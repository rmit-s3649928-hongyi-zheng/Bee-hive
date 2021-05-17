package beehive.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import beehive.ReLogoObserver;


class UserObserver extends ReLogoObserver{


		@Setup
		def setup(){
			clearAll()
			setDefaultShape(Bee,"turtle")
			createBees(numBees){
				setxy (0, 0)
			}
            ask(bees()){
				setVision(insectVision)
			}
			for (bee in bees()) {
				createFollowers(numFollowers){
					setxy(0,0)
				}
				ask(followers()){
					if(leader == null) {
						setLeader(bee)
					}
				}
			}

			def closePatches = patch(0,0).inRadius(patches(), 10)
			def distancePatches = patches()
			for(p in closePatches) {
				p.other(distancePatches)
			}
			def P = nOf(10,distancePatches) 
			ask(P){
				honey = 10
				recolorPatch()
			}
			
		}

	
		@Go
		def go(){
			ask(followers()){
				step()
			}
			ask(bees()){
				step()
			}
			ask(patches()){
				setPcolor(scaleColor(105,honey,0,12))
			}
			def noPower = true
			for (bee in bees()) {
				if (bee.power>0) {
					noPower = false
				}
			}
			if(noPower == true) {
				stop()
			}
		}

		def collectedHoney(){
		    patch(0,0).honey
		 }
			
}