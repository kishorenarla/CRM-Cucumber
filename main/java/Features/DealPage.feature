Feature: CRM DealsPage test

  Scenario: Add Deals in DealsPage
    Given user is on the homepage
    When user mouse hover to DealsTab and clicks on New Deals link
    Then user will be on Add New Deals page
    And user enter the required details and clicks on save button on dealspage
      | Title       | Amount  | Company         |
      | FoamBoard   | 5000    | ShireDartford   |
      | Stationary  | 10000   | LogicaLondon    |
