Feature: Add product

    Scenario: Add new product
    Given the user is logged into the admin module
    When the user adds a new product
    Then the new product is added to the product list