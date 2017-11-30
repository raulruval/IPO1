package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Miembros extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Miembros frame = new Miembros();
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
	public Miembros() {
		setBorder(null);
		setTitle("Miembros");
		setBounds(100, 100, 450, 300);

	}

}
