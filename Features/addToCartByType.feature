Feature: The user adds products to the basket by type

  After adding products and opening the basket
  the products should be displayed

  Scenario Outline: Add a machine or capsule to the cart based on the product type
    Given The User is on the nespresso homePage site
    And The User clicks on the <type> menu item
    And The User clicks on a <type> named <productName1>
    And The User adds the <productType> to the cart with <quantity1>
    When The user opens the cart
    Then The User should see the <productType> in the cart with quantity <quantity1>

    Examples:
      | type            | productName1 | quantity1 |
      | machineVertuo   | Vertuo Next  | 1         |
      | capsuleOriginal | Venezia      | 50        |