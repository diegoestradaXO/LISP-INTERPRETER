/**
 * Proyecto Lisp
 * @author Isabel Ortiz Naranjo 18176
 * @author Diego Estrada 18540
 * @author Michael Chan 18562
 */
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * Clase Prompt
 */
public class Prompt {

    //  Declaracion de variables
    private Scanner input;
    private String lastText;
    private static int lineNum = 1;

    /**
     * Constructor de la clase
     */
    public Prompt(){
        this.input = new Scanner(System.in);
    }

    // Metodo que espera algo para ser leido y entendido

    public void detect(Hashtable<String, Atom> userVariables) {

        // Se le indica al usuario que el interprete esta listo para procesar lo indicado.
        // Ingresando el numero de linea que corresponde

        System.out.print("["+lineNum+"]> ");

        // Declaracion de variables propias de la clase

        // Nueva expresion
        String newStatement = "";
        // Ha terminado de leer lo requerido
        boolean read = false;
        // No. de parentesis abiertos
        int openParentheses = 0;
        // No. de parentesis cerrados
        int closeParentheses = 0;

        do{
            newStatement += " "+input.nextLine().replace('\n', ' ');

            if (userVariables.containsKey(newStatement.trim())){
                read = true;
            }

            openParentheses = countC('(',newStatement);
            closeParentheses = countC(')',newStatement);

            if ((openParentheses == closeParentheses) && (openParentheses !=0))
                read = true;

        } while (!read);

        this.lastStatement = newStatement;
        this.lineNum++;
    }


    // Metodo para saber si se ingresa una lista en el Promt

    public boolean IngresoUnaLista(){

        // Evaluacion de la ultima expresion
        StringTokenizer tokenizer = new StringTokenizer(this.lastStatement);

        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }

        return false;
    }


    public void Escribir(String mensaje) {
        System.out.println(mensaje);
    }

    // Regresar la ultima expresion ingresada

    public String getLastStatement() {
        return this.lastStatement;
    }

    private int countC(char search, String chain) {
        int num = 0;

        for (int i = 0 ; i < chain.length() ; i++){
            if (chain.charAt(i)== search)
                num++;
        }

        return num;
    }
}