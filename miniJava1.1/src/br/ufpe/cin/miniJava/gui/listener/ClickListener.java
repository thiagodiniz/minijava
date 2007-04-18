package br.ufpe.cin.miniJava.gui.listener;

import br.ufpe.cin.miniJava.gui.Component;


/**
 * Esta interface descreve o m�todo que um ouvinte de clique deve ter.
 * 
 * Um ouvinte de clique � utilizado para informar o que deve ser feito
 * num componente na hora em que ele for clicado.
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
public interface ClickListener extends Listener{
	/**
	 * Executa a verifica��o da a��o de clique.
	 * 
	 * @param component <code>Component</code> que ir� usar a a��o de clique.
	 */
	public void clickEvent(Component component);
	/**
	 * Executa a verifica��o da a��o de clique.
	 * 
	 */
	public void clickEvent();

}
