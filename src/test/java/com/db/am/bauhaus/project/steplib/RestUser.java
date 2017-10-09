package com.db.am.bauhaus.project.steplib;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by ongshir on 05/10/2016.
 */
public class RestUser extends ScenarioSteps {

    String searchText = "craft";
    String searchSuggestion = "apple";
    String searchMenu = "Jewellery";
    String randomProduct = "";

    @Step
    public void searchKeyword(String keyword) {
        SerenityRest.given().when().get("http://www.etsy.com/uk/search?=" + keyword);
    }

    @Step
    public void searchShop(String shopName) {
        SerenityRest.given().when().get("https://www.etsy.com/search/shops?search_query=" + shopName);
    }

    @Step
    public int getStatusCode() {
        return SerenityRest.then().extract().statusCode();
    }

    @Step
    public String getPageText() {
        return SerenityRest.then().extract().body().asString();
    }

}
