Feature: To check the B-One Application

  @SC01
  Scenario: Create a Data with unique Sub Category
    Given user logins the b one application
    When user creates a sub category with unique data


  @SC02
  Scenario: Create a Data with Existing Sub Category
    Given user logins the b one application
    When user creates a sub category with Existing data