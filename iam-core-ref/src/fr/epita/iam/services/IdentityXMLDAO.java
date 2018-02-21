/**
 * This code is generated from the thoughts on Java Programming Lecture contributed by Prof.Thomas BROUSSARD
 * Code application : This class provides a DAO for project's XML functionality.
 * Compassionate :Create/update/delete/search identities within a XML standard.
 */
package fr.epita.iam.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.exceptions.IdentitySearchException;
import fr.epita.iam.services.configuration.ConfigurationService;
import fr.epita.iam.services.dao.IdentityDAO;
import fr.epita.logger.Logger;

/**
 * <h3>Description</h3>
 * <p>
 * This class provides a DAO method for project's XML functionality: create/update/delete/search identities within a XML file.
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used extensively as follows;
 * <pre>
 * <code>IdentityDAO dao_instance = new IdentityXMLDAO();</code>
 * <code>dao.create(new Identity(String displayname, String uid, String email));</code>
 * <code>List<Identity> identities = dao.search(new Identity(String displayname, String uid, String email));</code>
 * <code>dao.update(new Identity(String displayname, String uid, String email));</code>
 * <code>dao.delete(new Identity(String displayname, String uid, String email));</code>
 * </pre>
 * </p>
 *
 * @since 2018{version 1.0}
 * @see https://github.com/thomasbroussard?tab=repositories
 * @author Qiaoyu Liu	Hao Xu
 *
 *         Eclipse Oxygen, Java, Epita
 */
public class IdentityXMLDAO implements IdentityDAO {

	private static final XPathFactory xpathFactory = XPathFactory.newInstance();
	private static final XPath Xpath = xpathFactory.newXPath();
	private static final Logger LOGGER = new Logger(IdentityXMLDAO.class);
	private Document document;
	private static final ConfigurationService configuration = ConfigurationService.getInstance();
	/**
	 *
	 */
	public IdentityXMLDAO() {
		try {
			final File file = new File(configuration.getConfigurationValue("xml.file.path"));
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			final DocumentBuilder documentBuilder = dbf.newDocumentBuilder();

			if (file.exists()) {

				document = documentBuilder.parse(new FileInputStream(file));

			} else {
				document = documentBuilder.newDocument();

				document.appendChild(document.createElement("identities"));
			}
		} catch (SAXException | IOException | ParserConfigurationException e) {

			LOGGER.error("An error occured", e);
		}

	}
	@Override
	public void create(Identity identity,int i) throws IdentityCreationException{
		final Element root = document.getDocumentElement();
		final Element identityElement = getNewIdentityElt();
		identityElement.appendChild(getNewPropertyElmt("displayName", identity.getDisplayName()));
		identityElement.appendChild(getNewPropertyElmt("uid", identity.getUid()));
		identityElement.appendChild(getNewPropertyElmt("email", identity.getEmail()));
		if (i==0) {
		identityElement.appendChild(getNewPropertyElmt("password", identity.getPassword()));
		}
		root.appendChild(identityElement);
		writeToFile();
		}
	private Element getNewPropertyElmt(String propertyName, String propertyValue) {
		final Element identityProperty = getNewPropertyElt();
		identityProperty.setAttribute("name", propertyName);
		identityProperty.setTextContent(propertyValue);
		return identityProperty;
	}

	private Element getNewIdentityElt() {
		return document.createElement(configuration.getConfigurationValue("IDENTITY"));
	}



	private Element getNewPropertyElt() {
		return document.createElement(configuration.getConfigurationValue("PROPERTY"));
	}

	private String documentToString() {
		String output = "";
		try {
			final TransformerFactory tf = TransformerFactory.newInstance();
			final Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			final StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			output = writer.getBuffer().toString().replaceAll("\n|\r", "");
		} catch (final Exception e) {
			LOGGER.error("got a problem while transforming document to string", e);
		}
		return output;
	}

