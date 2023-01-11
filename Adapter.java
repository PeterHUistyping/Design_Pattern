import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.Month;

/*
Introduce a bridge between two incompatible interfaces.

**Target**: The Interface / class that the rest of your code is going to use. \
**Adaptee**: The class that we’re trying to adapt. \
Often 3rd-party, legacy or with lots of existing dependencies.\
**Adapter**: The class that will adapt method calls from the target to the Adaptee. 
 */
public class Adapter {
    public interface Resource { //Target
        int read(); 
    }
    public class AdapterDeviceResource implements Resource { //Adapter
        private Device device;
        public AdapterDeviceResource(Device device) { //Adaptee
            this.device = device;
        }
        @Override
        public int read() {
            return this.device.poll();
        }
    }
    public class Device {//Adaptee
        public int read(){
            return 0;
        }

        public int poll() {
            return 1;
        }
    }
        
    public static class RoundHole {    // RoundHoles are compatible with RoundPegs.
        private double radius;

        public RoundHole(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public boolean fits(RoundPeg peg) {
            boolean result;
            result = (this.getRadius() >= peg.getRadius());
            return result;
        }
    }
 
    public static class RoundPeg { // Target RoundPegs are compatible with RoundHoles.
        private double radius;

        public RoundPeg() {}

        public RoundPeg(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }
    }
 
    public static class SquarePeg { // Adapters SquarePegs are not compatible with RoundHoles (they were implemented by previous development team
        private double width;

        public SquarePeg(double width) {
            this.width = width;
        }

        public double getWidth() {
            return width;
        }

        public double getSquare() {
            double result;
            result = Math.pow(this.width, 2);
            return result;
        }
    }
  
    public static class SquarePegAdapter extends RoundPeg { // Adapter allows fitting square pegs into round holes.
        private SquarePeg peg;

        public SquarePegAdapter(SquarePeg peg) {
            this.peg = peg;
        }

        @Override
        public double getRadius() {
            double result;
            // Calculate a minimum circle radius, which can fit this peg.
            result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
            return result;
        }
    }

    public class Demo { //client 
        public static void main(String[] args) {
            // Round fits round, no surprise.
            RoundHole hole = new RoundHole(5);
            RoundPeg rpeg = new RoundPeg(5);
            if (hole.fits(rpeg)) {
                System.out.println("Round peg r5 fits round hole r5.");
            }

            SquarePeg smallSqPeg = new SquarePeg(2);
            SquarePeg largeSqPeg = new SquarePeg(20);
            // hole.fits(smallSqPeg); // Won't compile.

            // Adapter solves the problem.
            SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
            SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
            if (hole.fits(smallSqPegAdapter)) {
                System.out.println("Square peg w2 fits round hole r5.");
            }
            if (!hole.fits(largeSqPegAdapter)) {
                System.out.println("Square peg w20 does not fit into round hole r5.");
            }
            
        }
        
    // LocalDate -> Date
    LocalDate localDate = LocalDate.of(2022, Month.NOVEMBER, 28);
    java.util.Date date = java.sql.Date.valueOf(localDate);
    // Date -> LocalDate
    LocalDate newLocalDate
        = new java.sql.Date(date.getTime()).toLocalDate();
    // An InputStreamReader is a bridge from byte streams to character streams
        Reader reader = new InputStreamReader(System.in); 
    }

}
