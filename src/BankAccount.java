import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    private static int numberOfAccounts = 0;
    private double total = 0;

    private static String accNum;
    private double checkingBalance;
    private double savingBalance;

    public static String createNewAcc() {
        Random random = new Random();
        return "" + random.nextLong(1000000000, 9999999999l+1);
    }

    public BankAccount(double checkingBalance, double savingBalance) {
        this.accNum = createNewAcc();
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        numberOfAccounts++;
        total += this.checkingBalance + this.savingBalance;
        System.out.println("The account #"+accNum+" has been created. The checking has "+checkingBalance+", though savings: "+savingBalance+". Total is: "+total);
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingBalance() {
        return savingBalance;
    }

    public void deposit (double amountToBeDep) {
        Scanner input = new Scanner(System.in);
        boolean depSuccess = false;
        while (!depSuccess) {
            System.out.println("Chose the number, in which account would you like to depotis: 1 - checking, 2 - saving");
            int accType = input.nextInt();
            if (accType == 1) {
                checkingBalance += amountToBeDep;
                total += amountToBeDep;
                System.out.println("The amount has been deposited to Checking");
                System.out.println("Now checking is: "+checkingBalance+". Total: "+total);
                depSuccess = true;
            } else if (accType == 2) {
                savingBalance += amountToBeDep;
                total += amountToBeDep;
                System.out.println("The amount has been deposited to Saving");
                System.out.println("Now savings is: "+savingBalance+". Total: "+total);
                depSuccess = true;
            } else {
                System.out.println("Enter 1 or 2 only.");
            }
        }

    }
    public void withdraw(double amount) {
        Scanner input = new Scanner(System.in);
        boolean withdrawalSuccess = false;
        while (!withdrawalSuccess) {
            if (checkingBalance < amount && savingBalance<amount) {
                System.out.println("None of your accounts have enough money");
                withdrawalSuccess = true;
            } else {
            System.out.println("Chose the number, where from you'd like to withdraw: 1 - checking, 2 - saving");
            int accType = input.nextInt();
            if (accType == 1) {
                if (checkingBalance > amount) {
                    checkingBalance -= amount;
                    withdrawalSuccess = true;
                    total -= amount;
                    System.out.println("funds were withdrew");
                    System.out.println("Your checking now is "+checkingBalance+". Total: "+total);
                } else {
                    System.out.println("Not enough funds in checking. try to withdraw from savings");
                }

            } else if (accType == 2) {
                    if (savingBalance > amount) {
                        savingBalance -= amount;
                        withdrawalSuccess = true;
                        total -= amount;
                        System.out.println("funds were withdrew");
                        System.out.println("Your savings now is "+savingBalance+". Total: "+total);
                    } else {
                        System.out.println("Not enough funds in savings. Try to withdraw form checking");
                    }

                } else {
                    System.out.println("Enter 1 or 2 only.");
                }
            }
        }
    }
    public double getTotal() {
        return total;
    }
    public static void getAccsNumber() {
        System.out.println("There are total "+numberOfAccounts+" accounts have been created.");
    }


}
