package InterviewQuestions.NotificationManagementSystem;

interface NotificationGateway {
    void send(Notification notification) throws  Exception;
}
