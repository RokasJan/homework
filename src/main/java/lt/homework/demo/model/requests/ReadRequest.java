package lt.homework.demo.model.requests;

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
@XmlRootElement(name = "Read", namespace = Constants.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class ReadRequest {

    @XmlElement(name = "ServiceId")
    private String serviceId;
    
    @XmlElement(name = "CustomerId")
    private String customerId;
}