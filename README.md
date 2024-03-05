### Handling Exceptions Try

In this try, you will be implementing banking-related operations. 

First, you will be implementing the methods in the provided `CheckingAccount`class. 
`CheckingAccount` implements `BankAccount` and so it must implement the `deposit()`,
`withdraw()`, and `getBalance` methods that the `BankAccount` interface defines. 

Both `deposit` and `withdraw` should ensure the `amount` argument being provided
is valid with a call to `Validator::validate()`. If the `amount` is valid a 
deposit can proceed. In addition to receiving a valid `amount`, a withdraw must
also ensure that the `amount` is not larger than the `balance` in the account.
If the `amount` exceeds the `balance` an `InsufficientFundsException` should
be thrown.

You should run the `CheckingAccount` tests to verify your
`CheckingAccount` implementation before moving on to the `Bank` class. 

The provided `Bank` class has a `transfer()` method that should allow users to transfer 
money between accounts. The method should return `true` if the amount can be withdrawn from one
account and deposited to the other. If the transfer fails due to a `TransactionException` occurring,
the method should display a meaningful message to log the exception, and return false. If the transfer fails due to an 
`InvalidInputException` the method should propagate the exception. 

You can run `./gradlew -q clean test` to verify your `Bank` implementation.

**You have completed this pre-work when:**
* You have implemented all methods in the `CheckingAccount` class
* You have implemented the `transfer()` method in the `Bank` class
* `./gradlew -q clean test` is passing. This will run both sets of tests for you!
* You have committed and pushed your code
* You have answered the canvas quiz
