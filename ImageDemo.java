
import java.awt.*;
import java.applet.*;


/*<applet code="ImageDemo.class" width="500" height="500"></applet>*/


public class ImageDemo extends Applet implements Runnable
{
	Image [] imagearray = new Image[4] ;
	
	Thread t;
	int i=0;
	
	public void init()
	{
		
		for(int i=0;i<imagearray.length;i++)
		{
			imagearray[i]=getImage(getCodeBase(),"Image"+i+".jpg"); 
		}
	}
	
	public void start()
	{
		t = new Thread(this);
	    t.start();
	}
	
	public void stop()
	{
		t = null;
	}
	
	public void run()
	{
		
		while (true)
		{
			
			i=(i+1)%imagearray.length;
			repaint();
			try
			{
				t.sleep(1000); 
			}
			catch(InterruptedException e)
		    {		
		    }
			
		}
		
	}
	
	public void paint(Graphics g)
	{
		
		g.drawImage(imagearray[i],0,0,this);
	    
	}
}
