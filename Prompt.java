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
	/**
	 * Definicion de variables
	 * entrada de tipo Scanner
	 */
	private Scanner entrada;
	/**
	 * Ultima expresion de tipo String
	 */
	private String ultimaExpresion;
	/**
	 * numero de linea de tipo entero y estatico
	 */
	private static int numeroDeLinea=1;


	/**
	 * Constructor
	 */
	public Prompt()
	{
		this.entrada = new Scanner(System.in);
	}

	/**
	 * @param variablesDelUsuario se lee una nueva expresion dada por el usuario
	 */
	public void Escuchar(Hashtable<String, Atomo> variablesDelUsuario) {

		System.out.print(numeroDeLinea+">>> ");
		
		String nuevaExpresion = "";
		boolean haTerminadoDeLeer = false;
		int numeroDeParentesisAbiertos = 0;
		int numeroDeParentesisCerrados = 0;
		
		do{
			nuevaExpresion += " "+entrada.nextLine().replace('\n', ' ');
			
			if (variablesDelUsuario.containsKey(nuevaExpresion.trim())){
				haTerminadoDeLeer = true;
			}
				
			numeroDeParentesisAbiertos = contarCaracterEn('(',nuevaExpresion);
			numeroDeParentesisCerrados = contarCaracterEn(')',nuevaExpresion);
			
			if ((numeroDeParentesisAbiertos == numeroDeParentesisCerrados) && (numeroDeParentesisAbiertos !=0))
				haTerminadoDeLeer = true;
			
		} while (!haTerminadoDeLeer);
		
		this.ultimaExpresion = nuevaExpresion;
		this.numeroDeLinea++;
	}

	/**
	 * @param caracterBuscando caracter que esta buscando
	 * @param cadena cadena de tipo String
	 * @return retorna cuantas veces estan los caracteres que se estan buscando
	 */
	private int contarCaracterEn(char caracterBuscando, String cadena) {
		int cuantasVeces = 0;

		for (int i = 0 ; i < cadena.length() ; i++){
			if (cadena.charAt(i)==caracterBuscando)
				cuantasVeces++;
		}
		
		return cuantasVeces;
	}


	/**
	 * @return la ultima expresion
	 */
	public String getUltimaExpresion() {
		return this.ultimaExpresion;
	}
}
