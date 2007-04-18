package br.ufpe.cin.miniJava.util;

/**
 * A classe <code>Mathematics</code> cont�m m�todos que auxiliar�o o usu�rio
 * no c�lculo de opera��es matem�ticas, como valor absoluto, seno, cosseno,
 * potencia��o, raiz quadrada, etc. Por se tratar de uma classe <code>final</code>,
 * n�o poder� ser instanciada, para chamar seus m�todos, utilize
 * <i>Mathematics.nome_do_metodo()</i> diretamente.
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