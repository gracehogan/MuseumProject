Feature: I want to be able to test the get mappings of different Painting Spring endpoints

  Scenario Outline: Get painting by id endpoint
    Given I have a get painting by id Spring endpoint
    When I call the get painting by <Id> endpoint
    Then I should get back the <Title>, <Year_Completed> and <Artist_Name> of the painting

    Examples:
      | Title                           | Year_Completed | Artist_Name            | Id     |
      | "Shona Lisa"                    | 1519           |  "Leonardo Da Vinci"   | 1      |
      | "Grace With The Pearl Earring"  | 1665           |  "Johannes Vermeer"    | 2      |




  Scenario Outline: Get all paintings endpoint
    Given I have a get all paintings Spring endpoint
    When I call the get all paintings endpoint
    Then I should get back a list of paintings
    And each item should contain the <Title>, <Year_Completed> and <Artist_Name> of the paintings at a given <Index>

    Examples:
      | Title                           | Year_Completed | Artist_Name            | Index  |
      | "Shona Lisa"                    | 1519           |  "Leonardo Da Vinci"   | 0      |
      | "Grace With The Pearl Earring"  | 1665           |  "Johannes Vermeer"    | 1      |
