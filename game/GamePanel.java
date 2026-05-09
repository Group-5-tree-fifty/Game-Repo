package game;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import game.screens.BaseScreen;
 
class="c">// FILE 3- The single JPAnel the window contains.
class="c">// Swing double buffering eliminates flicker with no extra code.
class="c">// Forwards all mouse and keyboard events to the active screen.
 
public class GamePanel extends JPanel{
	private final App    app;
	private       BaseScreen screen;
	
	public GamePanel(App app) {
		this.app = app;
		setPrefferedSize(new Dimesion(App.Width, App.Height));
		setBackground(Color.BLACK);
		
		addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) {
				if (screen != null) screen.onMouseMove(e);
			}
		});
	}
	
	public void setScreen(BaseScreen s) {this.screen = s;}
	
	@Override
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		if (screen != null)  screen.draw(g2, getWidth(), getHeight());
	}
}
