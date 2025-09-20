package lt.homework.demo.consts;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Constants class");
    }

    public static final String NAMESPACE_URI = "test";

    public static final String TRANSFORMATION_ERROR_MESSAGE = "InvalidContactNumber";

    public static final String PHONE_NUMBER_PATTERN_ERROR = "Given phone number is not valid. It should start with '+' sign and contain 11 to 15 digits";
    public static final String SERVICE_ID_EXISTS_ERROR = "Given ServiceId already exists";
}