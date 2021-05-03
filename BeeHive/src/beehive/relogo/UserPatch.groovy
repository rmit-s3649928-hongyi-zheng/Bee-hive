package beehive.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import beehive.ReLogoPatch;

class UserPatch extends ReLogoPatch{

	
	
    @Diffusible
	double honey = 0
	
	def recolorPatch(){
			setPcolor(scaleColor(105,honey,0,12))
	}
	
	
}