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

            def num = 0
			while(num < 10) {
				def x = randomPxcor()
				def y = randomPycor()
				if(!(patch(x,y) in closePatches)) {
					patch(x,y).honey = 10
					num ++
				}


			}
			ask(patches()){
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