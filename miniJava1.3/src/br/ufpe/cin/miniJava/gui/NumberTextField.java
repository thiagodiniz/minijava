package br.ufpe.cin.miniJava.gui;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Esta classe representa um campo de n�meros, um componente de uma linha apenas
 * onde pode-se inserir n�meros. Caso tente-se inserir algum caractere n�o-num�rico
 * num campo de n�mero, ele vai levantar uma exce��o.
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/TextField.gif">
 * </p>
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.2
 * @since 1.0
 */
public class NumberTextField extends TextField {

	/**
	 * Cria um campo de n�meros vazio, com tamanho padr�o de 120 x 20;
	 *
	 */
	public NumberTextField() {
		super();
		this.naoPodeOutroCaracter();
	}

	private void naoPodeOutroCaracter() {
		class TempListener implements KeyListener{
			public void keyPressed(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {
				char value = arg0.getKeyChar();
				if (!((value < ' ') || (value == '.') ||
				((value >= '0') && (value <= '9')))) {
					throw new RuntimeException("Este TextField recebe apenas inteiros");
				}  
			}
		}
		TempListener listener = new TempListener();
		this.getComponent().addKeyListener(listener);
	}
	
	/**
	 * Cria um novo campo de n�meros com um valor j� inserido.
	 * 
	 * @param text valor inicial do <code>TextField</code>.
	 */
	public NumberTextField(int text) {
		this();
		this.setText(text + "");
	}
}
