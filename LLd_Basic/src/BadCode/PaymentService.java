package BadCode;

class PaymentService {
    void pay(String type) {
        if (type.equals("UPI")) {
            System.out.println("UPI payment");
        } else if (type.equals("CARD")) {
            System.out.println("Card payment");
        }
    }
}
/*
1.Code Maintainability
Problem:

Tomorrow you add NetBanking

You must modify existing code

Risk of breaking old logic
 */