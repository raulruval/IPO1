package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.ComponentOrientation;

public class PanelTareas extends JPanel {
	private JScrollPane scrollPane;
	private JToolBar toolBar;
	private JButton btnBorrar;
	private JTable table;
	
	
	//MimodelotablaTareas modeloTablaTareas = new MimodelotablaTareas();
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
	//	table.setModel(modeloTablaTareas);
		scrollPane.setViewportView(table);
		
		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(toolBar, BorderLayout.SOUTH);
		
		btnAñadir = new JButton("Añadir");
		toolBar.add(btnAñadir);
		
		btnBorrar = new JButton("Borrar");
		toolBar.add(btnBorrar);

	}

}
