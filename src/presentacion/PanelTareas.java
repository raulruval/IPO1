package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Proyecto;
import dominio.Tarea;
import dominio.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTareas extends JPanel {
	private JScrollPane scrollPane;
	private JToolBar toolBar;
	private JButton btnBorrar;
	private JTable table;
	
	
	MimodelotablaTareas modeloTablaTareas = new MimodelotablaTareas();
	private JButton btnAñadir;
	/**
	 * Create the panel.
	 */
	public PanelTareas() {
		setBorder(new TitledBorder(null, "Tareas:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modeloTablaTareas);
		table.setCellSelectionEnabled(true);
		
		
		scrollPane.setViewportView(table);
		
		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(toolBar, BorderLayout.SOUTH);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(new BtnAñadirActionListener());
		btnAñadir.setMinimumSize(new Dimension(100, 30));
		btnAñadir.setMaximumSize(new Dimension(100, 35));
		btnAñadir.setIcon(new ImageIcon(PanelTareas.class.getResource("/recursos/icons8-add-property-30.png")));
		toolBar.add(btnAñadir);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new BtnBorrarActionListener());
		btnBorrar.setMinimumSize(new Dimension(100, 35));
		btnBorrar.setMaximumSize(new Dimension(100, 35));
		btnBorrar.setIcon(new ImageIcon(PanelTareas.class.getResource("/recursos/icons8-trash-can-30.png")));
		toolBar.add(btnBorrar);

	}
	public void aniadefila(Proyecto pro){
		ArrayList<Tarea> tareasproyecto= pro.getTareas();
		for(int i=0; i<(pro.getTareas().size());i++){
			String[] fila1 = {tareasproyecto.get(i).getNombre()};
			modeloTablaTareas.aniadeFila(fila1);
		}
	}
	public MimodelotablaTareas gettabla(){
		return modeloTablaTareas;
	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			int p = JOptionPane.showOptionDialog(null, "¿Seguro que desea eliminar esta tarea?",
					"Eliminación de tarea", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
					null);
			if (p == 0) {
			}
		}
	}
	private class BtnAñadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Tarea añadida correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
