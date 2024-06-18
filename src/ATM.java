import java.util.Scanner;

public class ATM {
    static class Account {
        String type;
        double balance;
        double overdraftLimit;

        Account(String type, double overdraftLimit) {
            this.type = type;
            this.overdraftLimit = overdraftLimit;
            this.balance = 0;
        }

        boolean isOverdrawn() {
            return balance < 0;
        }
    }

    static Account checking = new Account("Checking", 50);
    static Account savings = new Account("Savings", 100);
    static Account currentAccount = checking;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("Current Account: " +  currentAccount.type + " | Balance: " + currentAccount.balance);
            System.out.println("[D]eposit - [W]ithdraw - [C]hange Account - [Q]uit");
            action = scanner.nextLine();

            switch (action){
                case "D":
                    deposit(scanner);
                    break;
                case "W":
                    withdraw(scanner);
                    break;
                case "C":
                    changeAccount();
                    break;
                case "Q":
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid Action");
            }
//            if (action.equalsIgnoreCase("D")){
//                deposit(scanner);
//            }
//            else if (action.equalsIgnoreCase("W")){
//                withdraw(scanner);
//            } else if (action.equalsIgnoreCase("C")) {
//                changeAccount();
//            } else if (action.equalsIgnoreCase("Q")){
//                break;
//            }
        }
    }

    static void changeAccount() {
        if (currentAccount.isOverdrawn()) {
            System.out.println("You can't change accounts while overdrawn");
            return;
        }

        if (currentAccount == checking) {
            currentAccount = savings;
        }else {
            currentAccount = checking;
        }

        System.out.println("Account changed to: " + currentAccount.type);
    }

    static void withdraw(Scanner scanner) {
        if (currentAccount.isOverdrawn()){
            System.out.println("I'm sorry. You cannot withdraw while overdrawn.");
        }

        System.out.println("Withdraw Amount: $");
        double amount = scanner.nextDouble();

        if (amount <= 0){
            System.out.println("Enter a positive integer.");
            return;
        }

        if (currentAccount.balance - amount < -currentAccount.overdraftLimit){
            System.out.println("You are trying to withdraw over your overdraft limit");
            return;
        }

        currentAccount.balance -= amount;
        System.out.println("Withdrew: $" + amount);

    }

    static void deposit(Scanner scanner) {
        System.out.println("Deposit Amount: $");
        double amount = scanner.nextDouble();

        currentAccount.balance += amount;
        System.out.println("Deposited Amount: $" + amount);
    }
}
