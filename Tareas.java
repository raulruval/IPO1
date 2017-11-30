package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Tareas extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tareas frame = new Tareas();
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
	public Tareas() {
		setTitle("Tareas");
		setBorder(null);
		setBounds(100, 100, 450, 300);

	}

}
