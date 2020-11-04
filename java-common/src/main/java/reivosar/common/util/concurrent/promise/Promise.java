package reivosar.common.util.concurrent.promise;

import java.util.function.Consumer;

public interface Promise<T> extends PromiseResultHolder<T>
{
	public static <T>PromiseHandler<T> single() {
		return multi(1);
	}

	public static <T>PromiseHandler<T> multi(final int multiple) {
		return new PromiseHandler<T>();
	}

	default Promise<T> onSuccess(final Consumer<T> consumer) {
		if (success())
			results().stream().forEach(result -> consumer.accept(result));
		return this;
	}

	default Promise<T> onFailure(final Consumer<Throwable> consumer) {
		if (fail())
			errors().stream().forEach(result -> consumer.accept(result));
		return this;
	}
}
