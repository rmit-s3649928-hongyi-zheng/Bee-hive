package beehive.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import beehive.ReLogoPatch
import beehive.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class PassiveActionBee extends Bee {
	 
	 def step()
	{   
		
		if(power > 0) { 
			power -= powerusage	
			
			
			for(bee in passiveActionBees()) {
				if(!bee.equals(this)) {
					if(this.distance(bee) < vision) {
						if((bee.flowers != this.flowers) || (bee.emptyFlowers != this.emptyFlowers)){
							update++
						}
						for(flower in this.flowers) {
							if(!bee.emptyFlowers.contains(flower)) {
								if(!bee.flowers.contains(flower)) {
									bee.flowers.add(flower)
								}
							}
						}
						for(flower in bee.flowers) {
							if(!this.emptyFlowers.contains(flower)) {
								if(!this.flowers.contains(flower)) {
									this.flowers.add(flower)
								}
							}
						}
						for(flower in this.emptyFlowers) {
							if(bee.flowers.contains(flower)) {
								bee.flowers.remove(flower)
								bee.emptyFlowers.add(flower)
							}
						}
						for(flower in bee.emptyFlowers) {
							if(this.flowers.contains(flower)) {
								this.flowers.remove(flower)
								this.emptyFlowers.add(flower)
							}
						}
					}
				}
			}
			
			
			if(currentTask == "searching") {
				
				if(flowers.size() == 0){
				    def found = false
					for(patchInVision in inRadius(patches(),vision)) {
						if(patchInVision.honey > 0) {
							if(patchInVision.distance(patch(0,0)) > 1) {
								found = true
								flowers.add(patchInVision)
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
				}
				else {
					def dis = 1000
					def currentFlower = null
					for(flower in flowers) {
						if(distance(flower) < dis) {
							dis = distance(flower)
							currentFlower = flower
						}
					}
					if(distance(currentFlower) < vision) {
						if(currentFlower.honey == 0) {
							flowers.remove(currentFlower)
							emptyFlowers.add(currentFlower)
						}
					}
					face(currentFlower)
				}
				
				forward(1)
				if(patchHere().honey > 0) {
					if(patchHere().distance(patch(0,0)) > 1) {
						currentTask = "collect"
					}
				}
			}
			else if(currentTask == "collect") {
				if(patchHere().honey > 0) {
					carriedHoney += 1
					collectedHoney += 1
					patchHere().honey -= 1
					if (!(this in patchHere().arrivedBees)) {
						patchHere().arrivedBees.add(this)
						patchHere().arrivals++
					}
					if(!(patchHere() in this.arrivedFlowers)) {
						arrivedFlowers.add(patchHere())
						coverage++
					}
					currentTask = "return"
				}
				else {
					flowers.remove(patchHere())
					emptyFlowers.add(patchHere())
					currentTask = "searching"
				}
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
	
		
		
}
					

