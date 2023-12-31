public class SavingsBankAccount extends BasicBankAccount{
    private int minimumBalance;

    public SavingsBankAccount(int minimumBalance, int initialBalance){
        super(initialBalance);
        this.minimumBalance=minimumBalance;
    }

    public SavingsBankAccount(){
        this.minimumBalance=1000;
    }

    public int getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(int minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(int requestedAmount) {
        if (this.getBalance()-requestedAmount<minimumBalance) {
            System.out.println("Transaction Failed! Balance Cannot Be Less Than Your Minimum Balance!");
            return;
        }

        this.setBalance(this.getBalance()-requestedAmount);
        System.out.println("Process Succeeded!");

    }

    @Override
    public void deposit(int amount) {
        if (amount<100) {
            System.out.println("Transaction Failed! Deposit Amount Cannot Be Less Than 100 Pounds!");
            return;
        }

        super.deposit(amount);
        System.out.println("Process Succeeded!");

    }
    @Override
    public void view() {
        System.out.println("Account Id: "+this.getAccountId());
        System.out.println("Balance: "+this.getBalance());
        System.out.println("Account minimum balance: "+minimumBalance);
        System.out.println("Client Name: "+getClient().getName());
        System.out.println("Client Phone Number: "+getClient().getPhoneNumber());
        System.out.println("Client Address: "+getClient().getAddress());
        System.out.println("-----------------------------------------------------");

    }
}
