/***********************************************************************************
 * 				  Copyright 2012, Technical University of Crete				       *
 * 							 Academic Year 2011-2012					           *
 ***********************************************************************************
 * 								Thesis Project								       *
 ***********************************************************************************
 * @author Methenitis Georgios													   *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League*
 * Start date: 25-04-2012														   *																	 
 * End date  : xx-xx-2012														   *																			   *
 ***********************************************************************************/
package perceptor;

public class Ball {

	private static boolean seeTheBall;
	private static float distance;
	private static float angleX;
	private static float angleY;

	public Ball(boolean seeTheBall, float distance, float angleX, float angleY) {

		seeTheBall = Ball.isSeeTheBall();
		distance = Ball.getDistance();
		angleX = Ball.getAngleX();
		angleY = Ball.getAngleY();

	}

	public static boolean isSeeTheBall() {
		return seeTheBall;
	}

	public static void setSeeTheBall(boolean seeTheBall) {
		Ball.seeTheBall = seeTheBall;
	}

	public static float getDistance() {
		return distance;
	}

	public static void setDistance(float distance) {
		Ball.distance = distance;
	}

	public static float getAngleX() {
		return angleX;
	}

	public static void setAngleX(float angleX) {
		Ball.angleX = angleX;
	}

	public static float getAngleY() {
		return angleY;
	}

	public static void setAngleY(float angleY) {
		Ball.angleY = angleY;
	}
	
	public static boolean isKickable(){
		if(HingeJointPerceptor.getHj1()<-15 && HingeJointPerceptor.getHj1()>-17){
			return true;
		}else{
			return false;
		}	
	}
	
}
