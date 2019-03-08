package atlassianmobilefinder.com.store

inline fun <T> Iterable<T>.firstOrDefault(predicate: (T) -> Boolean?, default: T): T {
    this.forEach {
        if (predicate(it) != null && predicate(it)!!) return it
    }

    return default
}


inline fun <T> Iterable<T>.findAndMap(find: (T) -> Boolean, map: (T) -> T): List<T> {
    return map {
        if (find(it)) map(it) else it
    }
}