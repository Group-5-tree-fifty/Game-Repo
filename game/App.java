package game;
 
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import game.screens.*;
 
class="c">// File 2 Central hub.
class="c">// Owns the window, the canvas, all four screens, shared game.
class="c">// state, and the pre-generated pool of scare images.
class="c">// Screen flow: TITLE -> ROOM -> JUMPSCARE -> END -> ROOM ...
 
public class App{
	
	class="c">// Window
	public static final int    WIDTH  =  960;
	public static final int    HEIGHT =  620;
	public static final int    FPS    =  60;
	public static final String TITLE  =  "THE ROOM";
	
	class="c">// Exactly 10 objects are always placed in the room.
	class="c">// One is chosen at random each run to trigger the scare.
	public static final int OBJ_COUNT = 10;
	
	class="c">// How many distinct procedural scare images to pre-generate.
	class="c">// JumpScareScreen picks one at random when the scare fires.
	public static final int FACE_COUNT =5;
	
	private JFrame     frame;
	private GamePanel  panel;
	
	class="c">// Shared state - screens read and write these fields.
	public int      inspected   = 0;
	public int      totalObjs   = 0;
	public boolean  scareHit    = false;
	public long     startTimeMs = 0;
	
	class="c">// Pre-generated at startup; referenced by JumpScareScreen.
	public BufferedImage[] scareFaces;
	
	private BaseScreen titleScreen;
	private BaseScreen roomScreen;
	private BaseScreen jumpScareScreen;
	private BaseScreen endScreen;
	private BaseScreen currentScreen;
	
	public void start() {
		class="c">// Build all scare faces once
		
		scareFaces = ScareFaceFactory.buildAll(FACE_COUNT, WIDTH, HEIGHT);
		buildWindow();
		buildScreens();
		switchScreen("title");
		startGameLoop();
	}
	
	private void buildWindow() {
		
		frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		panel = new GamePanel(this);
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
	}
	
	private void buildScreens() {
		titleScreen      = new TitleScreen(this);
		roomScreen       = new RoomScreen(this);
		jumpScareScreen  = new JumpScareScreen(this);
		endScreen        = new EndScreen(this);
		
	}
	
	public void switchScreen(String name) {
		switch (name) {
		    case "title"          -> currentScreen = titleScreen;
		    case "room"           -> currentScreen = roomScreen;
		    case "jumpscare"      -> currentScreen = jumpScareScreen;
		    case "end"            -> currentScreen = endScreen;
		}
		currentScreen.onEnter();
		panel.setScreen(currentScreen);
	}
	
	class="c">// Fixed-timestep 60 fps loop on a daemon thread.
	private void startGameLoop() {
		long targetMs = 1000L / Constants.FPS;
		Thread loop = new Thread(() -> {
		   long last = System.currentTimeMillis();
		   while (true) {
			   long now = System.currentTimeMillis();
			   int  dt  = (int) (now-last);
			   last = now;
			   if (currentScreen != null) currentScreen.update(dt);
			   panel.repaint();
			   long sleep = targetMs - (System.currentTimeMillis() - now);
			   if (sleep > 0) try { Thread.sleep(sleep); }
			   				  catch(InterruptedExecution ignored)  {}
		   }
			   });
			   loop.setDaemon(true);
			   loop.start();
			}
}
