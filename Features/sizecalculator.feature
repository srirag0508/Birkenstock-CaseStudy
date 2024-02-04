Feature: Navigate to PDP, Use Fit Guide, and Add to Shopping Cart


  As a user, I want to navigate to the PDP, use the fit guide to calculate my size,
  and add the product to my cart So that I can purchase the right size product
  @NavigateToPDPAndAddToCart

  Scenario: User successfully navigates to PDP, uses fit guide, calculates size, and adds to cart

    Given I am on the Size Calculator
    When I enter foot measurements and click calculate
    Then I verify the result Screen
    And Then I click Add to Cart
