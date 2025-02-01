/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex1_b;
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
