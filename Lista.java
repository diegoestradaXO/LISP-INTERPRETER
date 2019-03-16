/**
 * Proyecto Lisp
 * @author Isabel Ortiz Naranjo 18176
 * @author Diego Estrada 18540
 * @author Michael Chan 18562
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Clase lista
 */
public class Lista extends ArrayList implements List{
	/**
	 * declaracion de la operacion
	 */
	public boolean esOperacion;

	/**
	 * Constructor super ()
	 */
	public Lista() {
		super();
	}

	/**
	 * Constructor super ()
	 * @param lista paremetro lista tipo List
	 */
	public Lista(List lista){
		super();
		
		if (lista == null){
			lista = new Lista();
		}
		
		int i = 0;
		
		while (i < lista.size()){
			this.add(lista.get(i));
			i++;
		}
	}

	/**
	 * @param atomoIngresado parametro atomoIngresado de tipo Atomo
	 */
	public Lista(Atomo atomoIngresado) {
		super();
		
		this.add(atomoIngresado);
	}

	/**
	 * @return retorna si esta vacia la lista
	 */
	public boolean estaVacia(){

		return this.size()==0;
	}

	/**
	 * @param atomo atomo de tipo Atomo
	 */
	public void AgregarAlFinal(Atomo atomo){
			this.add(atomo);
	}

	/**
	 * Metodo para agregar en un indice indicado
	 * @param indice indice de lo que se quiere agregar
	 * @param atomo atomo de tipo Atomo
	 */
	public void AgregarEn(int indice, Atomo atomo){
		this.add(indice, atomo);
	}

	/**
	 * Metodo para saber si existe un atomo
	 * @param atomo atomo de tipo Atomo
	 * @return retorna true o false, dependiendo de la existencia del atomo
	 */
	public boolean existe(Atomo atomo){
		int i = 0;
		
		while (i <= this.size() -1){
			if (this.get(i).equals(atomo))
				return true;
			i++;
		}
		
		return false;
	}


	/**
	 * @return la operacion
	 */
	public Atomo getOperacion(){
		if (!this.esOperacion)
			return new Atomo();
		
		return (Atomo)this.get(0);
	}

	/**
	 * @param i parametro entero
	 * @return atomo
	 */
	public Atomo getAtomoEn(int i) {
		return (Atomo) this.get(i);
	}

	/**
	 *
	 * @param i entero i
	 * @return retorna el atomo
	 */
	private Atomo removeAtomoEn(int i) {
		return (Atomo) this.remove(i);
	}


	/**
	 * @param objetoLista de tipo Object
	 * @return retorna un valor booleano, true o false
	 */
	public boolean equals(Object objetoLista){
		Lista otraLista = (Lista)objetoLista;
		
		if (this.size()!=otraLista.size())
			return false;
		
		int indice = 0;
		while (indice < this.size()){
			if (!this.get(indice).equals(otraLista.get(indice)))
				return false;
		}
		
		return true;
	}

	/**
	 * Metodo para remplazar
	 * @param i entero
	 * @param atomoRemplazante atomo que va a remplazar
	 * @return atomo remplazado
	 */
	public Atomo remplazarEn_Por(int i, Atomo atomoRemplazante) {
		Atomo atomoRemplazado = this.removeAtomoEn(i);
		this.AgregarEn(i, atomoRemplazante);
		
		return atomoRemplazado;
	}
}
