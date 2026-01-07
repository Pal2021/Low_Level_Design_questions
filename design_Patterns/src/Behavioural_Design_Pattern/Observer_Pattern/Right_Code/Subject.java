package Behavioural_Design_Pattern.Observer_Pattern.Right_Code;

public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}