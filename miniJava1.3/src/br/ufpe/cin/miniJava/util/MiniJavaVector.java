package br.ufpe.cin.miniJava.util;

import java.util.Vector;

/**
 * A classe <code>MiniJavaVector</code> cont�m m�todos que auxiliar�o o usu�rio
 * na manipula��o de conjunto de dados, como inserir, remover, etc. Observe que
 * ela funciona como um array "auto-dimension�vel", podendo ter seus elementos acessados
 * atrav�s de um �ndice, mas n�o necessitando que sejam
 * implementadas rotinas de duplica��o de tamanho, por exemplo.
 * 
 * Esta classe utiliza <a href="http://en.wikipedia.org/wiki/Generic_programming">Generics</a>,
 * ou seja, voc� poder� definir com qual tipo espec�fico de objetos ela ir� trabalhar. 
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.2.1
 * @since 1.2
 */
public class MiniJavaVector<T> {
	
	private Vector<T> dentro;

	/**
	 * Cria um novo vetor vazio com a capacidade inicial
	 * desejada.
	 * 
	 * @param tam <code>int</code> contendo o tamanho do novo vetor.
	 * @see MiniJavaVector#MiniJavaVector()
	 */
	public MiniJavaVector(int tam) {
		this.dentro = new Vector<T>(tam);
	}

	/**
	 * Cria um novo vetor vazio com a capacidade inicial
	 * padr�o (capacidade para 10 objetos).
	 * 
	 * Como esta � uma classe gen�rica, pode-se indicar
	 * com qual tipo de objeto uma inst�ncia desta
	 * classe dever� trabalhar, atrav�s da seguinte forma:
	 * <blockquote>
	 * <pre>
	 * MiniJavaVector&lt;tipo_do_objeto_desejado&gt; vetor = new MiniJavaVector &lt;tipo_do_objeto_desejado&gt;();
	 * </pre>
	 * </blockquote>
	 * Dessa forma, os m�todos de MiniJavaVector receber�o apenas
	 * objetos do tipo indicado. 
	 * <br>
	 * Caso n�o seja necess�rio indicar o tipo do objeto, entende-se
	 * que poder� ser qualquer objeto inserido neste vetor.
	 */
	public MiniJavaVector() {
		this(10);
	}
	
	
	
	/**
	 * Insere um objeto neste vetor, na posi��o indicada como par�metro.
	 * Se j� houver um objeto nesta posi��o, ele ser� sobrescrito.
	 * 
	 * @param indice um <code>int</code> com a posi��o que o novo objeto ocupar�
	 * no vetor. Este valor deve estar entre 0 e tamanho do vetor menos um elemento,
	 * sen�o levantar� uma exce��o. 
	 * @param object o objeto que ser� adicionado na posi��o indicada.
	 */
	public void add(int indice, T object) {
		dentro.add(indice, object);
	}

	/**
	 * Insere um objeto neste vetor (colocando-o na pr�xima posi��o vaga).
	 * 
	 * @param object objeto a ser inserido no vetor.
	 */
	public void add(T object) {
		dentro.add(object);
	}

	/**
	 * Adiciona todos os objetos do vetor passado como par�metro neste
	 * vetor (come�ando da pr�xima posi��o vaga deste vetor).
	 * 
	 * @param vector um outro vetor, que ser� copiado por completo (todos os
	 * objetos dele) dentro do vetor que chamar este m�todo.
	 */
	public void addAll(MiniJavaVector<T> vector) {
		dentro.addAll(vector.dentro);
	}

	/**
	 * Adiciona todos os objetos do vetor passado como par�metro neste 
	 * vetor, come�ando a partir do indice indicado. 
	 * 
	 * @param indice um <code>int</code> que indicar� a partir de qual
	 * posi��o ir� se iniciar a c�pia do vetor.
	 * @param vector um outro vetor, que ser� copiado por completo (todos os
	 * objetos dele) dentro do vetor que chamar este m�todo.
	 */
	public void addAll(int indice, MiniJavaVector<T> vector) {
		dentro.addAll(indice, vector.dentro);
	}

	/**
	 *  Apaga todos os objetos contidos neste vetor.
	 */
	public void clear() {
		dentro.clear();
	}

	/**
	 * Verifica se este vetor cont�m todos os elementos do vetor
	 * passado como par�metro. Em outras palavras, verifica se
	 * o outro vetor � "sub-conjunto" do outro.
	 * 
	 * @param vector o vetor que ser� comparado com este vetor.
	 * @return <code>true</code> se o vetor passado como par�metro �
	 * "sub-conjunto" deste vetor (incluindo o caso de serem iguais) e
	 * <code>false</code> caso contr�rio.
	 */
	public boolean containsAll(MiniJavaVector<T> vector) {
		return dentro.containsAll(vector.dentro);
	}

	/**
	 * Retorna o objeto localizado na posi��o indicada.
	 * A fins de compara��o entre arrays:
	 * <blockquote>
     * <pre>
     * get(i) = array[i]</pre></blockquote>
	 *  
	 * @param indice posi��o na qual o objeto que se deseja acessar encontra-se.
	 * @return o objeto localizado na posi��o passada como par�metro.
	 */
	public T get(int indice) {
		return dentro.get(indice);
	}

	/**
	 * M�todo que indica se o vetor est� vazio (sem nenhum objeto inserido nele).
	 * @return <code>true</code> se ele n�o tiver elementos,
	 * <code>false</code> caso contr�rio.
	 */
	public boolean isEmpty() {
		return dentro.isEmpty();
	}

	/**
	 * Remove o objeto localizado na posi��o indicada, retornando-o ap�s
	 * sua remo��o. Esta remo��o far� com que todos os elementos posteriores
	 * ao que foi removido tenham sua posi��o deslocada para uma posi��o a
	 * menos da anterior.
	 * 
	 * @param indice posi��o onde o objeto que ser� removido se encontra.
	 * @return o objeto que acabou de ser removido, caso ele tenha sido
	 * removido efetivamente, ou <code>null</code>, caso n�o tenha sido
	 * removido (provavelmente por n�o ter sido encontrado).
	 */
	public T remove(int indice) {
		return dentro.remove(indice);
	}

	/**
	 * Retorna o n�mero de objetos contidos deste vetor.
	 * 
	 * @return um <code>int</code> com o n�mero de objetos contidos neste vetor.
	 */
	public int size() {
		return dentro.size();
	}
	
	/**
	 * M�todo que indica se dois vetores s�o iguais.
	 * Dois vetores s�o iguais se e somente se eles possuirem os mesmos elementos,
	 * e na mesma ordem, al�m da mesma quantidade de elementos.
	 * @param obj um vetor que ser� comparado com este vetor.
	 * @return <code>true</code> se os vetores forem iguais, <code>false</code>
	 * caso contr�rio. 
	 */
	public boolean equals(Object obj) {
		if (obj instanceof MiniJavaVector) {
			return dentro.equals(((MiniJavaVector) obj).dentro);
		}
		return super.equals(obj);
	}

}
