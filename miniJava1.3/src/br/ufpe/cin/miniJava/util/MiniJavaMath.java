package br.ufpe.cin.miniJava.util;

/**
 * A classe <code>MiniJavaMath</code> cont�m m�todos que auxiliar�o o usu�rio
 * no c�lculo de opera��es matem�ticas, como valor absoluto, seno, cosseno,
 * potencia��o, raiz quadrada, etc. Por se tratar de uma classe <code>final</code>,
 * n�o poder� ser instanciada, para chamar seus m�todos, utilize
 * <i>MiniJavaMath.nome_do_metodo()</i> diretamente.
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.2
 * @since 1.1
 */
public final class MiniJavaMath {

	/**
	 * Implementa��o vazia do construtor de MiniJavaMath, uma vez que
	 * n�o � necess�rio e nem permitido construir objetos desta classe.
	 */
	private MiniJavaMath(){}
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
	/**
	 * O m�todo <code>sqrt</code> retorna um <code>double</code> com
	 * a raiz quadrada positiva de um valor passado como par�metro
	 * (tamb�m um <code>double</code>). Caso o valor passado como par�metro
	 * seja menor ou igual a zero, o m�todo n�o retorna um <code>double </code> v�lido.
	 * 
	 * @param  value  um valor em <code>double</code>.
	 * @return um <code>double</code> com a raiz quadrada positiva do n�mero
	 * passado como par�metro.
	 */
	public static double sqrt(double value){
		return java.lang.Math.sqrt(value);
	}
	/**
	 * O m�todo <code>pow</code> calcula a pot�ncia de um n�mero (a base), 
	 * elevado a alguma pot�ncia (o expoente), e retorna este c�lculo
	 * armazenado num <code>int</code>. O expoente dever� ser positivo,
	 * e caso ele n�o seja, o m�todo n�o retornar� um <code>int </code> v�lido. 
	 * 
	 * @param  base  um valor em <code>int</code>.
	 * @param  expoente  um valor em <code>int</code>. 
	 * @return um <code>int</code> com o valor de <i>base</i> elevado a <code>expoente</code>.
	 */
	public static int pow(int base, int expoente){
		return (int) java.lang.Math.pow(base, expoente);
	}	
	

}