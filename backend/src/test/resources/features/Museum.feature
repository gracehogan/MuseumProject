Feature: I want to be able to test the get mappings of different Museum Spring endpoints

  Scenario Outline: Get museum by id endpoint
    Given I have a get museum by id Spring endpoint
    When I call the get museum by <Id> endpoint
    Then I should get back the <Name>, <Location> and <Curator> of the museum

    Examples:
      | Name      | Location         | Curator             | Id    |
      | "PAGES"   | "Northampton"    | "Ani Desai"         | 1     |
      | "MUSE"    | "London"         | "Shona Fitzpatrick" | 2     |

  Scenario Outline: Get all museums endpoint
    Given I have a get all museums Spring endpoint
    When I call the get all museums endpoint
    Then I should get back a list of museums
    And each item should contain the <Name>, <Location> and <Curator> of the museum at a given <Index>

    Examples:
      | Name      | Location         | Curator             | Index   |
      | "PAGES"   | "Northampton"    | "Ani Desai"         | 0       |
      | "MUSE"    | "London"         | "Shona Fitzpatrick" | 1       |