package net.sc.future.endpoint;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MathEngineTask {

	public static Executor executor = Executors.newFixedThreadPool(10);

}
