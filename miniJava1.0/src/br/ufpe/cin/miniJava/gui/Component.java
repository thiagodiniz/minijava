package br.ufpe.cin.miniJava.gui;

import java.util.Iterator;
import java.util.Set;

import br.ufpe.cin.miniJava.gui.listener.Listener;

/**
 * Esta � a classe principal de miniJava. Representa todos os componentes
 * visuais utilizados nesta API.
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
public class Component {

	private java.awt.Component component = null;

	/**
	 * Fornece a cor de fundo do componente.
	 * 
	 * @return <CODE>Color</CODE> com as propriedades de cor do componente.
	 */
	public Color getBackground() {
		java.awt.Color color = this.component.getBackground();
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		Color retorno = new Color(red, green, blue);
		return retorno;
	}

	/**
	 * Fornece a fonte do componente.
	 * 
	 * @return <CODE>Font</CODE> com as propriedades de fonte do componente.
	 */
	public Font getFont() {
		java.awt.Font font = this.component.getFont();
		Font retorno = new Font(font.getName(), font.getSize());
		return retorno;
	}

	/**
	 * Fornece a cor de frente do componente.
	 * 
	 * @return <CODE>Color</CODE> com as propriedades de cor do componente.
	 */
	public Color getForeground() {
		java.awt.Color color = this.component.getForeground();
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		Color retorno = new Color(red, green, blue);
		return retorno;
	}

	/**
	 * Fornece a altura do componente.
	 * 
	 * @return altura do componente.
	 */
	public int getHeight() {
		return this.component.getHeight();
	}

	/**
	 * Fornece a largura do componente.
	 * 
	 * @return largura do componente.
	 */
	public int getWidth() {
		return this.component.getWidth();
	}

	/**
	 * Fornece a posi��o X do componente.
	 * 
	 * @return posi��o X do componente.
	 */
	public int getX() {
		return this.component.getX();
	}

	/**
	 * Fornece a posi��o Y do componente.
	 * 
	 * @return posi��o Y do componente.
	 */
	public int getY() {
		return this.component.getY();
	}

	/**
	 * Fornece a propriedade <i>enabled</i>.
	 * 
	 * @return <CODE>true</CODE> se o componente estiver ativo.
	 */
	public boolean isEnabled() {
		return this.component.isEnabled();
	}

	/**
	 * Fornece a propriedade <i>visible</i>.
	 * 
	 * @return <CODE>true</CODE> se o componente estiver vis�vel.
	 */
	public boolean isVisible() {
		return this.component.isVisible();
	}

	/**
	 * Repinta este componente na tela, necess�rio caso algum sub-componente
	 * tenha sido adicionado � ele.
	 */
	public void repaint() {
		this.component.repaint();
	}

	/**
	 * Altera a cor de fundo do componente.
	 * 
	 * @param c
	 *            <CODE>Color</CODE> com as propriedades de cor do componente.
	 */
	public void setBackground(Color c) {
		if (c != null)
			this.component.setBackground(c.getColor());
	}

	/**
	 * Altera a posi��o do component.
	 * 
	 * @param x
	 *            Posi��o X do component.
	 * @param y
	 *            Posi��o Y do component.
	 */
	public void setPosition(int x, int y) {
		int width = this.component.getWidth();
		int height = this.component.getHeight();
		this.component.setBounds(x, y, width, height);
	}

	/**
	 * Altera a propriedade <i>enabled</i>.
	 * 
	 * @param b
	 *            <CODE>boolean</CODE> que indicar� se o componente dever�
	 *            estar ativo ou n�o.
	 */
	public void setEnabled(boolean b) {
		this.component.setEnabled(b);
	}

	/**
	 * Altera a fonte do componente.
	 * 
	 * @param f
	 *            <CODE>Font</CODE> com as propriedades de fonte do
	 *            componente.
	 */
	public void setFont(Font f) {
		if (f != null)
			this.component.setFont(f.getFont());
	}

	/**
	 * Altera a cor de frente do componente.
	 * 
	 * @param c
	 *            <CODE>Color</CODE> com as propriedades de cor do componente.
	 */
	public void setForeground(Color c) {
		if (c != null)
			this.component.setForeground(c.getColor());
	}

	/**
	 * Altera a altura do componente.
	 * 
	 * @param height
	 *            altura do componente.
	 */
	public void setHeight(int height) {
		int width = this.component.getWidth();
		this.component.setSize(width, height);
	}

	/**
	 * Altera as dimens�es do componente.
	 * 
	 * @param width
	 *            largura do componente.
	 * @param height
	 *            altura do componente.
	 */
	public void setSize(int width, int height) {
		this.component.setSize(width, height);
	}

	/**
	 * Altera a propriedade <i>visible</i>.
	 * 
	 * @param b
	 *            <CODE>boolean</CODE> que indicar� se o componente dever�
	 *            estar vis�vel ou n�o.
	 */
	public void setVisible(boolean b) {
		this.component.setVisible(b);
	}

	/**
	 * Altera a largura do componente.
	 * 
	 * @param width
	 *            largura do componente.
	 */
	public void setWidth(int width) {
		int height = this.component.getHeight();
		this.component.setSize(width, height);
	}

	/**
	 * Cria um novo componente. O m�todo � default porque nem todas as classes
	 * devem acessar o atributo component desta classe, que �
	 * java.awt.Component.
	 * 
	 * @param component
	 *            <CODE>java.awt.Component</CODE> para fins de implementa��o.
	 */
	// METODO DEFAULT PARA NAO APARECER NO JAVADOC
	Component(java.awt.Component component) {
		this.component = component;
	}

	/**
	 * Verifica se dois componentes s�o iguais.
	 * 
	 * @param obj
	 *            Component que ser� comparado com este.
	 * @return <CODE>true</CODE> se os componentes forem iguais.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Component) {
			return this.component.equals(((Component) obj).component);
		}
		return super.equals(obj);
	}

	public String toString() {
		return this.component.toString();
	}

	/**
	 * Fornece o objeto <CODE>java.awt.Component</CODE> representado por este
	 * Component. � a base da implementa��o de heran�a em miniJava.
	 * 
	 * O m�todo � default porque apenas as classes de br.ufpe.cin.miniJava.gui
	 * devem acessar o atributo component desta classe, que �
	 * java.awt.Component.
	 * 
	 * @return <CODE>java.awt.Component</CODE> para fins de implementa��o.
	 */
	// METODO DEFAULT PARA NAO APARECER NO JAVADOC
	java.awt.Component getComponent() {
		return this.component;
	}

	/**
	 * Altera o objeto <CODE>java.awt.Component</CODE> representado por este
	 * Component. � a base da implementa��o de heran�a em miniJava.
	 * 
	 * O m�todo � default porque apenas as classes de br.ufpe.cin.miniJava.gui
	 * devem acessar o atributo component desta classe, que �
	 * java.awt.Component.
	 * 
	 * @param c
	 *            <CODE>java.awt.Component</CODE> para fins de implementa��o.
	 */
	// METODO DEFAULT PARA NAO APARECER NO JAVADOC
	void setComponent(java.awt.Component c) {
		this.component = c;
	}

	/**
	 * Implementa��o vazia do <code>addListener</code> que as classes que
	 * necessitarem de ouvintes dever�o sobrescrever.
	 * 
	 * @param listener
	 *            <code>Listener</code> a ser adicionado.
	 * 
	 */
	// METODO DEFAULT PARA NAO APARECER NO JAVADOC
	void addListener(Listener listener) {

	}

	/**
	 * Retorna uma refer�ncia para o objeto janela que cont�m este componente.
	 * Caso este componente j� seja uma janela, ou caso este componente n�o
	 * esteja inserido em nenhuma janela, ele retornar� <code>null</code>.
	 * 
	 * @return <code>Window</code> onde o component est� inserido.
	 */
	// METODO DEFAULT PARA NAO APARECER NO JAVADOC
	public Window getParent() {
		Window retorno = null;
		java.awt.Container cont, cont2 = null;
		cont = this.component.getParent();
		while (cont != null) {
			cont2 = cont;
			cont = cont.getParent();
		}
		if (cont2 != null) {

			Set ws = Window.getTodasWindows();
			Iterator i = ws.iterator();

			while (i.hasNext() && retorno==null) {
				Window temp = (Window) i.next();
				if (temp.getComponent() == cont2) {
					retorno = temp;
				}
			}
			if (retorno == null) {
				retorno = new Window();
				retorno.setComponent(cont2);
			}
		}
		return retorno;
	}

}
