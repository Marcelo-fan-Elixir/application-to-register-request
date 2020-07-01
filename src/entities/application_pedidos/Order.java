package entities.application_pedidos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.application_pedidos.enums.OrderStatus;

public class Order {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment = new Date();
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}
	
	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
	}

	

	public Date getMoment() {
		return moment;
	}



	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	
	public double total() {
		double result = 0.0;
		for (OrderItem ot : items) {
			 result += ot.subTotal();
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY" + "\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order items: " + "\n");
		for(OrderItem oi : items) {
			sb.append(oi.getProduct().getName()
					+ ", $" 
					+ oi.getProduct().getPrice() 
					+ ", Quantity: " 
					+ oi.getQuantity() 
					+ " Subtotal: $" + oi.subTotal() + "\n");
		}
		sb.append("Total price: " + total());
		
		return sb.toString();
	}
	
	
	
}
