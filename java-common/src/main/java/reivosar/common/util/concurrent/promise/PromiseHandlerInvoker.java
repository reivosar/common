package reivosar.common.util.concurrent.promise;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import reivosar.common.util.concurrent.CompletableFutureResultWrapper;
import reivosar.common.util.concurrent.CompletableFutures;
import reivosar.common.util.concurrent.ExecutorServiceProvider;

class PromiseHandlerInvoker<T> {

	private final ExecutorServiceProvider executorServiceProvider;
	private final PromiseTask<T> promiseTask;

	PromiseHandlerInvoker(ExecutorServiceProvider executorServiceProvider, PromiseTask<T> promiseTask) {
		this.executorServiceProvider = executorServiceProvider;
		this.promiseTask = promiseTask;
	}

	Promise<T> invoke() {
		final CompletableFutures<T> futures = createCompletableFutures();
		watch (futures);
		return new PromiseBuilder<T>().build(futures);
	}

	private void watch(CompletableFutures<T> futures) {
		final CompletableFuture<Void> all = futures.toAllOfFutures();
		this.executorServiceProvider.start();
		while(!all.isDone()) {
			if (this.executorServiceProvider.occurredTimeout())
				this.executorServiceProvider.stop();
		}
	}

	private CompletableFuture<T> executeSupplyAsynch(final Supplier<T> supplier) {
		final CompletableFuture<T> future = executorServiceProvider.executeSupplyAsynch(supplier);
		future.whenComplete((result, error) -> {
			if (CompletableFutureResultWrapper.of(result, error).fail()) {
				this.executorServiceProvider.stop();
			}
		});
		return future;
	}

	private CompletableFutures<T> createCompletableFutures() {
		final CompletableFutures<T> result = new CompletableFutures<T>();
		this.promiseTask.forEach(supplier -> result.add(executeSupplyAsynch(supplier)));
		return result;
	}
}

