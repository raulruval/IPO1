package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.ComponentOrientation;
import javax.swing.table.DefaultTableModel;

import presentacion.MiModeloTabla;
import dominio.Mensaje;
import dominio.Proyecto;
import dominio.Tarea;
import dominio.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class PanelProyectos extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnBorrar;
	private JButton btnAadir;
	private JToolBar toolBar;
	int posicion = -1;
	PanelInicio inicio;

	public MiModeloTabla getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(MiModeloTabla modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	private PanelDatosProyecto datpro;

	private Proyecto pro;
	MiModeloTabla modeloTabla = new MiModeloTabla();

	public PanelProyectos(PanelInicio ini) {
		inicio = ini;
		setBorder(new TitledBorder(null, MessagesIPO1Inter.getString("PanelProyectos.0"), TitledBorder.LEADING, //$NON-NLS-1$
				TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modeloTabla);
		table.setCellSelectionEnabled(true);

		// String[] fila1= { dominio.persistencia.pro1.getNombre() };
		// modeloTabla.aniadeFila(fila1);
		// proyectos = dominio.persistencia.inicializar();
		// usuarios = dominio.persistencia.getusuarios();
		for (int i = 0; i < ((inicio.getProyectos()).size()); i++) {
			String[] fila1 = { inicio.getProyectos().get(i).getNombre() };
			modeloTabla.aniadeFila(fila1);
		}

		scrollPane.setViewportView(table);

		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(toolBar, BorderLayout.SOUTH);

		btnAadir = new JButton(MessagesIPO1Inter.getString("PanelProyectos.1")); //$NON-NLS-1$
		btnAadir.setMinimumSize(new Dimension(100, 30));
		btnAadir.setMaximumSize(new Dimension(100, 35));
		btnAadir.setIcon(new ImageIcon(PanelProyectos.class.getResource("/recursos/icons8-add-property-30.png"))); //$NON-NLS-1$
		btnAadir.addActionListener(new BtnAadirActionListener());
		toolBar.add(btnAadir);

		btnBorrar = new JButton(MessagesIPO1Inter.getString("PanelProyectos.3")); //$NON-NLS-1$
		btnBorrar.setMinimumSize(new Dimension(100, 30));
		btnBorrar.setMaximumSize(new Dimension(100, 35));
		btnBorrar.setIcon(new ImageIcon(PanelProyectos.class.getResource("/recursos/icons8-trash-can-30.png"))); //$NON-NLS-1$
		btnBorrar.addActionListener(new BtnBorrarActionListener());
		btnBorrar.setHorizontalAlignment(SwingConstants.LEFT);
		toolBar.add(btnBorrar);
		btnBorrar.setEnabled(false);

		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (!lsm.isSelectionEmpty()) {
					int filaSeleccionada = lsm.getMinSelectionIndex();
					posicion = filaSeleccionada;
					pro = inicio.getProyectos().get(filaSeleccionada);
					inicio.getVentanaDatosUsuario().setproyecto(pro);
					Usuario us = pro.getResponsable();
					String nombre = us.getNombre();
					datpro = inicio.getVentanaDatosProyecto();
					datpro.getTxtResponsable().setText(nombre);
					datpro.getTxtNombre().setText(pro.getNombre());
					datpro.getTextDescripcion().setText(pro.getDescripcion());
					inicio.getVentanaMiembros().gettabla().vaciartabla();
					inicio.getVentanaTareas().gettabla().vaciartabla();
					inicio.getVentanaMiembros().gettabla().fireTableDataChanged();
					inicio.getVentanaTareas().gettabla().fireTableDataChanged();
					inicio.getVentanaMiembros().aniadefila(pro);
					inicio.getVentanaTareas().aniadefila(pro);
					inicio.getVentanaTareas().gettabla().fireTableDataChanged();
					inicio.getVentanaMiembros().gettabla().fireTableDataChanged();
					inicio.getVentanaDatosProyecto().setVisible(true);
					inicio.getVentanaDatosProyecto().getTxtNombre().setEnabled(false);
					inicio.getVentanaDatosProyecto().getTxtResponsable().setEnabled(false);
					inicio.getVentanaDatosProyecto().getTextDescripcion().setEnabled(false);
					inicio.getVentanaMiembros().getBtnAñadir().setEnabled(true);
					inicio.getVentanaMiembros().getBtnBorrar().setEnabled(true);
					inicio.getVentanaTareas().getBtnAñadir().setEnabled(true);
					inicio.getVentanaTareas().getBtnBorrar().setEnabled(true);
					inicio.getVentanaDatosProyecto().getBtnModificar().setEnabled(true);
					inicio.getVentanaDatosProyecto().getBtnGuardar().setEnabled(true);
					btnBorrar.setEnabled(true);
					/*
					 * / //// Metido para tareas
					 * inicio.getVentanaTareas().gettabla().vaciartabla();
					 * inicio.getVentanaTareas().gettabla().fireTableDataChanged
					 * (); inicio.getVentanaTareas().aniadefila(pro);
					 * inicio.getVentanaTareas().gettabla().fireTableDataChanged
					 * (); /
					 */
				}
			}
		});
	}

	public void setinicio(PanelInicio in) {
		inicio = in;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public int getPosicion() {
		return posicion;
	}

	private class BtnAadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			inicio.getVentanaDatosProyecto().getTxtNombre().setText(""); //$NON-NLS-1$
			inicio.getVentanaDatosProyecto().getTextDescripcion().setText(""); //$NON-NLS-1$
			inicio.getVentanaDatosProyecto().getTxtResponsable().setText(""); //$NON-NLS-1$
			inicio.getVentanaDatosProyecto().getTxtNombre().setEnabled(true);
			inicio.getVentanaDatosProyecto().getTextDescripcion().setEnabled(true);
			inicio.getVentanaDatosProyecto().getTxtResponsable().setEnabled(true);
			inicio.getVentanaDatosProyecto().getBtnGuardar().setEnabled(true);
			inicio.getVentanaMiembros().gettabla().vaciartabla();
			inicio.getVentanaMiembros().gettabla().fireTableDataChanged();
			inicio.getVentanaTareas().gettabla().vaciartabla();
			inicio.getVentanaTareas().gettabla().fireTableDataChanged();
			posicion = -1;
			JOptionPane.showMessageDialog(null, MessagesIPO1Inter.getString("PanelProyectos.8"), //$NON-NLS-1$
					MessagesIPO1Inter.getString("PanelProyectos.9"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$
		}
	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Ventana de dialogo

			int p = JOptionPane.showOptionDialog(null, MessagesIPO1Inter.getString("PanelProyectos.10"), //$NON-NLS-1$
					MessagesIPO1Inter.getString("PanelProyectos.11"), JOptionPane.YES_NO_OPTION, //$NON-NLS-1$
					JOptionPane.QUESTION_MESSAGE, null, null,
					null);
			if (p == 0) {
				MiModeloTabla modeloTabla = (MiModeloTabla) table.getModel();
				int n = table.getSelectedRow();
				if (n != -1)
					modeloTabla.eliminaFila(table.getSelectedRow());
				modeloTabla.fireTableDataChanged();
				posicion = -1;
				inicio.getVentanaMiembros().gettabla().vaciartabla();
				inicio.getVentanaMiembros().gettabla().fireTableDataChanged();
				inicio.getVentanaTareas().gettabla().vaciartabla();
				inicio.getVentanaTareas().gettabla().fireTableDataChanged();
				inicio.getVentanaDatosProyecto().getTxtNombre().setText(""); //$NON-NLS-1$
				inicio.getVentanaDatosProyecto().getTextDescripcion().setText(""); //$NON-NLS-1$
				inicio.getVentanaDatosProyecto().getTxtResponsable().setText(""); //$NON-NLS-1$
			}

		}

	}

	public ArrayList<Proyecto> getproyectos() {
		return inicio.getProyectos();
	}

	public void aniadeproyecto(Proyecto proy) {
		inicio.getProyectos().add(proy);
		String[] fila1 = { proy.getNombre() };
		modeloTabla.aniadeFila(fila1);
		modeloTabla.fireTableDataChanged();
	}

	public MiModeloTabla getmodelotabla() {
		return modeloTabla;
	}

	public ArrayList<Usuario> getusuarios() {
		return inicio.getUsuarios();
	}

	public void aniadefila(String[] fila1) {

		modeloTabla.aniadeFila(fila1);
		modeloTabla.fireTableDataChanged();
	}

	public ArrayList<Mensaje> getMensajes() {
		return inicio.getMensajes();
	}

	public ArrayList<Mensaje> getmensajes() {
		return inicio.getMensajes();
	}

}
