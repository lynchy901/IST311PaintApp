


import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class myJFrame extends JFrame {
    
    myJPanel mjp;
    myToolbar mtb;
    
    public myJFrame(){
        
        // 
        mjp = new myJPanel(this);
        mtb = new myToolbar(this);
           
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mjp.p1,"North");
        getContentPane().add(mtb.toolbar,"South");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize (640, 480);
	setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
}
