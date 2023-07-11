package com.example.excercise4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import java.io.FileWriter;
import java.io.IOException;

import io.ous.jtoml.ParseException;
import org.json.simple.JSONObject;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class Exercise1 {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://github.com/SeleniumHQ/selenium");
    }

    @Test
    @SuppressWarnings("unchecked")
    public void main() throws InterruptedException, ParseException {
        Thread.sleep(1500);

        mainPage.codeButton.shouldBe(Condition.visible);
        mainPage.codeButton.click();

        Thread.sleep(1500);
        String urlText = mainPage.urlField.getValue();
        System.out.println(urlText);

        JSONObject jsonPayload = new JSONObject();
        jsonPayload.put("url", urlText);

        String releaseNo = mainPage.release.getText();
        System.out.println(releaseNo);

        jsonPayload.put("releases", releaseNo);

        try (FileWriter file = new FileWriter("selenium-meta-data.json")) {
            file.write(jsonPayload.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}