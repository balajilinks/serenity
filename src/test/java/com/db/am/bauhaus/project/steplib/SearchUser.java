package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.MainSearchPage;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchUser extends ScenarioSteps {

    MainSearchPage mainSearchPage;

    String searchText = "craft";
    String searchSuggestion = "apple";
    String searchCategory = "Jewellery";
    String randomProduct = "";

    @Step
    public void search_from_input_box() {
        mainSearchPage.searchFromInputBox(searchText);
    }

    @Step
    public void search_from_input_box_suggestions() {
        searchText = mainSearchPage.searchFromInputBoxSuggestions(searchSuggestion);
    }

    @Step
    public void select_category() {
        searchCategory = mainSearchPage.selectCategory();
    }

    @Step
    public void select_product_icon() {
        randomProduct = mainSearchPage.selectProductIcon();
    }

    @Step
    public void verify_all_links() {
        List<String> finalList = mainSearchPage.getAllLinks();
        assert mainSearchPage.getAllLinks() != null;
        // Since it is production site, reduce the number of Hits
        List<String> sampleLinks = finalList.subList(1, 10);
        for (String item : sampleLinks) {
            System.out.println("Checking Link " + item);
            assert SerenityRest.when().get(item).then().extract().statusCode() == 200;
        }
    }


    @Step
    public void verify_product_name() {
        assertThat(mainSearchPage.getProductDesc().toLowerCase(), containsString(randomProduct.toLowerCase().substring(1, 20)));
    }

    @Step
    public void verify_result_for_top_categories() {
        assertThat(mainSearchPage.getTopCategoriesHeader(), containsString(searchText));
    }

    @Step
    public void verify_result_categories() {
        assertThat(mainSearchPage.getMenuHeader().toLowerCase(), containsString(searchCategory.toLowerCase()));
    }

    @Step
    public void verify_result_for_all_categories() {
        assertThat(mainSearchPage.getAllCategoriesHeader(), containsString(searchText));
    }
}
