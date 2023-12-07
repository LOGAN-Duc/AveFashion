package vn.devpro.storemanagament.update.customer;

import java.util.ArrayList;
import java.util.Scanner;


public class CustomerManamgenment {
	private static ArrayList<Customer> list = new ArrayList<Customer>();
	public static ArrayList<Customer> getList() {
		return list;
	}

	public static void setList(ArrayList<Customer> list) {
		CustomerManamgenment.list = list;
	}
	public static int autoId = 1; //auto increasement
	public static void init() {
		list.add(new Customer(autoId++, "Hoang Anh"));
		list.add(new Customer(autoId++, "Le Quyen"));
		list.add(new Customer(autoId++, "Van Khai"));
		list.add(new Customer(autoId++, "Nghia AN"));
		list.add(new Customer(autoId++, "Dao An"));
	}
	public static void customerUpdate() {
		Scanner sc =  new Scanner(System.in);
		System.out.println("\n----CẬP NHẬT THÔNG TIN KHACH HANG-----");
		System.out.println("Các chức năng cập nhật");
	    System.out.println("\t1. Xem danh sach khach hàng");
	    System.out.println("\t2. Thêm mội khach hàng mới");
	    System.out.println("\t3. Sửa thông tin khach hàng trong danh sách");
	    System.out.println("\t4. Xóa thông tin khach hàng trong danh sách");
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
			update();
			break;
		}
		case 4: {
			remove();
			break;
		}
		case 0: {
			System.exit(0);return;
		}
		default: System.out.println("lua chon khong hop le");
		}}while(true);
	}

	private static void remove() {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		System.out.println("\n--------XOA THONG TIN KHACH HANG-------");
		System.out.print("Nhap ID khach hang : ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCustomer(id);
		if (index == -1) {
			System.out.println("\tId khong co trong danh sach");
		}else {
			list.remove(index);
			System.out.println("\tXoa Thanh Cong");
		}
	}

	private static void update() {
		Scanner sc =  new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("\n--------SUA THONG TIN KHACH HANG-------");
		System.out.print("Nhap ID khach hang : ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCustomer(id);
		if (index != -1) {
			System.out.print("\tNhập tên khach hàng mới : ");
			String name  = sc.nextLine();
			if (name == null || name.trim().length()==0) {
				System.out.println("\tTen khach hàng không được để trống");
				return;
			}
			
			list.get(index).setName(name);
		}else {
			System.out.println("\tId khong co trong danh sach");
		}
	}
	public static int indexOfCustomer(int id) {
		
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId()==id) {
				return index;
			}
		}
		return -1;
	}
	private static void insert() {
		// TODO Auto-generated method stub
		System.out.println("\n------THÊM MỘT LOẠI HÀNG MỚI-----");
		System.out.print("\tNhập tên loại hàng mới : ");
		Scanner sc =  new Scanner(System.in);
		Customer newCustomer = new Customer();
		String name  = sc.nextLine();
		if (name == null || name.trim().length()==0) {
			System.out.println("\tTen khach hàng không được để trống");
			return;
		}
		
		newCustomer.setName(name);
		newCustomer.setId(autoId++);
		System.out.println("\tThêm mới thành công");
		list.add(newCustomer);
		
		
	}
	
	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("\n\tDANH SÁCH KHACH HÀNG");

		System.out.printf("%-5s %-30s\n", "Id", "Customer Name");
		for (Customer category : list) {
			category.display();
		}
	}
	
	public static String getNameById(int id) {
		for (Customer category : list) {
			if (category.getId()==id) {
				return category.getName();
			}
		}
		return null;
	}
	
}
