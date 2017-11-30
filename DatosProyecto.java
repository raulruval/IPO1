package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class DatosProyecto extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosProyecto frame = new DatosProyecto();
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
	public DatosProyecto() {
		setTitle("Datos del proyecto");
		setBounds(100, 100, 450, 300);

	}

}
