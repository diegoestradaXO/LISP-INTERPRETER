/**
 * Proyecto Lisp
 * @author Isabel Ortiz Naranjo 18176
 * @author Diego Estrada 18540
 * @author Michael Chan 18562
 */
public class ImplementacionStack_Listas<E> implements InterfazStack<E> {

	/**
	 * Declaracion de variable contador
	 */
	public int contador;
	/**
	 * Declaracion de variable tipo Nodo
	 */
	public Nodo<E> head;

	/**
	 * Se inicializa una nueva Lista
	 */
	public ImplementacionStack_Listas(){
		contador = 0;
		head = null;
	}

	/**
	 * @return Si hay elementos en la lista
	 */
	public boolean empty() {
		if (contador==0)
			return true;
		else
			return false;
	}

	/**
	 * @return si la lista esta llena
	 */
	public boolean full() {
		if (contador==100)
			return true;
		else{
			return false;
		}
	}


	/**
	 * @param element se encarga de agregar un elemento a la lista
	 */
	public void push(Object element){
		Nodo<E> nuevoNodo = new Nodo<E> (element, null);
		contador++;
		//Si hay elementos en la lista se el nuevo nodo al final.
		if (head != null){
			Nodo<E> finger = head;
			while (finger.next() != null){
				finger = finger.next();
			}
			finger.setNext(nuevoNodo);
		}
		else
			head = nuevoNodo;
				
		}

	/**
	 * @return el ultimo elemento de la lista y no lo borra
	 */
	public E top() {
		Nodo<E> finger = head; 
		
		while (finger.next() != null){ // Encontrar el final de lista 
			finger = finger.next(); 
		} 

		return (E)finger.value();  
	}

	/**
	 * @return retorna el ultimo elemento en la lista y lo borra
	 */
	public E pop (){

		Nodo<E> finger = head; 
		Nodo<E> previous = null; 
		
		while (finger.next() != null){ // Encontrar el final de lista 
			previous = finger; 
			finger = finger.next(); 
		} 
		// finger is null, or points to end of list 
		if (previous == null) { 
		// has exactly one element 
			head = null; 
		} 
		else { 
		// pointer to last element is reset 
			previous.setNext(null); 
		} 
		contador--; 
		return (E)finger.value();  

	}

	/**
	 * @param pos posicion del elemento
	 * @return el elemento de la posicion indicada
	 */
	public E devolver(int pos) {
		if (pos>=contador)
			return (E) ("Dispo"+Integer.toString(pos+1));
		else{
			
			int recorrido=0;
			Nodo<E> finger = head; 
			while (recorrido<pos){
				finger = finger.next(); 
				recorrido++;
			} 
			return (E)finger.value();  	
		}
	}
	
}