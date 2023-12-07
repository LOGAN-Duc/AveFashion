package vn.devpro.storemanagament.update.category;

public class Category {
	private int id;
	private String name;
	
	
	public void display() {
		// TODO Auto-generated method stub
		System.out.printf("%5d %-30s\n", this.id, this.name);
	}
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
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
}
