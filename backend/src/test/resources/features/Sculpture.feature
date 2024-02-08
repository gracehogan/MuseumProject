Feature: I want to be able to test the get mappings of different Sculpture Spring endpoints

  Scenario Outline: Get sculpture by id endpoint
    Given I have a get sculpture by id Spring endpoint
    When I call the get sculpture by <Id> endpoint
    Then I should get back the <Title>, <Year_Completed> and <Medium> of the sculpture

    Examples:
      | Title         | Year_Completed | Medium     | Id     |
      | "David"       | 1504           | "Marble"   | 1      |
      | "The Thinker" | 1881           | "Bronze"   | 2      |


  Scenario Outline: Get all sculptures endpoint
    Given I have a get all sculptures Spring endpoint
    When I call the get all sculptures endpoint
    Then I should get back a list of sculptures
    And each item should contain the <Title>, <Year_Completed> and <Medium> of the sculptures at a given <Index>

    Examples:
      | Title         | Year_Completed | Medium     | Index  |
      | "David"       | 1504           | "Marble"   | 0      |
      | "The Thinker" | 1881           | "Bronze"   | 1      |