package reivosar.common.util.concurrent;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutures<T> {

	private final Collection<CompletableFuture<T>> completableFutures;

	public CompletableFutures() {
		this.completableFutures = new LinkedHashSet<CompletableFuture<T>>();
	}

	public CompletableFutures<T> add(CompletableFuture<T> completableFutures) {
		this.completableFutures.addAll(Arrays.asList(completableFutures));
		return this;
	}

	public CompletableFuture<Void> toAllOfFutures() {
		return CompletableFuture.allOf(
			this.completableFutures.toArray(
				new CompletableFuture[completableFutures.size()])
		);
	}

	public Collection<CompletableFuture<T>> all() {
		return this.completableFutures;
	}

	public boolean success() {
		return !fail();
	}

	public boolean fail() {
		return hasErrors();
	}

	public Collection<T> results() {
		return this.all().stream()
			.map     (future  -> CompletableFutureResultWrapper.of(future))
			.filter  (wrapper -> wrapper.success())
			.map     (wrapper -> wrapper.result())
			.collect (Collectors.toUnmodifiableList());
	}

	public Collection<Throwable> errors() {
		return this.all().stream()
			.map     (future  -> CompletableFutureResultWrapper.of(future))
			.filter  (wrapper -> wrapper.fail())
			.map     (wrapper -> wrapper.error())
			.collect (Collectors.toUnmodifiableList());
	}

	private boolean hasErrors() {
		return errors().size() > 0;
	}
}
