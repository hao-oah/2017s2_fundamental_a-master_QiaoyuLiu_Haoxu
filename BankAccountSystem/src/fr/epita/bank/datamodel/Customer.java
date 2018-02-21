/**
 * 
 * Code application : Composant :
 */
package fr.epita.bank.datamodel;

import java.util.List;

public class Customer {

	private String name;
	private String address;

	private List<SavingsAccount> savingsAccounts;
	private List<InvestmentAccount> investmentAccounts;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the savingsAccounts
	 */
	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}
	/**
	 * @param savingsAccounts the savingsAccounts to set
	 */
	public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}
	/**
	 * @return the investmentAccounts
	 */
	public List<InvestmentAccount> getInvestmentAccounts() {
		return investmentAccounts;
	}
	/**
	 * @param investmentAccounts the investmentAccounts to set
	 */
	public void setInvestmentAccounts(List<InvestmentAccount> investmentAccounts) {
		this.investmentAccounts = investmentAccounts;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", savingsAccounts=" + savingsAccounts + ", investmentAccounts="
				+ investmentAccounts + "]";
	}
	
	
	

}
