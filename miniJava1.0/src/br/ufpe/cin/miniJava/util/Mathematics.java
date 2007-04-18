/**
 *
 */
package br.ufpe.cin.miniJava.util;

/**
 * A classe Mathematics cont�m Esta classe cont�m opera��es .
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.1
 * @since 1.1
 */
public final class Mathematics {

	/**
	 * Implementa��o vazia do construtor de Mathematics, uma vez que
	 * n�o � necess�rio e nem permitido construir objetos desta classe.
	 */
	private Mathematics(){}
	/**
	 * O m�todo <code>abs</code> retorna o valor absoluto do <code>double</code>
	 * passado como par�metro.
	 * 
	 * @param  value  o <code>double</code> cujo valor absoluto ser� informado.
	 * @return <code>double</code> com o valor absoluto do argumento.
	 */
	public static double abs(double value){
		return java.lang.Math.abs(value);
	}
	/**
	 * O m�todo <code>abs</code> retorna o valor absoluto do <code>int</code>
	 * passado como par�metro.
	 * 
	 * @param  value  o <code>int</code> cujo valor absoluto ser� informado.
	 * @return <code>int</code> com o valor absoluto do argumento.
	 */
	public static int abs(int value){
		return java.lang.Math.abs(value);
	}

}