package lt.homework.demo.transformations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lt.homework.demo.model.Order;

@Component
public class CustomerTransformation implements Transformation {

    @Value("${transformations.vip.customer}")
    private String vipCustomer;

    @Override
    public void apply(Order order) {
        if (order.getCustomerId().equals(vipCustomer))
            order.setVipCustomer(true);
    }
}
