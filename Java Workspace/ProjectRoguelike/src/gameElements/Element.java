package gameElements;

import javax.swing.ImageIcon;

import auxilary.Vector2;

public abstract class Element {
	
	protected final ImageIcon[] icons = {new ImageIcon(getClass().getResource("Fliese" + ".png"))};
	protected final int id = 0;

	protected ImageIcon icon = icons[0];
	public Vector2 coords;
	
	public Element(int x, int y) {
		this.coords = new Vector2(x, y);
	}
	public Element(Vector2 coords) {
		this.coords = coords;
	}
	
	public ImageIcon setIcon(int iconIndex) {
		this.icon = icons[iconIndex];
		return this.icon;
	}
	
	public ImageIcon getIcon() {
		return this.icon;
	}
	
	public int getID() {
		return this.id;
	}
	
}
