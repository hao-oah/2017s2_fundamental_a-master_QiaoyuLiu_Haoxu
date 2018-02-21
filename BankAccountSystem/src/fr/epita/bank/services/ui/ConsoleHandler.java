/**
 * 
 * Code application :
 * Composant : 
 */
package fr.epita.bank.services.ui;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


/** 
 * <h3>Description</h3>  
 * <p>Cette classe permet de ...</p>
 *
 * <h3>Utilisation</h3>
 * <p>Elle s'utilise de la manière suivante :
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *  
 * @since $${version}
 * @see Voir aussi $${link}
 * @author ${user}
 *
 * ${tags}
 */
public class ConsoleHandler {
	
	//input from console
	private Scanner scanner;
	
	//output to console
	private PrintWriter printWriter;
	
	
	/**
	 * 
	 * @param in
	 * @param out
	 */
	public ConsoleHandler(InputStream in, OutputStream out) {
		this.printWriter = new PrintWriter(out);
		this.scanner = new Scanner(in);
	}
	
	
	
	/** 
	 * <h3>Description</h3>  
	 * <p>Cette méthode permet de ...</p>
	 *
	 * <h3>Utilisation</h3>
	 * <p>Elle s'utilise de la manière suivante :
	 *   
	 * <pre><code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code></pre>
	 * </p>
	 *  
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 * ${tags}
	 */
	public Double getDouble() {
		int counter = 0;
		while (counter < 3) {
			try {
				Double doubleValue = Double.valueOf(scanner.nextLine());
				return doubleValue;
			} catch (NumberFormatException nbe) {
				nbe.printStackTrace();
				counter ++;
				System.out.println("got an error whith your input, please retry");
			}
		
		}
		System.out.println("too much tries, your value is set to 0");
		return 0d;
	}
	
	
	/** 
	 * <h3>Description</h3>  
	 * <p>Cette méthode permet de ...</p>
	 *
	 * <h3>Utilisation</h3>
	 * <p>Elle s'utilise de la manière suivante :
	 *   
	 * <pre><code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code></pre>
	 * </p>
	 *  
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 * ${tags}
	 */
	public  String getString() {
		String name = scanner.nextLine();
		return name;
	}



	/** 
	 * <h3>Description</h3>  
	 * <p>Cette méthode permet de ...</p>
	 *
	 * <h3>Utilisation</h3>
	 * <p>Elle s'utilise de la manière suivante :
	 *   
	 * <pre><code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code></pre>
	 * </p>
	 *  
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 * ${tags}
	 */
	public void close() {
		this.scanner.close();
		this.printWriter.close();
	}


}
