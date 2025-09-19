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
public class CustomerDetails {
    
    @XmlElement(name = "Name", required = true)
    private String name;

    @XmlElement(name = "Address")
    private Address address;

    @XmlElement(name = "ContactNumber", required = true)
    private String contactNumber;
}
