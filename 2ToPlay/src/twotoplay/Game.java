package twotoplay;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import twotoplay.state.*;

public class Game extends StateBasedGame {
	
	public Game(String title) {
		super(title);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// Adding all the states for the game
		this.addState(new MenuState());
		this.addState(new PlayState());
		
		// Initializing them
		this.getState(State.MENU).init(container, this);
		this.getState(State.PLAY).init(container, this);
		
		// Setting the default state
		this.enterState(State.MENU);
	}
}
