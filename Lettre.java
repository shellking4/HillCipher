import java.util.*;

public class Lettre {
    private final String identifier;
    private final int position;

    public Lettre(String identifier, int position) {
        this.identifier = identifier;
        this.position = position;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int getPosition() {
        return this.position;
    }
}
