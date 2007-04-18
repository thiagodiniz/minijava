package br.ufpe.cin.miniJava.gui;

/**
 * Esta classe implementa um bot�o comum.
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/Button.gif">
 * </p>
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.2
 * @since 1.0
 */
public class Button extends AbstractButton {

	private javax.swing.JButton button;
	private final int MIN_WIDTH = 100;
	private final int MIN_HEIGHT = 40;
	private final String DEFAULT_TEXT = "OK";

    /**
     * Cria um bot�o com o texto padr�o "<i>OK</i>", com o tamanho padr�o
     * de 100 x 40 pixels
     */
	public Button(){		
		super(new Component(new javax.swing.JButton()));
		this.button = (javax.swing.JButton) this.getComponent();
		this.button.setSize(MIN_WIDTH,MIN_HEIGHT);
		this.button.setText(DEFAULT_TEXT);
	}
	
    /**
     * Cria um bot�o com um texto espec�fico, logo deve-se
     * indicar este texto no construtor do m�todo.
     * 
     * @param text <code>String</code> que ir� aparecer na frente do bot�o.
     */
	public Button(String text){		
		this();
		this.button.setText(text);
	}
	
}
