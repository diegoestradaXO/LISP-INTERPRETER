import java.util.List;

public class Atom{
    private boolean isList;
    private boolean isInt;
    public boolean isNull;

    public Lista list;
    public String description;
    private String atom;

    private float integer;
    public boolean booleanVal;
    private boolean isBoolean;


    public Atom() {
        this.isNull = true;
        this.isList = false;
        this.isInt = false;
    }

    public Atom(Lista lista){
        this.isList = true;
        this.isNull = false;
        this.isInt = false;

        this.list = lista;
    }

    public void copyAtom(Atom atomToCopy){
        this.isList = atomToCopy.isList;
        this.isInt = atomToCopy.isInt;
        this.list = atomToCopy.list;
        this.atom = atomToCopy.atom;
        this.description = atomToCopy.description;
        this.integer = atomToCopy.integer;
        this.isNull = atomToCopy.isNull;
    }

    public Atom(String atom) {
        /**
         * Tratar de parsear un entero
         */
        try {
            Atom atomoConUnNumero = new Atom(Integer.parseInt(atom));
            this.copyAtom(atomoConUnNumero);
            this.isInt = true;
        } catch (NumberFormatException atomoNoEsNumero){
            try {
                Atom atomoConUnNumero = new Atom(Float.parseFloat(atom));
                this.copyAtom(atomoConUnNumero);
                this.isInt = true;
            } catch (NumberFormatException atomoNoEsFlotante){
                this.atom = atom;
                this.isInt = false;
                this.isNull = false;
                this.isList = false;
            }

        }
    }

    public Atom(String atomo, String desc) {
        this.atom = atomo;
        this.description = desc;
    }

    public Atom(int number) {
        this.integer = number;
        this.isInt = true;
        this.isNull = false;
        this.isList = false;
        this.atom = Integer.toString(number);
    }

    public Atom(float number) {
        this.integer = number;
        this.isInt = true;
        this.isNull = false;
        this.isList = false;

        this.atom = Float.toString(this.getNum());
    }

    public Atom(boolean esTrue) {
        if (esTrue){
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

    public float getNum(){
        if (!this.isInt)
            return 0;

        return this.integer;
    }

    public boolean EsLista(){
        return this.isList;
    }

    public String toString(){
        if (this.isNull)
            return "NIL";

        if (this.EsLista())
            return this.list.toString();
        else
            return this.atom;
    }

    /**
     * Ve si un atomo es igual a este
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     * @author kmels
     */
    public boolean equals(Object objeto){
        Atom otroAtomo = (Atom)objeto;

        if ((this.isNull) && (otroAtomo.isNull))
            return true;

        if ((this.isInt) && (otroAtomo.isInt))
            return this.integer==otroAtomo.integer;

        if ((this.isList) && (otroAtomo.isList))
            return this.list.equals(otroAtomo.list);

        return this.atom.compareTo(otroAtomo.atom)==0;
    }

    public boolean startsWith(String substring){
        if ((substring.length()<=this.atom.length()) && (!this.isList)){
            return this.atom.substring(0, substring.length()).compareTo(substring)==0;
        }

        return false;
    }


    // en lista con operacion
    public boolean operationWithList() {
        if (this.EsLista())
            return (this.list.isOperation);

        return false;
    }

    /**
     * Metodo que verifica si este atomo es un numero
     */
    public boolean isNumber(){
        return this.isInt;
    }

    public boolean isInt() {
        if (!this.isInt)
            return false;

        /**
         * Si es numero, puede ser flotante o entero
         */

        try {
            int numero = Integer.parseInt(this.atom);
            return true;
        } catch (NumberFormatException noEsEntero) {
            return false;
        }
    }


    public String getType() {
        if (this.isList)
            return "CONS";
        else if (this.isInt)
            return "SINGLE-FLOAT";
        else if (this.isNull)
            return "NULL";
        else
            return "SYMBOL";

    }
}
