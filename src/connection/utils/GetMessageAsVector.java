/*******************************************************************************
 * Technical University of Crete
 * 
 * Thesis Project
 * 
 * Author:	Methenitis K. Georgios
 * 
 * Abstract  : Player Behavior and Team Strategy 
 * 			for the RoboCup 3D Simulation League
 * 
 * Date:  		July 2012
 ******************************************************************************/
package connection.utils;

import java.util.Vector;

public class GetMessageAsVector {

	public Vector<String> message = new Vector<String>();

	public GetMessageAsVector() {

	}

	public Vector<String> getMessage(String msg) {

		int length;
		length = msg.length();

		if (length != 0) {

			int start = 0;
			int end = 0;
			char[] valueOf;
			valueOf = msg.toCharArray();
			for (int i = 0; i < length + 1; i++) {

				if (i == length) {
					message.add("end");
				} else {

					if (valueOf[i] == '(') {
						start = i;

					} else if (valueOf[i] == '(' || valueOf[i] == ' '
							|| valueOf[i] == ')') {

						end = i;
						if (end > i - 1) {
							if (msg.substring(start + 1, end).equalsIgnoreCase(
									"")) {

							} else {
								message.add(msg.substring(start + 1, end));
							}

							start = end;
						}

					}

				}
			}

			return message;

		}
		return null;
	}

}
