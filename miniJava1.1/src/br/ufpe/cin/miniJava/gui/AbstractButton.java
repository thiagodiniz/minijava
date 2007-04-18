package br.ufpe.cin.miniJava.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import br.ufpe.cin.miniJava.gui.listener.ClickListener;
import br.ufpe.cin.miniJava.gui.listener.Listener;

/**
 * Esta classe abstrata implementa funcionalidades que alguns tipos de bot�es
 * poder�o ter, como a��o a ser tomada quando clicado, alterar tamanho, posi��o,
 * texto, etc.
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.1
 * @since 1.0
 */
abstract class AbstractButton extends Component {

	private javax.swing.AbstractButton absButton;
	
    /**
     * Cria um bot�o, um bot�o � um objeto ao qual se pode
     * associar uma a��o
     * 
     * @param component <CODE>Component</CODE> que indicar� qual ser� o
     * tipo do bot�o.
     */
	AbstractButton(Component component){		
		super(component.getComponent());
		this.absButton = (javax.swing.AbstractButton) this.getComponent();
	}
    /**
     * Adiciona um <CODE>ClickListener</CODE> ao bot�o,informando
     * que o bot�o ter� uma a��o associada a ele
     * 
     * @param clickListener <CODE>clickListener</CODE> que conter�
     * a a��o que o bot�o dever� executar ao ser clicado
     */	
	//o m�todo est� default para N�O APARECER NA API!!!!
	//pelo menos na vers�o atual n�o!!
	void addClickListener(ClickListener clickListener) {
		class TempActionListener implements ActionListener{
			private ClickListener actionListener;
			TempActionListener(ClickListener actionListener){
				this.actionListener = actionListener;
			}
			public void actionPerformed(ActionEvent actionEvent) {
				this.actionListener.clickEvent(AbstractButton.this);
				this.actionListener.clickEvent();
			}
		}
		TempActionListener actionListener = new TempActionListener(clickListener);
		this.absButton.addActionListener(actionListener);
	}
    /**
     * M�todo chamado quando se deseja obter o mesmo efeito de clicar no objeto.
     */		
	public void doClick() {
		this.absButton.doClick();
	}
	/**
     * Fornece a posi��o do alinhamento horizontal,
     * analogamente a um eixo cartesiano (cuja origem � o canto
     * superior esquerdo), fornece posi��o do alinhamento horizontal X.
     * 
     * @return <CODE>Position</CODE> com o alinhamento horizontal.
     */
	public MiniJavaConstants.Position getHorizontalAlignment() {
		int pos = this.absButton.getHorizontalAlignment();
		MiniJavaConstants.Position retorno = null;
		switch (pos) {
			case (SwingConstants.RIGHT) :
				retorno = MiniJavaConstants.RIGHT;
				break;
			
			case (SwingConstants.LEFT) :
				retorno = MiniJavaConstants.LEFT;
				break;
			
			case (SwingConstants.CENTER) :
				retorno = MiniJavaConstants.CENTER;
				break;
			
			case (SwingConstants.LEADING) :
				retorno = MiniJavaConstants.LEADING;
				break;
			
			case (SwingConstants.TRAILING) :
				retorno = MiniJavaConstants.TRAILING;
		}
		return retorno;
	}
	/**
     * Fornece a posi��o do alinhamento horizontal do texto,
     * analogamente a um eixo cartesiano (cuja origem � o canto
     * superior esquerdo), fornece a posi��o do alinhamento horizontal X
     * do texto.
     * 
     * @return <CODE>Position</CODE> com o alinhamento horizontal do texto.
     */
	public MiniJavaConstants.Position getHorizontalTextPosition() {
		MiniJavaConstants.Position retorno = null;
		int pos = this.absButton.getHorizontalTextPosition();
		switch (pos) {
			case (SwingConstants.RIGHT) :
				retorno = MiniJavaConstants.RIGHT;
				break;
			
			case (SwingConstants.LEFT) :
				retorno = MiniJavaConstants.LEFT;
				break;
			
			case (SwingConstants.CENTER) :
				retorno = MiniJavaConstants.CENTER;
				break;
			
			case (SwingConstants.LEADING) :
				retorno = MiniJavaConstants.LEADING;
				break;
			
			case (SwingConstants.TRAILING) :
				retorno = MiniJavaConstants.TRAILING;
		}
		return retorno;
	}
	/**
     * Fornece o texto do bot�o, 
     * retornando um objeto do tipo <code>String</code> com o texto deste bot�o. 
     * 
     * @return <CODE>String</CODE> com o texto do bot�o.
     */		
	public String getText() {
		return this.absButton.getText();
	}
	/**
     * Fornece a posi��o do alinhamento vertical,
     * analogamente a um eixo cartesiano (cuja origem � o canto
     * superior esquerdo), fornece posi��o do alinhamento vertical Y.
     * 
     * @return <CODE>Position</CODE> com o alinhamento vertical.
     */
	public MiniJavaConstants.Position getVerticalAlignment(){
		int pos = this.absButton.getVerticalAlignment();
		MiniJavaConstants.Position retorno = null;
		switch (pos) {
			case (SwingConstants.CENTER) :
				retorno = MiniJavaConstants.CENTER;
				break;
			
			case (SwingConstants.TOP) :
				retorno = MiniJavaConstants.TOP;
				break;
			
			case (SwingConstants.BOTTOM) :
				retorno = MiniJavaConstants.BOTTOM;
		}
		return retorno;
	} 
	/**
     * Fornece a posi��o do alinhamento vertical do texto,
     * analogamente a um eixo cartesiano (cuja origem � o canto
     * superior esquerdo), fornece a posi��o do alinhamento vertical Y
     * do texto.
     * 
     * @return <CODE>Position</CODE> com o alinhamento vertical do texto.
     */
	public MiniJavaConstants.Position getVerticalTextPosition() {
		int pos = this.absButton.getVerticalTextPosition();
		MiniJavaConstants.Position retorno = null;
		switch (pos) {
			case (SwingConstants.CENTER) :
				retorno = MiniJavaConstants.CENTER;
				break;
			
			case (SwingConstants.TOP) :
				retorno = MiniJavaConstants.TOP;
				break;
			
			case (SwingConstants.BOTTOM) :
				retorno = MiniJavaConstants.BOTTOM;
		}
		return retorno;
	} 
	/**
     * Fornece o valor da propriedade <i>selected</i>, cuja funcionalidade �
     * definir se o bot�o dever� estar ou n�o selecionado.
     * 
     * @return <CODE>true</CODE> se o bot�o estiver selecionado,
     * <CODE>false</CODE> caso contr�rio.
     */	
	public boolean isSelected() {
		return this.absButton.isSelected();
	} 
	/**
     * Altera a propriedade <i>enabled</i>, que define
     * se o bot�o vai estar ativo ou n�o (pass�vel de clique);
     * se este n�o estiver ativo, n�o poder� executar nenhuma a��o.
     * 
     * @param b <CODE>boolean</CODE> que indicar� se o bot�o estar� ativo ou n�o.
     */	
	public void setEnabled(boolean b) {
		this.absButton.setEnabled(b);
	}
	/**
     * Altera a posi��o do alinhamento horizontal,
     * analogamente a um eixo cartesiano (cuja origem � o canto
     * superior esquerdo), fornece posi��o do alinhamento horizontal X.
     * 
     * @param alignment <CODE>Position</CODE> com o alinhamento horizontal.
     */
	public void setHorizontalAlignment(MiniJavaConstants.Position alignment) {
		if (alignment != null)
		this.absButton.setHorizontalAlignment(alignment.value());
	}
	/**
     * Altera a posi��o do alinhamento horizontal do texto,
     * analogamente a um eixo cartesiano (cuja origem � o canto
     * superior esquerdo), fornece a posi��o do alinhamento horizontal X
     * do texto.
     * 
     * @param textPosition <CODE>Position</CODE> com a posi��o horizontal do texto.
     */
	public void setHorizontalTextPosition(MiniJavaConstants.Position textPosition) {
		if (textPosition != null)
		this.absButton.setHorizontalTextPosition(textPosition.value());
	} 
	/**
     * Modifica  a propriedade <i>selected</i>, que 
     * define se o bot�o dever� estar ou n�o selecionado.
     * 
     * @param b <CODE>boolean</CODE> que indicar� 
     * se o bot�o estar� selecionado ou n�o.
     */		
	public void setSelected(boolean b) {
		this.absButton.setSelected(b);
	} 
	/**
     * Altera o texto do bot�o, logo � preciso indicar o novo
     * texto, passando-o como par�metro
     * 
     * @param text <CODE>String</CODE> com o texto do bot�o.
     */	
	public void setText(String text) {
		this.absButton.setText(text);
	} 
	/**
     * Altera a posi��o do alinhamento vertical,
     * analogamente a um eixo cartesiano (cuja origem � o canto
     * superior esquerdo), fornece posi��o do alinhamento vertical Y.
     * 
     * @param alignment <CODE>Position</CODE> com a posi��o do alinhamento vertical.
     */	
	public void setVerticalAlignment(MiniJavaConstants.Position alignment) {
		if (alignment != null)
		this.absButton.setVerticalTextPosition(alignment.value());
	} 
	/**
     * Altera a posi��o do alinhamento horizontal do texto,
     * analogamente a um eixo cartesiano (cuja origem � o canto
     * superior esquerdo), fornece a posi��o do alinhamento vertical X
     * do texto.
     * 
     * @param textPosition <CODE>Position</CODE> com a posi��o vertical do texto.
     */
	public void setVerticalTextPosition(MiniJavaConstants.Position textPosition) {
		if (textPosition != null)
		this.absButton.setVerticalTextPosition(textPosition.value());
	} 
	
	/**
	 * Adiciona o listener espec�fico para este tipo de objeto.
	 * 
	 *  @param listener <code>Listener</code> a ser adicionado.
	 * 
	 */
	//METODO DEFAULT PARA NAO APARECER NO JAVADOC
	void addListener(Listener listener) {
		if(listener instanceof ClickListener){
			this.addClickListener((ClickListener)listener);
		}
	}

}
