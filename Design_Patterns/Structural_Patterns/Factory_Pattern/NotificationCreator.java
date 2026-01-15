package Design_Patterns.Structural_Patterns.Factory_Pattern;

public abstract class NotificationCreator {

    public abstract Notification createNotification();

    public void notifyUser(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }   
}
