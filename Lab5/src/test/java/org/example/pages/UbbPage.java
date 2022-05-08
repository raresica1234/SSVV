package org.example.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://www.cs.ubbcluj.ro/")
public class UbbPage extends PageObject {

    @FindBy(name = "s")
    private WebElementFacade searchTerms;

    public void enter_keywords_and_search(String keyword) {
        searchTerms.typeAndEnter(keyword);
    }

    public List<String> getResults() {
        WebElementFacade resultList = find(By.id("content"));
//        List<WebElement> result = resultList.findElements(By.tagName("div"));
        return resultList.findElements(By.tagName("h2")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void goToEnglishPage() {
        WebElementFacade resultList = find(By.className("lang-item-en"));
        resultList.findElement(By.tagName("a")).click();
    }
}
