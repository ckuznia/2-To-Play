package twotoplay.state;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState {

	private final int 
		X = 0,
		Y = 0,
		SIZE = 4,
		WIDTH = 800 / SIZE,
		HEIGHT = 600 / SIZE;
	
	private ColorUnit[][] colorUnits = new ColorUnit[WIDTH][HEIGHT];
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// Setting up information for the squares
		for(int x = 0; x < colorUnits.length ; x++) for(int y = 0; y < colorUnits[0].length ; y++) {
			int r = 255;
			int g = 255;
			int b = 255;
			
			colorUnits[x][y] = new ColorUnit(x * SIZE + X, y * SIZE + Y, SIZE, SIZE, new Color(r, g, b), true);
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawString("Play", 100, 100);
		
		// Rendering the squares
		for(int x = 0; x < colorUnits.length ; x++) for(int y = 0; y < colorUnits[0].length ; y++) {
			g.setColor(colorUnits[x][y].getColor());
			g.fillRect(x * SIZE + X, y * SIZE + Y, SIZE, SIZE);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		for(int x = 0; x < colorUnits.length ; x++) for(int y = 0; y < colorUnits[0].length ; y++) {
			// Each color unit has a chance of changing its color slightly
			if((int)(Math.random() * 10) == 0) {
				if(!colorUnits[x][y].isConformer()) {
					// If it will change its color, then it will only change
					// one of the RGB values will change by 1 or -1
					int colorDelta = 2;
					int change = ((int)(Math.random() * 2) == 0 ? colorDelta : -colorDelta);
					int color = (int)(Math.random() * 3);
					
					int r = colorUnits[x][y].getColor().getRed();
					int g = colorUnits[x][y].getColor().getGreen();
					int b = colorUnits[x][y].getColor().getBlue();
					
					switch(color) {
					case 0:
						// Only change if the color will still be in range
						if(r + change >= 0 && r + change < 256) 
							colorUnits[x][y].setColor(new Color(r + change, g, b));
						break;
					case 1:
						// Only change if the color will still be in range
						if(g + change >= 0 && g + change < 256) 
							colorUnits[x][y].setColor(new Color(r, g + change, b));
						break;
					case 2:
						// Only change if the color will still be in range
						if(b + change >= 0 && b + change < 256) 
							colorUnits[x][y].setColor(new Color(r, g, b + change));
					}
				}
				// This color unit will try to conform to the other color units around it
				else {
					if(x != 0 && x != colorUnits.length - 1 && y != 0 && y != colorUnits[0].length - 1) {
						// Getting the average off all the color values around it...
						Color c0 = colorUnits[x - 1][y].getColor();
						Color c1 = colorUnits[x + 1][y].getColor();
						Color c2 = colorUnits[x][y - 1].getColor();
						Color c3 = colorUnits[x][y + 1].getColor();
						Color c4 = colorUnits[x - 1][y - 1].getColor();
						Color c5 = colorUnits[x - 1][y + 1].getColor();
						Color c6 = colorUnits[x + 1][y - 1].getColor();
						Color c7 = colorUnits[x + 1][y + 1].getColor();
						
						if((int)(Math.random() * 7) == 0) {
							// Red
							int r0 = c0.getRed(),
								r1 = c1.getRed(),
								r2 = c2.getRed(),
								r3 = c3.getRed(),
								r4 = c4.getRed(),
								r5 = c5.getRed(),
								r6 = c6.getRed(),
								r7 = c7.getRed();
							int red = (r0 + r1 + r2 + r3 + r4 + r5 + r6 + r7) / 8;
							
							// Green
							int g0 = c0.getGreen(),
								g1 = c1.getGreen(),
								g2 = c2.getGreen(),
								g3 = c3.getGreen(),
								g4 = c4.getGreen(),
								g5 = c5.getGreen(),
								g6 = c6.getGreen(),
								g7 = c7.getGreen();
							int green = (g0 + g1 + g2 + g3 + g4 + g5 + g6 + g7) / 8;
							
							// blue
							int b0 = c0.getBlue(),
								b1 = c1.getBlue(),
								b2 = c2.getBlue(),
								b3 = c3.getBlue(),
								b4 = c4.getBlue(),
								b5 = c5.getBlue(),
								b6 = c6.getBlue(),
								b7 = c7.getBlue();
							int blue = (b0 + b1 + b2 + b3 + b4 + b5 + b6 + b7) / 8;
							
							colorUnits[x][y].setColor(new Color(red, green, blue));
						}
						else {
							int num = (int)(Math.random() * 8);
							
							Color color = null;
							if(num == 0) color = c0;
							if(num == 1) color = c1;
							if(num == 2) color = c2;
							if(num == 3) color = c3;
							if(num == 4) color = c4;
							if(num == 5) color = c5;
							if(num == 6) color = c6;
							if(num == 7) color = c7;
							colorUnits[x][y].setColor(color);
						}
					}
				}
			}
			// Each colorunit has a smal change of switching from a conformer to a leader, and vise versa
			if((int)(Math.random() * 1000 * 1000) == 0) colorUnits[x][y].setConformer(!colorUnits[x][y].isConformer());
		}
	}
	
	public Color getRandomColor() {
		return new Color(
				(int)(Math.random() * 256), 
				(int)(Math.random() * 256), 
				(int)(Math.random() * 256));
	}

	@Override
	public int getID() {
		return State.MENU;
	}
}
