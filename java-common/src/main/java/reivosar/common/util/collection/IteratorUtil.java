package reivosar.common.util.collection;

import java.util.Iterator;
import java.util.function.Predicate;

import org.apache.commons.collections4.iterators.FilterIterator;

public class IteratorUtil {

    private IteratorUtil() {
    }

    public static <E> Iterator<E> filteredIterator(final Iterator<? extends E> iterator,
            final Predicate<? super E> predicate) {
        if (iterator == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null");
        }
        return new FilterIterator<>(iterator, new org.apache.commons.collections4.Predicate<E>() {
            @Override
            public boolean evaluate(E object) {
                return predicate.equals(object);
            }
        });
    }
}
