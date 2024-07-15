Feature: Validating Place APIs

  @AddPlace
  Scenario Outline: Verify if place is being successfully added using AddPlace API
    Given Add place payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then status code should be 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify the place_Id created maps to "<name>" using "getPlaceAPI"

    Examples:
      | name   | language | address  |
      | Basava | English  | Nagawara |
      | Raj    | Kannada  | Hennur   |


    @DeletePlace
  Scenario: Verify delete place API

    Given DeletePlace payload
    When user calls "deletePlaceAPI" with "POST" http request
    Then status code should be 200


      Feature: Test Hooks
        @hooks
        Scenario: This scenario is to test hooks functionality
          Given this is the first step
          When this is the second step
          Then this is the third step