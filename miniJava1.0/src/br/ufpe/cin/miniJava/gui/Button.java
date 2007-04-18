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
 * @version 1.0
 * @since 1.0
 */
public class Button extends AbstractButton {

	private javax.swing.JButton button;
	private final int MIN_WIDTH = 100;
	private final int MIN_HEIGHT = 40;
	private final String DEFAULT_TEXT = "OK";

    /**
     * Cria um bot�o com o texto padr�o "<i>OK</i>".
     */
	public Button(){		
		super(new Component(new javax.swing.JButton()));
		this.button = (javax.swing.JButton) this.getComponent();
		this.button.setSize(MIN_WIDTH,MIN_HEIGHT);
		this.button.setText(DEFAULT_TEXT);
	}
	
    /**
     * Cria um bot�o com um texto espec�fico.
     * 
     * @param text {@link java.lang.String} que ir� aparecer na frente do bot�o.
     */
	public Button(String text){		
		this();
		this.button.setText(text);
	}
	
}
