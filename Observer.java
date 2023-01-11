import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 Define a 1:M dependency between objects so that when one object changes state, all its dependents are notified automatically \
● Enables decoupling between publisher and subscriber \
● Enables dynamic attachment/removal of subscribers 
 */
public class Observer {
    public interface EventObserver {
        public void update(String eventType, File file) ;
    }
    public static class EmailNotification_observer implements EventObserver {
        private String email;
    
        public EmailNotification_observer(String email) {
            this.email = email;
        }
    
        @Override
        public void update(String eventType, File file) {
            System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
        }
    }
    public static class LogOpen_observer implements EventObserver {
        private File log;
    
        public LogOpen_observer(String fileName) {
            this.log = new File(fileName);
        }
    
        @Override
        public void update(String eventType, File file) {
            System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
        }
    }
    public static class EventManager {
        Map<String, List<EventObserver>> observers = new HashMap<>();
        public EventManager(String... operations) {
            for (String operation : operations) {
                this.observers.put(operation, new ArrayList<>());
            }
        }
        public void subscribe(String eventType, EventObserver observer) {
            List<EventObserver> users = observers.get(eventType);
            users.add(observer);
        }
        public void unsubscribe(String eventType, EventObserver observer) {
            List<EventObserver> users = observers.get(eventType);
            users.remove(observer);
        }
        public void notify(String eventType, File file) {
            List<EventObserver> users = observers.get(eventType);
            for (EventObserver observer : users) {
                observer.update(eventType, file);
            }
        }
    }
    public static class Editor {
        public EventManager events;
        private File file;
        public Editor() {
            this.events = new EventManager("open", "save");
        }
        public void openFile(String filePath) {
            this.file = new File(filePath);
            events.notify("open", file);
        }
        public void saveFile() throws Exception {
            if (this.file != null) {
                events.notify("save", file);
            } else {
                throw new Exception("Please open a file first.");
            }
        }
    }

    public static class Demo {
        public static void main(String[] args) {
            Editor editor = new Editor();
            editor.events.subscribe("open", new LogOpen_observer("/path/to/log/file.txt"));
            editor.events.subscribe("save", new EmailNotification_observer("admin@example.com"));
    
            try {
                editor.openFile("test.txt");
                editor.saveFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
