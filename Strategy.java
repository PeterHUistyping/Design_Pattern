import java.io.File;

/*
Lets you define a family of algorithms, put each of
them into a separate class, and make their objects interchangeable.
 */
public class Strategy {
    public static class Email {}

    public static class Firewall{ 
        FilteringStrategy strategy;
        Firewall(FilteringStrategy str){
            strategy=str;
        }
        void setFilteringStrategy(FilteringStrategy str){
            strategy=str;
        }
    }

    public interface FileFilter {
        boolean accept(File file);
    }

    public interface FilteringStrategy {
    boolean accept(Email email); }
        
    class GovernmentFilteringStrategy implements FilteringStrategy { 
        @Override
        public boolean accept(Email email) {
        return false;
        //return email.getSender().endsWith("gov.uk");

        } 
    }
    Firewall firewall = new Firewall(new GovernmentFilteringStrategy());
    //firewall.process(importantEmail);
 
    //firewall.setFilteringStrategy(new NoLateEmailsFilteringStrategy());
   
    //firewall.process(lateEmail);
}
