/**
 *
 * Code application : Define the data type and structure for all identities (Normal Users + Administrators).
 * Composant : get and set all identity related data types and verify instance for user input
 * authentication.
 */
package fr.epita.iam.datamodel;

/**
 * <h3>Description</h3>
 * <p>This class is to define the datamodel of the project. : Displayname, uid, and email are three
 * parameters (properties) determining an identity. Then, Password is added to allow administrative 
 * functions of accessing the three information enclosed with this datamodel.
 * 
 * In addition, identity created without initiating password parameter will be regarded as normal users.
 * identity with non-null password will be considered as an administrator identity.  
 * This feature will allow the project requirements for the relationship between user and identity concepts.
 * 
 * </p>
 *
 * <h3>Utilisation</h3>
 * <p>***Management for this project as a model, through the related project DAO method please. 
 * Interface Reference: IdentityDAO.java
 * 
 * Way to use: Identity identity_instance = new Identity(); for identity creation
 * For specification on getter and setter for each param, Please view the comment and code for
 * related sections.
 * 
 * </p>
 *
 * @since 2018{1.1}
 * @see https://github.com/thomasbroussard?tab=repositories
 * @author Qiaoyu Liu & Hao Xu
 *
 * Data model, Class, Identity, Properties, Java, Eclipse
 */
public class Identity {

	private String displayName;
	private String uid;
	private String email;
	private String password; // authentication key & administrator flag

	/**
	 *
	 */
	public Identity() {

	}

	/**
	 * @param displayName
	 * @param uid
	 * @param email
	 * @param password : only applicable for real administrators. 
	 */
	public Identity(String displayName, String uid, String email,String password) {
		this.displayName = displayName;
		this.uid = uid;
		this.email = email;
		this.password=password;
	}
	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identity [displayName=" + displayName + ", uid=" + uid + ", email=" + email + "]";
	}

	@Override //generated hash for determining equality 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override // truth table to verify instance viability and its properties.

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identity other = (Identity) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}



}
