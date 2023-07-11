package com.example.excercise4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement codeButton = $x("//*[@id=\"repo-content-pjax-container\"]/div/div/div[2]/div[1]/div[1]/span[1]/get-repo");
    public SelenideElement urlField = $x("//*[@id=\"local-panel\"]/ul/li[1]/tab-container/div[2]/div/input");
    public SelenideElement release = $x("//*[@id=\"repo-content-pjax-container\"]/div/div/div[2]/div[2]/div/div[2]/div/h2/a/span");

    public SelenideElement issuesButton = $(By.id("issues-tab"));
    public SelenideElement searchField = $(By.id("js-issues-search"));
    public SelenideElement labelSearchField = $(By.id("label-filter-field"));
    public SelenideElement label = $x("//*[@id=\"label-select-menu\"]/summary");
    public SelenideElement labels = $x("/html/body/div[1]/div[4]/div/main/turbo-frame/div/div/div[4]/div[2]/div/div[1]/div/div[2]/span");
    public SelenideElement comments = $x("/html/body/div[1]/div[4]/div/main/turbo-frame/div/div/div[4]/div[2]/div/div[1]/div/div[3]/span[3]/a");
//    public SelenideElement issueID = $x("/html/body/div[1]/div[4]/div/main/turbo-frame/div/div/div[4]/div[2]/div/div[1]/div/div[2]/div/span[1]");
     public SelenideElement issueID = $(By.cssSelector("#issue_12305 > div > div.flex-auto.min-width-0.p-2.pr-3.pr-md-2 > div > span.opened-by"));

    public SelenideElement author = $x("/html/body/div[1]/div[4]/div/main/turbo-frame/div/div/div[4]/div[2]/div/div[1]/div/div[2]/div/span[1]/a");
    public SelenideElement created = $x("/html/body/div[1]/div[4]/div/main/turbo-frame/div/div/div[4]/div[2]/div/div[1]/div/div[2]/div/span[1]/relative-time");
    public SelenideElement title = $(By.id("issue_12305_link"));

 }