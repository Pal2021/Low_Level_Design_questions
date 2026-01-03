package SOLID.Single_Responsibility_Principle;
/*
Why SRP Exists
When one class handles multiple responsibilities:
Any small change risks breaking other logic
Testing becomes hard
Code becomes tightly coupled

Benefits:
Each class has one job
Easy to change
Easy to test
 */

//Bad Design
class UserService {

    void saveUser() {
        // save user to DB
    }

    boolean validateUser() {
        // validation logic
        return true;
    }

    void sendEmail() {
        // email logic
    }
}
/*
Problems:
Validation change → class changes
DB change → class changes
Email change → class changes
 Too many responsibilities
 */
/////////////////////////////////////////////////////
//Good Code
class User {
    String name;
    String email;
}

class UserValidator {
    boolean validate(User user) {
        return user.email.contains("@");
    }
}

class UserRepository {
    void save(User user) {
        System.out.println("User saved to DB");
    }
}


