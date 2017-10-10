package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("https://www.etsy.com/")
public class MainSearchPage extends PageObject {

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = "button[value='Search']")
    WebElementFacade searchButton;

    @FindBy(css = "div.placeholder-content")
    WebElementFacade randomProduct;

    @FindBy(css = "div.as-suggestion.new-web-ui")
    WebElementFacade searchSuggestions;

    @FindBy(css = "div.card-meta-row > span.vesta-hp-category-title.vesta-hp-curated-category")
    WebElementFacade categoryMenu;

    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    public String searchFromInputBoxSuggestions(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        String suggestion = searchSuggestions.waitUntilPresent().getText();
        searchSuggestions.click();
        return suggestion;
    }

    public String selectCategory() {
        String categoryName;
        try{
            categoryName = categoryMenu.getText();
            categoryMenu.click();
        }catch (Exception e){
            getDriver().navigate().to(getDriver().getCurrentUrl()+"c/home-and-living");
            categoryName = "Home";
        }

        return categoryName;
    }

    public String selectProductIcon() {
        String strDefinition = randomProduct.waitUntilVisible().findBy("img").getAttribute("alt");
        randomProduct.click();
        return strDefinition;
    }

    public String getTopCategoriesHeader() {
        return find(By.cssSelector("div.pb-xs-1-5")).getText();
    }

    public String getMenuHeader() {
        return find(By.cssSelector("h1")).getText();
    }

    public String getProductDesc() {
        if (find(By.cssSelector("span[itemprop='name']")).isPresent()) {
            return find(By.cssSelector("span[itemprop='name']")).getText();
        }
        return find(By.cssSelector("h2.text-gray-darker")).waitUntilPresent().getText();
    }

    public List getAllLinks() {
        List<WebElementFacade> elementList = new ArrayList();
        elementList = findAll(By.tagName("a"));
//        elementList.addAll(findAll(By.tagName("img")));
        List<String> finalList = new ArrayList();
        for (WebElementFacade element : elementList) {
            if (element.getAttribute("href") != null) {
                finalList.add(element.getAttribute("href"));
            }
        }
        return finalList;
    }


    public String getAllCategoriesHeader() {
        return find(By.cssSelector("h1.text-smaller.display-inline")).getText();
    }
}
