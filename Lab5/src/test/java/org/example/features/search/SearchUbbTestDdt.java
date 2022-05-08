package org.example.features.search;

import io.cucumber.java.it.Ma;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.pages.UbbPage;
import org.example.steps.serenity.UbbUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/UbbTestData.csv")
public class SearchUbbTestDdt {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;


    @ManagedPages(defaultUrl = "http://www.cs.ubbcluj.ro/")
    public Pages pages;

    public String keyword;
    public String result;

    @Qualifier
    public String getQualifier() {
        return keyword;
    }

    @Steps
    public UbbUserSteps user;


    @Test
    public void searchKeywordDDT() {
        user.is_the_home_page();
        System.out.println(webDriver.getCurrentUrl());
        user.enterAndSearch(getKeyword());
        user.should_see_title(getResult());
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
