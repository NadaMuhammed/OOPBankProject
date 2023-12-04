public class BasicBankAccount {
    private String accountId;
    private int balance;
    private static int id = 0;
    private Client client;

    public BasicBankAccount() {
        accountId = "";
        balance = 0;
    }

    public BasicBankAccount(int balance) {
        this.balance = balance;
        accountId = generateAccountId();
    }

    private String generateAccountId() {
        return "ACC" + id++;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void withdraw(int requestedAmount) {
        if (requestedAmount <= 0) {
            System.out.println("Please enter valid amount");
            return;
        }
        if (requestedAmount > balance) {
            System.out.println("Not Enough Balance");
            return;
        }
        balance -= requestedAmount;
        System.out.println("Process Succeeded!");

    }

    public void deposit(int amount) {
        if (amount <= 0){
            System.out.println("Enter valid amount of money");
            return;}

        balance += amount;
        System.out.println("Process Succeeded!");

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void view(){
        System.out.println("Account Id: "+this.accountId);
        System.out.println("Balance: "+this.balance);
        System.out.println("Client Name: "+client.getName());
        System.out.println("Client Phone Number: "+client.getPhoneNumber());
        System.out.println("Client Address: "+client.getAddress());
        System.out.println("-----------------------------------------------------");
    }

}
