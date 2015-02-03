
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class myToolbar extends JPanel {
    
    JButton paint,eraseButton,polygon,square,circle;
    JSlider thicknessSlider;
    JComboBox color;
    JPanel toolbar;
    JLabel cslider, tslider;
    
    String [] colors = {"red", "green", "blue", "black"};
    String [] thickness = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    
    myJFrame parentJFrame;
    
    
    public myToolbar(myJFrame theFrame){
        parentJFrame = theFrame;
        
        
        toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(2,6));
        
        
        paint = new JButton("Paint");
        //paintListener paintListen = new paintListener();
        //paint.addActionListener(paintListen);
        toolbar.add(paint);
        
        eraseButton = new JButton("Erase");
        //eraseListener eraseListen = new eraseListener();
        //erase.addActionListener(eraseListen);
        toolbar.add(eraseButton);
        
        square = new JButton("Square");
        //squareListener squareListen = new squareListener();
        //square.addActionListener(squareListen);
        toolbar.add(square);
        
        circle = new JButton("Circle");
        //circleListener circleListen = new circleListener();
        //circle.addActionListener(circleListen);
        toolbar.add(circle);
        
        color = new JComboBox(colors);
        cslider = new JLabel("   Choose A Color:");
        toolbar.add(cslider);
        toolbar.add(color);
        
        thicknessSlider = new JSlider();
        tslider = new JLabel("   Thickness:");
        toolbar.add(tslider);
        toolbar.add(thicknessSlider);
        
        
        
        
    }
    
        
    
 }
    
  
