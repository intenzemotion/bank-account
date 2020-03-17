package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();

        String file = "C:\\NewBankAccounts.csv"; // change this to your own location accordingly

        // read a CSV file then create new accounts based on that data
        List<String[]> newAccount = utilities.CSV.read(file);
        for (String[] account : newAccount) {

            String name = account[0];
            String ssn = account[1];
            String accountType = account[2];
            double initDeposit = Double.parseDouble(account[3]);

            if (accountType.equals("Savings")) {
                accounts.add(new Saving(name, ssn, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, ssn, initDeposit));
            } else {
                System.out.println("Error reading account type");
            }
        }

        for (Account acc : accounts) {
            System.out.println("\n***************************\n");
            acc.showInfo();
        }
    }

}
