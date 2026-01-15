This is Factory method pattern
which is little bit different from factory pattern

Factory pattern says you can have a dedicated factory for the different type of objects

But Factory method pattern is little bit upgrade

Lets consider a example of Notification service
Since we can have multiple type of notification service
it makes sence to have a interface and then have different concrete classes
implement that interface
1. Notification - interface
2. EmailNotification - concrete class implementing Notification
3. PushNotification - concrete class implementing Notification
4. SmsNotification - concrete class implementing Notification

Now what this Notification interface will contain
Ans - Most common method, send method implemented by all implementations


Now lets move to the other side

Here the concept is like we will have Creators
1. NotificationCreator -- abstract class
2. EmailNotificationCreator -- concrete class responsible for creating EmailNotification
3. PushNotificationCreator -- concrete class responsible for creating PushNotification
4. SmsNotificationCreator -- concrete class responsible for creating SmsNotification


Now what logic we need to have in these Creators
1. In NotificationCreator we will need to have Factory Method
This FactoryMethod is overridden by each of the creators and they return their own objects
Once we recieve that object, we can have send call on that object.
But this abstract class should have the dependency on the interface rathar than the concrete classes of that interface.

Now go check the code written


in the FactoryMethodRunner.java
now if in future we want to add a new channel for communication
we can just add 2 files
1. SlackNotification
2. SlackNotificationCreator
3. and then just call notifyUser for SlackNotificationCreator