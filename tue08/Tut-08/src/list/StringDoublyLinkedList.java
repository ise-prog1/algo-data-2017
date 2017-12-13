package list;

public class StringDoublyLinkedList {

	private ListEntry head = null;
	private ListEntry tail = null;
	private int size = 0;
	
	public void append(String s) {
		// TODO Auto-generated method stub
		if (size == 0) {
			ListEntry entry = new ListEntry(s);
			head = entry;
			tail = entry;
			size++;
		} else {
			ListEntry entry = new ListEntry(s);
			ListEntry oldTail = tail;
			tail = entry;
			
			oldTail.next = tail;
			tail.prev = oldTail;
			size++;
		}
	}

	public void insertAtHead(String s) {
		// TODO Auto-generated method stub
		if (size == 0) {
			ListEntry entry = new ListEntry(s);
			head = entry;
			tail = entry;
			size++;
		} else {
			ListEntry entry = new ListEntry(s);
			ListEntry oldHead = head;
			head = entry;
			
			oldHead.prev = head;
			head.next = oldHead;
			size++;
		}
	}

	public void insertAfter(int i, String s) {
		// TODO Auto-generated method stub
		if (size == 0) {
			append(s);
		}
			
		if (i >= size - 1) {
			append(s);
		}
		ListEntry beforeNewEntry = head;
		for(int j = 0; j < i; j++) {
			beforeNewEntry = head.next;
		}
		
		ListEntry newEntry = new ListEntry(s);
		ListEntry afterNewEntry = beforeNewEntry.next;
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

	public String getValue(int i) {
		if (i < 0 || i > size - 1) {
			return null;
		} else {
			ListEntry current = head;
			for(int j = 0; j < i; j++) {
				current = current.next;
			}
			return current.value;
		}
		
	}

	public void deleteValue(String s) {
		if (size == 0)
			return;
		
		ListEntry current = head;
		while(current.next != null) {
			if (current.value.equals(s))
				break;
			
			current = current.next;
		}
		
		if (current.value.equals(s)) {
			ListEntry beforeCurrent = current.prev;
			ListEntry afterCurrent = current.next;
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

	private static class ListEntry {
		public String value = null;
		public ListEntry prev = null;
		public ListEntry next = null;
		
		public ListEntry(String value) {
			this.value = value;
		}
	}
}


