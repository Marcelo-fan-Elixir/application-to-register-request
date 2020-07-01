package application_pedidos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.application_pedidos.Client;
import entities.application_pedidos.Order;
import entities.application_pedidos.OrderItem;
import entities.application_pedidos.Product;
import entities.application_pedidos.enums.OrderStatus;

public class Application_pedidos {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth Date DD/MM/YYYY: ");
		Date bdate = sdf.parse(sc.nextLine());
		
		Client c1 = new Client(name, email, bdate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Order order = new Order(OrderStatus.valueOf(status), c1);
		
		System.out.print("How many items to this order ?: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <=n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			sc.nextLine();
			System.out.print("Product name: ");
			String pName = sc.nextLine();
			
			System.out.print("Product price: ");
			double pPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int pQuantity = sc.nextInt();
			
			OrderItem oi = new OrderItem(pQuantity, pPrice, new Product(pName, pPrice));
			
			order.addItem(oi);
		}
		
		System.out.println(order);
		
		sc.close();

	}
	
}
