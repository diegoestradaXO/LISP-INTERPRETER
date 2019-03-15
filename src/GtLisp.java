import java.util.Hashtable;
import java.util.StringTokenizer;

public class GtLisp {
	Prompt prompt;
	Lista listaDeOperacionesImplementadas;
	Lista listaDePredicados;
	Hashtable<String,Atom> variablesDelUsuario = new Hashtable<String,Atom>();
	Hashtable<String,Atom> funcionesDelUsuario = new Hashtable<String,Atom>();

	public GtLisp(){
		definirOperacionesImplementadas();
		definirPredicados();
	}

	private void definirPredicados() {
		this.listaDePredicados = new Lista();
		this.listaDePredicados.insert(new Atom("="));
		this.listaDePredicados.insert(new Atom("/="));
		this.listaDePredicados.insert(new Atom("<"));
		this.listaDePredicados.insert(new Atom("<="));
		this.listaDePredicados.insert(new Atom(">"));
		this.listaDePredicados.insert(new Atom(">="));
	}


	private void definirOperacionesImplementadas() {

		this.listaDeOperacionesImplementadas = new Lista();
		/*
		 * Ordenadas alfabeticamente
		 */
		String textoDeAyuda = "";
		
		//textoDeAyuda = "";
		//this.listaDeOperacionesImplementadas.insert();(new Atom("atom"));
		
		textoDeAyuda = "car <lista>\n" +
				"Retorna el \'car\' de una lista, que es el primer atom de una lista\n" +
				"Ejemplo 1: (car '(1 2 3)) => 1\n" +
				"Ejemplo 2: (car '((1 2 3) 4 5)) => (1 2 3)\n";

		this.listaDeOperacionesImplementadas.insert(new Atom("car",textoDeAyuda));
		
		textoDeAyuda = "cdr <lista>\n" +
		"Retorna el \'cdr\' de una lista, que es una sublista una lista partiendo desde el segundo atom\n" +
		"Ejemplo 1: (cdr '(1 2 3)) => (2 3)\n" +
		"Ejemplo 2: (cdr '(1 2 3 (cdr '(4 5 6)))) => (2 3 (5 6))\n";
		this.listaDeOperacionesImplementadas.insert(new Atom("cdr",textoDeAyuda));
		
		//this.listaDeOperacionesImplementadas.insert();(new Atom("cond"));
		
		textoDeAyuda = "cons <atom 1> <atom 2> \n" +
		"Es la funcion primitiva para crear un nuevo cons, cuyo \"car\" es <atom 1> y cuyo \"cdr\" es <atom 2>\n" +
		"Ejemplo 1: (cons 'a 'b) => (a b)\n" +
		"Ejemplo 2: (cons 'a (cons 'b (cons 'c '()))) => (a b c)\n" +
		"Ejemplo 3: (cons 'a '(b c d)) => (a b c d)\n";
		this.listaDeOperacionesImplementadas.insert(new Atom("cons",textoDeAyuda));
		
		textoDeAyuda = "Define una nueva funcion llamada <nombre de la funcion> en el ambito global. \n" +
		"Puede usarse para definir una funcion, corregir una o redefinirla. \n" +
		"Ejemplo 1: (defun alCuadrado (x) (* x x)) => alCuadrado\n"+
		"Como usarlo: (alCuadrado 2) => 4 \n\n"+
		"Ejemplo 2: (defun factorial (x) \n" +
		"\t (cond\n" +
        "\t\t((> x 0)\n" + 
        "\t\t\t(* x (factorial (- x 1)))\n"+
        "\t\t)\n" + 
        "\t\t(t\n" + 
        "\t\t\t1\n" +
        "\t\t)\n" +
        "\t)\n" +
        ")\n" +
		"Como usarlo: (factorial 5) => 120\n";
		
		this.listaDeOperacionesImplementadas.insert(new Atom("defun",textoDeAyuda));
		//this.listaDeOperacionesImplementadas.insert();(new Atom("lisp"));
		
		textoDeAyuda = "list-length <lista>\n" +
		"Retorna el tamano de una lista\n" +
		"Ejemplo 1: (list-length '(1 2 3 4 5)) => 5\n" + 
		"Ejemplo 2: (list-length '(1 2 (car '(4 5)))) => 3\n";
		
		this.listaDeOperacionesImplementadas.insert(new Atom("list-length",textoDeAyuda));
		//this.listaDeOperacionesImplementadas.insert();(new Atom("mapcar"));
		//this.listaDeOperacionesImplementadas.insert();(new Atom("prog1"));
		//this.listaDeOperacionesImplementadas.insert();(new Atom("progn"));
		
		textoDeAyuda = "setq <variable de asignacion> <valor asignado>\n" +
		"Asocia un <valor asignado> a una <variable de asignacion>\n" +
		"Ejemplo 1: (setq lista '(1 2 3))\n" +
		"Ejemplo 2: (setq primerAtom (car lista))\n";
			
		this.listaDeOperacionesImplementadas.insert(new Atom("setq",textoDeAyuda));
		
		textoDeAyuda = "+ <num 1> <num 2> .. <num n>\n" +
		"Suma dos o mas numeros \n" +
		"Ejemplo 1: (+ 1 2) => 3\n" +
		"Ejemplo 2: (+ 1 2 (+ 3 4)) => 10 \n";
		this.listaDeOperacionesImplementadas.insert(new Atom("+",textoDeAyuda));
		
		textoDeAyuda = "* <num 1> <num 2> .. <num n>\n" +
		"Multiplica dos o mas numeros \n" +
		"Ejemplo 1: (* 1 2) => 2\n" +
		"Ejemplo 2: (* 2 (+ 3 4)) => 14 \n";
		this.listaDeOperacionesImplementadas.insert(new Atom("*",textoDeAyuda));
		
		textoDeAyuda = "- <num 1> <num 2> .. <num n> \n" +
		"Resta dos o mas numeros \n" +
		"Ejemplo 1: (- 8 4) => 4\n" +
		"Ejemplo 2: (- 10 (+ 3 4)) => 3 \n";
		this.listaDeOperacionesImplementadas.insert(new Atom("-",textoDeAyuda));
		
		textoDeAyuda = "/ <num 1> <num 2> .. <num n> \n" +
		"Divide dos o mas numeros \n" +
		"Ejemplo 1: (/ 1 2) => 0.5\n" +
		"Ejemplo 2: (/ 5 (+ 1 1)) => 2.5 \n";
		this.listaDeOperacionesImplementadas.insert(new Atom("/",textoDeAyuda));
		
		textoDeAyuda = "equal <atom 1> <atom 2> \n" +
		"Ejemplo 1: (equal 'a 'a) => T \n"+
		"Ejemplo 2: (equal (+ 1 1) (* 2 1))\n";
		this.listaDeOperacionesImplementadas.insert(new Atom("equal",textoDeAyuda));
		
		textoDeAyuda = "type-of <atom 1>\n" +
		"Ejemplo 1: (type-of 'e) => SYMBOL\n" +
		"Ejemplo 2: (type-of 1.0) => SINGLE-FLOAT\n";
		this.listaDeOperacionesImplementadas.insert(new Atom("type-of",textoDeAyuda));
		
		textoDeAyuda = "cond <clausula 1> <clausula 2> .. <clausula n> \n" +
		"Ejemplo 1: (cond ((+ 3 4))) => 7 \n" +
		"Ejemplo 2: (cond ((= 1 2) 'a) ((= 1 1) 'b))\n";
		this.listaDeOperacionesImplementadas.insert(new Atom("cond",textoDeAyuda));
		
		textoDeAyuda = "";
		this.listaDeOperacionesImplementadas.insert(new Atom("list",textoDeAyuda));

		/**
		 * Predicados
		 */
		this.listaDeOperacionesImplementadas.insert(new Atom("="));
		this.listaDeOperacionesImplementadas.insert(new Atom("/="));
		this.listaDeOperacionesImplementadas.insert(new Atom("<"));
		this.listaDeOperacionesImplementadas.insert(new Atom("<="));
		this.listaDeOperacionesImplementadas.insert(new Atom(">"));
		this.listaDeOperacionesImplementadas.insert(new Atom(">="));
	}

