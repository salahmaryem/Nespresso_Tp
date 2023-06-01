Feature: The user adds products to the basket
  After adding products and opening the basket
  the products should be displayed

  Scenario Outline: Add a machine and capsules to the cart
    Given The User is on the nespresso homePage site
    And The User clicks on the machineVertuo menu item
    And The User clicks on a machine named <productName1>
    And The User adds the machine to the cart with <quantity1>
    And The User clicks on the capsule menu item
    And The User clicks on a capsule named <productName2>
    And The User adds the capsule to the cart with <quantity2>
    When The user opens the cart
    Then The the cart should display the machine and capsules and verify their quantities <quantity1> <quantity2>


    Examples:
      | productName1 | quantity1 | productName2 | quantity2 |
      | Vertuo Next  | 1         | Venezia      | 50        |

