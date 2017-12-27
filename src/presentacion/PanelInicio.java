package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;

import dominio.Proyecto;
import dominio.Usuario;

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
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelInicio extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	PanelDatosProyecto VentanaDatosProyecto = new PanelDatosProyecto();
	PanelMiembros VentanaMiembros = new PanelMiembros();
	PanelTareas VentanaTareas = new PanelTareas();
	PanelProyectos VentanaProyectos = new PanelProyectos ();
	PanelMensajes VentanaMensajes = new PanelMensajes();
	PanelInformacionMensajes VentanaInformacionMensaje = new PanelInformacionMensajes();
	PanelDatosUsuario VentanaDatosUsuario = new PanelDatosUsuario();


	
	private final JPanel panel_Inicio = new JPanel();
	


	public PanelProyectos getVentanaProyectos() {
		return VentanaProyectos;
	}


	public void setVentanaProyectos(PanelProyectos ventanaProyectos) {
		VentanaProyectos = ventanaProyectos;
	}

	private final JButton btnInicio = new JButton("Inicio");
	private final JButton btnMensajes = new JButton("Mensajes");
	private final JPanel panel_Idioma = new JPanel();
	private final JComboBox comboBox = new JComboBox();
	private final JButton btnAyuda = new JButton("");
	private final JPanel panel_DerechaArriba = new JPanel();
	private final JPanel panel_DechaAbajo = new JPanel();
	private final JPanel panel_Izquierda = new JPanel();
	private final JPanel panel_Derecha = new JPanel();
	private final JSplitPane splitPane_Der = new JSplitPane();
	private final JPanel panel_IzqArriba = new JPanel();
	private final JPanel panel_IzqAbajo = new JPanel();
	private final JSplitPane splitPane_Izq = new JSplitPane();
	
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
		gbl_desktopPane.columnWidths = new int[]{336, 0, 0, 670, 166, 0};
		gbl_desktopPane.rowHeights = new int[]{47, 363, 126, 278, 0, 0};
		gbl_desktopPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_desktopPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		desktopPane.setLayout(gbl_desktopPane);
		
		GridBagConstraints gbc_panel_Inicio = new GridBagConstraints();
		gbc_panel_Inicio.gridwidth = 4;
		gbc_panel_Inicio.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Inicio.fill = GridBagConstraints.BOTH;
		gbc_panel_Inicio.gridx = 0;
		gbc_panel_Inicio.gridy = 0;
		desktopPane.add(panel_Inicio, gbc_panel_Inicio);
		btnInicio.addMouseListener(new BtnInicioMouseListener());
		btnInicio.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/inicio.png")));
		btnInicio.setPreferredSize(new Dimension(500, 35));
		
		panel_Inicio.add(btnInicio);
		btnMensajes.addMouseListener(new BtnMensajesMouseListener());
		btnMensajes.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/correo1.jpg")));
		btnMensajes.setPreferredSize(new Dimension(500, 35));
		
		panel_Inicio.add(btnMensajes);
		
		GridBagConstraints gbc_panel_Idioma = new GridBagConstraints();
		gbc_panel_Idioma.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Idioma.fill = GridBagConstraints.BOTH;
		gbc_panel_Idioma.gridx = 4;
		gbc_panel_Idioma.gridy = 0;
		desktopPane.add(panel_Idioma, gbc_panel_Idioma);
		comboBox.setPreferredSize(new Dimension(100, 35));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Español", "Ingles"}));
		comboBox.setToolTipText("Idioma");
		
		panel_Idioma.add(comboBox);
		btnAyuda.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/ayuda.png")));
		btnAyuda.setPreferredSize(new Dimension(80, 35));
		panel_Idioma.add(btnAyuda);
		
		GridBagConstraints gbc_panel_Izquierda = new GridBagConstraints();
		gbc_panel_Izquierda.gridheight = 3;
		gbc_panel_Izquierda.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Izquierda.fill = GridBagConstraints.BOTH;
		gbc_panel_Izquierda.gridx = 0;
		gbc_panel_Izquierda.gridy = 1;
		desktopPane.add(panel_Izquierda, gbc_panel_Izquierda);
		panel_Izquierda.setLayout(new CardLayout(0, 0));
		splitPane_Izq.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		panel_Izquierda.add(splitPane_Izq, "splitPane_Izquerda");
		splitPane_Izq.setRightComponent(panel_IzqAbajo);
		panel_IzqAbajo.setLayout(new CardLayout(0, 0));
		panel_IzqAbajo.add(VentanaMiembros, "VentanaMiembros");
		splitPane_Izq.setLeftComponent(panel_IzqArriba);
		panel_IzqArriba.setLayout(new CardLayout(0, 0));
		VentanaProyectos.setPreferredSize(new Dimension(464, 291));
		panel_IzqArriba.add(VentanaProyectos, "VentanaProyectos");
		VentanaProyectos.setinicio(this);
		
		GridBagConstraints gbc_panel_Derecha = new GridBagConstraints();
		gbc_panel_Derecha.gridwidth = 3;
		gbc_panel_Derecha.gridheight = 3;
		gbc_panel_Derecha.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Derecha.fill = GridBagConstraints.BOTH;
		gbc_panel_Derecha.gridx = 2;
		gbc_panel_Derecha.gridy = 1;
		desktopPane.add(panel_Derecha, gbc_panel_Derecha);
		panel_Derecha.setLayout(new CardLayout(0, 0));
		splitPane_Der.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		panel_Derecha.add(splitPane_Der, "splitPane_Derecha");
		splitPane_Der.setLeftComponent(panel_DerechaArriba);
		panel_DerechaArriba.setLayout(new CardLayout(0, 0));
		panel_DerechaArriba.add(VentanaDatosProyecto, "VentanaDatosProyecto");
		splitPane_Der.setRightComponent(panel_DechaAbajo);
		panel_DechaAbajo.setLayout(new CardLayout(0, 0));
		panel_DechaAbajo.add(VentanaTareas, "VentanaTareas");
		panel_Derecha.add(VentanaInformacionMensaje, "VentanaInformacionMensaje");
		panel_Izquierda.add(VentanaMensajes,"VentanaMensajes");
		
		panel_DerechaArriba.add(VentanaDatosUsuario, "VentanaDatosUsuario");
		
		
	
		
	}
	public void setVentanas(){
		
		VentanaDatosProyecto.setVisible(true);
		VentanaMiembros.setVisible(true);
		VentanaTareas.setVisible(true);
		
	}
	
	public PanelDatosProyecto getVentanaDatosProyecto() {
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
	

	

	

	private class BtnMensajesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			splitPane_Der.setVisible(false);
			splitPane_Izq.setVisible(false);
			VentanaInformacionMensaje.setVisible(true);
			VentanaMensajes.setVisible(true);			
			
		}
	}
	private class BtnInicioMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			VentanaInformacionMensaje.setVisible(false);
			VentanaMensajes.setVisible(false);		
			splitPane_Der.setVisible(true);
			splitPane_Izq.setVisible(true);
			
		}
	}
}

