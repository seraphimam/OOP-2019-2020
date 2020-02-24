package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class Sound2 extends PApplet
{	
	Minim minim;
	AudioInput ai;

	public void settings()
	{
		size(1024, 1024);
	}

	public void setup() 
	{
		minim = new Minim(this);
		ai = minim.getLineIn(Minim.MONO, width, 44100, 16);

		colorMode(HSB);
	}

	
	public void draw()
	{	
		background(0);		
		stroke(255);
		float cy = height / 2;
		float avg, total = 0;;
		
		for(int i = 0 ; i < ai.bufferSize() ; i ++)
		{
			total += ai.left.get(i) + 1;
			
		}
		
		avg = total / ai.bufferSize();
		
		ellipse(cy, cy, avg, avg);
	}
}