Feature: Buy

    Scenario: Buy a product
    Given the user is logged into the store
    When the user selects a product and confirm the purchase
    Then the purchase is confirmed
    And the message "seu item já pode ser retirado juntamente ao R2D2" is shown
    And user's galactic credits are debited
