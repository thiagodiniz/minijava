package br.ufpe.cin.miniJava.gui;

/**
 * Esta classe representa as fontes utilizadas nos componentes de MiniJava.
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/Font.gif">
 * </p>
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.2
 * @since 1.0
 */
public class Font {

	private java.awt.Font font;
	
	/**
	 * Cria uma fonte com o nome especificado no tamanho padr�o, uma fonte representa
	 * um tipo de escrita (Arial, por exemplo). 
	 * 
	 * @param name <CODE>String</CODE> com o nome da especifico da fonte.
	 */
	public Font(String name) {		
		this.font = new java.awt.Font(name,java.awt.Font.BOLD,12);
	}
	/**
	 * Cria uma fonte com o nome especificado no tamanho especificado, logo
	 * al�m de criar uma fonte (Arial, por exemplo) � especificado o tamanho
	 * da fonte (12 por exemplo).
	 * 
	 * @param name <CODE>String</CODE> com o nome da fonte
	 * @param size tamanho da fonte a ser criada.
	 */
	public Font(String name, int size) {		
		this.font = new java.awt.Font(name,java.awt.Font.BOLD,size);
	}
	/**
	 * Verifica se duas fontes s�o iguais, duas 
	 * fontes s�o iguais quando possuem al�m da 
	 * mesmo tipo de escrita o mesmo tamanho.
	 * 
	 * @param param Fonte que ser� comparada com o fonte sobre
	 * o qual o m�todo � aplicado.
	 * @return <CODE>true</CODE> se as fontes forem iguais
	 * <CODE>false</CODE> caso contr�rio.
	 */
	public boolean equals(Object param) {
		boolean retorno = false;
		if (param instanceof Font) {
			retorno = this.toString().equals(param.toString());
		}
		return retorno;
	}
	/**
	 * Fornece uma representa��o em <CODE>String</CODE> para esta fonte.
	 *  
	 * @return <CODE>String</CODE> com a representa��o desta fonte.
	 */
	public String toString() {
		String name = this.font.getName();
		int size = this.font.getSize();
		return ("Font " + name + ", " + size);
	}
	/**
	 * Retorna o objeto <CODE>java.awt.Font</CODE> interno desta fonte
	 * (n�o � p�blico, apenas para fins de implementa��o).
	 *  
	 * @return objeto <CODE>java.awt.Font</CODE> que esta fonte representa.
	 */
	//NAO DEVE APARECER PUBLICAMENTE NA API
	java.awt.Font getFont() {
		return this.font;		
	}

}
