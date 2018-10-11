Feature: Cash Withdrawal
  Scenario: Successful Withdrawal from an Account in Credit
    Given I have deposited $100.00 in  my account
    When I request $20
    Then $20 should be dispensed