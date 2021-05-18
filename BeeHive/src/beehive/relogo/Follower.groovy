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

class Follower extends PassiveActionBee {
	def leader = null
	def currentTask = "following"
	def carriedHoney = 0
	def collectedHoney = 0
	
	def setLeader(ReLogoTurtle leader) {
		this.leader = leader
	}
	
	def step() {
		setColor(45)
		if(currentTask == "following") {
			face(leader)
			fd(1)
			if(patchHere().honey > 0) {
				if(patchHere().distance(patch(0,0)) > 1) {
					carriedHoney += 1
					collectedHoney += 1
					patchHere().honey -= 1
				}
			}
			if(distancexy(0,0) < 1) {
				patch(0,0).honey += carriedHoney
				carriedHoney = 0
			}
		}
	}

}
