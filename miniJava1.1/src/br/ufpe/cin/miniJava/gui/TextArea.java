package br.ufpe.cin.miniJava.gui;


import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Esta classe representa uma �rea de texto, um componente que permite
 * inser��o de texto em m�ltiplas linhas.
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/TextArea.gif">
 * </p>
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
public class TextArea extends AbstractText {

	private javax.swing.JTextArea textArea;
	private javax.swing.JScrollPane scrollPane;
	private final int MIN_WIDTH = 150;
	private final int MIN_HEIGHT = 150;
	private final String DEFAULT_TEXT = "textArea";
	
	/**
	 * Cria um novo <code>TextArea</code> sem texto, com o n�mero de linhas
	 * e de colunas iguais a 0.
	 */
	public TextArea() {
		super(new Component(new JScrollPane(new JTextArea())));
		this.scrollPane = (JScrollPane) this.getComponent(); 
		this.textArea =  (JTextArea) this.scrollPane.getViewport().getView();
		this.scrollPane.setSize(MIN_WIDTH,MIN_HEIGHT);
		this.textArea.setText(DEFAULT_TEXT);
		this.textArea.setLineWrap(true);
	}
	
	/**
	 * Cria um novo <code>TextArea</code> sem texto, com o n�mero de linhas
	 * e de colunas de acordo com o especificado.
	 * 
	 * @param rows n�mero de linhas.
	 * @param columns n�mero de colunas.
	 */
	public TextArea(int rows, int columns) {
		this();
		this.textArea.setRows(rows);
		this.textArea.setColumns(columns);
	}
	/**
	 * Cria um novo <code>TextArea</code> com um texto, sem especificar n�mero
	 * de linhas e colunas, no entanto.
	 * 
	 * @param text texto a ser colocado inicialmente no <code>TextArea</code>.
	 */
	public TextArea(String text) {
		this();
		this.setText(text);
	}
	/**
	 * Cria um novo <code>TextArea</code> com um texto, e com o n�mero de linhas
	 * e de colunas de acordo com o especificado;
	 * 
	 * @param text texto a ser colocado inicialmente no <code>TextArea</code>.
	 * @param rows n�mero de linhas.
	 * @param columns n�mero de colunas.
	 */
	public TextArea(String text, int rows, int columns) {
		this(rows,columns);
		this.setText(text);
	}
	/**
	 * Concatena texto ao fim deste <code>TextArea</code>.
	 * 
	 * @param str texto a ser concatenado.
	 */
	public void append(String str) {
		this.textArea.append(str);
	} 
	/**
	 * Fornece o n�mero de colunas do <code>TextArea</code>.
	 * 
	 * @return n�mero de colunas.
	 */
	public int getColumns() {
		return this.textArea.getColumns();
	} 
	/**
	 * Fornece o n�mero de linhas preenchidas do <code>TextArea</code>.
	 * 
	 * @return n�mero de linhas preenchidas do <code>TextArea</code>.
	 */
	public int getLineCount() {
		return this.textArea.getLineCount();
	} 
	/**
	 * Indica se o <code>TextArea</code> trata quebras-de-linhas, caso o
	 * texto seja muito grande.
	 * 
	 * @return <code>true</code> se o <code>TextArea</code> usa quebras-de-linha.
	 */
	public boolean getLineWrap() {
		return this.textArea.getLineWrap();
	} 
	/**
	 * Fornece o n�mero de linhas do <code>TextArea</code>.
	 * 
	 * @return n�mero de linhas.
	 */
	public int getRows() {
		return this.textArea.getRows();
	} 
	/**
	 * Insere um texto na posi��o especificada.
	 * 
	 * @param str texto a ser inserido.
	 * @param pos posi��o onde o texto dever� ser inserido.
	 */
	public void insert(String str, int pos) {
		this.textArea.insert(str,pos);
	} 
	/**
	 * Altera a cor de fundo do componente.
	 * 
	 * @param c <CODE>Color</CODE> com as propriedades de cor do componente.
	 */
	public void setBackground(Color c) {
		if (c != null) this.textArea.setBackground(c.getColor());
	} 
	/**
	 * Altera o n�mero de colunas do <code>TextArea</code>.
	 * 
	 * @param columns novo n�mero de colunas.
	 */
	public void setColumns(int columns) {
		this.textArea.setColumns(columns);
	} 
	/**
	 * Altera a cor de frente do componente.
	 * 
	 * @param c <CODE>Color</CODE> com as propriedades de cor do componente.
	 */
	public void setForeground(Color c) {
		if (c != null) this.textArea.setForeground(c.getColor());
	} 
	/**
	 * Altera a propriedade <code>lineWrap</code>.
	 * 
	 * @param b <code>boolean</code> que indicar� se o <code>TextArea</code>
	 * dever� utilizar quebras-de-linha ou n�o.
	 */
	public void setLineWrap(boolean b) {
		this.textArea.setLineWrap(b);
	} 
	/**
	 * Altera o n�mero de linhas do <code>TextArea</code>.
	 * 
	 * @param rows novo n�mero de linhas.
	 */
	public void setRows(int rows) {
		this.textArea.setRows(rows);
	} 
	

}
