package lt.homework.demo.model.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.homework.demo.model.CustomerDetails;
import lt.homework.demo.model.ServiceDetails;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Update", namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateRequest {

    @XmlElement(name = "ServiceId", required = true) // still required to identify the record
    private String serviceId;

    @XmlElement(name = "ServiceType")
    private String serviceType;

    @XmlElement(name = "CustomerId")
    private String customerId;

    @XmlElement(name = "SubscriptionId")
    private String subscriptionId;

    @XmlElement(name = "ServiceDetails")
    private ServiceDetails serviceDetails;

    @XmlElement(name = "CustomerDetails")
    private CustomerDetails customerDetails;
}