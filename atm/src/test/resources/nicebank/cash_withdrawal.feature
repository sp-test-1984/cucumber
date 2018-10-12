Feature: Cash Withdrawal
  Scenario: Successful Withdrawal from an Account in Credit
    Given I have deposited $100.00 in  my account
    When I withdraw $20
    Then $20 should be dispensed
    And the balance of my account should be $80.00
