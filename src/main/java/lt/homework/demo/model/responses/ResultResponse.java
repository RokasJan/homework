package lt.homework.demo.model.responses;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.homework.demo.consts.Constants;
import lt.homework.demo.model.Order;
import lt.homework.demo.model.enums.StatusType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Response", namespace = Constants.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultResponse {
    
    // Success fields
    @XmlElement(name = "Status", namespace = Constants.NAMESPACE_URI)
    private String status;
    @XmlElement(name = "Message", namespace = Constants.NAMESPACE_URI)
    private String message;

    // Error fields
    @XmlElement(name = "ErrorCode", namespace = Constants.NAMESPACE_URI)
    private Integer errorCode;
    @XmlElement(name = "ErrorMessage", namespace = Constants.NAMESPACE_URI)
    private String errorMessage;
    @XmlElement(name = "Error", namespace = Constants.NAMESPACE_URI)
    private String error;

    // Read response
    @XmlElement(name = "Data", namespace = Constants.NAMESPACE_URI)
    private List<Order> services;

    // Static factory methods for convenience
    public static ResultResponse success(String message) {
        return new ResultResponse(StatusType.SUCCESS.getStatus(), message, null, null, null, null);
    }

    public static ResultResponse error(int code, String message) {
        return new ResultResponse(StatusType.FAILURE.getStatus(), null, code, message, null, null);
    }

    public static ResultResponse detailedError(int code, String message, String messageDetail) {
        return new ResultResponse(StatusType.FAILURE.getStatus(), null, code, message, messageDetail, null);
    }

    public static ResultResponse read(String message, List<Order> services) {
        return new ResultResponse(StatusType.SUCCESS.getStatus(), message, null, null, null, services);
    }
}