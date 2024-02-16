Feature: Create Order

  @PostOrder
  Scenario Outline: CReate order successfully
    When I sendth e info petID "<petId>" quantity "<quantity>" and shipDate "<shipDate>"
    Then I can validate response server code 200
    Examples:
      | petId | quantity | shipDate   |
      | 735   | 1        | 2024-02-16 |