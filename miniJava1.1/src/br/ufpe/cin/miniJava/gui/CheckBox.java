package br.ufpe.cin.miniJava.gui;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import br.ufpe.cin.miniJava.gui.listener.ClickListener;
import br.ufpe.cin.miniJava.gui.listener.ItemStateListener;
import br.ufpe.cin.miniJava.gui.listener.Listener;
/**
 * Esta classe implementa um checkbox (um tipo de bot�o que pode ser
 * marcado ou n�o).
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/CheckBox.gif">
 * </p>
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
public class CheckBox extends AbstractButton {

	private javax.swing.JCheckBox checkBox; 
	private final int MIN_WIDTH = 100;
	private final int MIN_HEIGHT = 30;
	private final String DEFAULT_TEXT = "";
	/**
     * Cria um checkbox desmarcado, sem texto, e este � criado com
     * um tamanho padr�o de 100 x 30.
     *
     */
	public CheckBox(){		
		super(new Component(new javax.swing.JCheckBox()));
		this.checkBox = (javax.swing.JCheckBox) this.getComponent();
		this.checkBox.setSize(MIN_WIDTH,MIN_HEIGHT);
		this.checkBox.setText(DEFAULT_TEXT);
	}
    /**
     * Cria um checkbox com um texto, assim surgir� uma caixa desmarcada
     * com o texto <CODE>String</CODE> passado por par�metro.
     *
     * @param text <CODE>String</CODE> com o texto do CheckBox. 
     */
	public CheckBox(String text){		
		this();
		this.setText(text);
	}
	/**
     * Cria um CheckBox com um texto, assim surgir� uma caixa com
    * o texto <CODE>String</CODE> passado por par�metro, marcada
    * ou n�o, a depender do <CODE>boolean</CODE> passado como 
    *par�metro.
    *
    * @param text <CODE>String</CODE> com o texto do CheckBox
    * @param selected <CODE>boolean</CODE> que indicar� se o CheckBox
    * dever� estar selecionado ou n�o.   
    */
	public CheckBox(String text, boolean selected) {
		this(text);
		this.setSelected(selected);
	}
    /**
     * Adiciona um <CODE>ItemStateListener</CODE> ao CheckBox,
     * ou seja, quando o estado mudar de marcado/n�o-marcado ou 
     * n�o-marcado/marcado uma definida a��o ser� executada.
     * 
     * @param itemStateListener <CODE>ItemStateListener</CODE> que conter�
     * a a��o que o checkBox dever� executar ao trocar de status.
     */	
	//metodo default para n�o aparecer na API!
	void addItemStateListener(ItemStateListener itemStateListener){
		class TempItemStateListener implements ItemListener{
			private ItemStateListener itemStateListener;
			TempItemStateListener(ItemStateListener itemStateListener){
				this.itemStateListener = itemStateListener;
			}
			
			public void itemStateChanged(ItemEvent e) {
				this.itemStateListener.stateEvent(CheckBox.this);
				this.itemStateListener.stateEvent();
			}
			
		}
		TempItemStateListener tempItemStateListener = new TempItemStateListener(itemStateListener);
		this.checkBox.addItemListener(tempItemStateListener);
	}
	/**
	 * Adiciona o listener espec�fico para este tipo de objeto.
	 * 
	 *  @param listener <code>Listener</code> a ser adicionado.
	 * 
	 */
	//METODO DEFAULT PARA NAO APARECER NO JAVADOC
	void addListener(Listener listener) {
		if(listener instanceof ItemStateListener) {
			this.addItemStateListener((ItemStateListener) listener);
		}
		if (listener instanceof ClickListener) {
			this.addClickListener((ClickListener) listener);
		}
	}

}
