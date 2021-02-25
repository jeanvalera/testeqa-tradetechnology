Feature: Product search

    Background:
    Given the user is logged into the admin module

    Scenario: Find by name
    When the user searches products by name
    Then the product list shows products with this name

    Scenario: Find by type
    When the user searches products by type
    Then the product list shows products with this type

    Scenario: Find by status
    When the user searches products by status
    Then the product list shows products with this status
    
    Scenario: Find by stock level
    When the user searches products by stock level
    Then the product list shows products with this stock level