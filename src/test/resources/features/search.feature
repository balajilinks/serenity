Feature: Search Feature

As a user
I would like to navigate to product page
Through various channels

  @ui @pageobject
  Scenario: Should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product from the input box
    Then the result should be displayed

  @ui @screenplay
  Scenario: Should be able to search for a product from the input box (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he searches for a product from the input box (screenplay)
    Then the result should be displayed (screenplay)

  @ui @pageobject
  Scenario: Should be able to search for a product from the drop-down menu
    Given John is viewing the Etsy landing page
    When he selects a category from drop down menu
    Then the category items should be displayed

  @ui @pageobject
  Scenario: Should be able to search for a product from the icons
    Given John is viewing the Etsy landing page
    When he selects a product from icons
    Then the product should be displayed

 @ui @pageobject
 Scenario: No broken links in the home page
    Given John is viewing the Etsy landing page
    Then all links are working fine
