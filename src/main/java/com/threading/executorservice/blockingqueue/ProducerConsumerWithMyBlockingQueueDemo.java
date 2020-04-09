/**
 * 
 */
package main.java.com.threading.executorservice.blockingqueue;

import java.util.Random;

import main.java.com.model.MyBlockingQueue;

/**
 * @author rk
 *
 */
public class ProducerConsumerWithMyBlockingQueueDemo {

	public static MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);
			
	public static void main(String[] args)  {
		
		Thread producedThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
			
		});
		
		Thread consumerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(100);
					consumer();
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
			
		});
		
		producedThread.start();
		consumerThread.start();
	}
	
	
	public static void producer() throws InterruptedException {
		Random random = new Random();
		while(true){
				Thread.sleep(2000);
				int produced = random.nextInt(100);
				queue.put(produced);
				System.out.println("Produced --"+produced);
		}
	}
	
	
	public static void consumer() throws InterruptedException {
			while(true) {
				Thread.sleep(2000);
				Integer consume = queue.take();
				System.out.println("Consumed --"+consume);
			}
		}
	
	
}	
