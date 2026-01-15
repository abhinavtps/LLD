package Design_Patterns.Structural_Patterns.Factory_Pattern;

public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS Notification with message: " + message);
    }
    
}
