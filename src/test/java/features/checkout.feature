Feature: Place the order for products

  @PLaceOrderTest
  Scenario Outline: Validate checkout process with cart items, promo code, and order placement
    Given user is on GreenKart landing page
    When user searched for shortname <Name> and extracted actual name of product
    And added "3" items of the selected product to cart
    Then user proceeds to checkout
    Then validate the <Name> items in checkout page
    And verify user has ability to enter promo code and place the order

  Examples:
    | Name |
    | Tom  |