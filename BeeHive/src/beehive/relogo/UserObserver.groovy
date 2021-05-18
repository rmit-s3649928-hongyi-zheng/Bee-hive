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
			if(communicationType == "Passive Action Recognizition") {
				setDefaultShape(PassiveActionBee,"turtle")
				createPassiveActionBees(numBees){
					setxy (0, 0)
				}
	            ask(passiveActionBees()){
					setVision(insectVision)
				}
				for (bee in passiveActionBees()) {
					createFollowers(numFollowers){
						setxy(0,0)
					}
					ask(followers()){
						if(leader == null) {
							setLeader(bee)
						}
					}
				}
			}
			else if(communicationType == "Implicit Communication") {
				setDefaultShape(ImplicitBee,"turtle")
				createImplicitBees(numBees){
					setxy (0, 0)
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
			for(bee in bees()){
				bee.step()
			}
			ask(patches()){
				recolorPatch()
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
			if(collectedHoney() == 100) {
				stop()
			}
		}

		def collectedHoney(){
		    patch(0,0).honey
		 }
			
}