package lt.homework.demo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlanType {
    MOBILE_2G("2G"), MOBILE_3G("3G"), MOBILE_4G("4G"), MOBILE_5G("5G"), FIBER("FIBER"), TV("TV"), LANDLINE("LANDLINE");

    private final String type;
}
