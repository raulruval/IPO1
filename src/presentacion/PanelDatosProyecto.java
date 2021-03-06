package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dominio.Proyecto;
import dominio.Tarea;
import dominio.Usuario;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TexturePaint;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class PanelDatosProyecto extends JPanel {
	private JLabel lblNombre;
	private JLabel lblDescripcin;
	private JLabel lblResponsable;
	private JTextField txtNombre;
	private JTextField txtResponsable;
	private JTextArea textDescripcion;
	private JToolBar toolBar;
	private JButton btnGuardar;
	private PanelInicio inicio;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public PanelDatosProyecto() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), MessagesIPO1Inter.getString("PanelDatosProyecto.1"), //$NON-NLS-1$ //$NON-NLS-2$
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 176, 233, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 187, 33, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblNombre = new JLabel(MessagesIPO1Inter.getString("PanelDatosProyecto.2")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		lblDescripcin = new JLabel(MessagesIPO1Inter.getString("PanelDatosProyecto.3")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 1;
		add(lblDescripcin, gbc_lblDescripcin);

		textDescripcion = new JTextArea();
		GridBagConstraints gbc_textDescripcion = new GridBagConstraints();
		gbc_textDescripcion.gridwidth = 2;
		gbc_textDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textDescripcion.gridx = 1;
		gbc_textDescripcion.gridy = 1;
		add(textDescripcion, gbc_textDescripcion);

		lblResponsable = new JLabel(MessagesIPO1Inter.getString("PanelDatosProyecto.4")); //$NON-NLS-1$
		GridBagConstraints gbc_lblResponsable = new GridBagConstraints();
		gbc_lblResponsable.anchor = GridBagConstraints.EAST;
		gbc_lblResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsable.gridx = 0;
		gbc_lblResponsable.gridy = 2;
		add(lblResponsable, gbc_lblResponsable);

		txtResponsable = new JTextField();
		GridBagConstraints gbc_txtResponsable = new GridBagConstraints();
		gbc_txtResponsable.gridwidth = 2;
		gbc_txtResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_txtResponsable.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtResponsable.gridx = 1;
		gbc_txtResponsable.gridy = 2;
		add(txtResponsable, gbc_txtResponsable);
		txtResponsable.setColumns(10);

		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 0, 5);
		gbc_toolBar.gridx = 2;
		gbc_toolBar.gridy = 3;
		add(toolBar, gbc_toolBar);

		btnGuardar = new JButton(MessagesIPO1Inter.getString("PanelDatosProyecto.5")); //$NON-NLS-1$
		btnGuardar.setMinimumSize(new Dimension(100, 30));
		btnGuardar.setMaximumSize(new Dimension(100, 35));
		btnGuardar.setIcon(new ImageIcon(PanelDatosProyecto.class.getResource("/recursos/icons8-save-30.png"))); //$NON-NLS-1$
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		toolBar.add(btnGuardar);
		btnGuardar.setEnabled(false);
		
		btnModificar = new JButton(MessagesIPO1Inter.getString("PanelDatosProyecto.7")); //$NON-NLS-1$
		btnModificar.setMinimumSize(new Dimension(100, 30));
		btnModificar.setMaximumSize(new Dimension(100, 35));
		btnModificar.setIcon(new ImageIcon(PanelDatosProyecto.class.getResource("/recursos/icons8-edit-property-30.png"))); //$NON-NLS-1$
		btnModificar.addActionListener(new BtnModificarActionListener());
		toolBar.add(btnModificar);
		btnModificar.setEnabled(false);
		
		textDescripcion.setEnabled(false);
		txtNombre.setEnabled(false);
		txtResponsable.setEnabled(false);

	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setinicio(PanelInicio in) {
		inicio = in;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtResponsable() {
		return txtResponsable;
	}

	public void setTxtResponsable(JTextField txtResponsable) {
		this.txtResponsable = txtResponsable;
	}

	public JTextArea getTextDescripcion() {
		return textDescripcion;
	}

	public void setTextDescripcion(JTextArea textDescripcion) {
		this.textDescripcion = textDescripcion;
	}

	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(inicio.getVentanaProyectos().getPosicion()==-1){
				String Nombre = getTxtNombre().getText();
				String descripcion = getTextDescripcion().getText();
				String Responsable = getTxtResponsable().getText();
				//ArrayList<Usuario> us = dominio.persistencia.getusuarios();
				ArrayList<Tarea> tar = new ArrayList<Tarea>();
				ArrayList<Usuario> miembros = new ArrayList<Usuario>();
				Proyecto proyectoo;
				Usuario usus;
				usus = new Usuario(Responsable, "", null, null, "", "", ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				miembros.add(usus);
				proyectoo = new Proyecto(Nombre, descripcion, miembros, tar, usus);
				inicio.getProyectos().add(inicio.getVentanaProyectos().getmodelotabla().getRowCount(),proyectoo);
				dominio.persistencia.getProyectos().add(inicio.getVentanaProyectos().getmodelotabla().getRowCount(),proyectoo);
				String[] fila1 = { Nombre };
				inicio.getVentanaProyectos().getModeloTabla().aniadeFila(fila1);
				String[] fila2= { Responsable };
				inicio.getVentanaMiembros().gettabla().aniadeFila(fila2);
				inicio.getVentanaProyectos().getmodelotabla().fireTableDataChanged();
				inicio.getVentanaMiembros().gettabla().fireTableDataChanged();
			}
			else if(inicio.getVentanaProyectos().getPosicion()>=0){
				inicio.getProyectos().get(inicio.getVentanaProyectos().getPosicion()).setNombre(txtNombre.getText());
				inicio.getProyectos().get(inicio.getVentanaProyectos().getPosicion()).setDescripcion(textDescripcion.getText());
				inicio.getProyectos().get(inicio.getVentanaProyectos().getPosicion()).setResponsable(txtResponsable.getText());
			}
			
			JOptionPane.showMessageDialog(null, MessagesIPO1Inter.getString("PanelDatosProyecto.13"), MessagesIPO1Inter.getString("PanelDatosProyecto.14"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textDescripcion.setEnabled(true);
			txtNombre.setEnabled(true);
			txtResponsable.setEnabled(true);
		}
	}
}
