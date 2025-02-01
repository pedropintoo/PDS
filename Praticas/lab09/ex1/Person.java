/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex1;
class Person {
	
	private String name;
	private ProxyBankAccount bankAccount;

	public Person(String n) {
		name = n;
		bankAccount = new ProxyBankAccount(new BankAccountImpl("PeDeMeia", 0));
	}

	public String getName() {
		return name;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
}