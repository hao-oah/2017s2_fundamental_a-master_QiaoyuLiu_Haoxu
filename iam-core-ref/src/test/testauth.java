package test;

import javax.xml.xpath.XPathExpressionException;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.IdentityXMLDAO;

public class testauth {
	public static void main(String[] args) throws XPathExpressionException {
		IdentityXMLDAO cs=new IdentityXMLDAO();
		Identity id = new Identity("aaaaaaaaaaaaaaa","0","0","null");
		boolean i=cs.authentification(id);
		System.out.println(i);
	}
}
