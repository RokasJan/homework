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

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Delete", namespace = Constants.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteRequest {

    @NotNull(message = "Service ID cannot be null")
    @NotBlank(message = "Service ID cannot be blank")
    @XmlElement(name = "ServiceId", required = true)
    private String serviceId;
}