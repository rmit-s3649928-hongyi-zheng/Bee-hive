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

class Bee extends ReLogoTurtle {
	 def carriedHoney = 0
	 def collectedHoney = 0
	 def power = 1000
	 def currentTask = "searching"
	 def vision = 3
	 def powerusage = 1
	 def flowers = new LinkedHashSet<ReLogoPatch>()
	 def emptyFlowers = new LinkedHashSet<ReLogoPatch>()
	 def step()
	{   
		setColor(15)
		if(power > 0) { 
			power -= powerusage
			def found = false
			for(bee in bees()) {
				if(!bee.equals(this)) {
					if(this.distance(bee) < vision) {
						for(flower in this.flowers) {
							if(!bee.flowers.contains(flower)) {
								bee.flowers.add(flower)
							}
						}
						for(flower in bee.flowers) {
							if(!this.flowers.contains(flower)) {
								this.flowers.add(flower)
							}
						}
						for(flower in this.emptyFlowers) {
							if(bee.flowers.contains(flower)) {
								bee.flowers.remove(flower)
							}
						}
						for(flower in bee.emptyFlowers) {
							if(this.flowers.contains(flower)) {
								this.flowers.remove(flower)
							}
						}
					}
				}
			}
			
			
			if(currentTask == "searching") {
				if(flowers.size() == 0){
					if(random(2))
						left(random(60))
					else
						left(-1*random(60))
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
					face(currentFlower)	
					if(distance(currentFlower) < vision) {
						if(currentFlower.honey == 0)
							flowers.remove(currentFlower)
							emptyFlowers.add(currentFlower)
					}
				}
				for(patchInVision in inRadius(patches(),vision)) {
					if(patchInVision.honey > 0) {
						if(patchInVision.distance(patch(0,0)) > 1) {
							flowers.add(patchHere())
							face(patchInVision)
							break
						}
					}
					
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
	
	def setVision(int vision) {
		this.vision = vision
	}
		
		
}
					

