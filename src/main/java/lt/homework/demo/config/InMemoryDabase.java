package lt.homework.demo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import lt.homework.demo.model.Order;

@Component
public class InMemoryDabase {
    private final Map<String, Order> database = new HashMap<>();
    
    public Map<String, Order> getDatabase() {
        return database;
    }

    public Order get(String serviceId) {
        return database.get(serviceId);
    }

    public Order put(String serviceId, Order order) {
        return database.put(serviceId, order);
    }

    public Order remove(String serviceId) {
        return database.remove(serviceId);
    }

    public boolean containsKey(String serviceId) {
        return database.containsKey(serviceId);
    }

    public boolean isEmpty() {
        return database.isEmpty();
    }

    public Stream<Order> streamValues() {
        return database.values().stream();
    }
}
