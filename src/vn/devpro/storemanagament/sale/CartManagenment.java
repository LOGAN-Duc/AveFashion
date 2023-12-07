package vn.devpro.storemanagament.sale;

import java.util.Scanner;

import vn.devpro.storemanagament.saleorder.SaleOderManagenment;
import vn.devpro.storemanagament.update.customer.Customer;
import vn.devpro.storemanagament.update.customer.CustomerManamgenment;

public class CartManagenment {
	//khoi tao gio hang
	//khach hang thuc hien
		//xem gio hang
	    //dua hang vao gio
	    //Sua so luong
	    //xoa hang 
		//thanh toan
		//huy gio hang
		//
	public static int autoID = 1;
	public static void cartManagenment() {//Moo phien giao dich moi
		Cart cart = new Cart();//Khoi tao gio hang moi
		Scanner sc =  new Scanner(System.in);
		System.out.println("\n CHAO MUNG QUY KHACH DEN MUA HANG");
		do {
			System.out.println("Chon thao tac voi gio hang cua ban");
			System.out.println("\t1. Xem thong tin gio hang");
			System.out.println("\t2. Them hang vao gio hang");
			System.out.println("\t3. Sua so luong gio hang");
			System.out.println("\t4. Xoa hang khoi gio hang");
			System.out.println("\t5. Huy gio hang");
			System.out.println("\t6. Thanh toan gio hang");
			System.out.println("\t0. Thoat");
			System.out.print("lựa chọn chức năng :");
		    int n = Integer.parseInt(sc.nextLine());
		    switch (n) {
		    case 1:
		    	cart.display();
				break;
		    case 2:
		    	cart.add();
				break;
		    case 3:
		    	cart.update();
				break;
		    case 4:
		    	cart.remove();
				break;
		    case 5:
		    	cart = new Cart();
		    	System.out.println("Da huy gio hang");
				break;
		    case 6:
		    	if (payment(cart)) {
					cart = new Cart();
				}
		    	
				break;
		    case 0:
		    	return;
			default:
				System.out.println("Lua chon ban khong hop le");
			}
		} while (true);
	}

	private static boolean payment(Cart cart) {// thanh toan gio hang
		//cap nhat thon tin khach hang

		Scanner sc =  new Scanner(System.in);
		System.out.println("\n----------THANH TOAN GIO HANG---------");
		//Kiem tra gio hang 
		if (cart == null||cart.getList().size()==0) {
			System.out.println("Gio hang khong co mat hang nao");
			return false;
		}
		
		System.out.print("Nhap id khach hang : ");
		int customerID = Integer.parseInt(sc.nextLine());
		int index = CustomerManamgenment.indexOfCustomer(customerID);
		
		
		String cusString = null;
		if (index == -1 ) {
			System.out.println("Nhap ten khach hang : ");
			cusString = sc.nextLine();
			if (cusString.trim().length()<=0) {
				System.out.println("Ten khach hang khong duoc de trong");
				return false;
			}
			//Them khach hang vao dnah sach khach hang
			customerID = CustomerManamgenment.autoId++;
			CustomerManamgenment.getList().add(new Customer(customerID, cusString));
		}else {
			cusString = CustomerManamgenment.getList().get(index).getName();
		}
		
		//Cap nhat thong tin gio hang
		cart.setId(autoID++);
		cart.setCustomerId(customerID);
		//HIen thi gio hang cho khach xem
		cart.display();
		//luu gio hang vao dnah sach
		SaleOderManagenment.getCarts().add(cart);	
		//Xoa gio hang
		System.out.println("Thanh toan gio hang thanh cong");
		return true;
	}
}
