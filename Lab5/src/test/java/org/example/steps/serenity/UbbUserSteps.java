package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.UbbPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class UbbUserSteps {

    UbbPage ubbPage;

    @Step
    public void enterAndSearch(String keyword) {
        ubbPage.enter_keywords_and_search(keyword);
    }

    @Step
    public void should_see_title(String title) {
        assertThat(ubbPage.getResults(), hasItem(containsString(title)));
    }

    @Step
    public void is_the_home_page() {
        ubbPage.open();
    }

    @Step
    public void goToEnglishPage() {
        ubbPage.goToEnglishPage();
    }
}
