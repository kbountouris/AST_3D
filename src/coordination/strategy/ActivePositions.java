/***********************************************************************************
 * Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/
package coordination.strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import agent.constraints.Constraints;
import coordination.main.CoordinationBeliefs;

public class ActivePositions {

	public static Vector<Coordinate> ActivePositions = new Vector<Coordinate>();

	public static void Calculate() {

		ActivePositions.removeAllElements();

		Vector<Coordinate> ActivePositionsTemp = new Vector<Coordinate>();

		float distance;
		float Theta = 0;


		if(CoordinationBeliefs.Ball.X >=0){

			distance = 2;
			Theta = (float) TriangleLocalization.FindAngleBetweenCoordinates(CoordinationBeliefs.Ball, Constraints.OpponentGoal);
			for (int i = 0; i < 11; i++) {

				Theta += 30;
				Coordinate a = TriangleLocalization.get_det_with_distance_angle(
						CoordinationBeliefs.Ball.X, CoordinationBeliefs.Ball.Y,
						Theta, (distance));

				if (ProperSupportPosition(a)) {

					ActivePositionsTemp.add(a);

				}
			}
			
			distance = 3.5f;
			Theta = (float) TriangleLocalization.FindAngleBetweenCoordinates(CoordinationBeliefs.Ball, Constraints.OpponentGoal);
			for (int i = 0; i < 17; i++) {

				Theta += 20;
				Coordinate a = TriangleLocalization.get_det_with_distance_angle(
						CoordinationBeliefs.Ball.X, CoordinationBeliefs.Ball.Y,
						Theta, (distance));
				

				if (ProperSupportPosition(a)) {

					ActivePositionsTemp.add(a);

				}
			}

			distance = 5;
			Theta = (float) TriangleLocalization.FindAngleBetweenCoordinates(CoordinationBeliefs.Ball, Constraints.OpponentGoal);
			for (int i = 0; i < 17; i++) {

				Theta += 20;
				Coordinate a = TriangleLocalization.get_det_with_distance_angle(
						CoordinationBeliefs.Ball.X, CoordinationBeliefs.Ball.Y,
						Theta, (distance));
				

				if (ProperSupportPosition(a)) {

					ActivePositionsTemp.add(a);

				}
			}

		}else{
			
			distance = 2;
			Theta = (float) TriangleLocalization.FindAngleBetweenCoordinates(CoordinationBeliefs.Ball, Constraints.OpponentGoal);
			
			for (int i = 0; i < 11; i++) {

				Theta += 30;

				Coordinate a = TriangleLocalization.get_det_with_distance_angle(
						CoordinationBeliefs.Ball.X, CoordinationBeliefs.Ball.Y,
						Theta, (distance));

				if (ProperSupportPosition(a)) {

					ActivePositionsTemp.add(a);

				}
			}
	
		}


		final Comparator<Coordinate> POSITIVE_ORDER = new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate e1, Coordinate e2) {
				boolean Cmp = SoccerFieldCoordinateValue.Calculate(e1) >= SoccerFieldCoordinateValue
						.Calculate(e2);
				if (Cmp != true) {
					return 1;
				} else {
					return 0;
				}
			}
		};

		final Comparator<Coordinate> NEGATIVE_ORDER = new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate e1, Coordinate e2) {
				boolean Cmp = SoccerFieldCoordinateValue.Calculate(e1) <= SoccerFieldCoordinateValue
						.Calculate(e2);
				if (Cmp != true) {
					return 1;
				} else {
					return 0;
				}
			}
		};

		// sort ActivePositions
		if (CoordinationBeliefs.Ball.X >= 0) {
			Collections.sort(ActivePositionsTemp, POSITIVE_ORDER);
		} else {
			Collections.sort(ActivePositionsTemp, NEGATIVE_ORDER);
		}


		for (int i = 0; i < ActivePositionsTemp.size(); i++) {

			if(i<9){
				
				ActivePositions.add(ActivePositionsTemp.elementAt(i));
	
			}else{

				ActivePositionsTemp.removeAllElements();
				break;
				
			}

		}

	}

	public static boolean ProperSupportPosition(Coordinate spot) {

		if ((Math.abs(spot.X) < ((Constraints.FieldLength / 2) - 1))
				&& (Math.abs(spot.Y) < (Constraints.FieldWidth / 2) - 0.5)) {

			return true;

		}

		return false;

	}

}