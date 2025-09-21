package lt.homework.demo.requests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import lt.homework.demo.config.InMemoryDabase;
import lt.homework.demo.model.CustomerDetails;
import lt.homework.demo.model.ServiceDetails;
import lt.homework.demo.model.enums.StatusType;
import lt.homework.demo.model.requests.CreateRequest;
import lt.homework.demo.model.responses.ResultResponse;
import lt.homework.demo.service.OrderService;

@Log4j2
@SpringBootTest
class CreateRequestTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private InMemoryDabase database;

    @Test
    void createServiceTest_whenRequestIsValid_addDataToDatabase() {
        ServiceDetails serviceDetails = new ServiceDetails("Tralala", null, null, true, null);
        CustomerDetails customerDetails = new CustomerDetails("My Name", null, "+37060000000");

        CreateRequest request = new CreateRequest(
                "SVC-001",
                "PREMIUM",
                "CUST-123",
                "SUB-456",
                serviceDetails,
                customerDetails
        );
        ResultResponse response = orderService.create(request);

        Assertions.assertTrue(response.getStatus().equals(StatusType.SUCCESS.getStatus()), "Status should be SUCCESS");
        Assertions.assertTrue(database.containsKey("SVC-001"), "Database should contain the new service ID");
    }

    @Test
    void createServiceTest_whenRequestIsInvalid_returnFailureStatus() {
        ServiceDetails serviceDetails = new ServiceDetails("Tralala", null, null, null, null);
        CustomerDetails customerDetails = new CustomerDetails("My Name", null, "+37060000000");

        CreateRequest request = new CreateRequest(
                "SVC-002",
                "PREMIUM",
                "CUST-123",
                "SUB-456",
                serviceDetails,
                customerDetails
        );
        ResultResponse response = orderService.create(request);

        Assertions.assertTrue(response.getStatus().equals(StatusType.FAILURE.getStatus()), "Status should be FAILURE");
        Assertions.assertFalse(database.containsKey("SVC-002"), "Database should not contain the invalid service ID");
    }
}
