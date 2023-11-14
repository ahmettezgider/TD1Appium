package utils;

public enum Device {

    SAMSUNG_A33("RZCT40MN7MY",
            "12",
            "Galaxy A33",
            "Android"),
    EMULATOR1("",
            "",
            "",
            "")
    ;



    private String udid;
    private String version;
    private String deviceName;
    private String platformName;

    Device(String udid, String version, String deviceName, String platformName) {
        this.udid = udid;
        this.version = version;
        this.deviceName = deviceName;
        this.platformName = platformName;
    }

    public String getUdid() {
        return udid;
    }

    public String getVersion() {
        return version;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getPlatformName() {
        return platformName;
    }
}
