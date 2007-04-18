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
	 * Cria uma nova janela com um texto de t�tulo,este 
	 * aparecer� na barra de cima da <i>Window</i>,como
	 * ocorre numa janela qualquer do sistema operacional.
	 * 
	 * @param title t�tulo da janela.
	 */
	public Window (String title) {
		this();
		this.window.setTitle(title);
	}
	/**
	 * Fornece o painel de conte�do da janela, ou seja 
	 * fornece o painel em que os outros componetes
	 * da janela s�o inseridos.
	 * 
	 * @return <code>Panel</code> de conte�do da janela, � nele 
	 * que os outros componentes s�o inseridos.
	 */
	public Panel getContentPane() {
		Panel retorno = new Panel();
		retorno.setComponent(this.window.getContentPane());
		return retorno;
	} 
	/**
	* Altera  o painel de conte�do da janela, ou seja 
	 * altera  o painel em que os outros componetes
	 * da janela s�o inseridos.
	 * 
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
	//m�todo default pq nao deve aparecer na API
	Window getOwner() {
		return (Window) new Component(this.window.getOwner());
	}
	/**
	 * Indica se o foco est� sob a janela ou n�o,
	 * o foco indica a janela que est� sendo usada no momento,
	 * ou se est� superposta por outras.Numa aplica��o pode-se
	 * abrir v�rias janelas , mas s� uma estar� sendo usada a cada momento 
	 * enquanto as outras estar�o subpostas a set�,logo indicar� 
	 * a superposi��o ou n�o da janela.
	 * 
	 * @return <code>true</code> se a janela estiver focalizada,
	 * <code>false</code> caso contr�rio, ou seja ela
	 * � a janela n�o usado no momento.
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
	 * Indicar� o que dever� acontecer ao fechar a janela,
	 * ou seja , fechando a janela seu programa poder� seguir
	 * dois caminho descritos a seguir: fechar a janela e
	 * encerrar o programa ou fechar apenas os recursos que 
	 * estavam sendo utilizados pela janela.
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
	 * Altera o t�tulo da janela, logo deve-se indicar neste m�todo
	 * o novo t�tulo que substituir� o anterior.
	 * 
	 * @param text novo t�tulo da janela.
	 */
	public void setTitle(String text){
		this.window.setTitle(text);
	}
	/**
	 * Fornece o t�tulo da janela, ou seja a <code>String</code>
	 * que � mostrada na barra superior da Janela. 
	 * 
	 * @return o t�tulo <code>String</code> da janela.
	 */
	public String getTitle(){
		return this.window.getTitle();
	}
	/**
	 *Fornece a cor de frente da janela, esta � representada 
	 *por um objeto do tipo <code>Color</code> que contem tr�s atributos
	 *inteiros que codificam a cor em quest�o.
	 * 
	 * @return <code>Color</code> contendo a cor de frente da janela.
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
	*Fornece a cor de fundo da janela, esta � representada 
	 *por um objeto do tipo <code>Color</code> que cont�m tr�s atributos
	 *inteiros que codificama  cor em quest�o.
	 * @return <code>Color</code> contendo a cor de fundo da janela.
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
