Feature:
  I want to be able to Enquiry integration test Spring endpoints

  Scenario Outline:
    Given I have a Rest Spring <Endpoint>
    When I call the <roomEndpoint> by name for rooms
    Then <Enquiry> is the result from the server

    Examples:
      |Endpoint|name|email|enquiryType|enquiryText|
      |"http://localhost:8080/sendEnquiry"|"/edward"|"edward@gmail.com"|"/Ticket Enquiry"|"How much do they cost?"|

#  /sendEnquiry/{name}/{email}/{enquiryType}/{enquiryText}