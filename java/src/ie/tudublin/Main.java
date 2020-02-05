package ie.tudublin;

public class Main
{

    public void BugZap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
	}
    
    public static void main(String[] arg)
    {
        Main main = new Main();
		main.BugZap();
        
    }
}