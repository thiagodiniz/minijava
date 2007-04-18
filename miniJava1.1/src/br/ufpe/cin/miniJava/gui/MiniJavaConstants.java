package br.ufpe.cin.miniJava.gui;

		
import javax.swing.SwingConstants;
/**
 * Esta interface cont�m as constantes necess�rias para
 * posicionamento, dire��o e orienta��o dos componentes
 * 
 * @author Bruno Barros (blbs)
 * @author Luiz Carlos d'Oleron (lcadb)
 * @version 1.0
 * @since 1.0
 */
public interface MiniJavaConstants {
	
	//verticais
	/** Posi��o vertical e/ou horizontal - meio do componente*/
	public static final Position CENTER = Position.CENTER;
	/** Posi��o vertical - parte superior do componente*/
	public static final Position TOP = Position.TOP;
	/** Posi��o vertical - parte inferior do componente*/
	public static final Position BOTTOM = Position.BOTTOM;
	
	//horizontais
	/** Posi��o horizontal - alinhamento � esquerda*/
	public static final Position LEFT = Position.LEFT;
	/** Posi��o horizontal - alinhamento � direita*/
	public static final Position RIGHT = Position.RIGHT;
	/** Posi��o horizontal - alinhamento com a borda externa*/
	public static final Position LEADING = Position.LEADING;
	/** Posi��o horizontal - alinhamento com a borda interna*/
	public static final Position TRAILING = Position.TRAILING;
	
	/** Dire��o - N (acima) */
	public static final Direction NORTH = Direction.NORTH;
	/** Dire��o - NE (direita acima) */
	public static final Direction NORTH_EAST = Direction.NORTH_EAST;
	/** Dire��o - E (direita) */
	public static final Direction EAST = Direction.EAST;
	/** Dire��o - SE (direita abaixo) */
	public static final Direction SOUTH_EAST = Direction.SOUTH_EAST;
	/** Dire��o - S (abaixo) */
	public static final Direction SOUTH = Direction.SOUTH;
	/** Dire��o - SW (esquerda abaixo) */
	public static final Direction SOUTH_WEST = Direction.SOUTH_EAST;
	/** Dire��o - W (esquerda) */
	public static final Direction WEST = Direction.WEST;
	/** Dire��o - NW (esquerda acima) */
	public static final Direction NORTH_WEST = Direction.NORTH_WEST;

	/** Orienta��o - Indica posi��o horizontal */
	public static final Orientation HORIZONTAL = Orientation.HORIZONTAL;
	/** Orienta��o - Indica posi��o vertical */
	public static final Orientation VERTICAL = Orientation.VERTICAL;
	
	enum Position {

	    CENTER(SwingConstants.CENTER),
	    TOP(SwingConstants.TOP),
	    LEFT(SwingConstants.LEFT),
		RIGHT(SwingConstants.RIGHT),
	    BOTTOM(SwingConstants.BOTTOM),
	    LEADING(SwingConstants.LEADING),
		TRAILING(SwingConstants.TRAILING);

		private final int value;
	        
	    Position (int pos) {
	        this.value = pos;
	    }
	    
	    int value() { return this.value; }
	    
	}

	enum Direction {

		NORTH(SwingConstants.NORTH),
		NORTH_EAST(SwingConstants.NORTH_EAST),
		EAST(SwingConstants.EAST),
		SOUTH_EAST(SwingConstants.SOUTH_EAST),
		SOUTH(SwingConstants.SOUTH),
		SOUTH_WEST(SwingConstants.SOUTH_WEST),
		WEST(SwingConstants.WEST),
		NORTH_WEST(SwingConstants.NORTH_WEST);
		
		private final int value;
	        
	    Direction (int pos) {
	        this.value = pos;
	    }
	    
	    int value() { return this.value; }
	    
	}

	enum Orientation {

	    HORIZONTAL(SwingConstants.HORIZONTAL),
	    VERTICAL(SwingConstants.VERTICAL);

		private final int value;
	        
	    Orientation (int pos) {
	        this.value = pos;
	    }
	    
	    int value() { return this.value; }
	}
	
}




