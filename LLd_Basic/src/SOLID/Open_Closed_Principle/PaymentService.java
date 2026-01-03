package SOLID.Open_Closed_Principle;
/*
Definition (Simple)
You should add new behavior
Without changing existing code
Classes should be:
Open for extension
Closed for modification
 Add new behavior without changing existing code
 */

/*
bad code
Problem:
New payment → modify existing code
 */
class PaymentService {
    void pay(String type) {
        if (type.equals("UPI")) {
            System.out.println("UPI payment");
        } else if (type.equals("CARD")) {
            System.out.println("Card payment");
        }
    }
}

/* Goode code
Old code untouched
✔️ OCP followed
 */

interface Payment {
    void pay();
}

class UPI implements Payment {
    public void pay() {
        System.out.println("UPI payment");
    }
}

class Card implements Payment {
    public void pay() {
        System.out.println("Card payment");
    }
}
//Adding new payment (No modification!)
class NetBanking implements Payment {
    public void pay() {
        System.out.println("Net banking payment");
    }
}

