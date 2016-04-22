package com.Slack.test.screens;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

import com.Slack.test.R;
import com.Slack.test.model.Package;
import com.Slack.test.model.Timeout;

public class PasswordScreens extends BaseScreen {

    private static final String TAG = "PasswordScreens";

    public void setPassword(String password) {
        BySelector passwordEditText = By.res(Package.SLACK, "password_edit_text");
        mDevice.wait(Until.hasObject(passwordEditText), Timeout.OBJECT_EXISTS);
        mDevice.findObject(passwordEditText).clear();
        mDevice.findObject(passwordEditText).setText(password);
    }

    public void pressTypePassword() {
        BySelector nextButton = By.res(Package.SLACK, "password_button");
        mDevice.wait(Until.hasObject(nextButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(nextButton).click();
    }

    public void pressMagicLink() {
        BySelector nextButton = By.res(Package.SLACK, "magic_link_button");
        mDevice.wait(Until.hasObject(nextButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(nextButton).click();
    }

    public void pressReset() {
        BySelector nextButton = By.res(Package.SLACK, "reset_password_button");
        mDevice.wait(Until.hasObject(nextButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(nextButton).click();
    }

    public void pressNext() {
        BySelector nextButton = By.res(Package.SLACK, "next_button");
        mDevice.wait(Until.hasObject(nextButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(nextButton).click();
    }
}