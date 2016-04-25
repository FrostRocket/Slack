package com.Slack.test.screens;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

import com.Slack.test.model.Package;
import com.Slack.test.model.Timeout;

public class LandingScreen extends BaseScreen {

    private static final String TAG = "LandingScreen";

    public boolean isVisible() {
        BySelector titleTextView = By.res(Package.SLACK, "title_text");
        mDevice.wait(Until.hasObject(titleTextView), Timeout.OBJECT_EXISTS);

        return mDevice.findObject(titleTextView).getText().equals("Welcome to Slack");
    }

    public void pressSignIn() {
        BySelector signInButton = By.res(Package.SLACK, "sign_in_button");
        mDevice.wait(Until.hasObject(signInButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(signInButton).click();
    }

    public void pressCreateTeam() {
        BySelector createTeamButton = By.res(Package.SLACK, "create_team_button");
        mDevice.wait(Until.hasObject(createTeamButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(createTeamButton).click();
    }
}