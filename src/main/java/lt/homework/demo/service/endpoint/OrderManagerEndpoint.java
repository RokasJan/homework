package lt.homework.demo.service.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import lt.homework.demo.model.request.DeleteRequest;
import lt.homework.demo.model.request.ReadRequest;
import lt.homework.demo.model.request.ServiceRequest;
import lt.homework.demo.model.request.UpdateRequest;
import lt.homework.demo.model.response.OperationResponse;
import lt.homework.demo.model.response.ReadServiceResponse;
import lt.homework.demo.service.OrderService;

@Endpoint
public class OrderManagerEndpoint {

    private static final String NAMESPACE_URI = "test";

    private final OrderService orderService;

    public OrderManagerEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Create")
    @ResponsePayload
    public OperationResponse createService(@RequestPayload ServiceRequest request) {
        return orderService.create(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Read")
    @ResponsePayload
    public ReadServiceResponse readService(@RequestPayload ReadRequest request) {
        return orderService.read(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Update")
    @ResponsePayload
    public OperationResponse updateService(@RequestPayload UpdateRequest request) {
        return orderService.update(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Delete")
    @ResponsePayload
    public OperationResponse deleteService(@RequestPayload DeleteRequest request) {
        return orderService.delete(request);
    }
}