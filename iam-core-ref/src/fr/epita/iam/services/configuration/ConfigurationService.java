/**
 * This code is generated from the thoughts on Java Programming Lecture contributed by Prof.Thomas BROUSSARD
 * Code application : This is a service class for configuration. *Connection to config properties should be 
 * set here.
 * Compassionate :Properties
 */
package fr.epita.iam.services.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <h3>Description</h3>
 * <p>This class transform usage of configuration as a service class.
 * it can check file-path to valid properties.</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>ConfigurationService instance = new ConfigurationService(String Path);</code></pre>
 * </p>
 *
 * @since $${1.0}
 * @see https://github.com/thomasbroussard/2017s2_fundamental_a/blob/master/iam-core-ref/src/fr/epita/iam/services/configuration/ConfigurationService.java
 * @author Qiaoyu Liu & Hao Xu
 *
 */
public class ConfigurationService {

	private Properties properties;

	private static ConfigurationService instance;

	private ConfigurationService(String filePathToConfiguration) {
		try {
			properties = new Properties();
			properties.load(new FileInputStream(new File(filePathToConfiguration)));
		} catch (final IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static ConfigurationService getInstance() {
		if (instance == null) {
			instance = new ConfigurationService("src/conf.properties");
		}
		return instance;
	}
	//return property by key
	public String getConfigurationValue(String propertyKey) {
		return properties.getProperty(propertyKey);
	}

}
