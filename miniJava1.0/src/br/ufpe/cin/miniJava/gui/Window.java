package br.ufpe.cin.miniJava.gui;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;

import br.ufpe.cin.miniJava.gui.listener.ClickListener;
import br.ufpe.cin.miniJava.gui.listener.ItemStateListener;

/**
 * Esta classe representa uma janela, como estas janelas que todos os
 * programas apresentam.
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/Window.gif">
 * </p>
 * 
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.1
 * @since 1.0
 */
public class Window extends Container implements ClickListener, ItemStateListener {
	
	private javax.swing.JFrame window;
	private final int MIN_WIDTH = 200;
	private final int MIN_HEIGHT = 200;
	private static Set<Window> todasWindows = new HashSet<Window>();
	
	static Set<Window> getTodasWindows(){
		return todasWindows;
	}
	
	/**
	 * Cria uma nova janela vazia.
	 *
	 */
	public Window(){		
		super(new Component(new javax.swing.JFrame()));
		this.window = (javax.swing.JFrame) this.getComponent();
		this.window.setLayout(null);
		this.window.setContentPane(this.window.getContentPane());
		this.setSize(MIN_WIDTH,MIN_HEIGHT);
		this.exitOnClose(true);
		Window.todasWindows.add(this);
	}
	/**
	 * Cria uma nova janela com um texto de t�tulo.
	 * 
	 * @param title t�tulo da janela.
	 */
	public Window (String title) {
		this();
		this.window.setTitle(title);
	}
	/**
	 * Fornece o painel de conte�do da janela.
	 * 
	 * @return <code>Panel</code> de conte�do da janela.
	 */
	public Panel getContentPane() {
		Panel retorno = new Panel();
		retorno.setComponent(this.window.getContentPane());
		return retorno;
	} 
	/**
	 * Altera o painel de conte�do da janela.
	 * 
	 * @param contentPane novo <code>Panel</code> que substituir� o
	 * <code>contentPane</code> atual.
	 */
	public void setContentPane(Panel contentPane) {
		this.window.setContentPane((java.awt.Container) contentPane.getComponent());
	}
	/**
	 * Fornece a janela-pai desta janela.
	 * 
	 * @return <code>Window</code> pai desta janela, ou <code>null</code>
	 * se ela n�o for filha de nenhuma outra janela.
	 */
	public Window getOwner() {
		
		return (Window) new Component(this.window.getOwner());
	}
	/**
	 * Indica se o foco est� sob a janela ou n�o.
	 * 
	 * @return <code>true</code> se a janela estiver focalizada.
	 */
	public boolean isFocused() {
		return this.window.isFocused();
	} 
	/**
	 * Envia esta janela para tr�s de todas as outras. 
	 *
	 */
	public void toBack() {
		this.window.toBack();
	} 
	/**
	 * Envia esta janela para a frente de todas as outras. 
	 *
	 */
	public void toFront() {
		this.window.toFront();
	}
	/**
	 * Indicar� o que dever� acontecer ao fechar a janela.
	 * 
	 * @param b <code>true</code> se o programa dever� encerrar
	 * ao fechar a janela, ou <code>false</code> se apenas os
	 * recursos utilizados pela janela devam ser liberados.
	 */
	public void exitOnClose(boolean b){
		int arg = javax.swing.JFrame.DISPOSE_ON_CLOSE;
		if (b) {
			arg = javax.swing.JFrame.EXIT_ON_CLOSE;
		}
		this.window.setDefaultCloseOperation(arg);
	}
	/**
	 * Altera o t�tulo da janela.
	 * 
	 * @param text novo t�tulo da janela.
	 */
	public void setTitle(String text){
		this.window.setTitle(text);
	}
	/**
	 * Fornece o t�tulo da janela.
	 * 
	 * @return o t�tulo da janela.
	 */
	public String getTitle(){
		return this.window.getTitle();
	}
	/**
	 * Fornece a cor de frente da janela.
	 * 
	 * @return <code>Color</code> contendo cor de frente da janela.
	 * 
	 */
	public Color getForeground() {
		java.awt.Color color = this.window.getContentPane().getForeground();
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		Color retorno = new Color(red,green,blue);
		return retorno;
	}
	/**
	 * Fornece a cor de fundo da janela.
	 * 
	 * @return <code>Color</code> contendo cor de fundo da janela.
	 * 
	 */
	public Color getBackground() {
		java.awt.Color color = this.window.getContentPane().getBackground();
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		Color retorno = new Color(red,green,blue);
		return retorno;
	} 
	/**
	 * Altera cor de fundo da janela.
	 * 
	 * @param c <code>Color</code> com a nova cor de fundo.
	 * 
	 */
	public void setBackground(Color c) {
		if (c != null) this.window.getContentPane().setBackground(c.getColor());
	} 
	/**
	 * Altera cor de frente da janela.
	 * 
	 * @param c <code>Color</code> com a nova cor de frente.
	 * 
	 */
	public void setForeground(Color c) {
		if (c != null) this.window.getContentPane().setForeground(c.getColor());
	}
	
	/**
	 * Implementa��o vazia da interface <code>ClickListener</code>.
	 * 
	 */
	public void clickEvent(Component component) {
		
	}
	/**
	 * Implementa��o vazia da interface <code>ClickListener</code>.
	 * 
	 */
	public void clickEvent() {
		
	}
	/**
	 * Implementa��o vazia da interface <code>ItemStateListener</code>.
	 * 
	 */
	public void stateEvent(Component component) {
		
	} 
	/**
	 * Implementa��o vazia da interface <code>ItemStateListener</code>.
	 * 
	 */
	public void stateEvent() {
		
	}
	/**
     * Insere um componente � janela, nas coordenadas desejadas.
     * 
     * A diferen�a entre este m�todo e o add, � o fato de que ao usar
     * include, o Component <code>comp</code> adiciona a janela
     * como novo ouvinte. 
     * 
     * @param comp <CODE>Component</CODE> que ser� adicionado e que
     * receber� um novo ouvinte.
     */
	public void include(Component comp) {
		if (comp != null) {
			this.add(comp);
		}
		
		//isso eh ruim pq cria dependencia da superclasse 
		//em rela��o as subclasses
		//comp.addListener(this);
		
		//criamos uma terceira entidade com a responsabilidade
		//de conhecer as dependencias
		ListenerManager.addListenerTo(this,comp);
	}
	
	/**
     * Insere um componente � janela, nas coordenadas desejadas.
     * 
     * @param comp <CODE>Component</CODE> que ser� adicionado e que
     * receber� um novo ouvinte.
     * @param x posi��o X do component.
     * @param y posi��o Y do component.
     */
	public void include(Component comp, int x, int y) {
		comp.setPosition(x,y);
		this.include(comp);
	}
	/**
	 * Altera o objeto <CODE>java.awt.Component</CODE> representado por
	 * este Component. � a base da implementa��o de heran�a em miniJava.
	 * 
	 * O m�todo � default porque apenas as classes de
	 * br.ufpe.cin.miniJava.gui devem acessar o atributo component
	 * desta classe, que � java.awt.Component.
	 * 
	 * @param c <CODE>java.awt.Component</CODE> para fins de implementa��o.
	 */
	//METODO DEFAULT PARA NAO APARECER NO JAVADOC	
	void setComponent(java.awt.Component c){
		super.setComponent(c);
		this.window = (JFrame) c;
	}
	
}
