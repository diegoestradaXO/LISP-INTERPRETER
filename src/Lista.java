import java.util.ArrayList;
import java.util.List;

/*Autores:
 *Michael Chan 18562
 *Diego Estrada 18540
 *Isabel Ortiz 18176
 *
 * Proyecto 1: Interprete Lisp en Java
 */

public class Lista extends ArrayList implements List {

    public Lista() {
        super();
    }

    public Lista(List list) {
        super();

        if (list == null) {
            list = new Lista();
        }

        int i = 0;

        while (i < list.size()) {
            this.add(list.get(i));
            i++;
        }
    }

    public Lista(Atom inputAtom) {
        super();

        this.add(inputAtom);
    }

    public boolean isEmpty(){
        return this.size()==0;
    }

    public void addAtFinal(Atom atom){
        this.add(atom);
    }

    public void addOn(int index, Atom atom){
        this.add(index, atom);
    }

    public boolean exist(Atom atom){
        int i = 0;

        while (i <= this.size() -1){
            if (this.get(i).equals(atom))
                return true;
            i++;
        }

        return false;
    }

    public Atom getOperation(){

        return (Atom)this.get(0);
    }

    public Atom getAtomOn(int i) {
        return (Atom) this.get(i);
    }

    private Atom removeAtomOn(int i) {
        return (Atom) this.remove(i);
    }

    public boolean equals(Object listObject){
        Lista otherList = (Lista)listObject;

        if (this.size()!=otherList.size())
            return false;

        int index = 0;
        while (index < this.size()){
            if (!this.get(index).equals(otherList.get(index)))
                return false;
        }

        return true;
    }

    public Atom replaceWith(int i, Atom newAtom) {
        Atom replacedAtom = this.removeAtomOn(i);
        this.add(i, newAtom);

        return replacedAtom;
    }

}