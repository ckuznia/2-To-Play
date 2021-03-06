package twotoplay.state;

import org.newdawn.slick.Color;

public class ColorUnit {

	private int x, y, width, height;
	private Color color;
	private boolean conformer;
	
	public ColorUnit(int x, int y, int width, int height, Color color, boolean conformer) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.conformer = conformer;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean isConformer() {
		return conformer;
	}
	
	public void setConformer(boolean value) {
		conformer = value;
	}
}
