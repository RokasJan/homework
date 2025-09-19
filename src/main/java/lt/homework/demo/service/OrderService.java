package lt.homework.demo.service;

import lt.homework.demo.model.request.DeleteRequest;
import lt.homework.demo.model.request.ReadRequest;
import lt.homework.demo.model.request.ServiceRequest;
import lt.homework.demo.model.request.UpdateRequest;
import lt.homework.demo.model.response.OperationResponse;
import lt.homework.demo.model.response.ReadServiceResponse;

public interface OrderService {
    OperationResponse create(ServiceRequest request);
    ReadServiceResponse read(ReadRequest request);
    OperationResponse update(UpdateRequest request);
    OperationResponse delete(DeleteRequest request);
}