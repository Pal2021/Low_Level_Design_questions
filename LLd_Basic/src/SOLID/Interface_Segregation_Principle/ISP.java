package SOLID.Interface_Segregation_Principle;
/*
Definition (Simple)

Don’t force a class to implement methods it doesn’t need.
 */
interface Worker {
    void work();
    void eat();
}
class Robot implements Worker {
    public void work() {}
    public void eat() {}  // ❌ Robot doesn’t eat
}

/*
Good code
Benefits:

No unnecessary methods

Clean & flexible design
 */

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() {}
    public void eat() {}
}

class Robot implements Workable {
    public void work() {}
}
