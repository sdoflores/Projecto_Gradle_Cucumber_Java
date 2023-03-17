Feature: Try google search.

 @Test
 Scenario Outline: As a Test Engineer, I want to validate that a text is present inside the list.
      Given I am on the Google search page
      When I enter a search <criteria>
      And Click on the search button
      Then The results match the criteria
   Examples:
      | criteria |
      | google   |