/**
 * Proyecto Lisp
 * @author Isabel Ortiz Naranjo 18176
 * @author Diego Estrada 18540
 * @author Michael Chan 18562
 *
 */

public class Node <E> {

    private Object Element;
    private Node<E> NextE;

    // Se crea un nuevo nodo

    public Node(Object element, Node<E> next) {
        Element = element;
        NextE = next;
    }

    // Retorna el elemento siguiente de la lista

    public Node<E> next() {
        return NextE;
    }

    // Determina el siguiente elemento

    public void setNext(Node<E> next){
        NextE = next;
    }

    // Retorna el valor asociado con el elemento

    public Object value() {
        return Element;
    }


}
