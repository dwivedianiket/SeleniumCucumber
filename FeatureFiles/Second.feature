#Feature: Retrieving list of living sub menu
Feature: Living

  Scenario: Retrieving the Living sub menu items
    Given On the Living page
    When choose a sub-menu item from Seating & Chairs or Living Storage
    Then retrieve all items under the chosen sub-menu
    And print the retrieved items in the console
