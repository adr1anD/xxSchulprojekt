package xxSchulprojekt;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Spiel implements Runnable{

	private Bildschirm bildschirm;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy buffStrat;
	private Graphics g;
	
	private SpriteSheet spritesheet;
	private BufferedImage test;
	
	public Spiel(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init(){
		bildschirm = new Bildschirm(title, width, height);
		test = BilderUpload.ladeBild("/textures/hintergrund.png");
		new SpriteSheet(test);
	}
	
	
	private void tick(){
		
	}
	
	private void render(){
		buffStrat = bildschirm.getCanvas().getBufferStrategy();
		if(buffStrat == null){
			bildschirm.getCanvas().createBufferStrategy(3);
			return;
		}
		g = buffStrat.getDrawGraphics();
		
		g.drawImage(spritesheet.auschschneiden(0, 0, 60, 60), 5, 5, null);
		
		buffStrat.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		while(running){
			tick();
			render();
		}
		
		stop();
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
