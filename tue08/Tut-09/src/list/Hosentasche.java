package list;

public class Hosentasche<T> {
	
	// left und right haben beide den gleichen Typ!
	private T leftPocket;
	private T rightPocket;
	
	public Hosentasche(T left, T right) {
		this.leftPocket = left;
		this.rightPocket = right;
	}

	// Getter
	public T getLeftPocket() {
		return leftPocket;
	}

	public T getRightPocket() {
		return rightPocket;
	}

	// Setter
	public void setLeftPocket(T leftPocket) {
		this.leftPocket = leftPocket;
	}

	public void setRightPocket(T rightPocket) {
		this.rightPocket = rightPocket;
	}
	
	// Demo Usage
	public static void main(String[] args) {
		// left und right müssen den gleichen Typ haben.
		Hosentasche<String> stringTasche = new Hosentasche<String>("hi", ":)");
		System.out.println(stringTasche.leftPocket); // hi
	}

}
