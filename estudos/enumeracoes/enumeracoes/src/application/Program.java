package application;

import entities.Order;
import java.util.Date;

import entitiesenums.OrderStatus;

public class Program {
    public static void main(String[] args) {
        
        Order order = new Order (1080, new Date(), OrderStatus.AGUARDANDO_PAGAMENTO);
        System.out.println(order);
    }
    
}
