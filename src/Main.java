/**
 * Proyecto Lisp, Main
 * @author Isabel Ortiz Naranjo 18176
 * @author Diego Estrada 18540
 * @author Michael Chan 18562
 */
public class Main {

	static Interpreter interpreter;

	/**
	 * Main del proyecto
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Se crea el interprete
		interpreter = new Interpreter();
		// Constructor
		Prompt prompt = new Prompt();
		boolean haSalido = false;
		while (!haSalido){
			prompt.Escuchar(interpreter.variablesDelUsuario);

			if (prompt.getUltimaExpresion().trim().compareTo("(exit)")==0){
				haSalido = true;
				return;
			}
			
			String ultimaExpresion = prompt.getUltimaExpresion().trim();
					
			try {
			} finally{

				try {
					Atomo atomoAEvaluar = interpreter.parsearExpresion(ultimaExpresion, false, false);
					System.out.println(interpreter.evaluar(atomoAEvaluar).toString());
				} finally {

                }
			}
		}
	}

}
