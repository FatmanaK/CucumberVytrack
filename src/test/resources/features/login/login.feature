@VYT-4121
Feature: Login
  As a user I want to login under different roles

  Background:
    Given user is on the landing page

  @storemanager
  Scenario: Login as store manager
    Then user logs in as a store manager
    And user verifies that "Dashboard" page name is displayed


  @negative
  Scenario: Verify warning message for invalid credentials
    Then user logs in with "wrong" username and "wrong" password
    And user verifies that "Invalid user name or password." warning message is displayed


  @driver
  Scenario: Login as a driver
    Then user logs in as a driver
    And user verifies that "Quick Launchpad" page name is displayed

  Scenario:


#    Then user navigates to the "Activities" tab and "Calendar Events"






















#If i put this tag on top before Feature: it will run everything in this file
#@login
#Feature: As a user I want to login under different roles

#  If there are multiple same steps that is repeating, we can take that step and put it here as a background
#  and every time, every scenario will run with this step
#  Background:
#    Given Open Vytrack login page



#  if I put this tag only on top of one Scenario: it will run only this Scenario:
#  and the others will be skipped
#  this @login tag can be any meaningful name, and it should be also in CukesRunner class
#  @login
#  Scenario: Login test (negative)

#    When Enter valid username and invalid password credentials
#    And Click login button
#    Then Message Invalid user name or password. should be displayed
#    And Page title and url should be the same

#    if we have multiple different tags we can chose which one to run,
#  by providing tag name in CukesRunner class
#  @driver
#  Scenario: Login as a Driver (positive)

#    When Enter valid driver user name and valid password credentials
#    And Click login button
#    Then Homepage should be displayed
#    And Verify page title

#  @storemanager
#  Scenario: Login as a Store manager
#
#    When Enter valid username and invalid password credentials
#    And Click login button
#    Then Homepage should be displayed
#    And Verify page title













