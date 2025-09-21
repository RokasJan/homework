package lt.homework.demo.model;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceDetails {

    @NotNull(message = "Plan Type cannot be null")
    @NotBlank(message = "Plan Type cannot be blank")
    @XmlElement(name = "PlanType", required = true)
    private String planType;

    @XmlElement(name = "DataLimit")
    private String dataLimit;

    @XmlElement(name = "SpecialOffer")
    private String specialOffer;

    @NotNull(message = "Roaming Enabled cannot be null")
    @XmlElement(name = "RoamingEnabled", required = true)
    private Boolean roamingEnabled;

    @XmlElement(name = "AdditionalServices")
    private AdditionalServices additionalServices;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class AdditionalServices {
        @XmlElement(name = "Service")
        private List<String> service;
    }
}