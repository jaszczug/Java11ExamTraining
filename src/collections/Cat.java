package collections;

public class Cat extends Animal {
	



	private String name;
	

	public Cat(String string) {
		name = string;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Pet name: " +name;
	}

}
