package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dominio.Proyecto;
import dominio.Usuario;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelDatosUsuario extends JPanel {
	private JLabel lblNombre;
	private JLabel lblDescripcin;
	private JLabel lblResponsable;
	private JTextField txtNombre;
	private JTextField txtResponsable;
	private JTextArea textDescripcion;
	private JToolBar toolBar;
	private JButton btnGuardar;
	private JButton button;
	PanelInicio inicio;
	Proyecto pro;
	int posicion=0;
	int posicion1=-1;
	/**
	 * Create the panel.
	 */
	public PanelDatosUsuario() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), MessagesIPO1Inter.getString("PanelDatosUsuario.1"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$ //$NON-NLS-2$
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{176, 233, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 187, 33, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNombre = new JLabel(MessagesIPO1Inter.getString("PanelDatosUsuario.2")); //$NON-NLS-1$
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
		
		lblDescripcin = new JLabel(MessagesIPO1Inter.getString("PanelDatosUsuario.3")); //$NON-NLS-1$
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
		
		lblResponsable = new JLabel(MessagesIPO1Inter.getString("PanelDatosUsuario.4")); //$NON-NLS-1$
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
		
		btnGuardar = new JButton(MessagesIPO1Inter.getString("PanelDatosUsuario.5")); //$NON-NLS-1$
		btnGuardar.setPreferredSize(new Dimension(85, 25));
		btnGuardar.setMinimumSize(new Dimension(100, 35));
		btnGuardar.setMaximumSize(new Dimension(100, 35));
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		btnGuardar.setIcon(new ImageIcon(PanelDatosUsuario.class.getResource("/recursos/icons8-save-30.png"))); //$NON-NLS-1$
		toolBar.add(btnGuardar);
		
		button = new JButton(MessagesIPO1Inter.getString("PanelDatosUsuario.7")); //$NON-NLS-1$
		button.addActionListener(new ButtonActionListener());
		button.setIcon(new ImageIcon(PanelDatosUsuario.class.getResource("/recursos/icons8-edit-property-30.png"))); //$NON-NLS-1$
		button.setMinimumSize(new Dimension(100, 30));
		button.setMaximumSize(new Dimension(100, 35));
		toolBar.add(button);
		txtResponsable.setEnabled(false);
		txtNombre.setEnabled(false);
		textDescripcion.setEnabled(false);

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

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtResponsable.setEnabled(true);
			txtNombre.setEnabled(true);
			textDescripcion.setEnabled(true);
			
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(posicion==0){
				Usuario us= new Usuario( txtNombre.getText(),textDescripcion.getText(), textDescripcion.getText(),txtResponsable.getText(),textDescripcion.getText() );
				ArrayList<Usuario> miembros=pro.getMiembros();
				miembros.add(inicio.getVentanaMiembros().gettabla().getRowCount(), us);
				inicio.getProyectos().get(posicion1).setMiembros(miembros);
				inicio.getVentanaMiembros().aniademiembro(us);
				
			} else if(posicion!=0){
				inicio.getVentanaMiembros().usuarios.get(posicion).setNombre(txtNombre.getText());
				inicio.getVentanaMiembros().usuarios.get(posicion).setInformacion(textDescripcion.getText());
				inicio.getVentanaMiembros().usuarios.get(posicion).setConocimientos(txtResponsable.getText());
			}
			JOptionPane.showMessageDialog(null, MessagesIPO1Inter.getString("PanelDatosUsuario.8"), MessagesIPO1Inter.getString("PanelDatosUsuario.8"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	public void setinicio(PanelInicio in){
		inicio=in;
	}
	public void setproyecto(Proyecto proy){
		pro=proy;
	}
	public void setusuario(int posicion){
		this.posicion=posicion;
	}
	public void setposicion1(int pos){
		posicion1=pos;
	}
}
