package lt.homework.demo.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lt.homework.demo.config.InMemoryDabase;
import lt.homework.demo.consts.Constants;
import lt.homework.demo.exceptions.ValidationException;
import lt.homework.demo.model.requests.CreateRequest;

@Component
public class CreateRequestValidator {
    
    private final InMemoryDabase database;

    @Value("${validation.phone.pattern}")
    private String phoneNumberPattern;

    public CreateRequestValidator(InMemoryDabase database) {
        this.database = database;
    }

    public void validate(CreateRequest request) {
        if (database.containsKey(request.getServiceId()))
            throw new ValidationException(Constants.SERVICE_ID_EXISTS_ERROR);
        if (!request.getCustomerDetails().getContactNumber().matches(phoneNumberPattern))
            throw new ValidationException(Constants.PHONE_NUMBER_PATTERN_ERROR);
    }
}
