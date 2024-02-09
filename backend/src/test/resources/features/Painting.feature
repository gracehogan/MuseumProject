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


  Scenario Outline: Sort paintings by title asc endpoint
    Given I have a sort paintings by title asc Spring endpoint
    When I call the sort paintings by title asc endpoint
    Then I should get back a list of paintings sorted by title asc
    And each item should returned in ascending title order and contain the <Title>, <Year_Completed> and <Artist_Name> of the paintings at a given <Index>

    Examples:
      | Title               | Year_Completed | Artist_Name           | Index  |
      | "Cleopani"          | 1866           |  "Jean-Léon Gérôme"   | 0      |
      | "Eddy The Emperor"  | 1805           |  "François Gérard"    | 1      |

  Scenario Outline: Sort paintings by title desc endpoint
    Given I have a sort paintings by title desc Spring endpoint
    When I call the sort paintings by title desc endpoint
    Then I should get back a list of paintings sorted by title desc
    And each item should returned in descending title order and contain the <Title>, <Year_Completed> and <Artist_Name> of the paintings at a given <Index>

    Examples:
      | Title               | Year_Completed | Artist_Name                 | Index  |
      | "Whistler's Mother" | 1871           |  "James McNeill Whistler"   | 0      |
      | "Water Lilies"      | 1916           |  "Claude Monet"             | 1      |


  Scenario Outline: Sort paintings by year completed asc endpoint
    Given I have a sort paintings by year completed asc Spring endpoint
    When I call the sort paintings by year completed asc endpoint
    Then I should get back a list of paintings sorted by year completed asc
    And each item should returned in ascending year completed order and contain the <Title>, <Year_Completed> and <Artist_Name> of the paintings at a given <Index>

    Examples:
      | Title               | Year_Completed | Artist_Name            | Index  |
      | "The Birth of Venus"| 1486           |  "Sandro Botticelli"   | 0      |
      | "Shona Lisa"        | 1519           |  "Leonardo Da Vinci"   | 1      |


  Scenario Outline: Sort paintings by year completed desc endpoint
    Given I have a sort paintings by year completed desc Spring endpoint
    When I call the sort paintings by year completed desc endpoint
    Then I should get back a list of paintings sorted by year completed desc
    And each item should returned in descending year completed order and contain the <Title>, <Year_Completed> and <Artist_Name> of the paintings at a given <Index>

    Examples:
      | Title                      | Year_Completed | Artist_Name        | Index  |
      | "The Persistence of Memory"| 1931           |  "Salvador Dali"   | 0      |
      | "Water Lilies"             | 1916           |  "Claude Monet"    | 1      |
