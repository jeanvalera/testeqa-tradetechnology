Feature: Delete product

    Scenario: Delete product
    Given the user is logged into the admin module
    And an existing product
    When the user deletes the product
    Then the product is deleted