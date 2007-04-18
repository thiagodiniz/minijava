package br.ufpe.cin.miniJava.gui;

import br.ufpe.cin.miniJava.gui.listener.ClickListener;
import br.ufpe.cin.miniJava.gui.listener.Listener;

/**
 * Esta classe representa um menu com sub-itens.
 * 
 * <p align=center> 
 * <img border="0" src="../../../../../resources/MenuBar.gif">
 * </p>
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
public class Menu extends AbstractMenu implements ClickListener {
	
	private javax.swing.JMenu menu;
	private final String DEFAULT_TEXT = "Menu";
	
    /**
     * Cria um menu vazio (sem sub-itens).
     */
	public Menu() {
		super(new Component(new javax.swing.JMenu()));
		this.menu = (javax.swing.JMenu) this.getComponent();
		this.setText(DEFAULT_TEXT);
	} 
    /**
     * Cria um menu com um texto.
     * 
     * @param text texto a ser inicializado no menu.
     */
	public Menu(String text) {
		this();
		this.setText(text);
	}
    /**
     * Adiciona um <code>Menu</code> no fim deste menu.
     * 
     * @param menuItem <code>Menu</code> que ser� adicionado.
     */
	//NAO DEVE APARECER NA API, NESTA VERSAO
	void add(AbstractMenu menuItem) {
		this.menu.add(menuItem.getComponent());
		if (menuItem instanceof MenuItem) {
			MenuItem task = (MenuItem) menuItem;
			task.setParent(this.getParent());
		}
	} 
	/**
     * Insere um componente � janela, nas coordenadas desejadas.
     * 
     * A diferen�a entre este m�todo e o add, � o fato de que ao usar
     * include, o Component <code>comp</code> adiciona a janela
     * como novo ouvinte. <b>Lembre que voc� dever� incluir o MenuBar na Window,
     * ANTES de incluir este objeto na MenuBar.
     * 
     * @param comp <CODE>Component</CODE> que ser� adicionado e que
     * receber� um novo ouvinte.
     * 
     */
	public void include(AbstractMenu comp) {
		if (comp != null) {
			this.menu.add(comp.getComponent());
		}
		//isso eh ruim pq cria dependencia da superclasse 
		//em rela��o as subclasses
		//comp.addListener(this);
		
		//criamos uma terceira entidade com a responsabilidade
		//de conhecer as dependencias
		Component listener =  this.getParent();
		while(!(listener instanceof Window)){
			listener =  listener.getParent();
		}
		ListenerManager.addListenerTo((Listener)listener,comp);
	}
	/**
     * Cria um novo <code>MenuItem</code> com o texto especificado e
     * adiciona-o ao fim deste menu. 
     * 
     * @param s texto do novo <code>MenuItem</code> que ser� adicionado ao menu.
     */
	//NAO DEVE APARECER NA API AINDA
	public void include(String s) {
		MenuItem m = new MenuItem(s);
		this.include(m);
	} 	
    /**
     * Cria um novo <code>MenuItem</code> com o texto especificado e
     * adiciona-o ao fim deste menu. 
     * 
     * @param s texto do novo <code>MenuItem</code> que ser� adicionado ao menu.
     */
	//NAO DEVE APARECER NA API AINDA
	void add(String s) {
		this.menu.add(s);
	} 
    /**
     * Fornece o <code>sub-menu</code> localizado na posi��o especificada. 
     * 
     * @param pos posi��o do menu em que o <code>sub-menu</code> se encontra.
     * @return <code>sub-menu</code> na posi��o especificada.
     */	
	public AbstractMenu getItem(int pos) {
		java.awt.Component retorno = this.menu.getItem(pos);
		return (AbstractMenu) new Component(retorno);
	} 
    /**
     * Fornece o n�mero de itens inseridos neste menu. 
     * 
     * @return quantidade de itens deste menu.
     */	
	public int getItemCount() {
		return this.menu.getItemCount();
	} 
    /**
     * Fornece um array com os objetos inseridos neste menu (incluindo separadores). 
     * 
     * @return array de <code>AbstractMenu</code> (sub-itens ou sub-menus deste menu).
     */	
	public AbstractMenu[] getMenuComponents() {
		java.awt.Component retorno [] = this.menu.getMenuComponents();
		AbstractMenu[] retorno2 = new AbstractMenu[retorno.length];
		for (int i = 0; i < retorno2.length; i++) {
			retorno2[i] = (AbstractMenu) new Component(retorno[i]);
		}
		return retorno2;
	} 
    /**
     * Insere um sub-menu na posi��o indicada. 
     * 
     * @param mi <code>sub-menu</code> a ser inserido.
     * @param pos posi��o onde o <code>sub-menu</code> ser� inserido.
     */	
	public void insert(AbstractMenu mi, int pos) {
		this.menu.insert((javax.swing.JMenuItem) mi.getComponent(),pos);
	} 
    /**
     * Cria um novo <code>sub-menu</code> com o texto especificado e
     * adiciona-o na posi��o indicada. 
     * 
     * @param s texto do novo <code>sub-menu</code> que ser� adicionado ao menu.
     * @param pos posi��o onde o <code>sub-menu</code> ser� inserido.
     */
	//NAO DEVE APARECER NA API!!
	void insert(String s, int pos) {
		this.menu.insert(s,pos);
	} 
    /**
     * Insere um separador de menu na posi��o indicada.
     * O separador aparecer� ap�s a posi��o indicada, e caso haja menos elementos
     * que a quantidade passada como par�metro, o separador n�o ser� inserido. 
     * 
     * @param index posi��o onde o separador ser� inserido.
     */	
	public void insertSeparator(int index) {
		this.menu.insertSeparator(index);
	} 
	/**
	 * Verifica se este menu cont�m um determinado <code>sub-menu</code>. 
	 * 
	 * @param c <code>sub-menu</code> a ser verificado.
	 * @return <code>true</code> se o <code>sub-menu</code> estiver contido neste menu.
	 */
	public boolean contains(AbstractMenu c) {
		return this.menu.isMenuComponent(c.getComponent());
	} 
	/**
	 * Remove o <code>sub-menu</code> especificado deste menu.
	 * 
	 * @param c <code>sub-menu</code> a ser removido.
	 */
	public void remove(AbstractMenu c) {
		this.menu.remove(c.getComponent());
	} 
	/**
	 * Remove o <code>sub-menu</code> que estiver na posi��o especificada.
	 * 
	 * @param pos posi��o de onde se quer remover um <code>sub-menu</code>.
	 */
	public void remove(int pos) {
		this.menu.remove(pos);
	} 
	/**
	 * Remove todos os sub-itens e sub-menus deste menu.
	 */
	public void removeAll() {
		this.menu.removeAll();
	}
	/**
	 * Executa a verifica��o da a��o de clique.
	 * 
	 * @param component <code>Component</code> que ir� usar a a��o de clique.
	 */
	public void clickEvent(Component component) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Executa a verifica��o da a��o de clique.
	 * 
	 */	
	public void clickEvent() {
		// TODO Auto-generated method stub
		
	} 
}
