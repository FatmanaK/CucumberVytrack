@vehicles
Feature: Vehicles
  As user I want to see list of all Vehicles

  Scenario: Login as a driver and navigate to the Vehicles
    Given user is on the landing page
    Then user logs in as a "driver"
    Then user navigates to "Fleet" and "Vehicles"
    And user verifies that "Cars" page name is displayed
    And user verifies that default page number is 1



#  vehicle, login, navigation
#
#  removed go to landing page step