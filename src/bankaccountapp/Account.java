package bankaccountapp;

public abstract class Account implements IBaseRate {

    // list common properties for savings and checking account
    private String name;
    private String ssn;
    private double balance;
    private static int index = 10000;

    protected String accountNumber;
    protected double rate;

    // constructor to set base properties and initialize the account
    public Account(
            String name,
            String ssn,
            double initDeposit) {

        this.name = name;
        this.ssn = ssn;
        balance = initDeposit;

        // set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoSSN = ssn.substring(ssn.length() - 2, ssn.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3)); // random 3 digits number
        return lastTwoSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance = balance + accruedInterest;
        System.out.println("Accrued interest: $" + accruedInterest);
        printBalance();
    }

    // list common methods - transactions
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo() {
        System.out.println("Name: " + name +
                           "\nAccount Number: " + accountNumber +
                           "\nBalance: " + balance +
                           "\nRate: " + rate + "%");
    }

}
