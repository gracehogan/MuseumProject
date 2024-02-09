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

  Scenario Outline: Sort sculptures by title asc endpoint
    Given I have a sort sculptures by title asc Spring endpoint
    When I call the sort sculptures by title asc endpoint
    Then I should get back a list of sculptures sorted by title asc
    And each item should returned in ascending title order and contain the <Title>, <Year_Completed> and <Artist_Name> of the sculptures at a given <Index>

    Examples:
      | Title              | Year_Completed | Artist_Name                     | Index  |
      | "Apollo Belvedere" | 1526           |  "Giovanni Angelo Montorsoli"   | 0      |
      | "David"            | 1504           |  "Michelangelo"                 | 1      |

  Scenario Outline: Sort sculptures by title desc endpoint
    Given I have a sort sculptures by title desc Spring endpoint
    When I call the sort sculptures by title desc endpoint
    Then I should get back a list of sculptures sorted by title desc
    And each item should returned in descending title order and contain the <Title>, <Year_Completed> and <Artist_Name> of the sculptures at a given <Index>

    Examples:
      | Title                          | Year_Completed | Artist_Name                                  | Index  |
      | "Winged Victory of Samothrace" | 1222           |  "Pythocritos son of Timocharis of Rhodes"   | 0      |
      | "Venus de Milo"                | 1104           |  "Alexandros of Antioch"                     | 1      |


  Scenario Outline: Sort sculptures by year completed asc endpoint
    Given I have a sort sculptures by year completed asc Spring endpoint
    When I call the sort sculptures by year completed asc endpoint
    Then I should get back a list of sculptures sorted by year completed asc
    And each item should returned in ascending year completed order and contain the <Title>, <Year_Completed> and <Artist_Name> of the sculptures at a given <Index>

    Examples:
      | Title                                | Year_Completed | Artist_Name                                  | Index  |
      | "Venus de Milo"                      | 1104           |  "Alexandros of Antioch"                     | 0      |
      | "Winged Victory of Samothrace"       | 1222           |  "Pythocritos son of Timocharis of Rhodes"   | 1      |

    