package lt.homework.demo.service;

import lt.homework.demo.model.requests.DeleteRequest;
import lt.homework.demo.model.requests.ReadRequest;
import lt.homework.demo.model.requests.ServiceRequest;
import lt.homework.demo.model.requests.UpdateRequest;
import lt.homework.demo.model.responses.ResultResponse;

public interface OrderService {
    ResultResponse create(ServiceRequest request);
    ResultResponse read(ReadRequest request);
    ResultResponse update(UpdateRequest request);
    ResultResponse delete(DeleteRequest request);
}