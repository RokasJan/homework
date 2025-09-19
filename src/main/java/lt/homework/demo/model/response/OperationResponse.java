package lt.homework.demo.model.response;

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
@XmlRootElement(name = "OperationResponse", namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationResponse {

    @XmlElement(name = "Status", required = true)
    private String status;

    @XmlElement(name = "Message")
    private String message;
}