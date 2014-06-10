import java.net.*;
import java.io.*;

/**
 * A class that provides a main function to read five lines of a commercial Web
 * page and print them in reverse order, given the name of a company.
 */

class Hwk01 {

	/**
	 * Prompts the user for the name X of a company (a single string), opens the
	 * Web site corresponding to www.X.com, and prints the first five lines of
	 * the Web page in reverse order.
	 * 
	 * @param arg
	 *            is not used.
	 * @exception Exception
	 *                thrown if there are any problems parsing the user's input
	 *                or opening the connection.
	 */
	public static void main(String[] arg) throws Exception {

		BufferedReader keyboard;
		String inputLine;

		keyboard = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Please enter the name of a company (without spaces): ");
		System.out.flush(); /* Make sure the line is printed immediately. */
		inputLine = keyboard.readLine();

		Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://www." + inputLine
						+ ".com");

		URL u;
		InputStream is = null;
		DataInputStream dis;
		String s;
		int counter = 0;

		u = new URL("http://www." + inputLine + ".com");
		is = u.openStream();
		dis = new DataInputStream(new BufferedInputStream(is));
		String[] a = new String[5];

		for (int i = 0; i < 5; i++) {
			a[i] = dis.readLine();
		}
		for (int j = 4; j >= 0; j--) {
			System.out.println(a[j]);
		}

	}
}
