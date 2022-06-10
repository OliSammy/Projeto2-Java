package domainexception;

public class GabaritoInvalidoException extends Exception {
    public GabaritoInvalidoException() {
        super("O gabarito não pode ser composto apenas por V ou apenas por F");
    }
}
