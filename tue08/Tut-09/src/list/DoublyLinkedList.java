package list;

public class DoublyLinkedList<T> {

	private ListEntry<T> head = null;
	private ListEntry<T> tail = null;
	private int size = 0;
	
	public void append(T s) {
		// TODO Auto-generated method stub
		if (size == 0) {
			ListEntry<T> entry = new ListEntry<>(s);
			head = entry;
			tail = entry;
			size++;
		} else {
			ListEntry<T> entry = new ListEntry<>(s);
			ListEntry<T> oldTail = tail;
			tail = entry;
			
			oldTail.next = tail;
			tail.prev = oldTail;
			size++;
		}
	}

	public void insertAtHead(T s) {
		// TODO Auto-generated method stub
		if (size == 0) {
			ListEntry<T> entry = new ListEntry<>(s);
			head = entry;
			tail = entry;
			size++;
		} else {
			ListEntry<T> entry = new ListEntry<T>(s);
			ListEntry<T> oldHead = head;
			head = entry;
			
			oldHead.prev = head;
			head.next = oldHead;
			size++;
		}
	}

	public void insertAfter(int i, T s) {
		// TODO Auto-generated method stub
		if (size == 0) {
			append(s);
		}
			
		if (i >= size - 1) {
			append(s);
		}
		ListEntry<T> beforeNewEntry = head;
		for(int j = 0; j < i; j++) {
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
		
		size++;
	}

	public T getValue(int i) {
		if (i < 0 || i > size - 1) {
			return null;
		} else {
			ListEntry<T> current = head;
			for(int j = 0; j < i; j++) {
				current = current.next;
			}
			return current.value;
		}
		
	}

	public void deleteValue(T s) {
		if (size == 0)
			return;
		
		ListEntry<T> current = head;
		while(current.next != null) {
			if (current.value.equals(s))
				break;
			
			current = current.next;
		}
		
		if (current.value.equals(s)) {
			ListEntry<T> beforeCurrent = current.prev;
			ListEntry<T> afterCurrent = current.next;
			if (beforeCurrent != null)
				beforeCurrent.next = afterCurrent;
			
			if (afterCurrent != null)
				afterCurrent.prev = beforeCurrent;
			
			if (head == current) {
				head = afterCurrent;
			}
			
			if (tail == current) {
				tail = beforeCurrent;
			}
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
			return "(" + value + ")" + ((next != null) ? next: "");
		}
		
	}

	@Override
	public String toString() {
		return "DoublyLinkedList size=" + size + " [" + ((head != null) ? head: "") + "]";
	}
	
}


