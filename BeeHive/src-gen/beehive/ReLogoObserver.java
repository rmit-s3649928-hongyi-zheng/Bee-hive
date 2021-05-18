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
	 * Makes a number of randomly oriented followers and then executes a set of commands on the
	 * created followers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created followers
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> createFollowers(int number, Closure closure) {
		AgentSet<beehive.relogo.Follower> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Follower");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.Follower){
				result.add((beehive.relogo.Follower)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented followers and then executes a set of commands on the
	 * created followers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created followers
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> createFollowers(int number) {
		return createFollowers(number,null);
	}

	/**
	 * Makes a number of uniformly fanned followers and then executes a set of commands on the
	 * created followers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created followers
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> createOrderedFollowers(int number, Closure closure) {
		AgentSet<beehive.relogo.Follower> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Follower");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.Follower){
				result.add((beehive.relogo.Follower)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned followers and then executes a set of commands on the
	 * created followers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created followers
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> createOrderedFollowers(int number) {
		return createOrderedFollowers(number,null);
	}

	/**
	 * Queries if object is a follower.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a follower
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public boolean isFollowerQ(Object o){
		return (o instanceof beehive.relogo.Follower);
	}

	/**
	 * Returns an agentset containing all followers.
	 * 
	 * @return agentset of all followers
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> followers(){
		AgentSet<beehive.relogo.Follower> a = new AgentSet<beehive.relogo.Follower>();
		for (Object e : this.getContext().getObjects(beehive.relogo.Follower.class)) {
			if (e instanceof beehive.relogo.Follower){
				a.add((beehive.relogo.Follower)e);
			}
		}
		return a;
	}

	/**
	 * Returns the follower with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public beehive.relogo.Follower follower(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof beehive.relogo.Follower)
			return (beehive.relogo.Follower) turtle;
		return null;
	}

	/**
	 * Returns an agentset of followers on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of followers on patch p
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> followersOn(Patch p){
		AgentSet<beehive.relogo.Follower> result = new AgentSet<beehive.relogo.Follower>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"follower")){
			if (t instanceof beehive.relogo.Follower)
			result.add((beehive.relogo.Follower)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of followers on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of followers on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> followersOn(Turtle t){
		AgentSet<beehive.relogo.Follower> result = new AgentSet<beehive.relogo.Follower>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"follower")){
			if (tt instanceof beehive.relogo.Follower)
			result.add((beehive.relogo.Follower)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of followers on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of followers on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> followersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<beehive.relogo.Follower>();
		}

		Set<beehive.relogo.Follower> total = new HashSet<beehive.relogo.Follower>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(followersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(followersOn(p));
				}
			}
		}
		return new AgentSet<beehive.relogo.Follower>(total);
	}

	/**
	 * Makes a number of randomly oriented implicitBees and then executes a set of commands on the
	 * created implicitBees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created implicitBees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.ImplicitBee")
	public AgentSet<beehive.relogo.ImplicitBee> createImplicitBees(int number, Closure closure) {
		AgentSet<beehive.relogo.ImplicitBee> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"ImplicitBee");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.ImplicitBee){
				result.add((beehive.relogo.ImplicitBee)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented implicitBees and then executes a set of commands on the
	 * created implicitBees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created implicitBees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.ImplicitBee")
	public AgentSet<beehive.relogo.ImplicitBee> createImplicitBees(int number) {
		return createImplicitBees(number,null);
	}

	/**
	 * Makes a number of uniformly fanned implicitBees and then executes a set of commands on the
	 * created implicitBees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created implicitBees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.ImplicitBee")
	public AgentSet<beehive.relogo.ImplicitBee> createOrderedImplicitBees(int number, Closure closure) {
		AgentSet<beehive.relogo.ImplicitBee> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"ImplicitBee");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.ImplicitBee){
				result.add((beehive.relogo.ImplicitBee)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned implicitBees and then executes a set of commands on the
	 * created implicitBees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created implicitBees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.ImplicitBee")
	public AgentSet<beehive.relogo.ImplicitBee> createOrderedImplicitBees(int number) {
		return createOrderedImplicitBees(number,null);
	}

	/**
	 * Queries if object is a implicitBee.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a implicitBee
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.ImplicitBee")
	public boolean isImplicitBeeQ(Object o){
		return (o instanceof beehive.relogo.ImplicitBee);
	}

	/**
	 * Returns an agentset containing all implicitBees.
	 * 
	 * @return agentset of all implicitBees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.ImplicitBee")
	public AgentSet<beehive.relogo.ImplicitBee> implicitBees(){
		AgentSet<beehive.relogo.ImplicitBee> a = new AgentSet<beehive.relogo.ImplicitBee>();
		for (Object e : this.getContext().getObjects(beehive.relogo.ImplicitBee.class)) {
			if (e instanceof beehive.relogo.ImplicitBee){
				a.add((beehive.relogo.ImplicitBee)e);
			}
		}
		return a;
	}

	/**
	 * Returns the implicitBee with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.ImplicitBee")
	public beehive.relogo.ImplicitBee implicitBee(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof beehive.relogo.ImplicitBee)
			return (beehive.relogo.ImplicitBee) turtle;
		return null;
	}

	/**
	 * Returns an agentset of implicitBees on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of implicitBees on patch p
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.ImplicitBee")
	public AgentSet<beehive.relogo.ImplicitBee> implicitBeesOn(Patch p){
		AgentSet<beehive.relogo.ImplicitBee> result = new AgentSet<beehive.relogo.ImplicitBee>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"implicitBee")){
			if (t instanceof beehive.relogo.ImplicitBee)
			result.add((beehive.relogo.ImplicitBee)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of implicitBees on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of implicitBees on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.ImplicitBee")
	public AgentSet<beehive.relogo.ImplicitBee> implicitBeesOn(Turtle t){
		AgentSet<beehive.relogo.ImplicitBee> result = new AgentSet<beehive.relogo.ImplicitBee>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"implicitBee")){
			if (tt instanceof beehive.relogo.ImplicitBee)
			result.add((beehive.relogo.ImplicitBee)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of implicitBees on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of implicitBees on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.ImplicitBee")
	public AgentSet<beehive.relogo.ImplicitBee> implicitBeesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<beehive.relogo.ImplicitBee>();
		}

		Set<beehive.relogo.ImplicitBee> total = new HashSet<beehive.relogo.ImplicitBee>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(implicitBeesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(implicitBeesOn(p));
				}
			}
		}
		return new AgentSet<beehive.relogo.ImplicitBee>(total);
	}

	/**
	 * Makes a number of randomly oriented passiveActionBees and then executes a set of commands on the
	 * created passiveActionBees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created passiveActionBees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.PassiveActionBee")
	public AgentSet<beehive.relogo.PassiveActionBee> createPassiveActionBees(int number, Closure closure) {
		AgentSet<beehive.relogo.PassiveActionBee> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"PassiveActionBee");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.PassiveActionBee){
				result.add((beehive.relogo.PassiveActionBee)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented passiveActionBees and then executes a set of commands on the
	 * created passiveActionBees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created passiveActionBees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.PassiveActionBee")
	public AgentSet<beehive.relogo.PassiveActionBee> createPassiveActionBees(int number) {
		return createPassiveActionBees(number,null);
	}

	/**
	 * Makes a number of uniformly fanned passiveActionBees and then executes a set of commands on the
	 * created passiveActionBees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created passiveActionBees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.PassiveActionBee")
	public AgentSet<beehive.relogo.PassiveActionBee> createOrderedPassiveActionBees(int number, Closure closure) {
		AgentSet<beehive.relogo.PassiveActionBee> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"PassiveActionBee");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.PassiveActionBee){
				result.add((beehive.relogo.PassiveActionBee)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned passiveActionBees and then executes a set of commands on the
	 * created passiveActionBees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created passiveActionBees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.PassiveActionBee")
	public AgentSet<beehive.relogo.PassiveActionBee> createOrderedPassiveActionBees(int number) {
		return createOrderedPassiveActionBees(number,null);
	}

	/**
	 * Queries if object is a passiveActionBee.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a passiveActionBee
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.PassiveActionBee")
	public boolean isPassiveActionBeeQ(Object o){
		return (o instanceof beehive.relogo.PassiveActionBee);
	}

	/**
	 * Returns an agentset containing all passiveActionBees.
	 * 
	 * @return agentset of all passiveActionBees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.PassiveActionBee")
	public AgentSet<beehive.relogo.PassiveActionBee> passiveActionBees(){
		AgentSet<beehive.relogo.PassiveActionBee> a = new AgentSet<beehive.relogo.PassiveActionBee>();
		for (Object e : this.getContext().getObjects(beehive.relogo.PassiveActionBee.class)) {
			if (e instanceof beehive.relogo.PassiveActionBee){
				a.add((beehive.relogo.PassiveActionBee)e);
			}
		}
		return a;
	}

	/**
	 * Returns the passiveActionBee with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.PassiveActionBee")
	public beehive.relogo.PassiveActionBee passiveActionBee(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof beehive.relogo.PassiveActionBee)
			return (beehive.relogo.PassiveActionBee) turtle;
		return null;
	}

	/**
	 * Returns an agentset of passiveActionBees on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of passiveActionBees on patch p
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.PassiveActionBee")
	public AgentSet<beehive.relogo.PassiveActionBee> passiveActionBeesOn(Patch p){
		AgentSet<beehive.relogo.PassiveActionBee> result = new AgentSet<beehive.relogo.PassiveActionBee>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"passiveActionBee")){
			if (t instanceof beehive.relogo.PassiveActionBee)
			result.add((beehive.relogo.PassiveActionBee)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of passiveActionBees on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of passiveActionBees on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.PassiveActionBee")
	public AgentSet<beehive.relogo.PassiveActionBee> passiveActionBeesOn(Turtle t){
		AgentSet<beehive.relogo.PassiveActionBee> result = new AgentSet<beehive.relogo.PassiveActionBee>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"passiveActionBee")){
			if (tt instanceof beehive.relogo.PassiveActionBee)
			result.add((beehive.relogo.PassiveActionBee)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of passiveActionBees on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of passiveActionBees on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.PassiveActionBee")
	public AgentSet<beehive.relogo.PassiveActionBee> passiveActionBeesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<beehive.relogo.PassiveActionBee>();
		}

		Set<beehive.relogo.PassiveActionBee> total = new HashSet<beehive.relogo.PassiveActionBee>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(passiveActionBeesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(passiveActionBeesOn(p));
				}
			}
		}
		return new AgentSet<beehive.relogo.PassiveActionBee>(total);
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
	 * Returns the value of the global variable communicationType.
	 *
	 * @return the value of the global variable communicationType
	 */
	@ReLogoBuilderGeneratedFor("global: communicationType")
	public Object getCommunicationType(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("communicationType");
	}

	/**
	 * Sets the value of the global variable communicationType.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: communicationType")
	public void setCommunicationType(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("communicationType",value);
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

	/**
	 * Returns the value of the global variable insectVision.
	 *
	 * @return the value of the global variable insectVision
	 */
	@ReLogoBuilderGeneratedFor("global: insectVision")
	public Object getInsectVision(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("insectVision");
	}

	/**
	 * Sets the value of the global variable insectVision.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: insectVision")
	public void setInsectVision(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("insectVision",value);
	}

	/**
	 * Returns the value of the global variable numFollowers.
	 *
	 * @return the value of the global variable numFollowers
	 */
	@ReLogoBuilderGeneratedFor("global: numFollowers")
	public Object getNumFollowers(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numFollowers");
	}

	/**
	 * Sets the value of the global variable numFollowers.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numFollowers")
	public void setNumFollowers(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numFollowers",value);
	}


}