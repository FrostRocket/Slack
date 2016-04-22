package com.Slack.test.screens;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

import com.Slack.test.model.Package;
import com.Slack.test.model.Timeout;

public class EmailScreen extends BaseScreen {

    private static final String TAG = "EmailScreen";

    public void setEmail(String email) {
        BySelector emailEditText = By.res(Package.SLACK, "email_edit_text");
        mDevice.wait(Until.hasObject(emailEditText), Timeout.OBJECT_EXISTS);
        mDevice.findObject(emailEditText).clear();
        mDevice.findObject(emailEditText).setText(email);
    }

    public void pressNext() {
        BySelector nextButton = By.res(Package.SLACK, "next_button");
        mDevice.wait(Until.hasObject(nextButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(nextButton).click();
    }
}