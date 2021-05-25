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

abstract class Bee extends ReLogoTurtle {
	def carriedHoney = 0
	def collectedHoney = 0
	def update = 0
	def power = 300
	def currentTask = "searching"
	def vision = 3
	def powerusage = 1
	def randomSearching = 0
	def coverage = 0
	def flowers = new LinkedHashSet<ReLogoPatch>()
	def arrivedFlowers = new LinkedHashSet<ReLogoPatch>()
	def emptyFlowers = new LinkedHashSet<ReLogoPatch>()
    
	def abstract step() 
	
	def setVision(int vision) {
		this.vision = vision
	}
}
