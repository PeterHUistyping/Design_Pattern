import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// import java.time.LocalDate;
// import java.time.Month;

/*
new “considered harmful” 

Factory Method is a creational design pattern that provides an interface for creating objects in a
superclass, but allows subclasses to alter the type of objects that will be created.

Avoid tight coupling between the creator and the concrete products.Avoid tight coupling between the creator and the concrete products.

The **Product** declares the interface, which is common to all objects that can be produced by the creator and its subclasses.\
**Concrete Products** are different implementations of the product interface.\
The **Creator** class declares the factory method that returns new product objects. It’s
important that the return type of this method matches the product interface.\
**Concrete Creators** override the base factory method so it returns a different type of product. \
Note that the factory method doesn’t have to create new instances all the time. It can also return existing objects from a cache, an object pool, or another source.
 */
 class Factory {
    // LocalDate date = LocalDate.of(2022, Month.NOVEMBER, 25);
    // System.out.println(date); // 2022-11-25
    // LocalDate parsedDate = LocalDate.parse("2022-11-26"); 
    // System.out.println(parsedDate); // 2022-11-26


    public interface Button {  //Product
        void render();
        void onClick();
    }
    public class HtmlButton implements Button { //Concrete Product

        public void render() {
            System.out.println("<button>Test Button</button>");
            onClick();
        }
    
        public void onClick() {
            System.out.println("Click! Button says - 'Hello World!'");
        }
    }
    public class WindowsButton implements Button { //Concrete Product
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        JButton button;
    
        public void render() {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel label = new JLabel("Hello World!");
            label.setOpaque(true);
            // label.setBackground(new Color(235, 233, 126));
            // label.setFont(new Font("Dialog", Font.BOLD, 44));
            // label.setHorizontalAlignment(SwingConstants.CENTER);
            // panel.setLayout(new FlowLayout(FlowLayout.CENTER));
            frame.getContentPane().add(panel);
            panel.add(label);
            onClick();
            panel.add(button);
    
            frame.setSize(320, 200);
            frame.setVisible(true);
            onClick();
        }
    
        public void onClick() {
            // button = new JButton("Exit");
            // button.addActionListener(new ActionListener() {
            //     public void actionPerformed(ActionEvent e) {
            //         frame.setVisible(false);
            //         System.exit(0);
            //     }
            // });
        }
    }
    public abstract class Dialog {  //Creator
        public void renderWindow() {
            // ... other code ...
    
            Button okButton = createButton();
            okButton.render();
        }
        public abstract Button createButton();
    }
    public class HtmlDialog extends Dialog {

        @Override
        public Button createButton() {
            return new HtmlButton();
        }
    }

    public class WindowsDialog extends Dialog {

        @Override
        public Button createButton() {
            return new WindowsButton();
        }
    }
    public class Demo {
        private static Dialog dialog;

        public static void main(String[] args) {
            configure();
            runBusinessLogic();
        }

        /**
         * The concrete factory is usually chosen depending on configuration or
         * environment options.
         */
        static void configure() {
            if (System.getProperty("os.name").equals("Windows 10")) {
                //dialog = new WindowsDialog();
            } else {
                //dialog = new HtmlDialog();
            }
        }

        /**
         * All of the client code should work with factories and products through
         * abstract interfaces. This way it does not care which factory it works
         * with and what kind of product it returns.
         */
        static void runBusinessLogic() {
            dialog.renderWindow();
        }
        }   
        public interface ThreadFactory {
            Thread newThread(Runnable r);
    }
    class DefaultThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable r) {
        return new Thread(r);
      } 
    } 
    class PrivilegedThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable r) {
            return new Thread(r);
          }
     }
     public class LoggingThreadFactory implements ThreadFactory
    {
    @Override
    public Thread newThread(Runnable r)
    {
        Thread t = new Thread(r);

        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException(Thread t, Throwable e)
            {
                // LoggerFactory.getLogger(t.getName()).error(e.getMessage(), e);
            }
        });

        return t;
    }
    }
    
}
