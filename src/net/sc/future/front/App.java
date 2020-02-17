package net.sc.future.front;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import net.sc.future.endpoint.MathEngine;
import net.sc.future.entity.Request;

public class App {

	MathEngine engine = new MathEngine();
	public void printOutput(Request[] in){
		for (Request request : in){
			Arrays.stream(request.getResponse().getData()).forEach(System.out::print);
			System.out.println();
		}
		System.out.println();
	}
	
	public List<CompletableFuture<Void>> submitBatch(Request[] in){
		 List<CompletableFuture<Void>> tasks = engine.acceptBatch(in);
		 return tasks;
	}
	
	public void callEndpoint(Request[] in){
		List<CompletableFuture<Void>> tasks = null;
		tasks = submitBatch(in);
		for (CompletableFuture<Void> task : tasks){
			try {
				task.get();
				printOutput(in);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args){
		App test = new App();
		Request a = new Request(1,"Sean",new Integer[]{1,2,3,4,5});
		Request b = new Request(2,"Chloe",new Integer[]{2,4,6,8,10});
		Request c = new Request(1,"Charlotte",new Integer[]{3,6,9,12,15});
		Request d = new Request(1,"Lynn",new Integer[]{5,10,15,20,25});
		Request[] in = new Request[]{a,b,c,d};
		test.callEndpoint(in);
	}
}

