package Design_Patterns.Structural_Patterns.Factory_Pattern;


//This is a runner class to demonstrate Factory Method Pattern


class FactoryMethodRunner {

    public static void main(String[] args) {
        NotificationCreator emailCreator = new EmailNotificationCreator();
        emailCreator.notifyUser("This is an email notification.");

        NotificationCreator smsCreator = new SmsNotificationCreator();
        smsCreator.notifyUser("This is an SMS notification.");

        NotificationCreator pushCreator = new PushNotificationCreator();
        pushCreator.notifyUser("This is a push notification.");

        // NotificationCreator slackCreator = new SlackNotificationCreator();
        // slackCreator.notifyUser("This is a slack notification.");
    }

}

