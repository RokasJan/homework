package lt.homework.demo.transformations;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lt.homework.demo.model.Order;

@Component
public class RoamingTransformation implements Transformation {

    private final List<String> nonRoamingCountries;

    // Constructor to initialize nonRoamingCountries from application properties separated by commas and converted to a List
    public RoamingTransformation(@Value("${transformations.countries.without.roaming}") String countries) {
        this.nonRoamingCountries = Arrays.stream(countries.split(","))
                                         .map(String::trim)
                                         .toList();
    }

    @Override
    public void apply(Order order) {
        if (nonRoamingCountries.contains(order.getCustomerDetails().getAddress().getCountry())) {
            order.getServiceDetails().setRoamingEnabled(null);
        }
    }
}
