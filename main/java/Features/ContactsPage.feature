Feature: CRM ContactPage test

  Scenario: Add Contacts in New Contacts
    Given user is on homepage
    When user mouse hover to contacts and clicks on New Contacts link
    Then user will be on Add New contacts page
    And user enter the required details and clicks on save button
      | Firstname | Surname | Company     |
      | Kishore   | Singham | ShireKing   |
      | Karan     | Kumar   | Logica      |
