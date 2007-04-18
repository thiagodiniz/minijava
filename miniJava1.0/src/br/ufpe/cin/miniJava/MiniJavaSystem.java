package br.ufpe.cin.miniJava;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Serializable;

/**
 * Classe que representa os dispositivos padr�es de entrada (teclado) e sa�da
 * (janela onde o programa est� sendo executado) de dados de um computador.
 *
 * @author   Ives Jos� de Albuquerque Mac�do J�nior (ijamj@cin.ufpe.br)
 *
 * @since JDK 1.1.x
 *
 * @version 1.2.3
 */
public class MiniJavaSystem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A stream de entrada padr�o
	 */
	private static InputStream in = System.in; // Esta linha foi alterada para evitar a sobrecarga

	// do sistema com v�rias Streams de Entrada

	/**
	 * A stream de sa�da padr�o
	 */
	private static PrintStream out = System.out; // Esta linha foi alterada para evitar a sobrecarga

	// do sistema com v�rias Streams de Entrada

	/**
	 * A stream de erros padr�o
	 */
	private static PrintStream err = System.err; // Esta linha foi alterada para evitar a sobrecarga

	// do sistema com v�rias Streams de Entrada

	/**
	 * A stream de entrada que converte os bytes em chars
	 */
	private static InputStreamReader isr = new InputStreamReader(MiniJavaSystem.in); // Esta linha foi alterada para evitar a sobrecarga

	// do sistema com v�rias Streams de Entrada

	/**
	 * O buffer que armazena os dados vindos da stream de entrada
	 */
	private static BufferedReader br = new BufferedReader(MiniJavaSystem.isr); // Esta linha foi alterada para evitar a sobrecarga

	// do sistema com v�rias Streams de Entrada

	/**
	 * O construtor default da Classe System
	 */
	public MiniJavaSystem() {
	}

	/*
	 * Os m�todos de leitura foram modificados para synchronized para criar
	 * regi�es de exclus�o m�tua que evitam que um m�todo de leitura se
	 * superponha a outro ( chamado ou n�o no mesmo objeto que executa aquele
	 * comando ) causando erros durante a leitura no Buffer da Classe System.
	 */

	/**
	 * M�todo que espera que o usu�rio digite uma String e
	 * aperte "Enter", devolvendo a String digitada como resultado
	 *
	 * @return    A String digitada
	 */
	public synchronized String readString() {
		String ret = "";

		try {

			while (!MiniJavaSystem.br.ready()) {
			} // esta linha de c�digo foi acrescentada para dar mais seguran�a
			// contra erros de Estrada/Sa�da durante a leitura de uma stream
			ret = MiniJavaSystem.br.readLine();
		} catch (java.io.IOException e) {
			MiniJavaSystem.err.println("Ocorreu um erro de Entrada/Saida !!!");
			e.printStackTrace();
		}

		if (ret == null) { // este bloco foi acrescentado para evitar
			ret = ""; // que seja retornada uma String nula
		}

		return ret;
	}

	/**
	 * M�todo que espera que o usu�rio digite um boolean e
	 * aperte "Enter", devolvendo true se ele for digitado
	 * e false se qualquer outra coisa seja digitada
	 *
	 * @return    Um valor booleano
	 */
	public synchronized boolean readBoolean() {
		boolean ret = false;
		String truthstr = "false";
		truthstr = this.readString();
		Boolean truthbln = Boolean.FALSE;
		truthbln = Boolean.valueOf(truthstr);
		ret = truthbln.booleanValue();
		return ret;
	}

	/**
	 * M�todo que espera que o usu�rio digite um caracter e
	 * aperte "Enter", devolvendo o caracter digitado. Caso
	 * o usu�rio digite mais de um caracter, o primeiro ser�
	 * lido e os demais ser�o descartados do sistema
	 *
	 * @return    O caracter digitado
	 */
	public synchronized char readChar() { // este m�todo foi alterado para ficar mais robusto
		char ret = (char) 0x0000; // a erros de entrada e sa�da e mais eficiente
		String line = this.readString();

		if (line.length() > 0) { // este bloco foi alterado para evitar
			ret = line.charAt(0); // erros quando a String lida for vazia
		} else {
			ret = '\n';
		}

		return ret;
	}

	/**
	 * M�todo que espera que o usu�rio digite uma String e aperte "Enter",
	 * devolvendo um array com os caracteres digitados como resultado
	 *
	 * @return    A String digitada como array de caracteres
	 */
	public synchronized char[] readCharArray() {
		char[] ret = { (char) 0x0000 };
		String string = this.readString();
		ret = string.toCharArray();
		return ret;
	}

	/**
	 * M�todo que espera que o usu�rio digite um byte e
	 * aperte "Enter", devolvendo o byte digitado,
	 * independentemente de ter sido digitado como:<br>
	 *
	 * decimal;<br>
	 * octal: come�ando com um 0 (zero)<br>
	 * hexadecimal: come�ando com um 0x ou um #<br>
	 *
	 * @return    O byte digitado
	 */
	public synchronized byte readByte() {
		byte ret = 0;
		String bytestr = this.readString();
		bytestr = bytestr.trim(); // esta linha foi acrescentada para que n�o ocorram problemas na
		// leitura de um byte que tem espa�os ou tabula��es em torno de si
		try {
			Byte byteobj = Byte.decode(bytestr);
			ret = byteobj.byteValue();
		} catch (java.lang.NumberFormatException e) {
			MiniJavaSystem.err.println("O valor digitado naum "
					+ "corresponde a um byte valido !!!");
			MiniJavaSystem.err.println("O menor byte valido eh: " + Byte.MIN_VALUE);
			MiniJavaSystem.err.println("O maior byte valido eh: " + Byte.MAX_VALUE);
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * M�todo que espera que o usu�rio digite um short e
	 * aperte "Enter", devolvendo o short digitado,
	 * independentemente de ter sido digitado como:<br>
	 *
	 * decimal;<br>
	 * octal: come�ando com um 0 (zero)<br>
	 * hexadecimal: come�ando com um 0x ou um #<br>
	 *
	 * @return    O short digitado
	 */
	public synchronized short readShort() {
		short ret = 0;
		String shortstr = this.readString();
		shortstr = shortstr.trim(); // esta linha foi acrescentada para que n�o ocorram problemas na
		// leitura de um short que tem espa�os ou tabula��es em torno de si
		try {
			Short shortobj = Short.decode(shortstr);
			ret = shortobj.shortValue();
		} catch (java.lang.NumberFormatException e) {
			MiniJavaSystem.err.println("O valor digitado naum "
					+ "corresponde a um short valido !!!");
			MiniJavaSystem.err.println("O menor short valido eh: " + Short.MIN_VALUE);
			MiniJavaSystem.err.println("O maior short valido eh: " + Short.MAX_VALUE);
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * M�todo que espera que o usu�rio digite um int e
	 * aperte "Enter", devolvendo o int digitado,
	 * independentemente de ter sido digitado como:<br>
	 *
	 * decimal;<br>
	 * octal: come�ando com um 0 (zero)<br>
	 * hexadecimal: come�ando com um 0x ou um #<br>
	 *
	 * @return    O int digitado
	 */
	public synchronized int readInt() {
		int ret = 0;
		String intstr = this.readString();
		intstr = intstr.trim(); // esta linha foi acrescentada para que n�o ocorram problemas na
		// leitura de um int que tem espa�os ou tabula��es em torno de si
		try {
			Integer intobj = Integer.decode(intstr);
			ret = intobj.intValue();
		} catch (java.lang.NumberFormatException e) {
			MiniJavaSystem.err.println("O valor digitado naum "
					+ "corresponde a um int valido !!!");
			MiniJavaSystem.err.println("O menor int valido eh: " + Integer.MIN_VALUE);
			MiniJavaSystem.err.println("O maior int valido eh: " + Integer.MAX_VALUE);
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * M�todo que espera que o usu�rio digite um long e
	 * aperte "Enter", devolvendo o long digitado,
	 * independentemente de ter sido digitado como:<br>
	 *
	 * decimal;<br>
	 * octal: come�ando com um 0 (zero)<br>
	 * hexadecimal: come�ando com um 0x ou um #<br>
	 *
	 * @return    O long digitado
	 */
	public synchronized long readLong() {
		long ret = 0;
		String longstr = this.readString();
		longstr = longstr.trim(); // esta linha foi acrescentada para que n�o ocorram problemas na
		// leitura de um long que tem espa�os ou tabula��es em torno de si
		try { // este bloco foi alterado para que possa rodar em compiladores mais antigos (JDK 1.1.x)
			int radix = 10;
			String longstrLC = longstr.toLowerCase();

			if (longstrLC.startsWith("0x") || longstrLC.startsWith("-0x")) {
				radix = 16;
			} else if (longstrLC.startsWith("0") || longstrLC.startsWith("-0")) {
				radix = 8;
			}

			ret = Long.parseLong(longstr, radix);
		} catch (java.lang.NumberFormatException e) {
			MiniJavaSystem.err.println("O valor digitado naum "
					+ "corresponde a um long valido !!!");
			MiniJavaSystem.err.println("O menor long valido eh: " + Long.MIN_VALUE);
			MiniJavaSystem.err.println("O maior long valido eh: " + Long.MAX_VALUE);
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * M�todo que espera que o usu�rio digite um float
	 * e aperte "Enter", devolvendo o float digitado
	 *
	 * @return    O byte digitado
	 */
	public synchronized float readFloat() {
		float ret = 0.0f;
		String floatstr = this.readString();
		floatstr = floatstr.trim(); // esta linha foi acrescentada para que n�o ocorram problemas na
		// leitura de um float que tem espa�os ou tabula��es em torno de si
		try {
			Float floatobj = Float.valueOf(floatstr);
			ret = floatobj.floatValue();
		} catch (java.lang.NumberFormatException e) {
			MiniJavaSystem.err.println("O valor digitado naum "
					+ "corresponde a um float valido !!!");
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * M�todo que espera que o usu�rio digite um double
	 * e aperte "Enter", devolvendo o double digitado
	 *
	 * @return    O byte digitado
	 */
	public synchronized double readDouble() {
		double ret = 0.0;
		String doublestr = this.readString();
		doublestr = doublestr.trim(); // esta linha foi acrescentada para que n�o ocorram problemas na
		// leitura de um double que tem espa�os ou tabula��es em torno de si
		try {
			Double doubleobj = Double.valueOf(doublestr);
			ret = doubleobj.doubleValue();
		} catch (java.lang.NumberFormatException e) {
			MiniJavaSystem.err.println("O valor digitado naum "
					+ "corresponde a um double valido !!!");
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * M�todo que imprime uma linha em branco na
	 * janela onde o programa est� sendo executado
	 */
	public void println() {
		MiniJavaSystem.out.println();
	}

	/**
	 * M�todo que imprime um objeto na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    obj O objeto a ser impresso na tela
	 */
	public void print(Object obj) {

		if (obj != null) {
			MiniJavaSystem.out.print(obj);
		} else {
			MiniJavaSystem.err.println("Voce acaba de inserir uma referencia"
					+ " nula no metodo print(Object obj)"
					+ " da classe System !!!");
		}

	}

	/**
	 * M�todo que imprime um objeto na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    obj O objeto a ser impresso na tela
	 */
	public void println(Object obj) {

		if (obj != null) {
			MiniJavaSystem.out.println(obj);
		} else {
			MiniJavaSystem.err.println("Voce acaba de inserir uma referencia"
					+ " nula no metodo println(Object obj)"
					+ " da classe System !!!");
		}

	}

	/**
	 * M�todo que imprime uma String na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    str A String a ser impressa na tela
	 */
	public void print(String str) {

		if (str != null) {
			MiniJavaSystem.out.print(str);
		} else {
			MiniJavaSystem.err.println("Voce acaba de inserir uma referencia"
					+ " nula no metodo print(String str)"
					+ " da classe System !!!");
		}

	}

	/**
	 * M�todo que imprime uma String na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    str A String a ser impressa na tela
	 */
	public void println(String str) {

		if (str != null) {
			MiniJavaSystem.out.println(str);
		} else {
			MiniJavaSystem.err.println("Voce acaba de inserir uma referencia"
					+ " nula no metodo println(String str)"
					+ " da classe System !!!");
		}

	}

	/**
	 * M�todo que imprime um boolean na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    bln O boolean a ser impresso na tela
	 */
	public void print(boolean bln) {
		MiniJavaSystem.out.print(bln);
	}

	/**
	 * M�todo que imprime um boolean na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    bln O boolean a ser impresso na tela
	 */
	public void println(boolean bln) {
		MiniJavaSystem.out.println(bln);
	}

	/**
	 * M�todo que imprime um char na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    chr O char a ser impresso na tela
	 */
	public void print(char chr) {
		MiniJavaSystem.out.print(chr);
	}

	/**
	 * M�todo que imprime um char na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    chr O char a ser impresso na tela
	 */
	public void println(char chr) {
		MiniJavaSystem.out.println(chr);
	}

	/**
	 * M�todo que imprime um array de char na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    chrs O array de char a ser impresso na tela
	 */
	public void print(char[] chrs) {
		MiniJavaSystem.out.print(chrs);
	}

	/**
	 * M�todo que imprime um array de char na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    chrs o array de char a ser impresso na tela
	 */
	public void println(char[] chrs) {
		MiniJavaSystem.out.println(chrs);
	}

	/**
	 * M�todo que imprime um byte na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    bits O byte a ser impresso na tela
	 */
	public void print(byte bits) {
		MiniJavaSystem.out.print(bits);
	}

	/**
	 * M�todo que imprime um byte na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    bits O byte a ser impresso na tela
	 */
	public void println(byte bits) {
		MiniJavaSystem.out.println(bits);
	}

	/**
	 * M�todo que imprime um byte na janela
	 * onde o programa est� sendo executado,
	 * na base especificada
	 *
	 * Obs.: Se a base estiver fora do intervalo
	 * [Character.MIN_RADIX, Character.MAX_RADIX],
	 * a base adotada ser� 10.
	 *
	 * @param    bits O byte a ser impresso na tela
	 * @param    base A base na qual deve ser impresso o n�mero
	 */
	public void print(byte bits, int base) {
		String byteWithRadix = Integer.toString((int) bits, base);
		MiniJavaSystem.out.print(byteWithRadix);
	}

	/**
	 * M�todo que imprime um byte na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha,
	 * na base especificada
	 *
	 * Obs.: Se a base estiver fora do intervalo
	 * [Character.MIN_RADIX, Character.MAX_RADIX],
	 * a base adotada ser� 10.
	 *
	 * @param    bits O byte a ser impresso na tela
	 * @param    base A base na qual deve ser impresso o n�mero
	 */
	public void println(byte bits, int base) {
		String byteWithRadix = Integer.toString((int) bits, base);
		MiniJavaSystem.out.println(byteWithRadix);
	}

	/**
	 * M�todo que imprime um short na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    sht O short a ser impresso na tela
	 */
	public void print(short sht) {
		MiniJavaSystem.out.print(sht);
	}

	/**
	 * M�todo que imprime um short na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    sht O short a ser impresso na tela
	 */
	public void println(short sht) {
		MiniJavaSystem.out.println(sht);
	}

	/**
	 * M�todo que imprime um short na janela
	 * onde o programa est� sendo executado,
	 * na base especificada
	 *
	 * Obs.: Se a base estiver fora do intervalo
	 * [Character.MIN_RADIX, Character.MAX_RADIX],
	 * a base adotada ser� 10.
	 *
	 * @param    sht O short a ser impresso na tela
	 * @param    base A base na qual deve ser impresso o n�mero
	 */
	public void print(short sht, int base) {
		String shortWithRadix = Integer.toString((int) sht, base);
		MiniJavaSystem.out.print(shortWithRadix);
	}

	/**
	 * M�todo que imprime um short na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha,
	 * na base especificada
	 *
	 * Obs.: Se a base estiver fora do intervalo
	 * [Character.MIN_RADIX, Character.MAX_RADIX],
	 * a base adotada ser� 10.
	 *
	 * @param    sht O short a ser impresso na tela
	 * @param    base A base na qual deve ser impresso o n�mero
	 */
	public void println(short sht, int base) {
		String shortWithRadix = Integer.toString((int) sht, base);
		MiniJavaSystem.out.println(shortWithRadix);
	}

	/**
	 * M�todo que imprime um int na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    integer O int a ser impresso na tela
	 */
	public void print(int integer) {
		MiniJavaSystem.out.print(integer);
	}

	/**
	 * M�todo que imprime um int na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    integer O int a ser impresso na tela
	 */
	public void println(int integer) {
		MiniJavaSystem.out.println(integer);
	}

	/**
	 * M�todo que imprime um int na janela
	 * onde o programa est� sendo executado,
	 * na base especificada
	 *
	 * Obs.: Se a base estiver fora do intervalo
	 * [Character.MIN_RADIX, Character.MAX_RADIX],
	 * a base adotada ser� 10.
	 *
	 * @param    integer O int a ser impresso na tela
	 * @param    base A base na qual deve ser impresso o n�mero
	 */
	public void print(int integer, int base) {
		String intWithRadix = Integer.toString(integer, base);
		MiniJavaSystem.out.print(intWithRadix);
	}

	/**
	 * M�todo que imprime um int na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha,
	 * na base especificada
	 *
	 * Obs.: Se a base estiver fora do intervalo
	 * [Character.MIN_RADIX, Character.MAX_RADIX],
	 * a base adotada ser� 10.
	 *
	 * @param    integer O int a ser impresso na tela
	 * @param    base A base na qual deve ser impresso o n�mero
	 */
	public void println(int integer, int base) {
		String intWithRadix = Integer.toString((int) integer, base);
		MiniJavaSystem.out.println(intWithRadix);
	}

	/**
	 * M�todo que imprime um long na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    lng O long a ser impressa na tela
	 */
	public void print(long lng) {
		MiniJavaSystem.out.print(lng);
	}

	/**
	 * M�todo que imprime um long na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    lng O long a ser impressa na tela
	 */
	public void println(long lng) {
		MiniJavaSystem.out.println(lng);
	}

	/**
	 * M�todo que imprime um long na janela
	 * onde o programa est� sendo executado,
	 * na base especificada
	 *
	 * Obs.: Se a base estiver fora do intervalo
	 * [Character.MIN_RADIX, Character.MAX_RADIX],
	 * a base adotada ser� 10.
	 *
	 * @param    lng O long a ser impresso na tela
	 * @param    base A base na qual deve ser impresso o n�mero
	 */
	public void print(long lng, int base) {
		String longWithRadix = Long.toString(lng, base);
		MiniJavaSystem.out.print(longWithRadix);
	}

	/**
	 * M�todo que imprime um long na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha,
	 * na base especificada
	 *
	 * Obs.: Se a base estiver fora do intervalo
	 * [Character.MIN_RADIX, Character.MAX_RADIX],
	 * a base adotada ser� 10.
	 *
	 * @param    lng O long a ser impresso na tela
	 * @param    base A base na qual deve ser impresso o n�mero
	 */
	public void println(long lng, int base) {
		String longWithRadix = Long.toString(lng, base);
		MiniJavaSystem.out.println(longWithRadix);
	}

	/**
	 * M�todo que imprime um float na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    flt O float a ser impresso na tela
	 */
	public void print(float flt) {
		MiniJavaSystem.out.print(flt);
	}

	/**
	 * M�todo que imprime um float na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    flt O float a ser impresso na tela
	 */
	public void println(float flt) {
		MiniJavaSystem.out.println(flt);
	}

	/**
	 * M�todo que imprime um double na janela
	 * onde o programa est� sendo executado
	 *
	 * @param    dbl O double a ser impresso na tela
	 */
	public void print(double dbl) {
		MiniJavaSystem.out.print(dbl);
	}

	/**
	 * M�todo que imprime um double na janela
	 * onde o programa est� sendo executado sendo
	 * que ap�s isso ele faz uma mudan�a de linha
	 *
	 * @param    dbl O double a ser impresso na tela
	 */
	public void println(double dbl) {
		MiniJavaSystem.out.println(dbl);
	}
	
	public void close() {
		System.exit(0);
	}
}
