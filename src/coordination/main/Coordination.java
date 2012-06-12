/**
 * 
 */
package coordination.main;

import java.util.Vector;

import coordination.communication.CoordinationMessage;

/***********************************************************************************
 * Copyright 2012, Technical University of Crete Academic Year 2011-2012
 * 
 * Thesis Project
 * 
 * @author Methenitis Georgios Student ID:2006030085
 * 
 *         Abstract: Player Behavior and Team Strategy for the RoboCup 3D
 *         Simulation League Start date: 25-04-2012 End date : xx-xx-2012
 ***********************************************************************************/
public class Coordination {

	/*
	 * Here is the main coordination function, coordination administrator
	 * calculates the actions which maximize team reward
	 */

	public static void MakeCoordination(
			Vector<CoordinationMessage> coordinationVector) {

		long timeStart = System.currentTimeMillis();
		/*
		 * Admin agent updates his belief for the position of the ball and the
		 * players' position
		 */

		CoordinationBeliefs.UpdateBeliefs(coordinationVector);
		System.out.println("Beliefs updated");
		
		/*
		 * Main coordination function. This function is called 
		 * in order to find actions for all agents which going
		 * to cost a minimum value. 
		 */
		
		CoordinateFunction.Calculate(coordinationVector);
		System.out.println("Coordination completed");

		long timeEnd = System.currentTimeMillis();
		
		long time = timeEnd - timeStart;
	
		System.out.println("time: "+time+" s");

	}

}
