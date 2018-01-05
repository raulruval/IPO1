package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dominio.Proyecto;
import dominio.Usuario;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.ComponentOrientation;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMiembros extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private JToolBar toolBar;
	private JButton btnAñadir;
	private JButton btnBorrar;
	MiModeloTabla modeloTabla = new MiModeloTabla();
	PanelInicio inicio;
	ArrayList<Proyecto> proyectos;
	ArrayList<Usuario> usuarios;

	/**
	 * Create the panel.
	 */
	public PanelMiembros() {
		
		setBorder(new TitledBorder(null, MessagesIPO1Inter.getString("PanelMiembros.0"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
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
		
		btnAñadir = new JButton(MessagesIPO1Inter.getString("PanelMiembros.1")); //$NON-NLS-1$
		btnAñadir.addActionListener(new BtnAñadirActionListener());
		btnAñadir.setMinimumSize(new Dimension(100, 30));
		btnAñadir.setMaximumSize(new Dimension(100, 35));
		btnAñadir.setIcon(new ImageIcon(PanelMiembros.class.getResource("/recursos/icons8-add-property-30.png"))); //$NON-NLS-1$
		toolBar.add(btnAñadir);
		btnAñadir.setEnabled(false);
		
		btnBorrar = new JButton(MessagesIPO1Inter.getString("PanelMiembros.3")); //$NON-NLS-1$
		btnBorrar.addActionListener(new BtnBorrarActionListener());
		btnBorrar.setMinimumSize(new Dimension(100, 30));
		btnBorrar.setMaximumSize(new Dimension(100, 35));
		btnBorrar.setIcon(new ImageIcon(PanelMiembros.class.getResource("/recursos/icons8-trash-can-30.png"))); //$NON-NLS-1$
		toolBar.add(btnBorrar);
		btnBorrar.setEnabled(false);
		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (!lsm.isSelectionEmpty()) {
					int filaSeleccionada = lsm.getMinSelectionIndex();
					int n= inicio.getVentanaProyectos().getTable().getSelectedRow();
					proyectos=inicio.getVentanaProyectos().getproyectos();
					usuarios=proyectos.get(n).getMiembros();
					inicio.getVentanaDatosTareas().setVisible(false);
					inicio.getVentanaDatosProyecto().setVisible(false);
					inicio.getVentanaDatosUsuario().setVisible(true);
					Usuario us =usuarios.get(filaSeleccionada);
					inicio.getVentanaDatosUsuario().setusuario(filaSeleccionada);
					inicio.getVentanaDatosUsuario().getTxtNombre().setText(us.getNombre());
					inicio.getVentanaDatosUsuario().getTxtResponsable().setText(us.getConocimientos());
					inicio.getVentanaDatosUsuario().getTextDescripcion().setText(us.getHabilidades());
					inicio.getVentanaDatosUsuario().getTxtNombre().setEnabled(false);
					inicio.getVentanaDatosUsuario().getTxtResponsable().setEnabled(false);
					inicio.getVentanaDatosUsuario().getTextDescripcion().setEnabled(false);
					btnBorrar.setEnabled(true);
				}
			}
		});

	}
	
	public JButton getBtnAñadir() {
		return btnAñadir;
	}
	public void setBtnAñadir(JButton btnAñadir) {
		this.btnAñadir = btnAñadir;
	}
	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}
	public void aniadefila(Proyecto pro){
		ArrayList<Usuario> miembrosproyecto= pro.getMiembros();
		int num=pro.getMiembros().size()/2;
		if(num<1){
			num=1;
		}
		for(int i=0; i<num;i++){
			String[] fila1 = {miembrosproyecto.get(i).getNombre()};
			modeloTabla.aniadeFila(fila1);
		}
	}
	public void aniademiembro(Usuario us){
		String[] fila1 = {us.getNombre()};
		modeloTabla.aniadeFila(fila1);
		modeloTabla.fireTableDataChanged();
	}
	public MiModeloTabla gettabla(){
		return modeloTabla;
	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int p = JOptionPane.showOptionDialog(null, MessagesIPO1Inter.getString("PanelMiembros.5"), //$NON-NLS-1$
					MessagesIPO1Inter.getString("PanelMiembros.6"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, //$NON-NLS-1$
					null);
			if (p == 0) {
				MiModeloTabla modeloTabla = (MiModeloTabla) table.getModel();
				int n = table.getSelectedRow();
				if (n != -1)
					modeloTabla.eliminaFila(table.getSelectedRow());
				modeloTabla.fireTableDataChanged();
			}
			btnBorrar.setEnabled(false);
		}
	}
	private class BtnAñadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MiModeloTabla modeloTabla = inicio.getVentanaProyectos().getmodelotabla();
			int n= inicio.getVentanaProyectos().getTable().getSelectedRow();
			inicio.getVentanaDatosProyecto().setVisible(false);
			inicio.getVentanaDatosUsuario().setVisible(true);
			JOptionPane.showMessageDialog(null, MessagesIPO1Inter.getString("PanelMiembros.7"), MessagesIPO1Inter.getString("PanelMiembros.8"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			inicio.getVentanaDatosUsuario().getTxtNombre().setText("");
			inicio.getVentanaDatosUsuario().getTxtNombre().setEnabled(true);
			inicio.getVentanaDatosUsuario().getTxtResponsable().setText("");
			inicio.getVentanaDatosUsuario().getTxtResponsable().setEnabled(true);
			inicio.getVentanaDatosUsuario().getTextDescripcion().setText("");
			inicio.getVentanaDatosUsuario().getTextDescripcion().setEnabled(true);
			inicio.getVentanaDatosUsuario().setusuario(0);
			btnBorrar.setEnabled(false);
		}
	}
	public void setinicio(PanelInicio in) {
		inicio = in;
	}
}
