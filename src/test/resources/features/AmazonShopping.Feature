Feature: To Validate Amazon Shopping Feature

  Scenario Outline: To Validate Amazon shopping
    Given an Amazon application <platform>
    When user login to shopping application
    Then shopping application page should be displayed
    When user select electronic category item
    Then selected item should be added to cart
    When user select book category item
    Then selected item should be added to cart
    When user select item from Deals of day
    Then selected item should be added to cart
    When user add new delivery address to shipping
    Then new address should be displayed
    Examples:
    |platform|
    |iOS     |



