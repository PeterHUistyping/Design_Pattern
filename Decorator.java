public class Decorator{
    public interface Coffee {
        double getCost();
        void make();
    }
    public class CoffeeMug implements Coffee
    {
        public double getCost()
        {
        return 0; 
        }
        public void make()
        {
            System.out.println("Get a mug");
        }
    }
    public class WithEspressoShot implements Coffee
    {
        private final Coffee coffee;
        public WithEspressoShot(final Coffee coffee)
        {
            this.coffee = coffee;
        }
        public double getCost()
        {
            return 1 + coffee.getCost();
        }
        public void make()
        {
            coffee.make();
            System.out.println("Pull Espresso Shot");
        }
    }
    public class WithSteamedAlmondMilk implements Coffee
    {
        private final Coffee coffee;
        public WithSteamedAlmondMilk(final Coffee coffee)
        {
            this.coffee = coffee;
        }
        public double getCost()
        {
            return 1 + coffee.getCost();
        }
        public void make()
        {
            coffee.make();
            System.out.println("Steam Almond Milk and pour into coffee");
        }
    }

    Coffee coffeeAddiction =
        new WithSteamedAlmondMilk(
            new WithEspressoShot(
                new WithEspressoShot(
                    new WithEspressoShot(new CoffeeMug()))));
};