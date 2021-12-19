Feature: Forms Search

  @forms
  Scenario: Enter details on a form using different components
    Given user navigate to the website "Forms"
    Given user enters "Vijay" as firstname
    Given user enters "Chavda" as surname
    Given user selects "Male" from "gender" dropdown
    Given user selects "Red" from colour radio
    Given user selects "Email" from contact checkbox
    Given user enters "This is some text" as textarea
    Given user selects "Europe" from "continent" dropdown
    Given user selects "Europe" from continent dropdown

