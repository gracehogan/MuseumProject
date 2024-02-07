Feature: I want to be able to test the get mappings of different Artist Spring endpoints

  Scenario Outline: Get artist by id endpoint
    Given I have a get artist by id Spring endpoint
    When I call the get artist by <Id> endpoint
    Then I should get back the <Name>, <Year_Of_Birth> and <Year_Of_Death> of the artist

    Examples:
      | Name               | Year_Of_Birth | Year_Of_Death | Id    |
      | "Leonardo Da Vinci"| 1452          | 1519          | 1     |