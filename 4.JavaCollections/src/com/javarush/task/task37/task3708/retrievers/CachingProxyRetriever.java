package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private final OriginalRetriever originalRetriever;
    private final LRUCache<Long, Object> lruCache;
    private Storage storage;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache(16);
    }

    @Override
    public Object retrieve(long id) {
        if (lruCache.find(id) == null) {
            lruCache.set(id, originalRetriever.retrieve(id));
        }
        return lruCache.get(id);
    }
}
