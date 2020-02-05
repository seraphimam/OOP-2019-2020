package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet{
	float playerX, playerY, playerWidth;
	float bugWidth = 20, bugHeight = 20;
	float x1, y1;
	float x2, x3;
	int kill;
	boolean alive;
	
	public void settings()
	{
		size(600, 600);
	}

	public void setup() {
		frameRate(60);
		playerX = width/2;
		playerY = height - 40;
		playerWidth = 40;
		
		x1 = random(width - 20);
		y1 = random(20, height/3);
		
		kill = 0;
		alive = true;
	}

	public void drawPlayer(float x, float y, float w){
		fill(0);
		stroke(255);
		rect(x, y, w, 20, 10, 10, 0, 0);
		line(x + w/2, y, x + w/2, y - 5);
	}
	
	public void laser(){
		float x = playerX + playerWidth/2;
		stroke(255);
		line(x, playerY, x, 0);
		
		if(x <= x1 + bugWidth && x >= x1){
			explode();
			kill++;
			x1 = random(width - 20);
			y1 = random(20, height/3);
		}
	}
	
	public void explode(){
		noStroke();
		fill(255,0,0);
		ellipse(x1 + bugWidth/2, y1 - bugHeight/2, bugWidth*2, bugHeight*2);
	}
	
	public void drawBug(){
		stroke(255);
		fill(255);
		triangle(x1, y1, x1 + bugWidth/2, y1 - bugHeight, x1 + bugWidth, y1);
	}
	
	public void moveBug(){
		if(x1 - bugWidth >= 0){
			x2 = x1 - bugWidth;
		}else{
			x2 = 0;
		}
			
		if(x1 + bugWidth <= width){
			x3 = x1 + bugWidth;
		}else{
			x3 = width;
		}
			
		x1 = random(x2, x3);
		y1 = random(y1, y1 + bugHeight);
	
	}
	
	public void draw()
	{	
		background(0);
		fill(255);
		textAlign(LEFT);
		text("Kill Count: " + kill, 10, 20);
		drawPlayer(playerX, playerY, playerWidth);
		drawBug();
		
		if(frameCount % 20 == 0){
			moveBug();
		}
		
		if(y1 >= height){
			alive = false;
			clear();
			background(0);
			fill(255);
			textAlign(CENTER);
			text("Game Over! Score: " + kill + "\nClick to replay!", width/2, height/2);
		}
	}
	
	public void keyPressed(){
		if(keyCode == 'a' || keyCode == 'A'){
			if(playerX >= 3)
				playerX = playerX - 3;
		}
		
		if(keyCode == 'd' || keyCode == 'D'){
			if(playerX <= width - 3 - playerWidth)
				playerX = playerX + 3;
		}
		
		if(keyCode == ' '){
			laser();
		}
	}
	
	public void mousePressed(){
		if(!alive){
			setup();
			redraw();
		}
	}
}