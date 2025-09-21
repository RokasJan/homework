package lt.homework.demo.model;

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
public class CustomerDetails {
    
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @XmlElement(name = "Name", required = true)
    private String name;

    @XmlElement(name = "Address")
    private Address address;

    @NotNull(message = "Contact Number cannot be null")
    @NotBlank(message = "Contact Number cannot be blank")
    @XmlElement(name = "ContactNumber", required = true)
    private String contactNumber;
}
