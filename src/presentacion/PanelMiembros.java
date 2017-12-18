package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.ComponentOrientation;

public class PanelMiembros extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private JToolBar toolBar;
	private JButton btnAñadir;
	private JButton btnBorrar;

	/**
	 * Create the panel.
	 */
	public PanelMiembros() {
		setBorder(new TitledBorder(null, "Miembros:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
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
