package vn.devpro.storemanagament.update;

import java.util.Scanner;

import vn.devpro.storemanagament.update.category.CategoryManagament;
import vn.devpro.storemanagament.update.customer.CustomerManamgenment;
import vn.devpro.storemanagament.update.product.ProductManagenment;

public class SystemInformationManagament {
	public static void execute() {
		Scanner sc =  new Scanner(System.in);
		do {
		    System.out.println("======CAP NHAT THONG TIN HE THONG======");
		    System.out.println("Các chức năng ");
		    System.out.println("\t1. Cập nhật thông tin loai hang");
		    System.out.println("\t2. Cập nhật thông tin hàng hóa");
		    System.out.println("\t3. Cập nhật thông tin khách hàng");
		    System.out.println("\t0. Quay lại");
		    System.out.print("lựa chọn chức năng quản lý :");
		    int n = Integer.parseInt(sc.nextLine());
		    switch (n) {
			case 1: {
				CategoryManagament.categoryUpdate();
				break;
			}
			case 2: {
				ProductManagenment.productUpdate();
				break;
			}
			case 3: {
				CustomerManamgenment.customerUpdate();
				break;
			}
			case 0: {
				return;
			}
			default: System.out.println("lua chon khong hop le");
			}
		} while (true);
		
	}
}
