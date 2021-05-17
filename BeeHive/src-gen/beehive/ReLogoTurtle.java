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
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoTurtle extends BaseTurtle{

	/**
	 * Makes a number of new bees and then executes a set of commands on the
	 * created bees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created bees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> hatchBees(int number, Closure closure) {
		AgentSet<beehive.relogo.Bee> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Bee");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.Bee){
				result.add((beehive.relogo.Bee)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new bees and then executes a set of commands on the
	 * created bees.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created bees
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> hatchBees(int number) {
		return hatchBees(number,null);
	}

	/**
	 * Returns an agentset of bees from the patch of the caller.
	 * 
	 * @return agentset of bees from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> beesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<beehive.relogo.Bee> result = new AgentSet<beehive.relogo.Bee>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"bee")){
			if (t instanceof beehive.relogo.Bee)
			result.add((beehive.relogo.Bee)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of bees on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of bees at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Bee")
	public AgentSet<beehive.relogo.Bee> beesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<beehive.relogo.Bee> result = new AgentSet<beehive.relogo.Bee>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"bee")){
			if (t instanceof beehive.relogo.Bee)
			result.add((beehive.relogo.Bee)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<beehive.relogo.Bee>();
		}
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"bee")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"bee")){
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
		for (Object e : this.getMyObserver().getContext().getObjects(beehive.relogo.Bee.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof beehive.relogo.Bee)
			return (beehive.relogo.Bee) turtle;
		return null;
	}

	/**
	 * Makes a number of new followers and then executes a set of commands on the
	 * created followers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created followers
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> hatchFollowers(int number, Closure closure) {
		AgentSet<beehive.relogo.Follower> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"Follower");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.Follower){
				result.add((beehive.relogo.Follower)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new followers and then executes a set of commands on the
	 * created followers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created followers
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> hatchFollowers(int number) {
		return hatchFollowers(number,null);
	}

	/**
	 * Returns an agentset of followers from the patch of the caller.
	 * 
	 * @return agentset of followers from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> followersHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<beehive.relogo.Follower> result = new AgentSet<beehive.relogo.Follower>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"follower")){
			if (t instanceof beehive.relogo.Follower)
			result.add((beehive.relogo.Follower)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of followers on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of followers at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.Follower")
	public AgentSet<beehive.relogo.Follower> followersAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<beehive.relogo.Follower> result = new AgentSet<beehive.relogo.Follower>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"follower")){
			if (t instanceof beehive.relogo.Follower)
			result.add((beehive.relogo.Follower)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<beehive.relogo.Follower>();
		}
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"follower")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"follower")){
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
		for (Object e : this.getMyObserver().getContext().getObjects(beehive.relogo.Follower.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof beehive.relogo.Follower)
			return (beehive.relogo.Follower) turtle;
		return null;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> hatchUserTurtles(int number, Closure closure) {
		AgentSet<beehive.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof beehive.relogo.UserTurtle){
				result.add((beehive.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> hatchUserTurtles(int number) {
		return hatchUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<beehive.relogo.UserTurtle> result = new AgentSet<beehive.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof beehive.relogo.UserTurtle)
			result.add((beehive.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserTurtle")
	public AgentSet<beehive.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<beehive.relogo.UserTurtle> result = new AgentSet<beehive.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof beehive.relogo.UserTurtle)
			result.add((beehive.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<beehive.relogo.UserTurtle>();
		}
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
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
		for (Object e : this.getMyObserver().getContext().getObjects(beehive.relogo.UserTurtle.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof beehive.relogo.UserTurtle)
			return (beehive.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns the value from the getHoney() method of the underlying patch.
	 * 
	 * @return getHoney() of type double
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserPatch")
	public double getHoney(){
		beehive.relogo.UserPatch p = (beehive.relogo.UserPatch)patchHere();
		return p.getHoney();
	}

	/**
	 * Calls the setHoney(double) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserPatch")
	public void setHoney(double value){
		beehive.relogo.UserPatch p = (beehive.relogo.UserPatch)patchHere();
		p.setHoney(value);
	}

	/**
	 * Makes a directed userLink from a turtle to the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public beehive.relogo.UserLink createUserLinkFrom(Turtle t, Closure closure){
		beehive.relogo.UserLink link = (beehive.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public beehive.relogo.UserLink createUserLinkFrom(Turtle t){
			return createUserLinkFrom(t,null);
	}

	/**
	 * Makes directed userLinks from a collection to the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet<beehive.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<beehive.relogo.UserLink> links = new AgentSet<beehive.relogo.UserLink>();
		for(Turtle t : a){
			links.add((beehive.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet<beehive.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a){
		return createUserLinksFrom(a,null);
	}

	/**
	 * Makes a directed userLink to a turtle from the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public beehive.relogo.UserLink createUserLinkTo(Turtle t, Closure closure){
		beehive.relogo.UserLink link = (beehive.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public beehive.relogo.UserLink createUserLinkTo(Turtle t){
			return createUserLinkTo(t,null);
	}

	/**
	 * Makes directed userLinks to a collection from the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet<beehive.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<beehive.relogo.UserLink> links = new AgentSet<beehive.relogo.UserLink>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((beehive.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet<beehive.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a){
		return createUserLinksTo(a,null);
	}

	/**
	 * Queries if there is a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public boolean inUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed userLinks to the caller.
	 * 
	 * @return agentset with directed userLinks to the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet inUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public beehive.relogo.UserLink inUserLinkFrom(Turtle t){
		return (beehive.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed userLinks from other turtles to the caller.
	 * 
	 * @return agentset of directed userLinks from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet<beehive.relogo.UserLink> myInUserLinks(){
		AgentSet<beehive.relogo.UserLink> result = new AgentSet<beehive.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getInEdges(this)){
			if (o instanceof beehive.relogo.UserLink){
				result.add((beehive.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed userLinks to other turtles from the caller.
	 * 
	 * @return agentset of directed userLinks to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet<beehive.relogo.UserLink> myOutUserLinks(){
		AgentSet<beehive.relogo.UserLink> result = new AgentSet<beehive.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getOutEdges(this)){
			if (o instanceof beehive.relogo.UserLink){
				result.add((beehive.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public boolean outUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed userLinks from the caller.
	 * 
	 * @return agentset with directed userLinks from the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet outUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public beehive.relogo.UserLink outUserLinkTo(Turtle t){
		return (beehive.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(this, t);
	}

	/**
	 * Reports true if there is a userLink connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public boolean userLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * userLinks connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet userLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's userLinks.
	 * 
	 * @return agentset of the caller's userLinks
	 */
	@ReLogoBuilderGeneratedFor("beehive.relogo.UserLink")
	public AgentSet<beehive.relogo.UserLink> myUserLinks(){
		AgentSet<beehive.relogo.UserLink> result = new AgentSet<beehive.relogo.UserLink>();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getEdges(this)){
			if (o instanceof beehive.relogo.UserLink){
				result.add((beehive.relogo.UserLink)o);
			}
		}
		return result;
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
		for (Object e : this.getMyObserver().getContext().getObjects(beehive.relogo.UserLink.class)) {
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
		return (beehive.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
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