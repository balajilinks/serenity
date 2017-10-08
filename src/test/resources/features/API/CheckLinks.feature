@api
Feature: Links Feature

As a TESTER
I would like to navigate from product page links
Through various channels

 @ui
 Scenario: No broken links in the home page
    Given John is viewing the Etsy landing page
    Then all links are working fine