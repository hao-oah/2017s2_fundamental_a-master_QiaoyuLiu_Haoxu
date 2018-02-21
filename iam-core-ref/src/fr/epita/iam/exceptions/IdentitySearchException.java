/**
/**
 * This code is generated from the thoughts on Java Programming Lecture contributed by Prof.Thomas BROUSSARD
 *
 * Code application : Handle Exceptions for identity search.
 * Composant : exception instance, identity instance.
 */
package fr.epita.iam.exceptions;

import fr.epita.iam.datamodel.Identity;


/**
 * <h3>Description</h3>
 * <p>This class allows project to handle exceptions regarding identity search without stopping
 * the entire program.</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 * 
 * include this class.
 * 
 *   <pre><code>try{}catch(IdentitySearchException e){"alert msg || user-defined method to handle." }</code></pre>
 * </p>
 *
 * @since 2018{version1.0}
 * @see IdentityDataException
 * @author Qiaoyu Liu & Hao Xu
 *
 * Identity Exception Java Eclipse
 */
public class IdentitySearchException extends IdentityDataException {

	/**
	 * @param cause
	 * @param faultyIdentity
	 */
	public IdentitySearchException(Exception cause, Identity faultyIdentity) {
		super(cause, faultyIdentity);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public String getMessage() {
		return "a problem occured while searching identities with that criteria : " + faultyIdentity;
	}
}
