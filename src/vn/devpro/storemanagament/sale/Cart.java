package vn.devpro.storemanagament.sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.devpro.storemanagament.update.customer.CustomerManamgenment;
import vn.devpro.storemanagament.update.product.ProductManagenment;

public class Cart {
	private int id, customerId;
	private  List<CartProduct> list = new ArrayList<CartProduct>();
	public  double cartTatol() {
		double total = 0;
		for (CartProduct cartProduct : list) {
			total+= cartProduct.tatal();
		}
		return total;
	}
	public void display() {//hien thi gio hang
		System.out.println("\n------GIO HANG CUA BAN------");
		System.out.println("\tTen khach hang : " + CustomerManamgenment.getNameById(customerId));
		System.out.println("\tGio hang cp "+list.size()+" loai hang hoa ");
		System.out.printf("%3s %-30s %-15s %-12s %-15s\n","STT","Ten hang","Don gia","So luong","Thanh Tien"
				);
		int i=1;
		for (CartProduct cartProduct : list) {
			System.out.printf("%-3d ",i++);
			cartProduct.display();
		}
		double total = cartTatol();
		System.out.printf("Thanh toan : %,.2f\n" , total);
	}
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int id, int customerId, List<CartProduct> list) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<CartProduct> getList() {
		return list;
	}
	public void setList(List<CartProduct> list) {
		this.list = list;
	}
	Scanner sc = new Scanner(System.in);
	public void add() {//them moi hang hoa vao gio hang
		System.out.println("\n---THEM HANG HOA VAO GIO---");
		System.out.print("Nhap ma hang (id) muon luu voa gio : ");
		int productId = Integer.parseInt(sc.nextLine());
		//Kiem tra id co trong danh sach hang hoa da ban hay khong
		int index = ProductManagenment.indexOfProduct(productId);
		if (index == -1) {
			System.out.println("Hang hoa khong co trong gio hang");
			return;
		}
		//CO thi nhap so luong can mua

		System.out.print("Nhap so luong muon mua : ");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount<=0) {
			System.out.println("So luong mua phai hon hon 0");
		}
		int cartIndex =indexOfCartProdcut(productId);
		//Tim xem hang hoa da co trong gio hang chua
		if (cartIndex!=-1) {
			amount += list.get(cartIndex).getAmount();
		}
		//Kiem tra tong so luong mua co vuot qua tong so luong dang co ban
		
		if (amount >ProductManagenment.getList().get(index).getAmout()) {
			System.out.println("So luong mua vuot qua kha nang, xin chon lai");
			return ;
		}
		//Them hang vao gio
		
		if (cartIndex  != -1 ) {//Hang da co trong gio
			list.get(cartIndex).setAmount(amount);//Set lai so luong moi
			CartProduct cartProduct = list.get(cartIndex);
			double amountLive = cartProduct.getAmount()- amount;
			cartProduct.setAmount(amountLive);
			
		}else {
			list.add(new CartProduct(productId,amount));//Them hang moi vao gio
			
		}
	}
	//kiem tra mot hang hoa co trong gio chua
	public int indexOfCartProdcut(int productId) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getProductId()==productId) {
				return i;
			}
		}
		return -1;
	}
	
	public void update() {//sua thong tin hang hia trin gio
		System.out.println("\n---SUA THONG TIN HANG HOA VAO GIO---");
		System.out.print("Nhap ma hang (id) muon sua : ");
		int productId = Integer.parseInt(sc.nextLine());
		//Kiem tra id co trong danh sach hang hoa da ban hay khong
		int cartIndex =indexOfCartProdcut(productId);
				if (cartIndex == -1) {
					System.out.println("Hang hoa khong co trong gio hang");
					return;
				}
				//CO thi nhap so luong can mua

				System.out.print("Nhap so luong moi : ");
				double amount = Double.parseDouble(sc.nextLine());
				if (amount<=0) {
					System.out.println("So luong mua phai hon hon 0");
				}
				//Kiem tra tong so luong mua co vuot qua tong so luong dang co ban

				int index = ProductManagenment.indexOfProduct(productId);
				if (amount >ProductManagenment.getList().get(index).getAmout()) {
					System.out.println("So luong mua vuot qua kha nang, xin chon lai");
					return ;
				}
				
				//Thay so cu bang so luong moi
				list.get(cartIndex).setAmount(amount);

				System.out.println("Sua so luong thanh cong");
	}
	public void remove() {//Xoa hang khoi gio
		System.out.println("\n---XOA THONG TIN HANG HOA VAO GIO---");
		System.out.print("Nhap ma hang (id) muon sua : ");
		int productId = Integer.parseInt(sc.nextLine());
		//Kiem tra id co trong danh sach hang hoa da ban hay khong
		int cartIndex =indexOfCartProdcut(productId);
				if (cartIndex == -1) {
					System.out.println("Hang hoa khong co trong gio hang");
					return;
				}
			list.remove(cartIndex);

			System.out.println("Xoa so luong thanh cong");
	}
	
}
