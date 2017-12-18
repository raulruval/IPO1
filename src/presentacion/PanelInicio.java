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

public class PanelInicio extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	PanelDatosProyecto VentanaDatosProyecto = new PanelDatosProyecto();
	PanelMiembros VentanaMiembros = new PanelMiembros();
	PanelTareas VentanaTareas = new PanelTareas();
	private final JPanel panel = new JPanel();
	private final JButton btnInicio = new JButton("Inicio");
	private final JButton btnMensajes = new JButton("Mensajes");
	private final JPanel panel_1 = new JPanel();
	private final JComboBox comboBox = new JComboBox();
	private final JButton btnAyuda = new JButton("");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelInicio frame = new PanelInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 
	public PanelInicio() {
		
		
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
		gbl_desktopPane.columnWidths = new int[]{275, 0, 814, 166, 0};
		gbl_desktopPane.rowHeights = new int[]{47, 363, 22, 278, 0, 0};
		gbl_desktopPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_desktopPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		desktopPane.setLayout(gbl_desktopPane);
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		desktopPane.add(panel, gbc_panel);
		btnInicio.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/inicio.png")));
		btnInicio.setPreferredSize(new Dimension(500, 35));
		
		panel.add(btnInicio);
		btnMensajes.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/correo1.jpg")));
		btnMensajes.setPreferredSize(new Dimension(500, 35));
		
		panel.add(btnMensajes);
		
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 0;
		desktopPane.add(panel_1, gbc_panel_1);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Español", "Ingles"}));
		comboBox.setToolTipText("Idioma");
		
		panel_1.add(comboBox);
		btnAyuda.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/ayuda.png")));
		btnAyuda.setPreferredSize(new Dimension(80,25));
		panel_1.add(btnAyuda);
		
		PanelProyectos VentanaProyectos = new PanelProyectos ();
		GridBagConstraints gbc_VentanaProyectos = new GridBagConstraints();
		gbc_VentanaProyectos.insets = new Insets(0, 0, 5, 5);
		gbc_VentanaProyectos.gridx = 0;
		gbc_VentanaProyectos.gridy = 1;
		gbc_VentanaProyectos.fill = GridBagConstraints.BOTH;
		desktopPane.add(VentanaProyectos, gbc_VentanaProyectos);
		
		
		VentanaDatosProyecto.setVisible(true);
		GridBagConstraints gbc_VentanaDatosProyecto = new GridBagConstraints();
		gbc_VentanaDatosProyecto.gridwidth = 2;
		gbc_VentanaDatosProyecto.insets = new Insets(0, 0, 5, 0);
		gbc_VentanaDatosProyecto.gridx = 2;
		gbc_VentanaDatosProyecto.gridy = 1;
		gbc_VentanaDatosProyecto.fill = GridBagConstraints.BOTH;
		VentanaProyectos.setinicio(this);
		desktopPane.add(VentanaDatosProyecto, gbc_VentanaDatosProyecto);
		

		GridBagConstraints gbc_VentanaMiembros = new GridBagConstraints();
		gbc_VentanaMiembros.fill = GridBagConstraints.BOTH;
		gbc_VentanaMiembros.insets = new Insets(0, 0, 5, 5);
		gbc_VentanaMiembros.gridx = 0;
		gbc_VentanaMiembros.gridy = 3;
		desktopPane.add(VentanaMiembros,gbc_VentanaMiembros);
		
		GridBagConstraints gbc_VentanaTareas = new GridBagConstraints();
		gbc_VentanaTareas.gridwidth = 2;
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
	}public PanelDatosProyecto getVentanaDatosProyecto() {
		return VentanaDatosProyecto;
	}

	public void setVentanaDatosProyecto(PanelDatosProyecto ventanaDatosProyecto) {
		VentanaDatosProyecto = ventanaDatosProyecto;
	}

	public PanelMiembros getVentanaMiembros() {
		return VentanaMiembros;
	}

	public void setVentanaMiembros(PanelMiembros ventanaMiembros) {
		VentanaMiembros = ventanaMiembros;
	}

	public PanelTareas getVentanaTareas() {
		return VentanaTareas;
	}

	public void setVentanaTareas(PanelTareas ventanaTareas) {
		VentanaTareas = ventanaTareas;
	}
	

	

}

