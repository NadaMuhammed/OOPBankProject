import java.util.ArrayList;
import java.util.Scanner;

public class Project {
    private static ArrayList<BasicBankAccount> accounts = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter: ");
            System.out.println("1 to Create Account ");
            System.out.println("2 to List All Accounts ");
            System.out.println("3 to List All Clients ");
            System.out.println("4 to View Specific Account Details ");
            System.out.println("5 to Withdraw ");
            System.out.println("6 to Deposit ");
            System.out.println("7 to Exit ");
            int userSelection = input.nextInt();
            boolean shouldBreak = false;
            switch (userSelection) {
                case 1:
                    CreateAccount();
                    break;
                case 2:
                    listAllAccounts();
                    break;
                case 3:
                    listAllClients();
                    break;
                case 4:
                    viewSpecificAccount();
                    break;
                case 5:
                    withdraw();
                    break;
                case 6:
                    deposit();
                    break;
                case 7:
                    System.out.println("Thank you for using our bank!");
                    shouldBreak = true;
                    break;
                default:
                    System.out.println("Enter Valid Selection");
            }
            if (shouldBreak)
                break;
//            if(userSelection==1){
//                CreateAccount();
//            } else if (userSelection==2){
//                listAllAccounts();
//            }else if (userSelection==3){
//                listAllClients();
//            }else if (userSelection==4){
//                viewSpecificAccount();
//            }else if (userSelection==5){
//                withdraw();
//            }else if (userSelection==6){
//                deposit();
//            }
//            else if (userSelection==7){
//                break;
//            } else {
//                System.out.println("Enter A Valid Number!");
//            }
        }
    }

    private static void deposit() {
        BasicBankAccount account = getAccountById();
        if (account != null) {
            System.out.println("Enter The Amount Of Money You Want To Deposit:");
            int amount = input.nextInt();
            account.deposit(amount);
            System.out.println("Current Balance: " + account.getBalance());
        }

    }

    private static void withdraw() {
        BasicBankAccount account = getAccountById();
        if (account != null) {
            System.out.println("Enter the withdrawal amount:");
            int requestedAmount = input.nextInt();
            while (requestedAmount > account.getBalance()) {
                System.out.println("Please enter valid amount");
                requestedAmount = input.nextInt();
            }
            account.withdraw(requestedAmount);
            System.out.println("Current Balance: " + account.getBalance());
        }

    }

    private static void viewSpecificAccount() {
        BasicBankAccount account = getAccountById();
        if (account != null) {
            account.view();
        }
    }

    private static BasicBankAccount getAccountById() {
        System.out.println("Please enter account id:");
        String accountId = input.next();
        for (BasicBankAccount account : accounts) {
            if (account.getAccountId().equalsIgnoreCase(accountId)) {
                return account;
            }
        }
        System.out.println("Account Not Found");
        return null;
    }

    private static void listAllClients() {
        for (Client client : clients) {
            client.view();
        }
    }

    private static void CreateAccount() {
        System.out.println("Enter: ");
        System.out.println("1 to Create Basic Account: ");
        System.out.println("2 to Create Savings Accounts: ");
        int userSelection = input.nextInt();

        System.out.println("Please enter your name:");
        String name = input.next();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        System.out.println("Please enter your address:");
        String address = input.next();
        System.out.println("Please enter your phone number:");
        String phoneNumber = input.next();
        Client client = new Client(name, address, phoneNumber);
        clients.add(client);
        BasicBankAccount account = null;
        if (userSelection == 1) {
            System.out.println("Please enter your balance:");
            int balance = input.nextInt();
            account = new BasicBankAccount(balance);

        } else if (userSelection == 2) {
            System.out.println("Please enter your minimum balance:");
            int minBalance = input.nextInt();
            System.out.println("Please enter your balance:");
            int balance = input.nextInt();

            while (balance < minBalance) {
                System.out.println("Please enter valid balance! Balance cannot be less than your minimum balance");
                balance = input.nextInt();
            }

            account = new SavingsBankAccount(minBalance, balance);
        } else
            System.out.println("Enter Valid Number!");


        if (account != null) {
            accounts.add(account);
            client.setAccount(account);
            account.setClient(client);
            System.out.println("Account Created Successfully! Welcome to our Bank " + name);
        }
    }

    private static void listAllAccounts() {
        for (BasicBankAccount account : accounts) {
            account.view();
        }
    }
}
