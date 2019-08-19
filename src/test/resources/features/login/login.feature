@VYT-4121
Feature: Login
  As a user I want to login under different roles

#  Background:
#    Given user is on the landing page  # we don't need this step any more because I put in Hooks class in @Before to go to that page

  @storemanager
  Scenario: Login as store manager
    Then user logs in as a store manager
    And user verifies that "Dashboard" page name is displayed


  @negative
  Scenario: Verify warning message for invalid credentials
    Then user logs in with "wrong" username and "wrong" password
    And user verifies that "Invalid user name or password.." warning message is displayed


  @driver
  Scenario: Login as a driver
    Then user logs in as a driver
    And user verifies that "Quick Launchpad" page name is displayed


    # if it is a Map we cannot use more than two columns
  @map_example
  Scenario: Login as different users
    Given user logs in with following credentials
      | username | salesmanager101 |
      | password | UserUser123     |
    Then user navigates to "Fleet" and "Vehicles"
    And user verifies that "All Cars" page name is displayed

#    Then user navigates to the "Activities" tab and "Calendar Events"


  @login_1
  Scenario Outline: login as different user tests
    Given user logs in as a "<user_type>"
    And user verifies that "<page name>" page name is displayed
    Examples:
      | user_type     | page name       |
      | driver        | Quick Launchpad |
      | sales manager | Dashboard       |
      | store manager | Dashboard       |


  @login_with_outline_2
  Scenario Outline: User names test
    Given user logs in with following credentials
      | username | <username> |
      | password | <password> |
    Then user name should be "<name>"
    Examples: Credentials information
      | username        | password    | name             |
      | user187         | UserUser123 | Jerel Vandervort |
      | user200         | UserUser123 | Lonzo Leuschke   |
      | storemanager52  | UserUser123 | Roma Medhurst    |
      | storemanager66  | UserUser123 | Carlos Ernser    |
      | salesmanager125 | UserUser123 | Cleveland Heller |
      | salesmanager140 | UserUser123 | Jameson Paucek   |


  @login_with_outline_3
  Scenario Outline: page titles with different users
    Given user logs in as a "<user_type>"
    Then user navigates to "<tab>" and "<module>"
    Then the page title should be "<title>"
    Examples: User and navigation info
      | user_type     | tab        | module          | title                                                              |
      | driver        | Fleet      | Vehicles        | Car - Entities - System - Car - Entities - System                  |
      | driver        | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System       |
      | driver        | Customers  | Accounts        | Accounts - Customers                                               |
      | driver        | Customers  | Contacts        | Contacts - Customers                                               |
      | driver        | Activities | Calendar Events | Calendar Events - Activities                                       |
      | driver        | System     | Jobs            | Jobs - System                                                      |
      | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | sales manager | System     | Jobs            | All - Jobs - System                                                |
      | store manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | store manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | store manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | store manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | store manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | store manager | System     | Jobs            | All - Jobs - System                                                |











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