	public Atom parsearExpresion(String expresionAParsear,boolean estaDefiniendoUnaLista,boolean esClausula){
		//System.out.println("Expresion A Parsear: "+expresionAParsear+ " ,definiendoLista: "+estaDefiniendoUnaLista+" ,esClausula: "+esClausula);
		
		expresionAParsear = expresionAParsear.trim();
		
		/**
		 * Si lo que el usuario ingreso es "" (es decir, no hubieron tokens), parsear un atom nulo
		 */
		if (expresionAParsear.compareTo("")==0)
			return new Atom();
		
		/**
		 * Ver si est� balanceada
		 */
		if (!this.estaBienBalanceada(expresionAParsear))
			return new Atom();

		Atom atomDeRespuesta = new Atom();
		
		/**
		 * Instanciar un separador de tokens
		 */
		StringTokenizer separador = new StringTokenizer(expresionAParsear);
		
		String primerToken = separador.nextToken();
		Atom atomIngresado = new Atom(primerToken);

		/**
		 * Si al separador le quedan 0 tokens, significa que ingreso toda la expresion en un solo token
		 * Puede ser una lista de la forma
		 * '(atom)
		 * o una variable
		 */	
		if ((separador.countTokens()==0)){
			/**
			 * Ver si es una variable, y si hay que evaluarla
			 * Hay que evaluarla si y solo si, estaDefiniendoUnaLista es false
			 */
			if ((this.variablesDelUsuario.containsKey(primerToken)) && (!estaDefiniendoUnaLista))
				return this.variablesDelUsuario.get(primerToken);
			
			if ((primerToken.compareTo("'()")==0) || ((primerToken.compareTo("()")==0)))
				return new Atom();

			if (primerToken.charAt(0)=='\''){
				if ((primerToken.charAt(1)!='(') && (primerToken.charAt(primerToken.length()-1)!=')'))
					return new Atom(primerToken.substring(1));
			}
		}

		/**
		 * Si no retorno nada antes, puede ser que quiera parsearse una lista
		 *
		 *
		 * Si el primer simbolo del separador comienza con "'(", se esta definiendo una lista
		 * Si la expresion es '(algo '(1 2 3)), se esta defiendo una lista con dos elementos,
		 * OJO: tambien se puede estar definiendo la misma lista con '(algo (1 2 3))
		 * el primero es "algo" y el segundo es la lista (1 2 3). Por definici�n, cuando la lista
		 * se define con '(, es una lista y no una operacion. Para ingresar una operacion, habria que
		 * hacer (car '(1 2 3))
		 */
		if ((new Atom(primerToken).startsWith("'("))){
			estaDefiniendoUnaLista = true;
			atomDeRespuesta = new Atom(new Lista());
			atomDeRespuesta.lista.isOperation = false;
			
			/**
			 * Entonces, quiere parsear una lista
			 * hay que cortar la expresi�n que esta dentro de esta..
			 * eso es, la expresi�n a partir del primer parentesis abierto (indice 1) hasta el parentesis que lo cierra
			 */
			
			int desdeDondeCortar = expresionAParsear.indexOf('(') + 1;
			int hastaDondeCortar = this.obtenerIndiceDelParentesisQueCierraAlPrimeroEn(expresionAParsear);
			
			/**
			 * Ver si no hay listas despues de esta lista.. es decir, que es la lista "mayor"
			 * es decir, la que encapsula a todas. De ser asi..
			 * no debe haber nada despues del ultimo parentesis
			 */
			if ((hastaDondeCortar==expresionAParsear.lastIndexOf(')')) && (!(hastaDondeCortar==expresionAParsear.length()-1)))
				return new Atom();
			
			expresionAParsear = expresionAParsear.substring(desdeDondeCortar, hastaDondeCortar);			
		} else if (primerToken.charAt(0)=='('){
			/**
			 * Entonces, puede estar tratando de parsear una operacion
			 * o una lista
			 * 
			 * Esta parseando una operacion si: estaDefiniendoUnaLista es false
			 * Esta parseando una operacion si: esCOND es true
			 * Esta parseando una lista si: estaDefiniendoUnaLista es true
			 */
			
			int desdeDondeCortar = expresionAParsear.indexOf('(') + 1;
			int hastaDondeCortar = this.obtenerIndiceDelParentesisQueCierraAlPrimeroEn(expresionAParsear);
			
			expresionAParsear = expresionAParsear.substring(desdeDondeCortar,hastaDondeCortar);
			atomDeRespuesta = new Atom(new Lista());
			
			
			separador = new StringTokenizer(expresionAParsear);
			String primerTokenDeLaLista = separador.nextToken();
			
			boolean esFuncion = (Lista.isOperationImplementada(primerTokenDeLaLista)) || this.funcionesDelUsuario.containsKey(primerTokenDeLaLista);
			
			if ((!estaDefiniendoUnaLista) && (!esFuncion)){
				/**
				 * Ver si se esta definiendo a ella misma
				 */
				return new Atom();
			}	
			
			if (estaDefiniendoUnaLista){
				if (!esClausula)
					atomDeRespuesta.lista.isOperation = false;
				else
					atomDeRespuesta.lista.isOperation = true;
			}else {
				atomDeRespuesta.lista.isOperation = true;
			}
		}		
		
		/**
		 * Ahora, revisar si es una lista.. o no, si no era una lista, eso significa que
		 * ingreso cualquier String, digamos "aasd asdf adsf sd saf"
		 */
		if (!atomDeRespuesta.EsLista())
			return new Atom(expresionAParsear);
		
		separador = new StringTokenizer(expresionAParsear);
		
		while (separador.hasMoreTokens()) {
			Atom atomActual = new Atom(separador.nextToken());

			/**
			 * Si encuentra una lista nueva ya sea sin operacion (empezando con "'(")
			 * o con operacion (empezando con "("), mandar a parsearla recursivamente
			 */
			if ((atomActual.startsWith("'(")) || (atomActual.startsWith("("))){
				/**
				 * Obtener la expresi�n de la lista
				 */
				int desdeDondeCortar = expresionAParsear.indexOf(atomActual.toString());
				expresionAParsear = expresionAParsear.substring(desdeDondeCortar);
				int hastaDondeCortar = this.obtenerIndiceDelParentesisQueCierraAlPrimeroEn(expresionAParsear);
				String expresionDeLaListaInterna = expresionAParsear.substring(0, hastaDondeCortar+1);
				Atom atomConLaListaInterna = new Atom();
				
				boolean esDefun = false;
				boolean esCOND = false;
				
				if (atomActual.startsWith("'("))
					atomConLaListaInterna = this.parsearExpresion(expresionDeLaListaInterna, true, esClausula);
				else {
					if (atomDeRespuesta.lista.size() > 0){
						if (atomDeRespuesta.EsListaConOperacion()){
							String operacionDeLaLista = atomDeRespuesta.lista.getOperacion().toString();
							
							/**
							 * Si es Defun y si atomActual es el tercer atom, parsearlo como lista
							 * ya que son los parametros de la funcion
							 */
							if ((operacionDeLaLista.compareToIgnoreCase("defun")==0) && (atomDeRespuesta.lista.size()==2)){
								atomConLaListaInterna = this.parsearExpresion(expresionDeLaListaInterna, true,false);
								esDefun = true;
							}
							
							/**
							 * Si es COND, parsearlo como lista
							 */
							if (operacionDeLaLista.compareToIgnoreCase("cond")==0){
								esCOND = true;
								atomConLaListaInterna = this.parsearExpresion(expresionDeLaListaInterna, true,true);
							}
						}
					/*	if ((atomDeRespuesta.lista.getAtomIn(0).toString().compareToIgnoreCase("defun")==0) && (atomDeRespuesta.lista.size()==2)){
							/**
							 * Obtener los parametros
							 */
					/*		atomConLaListaInterna = this.parsearExpresion("'"+expresionDeLaListaInterna, estaDefiniendoUnaLista);
							esDefun = true;
						}*/
					}
					
					if ((!esDefun) && (!esCOND))
						atomConLaListaInterna = this.parsearExpresion(expresionDeLaListaInterna, estaDefiniendoUnaLista, esClausula);
					
				}
				
				atomDeRespuesta.lista.insert(atomConLaListaInterna);
				String expresionDespuesDeLaListaInterna = expresionAParsear.substring(hastaDondeCortar + 1);
				expresionAParsear = expresionDespuesDeLaListaInterna;
				
				if (!esDefun){
					/**
					 * Instanciar de nuevo el separador a partir
					 * de en donde termina la lista
					 */
					separador = new StringTokenizer(expresionDespuesDeLaListaInterna);
				} else {
					/**
					 * Crear la funcion, es decir, meter la operacion
					 * por si esta haciendo una funcion recursiva 
					 */
					String nombreDeLaFuncion = atomDeRespuesta.lista.getAtomIn(1).toString();
					this.funcionesDelUsuario.put(nombreDeLaFuncion,new Atom());
					
					Atom atomConLaOperacion = this.parsearExpresion(expresionAParsear.trim(), false,false);
					atomDeRespuesta.lista.insert(atomConLaOperacion);
					separador = new StringTokenizer("");
					
					this.funcionesDelUsuario.remove(nombreDeLaFuncion);
				}
			} else{
				/**
				 * Es un simple atom, agregarlo a la lista
				 * Si es un atom que tiene un valor asignado, ponerlo
				 */
				int desdeDondeCortar = expresionAParsear.indexOf(atomActual.toString());
				expresionAParsear = expresionAParsear.substring(desdeDondeCortar);
				
				if (atomActual.startsWith("'"))
					/**
					 * Ver si comienza con '
					 * o 'b
					 */
					atomActual = new Atom(atomActual.toString().substring(1));
					
				atomDeRespuesta.lista.insert(atomActual);
			}
		}
		
		//System.out.print("Parseo: "+atomDeRespuesta.toString());
		//System.out.println(" Es lista con operacion?: "+atomDeRespuesta.EsListaConOperacion());
		return atomDeRespuesta;
	}
	
