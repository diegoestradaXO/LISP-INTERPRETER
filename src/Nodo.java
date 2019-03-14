/**
 * Proyecto Lisp
 * @author Isabel Ortiz Naranjo 18176
 * @author Diego Estrada 18540
 * @author Michael Chan 18562
 *
 */

public class Nodo <E> {

    private Object Element;
    private Node<E> Next;

    // Nuevo nodo

    public Node(Object element, Node<E> next) {
        Element = element;
        NextE = next;
    }

    //Devuelve el siguiente elemento en la lista

    public Node<E> next() {
        return NextE;
    }

    // Establece el siguiente elemento

    public void setNext(Node<E> next){
        NextE = next;
    }

    // Devuelve el valor asociado con este elemento.
    public Object value() {
        return Element;
    }


}