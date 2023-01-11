/*
 Only one instance of an object is created by developers using our code
 Ex. a class that encapsulates accessing a database over a network with only one connection at a time.
 Provide a global access point to that instance.
 */
public class Singleton_single_threaded {
    public static final class Singleton {  // static used for inner class
        public String value;
        private static Singleton instance; // static - shared instance; private - only accessible by the class
        // private static Singleton instace=new Singleton(value);

        private Singleton(String value) {   
            this.value = value;
        }
        // private Singleton(){
        //     //prevent from being instantiated.
        // }

        //lazy initialization
        public static Singleton getInstance(String value) {  //private - can't be accessed by outside
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
        // public static Singleton getInstance(String value){
        //     return instance;
        // }    
    }
    Singleton s=Singleton.getInstance(null);
    //Error when MultiThread
    public class DemoMultiThread {
        public static void main(String[] args) {
            System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                    "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                    "RESULT:" + "\n");
            Thread threadFoo = new Thread(new ThreadFoo());
            Thread threadBar = new Thread(new ThreadBar());
            threadFoo.start();
            threadBar.start();
        }
    
        static class ThreadFoo implements Runnable {
            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance("FOO");
                System.out.println(singleton.value);
            }
        }
    
        static class ThreadBar implements Runnable {
            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance("BAR");
                System.out.println(singleton.value);
            }
        }
    }
};

