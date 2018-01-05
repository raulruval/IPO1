package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;

import dominio.Tarea;
import dominio.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class PanelDatosTareas extends JPanel {
	private JLabel lblNombre;
	private JLabel lblEncargado;
	private JLabel lblFechaFinal;
	private JLabel lblEtiquetas;
	private JLabel lblComentarios;
	private JTextField txtNombre;
	private JTextField txtEncargado;
	private JTextField txtFecha;
	private JTextField txtEtiquetas;
	private JTextArea textComentarios;
	private JToolBar toolBar;
	private JButton button;
	private JButton button_1;
	int posicion = 0;

	PanelInicio inicio;

	public PanelDatosTareas() {
		setBorder(new TitledBorder(null, MessagesIPO1Inter.getString("PanelDatosTareas.0"), TitledBorder.LEADING, //$NON-NLS-1$
				TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 110, 123, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblNombre = new JLabel(MessagesIPO1Inter.getString("PanelDatosTareas.1")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		add(txtNombre, gbc_txtNombre);

		lblEncargado = new JLabel(MessagesIPO1Inter.getString("PanelDatosTareas.2")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEncargado = new GridBagConstraints();
		gbc_lblEncargado.anchor = GridBagConstraints.EAST;
		gbc_lblEncargado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEncargado.gridx = 0;
		gbc_lblEncargado.gridy = 1;
		add(lblEncargado, gbc_lblEncargado);

		txtEncargado = new JTextField();
		txtEncargado.setEnabled(false);
		txtEncargado.setColumns(10);
		GridBagConstraints gbc_txtEncargado = new GridBagConstraints();
		gbc_txtEncargado.gridwidth = 2;
		gbc_txtEncargado.insets = new Insets(0, 0, 5, 5);
		gbc_txtEncargado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEncargado.gridx = 1;
		gbc_txtEncargado.gridy = 1;
		add(txtEncargado, gbc_txtEncargado);

		lblFechaFinal = new JLabel(MessagesIPO1Inter.getString("PanelDatosTareas.3")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaFinal = new GridBagConstraints();
		gbc_lblFechaFinal.anchor = GridBagConstraints.EAST;
		gbc_lblFechaFinal.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaFinal.gridx = 0;
		gbc_lblFechaFinal.gridy = 2;
		add(lblFechaFinal, gbc_lblFechaFinal);

		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setColumns(10);
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.gridwidth = 2;
		gbc_txtFecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.gridx = 1;
		gbc_txtFecha.gridy = 2;
		add(txtFecha, gbc_txtFecha);

		lblEtiquetas = new JLabel(MessagesIPO1Inter.getString("PanelDatosTareas.4")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEtiquetas = new GridBagConstraints();
		gbc_lblEtiquetas.anchor = GridBagConstraints.EAST;
		gbc_lblEtiquetas.insets = new Insets(0, 0, 5, 5);
		gbc_lblEtiquetas.gridx = 0;
		gbc_lblEtiquetas.gridy = 3;
		add(lblEtiquetas, gbc_lblEtiquetas);

		txtEtiquetas = new JTextField();
		txtEtiquetas.setEnabled(false);
		txtEtiquetas.setColumns(10);
		GridBagConstraints gbc_txtEtiquetas = new GridBagConstraints();
		gbc_txtEtiquetas.anchor = GridBagConstraints.NORTH;
		gbc_txtEtiquetas.gridwidth = 2;
		gbc_txtEtiquetas.insets = new Insets(0, 0, 5, 5);
		gbc_txtEtiquetas.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEtiquetas.gridx = 1;
		gbc_txtEtiquetas.gridy = 3;
		add(txtEtiquetas, gbc_txtEtiquetas);

		lblComentarios = new JLabel(MessagesIPO1Inter.getString("PanelDatosTareas.5")); //$NON-NLS-1$
		GridBagConstraints gbc_lblComentarios = new GridBagConstraints();
		gbc_lblComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblComentarios.gridx = 0;
		gbc_lblComentarios.gridy = 4;
		add(lblComentarios, gbc_lblComentarios);

		textComentarios = new JTextArea();
		textComentarios.setEnabled(false);
		GridBagConstraints gbc_textComentarios = new GridBagConstraints();
		gbc_textComentarios.gridwidth = 2;
		gbc_textComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_textComentarios.fill = GridBagConstraints.BOTH;
		gbc_textComentarios.gridx = 1;
		gbc_textComentarios.gridy = 4;
		add(textComentarios, gbc_textComentarios);

		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.gridx = 2;
		gbc_toolBar.gridy = 5;
		add(toolBar, gbc_toolBar);

		button_1 = new JButton(MessagesIPO1Inter.getString("PanelDatosTareas.6")); //$NON-NLS-1$
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setMinimumSize(new Dimension(100, 35));
		button_1.setMaximumSize(new Dimension(100, 35));
		button_1.setPreferredSize(new Dimension(85, 25));
		button_1.setIcon(new ImageIcon(PanelDatosTareas.class.getResource("/recursos/icons8-save-30.png"))); //$NON-NLS-1$
		toolBar.add(button_1);

		button = new JButton(MessagesIPO1Inter.getString("PanelDatosTareas.7")); //$NON-NLS-1$
		button.addActionListener(new ButtonActionListener_1());
		button.setIcon(new ImageIcon(PanelDatosTareas.class.getResource("/recursos/icons8-edit-property-30.png"))); //$NON-NLS-1$
		button.setMinimumSize(new Dimension(100, 30));
		button.setMaximumSize(new Dimension(100, 35));
		toolBar.add(button);

	}

	public PanelInicio getInicio() {
		return inicio;
	}

	public void setInicio(PanelInicio inicio) {
		this.inicio = inicio;
	}

	public JTextField getTextNombre() {
		return txtNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.txtNombre = textNombre;
	}

	public JTextField getTextEncargado() {
		return txtEncargado;
	}

	public JTextArea getTextComentarios() {
		return textComentarios;
	}

	public void setTextComentarios(JTextArea textComentarios) {
		this.textComentarios = textComentarios;
	}

	public void setTextEncargado(JTextField textEncargado) {
		this.txtEncargado = textEncargado;
	}

	public JTextField getTextFecha() {
		return txtFecha;
	}

	public void setTextFecha(JTextField textFecha) {
		this.txtFecha = textFecha;
	}

	public JTextField getTextEtiquetas() {
		return txtEtiquetas;
	}

	public void setTextEtiquetas(JTextField textEtiquetas) {
		this.txtEtiquetas = textEtiquetas;
	}

	public JTextArea getTextArea() {
		return textComentarios;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public void setTextArea(JTextArea textArea) {
		this.textComentarios = textArea;
	}

	private class ButtonActionListener_1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			txtEncargado.setEnabled(true);
			txtNombre.setEnabled(true);
			textComentarios.setEnabled(true);
			txtEtiquetas.setEnabled(true);
			txtFecha.setEnabled(true);

		}
	}

	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (posicion == 0) {
				Usuario us = new Usuario(txtEncargado.getText(), "", "", "", "");
				Tarea tar = new Tarea(txtNombre.getText(), us, txtFecha.getText(), txtEtiquetas.getText(),
						textComentarios.getText());
				inicio.getVentanaTareas().getPro().getTareas()
						.add((inicio.getVentanaTareas().getPro().getTareas().size() / 2), tar);
				;
				inicio.getVentanaTareas().aniadetarea(tar);

			} else if (posicion != 0) {
				inicio.getVentanaTareas().getPro().getTareas().get(posicion).setNombre(txtNombre.getText());
				inicio.getVentanaTareas().getPro().getTareas().get(posicion).setFechafinal(txtFecha.getText());
				inicio.getVentanaTareas().getPro().getTareas().get(posicion).setEtiquetas(txtEtiquetas.getText());
				if (inicio.getVentanaTareas().getPro().getTareas().get(posicion).getEncargado()
						.getNombre() != txtEncargado.getText()) {
					Usuario us = new Usuario(txtEncargado.getText(), "", "", "", "");
					inicio.getVentanaTareas().getPro().getTareas().get(posicion).setEncargado(us);
				}
				inicio.getVentanaTareas().getPro().getTareas().get(posicion).setComentarios(textComentarios.getText());

			}
			inicio.getVentanaTareas().gettabla().fireTableDataChanged();
			JOptionPane.showMessageDialog(null, MessagesIPO1Inter.getString("PanelDatosTareas.23"), MessagesIPO1Inter.getString("PanelDatosTareas.24"), JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
