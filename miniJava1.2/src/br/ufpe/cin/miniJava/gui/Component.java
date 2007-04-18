package br.ufpe.cin.miniJava.gui;

import br.ufpe.cin.miniJava.gui.listener.Listener;

/**
 * Esta � a classe principal de miniJava. Representa todos os componentes
 * visuais utilizados nesta API.
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.2
 * @since 1.0
 */
public class Component {

	private java.awt.Component component = null;
	@SuppressWarnings("unused")
	private Component parent = null;

	/**
	 * Fornece a cor de fundo do componente, onde 
	 * a cor e representada por um objeto do tipo Color
	 * 
	 * @return <CODE>Color</CODE> com as propriedades de cor do componente,
	 * onde <CODE>Color</CODE> possui tr�s atributos do tipo <CODE>int</CODE>
	 * que indicam a cor.
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
	 * Fornece a fonte do componente,ou seja, fornece
	 * as propriedades relativas ao "tamanho" das letras
	 * e ao padr�o de escrita (<i>TimesNewRoman</i>, por exemplo)
	 * onde todas estas caracter�sticas est�o armazenadas 
	 * num objeto do tipo Font.
	 * @return <CODE>Font</CODE> com as propriedades de fonte do componente ,
	 * ou seja tamanho e tipo de escrita padr�o.
	 */
	public Font getFont() {
		java.awt.Font font = this.component.getFont();
		Font retorno = new Font(font.getName(), font.getSize());
		return retorno;
	}

	/**
	 * Fornece a cor de frente do componente, ou seja,
	 * fornece o cor dos caracteres que s�o parte 
	 * do componente.
	 * 
	* @return <CODE>Color</CODE> com as propriedades de cor do componente,
	 * onde <CODE>Color</CODE> possui tr�s atributos do tipo <CODE>int</CODE>
	 * que indicam a cor.
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
	 * Fornece a altura do componente, onde altura diz respeito
	 * ao segmento(Y(final)- Y(inicial)) num eixo cartesiano  (x, y), lembrando
	 * que o ponto (0,0) se encontra no canto superior esquerdo.
	 * 
	 * @return altura do componente, esta altura � a mencionada 
	 * acima e � representada por um<CODE>int</CODE>
	 */
	public int getHeight() {
		return this.component.getHeight();
	}

	/**
	 * Fornece a largura do componente, onde largura diz respeito
	 * ao segmento(X(final)- X(inicial)) num eixo cartesiano  (x, y), lembrando
	 * que o ponto (0,0) se encontra no canto superior esquerdo.
	 * 
	 * @return largura do componente, esta largura � a mencionada 
	 * acima e � representada por um<CODE>int</CODE>
	 */
	public int getWidth() {
		return this.component.getWidth();
	}

	/**
	 * Fornece a posicao X do componente em rela��o ao lado esquerdo do componente.
	 * 
	 * @return posi��o X do componente, representada por um <CODE>int</CODE>
	 */
	public int getX() {
		return this.component.getX();
	}

	/**
	 * Fornece a posi��o Y do componente em rela��o ao lado superior do componente.
	 * 
	 * @return posi��o Y do componente.
	 */
	public int getY() {
		return this.component.getY();
	}

	/**
	 * Fornece a propriedade <i>enabled</i>, esta propriedade � a que indica
	 * se o componente est� ou n�o ativo, por exemplo se a propriedade
	 *  <i>enabled</i> de um bot�o estiver como  <i>false</i> o usu�rio
	 *  n�o conseguir� interagir com o mesmo. 
	 * 
	 * @return <CODE>true</CODE> se o componente estiver ativo,
	 *  <i>false</i> caso contr�rio.
	 */
	public boolean isEnabled() {
		return this.component.isEnabled();
	}

	/**
	 * Fornece a propriedade <i>visible</i>, esta propriedade 
	 * indica se o componente est� ou n�o vis�vel pelo
	 * usu�rio.
	 * 
	 * @return <CODE>true</CODE> se o componente estiver vis�vel,
	 *  <i>false</i> caso contr�rio.
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
	 * Altera a cor de fundo do componente onde 
	 * a cor � representada por um objeto do tipo Color.
	 * 
	 * @param c <CODE>Color</CODE> com as propriedades de cor do componente,
	 * onde <CODE>Color</CODE> possui tr�s atributos do tipo <CODE>int</CODE>
	 * que indicam a cor.
	 */
	public void setBackground(Color c) {
		if (c != null)
			this.component.setBackground(c.getColor());
	}

	/**
	 * Altera a posi��o do Componente, dadas suas novas coordenadas (X,Y).
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
	 * Altera a propriedade <i>enabled</i> do componente.
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
	 * Altera as dimens�es do componente, baseado em sua
	 * nova altura e largura
	 * 
	 * @param width
	 *            largura do componente em pixels.
	 * @param height
	 *            altura do componente em pixels.
	 */
	public void setSize(int width, int height) {
		this.component.setSize(width, height);
	}

	/**
	 * Altera a propriedade <i>visible</i>, esta propriedade 
	 * indica se o componente est� ou n�o vis�vel pelo
	 * usu�rio.
	 * 
	 * @param b <code>boolean</code> que indicar� se o componente
	 * estar� visivel (<code>true</code>) ou n�o (<code>false</code>).
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
	 * Verifica se dois componentes s�o iguais, dois componetes
	 * s�o iguais quando possuem as mesmas caracter�sticas.
	 * 
	 * @param obj
	 *            Component que ser� comparado com o componente
	 *            sobre o qual o m�todo � aplicado.
	 * @return <CODE>true</CODE> se os componentes forem iguais
	 * <CODE>false</CODE> caso contr�rio
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Component) {
			return this.component.equals(((Component) obj).component);
		}
		return super.equals(obj);
	}

	public String toString() {
		String retorno = "Component : " + this.component.getClass().getCanonicalName() + "\n";
		if (parent != null) {
			retorno = ("Parent : " + this.parent.getClass().getCanonicalName() + "\n");
		}
		return retorno;
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
	Component getParent() {
		return this.parent;
	}
	// METODO DEFAULT PARA NAO APARECER NO JAVADOC
	void setParent(Component w) {
		this.parent = w;
	}

}
