Feature: I want to be able to test the get mappings of different Artist Spring endpoints

  Scenario Outline: Get artist by id endpoint
    Given I have a get artist by id Spring endpoint
    When I call the get artist by <Id> endpoint
    Then I should get back the <Name>, <Year_Of_Birth> and <Year_Of_Death> of the artist

    Examples:
      | Name                   | Year_Of_Birth | Year_Of_Death | Id    |
      | "Leonardo Da Vinci"    | 1452          | 1519          | 1     |
      | "Johannes Vermeer"     | 1632          | 1675          | 2     |
      | "Jean-Léon Gérôme"     | 1810          | 1873          | 3     |
      | "Konstantin Flavitsky" | 1830          | 1880          | 4     |
      | "François Gérard"      | 1782          | 1823          | 5     |

  Scenario Outline: Get all artists endpoint
    Given I have a get all artists Spring endpoint
    When I call the get all artists endpoint
    Then I should get back a list of artists
    And each item should contain the <Name>, <Year_Of_Birth> and <Year_Of_Death> of the artist at a given <Index>

    Examples:
      | Name                   | Year_Of_Birth | Year_Of_Death | Index |
      | "Leonardo Da Vinci"    | 1452          | 1519          | 0     |
      | "Johannes Vermeer"     | 1632          | 1675          | 1     |
      | "Jean-Léon Gérôme"     | 1810          | 1873          | 2     |
      | "Konstantin Flavitsky" | 1830          | 1880          | 3     |
      | "François Gérard"      | 1782          | 1823          | 4     |