package Design_Patterns.Structural_Patterns;

//used for logger, configuration settings, etc. where only one instance is needed
//Singleton means that only one instance can be created
//so first we will start with the thought that how a class's instance is created
//that means object is created 
//it is done via the new keyword
// Singleton instance = new Singleton();
//note here default constructor is getting called
//so we have to avoid constructor calling -- way to do that is make constructor private


//Now since we need to atleast generate the instance one time we will neeed to have a method exposed to public for getting instance

//1. Below is the basic setup with no care of synchronization issue.

// public class Singleton {
//     private static volatile Singleton instance;

//     private Singleton()
//     {
//     }
     
//     public static Singleton getInstance()
//     {
//        if(instance == null)
//         {
//             instance = new Singleton();
//         }        
//         return instance;
//     }
// }

//the issue comes in multi-threading when both the threads read the instance value as null
//and get that instance is null and both try to create new Singleton();
//to avoid this we use the synchronized, but where?
//two options - one is to make whole function synchronized.
//other is to make the instance block synchronized.
//to make is more effective in multi-threaded env we add one more if condition
//and then make it synchronized


// public class Singleton {

//     private static volatile Singleton instance;

//     private Singleton()
//     {
//     }
     
//     public static Singleton getInstance()
//     {
//        if(instance == null)
//         {
//             synchronized(Singleton.class){
//               if(instance == null)
//               {
//                 instance = new Singleton();
//               }
//             }
//         }        
//         return instance;
//     }
// }


//above is good code supports lazy initialization and thread-safe
//but there we are maintaining locking ourselves
//one other way is we can have the JVM backed locking - so no need to provide locking ourselves

class Singleton{
     private Singleton(){}

     private static class SingletonHelper {
        private static final Singleton instance = new Singleton();
     }

     public static Singleton getInstance(){
        return SingletonHelper.instance;
     }
}

//the above works because the class initialization is guaranteed to be thread safe by the JVM
//this works because in JVM a class is loaded only when it is referenced
//so that means when Singleton.getInstance is called, only the Singleton class is loaded and not the inner class
//only when the SingletonHelper.instance is called it will load the inner class


