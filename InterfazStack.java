/**
 * Proyecto Lisp
 * @author Isabel Ortiz Naranjo 18176
 * @author Diego Estrada 18540
 * @author Michael Chan 18562
 */
public interface InterfazStack<E> {

	/**
	 * @return si hay elementos en la lista
	 */
	public boolean empty ();

	/**
	 * @return si la lista esta llena
	 */
	public boolean full ();

	/**
	 * @param pos posicion del elemento
	 * @return el elemento en la posicion que se solicita
	 */
	public E devolver(int pos);

	/**
	 * @param element elemento a agregar
	 */
	public void push (E element);

	/**
	 * @return ultimo elemento de la lista y lo borra
	 */
	public E pop ();

	/**
	 * @return ultimo elemento de la lista y no lo borra
	 */
	public E top ();
	}
