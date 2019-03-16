import java.util.List;
/**
 * Proyecto Lisp
 * Clase Atomo
 * @author Isabel Ortiz Naranjo 18176
 * @author Diego Estrada 18540
 * @author Michael Chan 18562
 */
public class Atomo {

    /**
     * Declaracion de variables
     * Declaracion de Lista
     */
    private boolean esLista;
    /**
     * Declaracion del numero
     */
    private boolean esNumero;
    /**
     * Declaracion del nulo
     */
    public boolean esNulo;

    /**
     * Declaracion de lista tipo Lista
     */
    public Lista lista;
    /**
     * Declaracion de descripcion tipo String
     */
    public String descripcion;
    /**
     * Declaracion de atomo tipo String
     */
    private String atomo;

    /**
     * Declaracion de numero tipo float
     */
    private float numero;
    /**
     * Declaracion de valor booleano tipo boolean
     */
    public boolean valorBooleano;
    /**
     * Declaracion de variable tipo booleana
     */
    private boolean esBooleano;


    /**
     * Metodo atomo
     */
    public Atomo() {
        this.esNulo = true;
        this.esLista = false;
        this.esNumero = false;
    }

    /**
     * @param lista metodo que recibe de parametro una lista tipo Lista
     */
    public Atomo(Lista lista){
        this.esLista = true;
        this.esNulo = false;
        this.esNumero = false;
        this.lista = lista;
    }

    /**
     * @param atomoAcopiar metodo que recibe de el atomo a copiar
     */

    public void copiarAtomo(Atomo atomoAcopiar){
        this.esLista = atomoAcopiar.esLista;
        this.esNumero = atomoAcopiar.esNumero;
        this.lista = atomoAcopiar.lista;
        this.atomo = atomoAcopiar.atomo;
        this.descripcion = atomoAcopiar.descripcion;
        this.numero = atomoAcopiar.numero;
        this.esNulo = atomoAcopiar.esNulo;
    }

    /**
     * @param atomo trata de parsear un entero
     */
    public Atomo(String atomo) {

        try {
            Atomo atomoConUnNumero = new Atomo(Integer.parseInt(atomo));
            this.copiarAtomo(atomoConUnNumero);
            this.esNumero = true;
        } catch (NumberFormatException atomoNoEsNumero){
            try {
                Atomo atomoConUnNumero = new Atomo(Float.parseFloat(atomo));
                this.copiarAtomo(atomoConUnNumero);
                this.esNumero = true;
            } catch (NumberFormatException atomoNoEsFlotante){
                this.atomo = atomo;
                this.esNumero = false;
                this.esNulo = false;
                this.esLista = false;
            }

        }
    }


    /**
     * @param numero metodo que recibe de parametro un int - numero
     */
    public Atomo(int numero) {
        this.numero = numero;
        this.esNumero = true;
        this.esNulo = false;
        this.esLista = false;
        this.atomo = Integer.toString(numero);
    }

    /**
     * @param numero metodo que recibe de parametro un numero tipo float
     */
    public Atomo(float numero) {
        this.numero = numero;
        this.esNumero = true;
        this.esNulo = false;
        this.esLista = false;

        this.atomo = Float.toString(this.numero);
    }

    /**
     * @param esTrue metodo que recibe de parametro esTrue
     */
    public Atomo(boolean esTrue) {
        if (esTrue){
            this.esBooleano = true;
            this.valorBooleano = true;
            this.esNumero = false;
            this.esNulo = false;
            this.esLista = false;
            this.atomo = "T";
        } else {
            this.esNulo = true;
            this.esLista = false;
            this.esNumero = false;
        }
    }

    /**
     * @return numero tipo float
     */
    public float getNumero(){
        if (!this.esNumero)
            return 0;

        return this.numero;
    }

    /**
     * @return una Lista tipo booleana
     */
    public boolean EsLista(){

        return this.esLista;
    }

    /**
     * @return un NIL si es nulo y si es lista, un toString
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
     * Ve si un atomo es igual a este
     * @param objeto metodo que recibe de parametro un objeto
     * @return si es nulo true, si es el numero retorna el numero, si es lista la lista y se compara que no sea igual a cero
     */
    public boolean equals(Object objeto){
        Atomo otroAtomo = (Atomo)objeto;

        if ((this.esNulo) && (otroAtomo.esNulo))
            return true;

        if ((this.esNumero) && (otroAtomo.esNumero))
            return this.numero==otroAtomo.numero;

        if ((this.esLista) && (otroAtomo.esLista))
            return this.lista.equals(otroAtomo.lista);

        return this.atomo.compareTo(otroAtomo.atomo)==0;
    }

    /**
     * 	Verifica si el atomo, en caso de ser un string, comienza con un subString
     * @param substring por el que se esta buscando
     * @return se retorna True si el atomo termina con el SubString
     */
    public boolean comienzaCon(String substring){
        if ((substring.length()<=this.atomo.length()) && (!this.esLista)){
            return this.atomo.substring(0, substring.length()).compareTo(substring)==0;
        }

        return false;
    }

    /**
     * Metodo que verifica si este atomo es una lista con una operacion
     * @return true si el atomo es una lista con una operacion
     */
    public boolean EsListaConOperacion() {
        if (this.EsLista())
            return (this.lista.esOperacion);

        return false;
    }

    /**
     * @return esNumero
     */
    public boolean esNumero(){
        return this.esNumero;
    }

    /**
     * @return metodo que verifica si un numero es entero
     */
    public boolean esEntero() {
        if (!this.esNumero)
            return false;

        try {
            int numero = Integer.parseInt(this.atomo);
            return true;
        } catch (NumberFormatException noEsEntero) {
            return false;
        }
    }


    /**
     * @return Depende del tipo, devuelve Nil, T o NULL
     */
    public String getTipo() {
        if (this.esLista)
            return "Nil";
        else if (this.esNumero)
            return "T";
        else if (this.esNulo)
            return "NULL";
        else
            return "T";

    }
}
