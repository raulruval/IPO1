package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.Color;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Para que se abra a la dimensión de la pantalla
		setBounds(0, 0, screenSize.width, screenSize.height);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		GridBagLayout gbl_desktopPane = new GridBagLayout();
		gbl_desktopPane.columnWidths = new int[]{275, 0, 0, 0};
		gbl_desktopPane.rowHeights = new int[]{363, 22, 278, 0};
		gbl_desktopPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_desktopPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		desktopPane.setLayout(gbl_desktopPane);
		
		Proyectos VentanaProyectos = new Proyectos ();
		VentanaProyectos.setResizable(false);
		desktopPane.setLayer(VentanaProyectos, 0);
		VentanaProyectos.setBorder(null);
		GridBagConstraints gbc_VentanaProyectos = new GridBagConstraints();
		gbc_VentanaProyectos.insets = new Insets(0, 0, 5, 5);
		gbc_VentanaProyectos.fill = GridBagConstraints.BOTH;
		gbc_VentanaProyectos.gridx = 0;
		gbc_VentanaProyectos.gridy = 0;
		desktopPane.add(VentanaProyectos, gbc_VentanaProyectos);
		VentanaProyectos.setVisible(true);
		
		
		DatosProyecto VentanaDatosProyecto = new DatosProyecto();
		VentanaDatosProyecto.setBorder(null);
		GridBagConstraints gbc_DatosProyecto = new GridBagConstraints();
		gbc_DatosProyecto.fill = GridBagConstraints.BOTH;
		gbc_DatosProyecto.insets = new Insets(0, 0, 5, 0);
		gbc_DatosProyecto.gridx = 2;
		gbc_DatosProyecto.gridy = 0;
		desktopPane.add(VentanaDatosProyecto, gbc_DatosProyecto);
		VentanaDatosProyecto.setVisible(true);
			
		Miembros VentanaMiembros = new Miembros();
		GridBagConstraints gbc_VentanaMiembros = new GridBagConstraints();
		gbc_VentanaMiembros.insets = new Insets(0, 0, 0, 5);
		gbc_VentanaMiembros.gridx = 0;
		gbc_VentanaMiembros.gridy = 2;
		gbc_VentanaMiembros.fill = GridBagConstraints.BOTH;
		desktopPane.add(VentanaMiembros, gbc_VentanaMiembros);
		
		Tareas VentanaTareas = new Tareas();
		GridBagConstraints gbc_VentanaTareas = new GridBagConstraints();
		gbc_VentanaTareas.fill = GridBagConstraints.BOTH;
		gbc_VentanaTareas.gridx = 2;
		gbc_VentanaTareas.gridy = 2;
		desktopPane.add(VentanaTareas, gbc_VentanaTareas);
		VentanaTareas.setVisible(true);
		VentanaMiembros.setVisible(true);
		
		
	}
		

}
