package reivosar.common.util.concurrent;

import java.util.concurrent.Future;

public class CompletableFutureResultWrapper<T> {

	private final T result;
	private final Throwable error;

	public CompletableFutureResultWrapper(T result, Throwable error) {
		this.result = result;
		this.error  = error;
	}

	public static <T> CompletableFutureResultWrapper<T> of(final Future<T> future) {
		try {
			return new CompletableFutureResultWrapper<T>(future.get(), null);
		} catch (Throwable error) {
			return new CompletableFutureResultWrapper<T>(null, error);
		}
	}

	public static <T> CompletableFutureResultWrapper<T> of(T result, Throwable error) {
		return new CompletableFutureResultWrapper<T>(result, error);
	}

	public boolean success() {
		return !fail();
	}

	public boolean fail() {
		return error() != null;
	}

	public T result() {
		return success() ? this.result : null;
	}

	public Throwable error() {
		if (this.error != null)
			return this.error;

		if (this.result instanceof Throwable)
			return (Throwable) this.result;

		return null;
	}
}
