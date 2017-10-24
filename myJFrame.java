


import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class myJFrame extends JFrame {
    
    myJPanel mjp;
    myToolbar mtb;
    
    public myJFrame(){
        
        
        mjp = new myJPanel(this);
        mtb = new myToolbar(this);
           
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mjp.p1,"Center");
        
        getContentPane().add(mtb.toolbar,"South");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize (640, 481);
	setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    public myJPanel getJPanel() {
        return mjp;
    }
}
