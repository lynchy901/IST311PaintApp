
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class myToolbar {
    
    JButton paint,erase,polygon,square,circle;
    JSlider thickness;
    JComboBox color;
    JPanel toolbar;
    JLabel cslider, tslider;
    
    public myToolbar(myJFrame theFrame){
        
        toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(2,6));
        
        
        paint = new JButton("Paint");
        //paintListener paintListen = new paintListener();
        //paint.addActionListener(paintListen);
        toolbar.add(paint);
        
        erase = new JButton("Erase");
        //eraseListener eraseListen = new eraseListener();
        //erase.addActionListener(eraseListen);
        toolbar.add(erase);
        
        square = new JButton("Square");
        //squareListener squareListen = new squareListener();
        //square.addActionListener(squareListen);
        toolbar.add(square);
        
        circle = new JButton("Circle");
        //circleListener circleListen = new circleListener();
        //circle.addActionListener(circleListen);
        toolbar.add(circle);
        
        color = new JComboBox();
        cslider = new JLabel("   Choose A Color:");
        toolbar.add(cslider);
        toolbar.add(color);
        
        thickness = new JSlider();
        tslider = new JLabel("   Thickness:");
        toolbar.add(tslider);
        toolbar.add(thickness);
        
    }
    /* public class paintListener implements ActionListener{
        // Erase Button Logic Here
    }
    public class eraseListener implements ActionListener{
        // Erase Button Logic Here
    }
    public class squareListener implements ActionListener{
        // Square Button Logic Here
    }
    public class circleListener implements ActionListener{
        // Circle Button Logic Here
    }
    */
    
}
