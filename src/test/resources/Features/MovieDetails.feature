Feature: Movie Details

  Scenario: Verify UI elements on Movie Details page
    Given User is on log in page
    When User clicks on a movie
    Then Movie details page should display correct UI elements
  Scenario: Test UI elements on Movie Details Page from Popular Page
    Given User is on the Popular Page
    When User clicks on any Movie
    Then Popular Movie details page should display correct UI elements