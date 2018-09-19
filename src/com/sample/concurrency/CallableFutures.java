package com.sample.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutures {
	private static final int NTHREDS = 10;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        
        ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);
        
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 20; i++) {
            Callable<Integer> worker = new MyCallable();
            //Future<Integer> submit = executor.submit(worker);
            Future<Integer> submit = completionService.submit(worker);
            list.add(submit);
        }
        int sum = 0;
        System.out.println(list.size());
        // now retrieve the result
        for (Future<Integer> future : list) {
            try {
                //sum += future.get();
            	sum += completionService.take().get();
            	System.out.println("Inside try");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        executor.shutdown();
    }
    
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
    	int nextInt = new Random().nextInt(1000);
    	System.out.println("next Int is : "+nextInt);
        return nextInt; 
    }
}
