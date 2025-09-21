package lt.homework.demo.model.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Service ID cannot be null")
    @NotBlank(message = "Service ID cannot be blank")
    @XmlElement(name = "ServiceId", required = true)
    private String serviceId;

    @NotNull(message = "Service Type cannot be null")
    @NotBlank(message = "Service Type cannot be blank")
    @XmlElement(name = "ServiceType", required = true)
    private String serviceType;

    @NotNull(message = "Customer ID cannot be null")
    @NotBlank(message = "Customer ID cannot be blank")
    @XmlElement(name = "CustomerId", required = true)
    private String customerId;

    @NotNull(message = "Subscription ID cannot be null")
    @NotBlank(message = "Subscription ID cannot be blank")
    @XmlElement(name = "SubscriptionId", required = true)
    private String subscriptionId;

    @NotNull(message = "Service Details cannot be null")
    @XmlElement(name = "ServiceDetails", required = true)
    private ServiceDetails serviceDetails;

    @NotNull(message = "Customer Details cannot be null")
    @XmlElement(name = "CustomerDetails", required = true)
    private CustomerDetails customerDetails;

}
