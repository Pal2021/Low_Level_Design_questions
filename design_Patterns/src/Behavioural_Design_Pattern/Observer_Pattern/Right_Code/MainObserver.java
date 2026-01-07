package Behavioural_Design_Pattern.Observer_Pattern.Right_Code;
/*
Observer Pattern is like a notification system. When something important happens, all interested parties get notified automatically.
Real-life example:

YouTube Channel = Subject (the one being watched)
Subscribers = Observers (the ones watching)
When a channel uploads a video, all subscribers get notified automatically 🔔
 */
public class MainObserver {
    public static void main(String[] args) {
        YouTubeChannel techChannel=new YouTubeChannel("techops");
        Subscriber subscriber1=new Subscriber("alice");
        Subscriber subscriber2=new Subscriber("bob");
        Subscriber subscriber3=new Subscriber("paul");

        // Subscribers subscribe to the channel
        techChannel.subscribe(subscriber1);
        techChannel.subscribe(subscriber2);
        techChannel.subscribe(subscriber3);

        // Channel uploads a new video - all subscribers get notified
        techChannel.uploadVideo("Java Design Patterns Tutorial");

        System.out.println("\n--- Bob unsubscribed ---");
        techChannel.unsubscribe(subscriber2);

        // Channel uploads another video - only remaining subscribers get notified
        techChannel.uploadVideo("Spring Boot Complete Course");

    }
}
