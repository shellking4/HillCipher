import java.util.*;

public class Test {
    public static void main(String [] args) {
        Hill myHill = new Hill();
        String reply = myHill.interractionUser();
        while(reply.equalsIgnoreCase("Oui")) {
            myHill.clearScreen();
            reply = myHill.interractionUser();
        }
        System.out.println(" MERCI ET À LA PROCHAINE !");
        System.exit(0);
    }
}
