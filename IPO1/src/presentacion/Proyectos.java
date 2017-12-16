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
import javax.swing.ListSelectionModel;

public class Proyectos extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnBorrar;
	private JButton btnAadir;
	private JToolBar toolBar;

	private Inicio inicio;
	private DatosProyecto datpro;

	ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
	private Proyecto pro;

	public Proyectos() {
		setBorder(new TitledBorder(null, "Proyectos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		MiModeloTabla modeloTabla = new MiModeloTabla();

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modeloTabla);
		table.setCellSelectionEnabled(true);

		// String[] fila1= { dominio.persistencia.pro1.getNombre() };
		// modeloTabla.aniadeFila(fila1);
		proyectos = dominio.persistencia.inicializar();

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
		toolBar.add(btnAadir);

		btnBorrar = new JButton("Borrar");
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
					datpro=inicio.getVentanaDatosProyecto();
					datpro.getTxtResponsable().setText(nombre);
			
				}
			}
		});
	}

}
