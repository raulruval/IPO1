package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;

public class Seminario3 extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seminario3 frame = new Seminario3();
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
	public Seminario3() {
		setBounds(new Rectangle(0, 0, 700, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		
		
		VentanaLista ventanaLista = new VentanaLista ();
		desktopPane.add(ventanaLista);
		ventanaLista.setVisible(true);

	}
	

}
