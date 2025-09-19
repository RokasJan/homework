package lt.homework.demo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusType {
    SUCCESS ("Success"), FAILURE ("Failure");

    private final String status;
}