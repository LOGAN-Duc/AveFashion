package vn.devpro.storemanagament.update.product;

import java.util.Scanner;

import vn.devpro.storemanagament.update.category.CategoryManagament;

public class Product {


	private int id, categoryId;
	private String name;
	private double price,amout;
	
	public void display() {
		// TODO Auto-generated method stub
		System.out.printf("%6s %-25s %-25s %,15.2f %,12.2f\n",this.id,CategoryManagament.getNameById(categoryId)
				,this.name,this.price,this.amout);
	}
	public void update() {
		do {
	   	    Scanner sc = new Scanner(System.in);
			System.out.println("\t---SUA THONG TIN KHACH HANG --- ");
			System.out.println("\t-01.Ten hang");
			System.out.println("\t-02.So luong");
			System.out.println("\t-03.Don gia");
			System.out.println("\t-04.Loai hang");
			System.out.println("\t-0.quay lai");
			System.out.print("\n\tMoi ban chon : ");
			int choose ;
			choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1: 
				System.out.print("\tNhap ten hang moi: ");
				this.name = sc.nextLine();
				if (this.name == null || this.name.trim().length()==0) {
					System.out.println("\tTen hàng hoa không được để trống");
					return;
				}
				break;		
			case 2: 
				System.out.print("\tNhap so luong moi: ");
				this.amout = Double.parseDouble(sc.nextLine()) ;
				if (this.amout<0) {
					System.out.println("\tSo luong khong de am");
				}
				break;
			case 3: 
				System.out.print("\tNhap don gia moi: ");
				this.price = Double.parseDouble(sc.nextLine()) ;
				if (this.price<0) {
					System.out.println("\tDon gia khong de am");
				}
			    break;
			case 4: 
				System.out.print("\tNhap loai hang moi: ");
				this.categoryId = Integer.parseInt(sc.nextLine()) ;
				if (CategoryManagament.indexOfCategory(categoryId)==-1) {
					System.out.println("Loai hang hoa khong co trong danh sach");
					return;
				}
			    break;
			case 0: 
				System.out.print("\tSUA THANH CONG\n ");
			   return;
			default :
			    System.out.println("\t\tLua chon khong hop le");}
		}while(true);
	}
	
	public double getAmout() {
		return amout;
	}
	public void setAmout(double amout) {
		this.amout = amout;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product(int id, int categoryId, String name, double price, double amout) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.amout = amout;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
