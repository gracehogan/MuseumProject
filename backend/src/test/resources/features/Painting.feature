Feature: I want to be able to test the get mappings of different Painting Spring endpoints

  Scenario Outline: Get painting by id endpoint
    Given I have a get painting by id Spring endpoint
    When I call the get painting by <Id> endpoint
    Then I should get back the <Title>, <Year_Completed> and <Artist_Name> of the painting

    Examples:
      | Title        | Year_Completed | Artist_Name            | Id  |
      | "Shona Lisa" | 1519           |  "Leonardo Da Vinci"   | 1   |