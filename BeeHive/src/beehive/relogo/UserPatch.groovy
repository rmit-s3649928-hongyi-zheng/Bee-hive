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
import beehive.ReLogoTurtle

class UserPatch extends ReLogoPatch{

	def flowers = new LinkedHashSet<ReLogoPatch>()
	def emptyFlowers = new LinkedHashSet<ReLogoPatch>()
	def arrivedBees = new LinkedHashSet<ReLogoTurtle>()
	
    @Diffusible
	double honey = 0
	double level = 0
	double arrivals = 0
    
	
	def recolorPatch(){
		if(level == 0) {
			flowers = new LinkedHashSet<ReLogoPatch>()
			emptyFlowers = new LinkedHashSet<ReLogoPatch>()
		}
		else {
			level--
		}
		
		if(honey != 0) {
			setPcolor(scaleColor(105,honey,0,12))
		}
		if(level > 0) {
			setPcolor(scaleColor(yellow(),level,0,40))
		}
		if(honey == 0) {
			setPcolor(10)
		}
	}
	
	def setLevel(int level) {
		this.level = level
	}
	
	
}