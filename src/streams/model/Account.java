package streams.model;

import java.util.List;

public class Account {

	private int accountId;
	private String accountType;
	private List<Integer> transactions;

	public Account(int accountId, String accountType, List<Integer> transactions) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.transactions = transactions;
	}

	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setTransactions(List<Integer> transactions) {
		this.transactions = transactions;
	}

	public List<Integer> getTransactions() {
		return transactions;
	}
	

}
