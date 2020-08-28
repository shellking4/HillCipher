import java.util.*;

public class Hill {
    private int mat[][] = new int[2][2];
    private int demat[][] = new int[2][2];
    private Alphabet myAlphabet = new Alphabet();
    private ArrayList<Integer> chiffres = new ArrayList<Integer>();
    private ArrayList<Integer> codes = new ArrayList<Integer>();
    private ArrayList<String> cryptedMessages = new ArrayList<String>();
    private int value;
    private String message="";
    private String codedMessage="";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String ifToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" \n Voulez-vous crypter un autre message ? OUI/NON ");
        String reply;
        while(!scanner.hasNext("[A-Za-z]+")) {
            System.out.print(" ENTRER OUI OU NON : ");
            scanner.next();
        }
        reply = scanner.nextLine();
        return reply;
    }

    public void setMat() {
        int check;
        do {
            System.out.println(" \n Veuillez entrer une matrice de chiffrement valide");
            System.out.print("\n Exemple :   |9 4|");
            System.out.print(" \n ========    |5 7|");
            for(int i = 0; i < this.mat.length; i++) {
                for(int j = 0; j < this.mat.length; j++) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print(" \n Entrer la valeur [" + i + "][" + j + "] de la matrice de chiffrement : ");
                    while(!scanner.hasNextInt()) {
                        System.out.print(" Veuillez rentrer un entier : ");
                        scanner.next();
                    }
                    this.mat[i][j] = scanner.nextInt();
                }
            }
            check = (this.mat[0][0]*this.mat[1][1]) - (this.mat[0][1]*this.mat[1][0]);
        }while(check%2==0 || check%13==0);
        System.out.println(" La matrice de chiffrement est : ");
        for(int i = 0; i< this.mat.length; i++) {
            for(int j = 0; j < this.mat.length; j++) {
                this.demat[i][j] = this.mat[i][j];
                System.out.println("\t" + this.mat[i][j] + "\n");
            }
        }
    }

    public void lettreEnChiffre(String message) {
        message = message.replaceAll("\\s+","");
        for(int i = 0; i < message.length(); i++) {
            Character ch = message.charAt(i);
            String charact = ch.toString();
            for(Lettre lettre : this.myAlphabet.getAlphabet()) {
                if(lettre.getIdentifier().equalsIgnoreCase(charact)) {
                    this.chiffres.add(lettre.getPosition());
                }
            }
        }
    }

    public void chiffrer(int [][] mat) {
        this.chiffres.trimToSize();
        int n = this.chiffres.size();
        if(n%2==0) {
            for(int i = 0; i < n; i+=2) {
                int var1 = mat[0][0]*this.chiffres.get(i) + mat[0][1]*this.chiffres.get(i+1);
                int var2 = mat[1][0]*this.chiffres.get(i) + mat[1][1]*this.chiffres.get(i+1);
                this.codage(var1, var2);
            }
        }
        else if(n%2 != 0) {
            for(int i = 0; i < n; i+=2) {
                int vari1, vari2;
                if(i == n-1) {
                    vari1 = mat[0][0]*this.chiffres.get(i-1) + mat[0][1]*this.chiffres.get(i);
                    vari2 = mat[1][0]*this.chiffres.get(i-1) + mat[1][1]*this.chiffres.get(i);
                    this.codage(vari1, vari2);
                }
                else if(i < n-1) {
                    vari1 = mat[0][0]*this.chiffres.get(i) + mat[0][1]*this.chiffres.get(i+1);
                    vari2 = mat[1][0]*this.chiffres.get(i) + mat[1][1]*this.chiffres.get(i+1);
                    this.codage(vari1, vari2);
                }
            }
        }
    }

    public void encrypt(int [][] mat) {
        this.codes.trimToSize();
        for(Integer i : this.codes) {
            for(Lettre l : this.myAlphabet.getAlphabet()) {
                if(i == l.getPosition()) {
                    this.codedMessage += l.getIdentifier();
                    this.codedMessage = this.codedMessage.toLowerCase();
                }
            }
        }
        this.cryptedMessages.add(this.codedMessage);
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                mat[i][j] = 0;
            }
        }
    }

    public void codage(int vari1, int vari2) {
        if(vari1 <= 26) {
            this.codes.add(vari1);
        }
        else if(vari1 > 26) {
            while(vari1 > 26) {
                vari1 -= 26;
            }
            this.codes.add(vari1);
        }
        if(vari2 <= 26) {
            this.codes.add(vari2);
        }
        else if(vari2 > 26) {
            while(vari2 > 26) {
                vari2 -= 26;
            }
            this.codes.add(vari2);
        }
    }

    /* Decryptage */
    public void calculInverse() {
        int det = (this.demat[0][0]*this.demat[1][1]) - (this.demat[0][1]*this.demat[1][0]);
        int a = this.demat[0][0];
        this.demat[0][0] = this.demat[1][1];
        this.demat[0][1] = -this.demat[0][1];
        this.demat[1][0] = -this.demat[1][0];
        this.demat[1][1] = a;
        for(int i = 1; i <= 23; i+=2) {
            int value = det*i;
            if(value > 26) {
                while(value > 26) {
                    value -= 26;
                }
                if(value == 1) {
                    this.value = i;
                }
            }
        }
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                this.demat[i][j] = this.demat[i][j]*this.value;
                if(this.demat[i][j] < 0 && this.demat[i][j] < 26) {
                    while(this.demat[i][j] < 0) {
                        this.demat[i][j] += 26;
                    }
                }
                else if(this.demat[i][j] > 26) {
                    while(this.demat[i][j] > 26) {
                        this.demat[i][j] -= 26;
                    }
                }
            }
        }
        System.out.println(" La matrice de déchiffrement est : ");
        for(int i = 0; i< this.demat.length; i++) {
            for(int j = 0; j < this.demat.length; j++) {
                System.out.println("\t" + this.demat[i][j] + "\n");
            }
        }
    }

    public void decrypt() {
        String crypted = this.cryptedMessages.get(0);
        System.out.println(" Le message à décrypter est : " + crypted);
        this.calculInverse();
        this.lettreEnChiffre(crypted);
        this.chiffrer(this.demat);
        this.encrypt(this.demat);
        if(this.message.length()%2 != 0) {
            StringBuilder str = new StringBuilder(this.codedMessage);
            str = str.deleteCharAt(this.codedMessage.length()-2);
            this.codedMessage = str.toString();
        }
        this.stateResultDeCrypt();
        this.chiffres.clear();
        this.codes.clear();
        this.codedMessage="";
        this.cryptedMessages.clear();
    }
/* Decryptage */

    public String interractionUser() {
        this.setMat();
        System.out.print(" Veuillez entrer un message à crypter(non accentué!!!) : ");
        Scanner scanner = new Scanner(System.in);
        this.message = scanner.nextLine();
        this.message = this.message.replaceAll("\\s+","");
        System.out.print(" Votre message initial est : " + this.message);
        this.lettreEnChiffre(this.message);
        this.chiffrer(this.mat);
        this.encrypt(this.mat);
        this.stateResultCrypt();
        this.chiffres.clear();
        this.codes.clear();
        this.codedMessage="";
        System.out.print(" Voulez-vous décrypter le message ? Oui/Non ");
        Scanner sc = new Scanner(System.in);
        String rep = sc.nextLine();
        if(rep.equalsIgnoreCase("Oui")) {
            this.decrypt();
        }
        String reply = this.ifToContinue();
        return reply;
    }

    public void stateResultCrypt() {
        System.out.print("\n");
        System.out.println(" Le message chiffré est : " + this.codedMessage);
    }

    public void stateResultDeCrypt() {
        System.out.print("\n");
        System.out.println(" Le message déchiffré est : " + this.codedMessage);
    }
}
