package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.border.TitledBorder;

public class Proyectos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyectos frame = new Proyectos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Proyectos() {
		setTitle("Proyectos:");
		setBorder(new TitledBorder(null, "Proyectos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Para que se abra a la dimensión de la pantalla
		setBounds(0, 0, screenSize.width/3, screenSize.height/2);
		

	}
	
	

}
