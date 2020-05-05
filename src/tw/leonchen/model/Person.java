package tw.leonchen.model;

public class Person {
	private String name = "judy";
	private String address = "heaven";
	
	public Person() {		
	}

	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void showDetails() {
		System.out.println("name:" + name);
		System.out.println("address:" + address);
	}

}
