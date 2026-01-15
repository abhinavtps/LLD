package Design_Patterns.Structural_Patterns.Factory_Pattern;

public class SmsNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
