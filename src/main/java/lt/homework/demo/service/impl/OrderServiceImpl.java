package lt.homework.demo.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import lt.homework.demo.config.InMemoryDabase;
import lt.homework.demo.consts.Constants;
import lt.homework.demo.exceptions.ValidationException;
import lt.homework.demo.mapper.RequestMapper;
import lt.homework.demo.model.Order;
import lt.homework.demo.model.requests.CreateRequest;
import lt.homework.demo.model.requests.DeleteRequest;
import lt.homework.demo.model.requests.ReadRequest;
import lt.homework.demo.model.requests.UpdateRequest;
import lt.homework.demo.model.responses.ResultResponse;
import lt.homework.demo.service.OrderService;
import lt.homework.demo.transformations.RoamingTransformation;
import lt.homework.demo.transformations.SpecialOfferTransformation;
import lt.homework.demo.transformations.Transformation;
import lt.homework.demo.util.StringUtils;
import lt.homework.demo.validator.CreateRequestValidator;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {

    private final InMemoryDabase database;
    private final RequestMapper mapper;
    private final List<Transformation> transformations;
    private final CreateRequestValidator validator;
    private static final Set<Class<?>> updateTransformations = Set.of(RoamingTransformation.class, SpecialOfferTransformation.class);

    public OrderServiceImpl(InMemoryDabase database, RequestMapper mapper,
            List<Transformation> transformations, CreateRequestValidator validator) {
        this.database = database;
        this.mapper = mapper;
        this.transformations = transformations;
        this.validator = validator;
    }

    @Override
    public ResultResponse create(CreateRequest request) {
        log.debug("create: {}", request);
        log.info("Creating new service for user - {}", request.getCustomerId());
        try {
            validator.validate(request);
            Order newOrder = new Order(request);
            transformations.forEach(t -> t.apply(newOrder));
            database.put(request.getServiceId(), newOrder);
            log.info("New service added for user - {}", request.getCustomerId());
            return ResultResponse.success("Service created");
        } catch (ValidationException e) {
            log.error("Error during creating new service for user - {}", request.getCustomerId(), e.getMessage());
            if (e.getMessage().equals(Constants.PHONE_NUMBER_PATTERN_ERROR)) {
                return ResultResponse.detailedError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                        Constants.TRANSFORMATION_ERROR_MESSAGE);
            } else {
                return ResultResponse.error(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            }
        }
    }

    @Override
    public ResultResponse read(ReadRequest request) {
        log.info("read: {}", request);
        if (database.isEmpty()) {
            return ResultResponse.error(HttpStatus.NOT_FOUND.value(), "Database currently is empty!");
        }
        List<Order> list = database.streamValues()
                .filter(db -> StringUtils.isNullOrBlank(request.getCustomerId()) || db.getCustomerId().equals(request.getCustomerId()))
                .filter(db -> StringUtils.isNullOrBlank(request.getServiceId()) || db.getServiceId().equals(request.getServiceId()))
                .toList();
        if (list.isEmpty()) {
            return ResultResponse.error(HttpStatus.NOT_FOUND.value(), "No matching records found!");
        }
        return ResultResponse.read(list.size() + " record(s) found", list);
    }

    @Override
    public ResultResponse update(UpdateRequest request) {
        log.info("update: {}", request.getServiceId());
        Order databaseEntry = database.get(request.getServiceId());
        if (databaseEntry == null) {
            return ResultResponse.error(HttpStatus.NOT_FOUND.value(), "Given ServiceId does not exists");
        } else {
            mapper.updateServiceRequestFromUpdate(request, databaseEntry);
            transformations.stream()
                    .filter(t -> updateTransformations.contains(t.getClass()))
                    .forEach(t -> t.apply(databaseEntry));
            log.info("Service with ServiceId - {} updated", request.getServiceId());
            log.debug("New entry: {}", databaseEntry);
            return ResultResponse.success("Service updated");
        }
    }

    @Override
    public ResultResponse delete(DeleteRequest request) {
        log.info("delete: {}", request.getServiceId());
        if (database.containsKey(request.getServiceId())) {
            database.remove(request.getServiceId());
            log.info("Service with ServiceId - {} deleted", request.getServiceId());
            return ResultResponse.success("Service deleted");
        }
        return ResultResponse.error(HttpStatus.NOT_FOUND.value(), "Given ServiceId does not exists");
    }
}
