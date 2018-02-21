/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.services.dao;

import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.exceptions.IdentitySearchException;

/**
 * <h3>Description</h3>
 * <p>This class allows to ...</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */
public interface IdentityDAO {

	public static final Integer number = 0;

	public void create(Identity identity,int i) throws IdentityCreationException, IdentitySearchException;

	public List<Identity> search(Identity criteria,int i) throws IdentitySearchException, XPathExpressionException;

	public void update(Identity identityoriginal, Identity identityupdate, int search);

	public void delete(List<Identity> list,int delete,int index);

	public boolean authentification(Identity authidentity) throws XPathExpressionException;


}
