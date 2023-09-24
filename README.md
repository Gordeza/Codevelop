### The `AccountServiceImpl` class provides the following functionalities:

1. **Opening Savings Account**: It allows the creation of a new savings account with a specified initial deposit amount. This method associates the created account with a unique account ID. If the initial deposit is insufficient, it throws an `AccountCannotBeCreatedException`.

2. **Opening Current Account**: This functionality opens a new current account and associates it with a given unique account ID. If any issues arise during the account creation process, it throws an `AccountCannotBeCreatedException`.

3. **Withdrawing Funds**: It enables users to withdraw a specified amount from the account associated with a provided account ID. This method handles exceptions such as `AccountNotFoundException` (if the account does not exist) and `WithdrawalAmountTooLargeException` (if the withdrawal amount exceeds the account balance).

4. **Depositing Funds**: This functionality allows users to deposit a specified amount into the account associated with a provided account ID. It handles the `AccountNotFoundException` exception if the account does not exist.



### The `SystemDBImpl` class provides the following functionalities:

1. **Retrieving Account by ID**: It offers a method to retrieve an account by its unique identifier. Users can specify an account ID, and the method returns the account associated with that identifier. If no account exists with the provided ID, it throws an `AccountNotFoundException`.

2. **Adding a New Account**: This functionality allows the addition of a new account to the system. Users can specify a unique account ID and provide the account object to be added. If an account with the provided identifier already exists, it throws an `AccountExistsException`.

3. **Initialization with Default Accounts**: The class is initialized with a set of default accounts, including both savings and current accounts. This provides an initial set of accounts when the `SystemDBImpl` instance is created.


### The `CurrentAccount` class provides the following functionalities:

1. **Overdraft Limit Management**: The class allows the creation of a current account with a specified overdraft limit. If the provided overdraft limit exceeds the maximum allowed limit, it throws an `AccountCannotBeCreatedException`. The class also provides a default overdraft limit if none is specified.

2. **Withdrawal Operation with Overdraft**: It enables withdrawals from the current account's balance while considering the overdraft limit. If the withdrawal amount exceeds the available balance plus the overdraft limit, it throws a `WithdrawalAmountTooLargeException`.

3. **Deposit Operation**: The class supports depositing a specified amount into the current account's balance. The balance is updated accordingly.

### The `SavingsAccount` class provides the following functionalities:

1. **Account Creation with Initial Deposit**: The class allows the creation of a savings account with a specified initial deposit amount. If the initial deposit is less than the minimum allowed balance, it throws an `AccountCannotBeCreatedException`.

2. **Withdrawal Operation**: It supports withdrawals from the savings account's balance. If the withdrawal amount would result in a balance less than the minimum allowed balance, it throws a `WithdrawalAmountTooLargeException`.

3. **Deposit Operation**: The class enables deposits of a specified amount into the savings account's balance. The balance is updated accordingly.

These functionalities collectively define the behavior and operations that can be performed on a savings account, including account creation with initial deposit, withdrawals, and deposits.