	/**
	 * Metodo que verifica si posibleOperacion esta dentro de la Lista listasOperacionesImplementadas
	 * @param posibleOperacion
	 * @return
	 */
	private boolean isOperationImplementada(String posibleOperacion) {
		return this.listaDeOperacionesImplementadas.existe(new Atom(posibleOperacion));
	}

	/**
	* Metodo que revisa si una expresion esta bien balanceada o no,
	* es decir, si tiene el mismo numero de parentesis cerrados que abiertos.
	* @return true si la expresion esta bien balanceada, false de lo contrario
	* @author kmels
	*/
	public boolean estaBienBalanceada(String expresion) {
			int parentesisAbiertos = 0;
			int parentesisCerrados = 0;
			/*
			 * Recorrer expresion
			 */
			for (int i=0 ; i < expresion.length() ; i++){
				if (expresion.charAt(i) == '(')
					parentesisAbiertos++;
				else if (expresion.charAt(i) == ')')
					parentesisCerrados++;
			}
			
			return parentesisAbiertos == parentesisCerrados;
		}
 

	public Atom evaluar(Atom atomAEvaluar){
		Atom AtomDeRespuesta = new Atom();
		
		//System.out.println("atomAEvaluar: " +atomAEvaluar);
		if (atomAEvaluar.esNulo)
			return new Atom();
		
		if (atomAEvaluar.EsLista()){
			/**
			 * Si es una lista, puede ser que sea una simple lista, o una lista con operacion
			 * De ahora en adelante, se hablara de listaAEvaluar y no atomAEvaluar
			 */
			Lista listaAEvaluar = atomAEvaluar.lista;
			
			if (listaAEvaluar.isOperation){
				//System.out.println("listaAEvaluar.isOperation: " +listaAEvaluar.isOperation);
				/**
				 * Evaluar todos los atoms que estan dentro
				 */
				String operacionDeLaLista = listaAEvaluar.getOperacion().toString();
				if ((operacionDeLaLista.compareToIgnoreCase("defun")!=0) && (operacionDeLaLista.compareToIgnoreCase("cond")!=0))
					for (int i=0 ; i < listaAEvaluar.size() ; i++){
						if (listaAEvaluar.getAtomIn(i).EsListaConOperacion()){
							Atom listaEvaluada = this.evaluar(listaAEvaluar.getAtomIn(i));
							listaAEvaluar.remplazarEn_Por(i, listaEvaluada);
						} else if (this.variablesDelUsuario.containsKey(listaAEvaluar.getAtomIn(i).toString())){
							Atom valorDelAtom = this.variablesDelUsuario.get(listaAEvaluar.getAtomIn(i).toString());
							/**
							 * Si no la esta estableciendo, es decir
							 * si no esta haciendo 
							 * setq <atom que se esta evaluando> <valor a asignar>
							 * Evaluarlo
							 */
							if (listaAEvaluar.isOperation){
								if (!((i==1) && (listaAEvaluar.getOperacion().toString().compareTo("setq")==0)))
									listaAEvaluar.remplazarEn_Por(i, valorDelAtom);
							} else 
								listaAEvaluar.remplazarEn_Por(i, valorDelAtom);
						}
					}								
			} else {
				//System.out.println("listaAEvaluar.isOperation: " +listaAEvaluar.isOperation);
				return new Atom(listaAEvaluar);
			}
			
			/**
			 * Si es operacion, entonces hay que evaluarla
			 */			
			String operacion = listaAEvaluar.getOperacion().toString();
			if (this.esPredicado(operacion)){
				return this.evaluarPredicado(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("cdr")==0){
				return this.cdr(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("car")==0){
				return this.car(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("list-length")==0){
				return this.list_length(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("setq")==0){
				return this.setq(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("cons")==0){
				return this.cons(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("+")==0){
				return this.sumar(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("*")==0){
				return this.multiplicar(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("-")==0){
				return this.restar(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("/")==0){
				return this.dividir(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("defun")==0){
				return this.defun(listaAEvaluar);
			} else if (this.funcionesDelUsuario.containsKey(operacion)){
				return this.operarFuncionDelUsuario(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("equal")==0){
				return this.equal(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("type-of")==0){
				return this.type_of(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("cond")==0){
				return this.cond(listaAEvaluar);
			} else if (operacion.compareToIgnoreCase("list")==0){
				return this.list(listaAEvaluar);
			}
		} else{
			/**
			 * No es una lista, puede ser una variable
			 */
			if (this.variablesDelUsuario.containsKey(atomAEvaluar.toString()))
				AtomDeRespuesta = this.variablesDelUsuario.get(atomAEvaluar.toString());
			else
				/**
				 * Ya est� evaluado.
				 */
				AtomDeRespuesta = atomAEvaluar;
		}
		
		return AtomDeRespuesta;
	}

	private Atom list(Lista listaAEvaluar) {
		// Declarar variables y objetos
		Lista lista = new Lista();
		
		for(int i = 1; i < listaAEvaluar.size(); i++) {
			lista.insert(this.evaluar(listaAEvaluar.getAtomIn(i)));
		}
		
		return new Atom(lista);
	}

	private Atom evaluarPredicado(Lista listaAEvaluar){
		Atom atomDeRespuesta = new Atom();
		
		String predicadoAEvaluar = listaAEvaluar.getAtomIn(0).toString();
		if (!this.esPredicado(predicadoAEvaluar))
            return new Atom();
		if (predicadoAEvaluar.compareTo("=")==0){
			if (!(listaAEvaluar.size() > 1))
                return new Atom();
			boolean sonIguales = true;
			for (int i = 1 ; i < listaAEvaluar.size()-1 ; i++){
				sonIguales = listaAEvaluar.getAtomIn(i).equals(listaAEvaluar.getAtomIn(i+1));
				
				if (!sonIguales)
					return new Atom(sonIguales);
					
			}

			return new Atom(sonIguales);
		} else if (predicadoAEvaluar.compareTo("/=")==0){
			if (!(listaAEvaluar.size() > 1))
				return new Atom();
			
			boolean sonDiferentes = true;
			
			for (int i = 1 ; i < listaAEvaluar.size()-1 ; i++){
				sonDiferentes = !listaAEvaluar.getAtomIn(i).equals(listaAEvaluar.getAtomIn(i+1));
				
				if (!sonDiferentes)
					return new Atom(false);
			}
			return new Atom(sonDiferentes);
		} else if (predicadoAEvaluar.compareTo("<")==0){
			if (!(listaAEvaluar.size() > 1))
				return new Atom();
			
			boolean esMenorQue = true;
			
			for (int i = 1; i <listaAEvaluar.size()-1 ; i++){
				
				if (!(listaAEvaluar.getAtomIn(i).esNumero()))
					return new Atom();
				
				esMenorQue = listaAEvaluar.getAtomIn(i).getNumero() < listaAEvaluar.getAtomIn(i+1).getNumero();
				
				if (!esMenorQue)
					return new Atom (false);
			}
			
			return new Atom(esMenorQue);
		} else if (predicadoAEvaluar.compareTo("<=")==0){
			if (!(listaAEvaluar.size() > 1))
				return new Atom();
			
			boolean esMenorIgualQue = true;
			
			for (int i = 1; i <listaAEvaluar.size()-1 ; i++){
				if (!(listaAEvaluar.getAtomIn(i).esNumero()))
                    return new Atom();
				
				esMenorIgualQue = listaAEvaluar.getAtomIn(i).getNumero() <= listaAEvaluar.getAtomIn(i+1).getNumero();
				if (!esMenorIgualQue)
					return new Atom (false);
			}
			return new Atom(esMenorIgualQue);
		} else if (predicadoAEvaluar.compareTo(">")==0){
			if (!(listaAEvaluar.size() > 1))
                return new Atom();
			
			boolean esMayorQue = true;
			
			for (int i = 1; i <listaAEvaluar.size()-1 ; i++){
				
				if (!(listaAEvaluar.getAtomIn(i).esNumero()))
                    return new Atom();
				
				esMayorQue = listaAEvaluar.getAtomIn(i).getNumero() > listaAEvaluar.getAtomIn(i+1).getNumero();
				
				if (!esMayorQue)
					return new Atom (false);
			}
			
			return new Atom(esMayorQue);
		} else if (predicadoAEvaluar.compareTo(">=")==0){
			if (!(listaAEvaluar.size() > 1))
                return new Atom();
			
			boolean esMayorIgualQue = true;
			
			for (int i = 1; i <listaAEvaluar.size()-1 ; i++){
				if (!(listaAEvaluar.getAtomIn(i).esNumero()))
                    return new Atom();
				
				esMayorIgualQue = listaAEvaluar.getAtomIn(i).getNumero() >= listaAEvaluar.getAtomIn(i+1).getNumero();
				if (!esMayorIgualQue)
					return new Atom (false);
			}
			return new Atom(esMayorIgualQue);
		}

        return new Atom();
	}

	private boolean esPredicado(String operacion) {	
		return this.listaDePredicados.existe(new Atom(operacion));
	}


	private Atom cond(Lista listaAEvaluar){
		if (listaAEvaluar.size()<2)
			return new Atom();
		
		/**
		 * Ir a traves de todas las sublistas y ver si hay que ejecutarlas
		 */
		int revisandoSubListaIndex = 1;
		boolean haEncontradoRespuesta = false;
		Atom atomDeRespuesta = new Atom();
		
		while ((revisandoSubListaIndex < listaAEvaluar.size()) && (!haEncontradoRespuesta)){
			/**
			 * listaAEvaluar.getAtomIn(i) tiene que ser una lista, de lo contrario, ingreso mal
			 * los parametros de "cond"
			 */
			if (!listaAEvaluar.getAtomIn(revisandoSubListaIndex).EsLista())
				return new Atom();
			else {
				/*
				 * Revisar que no sea una lista NIL
				 */
				
			}
			
			Lista evaluandoSubLista = listaAEvaluar.getAtomIn(revisandoSubListaIndex).lista;
			
			/**
			 * Evaluar su primer atom, para ver si es TRUE
			 */
			Atom primerAtom = evaluandoSubLista.getAtomIn(0);
			
			/**
			 * Si no es la ultima clausula, y todavia no hay respuesta, no validar
			 */
			if (!((atomDeRespuesta.esNulo) && (revisandoSubListaIndex==listaAEvaluar.size()-1))) {
				if ((!primerAtom.EsLista()) && (!this.variablesDelUsuario.containsKey(primerAtom.toString())))
					return new Atom();
			}
			
			Atom primerAtomEvaluado = this.evaluar(primerAtom);
			
			
			/**
			 * Si el primer atom de evaluandoSubLista no es NIL (es TRUE):
			 * 		Encontro respuesta
			 * 			Si hay un atom de respuesta, retornar ese atom de respuesta
			 * 			Si no, retornar el atom evaluado (el que no es NIL)
			 * Si el primer atom es NIL, atomDeRespuesta = NIL (pero no ha encontrado respuesta, es decir, atomDeRespueta es un valor parcial, o temporal)
			 *				atomDeRespuesta = nil, no?
			 *
			 */
			
			if (!primerAtomEvaluado.esNulo){
				haEncontradoRespuesta = true;
					
				if (evaluandoSubLista.size() > 1)
					/**
					 * Entonces, especifico una respuesta
					 */
					atomDeRespuesta = this.evaluar(evaluandoSubLista.getAtomIn(evaluandoSubLista.size()-1));
				else
					/**
					 * Retornar el valor evaluado
					 */
					atomDeRespuesta = primerAtomEvaluado;
			} 
			
			revisandoSubListaIndex ++;
		}
		
		
		return atomDeRespuesta;
	}

	private Atom type_of(Lista listaAEvaluar){
		if (listaAEvaluar.size()!=2)
			return new Atom();
		
		return new Atom(listaAEvaluar.getAtomIn(1).getTipo());
	}

	private Atom equal(Lista listaAEvaluar){
		/**
		 * Revisar que tenga dos parametros
		 * 
		 */
		if (listaAEvaluar.size()!=3)
			return new Atom();
		
		/**
		 * Definici�n de equal:
		 * The equal predicate is true if its arguments are structurally similar (isomorphic) objects. 
		 * A rough rule of thumb is that two objects are equal if and only if their printed representations 
		 * are the same.
		 */
		return new Atom(listaAEvaluar.getAtomIn(1).toString().compareTo(listaAEvaluar.getAtomIn(2).toString())==0);
	}


	private Atom operarFuncionDelUsuario(Lista listaAEvaluar){
		/**
		 * Mapear parametros a valores 
		 */
		int numeroDeParametrosQueIngreso = listaAEvaluar.size()-1;
		
		Lista listaDeLosParametros = this.funcionesDelUsuario.get(listaAEvaluar.getOperacion().toString()).lista.getAtomIn(0).lista;
		
		//System.out.println("Lista de parametros:" + listaDeLosParametros);
		int numeroDeParametrosDeLaFuncion = listaDeLosParametros.size();
		
		if (numeroDeParametrosDeLaFuncion!=numeroDeParametrosQueIngreso)
			return new Atom();

		Hashtable<String,Atom> mapaDeParametrosYValores = new Hashtable<String,Atom>();
		
		for (int i =1 ; i <= numeroDeParametrosQueIngreso ; i++){
			//System.out.println("Mapeando el parametro "+i);
			mapaDeParametrosYValores.put(listaDeLosParametros.getAtomIn(i-1).toString(), listaAEvaluar.getAtomIn(i));
		}
		
		//System.out.println("mapaDeParametrosYValores"+mapaDeParametrosYValores);
		
		Atom atomDeLaOperacion = this.funcionesDelUsuario.get(listaAEvaluar.getOperacion().toString()).lista.getAtomIn(1);
		
		if (atomDeLaOperacion.EsLista()){
			Atom listaAEvaluarConParametrosMapeados = this.mapearParametrosEn(mapaDeParametrosYValores, new Atom(atomDeLaOperacion.lista));
			return this.evaluar(listaAEvaluarConParametrosMapeados);
		} else
			return atomDeLaOperacion;
		
	}


	private Atom mapearParametrosEn(Hashtable<String, Atom> mapaDeParametrosYValores, Atom atomEnDondeMapear){

		/**
		 * Hay que copiar la lista, por que de otro modo se estaria sobre escribiendo
		 * la funcion
		 */
		Lista listaAEvaluar = new Lista(atomEnDondeMapear.lista);
		listaAEvaluar.isOperation = atomEnDondeMapear.lista.isOperation;
		
		//System.out.println("Antes de mapear: "+listaAEvaluar);
		
		/**
		 * Ir a travez de cada uno de los elementos de la lista a evaluar, y mapear los
		 * parametros a sus valores 
		 */
		for (int i= 0 ; i < listaAEvaluar.size(); i++){
			Atom atomActual = listaAEvaluar.getAtomIn(i);
			
			if (atomActual.EsLista()){
				listaAEvaluar.remplazarEn_Por(i,this.mapearParametrosEn(mapaDeParametrosYValores, atomActual));
			} else{
				if (mapaDeParametrosYValores.containsKey(atomActual.toString()))
					listaAEvaluar.remplazarEn_Por(i,mapaDeParametrosYValores.get(atomActual.toString()));
			}
		}
		
		//System.out.println("Ya mapeado: "+ listaAEvaluar);
		return new Atom(listaAEvaluar);
	}


	private Atom defun(Lista listaAEvaluar){
		/**
		 * validar que hayan 4 elementos en la lista:
		 * defun (ya verificado), nombre de la lista, lista con parametros, operacion parseada
		 */
		if (listaAEvaluar.size()!=4)
			return new Atom();
		else{
			if (listaAEvaluar.getAtomIn(1).EsLista())
				return new Atom();

			if (!listaAEvaluar.getAtomIn(2).EsLista())
				return new Atom();
			
			
		}
		String nombreDeLaFuncion = listaAEvaluar.getAtomIn(1).toString();
		if (!esNombreDeFuncionValida(nombreDeLaFuncion))
			return new Atom();
		
		/**
		 * Mapear la funcion nombreDeLaFuncion
		 * a su lista de parametros, y a su operacion
		 */
		Atom atomDeLaFuncion = new Atom(new Lista(listaAEvaluar.subList(2, 4)));
		this.funcionesDelUsuario.put(nombreDeLaFuncion, new Atom(new Lista(listaAEvaluar.subList(2, 4))));
		
		return new Atom(nombreDeLaFuncion);
	}

	private boolean esNombreDeFuncionValida(String nombreDeLaFuncion){
		
		/**
		 * Ver si es una funcion ya implementada por GtLisp
		 */
		if (Lista.isOperationImplementada(nombreDeLaFuncion))
			return false;
		
		/**
		 * Ver que no empiece con un numero
		 */
		String primerCaracter = Character.toString(nombreDeLaFuncion.charAt(0)); 
		try {
			int posibleNumero = Integer.parseInt(primerCaracter);
			return false;
		} catch(NumberFormatException noEmpiezaConNumero){
			return true;
		}
	}

	private Atom dividir(Lista listaAEvaluar) {
		float division;
		if (listaAEvaluar.getAtomIn(1).esNumero())
			division = listaAEvaluar.getAtomIn(1).getNumero();
		else
			return new Atom();
		
		for (int i=2; i < listaAEvaluar.size() ; i++){
			if (listaAEvaluar.getAtomIn(i).esNumero()){
				//if (!listaAEvaluar.getAtomIn(i).esEntero())
				//	todosSonEnteros = false;
			
				division /= listaAEvaluar.getAtomIn(i).getNumero();
			} else
			    return new Atom();
		}

		return new Atom(division);
	}
	

	private Atom restar(Lista listaAEvaluar){
		float resta;
		if (listaAEvaluar.getAtomIn(1).esNumero())
			resta = listaAEvaluar.getAtomIn(1).getNumero();
		else
			return new Atom();

		boolean todosSonEnteros = true;
		
		for (int i=2; i < listaAEvaluar.size() ; i++){
			if (listaAEvaluar.getAtomIn(i).esNumero()){
				if (!listaAEvaluar.getAtomIn(i).esEntero())
					todosSonEnteros = false;
				
				resta -= listaAEvaluar.getAtomIn(i).getNumero();
			} else
				return new Atom();
		}
		
		if (todosSonEnteros) 
			return new Atom((int) resta);
		else 
			return new Atom(resta);
	}

	private Atom sumar(Lista listaAEvaluar) {
		float suma = 0;
		boolean todosSonEnteros = true;
		
		for (int i=1; i < listaAEvaluar.size() ; i++){
			if (listaAEvaluar.getAtomIn(i).esNumero()){
				if (!listaAEvaluar.getAtomIn(i).esEntero())
					todosSonEnteros = false;
				
				suma += listaAEvaluar.getAtomIn(i).getNumero();
			} else
                return new Atom();
		}
		
		if (todosSonEnteros) 
			return new Atom((int) suma);
		else 
			return new Atom(suma);
	}

	private Atom multiplicar(Lista listaAEvaluar){
		float Multiplicacion = 1;
		boolean todosSonEnteros = true;
		
		for (int i=1; i < listaAEvaluar.size() ; i++){
			if (listaAEvaluar.getAtomIn(i).esNumero()){
				if (!listaAEvaluar.getAtomIn(i).esEntero())
					todosSonEnteros = false;
			
				Multiplicacion *= listaAEvaluar.getAtomIn(i).getNumero();
			} else
                return new Atom();
		}
		
		if (todosSonEnteros)
			return new Atom((int) Multiplicacion);
		else
			return new Atom(Multiplicacion);
	}

	public Atom cons(Lista listaAEvaluar){
		if (listaAEvaluar.size() != 3)
            return new Atom();
		
		Lista listaConstruida = new Lista();
		listaConstruida.insert(listaAEvaluar.getAtomIn(1));
		
		/**
		 * Si el segundo atom es una lista, insertar cada uno de los atoms
		 */
		if (listaAEvaluar.getAtomIn(2).EsLista()){
			for (int i = 0; i < listaAEvaluar.getAtomIn(2).lista.size(); i++){
				if (!listaAEvaluar.getAtomIn(2).lista.getAtomIn(i).esNulo)
					listaConstruida.insert(listaAEvaluar.getAtomIn(2).lista.getAtomIn(i));
			}
		} else
			listaConstruida.insert(listaAEvaluar.getAtomIn(2));
		
		return new Atom(listaConstruida);
	}

	public Atom setq(Lista listaAEvaluar) {
		
		if ((listaAEvaluar.size() != 3))
            return new Atom();

		if (((Atom)listaAEvaluar.get(1)).EsLista())
            return new Atom();
		
		/**
		 * OJO: solo estamos seguros que es un String, pero no sabemos si es un numero
		 * FALTA!!
		 * @author kmels
		 */
		String variableDeAsignacion = ((Atom) listaAEvaluar.get(1)).toString();
		Atom atomAsignado = ((Atom) listaAEvaluar.get(2));
		
		/**
		 * Evaluar el atom asignado en caso de que sea una operacion
		 * o una variable, o una lista con variables..
		 */ 
		atomAsignado = this.evaluar(atomAsignado);

		this.variablesDelUsuario.put(variableDeAsignacion, atomAsignado);
		return atomAsignado;
	}


	public Atom list_length(Lista listaAEvaluar) {
		/**
		 * list-length: devuelve el tamano de una lista
		 * Operandos: una lista
		 * Ejemplo: (lisg-length '(1 2 3)) 
		 */
		
		if (!this.operandoEsLista(listaAEvaluar))
            return new Atom();
		
		Atom listaOperanda = this.evaluar(listaAEvaluar.getAtomIn(1));
		return new Atom(listaOperanda.lista.size());
	}


	public Atom car(Lista listaAEvaluar){
		if (!this.operandoEsLista(listaAEvaluar))
            return new Atom();
		
		Lista listaOperanda = this.evaluar(listaAEvaluar.getAtomIn(1)).lista;
		
		if (listaOperanda.estaVacia())
			return new Atom();
		
		Atom primerAtom = listaOperanda.getAtomIn(0);
		
		if (primerAtom.EsListaConOperacion())
			primerAtom = this.evaluar(primerAtom);
		
		return primerAtom;
	}


	public Atom cdr(Lista listaAEvaluar){
		
		if (!this.operandoEsLista(listaAEvaluar))
            return new Atom();
		
		Lista listaOperanda = this.evaluar(listaAEvaluar.getAtomIn(1)).lista;
		
		if (listaOperanda.size()<2)
			return new Atom();
		
		Lista subLista = new Lista(listaOperanda.subList(1, listaOperanda.size()));
		
		return new Atom(subLista);
	}

	public boolean operandoEsLista(Lista listaAEvaluar){
		if (!listaAEvaluar.isOperation)
			return false;
		
		if (listaAEvaluar.size()>2)
			return false;

		/**
		 * 	Ver si es una variable 
		 */
		if (this.variablesDelUsuario.containsKey(listaAEvaluar.getAtomIn(1).toString()))
			return true;
			
		if (!listaAEvaluar.getAtomIn(1).EsLista())
			return false;
		
		return listaAEvaluar.isOperation;
	}
	
	

	public int obtenerIndiceDelParentesisQueCierraAlPrimeroEn(String expresion){
		expresion = expresion.trim();
		
		if (!((new Atom(expresion).startsWith("'("))  ||  (new Atom(expresion).startsWith("("))))
			return 0;


		int indice = expresion.indexOf('(')+1;
		int numeroDeParentesisAbiertosPorCerrar = 1;
		
		while (indice < expresion.length()){
			if (expresion.charAt(indice)=='('){
				numeroDeParentesisAbiertosPorCerrar++;
			} else if (expresion.charAt(indice)==')'){
				numeroDeParentesisAbiertosPorCerrar--;
				if (numeroDeParentesisAbiertosPorCerrar==0)
					return indice;
			}
			indice ++;
		}

		return 0;
	}
}
