
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.*;



public class myJPanel extends JPanel implements MouseMotionListener, MouseListener {
    Boolean drawSquare = false;
    boolean erase = false;
    
    //These arrays are parallel and all need to be update simultaneously.
    Point[] theSquarePointArray = new Point[10000];
    ArrayList <Point> thePointArray = new ArrayList();
    ArrayList <Integer> theThicknessArray = new ArrayList();
    ArrayList <Color>theColorArray = new ArrayList();
    
    
    ArrayList <Rectangle> theRectArray = new ArrayList();
    JPanel p1;
    myToolbar theBar;
    myJFrame theFrame;
    
    Color currColor;
    int counter = 0;
    int squareCounter = 0;
    int eraseCounter = 0;
    
    Point[] p = new Point[1000];
    int i = 0; 
    myJFrame parentJFrame;
            
    public myJPanel(myJFrame theFrame){
        
       
          parentJFrame = theFrame;
        
        setLayout(new BorderLayout());
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setBackground(Color.MAGENTA);
       
       initComponents();
    }
    
    public void initComponents() {
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        
        
        parentJFrame.mtb.color.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theColorListActionPerformed(evt);
                    }
                });
        parentJFrame.mtb.square.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theSquareButtonActionPerformed(evt);
                    }
                });
        parentJFrame.mtb.eraseButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theEraseButtonActionPerformed(evt);
                    }
                });
        
        
        
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        Point pt = evt.getPoint();
        int x = pt.x;
        int y = pt.y;
        Graphics gg = getGraphics();
        
        if (drawSquare != true && erase != true) {
            
            try {
                Field field = Class.forName("java.awt.Color").getField((String)parentJFrame.mtb.color.getSelectedItem());
                currColor = (Color)field.get(null);
            } catch (Exception e) {
                currColor = null; // Not defined
            }
            gg.setColor(currColor);
            
        
            
            gg.fillRect(x,y,parentJFrame.mtb.thicknessSlider.getValue(),parentJFrame.mtb.thicknessSlider.getValue());
            
        
            theColorArray.add(currColor);
            thePointArray.add(new Point(x, y));
            theThicknessArray.add(parentJFrame.mtb.thicknessSlider.getValue());
            
            counter++;
        } else if (erase == true) {
            
            for (int i = 0; i < thePointArray.size(); i++) {
                Rectangle tmpRect = new Rectangle(thePointArray.get(i).x, thePointArray.get(i).y,theThicknessArray.get(i),theThicknessArray.get(i));
                if (tmpRect.contains(x,y)) {
                    removePoint(thePointArray.get(i), i);
                    repaint();
                }
            }
            
        } else if (drawSquare == true) {
            theSquarePointArray[squareCounter] = new Point(x,y);
            System.out.println(theSquarePointArray[squareCounter].x + " " + theSquarePointArray[squareCounter].y);
            squareCounter++;
        }   
       
            
    }
        
    
    
    @Override
    public void mouseMoved(MouseEvent me) {
       
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //repaints all points with correct colors
        for (int i = 0; i < thePointArray.size(); i++) {
            g.setColor(theColorArray.get(i));
            g.fillRect((thePointArray.get(i).x), (thePointArray.get(i).y), theThicknessArray.get(i), theThicknessArray.get(i));       
        }
        g.setColor(Color.black);
        for (int i = 0; i < theRectArray.size(); i++) {
            g.drawRect(theRectArray.get(i).x, theRectArray.get(i).y, theRectArray.get(i).width , theRectArray.get(i).height);
        }
    }
    
    
    public void theEraseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (erase == true) {
            erase = false;
        } else if (erase == false) {
            erase = true;
        }
        System.out.println("Erase is called and erase = "  + erase);
        
        
        
    }
    public void theColorListActionPerformed(java.awt.event.ActionEvent evt) {
        JComboBox cb = (JComboBox)evt.getSource();
        String currColor = (String) cb.getSelectedItem();
        cb.setSelectedItem(currColor);
        
        
        
    }
    public void theThicknessListActionPerformed(java.awt.event.ActionEvent evt) {
        JComboBox cb = (JComboBox)evt.getSource();
        int currThickness= Integer.parseInt((String)cb.getSelectedItem());
        cb.setSelectedItem(currThickness);
        
        
        
    }
    
    public void theSquareButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (drawSquare == true) {
            drawSquare = false;
        } else {
            drawSquare = true;
        }
        
        
        
    }


    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (drawSquare == true && theSquarePointArray[0] != null) {
            Rectangle rect = new Rectangle(theSquarePointArray[0]);
            rect.add(theSquarePointArray[squareCounter-1]);
            Graphics gg = getGraphics();
            gg.drawRect(rect.x, rect.y, rect.width, rect.height);
            squareCounter = 0;
            theRectArray.add(rect);
        }
                
        
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void removePoint(Point p, int i) {
        thePointArray.remove(p);
        theThicknessArray.remove(i);
        theColorArray.remove(i);
    }
    

    
}
