Feature: Cash Withdrawal
  Scenario: Successful Withdrawal from an Account in Credit
    Given my account has been credited with $100.00
    When I withdraw $20
    Then $20 should be dispensed
    And the balance of my account should be $80.00
