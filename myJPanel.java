
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;



public class myJPanel extends JFrame implements MouseMotionListener {
    
    JPanel p1;
    myToolbar theBar;
    myJFrame theFrame;
    
    Point[] p = new Point[1000];
    int i = 0; 
            
    public myJPanel(myJFrame theFrame){
        
       
          
        
        setLayout(new BorderLayout());
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setBackground(Color.MAGENTA);
       
        addMouseMotionListener(this);
    }
    public void paintComponent(Graphics g){
            // super.paintComponent(g);
            for (int j = 0; j < i; j++)
            {
                g.fillRect((int)p[j].x,p[j].y,5,5);
            }
        }
    public void mouseMoved(MouseEvent evt)
    {
    	Point pt = evt.getPoint();
    	String sx = "x = " + pt.getX();
    	String sy = "y = " + pt.getY();
    }
    public void mouseDragged(MouseEvent evt)
    {
     Point pt = evt.getPoint();
     int x = pt.x;
     int y = pt.y;
     Graphics gg = getGraphics();

     gg.setColor(Color.RED);
     gg.fillRect(x,y,5,5);
     p[i++] = pt;
    
    
    }

    
}
