package Behavioural_Design_Pattern.Observer_Pattern.Right_Code;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {
    private List<Observer> subscribers = new ArrayList<>();
    private String channelName;
    private String latestVideo;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
        System.out.println("New subscriber added to " + channelName);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
        System.out.println("Subscriber removed from " + channelName);
    }

    @Override
    public void notifyObservers() {
        System.out.println("\n[" + channelName + "] Notifying all subscribers...");
        for (Observer observer : subscribers) {
            observer.update(latestVideo);
        }
    }

    public void uploadVideo(String videoTitle) {
        this.latestVideo = videoTitle;
        System.out.println("\n" + channelName + " uploaded: " + videoTitle);
        notifyObservers();
    }

    public String getChannelName() {
        return channelName;
    }
}
