package vn.devpro.storemanagament.update.category;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoryManagament {
	private static ArrayList<Category> list = new ArrayList<Category>();
	public static ArrayList<Category> getList() {
		return list;
	}

	public static void setList(ArrayList<Category> list) {
		CategoryManagament.list = list;
	}
	public static int autoId = 1; //auto increasement
	public static void init() {
		list.add(new Category(autoId++, "Điện tử"));
		list.add(new Category(autoId++, "Gia Dụng"));
		list.add(new Category(autoId++, "Thời Trang"));
		list.add(new Category(autoId++, "Mỹ Phẩm"));
		list.add(new Category(autoId++, "Thực Phẩm"));
	}
	public static void categoryUpdate() {
		Scanner sc =  new Scanner(System.in);
		System.out.println("\n----CẬP NHẬT THÔNG TIN LOẠI HANG-----");
		System.out.println("Các chức năng cập nhật");
	    System.out.println("\t1. Xem danh sach loại hàng");
	    System.out.println("\t2. Thêm mội loại hàng mới");
	    System.out.println("\t3. Sửa thông tin loại hàng trong danh sách");
	    System.out.println("\t4. Xóa thông tin loại hàng trong danh sách");
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
		System.out.println("\n--------XOA THONG TIN LOAI HANG-------");
		System.out.print("Nhap ID loai hang : ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCategory(id);
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
		System.out.println("\n--------SUA THONG TIN LOAI HANG-------");
		System.out.print("Nhap ID loai hang : ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOfCategory(id);
		if (index != -1) {
			System.out.print("\tNhập tên loại hàng mới : ");
			String name  = sc.nextLine();
			if (name == null || name.trim().length()==0) {
				System.out.println("\tTen loai hàng không được để trống");
				return;
			}
			if (nameIsExist(name)) {
				System.out.println("\tTen này đã tồn tại trong danh sách");
				return;
			}
			list.get(index).setName(name);
		}else {
			System.out.println("\tId khong co trong danh sach");
		}
	}
	public static int indexOfCategory(int id) {
		
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
		Category newCategory = new Category();
		String name  = sc.nextLine();
		if (name == null || name.trim().length()==0) {
			System.out.println("\tTen loai hàng không được để trống");
			return;
		}
		if (nameIsExist(name)) {
			System.out.println("\tTen này đã tồn tại trong danh sách");
			return;
		}
		newCategory.setName(name);
		newCategory.setId(autoId++);
		System.out.println("\tThêm mới thành công");
		list.add(newCategory);
		
		
	}
	private static boolean nameIsExist(String name) {
		for (Category category : list) {
			if (category.getName().trim().equals(name.trim())) {
				return true;
			}
		}
		return false;
	}
	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("\n\tDANH SÁCH LOẠI HÀNG");

		System.out.printf("%-5s %-30s\n", "Id", "Category Name");
		for (Category category : list) {
			category.display();
		}
	}
	
	public static String getNameById(int id) {
		for (Category category : list) {
			if (category.getId()==id) {
				return category.getName();
			}
		}
		return null;
	}
	
}
