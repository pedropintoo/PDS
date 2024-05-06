package ex2;
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
	
	public void deposit(double amount) {
		bankAccount.deposit(amount);
	}

	public boolean withdraw(double amount) {
		return bankAccount.withdraw(amount);
	}

	public double balance() {
		return bankAccount.balance();
	}

	@Override
	public String toString() {
		return "Person[" + name + "]";
	}
}