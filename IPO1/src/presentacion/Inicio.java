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
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	DatosProyecto VentanaDatosProyecto = new DatosProyecto();
	Miembros VentanaMiembros = new Miembros();
	Tareas VentanaTareas = new Tareas();
	private final JToolBar toolBar = new JToolBar();
	private final JButton btnInicio = new JButton("Inicio");
	
	
	private final JButton btnMensajes = new JButton("Mensajes");
	private final JComboBox comboBox = new JComboBox();
	private final JButton btnNewButton = new JButton("");
	
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
		gbl_desktopPane.rowHeights = new int[]{0, 363, 22, 278, 0, 0};
		gbl_desktopPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_desktopPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		desktopPane.setLayout(gbl_desktopPane);
		
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.gridwidth = 3;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		desktopPane.add(toolBar, gbc_toolBar);
		btnInicio.setPreferredSize(new Dimension(140, 25));
		btnInicio.setIcon(new ImageIcon(Inicio.class.getResource("/recursos/inicio.png")));
		
		toolBar.add(btnInicio);
		btnMensajes.setPreferredSize(new Dimension(63, 25));
		btnMensajes.setMinimumSize(new Dimension(63, 25));
		btnMensajes.setMaximumSize(new Dimension(63, 25));
		btnMensajes.setIcon(new ImageIcon(Inicio.class.getResource("/recursos/correo1.jpg")));
		
		toolBar.add(btnMensajes);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Español", "Inglés"}));
		comboBox.setToolTipText("Idioma");
		
		toolBar.add(comboBox);
		btnNewButton.setIcon(new ImageIcon(Inicio.class.getResource("/recursos/ayuda.png")));
		
		toolBar.add(btnNewButton);
		
		Proyectos VentanaProyectos = new Proyectos ();
		GridBagConstraints gbc_VentanaProyectos = new GridBagConstraints();
		gbc_VentanaProyectos.insets = new Insets(0, 0, 5, 5);
		gbc_VentanaProyectos.gridx = 0;
		gbc_VentanaProyectos.gridy = 1;
		gbc_VentanaProyectos.fill = GridBagConstraints.BOTH;
		desktopPane.add(VentanaProyectos, gbc_VentanaProyectos);
		
		
		VentanaDatosProyecto.setVisible(true);
		GridBagConstraints gbc_VentanaDatosProyecto = new GridBagConstraints();
		gbc_VentanaDatosProyecto.insets = new Insets(0, 0, 5, 0);
		gbc_VentanaDatosProyecto.gridx = 2;
		gbc_VentanaDatosProyecto.gridy = 1;
		gbc_VentanaDatosProyecto.fill = GridBagConstraints.BOTH;
		desktopPane.add(VentanaDatosProyecto, gbc_VentanaDatosProyecto);
		

		GridBagConstraints gbc_VentanaMiembros = new GridBagConstraints();
		gbc_VentanaMiembros.fill = GridBagConstraints.BOTH;
		gbc_VentanaMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_VentanaMiembros.gridx = 0;
		gbc_VentanaMiembros.gridy = 3;
		desktopPane.add(VentanaMiembros,gbc_VentanaMiembros);
		
		GridBagConstraints gbc_VentanaTareas = new GridBagConstraints();
		gbc_VentanaTareas.insets = new Insets(0, 0, 5, 0);
		gbc_VentanaTareas.fill = GridBagConstraints.BOTH;
		gbc_VentanaTareas.gridx = 2;
		gbc_VentanaTareas.gridy = 3;
		desktopPane.add(VentanaTareas,gbc_VentanaTareas);
	}
	public void setVentanas(){
		VentanaDatosProyecto.setVisible(true);
		VentanaMiembros.setVisible(true);
		VentanaTareas.setVisible(true);
	}public DatosProyecto getVentanaDatosProyecto() {
		return VentanaDatosProyecto;
	}

	public void setVentanaDatosProyecto(DatosProyecto ventanaDatosProyecto) {
		VentanaDatosProyecto = ventanaDatosProyecto;
	}

	public Miembros getVentanaMiembros() {
		return VentanaMiembros;
	}

	public void setVentanaMiembros(Miembros ventanaMiembros) {
		VentanaMiembros = ventanaMiembros;
	}

	public Tareas getVentanaTareas() {
		return VentanaTareas;
	}

	public void setVentanaTareas(Tareas ventanaTareas) {
		VentanaTareas = ventanaTareas;
	}

}

