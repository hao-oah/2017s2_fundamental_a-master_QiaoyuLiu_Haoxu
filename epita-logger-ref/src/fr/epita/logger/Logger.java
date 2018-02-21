/**
 * This code is generated from the thoughts on Java Programming Lecture contributed by Prof.Thomas BROUSSARD
 * Code application : This class provides a log trace for diagnostic purposes.
 * Compassionate :Set log path/format log.
 */
package fr.epita.logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.epita.iam.services.Configuration;

/**
 * <h3>Description</h3>
 * <p>
 * This class allows implemented classes to print to console or workspace running exceptions time-wise. Without stopping
 * the whole program. 
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used as follows:
 *
 * <pre>
 * <p>initiation</p>
 * <code>Logger logger_instance = new Logger(class_object);</code>
 * <p>implementation</p>
 * <code>logger_instance.error(String msg, Exception e); error message flag</code>
 * </pre>
 * </p>
 *
 * @since $${1.0}
 * @see https://github.com/thomasbroussard/2017s2_fundamental_a/tree/master/epita-logger-ref
 * @author Qiaoyu Liu & Hao Xu
 *
 * Logger Diagnostic Class Java Eclipse
 */
public class Logger {

	private static final String logPath = "/tmp/application.log";
	private static PrintWriter pw;

	private static final String ERROR = "ERROR";
	private static final String INFO = "INFO";

	static {
		try {
			pw = new PrintWriter(new FileOutputStream(new File(logPath), true));
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private void printMessage(String message, String Level) {
		final String completeMessage = getTimeStamp() + " - " + Level + " - " + cls.getCanonicalName() + " " + message;
		pw.println(completeMessage);
		pw.flush();
	}

	private static String getTimeStamp() {
		final Date date = new Date();

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		return sdf.format(date);
	}

	public void error(String message, Exception e) {
		printMessage(message, ERROR);
		e.printStackTrace(pw);
		pw.flush();
	}

}
