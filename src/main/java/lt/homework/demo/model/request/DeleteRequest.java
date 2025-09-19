package lt.homework.demo.model.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Delete", namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteRequest {

    @XmlElement(name = "ServiceId", required = true)
    private String serviceId;
}