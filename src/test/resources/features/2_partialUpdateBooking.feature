@Regression
Feature: Partial Update Booking
  Scenario: User partially updates booking
    Given user sends a patch request to booking "Id"
    When user gets the patch status code 200
    Then user verify the booking was partially updated with "Firstname"and "Lastname"