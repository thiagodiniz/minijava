package br.ufpe.cin.miniJava.exception;
/**
 * Esta classe representa uma exce��o gerada quando n�o se tem sucesso a
 * fazer uma convers�o de tipos em miniJava, por exemplo, quando tenta-se
 * converter de <code>String</code> para <code>int</code> ou <code>double</code>.
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.2
 * @since 1.1
 */
public class InvalidConversionException extends Exception {

	private static final long serialVersionUID = 1L;
	/**
	 * Cria uma nova exce��o do tipo <code>InvalidConversionException</code>
	 * sem mensagem de detalhamento de sua causa.
	 */
	public InvalidConversionException() {
		super();
	}
	/**
	 * Cria uma nova exce��o do tipo <code>InvalidConversionException</code>
	 * com uma mensagem de detalhamento de sua causa, que dever� ser passada
	 * por par�metro como uma <code>String</code>.
	 * 
	 * @param message <code>String</code> com uma mensagem indicando o motivo
	 * que gerou esta exce��o.
	 */
	public InvalidConversionException(String message) {
		super(message);
	}

}
