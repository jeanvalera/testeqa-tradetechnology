Feature: Employee consumption chart

    Scenario: Generate consumption chart
    Given the user is logged into the admin module
    When the user generates the consumption chart for an employee
    Then the chart is generated