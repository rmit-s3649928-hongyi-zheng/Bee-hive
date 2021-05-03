package beehive.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import beehive.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class Bee extends ReLogoTurtle {
	 def carriedHoney = 0
	 def collectedHoney = 0
	 def currentTask = "searching"
	 def step()
	{
		def found = false
		if(currentTask == "searching") {
			for(patchInVision in inRadius(patches(),1)) {
				if(patchInVision.honey > 0) {
					if(patchInVision.distance(patch(0,0)) > 1) {
						found = true
						face(patchInVision)
						break
					}
				}
				
			}
			if(found == false) {
				if(random(2))
					left(random(60))
				else
					left(-1*random(60))
			}
			forward(1)
			if(patchHere().honey > 0) {
				if(patchHere().distance(patch(0,0)) > 1) {
					currentTask = "collect"
				}
			}
		}
		else if(currentTask == "collect") {
			carriedHoney += 1
			collectedHoney += 1
			patchHere().honey -= 1
			currentTask = "return"
		}
		else if(currentTask == "return") {
			facexy(0,0)
			forward(1)
		    if(distancexy(0,0) < 1) {
				patch(0,0).honey += carriedHoney
				carriedHoney = 0
				currentTask = "searching"
			}	
		}
		}
		
		
}
					

