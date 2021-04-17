package factory;

public enum DriverType {
    CHROME("CHROME"),
    EDGE("EDGE");

    private final String type;

    DriverType(String type) {
        this.type = type;
    }

    public static DriverType fromValue(String value) {
        return DriverType.valueOf(value);
    }
}
