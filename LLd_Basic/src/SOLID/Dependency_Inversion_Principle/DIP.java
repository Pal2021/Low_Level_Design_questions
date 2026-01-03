package SOLID.Dependency_Inversion_Principle;
/*
Definition (Simple)

High-level modules should depend on abstractions, not concrete classes.
 */
class MySQLDatabase {
    void save() {}
}

class UserService {
    MySQLDatabase db = new MySQLDatabase();
}
/*
Problem:

DB change → code change

Hard to test
 */

interface Database {
    void save();
}

class MySQLDatabase implements Database {
    public void save() {
        System.out.println("Saved in MySQL");
    }
}

class UserService {
    Database db;

    UserService(Database db) {
        this.db = db;
    }
}
/*
Benefits:

Loose coupling

Easy testing

Easy DB change
 */