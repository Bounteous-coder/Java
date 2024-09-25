// Numan Salahuddin - 251264939
/**
 * A Double Linked Stack implementation that supports pushing, popping, peeking, and retrieving the size of the stack.
 * @param <T> The type of elements to be stored in the stack.
 */
public class DLStack<T> implements DLStackADT<T> {
	private DoubleLinkedNode<T> top; // The top node of the stack represents the last added element
	private int numItems;  // Number of items currently in the stack
	/**
	 * Constructor to initialize an empty stack.
	 */
	public DLStack() {
		top = null; // Initializing the top node to null since the stack is empty
		numItems = 0; // Set no. of items to 0 since the stack is empty
	}
	/**
	 * Method to push (add) a new element to the stack.
	 *
	 * @param dataItem The element to be pushed onto the stack.
	 */
	public void push(T dataItem) { // Method to push (add) a new element to the stack
		DoubleLinkedNode<T> node = new DoubleLinkedNode<>(dataItem); // Create a new node with the given data

		if (top == null)
			top = node; // If the stack is empty we make the new node the top node
		else {
			// If the stack is not empty we insert the new node at the top of the stack
			node.setNext(top);
			top.setPrevious(node);
			top = node;
		}
		numItems++; // Increment ++ the number of items in the stack
	}
	/**
	 * Method to pop (remove and return) the top element from the stack.
	 *
	 * @return The element removed from the top of the stack.
	 * @throws EmptyStackException If the stack is empty and no elements can be popped.
	 */
	public T pop() throws EmptyStackException {  // Method to pop (remove and return) the top element from the stack
		if (isEmpty())
			throw new EmptyStackException("Stack is empty."); // If the stack is empty we throw an exception

		T element = top.getElement(); // Get the data of the top node

		if (numItems == 1) {
			top = null; // If the stack contains only one item then set the top to null
		} else {
			top = top.getNext(); // Move the top to the next node
			top.setPrevious(null); // Set the previous reference of the new top to null
		}

		numItems--; // Decrement the number of items in the stack
		return element; // Return the popped element
	}
	/**
	 * Method to pop the k-th element from the top of the stack.
	 *
	 * @param k The position of the element to be removed from the top of the stack.
	 * @return The element removed from the k-th position from the top of the stack.
	 * @throws InvalidItemException If the value of k is invalid (less than 1 or greater than the number of items).
	 */
	public T pop(int k) throws InvalidItemException { // Method to pop the k-th element from the top of the stack
		if (k <= 0 || k > numItems) {
			throw new InvalidItemException("Invalid Item"); // If the k value is invalid we throw an InvalidItemException.
		}

		if (k == 1) {
			return pop(); // If k is 1, simply call the regular pop() method to remove the top element
		}

		// If k > 1, find the k-th node and remove it from the stack
		DoubleLinkedNode<T> current = top;
		int count = 1;

		while (count < k) {
			current = current.getNext(); // Traverse the stack to find the k-th node
			count++;
		}

		// Get references to the previous and next nodes of the k-th node
		DoubleLinkedNode<T> previous = current.getPrevious();
		DoubleLinkedNode<T> next = current.getNext();

		// Rearrange the references to remove the k-th node from the stack
		if (previous != null) {
			previous.setNext(next);
		} else if (next != null) {
			next.setPrevious(previous);
		} else if (next == null) {
			previous.setNext(null); // If k-th node is the last one then we set the previous node's next reference to null
		}

		if (previous == null) {
			next.setPrevious(null); // If k-th node is the top node then we set the next node's previous reference to null
		}

		numItems--; // Decrement the number of items in the stack
		return current.getElement(); // Return the data of the removed k-th node
	}

	/**
	 * Method to peek (retrieve without removing) the top element of the stack.
	 *
	 * @return The element at the top of the stack.
	 * @throws EmptyStackException If the stack is empty and no elements can be peeked.
	 */
	public T peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Empty Stack."); // If the stack is empty, throw an exception
		}
		return top.getElement(); // Return the data of the top node
	}
	/**
	 * Method to check if the stack is empty.
	 *
	 * @return True if the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {  // Method to check if the stack is empty
		return numItems == 0; // If the number of items is 0, the stack is empty, return true;
		// otherwise, return false
	}
	/**
	 * Method to get the number of items in the stack.
	 *
	 * @return The number of items currently in the stack.
	 */
	public int size() {
		return numItems; // Return the number of items in the stack
	}
	/**
	 * Method to get the top node of the stack.
	 *
	 * @return The top node of the stack.
	 */
	public DoubleLinkedNode<T> getTop() {
		return top; // Returns the top node of the stack
	}
	/**
	 * Method to represent the stack as a string for debugging purposes.
	 *
	 * @return A string representation of the stack.
	 */
	public String toString() {
		String toPrint = "[";
		DoubleLinkedNode<T> current = top;

		while (current != null) {
			toPrint += current.getElement(); // Append the data of the current node to the string
			if (current.getNext() != null)
				toPrint += " "; // Add a space after the data for readability
			current = current.getNext(); // Move to the next node
		}

		toPrint += "]";
		return toPrint; // Return the string representation of the stack with space after the data for readability.
	}

}
