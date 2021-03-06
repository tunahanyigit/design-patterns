package flyweight;

import java.util.WeakHashMap;

public class CoffeeFlavour {
    private final String name;
    private static final WeakHashMap<String, CoffeeFlavour> CACHE = new WeakHashMap<>();

    public CoffeeFlavour(String name) {
        this.name = name;
    }

    public static CoffeeFlavour getCoffeeFlavour(String name) {
        synchronized (CACHE) {
            return CACHE.computeIfAbsent(name, CoffeeFlavour::new);
        }
    }

    public static int flavourSize() {
        synchronized (CACHE) {
            return CACHE.size();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
