Feature:
  I want to test the Booking

  Scenario Outline:
#    Given I have a Rest Spring Endpoint
    Given the following museum are available to book
      | Museums | Flat fee |
      | MUSE    | 100      |
      | PAGES   | 200      |

    Given the following ticket types are available
      | Ticket type  | Discount Rate |
      | SINGLE_ADULT | 1             |
      | SINGLE_CHILD | 0.7           |
      | GROUP_ADULT  | 0.8           |
      | GROUP_CHILD  | 0.5           |

    Given I am a registered user with a booking
      | Name   | Email            | Slot            |
      | Edward | edward@gmail.com | 7th Sept 24 8pm |

    When <Name> books a visit to  <Museums> with <Ticket type> for <Persons>
    Then the total fee for is <Amount>
    Examples:
      | Name     | Museums |  Ticket type    | Persons | Amount |
      | "Edward" | "PAGES" | "SINGLE_ADULT" | "4"     | 400.0  |


#  /estimateFee/eddy/4/SINGLE_ADULT/abc@gmail.com/PAGES/7th Sept 24 8pm