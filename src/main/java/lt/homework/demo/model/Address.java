package lt.homework.demo.model;

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
public class Address {
    
    @XmlElement(name = "Street")
    private String street;

    @XmlElement(name = "City")
    private String city;

    @XmlElement(name = "PostalCode")
    private String postalCode;

    @XmlElement(name = "Country")
    private String country;
}