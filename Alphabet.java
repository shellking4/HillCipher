import java.util.*;

public class Alphabet {
    private ArrayList<Lettre> alphabet = new ArrayList<Lettre>(26);
    private final int nombreLettre = 26;

    public Alphabet() {
        Lettre lettre1 = new Lettre("A", 1);
        Lettre lettre2 = new Lettre("B", 2);
        Lettre lettre3 = new Lettre("C", 3);
        Lettre lettre4 = new Lettre("D", 4);
        Lettre lettre5 = new Lettre("E", 5);
        Lettre lettre6 = new Lettre("F", 6);
        Lettre lettre7 = new Lettre("G", 7);
        Lettre lettre8 = new Lettre("H", 8);
        Lettre lettre9 = new Lettre("I", 9);
        Lettre lettre10 = new Lettre("J", 10);
        Lettre lettre11 = new Lettre("K", 11);
        Lettre lettre12 = new Lettre("L", 12);
        Lettre lettre13 = new Lettre("M", 13);
        Lettre lettre14 = new Lettre("N", 14);
        Lettre lettre15 = new Lettre("O", 15);
        Lettre lettre16 = new Lettre("P", 16);
        Lettre lettre17 = new Lettre("Q", 17);
        Lettre lettre18 = new Lettre("R", 18);
        Lettre lettre19 = new Lettre("S", 19);
        Lettre lettre20 = new Lettre("T", 20);
        Lettre lettre21 = new Lettre("U", 21);
        Lettre lettre22 = new Lettre("V", 22);
        Lettre lettre23 = new Lettre("W", 23);
        Lettre lettre24 = new Lettre("X", 24);
        Lettre lettre25 = new Lettre("Y", 25);
        Lettre lettre26 = new Lettre("Z", 26);

        alphabet.add(lettre1);
        alphabet.add(lettre2);
        alphabet.add(lettre3);
        alphabet.add(lettre4);
        alphabet.add(lettre5);
        alphabet.add(lettre6);
        alphabet.add(lettre7);
        alphabet.add(lettre8);
        alphabet.add(lettre9);
        alphabet.add(lettre10);
        alphabet.add(lettre11);
        alphabet.add(lettre12);
        alphabet.add(lettre13);
        alphabet.add(lettre14);
        alphabet.add(lettre15);
        alphabet.add(lettre16);
        alphabet.add(lettre17);
        alphabet.add(lettre18);
        alphabet.add(lettre19);
        alphabet.add(lettre20);
        alphabet.add(lettre21);
        alphabet.add(lettre22);
        alphabet.add(lettre23);
        alphabet.add(lettre24);
        alphabet.add(lettre25);
        alphabet.add(lettre26);
    }
    
    public ArrayList<Lettre> getAlphabet() {
        return this.alphabet;
    }

    public int getNombreLettre() {
        return this.nombreLettre;
    }
}
