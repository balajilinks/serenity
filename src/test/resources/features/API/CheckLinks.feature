@api
Feature: Links Feature

  As a TESTER
  I would like to navigate from product page links
  Through various channels

  @ui
  Scenario: No broken links in the home page
    Given John is viewing the Etsy landing page
    Then all links are working fine

  Scenario: Keyword search
    When john searching for "product"
    Then "product" result page returned

  Scenario: Shop Search
    When john searching for "shop"
    Then "Shop" result page returned