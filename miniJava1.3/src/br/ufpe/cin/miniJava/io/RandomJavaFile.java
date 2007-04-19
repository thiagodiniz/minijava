package br.ufpe.cin.miniJava.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * A classe <code>RandomJavaFile</code> permite que se escreva e leia ao mesmo tempo
 * de um �nico arquivo, tamb�m permite com que se "mova" um ponteiro pelo arquivo
 * indicando em que posi��o encontra-se a leitura/escrita atual. Este arquivo
 * comporta-se como um grande array de bytes armazenado no sistema de arquivos, e a
 * esta classe prov� m�todos para manipular este arquivo de v�rias formas.
 *  
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.3
 * @since 1.3
 */
public class RandomJavaFile{
	
	private RandomAccessFile raf;
	/**
	 * Cria um novo <code>RandomJavaFile</code>, que representar� um arquivo existente,
	 * que ter� seu caminho indicado pela String <code>endereco</code>, e seu tipo de 
	 * acesso atrav�s da String <code>tipoAcesso</code>, podendo ser leitura ou leitura/grava��o. 
	 * 
	 * @param endereco Caminho completo do arquivo existente no sistema de arquivos, de onde ser� feito leitura e/ou escrita de dados.
	 * @param tipoAcesso String que indicar� o tipo de acesso ao arquivo, podendo ser:
	 * <ul> <li><b>r</b> - somente leitura</li><li><b>rw</b> - leitura e escrita</li>
	 * </ul>
	 * @throws FileNotFoundException caso o arquivo n�o for encontrado no sistema de arquivos.
	 * @throws IllegalArgumentException caso o tipo de acesso n�o for uma String v�lida (ou <b>r</b> ou <b>rw</b>);
	 */
	public RandomJavaFile(String endereco, String tipoAcesso) throws FileNotFoundException, IllegalArgumentException {
		this.raf = new RandomAccessFile(endereco, tipoAcesso);
	}
	/**
	 * Fecha os arquivo e libera todos os recursos criados pelo
	 * sistema operional associados a ele.
	 * 
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public void close() throws IOException {
		raf.close();
	}

	/**
	 * Retorna o tamanho em bytes do arquivo representado por esta classe.
	 * 
	 * @return um <code>long</code> com o tamanho em bytes deste arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public long length() throws IOException {
		return raf.length();
	}
	/**
	 * L� deste arquivo a quantidade de bytes que couberem no array de bytes passado
	 * como par�metro, e armazena neste array. 
	 * 
	 * @param byteArray o array de bytes que receber� os bytes lidos do arquivo.
	 * @return a quantidade de bytes que foram lidos do arquivo (nem sempre ser� do tamanho do array,
	 * por exemplo, quando j� se estiver pr�ximo do fim do arquivo).
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public int read(byte[] byteArray) throws IOException {
		return raf.read(byteArray);
	}

	/**
	 * L� um boolean deste arquivo.
	 * 
	 * @return o boolean lido do arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public boolean readBoolean() throws IOException {
		return raf.readBoolean();
	}

	/**
	 * L� um byte deste arquivo.
	 * 
	 * @return o byte lido do arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public byte readByte() throws IOException {
		return raf.readByte();
	}
	/**
	 * L� um char deste arquivo.
	 * 
	 * @return o char lido do arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public char readChar() throws IOException {
		return raf.readChar();
	}
	
	/**
	 * L� um double deste arquivo.
	 * 
	 * @return o double lido do arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public double readDouble() throws IOException {
		return raf.readDouble();
	}

	/**
	 * L� um int deste arquivo.
	 * 
	 * @return o int lido do arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public int readInt() throws IOException {
		return raf.readInt();
	}

	/**
	 * L� toda uma linha do arquivo, iniciando-se da posi��o atual (onde o ponteiro
	 * do arquivo est� apontando agora), e vai at� encontrar um caractere que indique
	 * quebra de linha.
	 * 
	 * @return uma <code>String</code> com a linha lida do arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public String readLine() throws IOException {
		return raf.readLine();
	}

	/**
	 * L� uma String do arquivo.
	 * Observe que primeiro � lido um int que indicar� o tamanho da String,
	 * depois s�o lidos a quantidade de bytes correspondentes ao tamanho da String.
	 * 
	 * @return a String lida do arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public String readString() throws IOException {		
		byte[] string = new byte[raf.readInt()];
		raf.read(string);
		return new String(string);
	}

	/**
	 * Altera a posi��o do ponteiro do arquivo, ou seja, comparando o arquivo
	 * com um array gigante de bytes, altera a vari�vel que percorre este grande array.
	 * 
	 * @param posicao a nova posi��o desejada para o ponteiro do arquivo.
	 * @throws IOException caso posicao seja menor que zero, ou aconte�a algum erro de IO.
	 */
	public void seek(long posicao) throws IOException {
		raf.seek(posicao);
	}
	/**
	 * Pula a quantidade de bytes indicada, ou seja, soma o valor passado por par�metro
	 * ao ponteiro do arquivo.
	 * 
	 * @param distancia a quantidade que ser� somada ao ponteiro atual do arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public int skipBytes(int distancia) throws IOException {
		return raf.skipBytes(distancia);
	}
	/**
	 * Escreve um boolean no arquivo.
	 * 
	 * @param dado boolean a ser escrito no arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */	
	public void writeBoolean(boolean dado) throws IOException {
		raf.writeBoolean(dado);
	}
	/**
	 * Escreve uma <code>String</code> no arquivo.
	 * Para tal, primeiro � escrito um <code>int</code> com o tamanho da String,
	 * logo em seguida s�o escritos os bytes desta String.
	 * 
	 * @param dados String a ser escrita no arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public void writeString(String dados) throws IOException {
		raf.writeInt(dados.length());
		raf.writeBytes(dados);
	}
	/**
	 * Escreve um char no arquivo.
	 * 
	 * @param dado char a ser escrito no arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public void writeChar(int dado) throws IOException {
		raf.writeChar(dado);
	}
	/**
	 * Escreve um double no arquivo.
	 * 
	 * @param dado double a ser escrito no arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public void writeDouble(double dado) throws IOException {
		raf.writeDouble(dado);
	}
	/**
	 * Escreve um int no arquivo.
	 * 
	 * @param dado int a ser escrito no arquivo.
	 * @throws IOException caso aconte�a algum erro de IO.
	 */
	public void writeInt(int dado) throws IOException {
		raf.writeInt(dado);
	}

}
