Feature: Log In

  Scenario: Login failure
    Given I am on the vodafone landing page
    When I click the My Vodafone link
    Then I should see the 'using MyVodafone' page
    When I click the Login button
    Then I should see the 'login Handler' page
    When I try to login with invalid credentials
    Then I should see the notice "Your email address is not registered for My Vodafone"

  Scenario: Login failure
    Given I am on the vodafone login page
    When I try to login with invalid credentials
    Then I should see the notice "Your email address is not registered for My Vodafone"
