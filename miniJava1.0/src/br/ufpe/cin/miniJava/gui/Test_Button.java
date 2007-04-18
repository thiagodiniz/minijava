package br.ufpe.cin.miniJava.gui;

import junit.framework.TestCase;

class Test_Button extends TestCase {

	private Button botao;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.botao = new Button();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		this.botao = null;
	}

	/*
	 * Test method for 'br.ufpe.cin.miniJava.gui.Button.Button()'
	 */
	public void testButton() {
		Button temp = new Button();
		int minWidth = 200;
		int minHeight = 200;
				
		assertEquals("O bot�o n�o est� inicializando com sua largura m�nima:\n",
				minWidth,temp.getWidth());
		
		assertEquals("O bot�o n�o est� inicializando com sua altura m�nima:\n",
				minHeight,temp.getHeight());
		
		assertEquals("O texto padr�o do bot�o n�o est� sendo inicializado:\n",
				"OK",temp.getText());
		

	}

	/*
	 * Test method for 'br.ufpe.cin.miniJava.gui.Button.Button(String)'
	 */
	public void testButtonString() {
		Button temp = new Button("Testar string");
		botao.setText("Testar string");
		assertEquals("Dois bot�es s�o iguais apenas se possuirem a mesma refer�ncia\n",
				botao,botao);
		assertNotSame("Dois bot�es s�o iguais apenas se possuirem a mesma refer�ncia",
				temp);
		
	}

}
