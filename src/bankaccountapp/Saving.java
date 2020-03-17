package bankaccountapp;

public class Saving extends Account {

    // list properties specific to the savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // constructor to initialize settings for the savings properties
    public Saving(
            String name,
            String ssn,
            double initDeposit) {
        super(name, ssn, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    // list any methods specific to savings account
    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Your saving account features" +
                           "\n Safety deposit box ID: " + safetyDepositBoxID +
                           "\n Safety deposit box key: " + safetyDepositBoxKey);
    }

}
