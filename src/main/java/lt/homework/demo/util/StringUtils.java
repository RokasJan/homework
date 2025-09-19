package lt.homework.demo.util;

public class StringUtils {

    private StringUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Checks if a string is not null and not blank.
     *
     * @param value the string to check
     * @return true if the string is not null and not blank, false otherwise
     */
    public static boolean isNotNullOrBlank(String value) {
        return value != null && !value.isBlank();
    }

    /**
     * Checks if a string is null or blank.
     *
     * @param value the string to check
     * @return true if the string is null or blank, false otherwise
     */
    public static boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }
}