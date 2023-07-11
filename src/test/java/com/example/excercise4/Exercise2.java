package com.example.excercise4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.ous.jtoml.ParseException;
import io.qameta.allure.selenide.AllureSelenide;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class Exercise2 {
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

        mainPage.issuesButton.click();
        mainPage.searchField.clear();
        mainPage.label.click();
        mainPage.labelSearchField.click();
        mainPage.labelSearchField.sendKeys("C-java");
        mainPage.labelSearchField.pressEnter();

        String title = mainPage.title.getText();
        System.out.println(title);
        JSONObject jsonPayload = new JSONObject();
        jsonPayload.put("title", title);

        String labels = mainPage.labels.getText();
        System.out.println(labels);
        jsonPayload.put("labels", labels);

        String comments = mainPage.comments.getText();
        System.out.println(comments);
        jsonPayload.put("number of comments", comments);

        String issueID = mainPage.issueID.getText();
        int indx;
        indx = issueID.indexOf(" "); //Isolate First Name from other text in field
        issueID = issueID.substring(0, indx).trim();
        System.out.println(issueID);
        jsonPayload.put("issueID", issueID);

        String author = mainPage.author.getText();
        System.out.println(author);
        jsonPayload.put("author", author);

        String created = mainPage.created.getText();
        System.out.println(created);
        jsonPayload.put("created date", created);

        try (FileWriter file = new FileWriter("most-discussed-java-issue.json")) {
            file.write(jsonPayload.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}