package test;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.ConsoleHandler;
import fr.epita.iam.services.IdentityXMLDAO;

public class testinteger {
	public static void main(String[] args) {
ConsoleHandler cs = new ConsoleHandler(System.in, System.out);
IdentityXMLDAO dao=new IdentityXMLDAO();
System.out.println("test");
System.out.println(cs.getInteger());
System.out.println(cs.getString());
	}
}
