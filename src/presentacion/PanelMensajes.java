package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;

public class PanelMensajes extends JPanel {
	private JScrollPane scrollPane;
	private JToolBar toolBar;
	private JTable table;
	private JButton button;
	private JButton button_1;

	/**
	 * Create the panel.
	 */
	public PanelMensajes() {
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(toolBar, BorderLayout.SOUTH);
		
		button = new JButton("Añadir");
		toolBar.add(button);
		
		button_1 = new JButton("Borrar");
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		toolBar.add(button_1);

	}

}
