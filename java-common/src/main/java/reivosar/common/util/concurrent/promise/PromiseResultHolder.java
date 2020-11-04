package reivosar.common.util.concurrent.promise;

import java.util.Collection;
import java.util.Optional;

public interface PromiseResultHolder<T>
{
	 boolean success();

	 boolean fail();

	 T nullableResult();

	 Optional<T> result();

	 Collection<T> results();

	 Throwable nullableError();

	 Optional<Throwable> error();

	 Collection<Throwable> errors();
}
