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
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.ComponentOrientation;
import javax.swing.table.DefaultTableModel;

import dominio.Proyecto;
import dominio.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnAadir.addActionListener(new BtnAadirActionListener());
		toolBar.add(btnAadir);

		btnBorrar = new JButton("Borrar");
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
					inicio.getVentanaMiembros().aniadefila(pro);
					inicio.getVentanaMiembros().gettabla().fireTableDataChanged();
				}
			}
		});
	}

	public void setinicio(PanelInicio in) {
		inicio = in;
	}

	private class BtnAadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			inicio.getVentanaDatosProyecto().getTxtNombre().setText("");
			inicio.getVentanaDatosProyecto().getTextDescripcion().setText("");
			inicio.getVentanaDatosProyecto().getTxtResponsable().setText("");
			inicio.getVentanaMiembros().gettabla().vaciartabla();
		}
	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ListSelectionModel rowSM = table.getSelectionModel();
			rowSM.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if (!lsm.isSelectionEmpty()) {
						int filaSeleccionada = lsm.getMinSelectionIndex();
						modeloTabla.eliminaFila(filaSeleccionada);
						
					}
					
				}
			});
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
}
