/**
 * 
 * Code application :
 * Composant : 
 */
package fr.epita.bank.datamodel;

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
public class SavingsAccount extends Account {
	
	private Double interrestRate;

	/**
	 * @return the interrestRate
	 */
	public Double getInterrestRate() {
		return interrestRate;
	}

	/**
	 * @param interrestRate the interrestRate to set
	 */
	public void setInterrestRate(Double interrestRate) {
		this.interrestRate = interrestRate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SavingsAccount [interrestRate=" + interrestRate + ", balance=" + balance + "]";
	} 

}
