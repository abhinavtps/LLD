package Design_Patterns.Structural_Patterns.Factory_Pattern;

public class PushNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
    
}
