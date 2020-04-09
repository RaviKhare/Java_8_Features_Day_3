/**
 * 
 */
package main.java.com.model;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author rk
 *
 */


public class TaskWithCallable implements Callable<Integer>{


	@Override
	public Integer call() throws Exception {
		Thread.sleep(3000);
		return new Random().nextInt();
	}
	
	
	
}
