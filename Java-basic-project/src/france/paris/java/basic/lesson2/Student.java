package france.paris.java.basic.lesson2;

public class Student extends People {

	private String fullName = "Unknown";
	private int finalPoint = 0;
	protected final static String PROMOTION = "K2017";
	
	static int test = 9;

	public Student(String name, String famillyName) {
		super(name);
		this.fullName = famillyName + name;
	}

	public Student() {
		this("a", "b");
	}
	
	public Student getMyself(){
		test = 6;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getFinalPoint() {
		return finalPoint;
	}

	public void setFinalPoint(int finalPoint) {
		this.finalPoint = finalPoint;
	}

	
}
