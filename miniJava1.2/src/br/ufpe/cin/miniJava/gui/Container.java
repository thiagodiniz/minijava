package br.ufpe.cin.miniJava.gui;


/**
 * Esta � a classe abstrata que representa tipos de objetos
 * que podem ter outros componentes inseridos dentro de si.
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.2
 * @since 1.0
 */
abstract class Container extends Component {
	
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
     * Insere um componente no container, nas coordenadas desejadas.
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
     * objeto do tipo o <i>Conteiner</i> guarda seus 
     * objetos, ou seja se foram adicionados n elementos ao Container 
     * a chamada deste m�todo passando n-1 como par�mentro retorna o 
     * �ltimo elemento adicionado ao passo que com 0 o elemento retornado
     * ser� o primeiro inserido ao passo que uma chamada passando n
     * como par�metro retorna null.
     * 
     * @param n posi��o de onde quer se obter um componente do <i>Container</i>. 
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
     * Fornece o n�mero de componentes no container.
     * 
     * @return n�mero de componentes no container.
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
     * Remove um component do container, para isso � preciso especificar qual componente 
     * se quer remover.
     * 
     * @param comp <CODE>Component</CODE> a ser removido do container.
     */
	public void remove(Component comp) {
		if (comp != null) {
			this.container.remove(comp.getComponent());
			this.repaint();
		}
	}
	/**
     * Remove todos os componentes do Container.
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
	
}
