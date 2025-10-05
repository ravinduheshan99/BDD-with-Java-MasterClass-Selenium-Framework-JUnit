Feature: Search and Place the Order for Products

  @SearchTest
  Scenario Outline: Search Experience product search in both home and offers page
    Given user is on GreenKart landing page
    When user searched for shortname <Name> and extracted actual name of product
    Then user searched for same shortname <Name> in offers page and extracted actual name of product
    And validate product name in offers page matches with landing page

  Examples:
    | Name |
    | Tom  |
    | Beet |