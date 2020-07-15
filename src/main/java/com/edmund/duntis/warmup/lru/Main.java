package com.edmund.duntis.warmup.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {

		LRU lru = new LRU(4);
		lru.set("a", 1);
		lru.set("b", 2);
		lru.set("c", 3);
		lru.set("d", 4);
		lru.print();

		lru.get("c");
		lru.print();

		lru.set("e", 5);
		lru.print();

	}
}

class LRU {
	private final int maxSize;
	private final float loadFactor = 0.75f;

	private Map<String, Integer> cache;

	@SuppressWarnings("serial")
	public LRU(int size) {
		this.maxSize = size;
		int initSize = (int) Math.ceil(maxSize / loadFactor);
		cache = new LinkedHashMap<String, Integer>(initSize, loadFactor, true) {
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<String, Integer> eldest) {
				return size() > maxSize;
			}
		};
	}

	public Optional<Integer> get(String key) {
		Integer value = cache.get(key);
		return Optional.ofNullable(value);
	}

	public void set(String key, Integer value) {
		if (value != null) {
			cache.put(key, value);
		}

	}

	public void print() {
		System.out.println();
		for (Map.Entry<String, Integer> e : cache.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
	}

}