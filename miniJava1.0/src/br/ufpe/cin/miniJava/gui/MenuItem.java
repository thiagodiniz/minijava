package br.ufpe.cin.miniJava.gui;


import javax.swing.JMenuItem;
/**
 * Esta classe representa um sub-item de menu.
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/MenuBar.gif">
 * </p>
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
public class MenuItem extends AbstractMenu  {
	/**
	 * Cria um sub-item de menu vazio.
	 */
	
	
	private final String DEFAULT_TEXT = "MenuItem";
	private Window parent;
	
	public MenuItem() {
		super(new Component(new JMenuItem()));
		this.setText(DEFAULT_TEXT);
	} 
	/**
	 * Cria um sub-item de menu com um texto.
	 * 
	 * @param text texto a ser inicializado no sub-item de menu
	 */
	public MenuItem(String text) {
		this();
		this.setText(text);
	}
	/**
	 * Retorna uma refer�ncia para o objeto janela que cont�m este componente.
	 * Caso este componente j� seja uma janela, ou caso este componente n�o esteja
	 * inserido em nenhuma janela, ele retornar� <code>null</code>.
	 * 
	 * @return <code>Window</code> onde o component est� inserido. 
	 */
	//	METODO DEFAULT PARA NAO APARECER NO JAVADOC
	public Window getParent() {
		return this.parent;
	}
	
	void setParent(Window w) {
		this.parent = w;
	}
	

}
