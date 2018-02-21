/**
 * 
 * Code application : Composant :
 */
package fr.epita.bank.launcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.services.ui.ConsoleHandler;

/**
 * <h3>Description</h3>
 * <p>
 * Cette classe permet de ...
 * </p>
 *
 * <h3>Utilisation</h3>
 * <p>
 * Elle s'utilise de la manière suivante :
 * 
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 * 
 * @since $${version}
 * @see Voir aussi $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class Main {

	/**
	 * <h3>Description</h3>
	 * <p>
	 * Cette méthode permet de ...
	 * </p>
	 *
	 * <h3>Utilisation</h3>
	 * <p>
	 * Elle s'utilise de la manière suivante :
	 * 
	 * <pre>
	 * <code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code>
	 * </pre>
	 * </p>
	 * 
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 *         ${tags}
	 */
	public static void main(String[] args) {
		
		ConsoleHandler consoleHandler = new ConsoleHandler(System.in, System.out);
		
		System.out.println("Welcome to the bank system program");
		System.out.println("Please enter the user name: ");
		String name = consoleHandler.getString();
		
		Customer customer1 = new Customer();

		customer1.setName(name);
		System.out.println("the program created a customer with name :" + customer1.getName());

		System.out.println("Please enter a balance for the investment account");
		InvestmentAccount investmentAccount = new InvestmentAccount();
		Double investmentAccountBalance = consoleHandler.getDouble();

		investmentAccount.setBalance(investmentAccountBalance);

		SavingsAccount savingsAccount = new SavingsAccount();
		System.out.println("Please enter a balance for the savings account");
		Double savingsAccountBalance = consoleHandler.getDouble();
		savingsAccount.setBalance(savingsAccountBalance);

		System.out.println("Please enter an interest rate for the savings account");
		Double savingsAccountRate = consoleHandler.getDouble();
		savingsAccount.setInterrestRate(savingsAccountRate);

		customer1.setInvestmentAccounts(Arrays.asList(investmentAccount));

		customer1.setSavingsAccounts(Arrays.asList(savingsAccount));

		List<SavingsAccount> savingsAccountList = new ArrayList<>();
		savingsAccountList.add(savingsAccount);

		customer1.setSavingsAccounts(savingsAccountList);

		System.out.println("customer1 content : " + customer1);

		System.out.println("End of program");

		consoleHandler.close();
	}

	
	
}
