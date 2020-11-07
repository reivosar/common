package reivosar.common.util.concurrent.promise;

import java.util.Collection;
import java.util.Optional;

import reivosar.common.util.concurrent.CompletableFutures;

class PromiseBuilder<T> {

	Promise<T> build(final CompletableFutures<T> futures) {
		return new Promise<T>() {
			public boolean success() {
				return futures.success();
			}
			public boolean fail() {
				return futures.fail();
			}
			public T nullableResult() {
				if (fail()) {
					return null;
				}
				if (futures.results().size() == 0) {
					return null;
				}
				return results().stream().findFirst().get();
			}
			public Optional<T> result() {
				return Optional.ofNullable(nullableResult());
			}
			public Collection<T> results() {
				return futures.results();
			}
			public Throwable nullableError() {
				if (fail()) return null;
				return errors().stream().findFirst().get();
			}
			public Optional<Throwable> error() {
				return Optional.ofNullable(nullableError());
			}
			public Collection<Throwable> errors() {
				return futures.errors();
			}
		};
	}
}
