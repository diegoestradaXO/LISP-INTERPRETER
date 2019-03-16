/**
 * Proyecto Lisp
 * Clase Nodo
 * @author Isabel Ortiz Naranjo 18176
 * @author Diego Estrada 18540
 * @author Michael Chan 18562
 */
public class Nodo <E> {

	/**
	 * Elemento de tipo Object
	 */
	private Object Elemento;
	/**
	 * Siguiente elemento de tipo Nodo
	 */
	private Nodo<E> SiguienteElemento;

	/**
	 * Nuevo nodo
	 * @param elemento de tipo Object
	 * @param next de tipo Nodo
	 */

	public Nodo(Object elemento, Nodo<E> next) {
		Elemento = elemento; 
		SiguienteElemento = next; 
	}

	/**
	 * @return el siguiente elemento de la lista
	 */
	public Nodo<E> next() {
		return SiguienteElemento; 
	}

	/**
	 * @param next es el siguiente elemento.
	 * El cual se define en este metodo
	 */

	public void setNext(Nodo<E> next){
		SiguienteElemento = next; 
	}

	/**
	 * @return retorna el valor asociado con este elemento.
	 */
	public Object value() {
		return Elemento; 
	} 
	
	
}

