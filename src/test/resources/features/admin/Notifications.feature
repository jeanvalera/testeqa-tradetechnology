Feature: Notifications

    Background:
    Given the user is logged into the admin module

    Scenario: Product with less than 6 units
    Given a product with 6 units in stock
    When the product stock is reduced to less than 6 units
    Then a notification is sent to the admin about the product's limited stock

    Scenario: Product expires in two days
    When a product expires in two days
    Then a notification is sent to the admin about the product expiration