	private void writeToFile() {
		final String xmlFilePath = ConfigurationService.getInstance().getConfigurationValue("xml.file.path");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(xmlFilePath), true);
			writer.println(documentToString());
		} catch (final FileNotFoundException e) {

			LOGGER.error("An error occured", e);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public boolean authentification(Identity identity) throws XPathExpressionException {
		XPathFactory xpathF = XPathFactory.newInstance();
	    XPath xpath = xpathF.newXPath();  
		final String pwd = "/identities/identity[./property[@name='displayName']/text() = '" + identity.getDisplayName()
		+ "']/property[@name='password']/text()";
		Node node =(Node) xpath.evaluate(pwd,document, XPathConstants.NODE);
		if (node == null) {
			System.out.println("authentification fails");
			return false;
		}
	    String npassword =node.getNodeValue();
	if (identity.getPassword()!=npassword && identity.getPassword()==null ) {
		System.out.println("authentification fails");
		return false;
	}
	else return true;
	}
	
	@Override
	public void update(Identity identityoriginal,Identity identityupdate,int search) {
		try {
					final String expression = "/identities/identity[./property[@name='displayName']/text() = '" + identityoriginal.getDisplayName()
							+ "']";
						Node node;
						node = (Node) Xpath.evaluate(expression,document, XPathConstants.NODE);
						if (node instanceof Element) {
				 final Element identityElement = (Element) node;
			final NodeList propertiesList = identityElement.getElementsByTagName(configuration.getConfigurationValue("PROPERTY"));
			if (search==0) {
			 propertiesList.item(0).getFirstChild().setNodeValue(identityupdate.getDisplayName());
			 propertiesList.item(1).getFirstChild().setNodeValue(identityupdate.getUid());
			 propertiesList.item(2).getFirstChild().setNodeValue(identityupdate.getEmail());
			 propertiesList.item(3).getFirstChild().setNodeValue(identityupdate.getPassword());
			}
			else {
				 propertiesList.item(0).getFirstChild().setNodeValue(identityupdate.getDisplayName());
				 propertiesList.item(1).getFirstChild().setNodeValue(identityupdate.getUid());
				 propertiesList.item(2).getFirstChild().setNodeValue(identityupdate.getEmail());
				}
				}
			 writeToFile();
		} catch (XPathExpressionException e) {
			LOGGER.error("An error occured", e);
		}
	}
	
	public void delete(List<Identity> list,int delete,int index) {
		   XPathFactory xpathF = XPathFactory.newInstance();  
		    XPath xpath = xpathF.newXPath();  
		    index=index-1;
		try {
			if (delete==0) {
				for (int i = 0; i < list.size(); i++)
				{
					final String expression = "/identities/identity[./property[@name='displayName']/text() = '" + list.get(i).getDisplayName()
					+ "']";
				Node node;
				node = (Node) xpath.evaluate(expression,document, XPathConstants.NODE);
				node.getParentNode().removeChild(node);
			}
			writeToFile();
			return;
			}
			else {
				final String expression = "/identities/identity[./property[@name='displayName']/text() = '" + list.get(index).getDisplayName()
				+ "']";
			Node node;
			node = (Node) xpath.evaluate(expression,document, XPathConstants.NODE);
			node.getParentNode().removeChild(node);
				writeToFile();
				return;
			}
		} catch (XPathExpressionException e) {
			LOGGER.error("An error occured", e);
		}
	}

	private List<Element> evaluateXpathAsList(Node relativeParent, String xpath) {
		final List<Element> elements = new ArrayList<>();
		XPathExpression xPathExpression;
		try {
			xPathExpression = Xpath.compile(xpath);
			final NodeList results = (NodeList) xPathExpression.evaluate(relativeParent, XPathConstants.NODESET);
			final int length = results.getLength();
			for (int i = 0; i < length; i++) {
				final Node item = results.item(i);
				if (item instanceof Element) {
					elements.add((Element) item);
				}
			}
		} catch (final XPathExpressionException e) {
			LOGGER.error("An error occured", e);
		}
		return elements;
	}

	private String evaluateXpathAsString(Node relativeParent, String xpath) {
		XPathExpression xPathExpression;
		try {
			xPathExpression = Xpath.compile(xpath);
			return (String) xPathExpression.evaluate(relativeParent, XPathConstants.STRING);

		} catch (final XPathExpressionException e) {
			LOGGER.error("An error occured", e);
		}
		return "";
	}
	@Override

	
	public List<Identity> search(Identity criteria,int i) throws IdentitySearchException, XPathExpressionException {
		final List<Identity> identities = new ArrayList<>();
		final String expression = "/identities/identity[starts-with(./property[@name='displayName']/text() , '" + criteria.getDisplayName()
		+ "')]";
		final List<Element> identitiesAsElement = evaluateXpathAsList(document, expression);
		for (final Element element : identitiesAsElement) {
			final Identity identity = new Identity();
			identity.setDisplayName(evaluateXpathAsString(element, configuration.getConfigurationValue("PROPERTY_NAME_DISPLAY_NAME_TEXT")));
			identity.setEmail(evaluateXpathAsString(element, configuration.getConfigurationValue("PROPERTY_NAME_EMAIL_TEXT")));
			identity.setUid(evaluateXpathAsString(element, configuration.getConfigurationValue("PROPERTY_NAME_UID_TEXT")));
			final String pwd = "/identities/identity[./property[@name='displayName']/text() = '" + identity.getDisplayName()
			+ "']/property[@name='password']/text()";
			Node node =(Node) Xpath.evaluate(pwd,document, XPathConstants.NODE);
			switch (i) {
			case 1:
			if (node==null) identities.add(identity);
			break;
			case 0:
			if (node!=null) {
				identity.setPassword(evaluateXpathAsString(element, configuration.getConfigurationValue("PROPERTY_NAME_PASSWORD_TEXT")));
				identities.add(identity);
			}
			break;
			default:
				identities.add(identity);	
		}
		}
		return identities;
	}
}