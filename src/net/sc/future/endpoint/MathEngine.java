package net.sc.future.endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import net.sc.future.entity.Request;
import net.sc.future.front.App;

public class MathEngine {

	int x;
	
	public static void addByX(int x, Request in){
		Integer[] ret = new Integer[in.getData().length];
		for (int i = 0; i < in.getData().length; i++){
			ret[i] = in.getData()[i]+x;
		}
		in.getResponse().setData(ret);
	}

	/**
	 * using runAsync and returning a list of Future.
	 * 
	 * @param in
	 * @param appConsumer
	 */
	public List<CompletableFuture<Void>> acceptBatch(Request[] in) {
		List<CompletableFuture<Void>> ret = new ArrayList<>();
		for (int i = 0; i < in.length; i++){
			final int index = i;
			ret.add(CompletableFuture.runAsync(() ->
				{
			        try {
						TimeUnit.SECONDS.sleep(index);
					} catch (InterruptedException e) {
					}
					addByX(2, in[index]);
				}, MathEngineTask.executor
			).thenRun(() -> {
				App.printOutput(in);
				})
					
			);
		}
		return ret;
	}
	
}
