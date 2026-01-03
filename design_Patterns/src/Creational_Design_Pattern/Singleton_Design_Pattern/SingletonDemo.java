package Creational_Design_Pattern.Singleton_Design_Pattern; /**
 * SINGLETON PATTERN - Concise Demonstration
 * Problem: Need exactly one instance of a class throughout the application
 */

import java.util.*;

/* ========================================
   WRONG WAY - Multiple Instances
   ======================================== */

// 🚨 BAD: Anyone can create multiple instances
class BadDatabaseConnection {
    private boolean isConnected;

    public BadDatabaseConnection() {
        System.out.println("🚨 BAD: Creating new database connection...");
        // Simulate expensive initialization
        try { Thread.sleep(50); } catch (InterruptedException e) {}
        this.isConnected = true;
    }

    public void executeQuery(String query) {
        System.out.println("🚨 Executing: " + query);
    }
}

// 🚨 BAD: Configuration loaded multiple times
class BadConfigManager {
    private Map<String, String> config = new HashMap<>();

    public BadConfigManager() {
        System.out.println("🚨 BAD: Loading configuration...");
        try { Thread.sleep(30); } catch (InterruptedException e) {}
        config.put("db.host", "localhost");
        config.put("app.name", "MyApp");
    }

    public String get(String key) { return config.get(key); }
    public void set(String key, String value) { config.put(key, value); }
}

/* ========================================
   RIGHT WAY - Singleton Pattern
   ======================================== */

// ✅ GOOD: Thread-safe Singleton
class GoodDatabaseConnection {
    private static volatile GoodDatabaseConnection instance;
    private static final Object lock = new Object();
    private boolean isConnected;

    // Private constructor prevents external instantiation
    private GoodDatabaseConnection() {
        System.out.println("✅ GOOD: Creating single database connection...");
        try { Thread.sleep(50); } catch (InterruptedException e) {}
        this.isConnected = true;
    }

    // Double-checked locking for thread safety
    public static GoodDatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new GoodDatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("✅ Executing: " + query);
    }
}

// ✅ BEST: Enum-based Singleton (recommended)
enum GoodConfigManager {
    INSTANCE;

    private Map<String, String> config = new HashMap<>();

    // Constructor called only once
    GoodConfigManager() {
        System.out.println("✅ GOOD: Loading configuration once...");
        try { Thread.sleep(30); } catch (InterruptedException e) {}
        config.put("db.host", "localhost");
        config.put("app.name", "MyApp");
    }

    public String get(String key) { return config.get(key); }

    public void set(String key, String value) {
        config.put(key, value);
        System.out.println("✅ Config updated globally: " + key + " = " + value);
    }
}

/* ========================================
   DEMONSTRATION
   ======================================== */

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("🏛️ SINGLETON PATTERN DEMO");

        // BAD WAY - Multiple instances
        System.out.println("\n🚨 BAD WAY - Multiple Instances:");
        BadDatabaseConnection db1 = new BadDatabaseConnection();
        BadDatabaseConnection db2 = new BadDatabaseConnection(); // Another expensive creation!
        BadConfigManager config1 = new BadConfigManager();
        BadConfigManager config2 = new BadConfigManager();

        config1.set("cache.size", "100");
        System.out.println("Config1 cache: " + config1.get("cache.size"));
        System.out.println("Config2 cache: " + config2.get("cache.size")); // Inconsistent!

        System.out.println("Same instances? " + (db1 == db2)); // false

        System.out.println("\n✅ GOOD WAY - Single Instance:");
        GoodDatabaseConnection goodDb1 = GoodDatabaseConnection.getInstance();
        GoodDatabaseConnection goodDb2 = GoodDatabaseConnection.getInstance(); // No new creation!
        GoodConfigManager goodConfig1 = GoodConfigManager.INSTANCE;
        GoodConfigManager goodConfig2 = GoodConfigManager.INSTANCE;

        goodConfig1.set("cache.size", "200");
        System.out.println("Config1 cache: " + goodConfig1.get("cache.size"));
        System.out.println("Config2 cache: " + goodConfig2.get("cache.size")); // Consistent!

        System.out.println("Same instances? " + (goodDb1 == goodDb2)); // true

        System.out.println("\n📊 BENEFITS:");
        System.out.println("✅ Resource efficient - only one instance");
        System.out.println("✅ Consistent state across application");
        System.out.println("✅ Controlled access to critical resources");
        System.out.println("✅ Thread-safe implementation");

        System.out.println("\n⚠️ WHEN TO USE:");
        System.out.println("- Database connections");
        System.out.println("- Configuration managers");
        System.out.println("- Logging services");
        System.out.println("- Cache managers");
    }
}