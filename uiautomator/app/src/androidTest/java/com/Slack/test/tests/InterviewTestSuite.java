package com.Slack.test.tests;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
;
import com.Slack.test.screens.EmailScreen;
import com.Slack.test.screens.HomeScreen;
import com.Slack.test.screens.LandingScreen;
import com.Slack.test.screens.LoginScreen;
import com.Slack.test.screens.PasswordScreens;
import com.Slack.test.screens.SearchScreen;
import com.Slack.test.utils.AndroidUtils;
import com.Slack.test.utils.SlackUtils;
import com.Slack.test.watchers.SlackSuiteWatcher;
import com.Slack.test.watchers.SlackTestWatcher;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class InterviewTestSuite {

    private static final String TAG = "InterviewTestSuite";

    static final UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    private static LandingScreen launcherScreen = new LandingScreen();
    private static LoginScreen loginScreen = new LoginScreen();
    private static EmailScreen emailScreen = new EmailScreen();
    private static PasswordScreens passwordScreens = new PasswordScreens();
    private static HomeScreen homeScreen = new HomeScreen();
    private static SearchScreen searchScreen = new SearchScreen();

    @ClassRule
    public static TestRule suiteWatcher = new SlackSuiteWatcher();

    @Rule
    public TestRule testWatcher = new SlackTestWatcher();

    @BeforeClass
    public static void setUpSuite() {
        AndroidUtils.clearData();
        SlackUtils.launchApp();

        launcherScreen.pressSignIn();
        loginScreen.setTeamNameURL("automationteam-group");
        loginScreen.pressNext();
        emailScreen.setEmail("mjgroves182@gmail.com");
        emailScreen.pressNext();
        passwordScreens.pressTypePassword();

        // Should use credentials imported from a properties file or via script parameters
        passwordScreens.setPassword("slackinterview");
        passwordScreens.pressNext();

        assertTrue(homeScreen.isVisible());
    }

    @Before
    public void setUpTest() {
        // Placeholder for anything done before each test
    }

    @Test
    public void verifyStarMessageFilter() {
        // Create a unique message using UUIDs so we don't accidentally select a duplicate message
        String message = "Unique Message ID: " + UUID.randomUUID();

        homeScreen.pressOverlay();
        homeScreen.openSlackbotConversation();
        homeScreen.sendTextMessage(message);
        homeScreen.longPressTextMessage(message);
        homeScreen.pressMessageMenuItem("Star");
        homeScreen.pressSearchButton();
        searchScreen.setSearchText("has:star");
        searchScreen.pressSearch();

        assertTrue(searchScreen.hasMessage(message));

        // Since the mobile app doesn't have a star filter, the following is sample code
        // for the remaining task steps.

        // homeScreen.pressStarButton();
        // assertTrue(homeScreen.hasMessage(message));
    }

    @After
    public void tearDownTest() {
        // Placeholder for anything done after each test
    }

    @AfterClass
    public static void tearDownSuite() {
        // Placeholder for anything done after the entire suite runs
    }
}