package ex2;
class ProxyBankAccount implements BankAccount {

    private BankAccount bank;

    public ProxyBankAccount(BankAccount bank){
        this.bank = bank;
    }

    public void deposit(double amount) {
        bank.deposit(amount);
    } 

    public boolean withdraw(double amount) {
        if (User.OWNER == Company.user) {
            return bank.withdraw(amount);
        }
        return false;
    }

    public double balance() {
        if (User.OWNER == Company.user) {
            return bank.balance();
        }   
        return -1;
    }

}
