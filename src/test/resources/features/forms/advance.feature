Feature: Forms Search

  Background:
    Given user navigate to the website "advance"


  @table
  Scenario: Advanced form search
    Given user clicks on menu item "dynamictablestest"
    Given user verifies data in table "dynamictable"
      | name   | age |
      | Bob    | 20  |
      | George | 42  |

  @frame
  Scenario: Advanced form search
    Given user clicks on menu item "iframestest"
    Given user switches frames to "theheaderhtml" and clicks on the H1 item "Nested Page"
    Given user switches frames to "thedynamichtml" and clicks on the H1 item "iFrame"
    Given user switches frames to "thedynamichtml" and clicks on the Li item "iframe0" and selects "iFrame List Item 0"

