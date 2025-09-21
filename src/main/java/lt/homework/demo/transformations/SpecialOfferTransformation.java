package lt.homework.demo.transformations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lt.homework.demo.model.Order;
import lt.homework.demo.model.enums.PlanType;

@Component
public class SpecialOfferTransformation implements Transformation {
    
    @Value("${transformations.special.offer}")
    private String offer;

    @Override
    public void apply(Order order) {
        if (order.getServiceDetails().getPlanType().equals(PlanType.MOBILE_5G.getType()) 
            && order.getServiceDetails().getDataLimit() == null) {
                order.setSpecialOffer(offer);
        } else if (order.getSpecialOffer() != null && (!order.getServiceDetails().getPlanType().equals(PlanType.MOBILE_5G.getType()) 
            || order.getServiceDetails().getDataLimit() != null)) {
            order.setSpecialOffer(null);
        }
    }
}
