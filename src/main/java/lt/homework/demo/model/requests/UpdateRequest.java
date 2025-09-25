package lt.homework.demo.model.requests;

import jakarta.validation.Valid;
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
@XmlRootElement(name = "Update", namespace = Constants.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateRequest {

    @NotNull(message = "Service ID cannot be null")
    @NotBlank(message = "Service ID cannot be blank")
    @XmlElement(name = "ServiceId", required = true)
    private String serviceId;

    @XmlElement(name = "ServiceDetails")
    @Valid
    private ServiceDetails serviceDetails;

    @XmlElement(name = "CustomerDetails")
    @Valid
    private CustomerDetails customerDetails;
}
