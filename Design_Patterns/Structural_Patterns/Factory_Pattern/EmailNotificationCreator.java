package Design_Patterns.Structural_Patterns.Factory_Pattern;

public class EmailNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
    
}
