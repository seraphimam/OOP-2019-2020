package ie.tudublin;

// Hello from Bryan

import processing.core.PApplet;

public class Arrays extends PApplet
{	
	float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 50};
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	int max = 1, min = 1;
	float bar;
	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		for(int i = 1; i < rainFall.length; i++){
			if(rainFall[max] < rainFall[i]){
				max = i;
			}
			
			if(rainFall[min] > rainFall[i]){
				min = i;
			}
		}
		
		println("Month of maximum rainfall: " + months[max]);
		println("Month of minimum rainfall: " + months[min]);
		
		bar = 100 / rainFall[max];
	}

	

	float offset = 0;

	
	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	


	public void draw()
	{	
		background(0);		
		colorMode(HSB);
		
		textSize(12);
		for(int i = 0; i < 10; i++){
			text(((char)(int)(rainFall[max]/(i+1.0))), width/15.0, height*(i+1.0)/13.0);			
		}
		
		text("0", width/15.0, height*11.0/13.0);
		stroke(0,0,100);
		line((width/15.0)*2.0, height/13.0, (width/15.0)*2.0, height*11.0/13.0);
		
		offset = (width / (months.length+3))/2;
		for(int i = 0; i < months.length; i++){
			text(months[i], width*(i+2.0)/15.0+ offset, height*12.0/13.0);
		}
		line((width/15.0)*2.0, height*11.0/13.0, (width/15.0)*14.0 + offset, height*11.0/13.0);
		
		noStroke();
		for(int i = 0; i < rainFall.length; i++){
			fill(i*6, 100, 100);
			rect((width/15.0)*2.0, height*11.0/13.0, 2.0*offset, (float)(-1.0*(rainFall[i]/rainFall[max])));
		}
		
	}
}
