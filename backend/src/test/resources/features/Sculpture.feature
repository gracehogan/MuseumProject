Feature: I want to be able to test the get mappings of different Sculpture Spring endpoints

  Scenario Outline: Get sculpture by id endpoint
    Given I have a get sculpture by id Spring endpoint
    When I call the get sculpture by <Id> endpoint
    Then I should get back the <Title>, <Year_Completed> and <Medium> of the sculpture

    Examples:
      | Title   | Year_Completed | Medium     | Id  |
      | "David" | 1504           | "Marble"   | 1   |