/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex2;
class BankAccountImpl implements BankAccount {
	
private String bank;
private double balance;

	BankAccountImpl(String bank, double initialDeposit) {
		this.bank = bank;
		balance = initialDeposit;
	}
	
	public String getBank() {
		return bank;	
	}
	@Override public void deposit(double amount) {
			balance += amount;
	}
	@Override public boolean withdraw(double amount) {
		if (amount > balance )
			return false;
		balance -= amount;
		return true;
	}
	@Override public double balance() {
		return balance;
	}
}