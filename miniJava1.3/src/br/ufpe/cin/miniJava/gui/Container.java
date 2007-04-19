package br.ufpe.cin.miniJava.gui;

import br.ufpe.cin.miniJava.gui.listener.ClickListener;
import br.ufpe.cin.miniJava.gui.listener.ItemStateListener;


/**
 * Esta � a classe abstrata que representa tipos de objetos
 * que podem ter outros componentes inseridos dentro de si.
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.2
 * @since 1.0
 */
abstract class Container extends Component implements ClickListener, ItemStateListener {
	
	private java.awt.Container container;
    /**
     * Cria um container, que � uma especie de "moldura" onde
     * ser�o colocados outros objetos.
     * @param component <CODE>Component</CODE> que indicar� qual ser� o
     * tipo do Container.
     */
	Container(Component component){
		super(component.getComponent());
		this.container = (java.awt.Container) this.getComponent();
	}
    /**
     * Insere um componente neste objeto.
     * 
     * @param comp <CODE>Component</CODE> que ser� adicionado.
     */
	//METODO DEFAULT QUE NAO DEVER� APARECER NESTA VERSAO
	void add(Component comp) {
		if (comp != null) {
			this.container.add(comp.getComponent());
			comp.setParent(this);
			this.repaint();
		}
	}
	/**
     * Insere um componente neste objeto, nas coordenadas desejadas.
     * 
     * @param comp <CODE>Component</CODE> que ser� adicionado.
     * @param x posi��o X do component.
     * @param y posi��o Y do component.
     */
	//METODO DEFAULT QUE NAO DEVER� APARECER NESTA VERSAO
	void add(Component comp, int x, int y) {
		if (comp != null) {
			comp.setPosition(x,y);
			this.add(comp);
		}
	}
	/**
     * Fornece o component que est� na posi��o <i>n</i>, 
     * onde n diz respeito a posi��o do array onde o 
     * este objeto guarda seus componentes, ou seja,
     * se foram adicionados n elementos a este objeto, 
     * a chamada deste m�todo passando n-1 como par�metro retorna o 
     * �ltimo elemento adicionado, ao passo que com 0 o elemento retornado
     * ser� o primeiro inserido, de forma que uma chamada passando n
     * como par�metro retorna null.
     * 
     * @param n posi��o de onde quer se obter um componente. 
     * @return componente localizado na posi��o <i>n</i>.
     */
	public Component getComponent(int n) {
		java.awt.Component component;
		if (this instanceof Window) {
			/*
			 * N�o assuste-se! Esta � a forma que Swing guarda objetos numa janela! :( 
			 */
			component = ((java.awt.Container) ((java.awt.Container) ((java.awt.Container) this.container.getComponent(0)).getComponent(1)).getComponent(0)).getComponent(n);
		} else {
			component = this.container.getComponent(n);
		}
		return new Component (component);
	}
	/**
     * Fornece o n�mero de componentes neste objeto.
     * 
     * @return n�mero de componentes neste objeto.
     */
	public int getComponentCount() {
		int resp = this.container.getComponentCount();
		if (this instanceof Window) {
			/*
			 * N�o assuste-se! Esta � a forma que Swing guarda objetos numa janela! :( 
			 */
			resp = ((java.awt.Container) ((java.awt.Container) ((java.awt.Container) this.container.getComponent(0)).getComponent(1)).getComponent(0)).getComponentCount();
		}
		return resp;
	}
	/**
     * Remove um component deste objeto, para isso � preciso especificar qual componente 
     * se quer remover.
     * 
     * @param comp <CODE>Component</CODE> a ser removido.
     */
	public void remove(Component comp) {
		if (comp != null) {
			this.container.remove(comp.getComponent());
			this.repaint();
		}
	}
	/**
     * Remove todos os componentes deste objeto.
     */
	public void removeAll() {
		this.container.removeAll();
		this.repaint();
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
		this.container = (java.awt.Container) c;
	}
	/**
	 * Implementa��o vazia da interface <code>ClickListener</code>.
	 * 
	 */
	public void clickEvent(Component component) { }
	/**
	 * Implementa��o vazia da interface <code>ClickListener</code>.
	 * 
	 */
	public void clickEvent() { }
	/**
	 * Implementa��o vazia da interface <code>ItemStateListener</code>.
	 * 
	 */
	public void stateEvent(Component component) { } 
	/**
	 * Implementa��o vazia da interface <code>ItemStateListener</code>.
	 * 
	 */
	public void stateEvent() { }
	/**
	 * M�todo include, que adiciona o componente no container
	 * @param comp
	 */
	void include(Component comp) {
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
}
