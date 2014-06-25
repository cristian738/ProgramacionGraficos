import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Formulario extends JFrame {

	public Formulario(String nombre){
		//
		setSize(500,500);
		setLocation(180,80);
		setVisible(true);
		setLocationRelativeTo(null);
		///
		Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/ruta.jpg"));
		setIconImage(icono);
		///
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
			
		
		JButton ok = new JButton();
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub			
				
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setVisible(false);	
				
			}});
	
		
	
		
		
		
		
	}
	
	
}
