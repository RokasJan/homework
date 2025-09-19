package lt.homework.demo.model.response;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.homework.demo.model.request.ServiceRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ServiceResponse", namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReadServiceResponse {

    @XmlElement(name = "Status", required = true)
    private String status;

    @XmlElement(name = "Message")
    private String message;

    @XmlElement(name = "Service")
    private List<ServiceRequest> services;
}