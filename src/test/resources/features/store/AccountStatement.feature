Feature: Account statement

    Scenario: Show account statement
    Given the user is logged into the store
    When the user goes to his account statement
    Then a list of the user's last purchases is shown
