public class Client {
    private String name;
    private String address;
    private String phoneNumber;
    private BasicBankAccount account;

    public Client(String name, String address, String phoneNumber){
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }

    public Client() {
        this.name = "";
        this.address="";
        this.phoneNumber="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BasicBankAccount getAccount() {
        return account;
    }

    public void setAccount(BasicBankAccount account) {
        this.account = account;
    }

    public void view(){
        System.out.println("Client Name: "+this.name);
        System.out.println("Client Phone Number: "+this.phoneNumber);
        System.out.println("Client Address: "+this.address);
        System.out.println("Account Id: "+this.account.getAccountId());
        System.out.println("Balance: "+this.account.getBalance());
        System.out.println("-----------------------------------------------------");
    }
}
