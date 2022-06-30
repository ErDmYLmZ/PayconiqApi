@Regression
@Before(order=3)
Feature: Delete an existing user
  Scenario: User deletes a user
    Given user sends a delete request to booking "Id"
    When user gets the delete status code 201
    Then user verify the booking "id" was deleted succesfully