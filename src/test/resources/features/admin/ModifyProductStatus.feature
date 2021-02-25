Feature: Modify product status

    Scenario: Activate product
    Given the user is logged into the admin module
    And an inactive product
    When the user activates the product
    Then the product is activated

    Scenario: Deactivate product
    Given the user is logged into the admin module
    And an active product
    When the user deactivates the product
    Then the product is deactivated