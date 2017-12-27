package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dominio.Proyecto;
import dominio.Usuario;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.util.ArrayList;

public class PanelMiembros extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private JToolBar toolBar;
	private JButton btnAñadir;
	private JButton btnBorrar;
	MiModeloTabla modeloTabla = new MiModeloTabla();
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
		table.setModel(modeloTabla);
		table.setCellSelectionEnabled(true);
		
		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(toolBar, BorderLayout.SOUTH);
		
		btnAñadir = new JButton("Añadir");
		toolBar.add(btnAñadir);
		
		btnBorrar = new JButton("Borrar");
		toolBar.add(btnBorrar);

	}
	public void aniadefila(Proyecto pro){
		ArrayList<Usuario> miembrosproyecto= pro.getMiembros();
		for(int i=0; i<(pro.getMiembros().size());i++){
			String[] fila1 = {miembrosproyecto.get(i).getNombre()};
			modeloTabla.aniadeFila(fila1);
		}
	}
	public MiModeloTabla gettabla(){
		return modeloTabla;
	}

}
