import java.util.Hashtable;

public class Interpreter {
    Prompt prompt;
    Lista listOfImplementedOperations;
    Lista listOfPredicates;
    Hashtable<String,Atom> userVariables = new Hashtable<String, Atom>();
    Hashtable<String,Atom> userFuntions = new Hashtable<String, Atom>();

    public Interpreter() throws Exception{
        defineImplementedOperations();
        definePredicates();
    }

    private void definePredicates(){
        this.listOfPredicates = new Lista();
        this.listOfPredicates.addAtFinal(new Atom("="));
        this.listOfPredicates.addAtFinal(new Atom("/="));
        this.listOfPredicates.addAtFinal(new Atom("<"));
        this.listOfPredicates.addAtFinal(new Atom("<="));
        this.listOfPredicates.addAtFinal(new Atom(">"));
        this.listOfPredicates.addAtFinal(new Atom(">="));
    }


}
