package lt.homework.demo.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import lt.homework.demo.consts.Constants;
import lt.homework.demo.model.requests.CreateRequest;
import lt.homework.demo.model.requests.DeleteRequest;
import lt.homework.demo.model.requests.ReadRequest;
import lt.homework.demo.model.requests.UpdateRequest;
import lt.homework.demo.model.responses.ResultResponse;
import lt.homework.demo.service.OrderService;

@Endpoint
public class OrderManagerEndpoint {

    private final OrderService orderService;

    public OrderManagerEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "Create")
    @ResponsePayload
    public ResultResponse createService(@RequestPayload CreateRequest request) {
        return orderService.create(request);
    }

    @PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "Read")
    @ResponsePayload
    public ResultResponse readService(@RequestPayload ReadRequest request) {
        return orderService.read(request);
    }

    @PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "Update")
    @ResponsePayload
    public ResultResponse updateService(@RequestPayload UpdateRequest request) {
        return orderService.update(request);
    }

    @PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "Delete")
    @ResponsePayload
    public ResultResponse deleteService(@RequestPayload DeleteRequest request) {
        return orderService.delete(request);
    }
}