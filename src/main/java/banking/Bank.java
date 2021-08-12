package banking;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
    private  static long ACCOUNT_NUMBER=0;
	public Bank() {
		 accounts=new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		long acctNumber=ACCOUNT_NUMBER+1;
		ACCOUNT_NUMBER++;
		CommercialAccount c=new CommercialAccount(company,acctNumber,pin,startingDeposit);
		this.accounts.put(acctNumber,c);
        return acctNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		long acctNumber=ACCOUNT_NUMBER+1;
		ACCOUNT_NUMBER++;
		ConsumerAccount consumerAccount=new ConsumerAccount(person,acctNumber,pin,startingDeposit);
		this.accounts.put(acctNumber,consumerAccount);
        return acctNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		Account a=this.getAccount(accountNumber);
        return a.validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
        return this.getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		this.getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
        return this.getAccount(accountNumber).debitAccount(amount);
	}
}
