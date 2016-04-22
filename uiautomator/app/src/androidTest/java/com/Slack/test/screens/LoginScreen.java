package com.Slack.test.screens;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

import com.Slack.test.model.Package;
import com.Slack.test.model.Timeout;

public class LoginScreen extends BaseScreen {

    private static final String TAG = "LoginScreen";

    public void setTeamNameURL(String team) {
        BySelector urlEditText = By.res(Package.SLACK, "team_url_edit_text");
        mDevice.wait(Until.hasObject(urlEditText), Timeout.OBJECT_EXISTS);
        mDevice.findObject(urlEditText).clear();
        mDevice.findObject(urlEditText).setText(team);
    }

    public void pressSendReminder(String password) {
        BySelector sendReminderButton = By.res(Package.SLACK, "reminder_button");
        mDevice.wait(Until.hasObject(sendReminderButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(sendReminderButton).click();
    }

    public void pressNext() {
        BySelector nextButton = By.res(Package.SLACK, "next_button");
        mDevice.wait(Until.hasObject(nextButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(nextButton).click();
    }
}