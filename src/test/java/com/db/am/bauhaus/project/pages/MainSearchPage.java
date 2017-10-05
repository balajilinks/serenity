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


    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }


    // Jewellery --> All Jewellery
    public void selectMenuItem(String strMenuName) {
        find(By.xpath("//span[contains(text(),'" + strMenuName + "')]")).click();
        find(org.openqa.selenium.By.partialLinkText("ALL")).click();
    }


    public String selectProductIcon() {
        String strDefinition = randomProduct.findBy("img").getAttribute("alt");
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
        return find(By.cssSelector("span[itemprop='name']")).getText();
    }

    public List getAllLinks() {
        List<WebElementFacade> elementList = new ArrayList();

        elementList = findAll(By.tagName("a"));
        // Add if required
//        elementList.addAll(findAll(By.tagName("img")));
        List<String> finalList = new ArrayList();

        for (WebElementFacade element : elementList) {
            if (element.getAttribute("href") != null) {
                System.out.println(element.getAttribute("href"));
                finalList.add(element.getAttribute("href"));
            }
        }
        return finalList;
    }


    public String getAllCategoriesHeader() {
        return find(By.cssSelector("h1.text-smaller.display-inline")).getText();
    }
}
