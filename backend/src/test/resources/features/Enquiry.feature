Feature:
  I want to be able to Enquiry integration test Spring endpoints

  Scenario Outline:
    Given I have a Rest Spring <Endpoint>
    When I send an enquiry calling  <name> <email> <enquiryType> <enquiryText>
    Then I should get the <name> <email> <enquiryType> <enquiryText> of the customer

    Examples:
      | Endpoint                            | name      | email              | enquiryType       | enquiryText              |
      | "http://localhost:8080/sendEnquiry" | "edward" | "edward@gmail.com" | "Ticket Enquiry" | "How much do they cost?" |


