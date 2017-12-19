package list;

/**
 * A generic version of a doubly linked list.
 * 
 * @author clemens
 *
 * @param <T>
 *            - Represents the type of elements to be stored
 */
public class DoublyLinkedList<T> {

	// use same type for the ListEntry attributes as in DoublyLinkedList
	private ListEntry<T> head = null;
	private ListEntry<T> tail = null;
	private int size = 0;

	public void append(T value) {
		// TODO Auto-generated method stub
		if (size == 0) {
			// handle first element
			ListEntry<T> entry = new ListEntry<>(value);
			head = entry;
			tail = entry;
			size++;
		} else {
			ListEntry<T> entry = new ListEntry<>(value);
			ListEntry<T> oldTail = tail;
			// set new end point
			tail = entry;

			// link old and new properly
			oldTail.next = tail;
			tail.prev = oldTail;

			// increase size
			size++;
		}
	}

	public void insertAtHead(T value) {
		if (size == 0) {
			// handle first element
			ListEntry<T> entry = new ListEntry<>(value);

			// beginning and end should point
			// to the only element of the list
			head = entry;
			tail = entry;

			// increase size
			size++;
		} else {
			ListEntry<T> entry = new ListEntry<T>(value);
			ListEntry<T> oldHead = head;

			// set new start point
			head = entry;

			// link old and new head
			oldHead.prev = head;
			head.next = oldHead;

			// increase size
			size++;
		}
	}

	public void insertAfter(int i, T s) {
		
		// list is empty -> append
		if (size == 0) {
			append(s);
		}

		// index is out of bounds -> append
		if (i >= size - 1) {
			append(s);
		}
		
		// iterate until we have the correct entry
		ListEntry<T> beforeNewEntry = head;
		for (int j = 0; j < i; j++) {
			beforeNewEntry = head.next;
		}

		ListEntry<T> newEntry = new ListEntry<T>(s);
		ListEntry<T> afterNewEntry = beforeNewEntry.next;
		
		// integrate new element with predecessor
		beforeNewEntry.next = newEntry;
		newEntry.prev = beforeNewEntry;

		// integrate new element with successor
		newEntry.next = afterNewEntry;
		if (afterNewEntry != null) {
			afterNewEntry.prev = newEntry;
		}

		// if inserted after last element we update the tail
		if (tail == beforeNewEntry && afterNewEntry == null) {
			tail = newEntry;
		}

		// increase size
		size++;
	}

	public T getValue(int i) {
		// Index out of bounds -> return null
		if (i < 0 || i > size - 1) {
			return null;
		} else {
			ListEntry<T> current = head;
			for (int j = 0; j < i; j++) {
				current = current.next;
			}
			return current.value;
		}

	}

	public void deleteValue(T s) {
		// deleting is not possible with zero elements
		if (size == 0)
			return;

		ListEntry<T> current = head;
		while (current.next != null) {
			// break if current is the target value
			if (current.value.equals(s))
				break;

			current = current.next;
		}

		// check if we found the value
		if (current.value.equals(s)) {
			
			ListEntry<T> beforeCurrent = current.prev;
			ListEntry<T> afterCurrent = current.next;
			
			// beforeCurrent might be null!
			if (beforeCurrent != null) {
				beforeCurrent.next = afterCurrent;	
			}

			// afterCurrent might be null!
			if (afterCurrent != null) {
				afterCurrent.prev = beforeCurrent;
			}

			// update head if head was removed
			if (head == current) {
				head = afterCurrent;
			}

			// update tail if tail was removed
			if (tail == current) {
				tail = beforeCurrent;
			}
			
			// decrease size
			size--;
		}
	}

	private static class ListEntry<T> {
		public T value = null;
		public ListEntry<T> prev = null;
		public ListEntry<T> next = null;

		public ListEntry(T value) {

			this.value = value;
		}

		@Override
		public String toString() {
			return "(" + value + ")" + ((next != null) ? next : "");
		}

	}

	@Override
	public String toString() {
		return "DoublyLinkedList size=" + size + " [" + ((head != null) ? head : "") + "]";
	}

}
