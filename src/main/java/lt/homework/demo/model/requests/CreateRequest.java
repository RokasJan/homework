package lt.homework.demo.model.requests;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.homework.demo.consts.Constants;
import lt.homework.demo.model.CustomerDetails;
import lt.homework.demo.model.ServiceDetails;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Create", namespace = Constants.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateRequest {

    @XmlElement(name = "ServiceId", required = true)
    private String serviceId;

    @XmlElement(name = "ServiceType", required = true)
    private String serviceType;

    @XmlElement(name = "CustomerId", required = true)
    private String customerId;

    @XmlElement(name = "SubscriptionId", required = true)
    private String subscriptionId;

    @XmlElement(name = "ServiceDetails", required = true)
    private ServiceDetails serviceDetails;

    @XmlElement(name = "CustomerDetails", required = true)
    private CustomerDetails customerDetails;

}
