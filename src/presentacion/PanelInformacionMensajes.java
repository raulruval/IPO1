package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class PanelInformacionMensajes extends JPanel {
	private JLabel lblAsunto;
	private JTextField textField_Asunto;
	private JLabel lblRemitente;
	private JTextField textField_Remitente;
	private JTextArea textArea_Mensaje;
	private JToolBar toolBar;
	private JButton btnEnviar;
	PanelInicio inicio;
	private JButton btnModificar;
	/**
	 * Create the panel.
	 */
	public PanelInformacionMensajes() {
		setBorder(new TitledBorder(null, MessagesIPO1Inter.getString("PanelInformacionMensajes.0"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 106, 0, 85, 23, 0};
		gridBagLayout.rowHeights = new int[]{49, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblAsunto = new JLabel(MessagesIPO1Inter.getString("PanelInformacionMensajes.1")); //$NON-NLS-1$
		GridBagConstraints gbc_lblAsunto = new GridBagConstraints();
		gbc_lblAsunto.anchor = GridBagConstraints.EAST;
		gbc_lblAsunto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsunto.gridx = 1;
		gbc_lblAsunto.gridy = 0;
		add(lblAsunto, gbc_lblAsunto);
		
		textField_Asunto = new JTextField();
		textField_Asunto.setColumns(10);
		GridBagConstraints gbc_textField_Asunto = new GridBagConstraints();
		gbc_textField_Asunto.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Asunto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Asunto.gridx = 2;
		gbc_textField_Asunto.gridy = 0;
		add(textField_Asunto, gbc_textField_Asunto);
		
		lblRemitente = new JLabel(MessagesIPO1Inter.getString("PanelInformacionMensajes.2")); //$NON-NLS-1$
		GridBagConstraints gbc_lblRemitente = new GridBagConstraints();
		gbc_lblRemitente.anchor = GridBagConstraints.EAST;
		gbc_lblRemitente.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemitente.gridx = 1;
		gbc_lblRemitente.gridy = 1;
		add(lblRemitente, gbc_lblRemitente);
		
		textField_Remitente = new JTextField();
		textField_Remitente.setColumns(10);
		GridBagConstraints gbc_textField_Remitente = new GridBagConstraints();
		gbc_textField_Remitente.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Remitente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Remitente.gridx = 2;
		gbc_textField_Remitente.gridy = 1;
		add(textField_Remitente, gbc_textField_Remitente);
		
		textArea_Mensaje = new JTextArea();
		GridBagConstraints gbc_textArea_Mensaje = new GridBagConstraints();
		gbc_textArea_Mensaje.gridwidth = 3;
		gbc_textArea_Mensaje.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_Mensaje.fill = GridBagConstraints.BOTH;
		gbc_textArea_Mensaje.gridx = 1;
		gbc_textArea_Mensaje.gridy = 2;
		add(textArea_Mensaje, gbc_textArea_Mensaje);
		textArea_Mensaje.setEnabled(false);
		textField_Asunto.setEnabled(false);
		textField_Remitente.setEnabled(false);
		
		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.EAST;
		gbc_toolBar.insets = new Insets(0, 0, 0, 5);
		gbc_toolBar.gridx = 3;
		gbc_toolBar.gridy = 3;
		add(toolBar, gbc_toolBar);
		
		btnEnviar = new JButton(MessagesIPO1Inter.getString("PanelInformacionMensajes.3")); //$NON-NLS-1$
		btnEnviar.addActionListener(new BtnEnviarActionListener());
		btnEnviar.setMinimumSize(new Dimension(100, 30));
		btnEnviar.setMaximumSize(new Dimension(100, 35));
		btnEnviar.setIcon(new ImageIcon(PanelInformacionMensajes.class.getResource("/recursos/icons8-send-30.png"))); //$NON-NLS-1$
		toolBar.add(btnEnviar);
		btnEnviar.setEnabled(false);
		
		btnModificar = new JButton(MessagesIPO1Inter.getString("PanelInformacionMensajes.5")); //$NON-NLS-1$
		btnModificar.setIcon(new ImageIcon(PanelInformacionMensajes.class.getResource("/recursos/icons8-edit-property-30.png"))); //$NON-NLS-1$
		btnModificar.setMinimumSize(new Dimension(100, 30));
		btnModificar.setMaximumSize(new Dimension(100, 35));
		btnModificar.addActionListener(new BtnModificarActionListener());
		toolBar.add(btnModificar);
		btnModificar.setEnabled(false);

	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public JButton getBtnEnviar() {
		return btnEnviar;
	}
	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}
	public void setinicio(PanelInicio in) {
		inicio = in;
	}
	public JTextField getTextField_Asunto() {
		return textField_Asunto;
	}
	public void setTextField_Asunto(JTextField textField_Asunto) {
		this.textField_Asunto = textField_Asunto;
	}
	public JTextField getTextField_Remitente() {
		return textField_Remitente;
	}
	public void setTextField_Remitente(JTextField textField_Remitente) {
		this.textField_Remitente = textField_Remitente;
	}
	public JTextArea getTextArea_Mensaje() {
		return textArea_Mensaje;
	}
	public void setTextArea_Mensaje(JTextArea textArea_Mensaje) {
		this.textArea_Mensaje = textArea_Mensaje;
	}

	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textArea_Mensaje.setEnabled(true);
			textField_Asunto.setEnabled(true);
			textField_Remitente.setEnabled(true);
			btnEnviar.setEnabled(true);
		}
	}
	private class BtnEnviarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null, MessagesIPO1Inter.getString("PanelInformacionMensajes.7"), MessagesIPO1Inter.getString("PanelInformacionMensajes.8"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			
			textArea_Mensaje.setText(""); //$NON-NLS-1$
			textField_Asunto.setText(""); //$NON-NLS-1$
			textField_Remitente.setText(""); //$NON-NLS-1$
			textArea_Mensaje.setEnabled(false);
			textField_Asunto.setEnabled(false);
			textField_Remitente.setEnabled(false);
			btnModificar.setEnabled(false);
			btnEnviar.setEnabled(false);
			inicio.getVentanaMensajes().getButton_1().setEnabled(false);
			
			
		}
	}
	
}
