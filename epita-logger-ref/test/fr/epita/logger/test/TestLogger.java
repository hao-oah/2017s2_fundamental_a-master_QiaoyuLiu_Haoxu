/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.logger.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import fr.epita.logger.Logger;

/**
 * <h3>Description</h3>
 * <p>
 * This class allows to ...
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used as follows:
 *
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class TestLogger {

	private static final Logger logger = new Logger(TestLogger.class);

	public static void main(String[] args) throws FileNotFoundException {
		// given / when
		logger.error("first error");

		// then
		final String pathname = "/tmp/application.log";
		final File file = new File(pathname);
		if (file.exists()) {
			System.out.println("file exists");
			final Scanner scanner = new Scanner(file);

			while (scanner.hasNext()) {
				final String nextLine = scanner.nextLine();
				System.out.println(nextLine);
				if (nextLine.contains("first error")) {
					System.out.println("success");
				} else {
					System.out.println("error");
				}
			}
			scanner.close();
		}

	}

}
