Feature: UL Services Form Submission

  Scenario Outline: Submit UL Services gform using Excel data
    Given user navigates to UL Services section
    When user scrolls to UL Services using JavaScript
    And switches to iframe and gets src URL
    And fetch data from excel sheet "<SheetName>" and row <RowNum>
    And enters user details into the form
    And submit the form
    Then verify the form submission and take appropriate screenshot

    Examples: 
      | SheetName | RowNum |
      | UserData  |      1 |
      | UserData  |      2 |
      | UserData  |      3 |
      | UserData  |      4 |
      | UserData  |      5 |
      | UserData  |      6 |
