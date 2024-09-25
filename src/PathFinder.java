// Numan Salahuddin - 251264939
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * The PathFinder class helps explore a pyramid map and find a path to reach all the treasures hidden inside it.
 * It uses a stack data structure to keep track of the path.
 */
public class PathFinder {
	private Map pyramidMap; // The map representing the pyramid with chambers and treasures

	public PathFinder(String fileName) throws InvalidMapCharacterException, FileNotFoundException, IOException {
		// Constructor to create a PathFinder object with the specified map file
		pyramidMap = new Map(fileName); // Create a new Map object using the provided file
	}

	public DLStack<Chamber> path() {	// Method to find and return the path of chambers leading to all the treasures.
		DLStack<Chamber> stack = new DLStack<Chamber>();	// Create a stack to store the path of chambers.
		Chamber start = pyramidMap.getEntrance();	// Get the entrance chamber of the pyramid as the starting point.
		int treasureNum = pyramidMap.getNumTreasures();	// Get the total number of treasures in the pyramid.
		int treasureFound = 0; // Counter to keep track of how many treasures are found so far.
		stack.push(start);	// Push the entrance chamber onto the stack to start the path.
		start.markPushed();	// Mark the entrance chamber as pushed to keep track of its position.
		Chamber current = stack.peek();	// Get the current chamber (top of the stack) to begin the path exploration.
		while (!stack.isEmpty()) {	// Explore the path until stack is empty
			current = stack.peek(); // Get the current chamber without removing it from the stack

			// If the current chamber contains a treasure, increment the treasure found counter
			if (current.isTreasure())
				treasureFound++;

			// If the current chamber contains a treasure and all treasures are found, break the loop
			if (current.isTreasure() && treasureFound == treasureNum)
				break;

			// Find the next best chamber to explore from the current chamber
			Chamber best = bestChamber(current);

			// If there's a valid best chamber to move to, push it onto the stack and mark it as pushed
			if (best != null) {
				stack.push(best);
				best.markPushed();

			} else {
				Chamber top = stack.pop();	// If no valid best chamber is found, pop the current chamber from the stack
				top.markPopped();	// Mark it as popped (no possible path leads from this chamber)
			}
		}

		return stack; // Return the stack containing the path of chambers leading to the treasures
	}
	/**
	 * Method to retrieve the map representing the pyramid.
	 *
	 * @return The Map object representing the pyramid.
	 */
	public Map getMap() {	// Method to retrieve the map representing the pyramid
		return pyramidMap;
	}
	/**
	 * Checks if a given chamber has a neighboring lighted, unsealed chamber.
	 *
	 * @param currentChamber The chamber to check for neighboring lighted, unsealed chambers.
	 * @return True if a neighboring lighted, unsealed chamber is found, false otherwise.
	 */
	public boolean isDim(Chamber currentChamber) {
		boolean toReturn = false;
		for (int i = 0; i < 6; i++) {
			Chamber neighbor = currentChamber.getNeighbour(i);
			if (neighbor != null && neighbor.isLighted() && !neighbor.isSealed()) {
				toReturn = true; // If such a neighbor is found then we mark toReturn as true.
				break; // We break since there is no need to check further.
			}
		}
		return toReturn;
	}
	/**
	 * Finds the next best chamber to explore from the current chamber.
	 *
	 * @param currentChamber The current chamber from which to find the next best chamber.
	 * @return The next best chamber to explore, or null if no valid neighboring chamber is found.
	 */
	public Chamber bestChamber(Chamber currentChamber) {
		Chamber neighbors[] = new Chamber[6];	// Create an array to store the neighboring chambers of the current chamber

		// Store the neighboring chambers in the array
		for (int i = 0; i < 6; i++) {
			neighbors[i] = currentChamber.getNeighbour(i);
		}

		// Check each neighboring chamber to find the next best one to explore
		for (Chamber neighbor : neighbors) {
			if (neighbor != null) {
				// If the neighbor is not marked, and it contains a treasure, return as best option.
				if (!neighbor.isMarked() && neighbor.isTreasure())
					return neighbor;
					// If the neighbor is not marked, it is lighted, return as best option.
				else if (!neighbor.isMarked() && neighbor.isLighted())
					return neighbor;
					// If the neighbor is not marked, it has an adjacent lighted, unsealed chamber, return as best option.
				else if (!neighbor.isMarked() && isDim(neighbor))
					return neighbor;
			}
		}

		return null; // Return null if no possible neighboring chamber is found
	}
}
/**

 PathFinder is a special class that helps us explore a pyramid map and find a path to reach all the treasures hidden inside it.
 To keep track of our journey, we use a tool called a "stack."

 When we create a PathFinder object, we give it the name of the map file we want to explore.
 The PathFinder class processes the map file, analyzing the pyramid's structure and handling any potential errors, such as incorrect characters or problems with the file itself.

 The most exciting part is the "path()" method. It's like a treasure hunt algorithm, We start at the entrance of the pyramid and explore different chambers one by one.
 We follow specific rules: we check for treasures, lit-up chambers, and also consider nearby chambers that have lights.
 This way, we find the best way to reach all the treasures.

 The class also has other tricks like "isDim()" to check if a chamber has a nearby lit-up friend, and "bestChamber()" to choose the best chamber to explore next.

 We test our PathFinder with all kinds of pyramid maps to make sure it works perfectly.
 We try easy and hard maps with lots of treasures or no treasures at all. We even do big tests to check how fast it finds the path.
 PathFinder is a real hero in exploring pyramids and finding treasure.

 */