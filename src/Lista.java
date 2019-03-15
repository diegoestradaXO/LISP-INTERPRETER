import java.util.ArrayList;
import java.util.List;

public class Lista extends ArrayList implements List{
	public boolean isOperation;

	public Lista() {
		super();
	}

	public Lista(List list){
		super();
		
		if (list == null){
			list = new Lista();
		}
		
		int i = 0;
		
		while (i < list.size()){
			this.add(list.get(i));
			i++;
		}
	}
	
	public Lista(Atom selectedAtom) {
		super();
		
		this.add(selectedAtom);
	}
    //esta vacia
	public boolean isEmpty(){
		return this.size()==0;
	}
	//agregar al final
	public void insert(Atom atom){
			this.add(atom);
	}
	//agregar en
	public void addIn(int index, Atom selectedAtom){
		this.add(index, selectedAtom);
	}
	
	public boolean exist(Atom selectedAtom){
		int i = 0;
		
		while (i <= this.size() -1){
			if (this.get(i).equals(selectedAtom))
				return true;
			i++;
		}
		
		return false;
	}
	

	public Atom getOperation(){
		if (!this.isOperation)
			return new Atom();
		
		return (Atom)this.get(0);
	}

	public Atom getAtomIn(int i) {
		return (Atom) this.get(i);
	}
	
	private Atom removeAtomIn(int i) {
		return (Atom) this.remove(i);
	}

	public boolean equals(Object listObject){
		Lista myList = (Lista)listObject;
		
		if (this.size()!=myList.size())
			return false;
		
		int index = 0;
		while (index < this.size()){
			if (!this.get(index).equals(myList.get(index)))
				return false;
		}
		
		return true;
	}

	public Atom replaceAt(int i, Atom replacement) {
		Atom atomToReplace = this.removeAtomIn(i);
		this.addIn(i, replacement);
		
		return atomToReplace;
	}
}
