package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;

import dominio.Mensaje;
import dominio.Proyecto;
import dominio.Tarea;
import dominio.Usuario;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelInicio extends JFrame {
	static ArrayList<Proyecto> proyectos=dominio.persistencia.inicializar();;
	static ArrayList<Usuario> usuarios=dominio.persistencia.getusuarios(); ;
	static ArrayList<Mensaje> mensajes=dominio.persistencia.getmensajes();;
	static ArrayList<Tarea> tareas=dominio.persistencia.getTareas();;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	PanelProyectos VentanaProyectos = new PanelProyectos(this);
	PanelDatosProyecto VentanaDatosProyecto = new PanelDatosProyecto();
	PanelMiembros VentanaMiembros = new PanelMiembros();
	PanelTareas VentanaTareas = new PanelTareas();
	PanelMensajes VentanaMensajes = new PanelMensajes();
	PanelInformacionMensajes VentanaInformacionMensaje = new PanelInformacionMensajes();
	PanelDatosUsuario VentanaDatosUsuario = new PanelDatosUsuario();

	public PanelDatosUsuario getVentanaDatosUsuario() {
		return VentanaDatosUsuario;
	}

	public void setVentanaDatosUsuario(PanelDatosUsuario ventanaDatosUsuario) {
		VentanaDatosUsuario = ventanaDatosUsuario;
	}

	private final JPanel panel_Inicio = new JPanel();

	public PanelProyectos getVentanaProyectos() {
		return VentanaProyectos;
	}

	public void setVentanaProyectos(PanelProyectos ventanaProyectos) {
		VentanaProyectos = ventanaProyectos;
	}

	public static void setProyectos(ArrayList<Proyecto> proyectos) {
		PanelInicio.proyectos = proyectos;
	}

	private final JButton btnInicio = new JButton(MessagesIPO1Inter.getString("PanelInicio.btnInicio.text")); //$NON-NLS-1$
	private final JButton btnMensajes = new JButton(MessagesIPO1Inter.getString("PanelInicio.btnMensajes.text")); //$NON-NLS-1$
	private final JPanel panel_Idioma = new JPanel();
	private final JButton btnAyuda = new JButton(""); //$NON-NLS-1$
	private final JPanel panel_DerechaArriba = new JPanel();
	private final JPanel panel_DechaAbajo = new JPanel();
	private final JPanel panel_Izquierda = new JPanel();
	private final JPanel panel_Derecha = new JPanel();
	private final JSplitPane splitPane_Der = new JSplitPane();
	private final JPanel panel_IzqArriba = new JPanel();
	private final JPanel panel_IzqAbajo = new JPanel();
	private final JSplitPane splitPane_Izq = new JSplitPane();
	private final JButton button = new JButton(MessagesIPO1Inter.getString("PanelInicio.button.text")); //$NON-NLS-1$
	private final JButton button_1 = new JButton(MessagesIPO1Inter.getString("PanelInicio.button_1.text")); //$NON-NLS-1$
	
	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

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
		 
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(PanelInicio.class.getResource("/recursos/icons8-caballete-40.png"))); //$NON-NLS-1$
		setTitle(MessagesIPO1Inter.getString("PanelInicio.this.title")); //$NON-NLS-1$

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Para
																			// que
																			// se
																			// abra
																			// a
																			// la
																			// dimensión
																			// de
																			// la
																			// pantalla
		setBounds(0, 0, screenSize.width, screenSize.height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		GridBagLayout gbl_desktopPane = new GridBagLayout();
		gbl_desktopPane.columnWidths = new int[] { 336, 0, 0, 670, 166, 0 };
		gbl_desktopPane.rowHeights = new int[] { 47, 363, 126, 278, 0, 0 };
		gbl_desktopPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_desktopPane.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		desktopPane.setLayout(gbl_desktopPane);

		GridBagConstraints gbc_panel_Inicio = new GridBagConstraints();
		gbc_panel_Inicio.gridwidth = 4;
		gbc_panel_Inicio.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Inicio.fill = GridBagConstraints.BOTH;
		gbc_panel_Inicio.gridx = 0;
		gbc_panel_Inicio.gridy = 0;
		panel_Inicio.setMinimumSize(new Dimension(100, 100));
		desktopPane.add(panel_Inicio, gbc_panel_Inicio);
		btnInicio.setIconTextGap(6);
		btnInicio.addMouseListener(new BtnInicioMouseListener());
		btnInicio.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/inicio.png"))); //$NON-NLS-1$
		btnInicio.setPreferredSize(new Dimension(500, 35));

		panel_Inicio.add(btnInicio);
		btnMensajes.setIconTextGap(6);
		btnMensajes.setMinimumSize(new Dimension(63, 25));
		btnMensajes.setMaximumSize(new Dimension(63, 25));

		btnMensajes.addMouseListener(new BtnMensajesMouseListener());
		btnMensajes.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/icons8-secured-letter-30.png"))); //$NON-NLS-1$
		btnMensajes.setPreferredSize(new Dimension(500, 35));

		panel_Inicio.add(btnMensajes);

		GridBagConstraints gbc_panel_Idioma = new GridBagConstraints();
		gbc_panel_Idioma.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Idioma.fill = GridBagConstraints.BOTH;
		gbc_panel_Idioma.gridx = 4;
		gbc_panel_Idioma.gridy = 0;
		desktopPane.add(panel_Idioma, gbc_panel_Idioma);
		btnAyuda.addActionListener(new BtnAyudaActionListener());
		button.addActionListener(new Button_2ActionListener());
		button.setPreferredSize(new Dimension(100, 35));
		button.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/banderaEsp.gif")));

		panel_Idioma.add(button);
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/banderaIng.gif")));
		button_1.setPreferredSize(new Dimension(100, 35));

		panel_Idioma.add(button_1);
		btnAyuda.setIcon(new ImageIcon(PanelInicio.class.getResource("/recursos/ayuda.png"))); //$NON-NLS-1$
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

		panel_Izquierda.add(splitPane_Izq, "splitPane_Izquerda"); //$NON-NLS-1$
		panel_IzqAbajo.setMinimumSize(new Dimension(10, 300));
		splitPane_Izq.setRightComponent(panel_IzqAbajo);
		panel_IzqAbajo.setLayout(new CardLayout(0, 0));

		panel_IzqAbajo.add(VentanaMiembros, "VentanaMiembros"); //$NON-NLS-1$
		VentanaMiembros.setinicio(this);
		panel_IzqArriba.setMinimumSize(new Dimension(10, 350));
		splitPane_Izq.setLeftComponent(panel_IzqArriba);
		panel_IzqArriba.setLayout(new CardLayout(0, 0));
		VentanaProyectos.setPreferredSize(new Dimension(464, 291));
		panel_IzqArriba.add(VentanaProyectos, "VentanaProyectos"); //$NON-NLS-1$
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

		VentanaInformacionMensaje.setinicio(this);
		VentanaMensajes.setinicio(this);
		panel_Derecha.add(splitPane_Der, "splitPane_Derecha"); //$NON-NLS-1$
		panel_DerechaArriba.setMinimumSize(new Dimension(10, 350));
		splitPane_Der.setLeftComponent(panel_DerechaArriba);
		panel_DerechaArriba.setLayout(new CardLayout(0, 0));
		panel_DerechaArriba.add(VentanaDatosProyecto, "VentanaDatosProyecto"); //$NON-NLS-1$
		panel_DechaAbajo.setMinimumSize(new Dimension(10, 300));
		splitPane_Der.setRightComponent(panel_DechaAbajo);
		panel_DechaAbajo.setLayout(new CardLayout(0, 0));
		panel_DechaAbajo.add(VentanaTareas, "VentanaTareas"); //$NON-NLS-1$
		panel_Derecha.add(VentanaInformacionMensaje, "VentanaInformacionMensaje"); //$NON-NLS-1$
		panel_Izquierda.add(VentanaMensajes, "VentanaMensajes"); //$NON-NLS-1$

		panel_DerechaArriba.add(VentanaDatosUsuario, "VentanaDatosUsuario"); //$NON-NLS-1$

	}

	public PanelInformacionMensajes getVentanaInformacionMensaje() {
		return VentanaInformacionMensaje;
	}

	public void setVentanaInformacionMensaje(PanelInformacionMensajes ventanaInformacionMensaje) {
		VentanaInformacionMensaje = ventanaInformacionMensaje;
	}

	public PanelMensajes getVentanaMensajes() {
		return VentanaMensajes;
	}

	public void setVentanaMensajes(PanelMensajes ventanaMensajes) {
		VentanaMensajes = ventanaMensajes;
	}

	public void setVentanas() {

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

	private class BtnAyudaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JOptionPane.showMessageDialog(null, MessagesIPO1Inter.getString("PanelInicio.13"), //$NON-NLS-1$
					MessagesIPO1Inter.getString("PanelInicio.14"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$
		}
	}

	private class Button_2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VentanaProyectos.getModeloTabla().vaciartabla();
			VentanaTareas.gettabla().vaciartabla();
			VentanaMensajes.getModeloTabla().vaciartabla();
			VentanaMiembros.gettabla().vaciartabla();
			VentanaProyectos.getModeloTabla().fireTableDataChanged();
			VentanaTareas.gettabla().fireTableDataChanged();
			VentanaMensajes.getModeloTabla().fireTableDataChanged();
			VentanaMiembros.gettabla().fireTableDataChanged();
			dominio.persistencia.vaciartodo();
			MessagesIPO1Inter.setIdioma("Español");
			setVisible(false);
			PanelInicio frame = new PanelInicio();
			frame.setVisible(true);

		}
	}

	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VentanaProyectos.getModeloTabla().vaciartabla();
			VentanaTareas.gettabla().vaciartabla();
			VentanaMensajes.getModeloTabla().vaciartabla();
			VentanaMiembros.gettabla().vaciartabla();
			VentanaProyectos.getModeloTabla().fireTableDataChanged();
			VentanaTareas.gettabla().fireTableDataChanged();
			VentanaMensajes.getModeloTabla().fireTableDataChanged();
			VentanaMiembros.gettabla().fireTableDataChanged();
			dominio.persistencia.vaciartodo();
			MessagesIPO1Inter.setIdioma("inglés");
			setVisible(false);
			PanelInicio frame = new PanelInicio();
			frame.setVisible(true);

		}
	}

}
