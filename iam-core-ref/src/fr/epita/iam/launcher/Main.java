/**
 * This code is generated from the thoughts on Java Programming Lecture contributed by Prof.Thomas BROUSSARD
 * Code application : This Package provides a Main for project's console functionality.
 * Compassionate :Adm Authentication, Create/update/delete/search identities.
 */
package fr.epita.iam.launcher;
/**
 * <h3>Description</h3>
 * <p>
 * This method allows adm to launch the program. Click "run" to launch it.
 * Be sure you have your administrator info prepared, you will be asked during authorization. 
 * </p>
 *
 * <h3>Utilisation</h3>
 * <p>
 * The first argument is the file path to the configuration file.
 * The file's existence will be verified by the second argument.
 * The Consolehandler Class is instantiated with the third argument.
 * An instance of identity(datamodel) will be created. - Fourth argument 
 * The DAO method access to IdentityXML will be created. - Fifth argument
 * 
 * According to the displayed text, input the identity information needed to proceed. 
 * 
 * </p>
 *
 * @since 2018{version 1.8}
 * @author Qiaoyu Liu & Hao Xu
 *
 *         Authentication, Console, Main, Launcher, Java, Eclipse
 */

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.services.ConsoleHandler;
import fr.epita.iam.services.IdentityXMLDAO;
import fr.epita.iam.services.configuration.ConfigurationService;
import fr.epita.iam.services.dao.IdentityDAO;
import fr.epita.logger.Logger;

public class Main {

	/**
	 * @throws IdentitySearchException 
	 * @throws IdentityCreationException 
	 * @throws XPathExpressionException 
	 */
	public static void main(String[] args) throws IdentitySearchException, IdentityCreationException, XPathExpressionException {
			final String filePath = "src/conf.properties";
			final File file = new File(filePath);
			if (!file.exists()) {
				System.out.println("the configuration file does not exist");
			}
		 ConsoleHandler cs = new ConsoleHandler(System.in,System.out);
			Identity authidentity= new Identity();
			IdentityXMLDAO dao = new IdentityXMLDAO();
			//get user system input from console
			//get user system input from console
			System.out.println("your account please");
			authidentity.setDisplayName(cs.getString());
			System.out.println("your password please");
			authidentity.setPassword(cs.getString());
			//boolean switch 
			boolean au = dao.authentification(authidentity);
			if (au==false) return;
         cs.menu();
         cs.close();
		}
	}

