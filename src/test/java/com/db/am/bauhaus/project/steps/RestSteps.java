package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.steplib.RestUser;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class RestSteps {

    @Steps
    RestUser restUser;

    String keyword = "apple";

    @When("^john searching for \"([^\"]*)\"$")
    public void john_searching_for(String strName) throws Throwable {
        switch (strName.toLowerCase().trim().replace(" ", "")) {
            case "product":
                restUser.searchKeyword(keyword);
                break;
            case "shop":
                restUser.searchShop("apple");
                break;
            default:
                restUser.searchKeyword(keyword);
                break;
        }
    }

    @Then("^\"([^\"]*)\" result page returned$")
    public void result_page_returned(String strName) throws Throwable {
        assert restUser.getStatusCode() == 200;
        System.out.println(restUser.getPageText().toLowerCase());
        switch (strName.toLowerCase().trim().replace(" ", "")) {
            case "product":
                assert restUser.getPageText().toLowerCase().contains("all categories");
                break;
            case "shop":
                assert restUser.getPageText().toLowerCase().contains("shops found for");
                break;
            default:
                assert false;
        }
    }

}
