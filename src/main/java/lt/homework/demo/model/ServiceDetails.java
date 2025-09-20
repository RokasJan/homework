package lt.homework.demo.model;

import java.util.List;

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
    @XmlElement(name = "PlanType", required = true)
    private String planType;

    @XmlElement(name = "DataLimit")
    private String dataLimit;

    @XmlElement(name = "SpecialOffer")
    private String specialOffer;

    @XmlElement(name = "RoamingEnabled", required = true)
    private boolean roamingEnabled;

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