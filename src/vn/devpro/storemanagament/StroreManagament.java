package vn.devpro.storemanagament;

import java.util.Scanner;

import vn.devpro.storemanagament.sale.CartManagenment;
import vn.devpro.storemanagament.saleorder.SaleOderManagenment;
import vn.devpro.storemanagament.update.SystemInformationManagament;
import vn.devpro.storemanagament.update.category.CategoryManagament;
import vn.devpro.storemanagament.update.customer.CustomerManamgenment;
import vn.devpro.storemanagament.update.product.ProductManagenment;

public class StroreManagament {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CategoryManagament.init();
		ProductManagenment.init();
		CustomerManamgenment.init();
		Scanner sc =  new Scanner(System.in);
		do {
		    System.out.println("======CHUONG TRINH QUAN LY CUA HANG======");
		    System.out.println("Các chức năng ");
		    System.out.println("\t1. Cập nhật thông tin hệ thống");
		    System.out.println("\t2. Quản lý bán hàng");
		    System.out.println("\t3. Quan lý don hang");
		    System.out.println("\t0.Thoat");
		    System.out.print("lựa chọn chức năng quản lý :");
		    int n = Integer.parseInt(sc.nextLine());
		    switch (n) {
			case 1: {
				SystemInformationManagament.execute();
				break;
			}
			case 2: {
				CartManagenment.cartManagenment();
				break;
			}
			case 3: {
				SaleOderManagenment.saleOdermanagenment();
				break;
			}
			case 0: {
				
				System.out.println("Thóa khỏi ứng dụng");
				System.exit(0);
			}
			default: System.out.println("lua chon khong hop le");
			}
		} while (true);
	}

}
