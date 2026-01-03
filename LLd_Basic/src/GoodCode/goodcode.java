package GoodCode;

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
/*
Why better:

New payment → new class

Old code untouched

Easy to maintain
 */