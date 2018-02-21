/**
/**
 * This code is generated from the thoughts on Java Programming Lecture contributed by Prof.Thomas BROUSSARD
 *
 * Code application : Handle Exceptions when creating identity instances. 
 * Composant : exception instance, identity instance
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Identity;

/**
 * <h3>Description</h3>
 * <p>This class allows project to handle exceptions regarding creating identity without stopping
 * the entire program.</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>try{}catch(IdentityCreationException e){"alert msg || user-defined method to handle." }</code></pre>
 * </p>
 *
 * @since 2018{version1.0}
 * @see IdentityDataException
 * @author Qiaoyu Liu & Hao Xu
 *
 * Identity Exception Java Eclipse
 */
public class IdentityCreationException extends IdentityDataException {

	/**
	 * @param e
	 * @param identity
	 */
	public IdentityCreationException(Exception e, Identity identity) {
		super(e, identity);
	}

	@Override
	public String getMessage() {
		return "A problem occurred while creating that Identity : " + faultyIdentity;
	}

}
