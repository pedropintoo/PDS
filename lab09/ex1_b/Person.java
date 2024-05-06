package ex1_b;
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