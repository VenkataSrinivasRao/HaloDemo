Feature: Login into Para bank

  Scenario: Login into para bank with valid credentials
    Given user is on landing page
    When user enters username
    And user enters password
    And user clicks on login button
    Then user can see total balance
    
  	
  Scenario: User submitting details to customter care 
  	Given user is on landing page
  	When user clicks on contactus 
  	And user submits contact us form
  	  | Srinivas| srinivas@test.com| 9876543210| Need help regarding my login |
  	Then user can see Thanks message