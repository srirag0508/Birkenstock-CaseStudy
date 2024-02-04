Feature: Fit Guide Automation

  As a user, I want to use the Fit Guide to calculate my shoe size and add the product to the shopping cart.

  @FitGuideAutomation
  Scenario: Navigate to PDP, use Fit Guide, and add to shopping cart

    Given I am on the Product Display Page (PDP)

    When I click on the Fit Guide link

    And I select the left foot measurements:
      | Length | Width |
      | 220 mm  | 85 mm |

    And I select the right foot measurements:
      | Length | Width |
      | 220 mm  | 85 mm |

    And I click on the calculate size button

    Then I verify the result displyed

    And I verify the resulted Size

    And I click on the Add to Shopping Cart button

    Then I should be redirected to the shopping cart

    And I should see the product added with the calculated size
