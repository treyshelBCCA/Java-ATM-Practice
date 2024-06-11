# ATM Practice:

You're making an atm.
1. It should use a dataclass.
2. You should have three functions besides main, a [deposit], [withdraw], and a [change account].
3. There are two accounts you can draw funds from:
4.   Checking  and  Savings
6.   Checking has an overdraft limit of $50, Savings has an overdraft limit of $100.
7. A user can withdraw an amount equal to their balance and up to the overdraft limit. 'Balance should show (Overdrawn)'
8. However, if the account is already overdraft, they can't withdraw any money. Should say 'Cannot withdraw while overdrawn.'
9. They also cannot change accounts if the account is overdraft. Should say 'Cannot change account type while overdrawn.'
10. Withdraw should remove the funds from the account.
11. Deposit should add funds to the account.
12. You should have proper input helpers.
13. And the user should be able to quit at anytime.