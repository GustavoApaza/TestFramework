Feature: The cart page
  Scenario: As a final user, I want to navigate to the cart page To see the total price of all products added on it
    Given The user navigate to the home page
    When he add the first product to the cart
    And he add the second product to the cart
    And he navigate to the cart page
    Then he can see the total price of all products added
