/**
/**
 * This code is generated from the thoughts on Java Programming Lecture contributed by Prof.Thomas BROUSSARD
 *
 * Code application : Handle Exceptions for faulty identity.
 * Composant : exception instance, identity instance.
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Identity;

/**
 * <h3>Description</h3>
 * <p>This class allows project to handle exceptions regarding faulty identity without stopping
 * the entire program.</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 * 
 * include this class.
 * 
 *   <pre><code>try{}catch(IdentityDataException e){"alert msg || user-defined method to handle." }</code></pre>
 * </p>
 *
 * @since 2018{version1.0}
 * @see IdentityDataException
 * @author Qiaoyu Liu & Hao Xu
 *
 * Identity Exception Java Eclipse
 */
public class IdentityDataException extends Exception {

	protected final Identity faultyIdentity;


	public IdentityDataException(Exception cause, Identity faultyIdentity) {
		initCause(cause);
		this.faultyIdentity = faultyIdentity;
	}
}
