package br.ufpe.cin.miniJava.gui;
import javax.swing.SwingConstants;

/**
 * Esta classe representa um campo de texto, um componente de uma linha apenas
 * onde pode-se inserir texto.
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/TextField.gif">
 * </p>
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
public class TextField extends AbstractText {

	private javax.swing.JTextField textField;
	private final int MIN_WIDTH = 120;
	private final int MIN_HEIGHT = 20;
	
	/**
	 * Cria um campo de texto vazio, com n�mero de colunas igual a 0.
	 *
	 */
	public TextField() {
		super(new Component(new javax.swing.JTextField()));
		this.textField = (javax.swing.JTextField) this.getComponent();
		this.textField.setSize(MIN_WIDTH,MIN_HEIGHT);
	}
	/**
	 * Cria um novo campo de texto com o n�mero de colunas especificado.
	 * 
	 * @param columns n�mero de colunas.
	 */
	public TextField(int columns) {
		this();
		this.textField.setColumns(columns);
	}
	/**
	 * Cria um novo campo de texto com um texto j� inserido.
	 * 
	 * @param text texto inicial do <code>TextField</code>.
	 */
	public TextField(String text) {
		this();
		this.textField.setText(text);
	}
	/**
	 * Cria um novo campo de texto com um texto j� inserido,
	 * e com um n�mero de colunas definido.
	 * 
	 * @param text texto inicial do <code>TextField</code>.
	 * @param columns n�mero de colunas.
	 */
	public TextField(String text, int columns) {
		this(text);
		this.textField.setColumns(columns);
	}
	/**
	 * Fornece o n�mero de colunas do <code>TextField</code>.
	 * 
	 * @return n�mero de colunas.
	 */
	public int getColumns() {
		return this.textField.getColumns();
	} 
	/**
     * Fornece a posi��o do alinhamento horizontal.
     * 
     * @return <CODE>Position</CODE> com o alinhamento horizontal, podendo ser uma das
     * seguintes constantes definidas em MiniJavaConstants:<p>
     * <ul>
     * <li>LEFT</li><li>CENTER</li><li>RIGHT</li>
     * <li>LEADING</li><li>TRAILING</li>
     * </ul>
     */
	public MiniJavaConstants.Position getHorizontalAlignment() {
		int pos = this.textField.getHorizontalAlignment();
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
	 * Altera o n�mero de colunas do <code>TextField</code>.
	 * 
	 * @param columns novo n�mero de colunas.
	 */
	public void setColumns(int columns) {
		this.textField.setColumns(columns);
	}
	/**
     * Altera a posi��o do alinhamento horizontal.
     * 
     * @param alignment <CODE>Position</CODE> com o alinhamento horizontal,
     * podendo ser uma das seguintes constantes definidas em MiniJavaConstants:<p>
     * <ul>
     * <li>LEFT</li><li>CENTER</li><li>RIGHT</li>
     * <li>LEADING</li><li>TRAILING</li>
     * </ul>     
     */
	public void setHorizontalAlignment(MiniJavaConstants.Position alignment) {
		if (alignment != null)
		this.textField.setHorizontalAlignment(alignment.value());
	}

}
