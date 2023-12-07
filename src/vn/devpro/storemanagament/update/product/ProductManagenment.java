package vn.devpro.storemanagament.update.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.devpro.storemanagament.update.category.CategoryManagament;


public class ProductManagenment {
	
	private static List<Product> list =  new ArrayList<Product>();

	public static List<Product> getList() {
		return list;
	}
	static Scanner sc = new Scanner(System.in);
	public static void setList(List<Product> list) {
		ProductManagenment.list = list;
	}
	public static int autoID = 1;
	public static void init() {
		list.add(new Product(autoID++, 1, "Ti Vi", 1200000, 10));
		list.add(new Product(autoID++, 2, "Noi chien khong dau", 6000000, 30));
		list.add(new Product(autoID++, 3, "Quan bo nhap khau", 300000, 100));
		list.add(new Product(autoID++, 1, "Tu lanh SamSung", 1500000, 5));
		list.add(new Product(autoID++, 2, "Noi com cucko", 700000, 20));
	}
	public static void productUpdate() {
		System.out.println("\n----CẬP NHẬT THÔNG TIN HANG HOA-----");
		System.out.println("Các chức năng cập nhật");
	    System.out.println("\t1. Xem danh sach hàng hoa");
	    System.out.println("\t2. Thêm một hàng hoa mới");
	    System.out.println("\t3. Sửa thông tin  hàng hoa trong danh sách");
	    System.out.println("\t4. Xóa thông tin  hàng hoa trong danh sách");
	    System.out.println("\t0.Thoat");
	    do {
	    System.out.print("lựa chọn chức năng quản lý :");
	    int n = Integer.parseInt(sc.nextLine());
	    switch (n) {
		case 1: {
			display();
			break;
		}
		case 2: {
			insert();
			break;
		}
		case 3: {
			edit();
			break;
		}
		case 4: {
			remove();
			break;
		}
		case 0: {
			return;
		}
		default: System.out.println("lua chon khong hop le");
		}}while(true);
	}

	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("\n\tDANH SACH HANG HOA");
		System.out.printf("%6s %-25s %-25s %15s %12s\n","ID","Ten loai hang"
				,"Ten hang","Don gia","So luong");
		for (Product product : list) {
			product.display();
		}
	}
     public static int indexOfProduct(int id) {
		
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId()==id) {
				return index;
			}
		}
		return -1;
	}
	private static void insert() {
		// TODO Auto-generated method stub
		System.out.println("\n------THÊM MỘT HÀNG HOA MỚI-----");
		System.out.print("\tChon category ");
		int categoryID = Integer.parseInt(sc.nextLine());
		//kiem tra id category
		if (CategoryManagament.indexOfCategory(categoryID)==-1) {
			System.out.println("Loai hang hoa khong co trong danh sach");
			return;
		}
		System.out.print("\tNhập tên hàng hoa mới : ");
		String name  = sc.nextLine();
		if (name == null || name.trim().length()==0) {
			System.out.println("\tTen hàng hoa không được để trống");
			return;
		}
		System.out.print("Nhap don gia : ");
		double price = Double.parseDouble(sc.nextLine());
		if (price<0) {
			System.out.println("\tDon gia khong de am");
		}
		System.out.print("Nhap so luong gia : ");
		double amout = Double.parseDouble(sc.nextLine());
		if (amout<0) {
			System.out.println("\tSo luong khong de am");
		}
		list.add(new Product(autoID++,categoryID,name,price,amout));
		System.out.println("\tTHEM MOI THANH CONG");
		
	}
	
	private static void edit() {
		// TODO Auto-generated method stub
		System.out.println("\n--------SUA THONG TIN HANG HOA-------");
		System.out.print("Nhap ID hang hoa : ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfProduct(id);
		if (index == -1) {
			System.out.println("\tId khong co trong danh sach");
		}
		list.get(index).update();

	}
	

	private static void remove() {
		// TODO Auto-generated method stub
		System.out.println("\n--------XOA THONG TIN HANG HOA-------");
		System.out.print("Nhap ID loai hang : ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfProduct(id);
		if (index == -1) {
			System.out.println("\tId khong co trong danh sach");
		}
		list.remove(index);
		System.out.println("\tXOA THANH CONG");
	}
	//tra ve doi tuong hang hoa
	public static Product getProductById(int id) {
		for (Product product : list) {
			if (product.getId()==id) {
				return product;
			}
		}
		return null;	
	}

}
