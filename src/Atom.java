/**
 * Proyecto Lisp
 * @author Isabel Ortiz Naranjo 18176
 * @author Diego Estrada 18540
 * @author Michael Chan 18562
 *
 */
/**
 * Proyecto 1: Interprete Lisp en Java
 */
public class Atom {

    // Definicion de variables
    private boolean isList;
    private boolean isInt;
    public boolean isNull;

    public Lista list;
    public String description;
    private String atom;

    private float integer;
    public boolean booleanVal;
    private boolean isBoolean;


    /**
     *  Constructor
     */
    public Atom() {
        this.isNull = true;
        this.isList = false;
        this.isInt = false;
    }

    /**
     * Constructor
     * @param selectedList Lista
     */
    public Atom(Lista selectedList) {
        this.isList = true;
        this.isNull = false;
        this.isInt = false;

        this.list = selectedList;
    }

    /**
     * Constructor
     * @param selectedAtom atomo seleccionado
     */
    public void copyAtom(Atom selectedAtom) {
        this.isList = selectedAtom.isList;
        this.isInt = selectedAtom.isInt;
        this.list = selectedAtom.list;
        this.atom = selectedAtom.atom;
        this.description = selectedAtom.description;
        this.integer = selectedAtom.integer;
        this.isNull = selectedAtom.isNull;
    }

    /**
     * Tratar de parsear un entero
     * @param selectedAtom atomo seleccionado
     */
    public Atom(String selectedAtom) {
        try {
            Atom intAtom = new Atom(Integer.parseInt(selectedAtom));
            this.copyAtom(intAtom);
            this.isInt = true;
        } catch (NumberFormatException notIntegerAtom) {
            try {
                Atom intAtom = new Atom(Float.parseFloat(selectedAtom));
                this.copyAtom(intAtom);
                this.isInt = true;
            } catch (NumberFormatException notFloatingAtom) {
                this.atom = selectedAtom;
                this.isInt = false;
                this.isNull = false;
                this.isList = false;
            }

        }
    }

    /**
     * @param selectedAtom atomo seleccionado
     * @param description descripcion
     */
    public Atom(String selectedAtom, String description) {
        this.atom = selectedAtom;
        this.description = description;
    }


    /**
     * @param number numero
     */
    public Atom(int number) {
        this.integer = number;
        this.isInt = true;
        this.isNull = false;
        this.isList = false;
        this.atom = Integer.toString(numero);
    }

    /**
     * @param number numero
     */
    public Atom(float number) {
        this.integer = number;
        this.isInt = true;
        this.isNull = false;
        this.isList = false;

        this.atom = Float.toString(this.integer);
    }

    /**
     * @param isTrue
     */
    public Atom(boolean isTrue) {
        if (isTrue) {
            this.isBoolean = true;
            this.booleanVal = true;
            this.isInt = false;
            this.isNull = false;
            this.isList = false;
            this.atom = "T";
        } else {
            this.isNull = true;
            this.isList = false;
            this.isInt = false;
        }
    }

    /**
     * @return 0 o numero
     */
    public float getNumber(){
        if (!this.esNumber)
            return 0;

        return this.number;
    }

    /**
     * @return Lista
     */
    public boolean InList(){
        return this.isList;
    }

    /**
     * @return Nulo o Nil
     */
    public String toString(){
        if (this.esNulo)
            return "NIL";

        if (this.EsLista())
            return this.lista.toString();
        else
            return this.atomo;
    }

    /**
     * Se verifica si un atomo es igual a este
     *
     */
    public boolean equals(Object objet){
        Atom otherAtom = (Atom) objet;

        if ((this.isNull) && (otherAtom.isNull))
            return true;

        if ((this.isNumber) && (otherAtom.isNumber))
            return this.number==otherAtom.number;

        if ((this.isList) && (otherAtom.isList))
            return this.list.equals(otherAtom.list);

        return this.atom.compareTo(otherAtom.atom)==0;
    }

    /**
     * Verifica si el atomo, en caso de ser un string, comienza con un subString
     * @param substring subString por el que se esta buscando
     * @return true si este atomo comienza con subString
     */
    public boolean start(String substring){
        if ((substring.length()<=this.atom.length()) && (!this.isList)){
            return this.atom.substring(0, substring.length()).compareTo(substring)==0;
        }
        return false;
    }

    /**
     * Metodo que verifica si este atomo es una lista con una operacion
     * @return True si la este atomo es una lista con una operacion
     *
     */
    public boolean ListWithO() {
        if (this.IsList())
            return (this.list.esOperacion);
        return false;
    }

    /**
     * Metodo que verifica si este atomo es un numero
     */
    public boolean isNumber(){
        return this.isNumber();
    }

    /**
     * Ve si el atomo, en caso de ser un string, termina con un subString
     * @param subString subString que se esta buscando
     * @return true si este atomo termina con subString
     * Metodo que verifica si este es un numero entero
     */
    public boolean isNumber() {
        if (!this.isNumber)
            return false;

        try {
            int number = Integer.parseInt(this.atom);
            return true;
        } catch (NumberFormatException noInt) {
            return false;
        }
    }


    public String getTipo() {
        if (this.isList)
            return "CONS";
        else if (this.isNumber)
            return "SINGLE-FLOAT";
        else if (this.isNull)
            return "NULL";
        else
            return "SYMBOL";

    }
}
