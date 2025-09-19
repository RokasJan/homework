package lt.homework.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import lt.homework.demo.model.enums.StatusType;
import lt.homework.demo.model.request.DeleteRequest;
import lt.homework.demo.model.request.ReadRequest;
import lt.homework.demo.model.request.ServiceRequest;
import lt.homework.demo.model.request.UpdateRequest;
import lt.homework.demo.model.response.OperationResponse;
import lt.homework.demo.model.response.ReadServiceResponse;
import lt.homework.demo.service.OrderService;
import lt.homework.demo.util.StringUtils;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {

    private final Map<String, ServiceRequest> database = new HashMap<>();

    @Override
    public OperationResponse create(ServiceRequest request) {
        log.info("create: {}", request);
        if (database.containsKey(request.getServiceId())) {
            log.info("ServiceId - {} already exists", request.getServiceId());
            return new OperationResponse(StatusType.FAILURE.getStatus(), "Given ServiceId already exists");
        }
        database.put(request.getServiceId(), request);
        log.info("New service added for user - {}", request.getCustomerId());
        return new OperationResponse(StatusType.SUCCESS.getStatus(), "Service created");
    }

    @Override
    public ReadServiceResponse read(ReadRequest request) {
        log.info("read: {}", request);
        if (database.isEmpty())
            return new ReadServiceResponse(StatusType.FAILURE.getStatus(), "Database currently is empty!", null);
        List<ServiceRequest> list = database.values().stream()
            .filter(db -> StringUtils.isNullOrBlank(request.getCustomerId()) || db.getCustomerId().equals(request.getCustomerId()))
            .filter(db -> StringUtils.isNullOrBlank(request.getServiceId()) || db.getServiceId().equals(request.getServiceId()))
            .toList();
        if (list.isEmpty())
            return new ReadServiceResponse(StatusType.FAILURE.getStatus(), "No matching records found!", null);
        return new ReadServiceResponse(StatusType.SUCCESS.getStatus(), list.size() + " record(s) found", list);
    }

    @Override
    public OperationResponse update(UpdateRequest request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OperationResponse delete(DeleteRequest request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}