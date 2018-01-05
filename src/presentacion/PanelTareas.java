package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	PanelInicio inicio;
	Proyecto pro;
	Tarea tarea;
	MimodelotablaTareas modeloTablaTareas = new MimodelotablaTareas();
	private JButton btnAñadir;
	/**
	 * Create the panel.
	 */
	public PanelTareas() {
		setBorder(new TitledBorder(null, MessagesIPO1Inter.getString("PanelTareas.0"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modeloTablaTareas);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
		scrollPane.setViewportView(table);
		
		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(toolBar, BorderLayout.SOUTH);
		
		btnAñadir = new JButton(MessagesIPO1Inter.getString("PanelTareas.1")); //$NON-NLS-1$
		btnAñadir.addActionListener(new BtnAñadirActionListener());
		btnAñadir.setMinimumSize(new Dimension(100, 30));
		btnAñadir.setMaximumSize(new Dimension(100, 35));
		btnAñadir.setIcon(new ImageIcon(PanelTareas.class.getResource("/recursos/icons8-add-property-30.png"))); //$NON-NLS-1$
		toolBar.add(btnAñadir);
		btnAñadir.setEnabled(false);
		btnBorrar = new JButton(MessagesIPO1Inter.getString("PanelTareas.3")); //$NON-NLS-1$
		btnBorrar.addActionListener(new BtnBorrarActionListener());
		btnBorrar.setMinimumSize(new Dimension(100, 35));
		btnBorrar.setMaximumSize(new Dimension(100, 35));
		btnBorrar.setIcon(new ImageIcon(PanelTareas.class.getResource("/recursos/icons8-trash-can-30.png"))); //$NON-NLS-1$
		toolBar.add(btnBorrar);
		btnBorrar.setEnabled(false);
		
		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (!lsm.isSelectionEmpty()) {
					int filaSeleccionada = lsm.getMinSelectionIndex();
					tarea=pro.getTareas().get(filaSeleccionada);
					inicio.getVentanaDatosUsuario().setVisible(false);
					inicio.getVentanaDatosProyecto().setVisible(false);
					inicio.getVentanaDatosTareas().setVisible(true);
					inicio.getVentanaDatosTareas().getTextNombre().setEnabled(false);
					inicio.getVentanaDatosTareas().getTextEncargado().setEnabled(false);
					inicio.getVentanaDatosTareas().getTextFecha().setEnabled(false);
					inicio.getVentanaDatosTareas().getTextEtiquetas().setEnabled(false);
					inicio.getVentanaDatosTareas().getTextComentarios().setEnabled(false);
					inicio.getVentanaDatosTareas().getTextNombre().setText(tarea.getNombre());
					inicio.getVentanaDatosTareas().getTextEncargado().setText(tarea.getEncargado().getNombre());
					inicio.getVentanaDatosTareas().getTextFecha().setText(tarea.getFechafinal());
					inicio.getVentanaDatosTareas().getTextEtiquetas().setText(tarea.getEtiquetas());
					inicio.getVentanaDatosTareas().getTextComentarios().setText(tarea.getComentarios());
					inicio.getVentanaDatosTareas().setPosicion(filaSeleccionada);
					btnBorrar.setEnabled(true);
				}
			}
		});
	}
	public Tarea getTarea() {
		return tarea;
	}
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	public Proyecto getPro() {
		return pro;
	}
	public void setPro(Proyecto pro) {
		this.pro = pro;
	}
	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}
	public JButton getBtnAñadir() {
		return btnAñadir;
	}
	public void setBtnAñadir(JButton btnAñadir) {
		this.btnAñadir = btnAñadir;
	}
	public void setinicio(PanelInicio in){
		inicio=in;
	}
	public void aniadefila(Proyecto pro){
		ArrayList<Tarea> tareasproyecto= pro.getTareas();
		for(int i=0; i<(pro.getTareas().size())/2;i++){
			String[] fila1 = {tareasproyecto.get(i).getNombre(), tareasproyecto.get(i).getEncargado().getNombre(),
					tareasproyecto.get(i).getFechafinal(), tareasproyecto.get(i).getEtiquetas(), tareasproyecto.get(i).getComentarios()};
			modeloTablaTareas.aniadeFila(fila1);
		}
	}
	public void aniadetarea(Tarea tar){
		String[] fila1 = {tar.getNombre(), tar.getEncargado().getNombre(),
				tar.getFechafinal(), tar.getEtiquetas(), tar.getComentarios()};
		modeloTablaTareas.aniadeFila(fila1);
		modeloTablaTareas.fireTableDataChanged();
		
	}
	public MimodelotablaTareas gettabla(){
		return modeloTablaTareas;
	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			int p = JOptionPane.showOptionDialog(null, MessagesIPO1Inter.getString("PanelTareas.5"), //$NON-NLS-1$
					MessagesIPO1Inter.getString("PanelTareas.6"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, //$NON-NLS-1$
					null);
			if (p == 0) {
				MimodelotablaTareas modeloTabla = (MimodelotablaTareas) table.getModel();
				int n = table.getSelectedRow();
				if (n != -1)
					modeloTabla.eliminaFila(table.getSelectedRow());
			}
			modeloTablaTareas.fireTableDataChanged();
			btnBorrar.setEnabled(false);
			inicio.getVentanaDatosTareas().setPosicion(0);
		}
	}
	private class BtnAñadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnBorrar.setEnabled(false);
			inicio.getVentanaDatosTareas().setVisible(true);
			inicio.getVentanaDatosTareas().getTextNombre().setEnabled(true);
			inicio.getVentanaDatosTareas().getTextFecha().setEnabled(true);
			inicio.getVentanaDatosTareas().getTextEtiquetas().setEnabled(true);
			inicio.getVentanaDatosTareas().getTextEncargado().setEnabled(true);
			inicio.getVentanaDatosTareas().getTextComentarios().setEnabled(true);
			inicio.getVentanaDatosTareas().getTextNombre().setText("");
			inicio.getVentanaDatosTareas().getTextFecha().setText("");
			inicio.getVentanaDatosTareas().getTextEtiquetas().setText("");
			inicio.getVentanaDatosTareas().getTextEncargado().setText("");
			inicio.getVentanaDatosTareas().getTextComentarios().setText("");;
			inicio.getVentanaDatosTareas().setPosicion(0);
			JOptionPane.showMessageDialog(null, MessagesIPO1Inter.getString("PanelTareas.12") //$NON-NLS-1$
					+ MessagesIPO1Inter.getString("PanelTareas.13"), MessagesIPO1Inter.getString("PanelTareas.14"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	
}
