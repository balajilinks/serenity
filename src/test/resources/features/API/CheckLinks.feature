Feature: Links Feature

As a user
I would like to navigate to product page
Through various channels

 @ui @pageobject @wip
 Scenario: No broken links in the home page
    Given John is viewing the Etsy landing page
    Then all links are working fine
