package reivosar.common.util.concurrent.promise;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import reivosar.common.util.concurrent.ExecutorServiceProvider;

public class PromiseHandler<T>
{
	private final ExecutorServiceProvider executorServiceProvider;
	private final PromiseTask<T> promiseTask;

	private static final long DEFAULT_TIMEOUT = 30;

	PromiseHandler() {
		this(Executors.newFixedThreadPool(1));
	}

	PromiseHandler(final ExecutorService executorService) {
		this(executorService, DEFAULT_TIMEOUT);
	}

	PromiseHandler(final ExecutorService executorService, final long timeout) {
		this.executorServiceProvider = new ExecutorServiceProvider(executorService, timeout);
		this.promiseTask = new PromiseTask<>();
	}

	public PromiseHandler<T> then(final Supplier<T> supplier) {
		this.promiseTask.addTask(supplier);
		return this;
	}

	public PromiseHandler<T> then(final Collection<Supplier<T>> suppliers) {
		this.promiseTask.addTask(suppliers);
		return this;
	}

	public Promise<T> done() {
		return new PromiseHandlerInvoker<T>(executorServiceProvider, promiseTask).invoke();
	}
}
