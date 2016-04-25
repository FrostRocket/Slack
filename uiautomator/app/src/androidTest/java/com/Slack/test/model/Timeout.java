package com.Slack.test.model;

public class Timeout {
    // This is only the max timeout value, tests will continue running
    // as soon as the object is found.
    public static final int OBJECT_EXISTS = 20000;

    public static final int X_SHORT = 1000;
    public static final int SHORT = 3000;
    public static final int MEDIUM = 5000;
    public static final int LONG = 10000;
    public static final int X_LONG = 30000;

    public static final int HTTP = 15000;
}
