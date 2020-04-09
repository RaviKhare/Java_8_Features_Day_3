/**
 * 
 */
package main.java.com.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rk
 * @param <E>
 * @param <E>
 *
 */
public class MyBlockingQueue<E> {
	
	private int max;
	private Queue<E> queue = new LinkedList<>();
	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	
	
	public MyBlockingQueue(int size) {
		super();
		
		this.queue = new LinkedList<>();
		this.max = size;
	}
	
	public E take () {
		lock.lock();
		try {
			while(this.queue.size() == 0) {
				notEmpty.await();
			}
			E item = this.queue.remove();
			this.notFull.signalAll();
			return item;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
		return null;
	}

	public void put (E item) {
		lock.lock();
		try {
			if(this.queue.size() == max) {
				notFull.await();
			}
			this.queue.add(item);
			this.notEmpty.signalAll();
	} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
	}
	
	
}	
