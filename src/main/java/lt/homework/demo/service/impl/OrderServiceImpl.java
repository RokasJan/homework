package lt.homework.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import lt.homework.demo.mapper.RequestMapper;
import lt.homework.demo.model.requests.DeleteRequest;
import lt.homework.demo.model.requests.ReadRequest;
import lt.homework.demo.model.requests.ServiceRequest;
import lt.homework.demo.model.requests.UpdateRequest;
import lt.homework.demo.model.responses.ResultResponse;
import lt.homework.demo.service.OrderService;
import lt.homework.demo.util.StringUtils;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {

    private final Map<String, ServiceRequest> database = new HashMap<>();

    private final RequestMapper mapper;

    public OrderServiceImpl(RequestMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ResultResponse create(ServiceRequest request) {
        log.info("create: {}", request);
        if (database.containsKey(request.getServiceId())) {
            log.info("ServiceId - {} already exists", request.getServiceId());
            return ResultResponse.error(HttpStatus.BAD_REQUEST.value(), "Given ServiceId already exists");
        }
        database.put(request.getServiceId(), request);
        log.info("New service added for user - {}", request.getCustomerId());
        return ResultResponse.success("Service created");
    }

    @Override
    public ResultResponse read(ReadRequest request) {
        log.info("read: {}", request);
        if (database.isEmpty())
            return ResultResponse.error(HttpStatus.NOT_FOUND.value(), "Database currently is empty!");
        List<ServiceRequest> list = database.values().stream()
            .filter(db -> StringUtils.isNullOrBlank(request.getCustomerId()) || db.getCustomerId().equals(request.getCustomerId()))
            .filter(db -> StringUtils.isNullOrBlank(request.getServiceId()) || db.getServiceId().equals(request.getServiceId()))
            .toList();
        if (list.isEmpty())
            return ResultResponse.error(HttpStatus.NOT_FOUND.value(), "No matching records found!");
        return ResultResponse.read(list.size() + " record(s) found", list);
    }

    @Override
    public ResultResponse update(UpdateRequest request) {
        log.info("update: {}", request.getServiceId());
        ServiceRequest databaseEntry = database.get(request.getServiceId());
        if (databaseEntry == null)
            return ResultResponse.error(HttpStatus.NOT_FOUND.value(), "Given ServiceId does not exists");
        else {
            mapper.updateServiceRequestFromUpdate(request, databaseEntry);
            log.info("Service with ServiceId - {} updated", request.getServiceId());
            log.info("New entry: {}", databaseEntry);
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