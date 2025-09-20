package lt.homework.demo.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.homework.demo.consts.Constants;
import lt.homework.demo.model.requests.CreateRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Service", namespace = Constants.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
    
    @XmlElement(name = "ServiceId")
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

    @XmlElement(name = "VIPCustomer")
    private Boolean vipCustomer;

    @XmlElement(name = "SpecialOffer")
    private String specialOffer;

    // Constructor to create Order from CreateRequest
    public Order(CreateRequest request) {
        this.serviceId = request.getServiceId();
        this.serviceType = request.getServiceType();
        this.customerId = request.getCustomerId();
        this.subscriptionId = request.getSubscriptionId();
        this.serviceDetails = request.getServiceDetails();
        this.customerDetails = request.getCustomerDetails();
    }
}