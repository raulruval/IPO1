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

	private PanelInicio inicio;
	private PanelDatosProyecto datpro;

	ArrayList<Proyecto> proyectos = dominio.persistencia.inicializar();
	ArrayList<Usuario> usuarios = dominio.persistencia.getusuarios();
	ArrayList<Mensaje> mensajes=dominio.persistencia.getmensajes();
	ArrayList<Tarea> tareas=dominio.persistencia.getTareas();
	
	private Proyecto pro;
	MiModeloTabla modeloTabla = new MiModeloTabla();

	public PanelProyectos() {
		setBorder(new TitledBorder(null, "Proyectos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		for (int i = 0; i < proyectos.size(); i++) {
			String[] fila1 = { proyectos.get(i).getNombre() };
			modeloTabla.aniadeFila(fila1);
		}

		scrollPane.setViewportView(table);

		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(toolBar, BorderLayout.SOUTH);

		btnAadir = new JButton("Añadir");
		btnAadir.setMinimumSize(new Dimension(100, 30));
		btnAadir.setMaximumSize(new Dimension(100, 35));
		btnAadir.setIcon(new ImageIcon(PanelProyectos.class.getResource("/recursos/icons8-add-property-30.png")));
		btnAadir.addActionListener(new BtnAadirActionListener());
		toolBar.add(btnAadir);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setMinimumSize(new Dimension(100, 30));
		btnBorrar.setMaximumSize(new Dimension(100, 35));
		btnBorrar.setIcon(new ImageIcon(PanelProyectos.class.getResource("/recursos/icons8-trash-can-30.png")));
		btnBorrar.addActionListener(new BtnBorrarActionListener());
		btnBorrar.setHorizontalAlignment(SwingConstants.LEFT);
		toolBar.add(btnBorrar);

		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (!lsm.isSelectionEmpty()) {
					int filaSeleccionada = lsm.getMinSelectionIndex();
					pro = proyectos.get(filaSeleccionada);
					Usuario us = pro.getResponsable();
					String nombre = us.getNombre();
					datpro = inicio.getVentanaDatosProyecto();
					datpro.getTxtResponsable().setText(nombre);
					datpro.getTxtNombre().setText(pro.getNombre());
					datpro.getTextDescripcion().setText(pro.getDescripcion());
					inicio.getVentanaMiembros().gettabla().vaciartabla();
					inicio.getVentanaMiembros().gettabla().fireTableDataChanged();
					inicio.getVentanaMiembros().aniadefila(pro);
					inicio.getVentanaMiembros().gettabla().fireTableDataChanged();
					inicio.getVentanaDatosProyecto().setVisible(true);
					inicio.getVentanaDatosProyecto().getTxtNombre().setEnabled(false);
					inicio.getVentanaDatosProyecto().getTxtResponsable().setEnabled(false);
					inicio.getVentanaDatosProyecto().getTextDescripcion().setEnabled(false);
					
				/*/	//// Metido para tareas
					inicio.getVentanaTareas().gettabla().vaciartabla();
					inicio.getVentanaTareas().gettabla().fireTableDataChanged();
					inicio.getVentanaTareas().aniadefila(pro);
					inicio.getVentanaTareas().gettabla().fireTableDataChanged(); /*/
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

	private class BtnAadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			inicio.getVentanaDatosProyecto().getTxtNombre().setText("");
			inicio.getVentanaDatosProyecto().getTextDescripcion().setText("");
			inicio.getVentanaDatosProyecto().getTxtResponsable().setText("");
			inicio.getVentanaMiembros().gettabla().vaciartabla();
			JOptionPane.showMessageDialog(null, "Añada la información del proyecto en la ventana de datos del proyecto", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Ventana de dialogo
			
			int p = JOptionPane.showOptionDialog(null, "¿Seguro que desea eliminar este proyecto?",
					"Eliminación de proyecto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
					null);
			if (p == 0) {
				MiModeloTabla modeloTabla = (MiModeloTabla) table.getModel();
				int n = table.getSelectedRow();
				if (n != -1)
					modeloTabla.eliminaFila(table.getSelectedRow());
				modeloTabla.fireTableDataChanged();
				inicio.getVentanaMiembros().gettabla().vaciartabla();
				inicio.getVentanaMiembros().gettabla().fireTableDataChanged();
				inicio.getVentanaDatosProyecto().getTxtNombre().setText("");
				inicio.getVentanaDatosProyecto().getTextDescripcion().setText("");
				inicio.getVentanaDatosProyecto().getTxtResponsable().setText("");
			}

		}
		
	}

	public ArrayList<Proyecto> getproyectos() {
		return proyectos;
	}

	public void aniadeproyecto(Proyecto proy) {
		proyectos.add(proy);
	}

	public MiModeloTabla getmodelotabla() {
		return modeloTabla;
	}

	public ArrayList<Usuario> getusuarios() {
		return usuarios;
	}

	public void aniadefila(String[] fila1) {

		modeloTabla.aniadeFila(fila1);
		modeloTabla.fireTableDataChanged();
	}

	public ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(ArrayList<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	public ArrayList<Mensaje> getmensajes(){
		return mensajes;
	}
}
