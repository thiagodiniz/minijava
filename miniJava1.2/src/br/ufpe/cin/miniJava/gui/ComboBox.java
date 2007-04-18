package br.ufpe.cin.miniJava.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import br.ufpe.cin.miniJava.gui.listener.ClickListener;
import br.ufpe.cin.miniJava.gui.listener.ItemStateListener;
import br.ufpe.cin.miniJava.gui.listener.Listener;

/**
 * Esta classe implementa um comboBox (uma lista com v�rios itens, onde apenas
 * um pode ser selecionado por vez).
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/ComboBox.gif">
 * </p>
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.2
 * @since 1.0
 */
public class ComboBox extends Component {

	private javax.swing.JComboBox comboBox;
	private final int MIN_WIDTH = 150;
	private final int MIN_HEIGHT = 30;
    /**
     * Cria um ComboBox vazio.
     */
	public ComboBox(){		
		super(new javax.swing.JComboBox());
		this.comboBox = (javax.swing.JComboBox) this.getComponent();
		this.comboBox.setSize(MIN_WIDTH,MIN_HEIGHT);
	}
    /**
     * Cria um ComboBox com v�rios itens, cada item representa 
     * uma op��o para o ComboBox.
     * 
     * @param items - array com os objetos a serem inseridos. 
     */
	public ComboBox(Object[] items){
		super(new javax.swing.JComboBox(items));
		this.comboBox = (javax.swing.JComboBox) this.getComponent();
		this.comboBox.setSize(MIN_WIDTH,MIN_HEIGHT);
	}
    /**
     * Adiciona um <CODE>ClickListener</CODE> ao ComboBox.
     * 
     * @param clickListener <CODE>clickListener</CODE> que conter�
     * a a��o que o comboBox dever� executar ao ser clicado
     */
	//DEFAULT PARA NAO APARECER NESTA VERSAO DE MINIJAVA!
	void addClickListener(ClickListener clickListener) {
		class TempActionListener implements ActionListener{
			private ClickListener actionListener;
			TempActionListener(ClickListener actionListenter){
				this.actionListener = actionListenter;
			}
			public void actionPerformed(ActionEvent actionEvent) {
				this.actionListener.clickEvent(ComboBox.this);
				this.actionListener.clickEvent();
			}
		}
		TempActionListener actionListener = new TempActionListener(clickListener);
		this.comboBox.addActionListener(actionListener);
	}
    /**
     * Adiciona um <CODE>ItemStateListener</CODE> ao ComboBox.
     * 
     * @param itemStateListener <CODE>ItemStateListener</CODE> que conter�
     * a a��o que o comboBox dever� executar ao trocar de status.
     */
	//DEFAULT PARA NAO APARECER NESTA VERSAO
	void addItemStateListener(ItemStateListener itemStateListener){
		class TempItemStateListener implements ItemListener{
			private ItemStateListener itemStateListener;
			TempItemStateListener(ItemStateListener itemStateListener){
				this.itemStateListener = itemStateListener;
			}
			
			public void itemStateChanged(ItemEvent e) {
				this.itemStateListener.stateEvent(ComboBox.this);
				this.itemStateListener.stateEvent();
			}
			
		}
		TempItemStateListener tempItemStateListener = new TempItemStateListener(itemStateListener);
		this.comboBox.addItemListener(tempItemStateListener);
	}
    /**
     *Insere um objeto no comboBox, ou seja o ComboBox
     *ganhar� mais uma op��o.
     * 
     * @param anObject o objeto que ser� inserido no comboBox
     */	
	public void addItem(Object anObject) {
		this.comboBox.addItem(anObject);
	} 
    /**
     * Fornece o objeto que est� na posi��o <i>index</i> do ComboBox,
     * se voc� tem n objetos o primeiro ter� indice 0 e
     * o �ltimo ter� �ndice n-1, logo n�o existe �ndice n. 
     * 
     * @param index posi��o do comboBox a ser procurada.
     * @return objeto que est� na posi��o <i>index</i>.
     */			
	public Object getItemAt(int index) {
		return this.comboBox.getItemAt(index);
	} 
    /**
     * Fornece o n�mero de itens no ComboBox, ou seja 
     * quantas op��es o mesmo vai ter.
     * 
     * @return n�mero de itens no ComboBox.
     */			
	public int getItemCount() {
		return this.comboBox.getItemCount();
	} 
	/**
     * Fornece o n�mero m�ximo de linhas.
     * 
     * @return n�mero m�ximo de linhas do ComboBox.
     */
	public int getMaximumRowCount() {
		return this.comboBox.getMaximumRowCount();
	} 
	/**
     * Fornece a posi��o do item que est� selecionado, se
     * o �ltimo de n itens esta selecionado ele retorna
     * n-1, por exemplo.
     * 
     * @return posi��o do item selecionado no ComboBox.
     */
	public int getSelectedIndex() {
		return this.comboBox.getSelectedIndex();
	} 
	/**
     * Fornece o item que est� selecionado, ou seja, retorna o objeto
     * que est� selecionado no ComboBox
     * 
     * @return item selecionado no ComboBox.
     */
	public Object getSelectedItem() {
		return this.comboBox.getSelectedItem();
	} 
	/**
     * Caso for permitida m�ltipla sele��o, fornece um array de itens que
     * est�o selecionados, ao inv�s de um item s� apenas
     * 
     * @return array de objetos selecionados.
     */
	public Object[] getSelectedObjects() {
		return this.comboBox.getSelectedObjects();
	} 
	/**
     * Insere um item na posi��o <i>index</i>.
     * 
     * @param anObject objeto a ser inserido.
     * @param index posicao na qual o objeto ser� inserido.
     */
	public void insertItemAt(Object anObject, int index) {
		this.comboBox.insertItemAt(anObject, index);
	} 
	/**
     * Fornece a propriedade <i>editable</i>, que indica se o ComboBox
     * poder� ser editado ou n�o.
     * 
     * @return <CODE>true</CODE> se o comboBox for edit�vel.
     */
	public boolean isEditable() {
		return this.comboBox.isEditable();
	} 
	/**
     * Remove todos os itens do ComboBox.
     */
	public void removeAllItems() {
		this.comboBox.removeAllItems();
	} 
	/**
     * Remove o item passado como par�metro do ComboBox.
     * 
     * @param anObject objeto a ser removido do ComboBox.
     */	
	public void removeItem(Object anObject) {
		this.comboBox.removeItem(anObject);
	} 
	/**
     * Remove o item que est� na posi��o <i>anIndex</i>.
     * 
     * @param anIndex posi��o na qual objeto ser� removido.
     */	
	public void removeItemAt(int anIndex) {
		this.comboBox.removeItemAt(anIndex);
	} 
	/**
     * Altera a propriedade <i>editable</i> do ComboBox, que indica
     * se o ComboBox poder� ser editado ou n�o.
     * 
     * @param aFlag <CODE>boolean</CODE> que indicar� se o comboBox
     * poder� ser editado ou n�o.
     */
	public void setEditable(boolean aFlag) {
		this.comboBox.setEditable(aFlag);
	} 
	/**
     * Altera a propriedade <i>enabled</i>, que define se o ComboBox
     * est� ativo ou n�o.
     * 
     * @param b <CODE>boolean</CODE> que indicar� se o comboBox
     * est� ativo ou n�o.
     */	
	public void setEnabled(boolean b) {
		this.comboBox.setEnabled(b);
	} 
	/**
     * Altera o n�mero m�ximo de linhas deste ComboBox.
     * 
     * @param count n�mero m�ximo de linhas do ComboBox.
     */
	public void setMaximumRowCount(int count) {
		this.comboBox.setMaximumRowCount(count);
	} 
	/**
     * Altera a posi��o a ser selecionada.
     * 
     * @param anIndex nova posi��o a ser selecionada.
     */
	public void setSelectedIndex(int anIndex) {
		this.comboBox.setSelectedIndex(anIndex);
	} 
	/**
     * Altera o item a ser selecionado.
     * 
     * @param anObject item a ser selecionado.
     */
	public void setSelectedItem(Object anObject) {
		this.comboBox.setSelectedItem(anObject);
	} 
	/**
	 * Adiciona o listener espec�fico para este tipo de objeto.
	 * 
	 *  @param listener <code>Listener</code> a ser adicionado.
	 * 
	 */
	//DEFAULT PARA NAO APARECER NA API!!
	void addListener(Listener listener) {
		if(listener instanceof ItemStateListener) {
			this.addItemStateListener((ItemStateListener) listener);
		}
		if (listener instanceof ClickListener) {
			this.addClickListener((ClickListener) listener);
		}
	}

}
