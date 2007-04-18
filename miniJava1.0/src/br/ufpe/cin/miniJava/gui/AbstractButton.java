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
 * @version 1.0
 * @since 1.0
 */
abstract class AbstractButton extends Component {

	private javax.swing.AbstractButton absButton;
	
    /**
     * Cria um bot�o abstrato
     * 
     * @param component <CODE>Component</CODE> que indicar� qual ser� o
     * tipo do bot�o abstrato.
     */
	AbstractButton(Component component){		
		super(component.getComponent());
		this.absButton = (javax.swing.AbstractButton) this.getComponent();
	}
    /**
     * Adiciona um <CODE>ClickListener</CODE> ao bot�o abstrato.
     * 
     * @param clickListener <CODE>clickListener</CODE> que conter�
     * a a��o que o bot�o dever� executar ao ser clicado
     */	
	//o m�todo est� default para N�O APARECER NA API!!!!
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
     * Efetua um clique no objeto, tendo o mesmo efeito do clique do mouse neste objeto.
     */		
	public void doClick() {
		this.absButton.doClick();
	}
	/**
     * Fornece a posi��o do alinhamento horizontal.
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
     * Fornece a posi��o horizontal do texto.
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
     * Fornece o texto do bot�o.
     * 
     * @return <CODE>String</CODE> com o texto do bot�o.
     */	
	public String getText() {
		return this.absButton.getText();
	}
	/**
     * Fornece a posi��o do alinhamento vertical.
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
     * Fornece a posi��o vertical do texto.
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
     * Fornece a propriedade <i>selected</i>.
     * 
     * @return <CODE>true</CODE> se o bot�o estiver selecionado.
     */	
	public boolean isSelected() {
		return this.absButton.isSelected();
	} 
	/**
     * Altera a propriedade <i>enabled</i>.
     * 
     * @param b <CODE>boolean</CODE> que indicar� 
     * se o bot�o estar� ativo ou n�o.
     */	
	public void setEnabled(boolean b) {
		this.absButton.setEnabled(b);
	}
	/**
     * Altera a posi��o do alinhamento horizontal.
     * 
     * @param alignment <CODE>Position</CODE> com o alinhamento horizontal.
     */
	public void setHorizontalAlignment(MiniJavaConstants.Position alignment) {
		if (alignment != null)
		this.absButton.setHorizontalAlignment(alignment.value());
	}
	/**
     * Altera a posi��o horizontal do texto.
     * 
     * @param textPosition <CODE>Position</CODE> com a posi��o horizontal do texto.
     */
	public void setHorizontalTextPosition(MiniJavaConstants.Position textPosition) {
		if (textPosition != null)
		this.absButton.setHorizontalTextPosition(textPosition.value());
	} 
	/**
     * Altera a propriedade <i>selected</i>.
     *
     * @param b <CODE>boolean</CODE> que indicar� 
     * se o bot�o estar� selecionado ou n�o.
     */		
	public void setSelected(boolean b) {
		this.absButton.setSelected(b);
	} 
	/**
     * Altera o texto do bot�o.
     * 
     * @param text <CODE>String</CODE> com o texto do bot�o.
     */	
	public void setText(String text) {
		this.absButton.setText(text);
	} 
	/**
     * Altera a posi��o do alinhamento vertical.
     * 
     * @param alignment <CODE>Position</CODE> com a posi��o do alinhamento vertical.
     */	
	public void setVerticalAlignment(MiniJavaConstants.Position alignment) {
		if (alignment != null)
		this.absButton.setVerticalTextPosition(alignment.value());
	} 
	/**
     * Altera a posi��o vertical do texto.
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
