package vn.devpro.storemanagament.update.customer;

public class Customer {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void display() {
		// TODO Auto-generated method stub
		System.out.printf("%5d %-30s\n", this.id, this.name);
	}
}
