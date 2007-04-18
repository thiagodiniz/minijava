package br.ufpe.cin.miniJava.gui;


import javax.swing.JScrollPane;
import javax.swing.text.JTextComponent;

import br.ufpe.cin.miniJava.exception.InvalidConversionException;

/**
 * Esta classe abstrata implementa funcionalidades que componentes de texto
 * poder�o ter, como copiar, colar, alterar sele��o, editar, etc.
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
abstract class AbstractText extends Component {
			
	private javax.swing.text.JTextComponent textComponent;
    /**
     * Cria um componente de texto.
     * 
     * @param component <CODE>Component</CODE> que indicar� qual ser� o
     * tipo do <code>AbstractText</code>.
     */
	AbstractText(Component component) {
		super(component.getComponent());
		java.awt.Component temp = this.getComponent();
		if (temp instanceof JScrollPane) {
			this.textComponent = (JTextComponent) ((JScrollPane) temp).getViewport().getView();
		} else {
			this.textComponent = (javax.swing.text.JTextComponent) this.getComponent();	
		}
	} 
	/**
	 * Copia o texto selecionado para a �rea de transfer�ncia.
	 *
	 */
	public void copy() {
		if (this.textComponent.getSelectedText() == null) {
			this.textComponent.selectAll();
		}
		this.textComponent.copy();
	}
	/**
	 * Recorta o texto selecionado para a �rea de transfer�ncia,
	 * apagando-o do <code>AbstractText</code>.
	 *
	 */
	public void cut() {
		if (this.textComponent.getSelectedText() == null) {
			this.textComponent.selectAll();
		}
		this.textComponent.cut();
	} 
	/**
	 * Fornece o texto que est� selecionado no <code>AbstractText</code>.
	 * 
	 * @return texto selecionado.
	 */
	public String getSelectedText() {
		return this.textComponent.getSelectedText();
	} 
	/**
	 * Fornece um <code>int</code> com o valor do <code>AbstractText</code>.
	 * 
	 * @return <code>int</code> com o valor do <code>AbstractText</code>.
	 */
	public int getInt() {
		int retorno = -1;
		String temp = this.textComponent.getText();
		try {
			retorno = Integer.parseInt(temp);			
		} catch (NumberFormatException e) {
			/*
			 * N�o eh legal q isso apare�a
			 * 
			 * System.err.println("Falha ao tentar converter de String para double.");
			 */
		}
		return retorno;
	}	
	/**
	 * Altera o texto do objeto com o <code>int</code> informado.
	 * 
	 * @param value <code>int</code> com o valor do <code>AbstractText</code>.
	 */
	public void setInt(int value) {
		this.textComponent.setText(value + "");
	}
	/**
	 * Altera o texto do objeto com o <code>double</code> informado.
	 * 
	 * @param value <code>double</code> com o valor do <code>AbstractText</code>.
	 */
	public void setDouble(double value) {
		this.textComponent.setText(value + "");
	}	
	/**
	 * Fornece um <code>int</code> com o valor do <code>AbstractText</code>.
	 * 
	 * Caso o texto localizado no <code>AbstractText</code> n�o for reconhecido como um <code>int</code>,
	 * uma <code>InvalidConversionException</code> ser� lan�ada.
	 * 
	 * @return <code>int</code> com o valor do <code>AbstractText</code>.
	 * @throws InvalidConversionException se o valor n�o puder ser convertido.
	 */
	public int getIntExc() throws InvalidConversionException {
		int retorno = -1;
		String temp = this.textComponent.getText();
		try {
			retorno = Integer.parseInt(temp);			
		} catch (NumberFormatException e) {
			throw new InvalidConversionException("Falha ao tentar converter de String para int.",e);
		}
		return retorno;
	}
	/**
	 * Fornece um <code>double</code> com o valor do <code>AbstractText</code>.
	 * 
	 * @return <code>double</code> com o valor do <code>AbstractText</code>.
	 */
	public double getDouble() {
		double retorno = -1.0;
		String temp = this.textComponent.getText();
		try {
			retorno = Float.parseFloat(temp);			
		} catch (NumberFormatException e) {
			/*
			 * N�o eh legal q isso apare�a
			 * 
			 * System.err.println("Falha ao tentar converter de String para double.");
			 */
		}
		return retorno;
	}
	/**
	 * Fornece um <code>double</code> com o valor do <code>AbstractText</code>.
	 * 
	 * Caso o texto localizado no <code>AbstractText</code> n�o for reconhecido como um <code>double</code>,
	 * uma <code>InvalidConversionException</code> ser� lan�ada.
	 * 
	 * @return <code>double</code> com o valor do <code>AbstractText</code>.
	 * @throws InvalidConversionException se o valor n�o puder ser convertido.
	 */
	public double getDoubleExc() throws InvalidConversionException {
		double retorno = -1;
		String temp = this.textComponent.getText();
		try {
			retorno = Float.parseFloat(temp);			
		} catch (NumberFormatException e) {
			throw new InvalidConversionException("Falha ao tentar converter de String para double.",e);
		}
		return retorno;
	}
	/**
	 * Fornece todo o texto do <code>AbstractText</code>.
	 * 
	 * @return texto do <code>AbstractText</code>.
	 */
	public String getText() {
		return this.textComponent.getText();
	} 
	/**
	 * Indica se o <code>AbstractText</code> � edit�vel ou n�o.
	 * 
	 * @return <code>true</code> se o <code>AbstractText</code> for edit�vel.
	 */
	public boolean isEditable() {
		return this.textComponent.isEditable();
	} 
	/**
	 * Cola o conte�do da �rea de transfer�ncia no <code>AbstractText</code>.
	 */
	public void paste() {
		this.textComponent.paste();
	}
	/**
	 * Substitui o texto selecionado pelo texto passado como par�metro.
	 * 
	 * @param content novo texto.
	 */
	public void replaceSelection(String content) {
		this.textComponent.replaceSelection(content);
	} 
	/**
	 * Seleciona todo o texto do <code>AbstractText</code>.
	 *
	 */
	public void selectAll() {
		this.textComponent.selectAll();
	} 
	 /**
	  * Altera a propriedade <code>editable</code> do <code>AbstractText</code>.
	  * 
	  * @param b <code>boolean</code> que indicar� se o <code>AbstractText</code>
	  * poder� ser editado ou n�o.
	  */
	public void setEditable(boolean b) {
		this.textComponent.setEditable(b);
	}
	 /**
	  * Altera o texto do <code>AbstractText</code>.
	  * 
	  * @param t novo texto.
	  */
	public void setText(String t) {
		this.textComponent.setText(t);
	}
	
}
