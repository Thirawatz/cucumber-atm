package ku.atm;

public class ATM {
	private Bank bank;
	private Customer currentCustomer;
	private BankAccount currentAccount;

	public ATM(Bank bank) {
		this.bank = bank;
	}

	public boolean validateCustomer(int id, int pin) {
		Customer customer = bank.getCustomer(id);
		if (customer == null) {
			throw new IllegalArgumentException("ID not found");
		}
		if (!customer.match(pin)) {
			return false;
		}
		currentCustomer = customer;
		currentAccount = customer.getAccount();
		return true;
	}

	public void withdraw(double value) throws NotEnoughBalanceException {
		if (currentAccount != null)
            currentAccount.withdraw(value);
	}

	public void deposit(double value) {
		if (value <= 0) {
			throw new IllegalArgumentException("Invalid deposit amount");
		}
		currentAccount.deposit(value);
	}

	public double getBalance() {
		if (currentAccount != null)
            return currentAccount.getBalance();
        return -1;
	}

	public void transfer(int receiverId, double amount) throws NotEnoughBalanceException {
		if (currentAccount != null)
            bank.transfer(currentCustomer.getId(), receiverId, amount);
	}

	public void reset() {
		currentCustomer = null;
		currentAccount = null;
	}




}
