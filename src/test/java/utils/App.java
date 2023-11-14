package utils;

public enum App {

    APIDEMO("com.touchboarder.android.api.demos",
            "com.touchboarder.androidapidemos.MainActivity"),

    CALCULATOR("",
            "")
    ;

    private String appPackage;
    private String appActivity;

    App(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }
}
