/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex1_b;
interface BankAccount {
	void deposit(double amount);
	boolean withdraw(double amount);
	double balance();
}

