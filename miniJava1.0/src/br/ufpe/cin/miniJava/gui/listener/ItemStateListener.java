package br.ufpe.cin.miniJava.gui.listener;

import br.ufpe.cin.miniJava.gui.Component;


/**
 * Esta interface descreve o m�todo que um ouvinte de mudan�a de estado deve ter.
 * 
 * Um ouvinte de mudan�a de estado � utilizado para informar o que deve ser feito
 * num componente na hora em que seu estado for alterado.
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
public interface ItemStateListener extends Listener {
	/**
	 * Executa a verifica��o da mudan�a de estado.
	 * 
	 * @param component <code>Component</code> que ir� usar a mudan�a de estado.
	 */
	public void stateEvent(Component component);
	/**
	 * Executa a verifica��o da mudan�a de estado.
	 * 
	 */
	public void stateEvent();
}
