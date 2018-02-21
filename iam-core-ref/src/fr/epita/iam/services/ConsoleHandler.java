/**
 * Code application : This class provides a console handling procedure.
 * Compassionate :system read and write throughput of the project.
 */
package fr.epita.iam.services;
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.services.dao.IdentityDAO;


/** 
 * <h3>Description</h3>  
 * <p>This class allows user to console-access administrator functionality</p>
 * <p>Relevant exceptions are handled within this class</p>
 *
 * <h3>Utilisation</h3>
 * <p>This class is designed to be accessed by Main.java Only
 *   <pre><code>ConsoleHandler consolehandler_instance = new ConsoleHandler(System.in,System.out);</code></pre>
 * </p>
 *  
 * @since $${1.1}
 * @see Voir aussi $${link}
 * @author Qiaoyu Liu & Hao Xu
 *
 * 
 */
	public class ConsoleHandler {
		private IdentityDAO dao = new IdentityXMLDAO();
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
		//integer as option(s) prefix 
		public int getInteger() {
			int a = 0;
			try{a = Integer.parseInt(scanner.nextLine());}
			catch(NumberFormatException e) {
				System.out.println("please input an integer");
				a=getInteger();
			}
			return a;
				} 

		public  String getString() {
			String s = scanner.nextLine();
			if (s.equals("")) {
				System.out.println("Don't leave if blank");
				s=getString();
			}
			return s;
		}
		//authentication
		public int ifvalidindex(int length,int i) {
			ConsoleHandler cs = new ConsoleHandler(System.in,System.out);
			int k =cs.getInteger();
			if(i==0) {
			if (k>length || k==0) {
				System.out.println("please choose a valide number");
				ifvalidindex(length,i);
			}
			}
			else if (k>length) {
				System.out.println("please choose a valide number");
				ifvalidindex(length,i);
			}
			return k;
		}

		public String ifnameexist() throws IdentitySearchException, XPathExpressionException{
			ConsoleHandler cs = new ConsoleHandler(System.in,System.out);
			String name =cs.getString();
        	final IdentityDAO dao = new IdentityXMLDAO();
    		final List<Identity> list = dao.search(new Identity(name,null,null,null),9);
    		if (!list.isEmpty()) {
    			System.out.println("this name is used,please set another displayname");
    			ifnameexist();
    		}
    		return (name);
		}
		
		
		public void menu() throws IdentitySearchException, IdentityCreationException, XPathExpressionException {
			ConsoleHandler cs = new ConsoleHandler(System.in,System.out);
            System.out.println("please choose :1.create an account 2.search an account 3.exit");
            int i = cs.getInteger();
        switch (i) {
        case 1:
        	System.out.println("please choose : 0.create an administrator account \n"
        			+ "other number.create a normal account");
        	int k = cs.getInteger();
        	Identity identity = new Identity();
        	System.out.println("please set your displayname");
        	identity.setDisplayName(cs.ifnameexist());
        	System.out.println("please set your uid");
        	identity.setUid(cs.getString());
        	System.out.println("please set your email");
        	identity.setEmail(cs.getString());
        	if (k==0) {
        		System.out.println("please set your password");
            	identity.setPassword(cs.getString());
        	}
        	dao.create(identity,k);
        	
        	menu();
        	break;
        case 2:
        	Identity identitysearch = new Identity();
        	System.out.println("please choose:0.search an administrator account 1.search an normal account\n"
        			+ "if you want to search them all, please input anyother number");
        	int search = cs.getInteger();
        	System.out.println("please input the displayname");
        	identitysearch.setDisplayName(cs.getString());
        	final List<Identity> list = dao.search(identitysearch,search);
        	int length=list.size();
        	if (list.isEmpty()) {
    			System.out.println("no such an account");
    			menu();
    		} else {
    			System.out.println(list);
    			menu2(list,length,search);
    		}
        	break;
        case 3:
        	break;
        default:
        	System.out.print("please select from 1 ,2,3");
        	menu();
        }
        cs.close();
        return;
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
		 * @param list 
		 * @param search 
		 * @return 
		 * @throws IdentitySearchException 
		 * @throws IdentityCreationException 
		 * @throws XPathExpressionException 
		 */
		private void menu2(List<Identity> list,int length, int search) throws IdentitySearchException, IdentityCreationException, XPathExpressionException {
		ConsoleHandler cs = new ConsoleHandler(System.in,System.out);
		System.out.println("please choose :1.delete 2.update 3.exit");
		int k = cs.getInteger();
		switch (k) {
		case 1:
			System.out.println("which one do you want to delete,please tell me the number(example:the number of the first one is 1).If you want to delete them all please input 0");
			int delete=cs.ifvalidindex(length,1);
		dao.delete(list,delete,k);
		menu();
		break;
		case 2:
			System.out.println("which one do you want to update,please tell me the number(example:the number of the first one is 1)");
			int update=cs.ifvalidindex(length,0);
			update=update-1;
			Identity identityupdate = new Identity();
        	System.out.println("please input the displayname");
        	identityupdate.setDisplayName(cs.getString());
        	System.out.println("please input the uid");
        	identityupdate.setUid(cs.getString());
        	System.out.println("please input the email");
        	identityupdate.setEmail(cs.getString());
        	if(search==0) {
        	System.out.println("please input the password");
        	identityupdate.setPassword(cs.getString());
        	}
        	dao.update(list.get(update),identityupdate,search);
        	menu();
        	break;
		case 3:
			menu();
			break;
		default:
			System.out.print("please select from 1,2,3");
        	menu2(list,length,search);
		}
		cs.close();
		return;
		}
		public void close() {
			this.scanner.close();
			this.printWriter.close();
		}
}
