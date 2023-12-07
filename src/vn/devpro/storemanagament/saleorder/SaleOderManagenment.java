package vn.devpro.storemanagament.saleorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.devpro.storemanagament.sale.Cart;
import vn.devpro.storemanagament.update.customer.CustomerManamgenment;

public class SaleOderManagenment {
	private static List<Cart> carts = new ArrayList<>();

	public static List<Cart> getCarts() {
		return carts;
	}

	public static void setCarts(List<Cart> carts) {
		SaleOderManagenment.carts = carts;
	}
	
	//Hien thi danh sách các đơn hàng
	//Tính tổng doanh thu từ các giở hàng
	//tìm kiểm giỏ hàng
	public static void saleOdermanagenment() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n-----QUAN LY DON HANG----");

		    System.out.println("Các chức năng ");
		    System.out.println("\t1. Hien thi danh sach don hang");
		    System.out.println("\t2. Tinh tong doanh thu tu cac gio hang");
		    System.out.println("\t3. Tim kiem gioi hang");
		    System.out.println("\t0.Thoat");
		    System.out.print("lựa chọn chức năng quản lý :");
		    int n = Integer.parseInt(sc.nextLine());
		    switch (n) {
			case 1: {
				display();
				break;
			}
			case 2: {
				totalDisplay();
				break;
			}
			case 3: {
				findCart();
				break;
			}
			case 0: {
				return;
			}
			default: System.out.println("lua chon khong hop le");
			}
		} while (true);
	}

	private static void findCart() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---TIM KIEM GIO HANG--");
		System.out.print("Nhap ma don hang (id)  : ");
		int cartId = Integer.parseInt(sc.nextLine());
		boolean result = false;
		for (Cart cart : carts) {
			if (cart.getId()==cartId) {
				System.out.println("Chi tiet don hang");
				cart.display();
				result = true;
			}
			
		}

	}

	private static void totalDisplay() {
		// TODO Auto-generated method stub
		System.out.printf("Tong doang thu : %,15.2f",total());
	}

	private static void display() {
		// TODO Auto-generated method stub
		System.out.println("---DANH SACH DON HANG---");
		System.out.printf("%3s %11s %-30s %-15s\n","STT","Ma don hang" ,"Ten khach hang","Doanh thu");
		int stt=1;
		for (Cart cart : carts) {
		System.out.printf("%3d ",stt++);
		System.out.printf("%11s %-30s %,15.2f\n",cart.getId(),
				CustomerManamgenment.getNameById(cart.getCustomerId())
				,cart.cartTatol());
		}
	}

	private static double total() {
		// TODO Auto-generated method stub
		double total =0;
		for (Cart cart : carts) {
			total += cart.cartTatol();
		}
		return total;
	}
	
	
	
	
}
