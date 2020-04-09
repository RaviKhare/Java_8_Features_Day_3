/**
 * 
 */
package main.java.com.threading.executorservice.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import main.java.com.model.Order;

/**
 * @author rk
 *
 */
public class ExecutorWithCompletableFuture {

	public static void main(String[] args)  {
		
		 ExecutorService service = Executors.newFixedThreadPool(50);
		
		 CompletableFuture<Order> future  =	CompletableFuture
				 .supplyAsync(() -> getOrder());
				try {
					future.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
		 
		 List<CompletableFuture> completableFutureList = new ArrayList<CompletableFuture>();
		 for (int i=0; i < 10; i++) {		
	 		 CompletableFuture<Order> futureObj  =	CompletableFuture
					 .supplyAsync(() -> getOrder())
					 .thenApply((order) -> enrichOrder(order))
					 .thenApply((order) -> dispatch(order))
					 .thenApply((order) -> performPayment(order))
					 .thenApply((order) -> dispatch(order));
				
	 		 completableFutureList.add(futureObj);
	 	 }	  		
		 
		 List<CompletableFuture> completableFutureList1 = new ArrayList<CompletableFuture>();
		 for (int i=0; i < 10; i++) {		
	 		 CompletableFuture futureObj1  =	CompletableFuture
					 .supplyAsync(() -> getOrder())
					 .thenApplyAsync((order) -> enrichOrder(order), service)
					 .thenApplyAsync((order) -> dispatch(order), service)
					 .thenApplyAsync((order) -> performPayment(order), service)
					 .thenApply((order) -> dispatch(order))
					 .thenAccept((order) -> convertToFinish(order));
	 	
	 		 completableFutureList1.add(futureObj1);
	 	 }	
		 		
		}	
	
	
	
		 
		 public static Order getOrder() {
			 return new Order();
		 }
		 
		 private static Order convertToFinish(Order order) {
		        System.out.println("Order is completed: " );
		        order.setOrderBillAmount(654.33);
		        //  some operation 
		        return order;
		    }
		 
		 public static Order enrichOrder(Order order) {
			 // perform opration on the order 
			 order.setOrderQuantity(20);
			 order.setOrderFlavour("mild spicy");
			 return order;
		 }
		 
		 public static Order performPayment(Order order) {
			 // perform some more operation  
			 order.setOrderQuantity(20);
			 order.setOrderBillAmount(2354.83);
			 return order;
		 } 
		 
		 public static Order dispatch(Order order) {
			 // perform some operation  
			
			 return order;
		 } 
	
}	
