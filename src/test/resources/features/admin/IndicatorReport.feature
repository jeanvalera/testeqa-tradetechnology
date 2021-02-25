Feature: Indicator report

    Scenario: Export report
    Given the user is logged into the admin module
    When the user exports the indicators report
    Then the report is exported