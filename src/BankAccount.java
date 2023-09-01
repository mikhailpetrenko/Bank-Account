import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    private static int numberOfAccounts = 0;
    private static double total = 0;

    private String accNum;
    private double checkingBalance;
    private double savingBalance;

    public static String createNewAcc() {
        Random random = new Random();
        String accNum = "" + random.nextLong(1000000000, 9999999999l+1);
        return accNum;
    }

    public BankAccount(double checkingBalance, double savingBalance) {
        this.accNum = createNewAcc();
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        numberOfAccounts++;
        total += checkingBalance + savingBalance;
        System.out.println("The account #"+accNum+" has been created. The checking has "+checkingBalance+", though savings: "+savingBalance);
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
            System.out.println("Chose the number, where from you'd like to withdraw: 1 - checking, 2 - saving");
            int accType = input.nextInt();
            if (accType == 1) {
                if (checkingBalance > amount) {
                    checkingBalance -= amount;
                    System.out.println("funds were withdrew");
                    withdrawalSuccess = true;
                    total -= amount;
                } else {
                    System.out.println("Not enough funds in checking");
                }

            } else if (accType == 2) {
                    if (savingBalance > amount) {
                        savingBalance -= amount;
                        System.out.println("funds were withdrew");
                        withdrawalSuccess = true;
                        total -= amount;
                    } else {
                        System.out.println("Not enough funds in checking");
                    }

                } else {
                    System.out.println("Enter 1 or 2 only.");
                }
        }
    }
    public double getTotal() {
        return total;
    }




}
