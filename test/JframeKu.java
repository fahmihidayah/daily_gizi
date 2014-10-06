
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fahmi
 */
public class JframeKu extends JFrame{

    public JframeKu(String title) throws HeadlessException {
        super(title);
        setSize(244,244);
        getContentPane().setBackground(Color.yellow);
        setVisible(true);setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String a[]){
        JframeKu jframeKu = new JframeKu("s");
    }
    
}
