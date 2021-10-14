Feature: Make coffee with coffeemaker.

  Scenario: Add a Recipe
    Given Create a recipe
    When I add Latte recipe to coffee maker
    Then the coffee maker must have Latte recipe

  Scenario: Edit a recipe
    Given coffee maker has Latte recipe
    When I edit Latte recipe to Milktea
    Then that Latte recipe will Milktea

  Scenario: Add coffee in inventory
    Given Inventory
    When I add 10 coffee into inventory
    Then the inventory will have 25 coffee

  Scenario: Add chocolate in inventory
    Given Inventory
    When I add 10 chocolate into inventory
    Then the inventory will have 25 chocolate

  Scenario: Add milk in inventory
    Given Inventory
    When I add 10 milk into inventory
    Then the inventory will have 25 milk

  Scenario: Customer buy Latte
    Given Start Coffee maker
    When Customer pay Latte 100
    Then Customer get Latte and no change

  Scenario: Customer buy Milktea
    Given Start Coffee maker
    When Customer pay 100
    Then Customer get Milktea and 40 change
