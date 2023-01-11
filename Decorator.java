// import java.io.*;
// import java.util.zip.GZIPInputStream;
// import java.util.zip.ZipInputStream;

/*
Component: The Component defines the interface for objects that can have responsibilties added dynamically \
ConcreteComponent: It is simply an implementation of Component interface \
Decorator: The Decorator has a reference to a Component, and also conforms to the Component interface. Decorator is essentially wrapping the Component \
ConcreteDecorator: The ConcreteDecorator just adds responsibilities to the original Component. 

The most common relationships between classes are \
• Dependence (“uses–a”) \
• Inheritance (“is–a”) \
Object itself does the work.\
• Aggregation (“has–a”) \
Object delegates the work through reference to others and alter the result.

Problems with Inheritance \
● Static, Single Relationship \
○ Defined at Compile-time, can’t customise at runtime \
● Inheritance based Coupling \
● Misuse of Inheritance, Inheritance implies: Latte is an Espresso - not true 

Aggregation
Add state or methods at runtime\
Enables more flexible addition of behaviour, not hard-bounding \
Combining multiple behaviours
*/

public class Decorator{
    //compile-time
    public interface Coffee { 
        //Component
        double getCost();
        void make();
    }
    public class CoffeeMug implements Coffee { 
        //Concrete Component
        public double getCost(){
            return 0; 
        }
        public void make(){
            System.out.println("Get a mug");
        }
    }
    public class WithEspressoShot implements Coffee{  
        //Decorator
        private final Coffee coffee;
        // inaccessible to other classes, can't be overwritten
        public WithEspressoShot(final Coffee coffee)
        {
            this.coffee = coffee;
        }
        @Override
        public double getCost()
        {
            return 1 + coffee.getCost();
        }
        @Override
        public void make()
        {
            coffee.make();
            System.out.println("Pull Espresso Shot");
        }
    }
    public class WithSteamedAlmondMilk implements Coffee {
        // Another similar Decorator
        private final Coffee coffee;
        public WithSteamedAlmondMilk(final Coffee coffee)
        {
            this.coffee = coffee;
        }
        @Override
        public double getCost()
        {
            return 1 + coffee.getCost();
        }
        @Override
        public void make()
        {
            coffee.make();
            System.out.println("Steam Almond Milk and pour into coffee");
        }
    }
    // Add state or methods at runtime
    Coffee coffeeAddiction =
        new WithSteamedAlmondMilk(
            new WithEspressoShot(
                new WithEspressoShot(
                    new WithEspressoShot(new CoffeeMug()))));

     
    // BufferedReader r = new BufferedReader(new PushbackReader(new FileReader("fileName")));
    // Compenent: Reader
   
    // GZIPInputStream z= new GZIPInputStream((new FileInputStream("filename")));
    // Compenent: InputStream
    // Decorator:  ZipInputStream GZipInputStream  ObjectInputStream
};