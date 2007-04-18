package br.ufpe.cin.miniJava.gui;

/**
 * Esta classe representa uma barra de progresso, um componente que
 * altera seu status de acordo com a execu��o de alguma tarefa.
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/ProgressBar.gif">
 * </p>
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
public class ProgressBar extends Component{
	
	private javax.swing.JProgressBar progressBar;
	private final int MIN_WIDTH = 150;
	private final int MIN_HEIGHT = 25;
	/**
	 *  Cria uma barra de progresso, com o valor m�nimo 0 e
	 *  o valor m�ximo 100.
	 */
	public ProgressBar() {
		super(new javax.swing.JProgressBar());
		this.progressBar = (javax.swing.JProgressBar) this.getComponent();
		this.progressBar.setSize(MIN_WIDTH,MIN_HEIGHT);
	}
	/**
	 * Cria uma barra de progresso com valores m�nimo e m�ximo
	 * de acordo com o especificado.
	 * 
	 * @param min valor m�nimo da barra.
	 * @param max valor m�ximo da barra.
	 */
	public ProgressBar(int min, int max) {
		this();
		this.progressBar.setMinimum(min);
		this.progressBar.setMaximum(max);
	}
	/**
	 * Fornece o valor m�ximo da barra.
	 * 
	 * @return o valor m�ximo da barra.
	 */
	public int getMaximum() {
		return this.progressBar.getMaximum();
	} 
	/**
	 * Fornece o valor m�nimo da barra.
	 * 
	 * @return o valor m�nimo da barra.
	 */	
	public int getMinimum() {
		return this.progressBar.getMinimum();
	} 
	/**
	 * Fornece o valor atual da barra.
	 * 
	 * @return o valor atual da barra.
	 */	
	public int getValue() {
		return this.progressBar.getValue();
	} 
	/**
     * Fornece o valor da propriedade <i>indeterminate</i>.
     * 
     * @return <code>true</code> se o valor m�ximo da barra n�o for
     * conhecido, ou seja, se o valor for <i>indeterminado</i>.
     */	
	public boolean isIndeterminate() {
		return this.progressBar.isIndeterminate();
	} 
	/**
     * Altera o valor da propriedade <i>indeterminate</i>.
     * 
     * @param newValue <code>boolean</code> que indicar� se o
     * valor m�ximo da barra n�o � conhecido, ou seja, se este
     * valor for <i>indeterminado</i>.
     */	
	public void setIndeterminate(boolean newValue) {
		this.progressBar.setIndeterminate(newValue);
	} 
	/**
	 * Altera o valor m�ximo da barra.
	 * 
	 * @param n novo valor m�ximo da barra.
	 */	
	public void setMaximum(int n) {
		this.progressBar.setMaximum(n);
	} 
	/**
	 * Altera o valor m�nimo da barra.
	 * 
	 * @param n novo valor m�nimo da barra.
	 */		
	public void setMinimum(int n) {
		this.progressBar.setMinimum(n);
	} 
	/**
	 * Altera o valor atual da barra.
	 * 
	 * @param n novo valor atual da barra.
	 */	
	public void setValue(int n) {
		this.progressBar.setValue(n);
	} 

}
