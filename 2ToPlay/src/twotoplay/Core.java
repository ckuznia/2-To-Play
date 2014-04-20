package twotoplay;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Core {

	public static void main(String[] args) {
		AppGameContainer container;
		
		try {
			// Creating the game container and setting its size
			container = new AppGameContainer(new Game("2ToPlay"), 800, 600, false);
			// Starting the game
			container.start();
		}
		catch(SlickException e) {
			e.printStackTrace();
		}
	}
}
