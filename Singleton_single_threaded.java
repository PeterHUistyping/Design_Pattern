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
};

