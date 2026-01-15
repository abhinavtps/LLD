package Design_Patterns.Structural_Patterns.Factory_Pattern;

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification with message: " + message);
    }
}