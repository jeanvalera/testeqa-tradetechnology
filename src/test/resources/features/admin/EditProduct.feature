Feature: Edit product

    Scenario: Edit product
    Given the user is logged into the admin module
    And an existing product
    When the user modifies the product
    Then the product is updated with new data