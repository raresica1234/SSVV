package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.example.steps.serenity.UbbUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class CheckNavigationUbbTest {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;


    @ManagedPages(defaultUrl = "http://www.cs.ubbcluj.ro/")
    public Pages pages;

    @Steps
    public UbbUserSteps user;


    @Test
    public void checkNavigation() {
        user.is_the_home_page();
        user.goToEnglishPage();
        assertThat(webDriver.getCurrentUrl(), is("http://www.cs.ubbcluj.ro/en/"));
    }

    @Test
    public void checkNavigation2() {
        user.is_the_home_page();
        user.goToEnglishPage();
        assertThat(webDriver.getCurrentUrl(), is("http://www.cs.ubbcluj.ro/hu/"));
    }
}
