package beehive;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoObserver extends BaseObserver{

	/**
	 * Makes a number of randomly oriented bees and then executes a set of commands on the
	 * created bees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created bees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> createBees(int number, Closure closure) {
		AgentSet<beehive.relogo.Bee> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Bee");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.Bee){
				result.add((beehive.relogo.Bee)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented bees and then executes a set of commands on the
	 * created bees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created bees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> createBees(int number) {
		return createBees(number,null);
	}

	/**
	 * Makes a number of uniformly fanned bees and then executes a set of commands on the
	 * created bees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created bees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> createOrderedBees(int number, Closure closure) {
		AgentSet<beehive.relogo.Bee> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Bee");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.Bee){
				result.add((beehive.relogo.Bee)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned bees and then executes a set of commands on the
	 * created bees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created bees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> createOrderedBees(int number) {
		return createOrderedBees(number,null);
	}

	/**
	 * Queries if object is a bee.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a bee
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public boolean isBeeQ(Object o){
		return (o instanceof beehive.relogo.Bee);
	}

	/**
	 * Returns an agentset containing all bees.
	 * 
	 * @return agentset of all bees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> bees(){
		AgentSet<beehive.relogo.Bee> a = new AgentSet<beehive.relogo.Bee>();
		for (Object e : this.getContext().getObjects(beehive.relogo.Bee.class)) {
			if (e instanceof beehive.relogo.Bee){
				a.add((beehive.relogo.Bee)e);
			}
		}
		return a;
	}

	/**
	 * Returns the bee with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public beehive.relogo.Bee bee(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof beehive.relogo.Bee)
			return (beehive.relogo.Bee) turtle;
		return null;
	}

	/**
	 * Returns an agentset of bees on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of bees on patch p
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> beesOn(Patch p){
		AgentSet<beehive.relogo.Bee> result = new AgentSet<beehive.relogo.Bee>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"bee")){
			if (t instanceof beehive.relogo.Bee)
			result.add((beehive.relogo.Bee)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of bees on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of bees on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> beesOn(Turtle t){
		AgentSet<beehive.relogo.Bee> result = new AgentSet<beehive.relogo.Bee>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"bee")){
			if (tt instanceof beehive.relogo.Bee)
			result.add((beehive.relogo.Bee)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of bees on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of bees on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> beesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<beehive.relogo.Bee>();
		}

		Set<beehive.relogo.Bee> total = new HashSet<beehive.relogo.Bee>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(beesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(beesOn(p));
				}
			}
		}
		return new AgentSet<beehive.relogo.Bee>(total);
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> createUserTurtles(int number, Closure closure) {
		AgentSet<beehive.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.UserTurtle){
				result.add((beehive.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> createUserTurtles(int number) {
		return createUserTurtles(number,null);
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> createOrderedUserTurtles(int number, Closure closure) {
		AgentSet<beehive.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.UserTurtle){
				result.add((beehive.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> createOrderedUserTurtles(int number) {
		return createOrderedUserTurtles(number,null);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof beehive.relogo.UserTurtle);
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> userTurtles(){
		AgentSet<beehive.relogo.UserTurtle> a = new AgentSet<beehive.relogo.UserTurtle>();
		for (Object e : this.getContext().getObjects(beehive.relogo.UserTurtle.class)) {
			if (e instanceof beehive.relogo.UserTurtle){
				a.add((beehive.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public beehive.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof beehive.relogo.UserTurtle)
			return (beehive.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<beehive.relogo.UserTurtle> result = new AgentSet<beehive.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"userTurtle")){
			if (t instanceof beehive.relogo.UserTurtle)
			result.add((beehive.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<beehive.relogo.UserTurtle> result = new AgentSet<beehive.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"userTurtle")){
			if (tt instanceof beehive.relogo.UserTurtle)
			result.add((beehive.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<beehive.relogo.UserTurtle>();
		}

		Set<beehive.relogo.UserTurtle> total = new HashSet<beehive.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<beehive.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof beehive.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet<beehive.relogo.UserLink> userLinks(){
		AgentSet<beehive.relogo.UserLink> a = new AgentSet<beehive.relogo.UserLink>();
		for (Object e : this.getContext().getObjects(beehive.relogo.UserLink.class)) {
			if (e instanceof beehive.relogo.UserLink){
				a.add((beehive.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public beehive.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (beehive.relogo.UserLink)(this.getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public beehive.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Returns the value of the global variable numBees .
	 *
	 * @return the value of the global variable numBees 
	 */
	@ReLogoBuilderGeneratedFor("global: numBees ")
	public Object getNumBees (){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numBees ");
	}

	/**
	 * Sets the value of the global variable numBees .
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numBees ")
	public void setNumBees (Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numBees ",value);
	}


}