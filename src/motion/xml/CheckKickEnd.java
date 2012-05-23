package motion.xml;

import behavior.fsm.GKBstates;

public class CheckKickEnd {

	public static boolean Check(){

		if(MotionPlaying.getMotionPhase()!=null){
			
			if(MotionPlaying.getMotionPhase().equalsIgnoreCase("rigth_front_front_kick4")){

				GKBstates.setState("GoToBall");
				return true;

			}
			
		}


		return false;


	}

}