package twotoplay;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Core {
	
	public static final int
		WIDTH = 1200,
		HEIGHT = 900;

	public static void main(String[] args) {
		AppGameContainer container;
		
		try {
			// Creating the game container and setting its size
			container = new AppGameContainer(new Game("2ToPlay"), WIDTH, HEIGHT, false);
			// Starting the game
			container.start();
		}
		catch(SlickException e) {
			e.printStackTrace();
		}
	}
}
