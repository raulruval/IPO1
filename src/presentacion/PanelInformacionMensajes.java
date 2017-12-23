package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PanelInformacionMensajes extends JPanel {
	private JLabel lblAsunto;
	private JTextField textField_Asunto;
	private JLabel lblRemitente;
	private JTextField textField_Remitente;
	private JTextArea textArea_Mensaje;
	private JToolBar toolBar;
	private JButton btnEnviar;

	/**
	 * Create the panel.
	 */
	public PanelInformacionMensajes() {
		setBorder(new TitledBorder(null, "Informaci\u00F3n del mensaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 106, 0, 85, 23, 0};
		gridBagLayout.rowHeights = new int[]{49, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblAsunto = new JLabel("Asunto:");
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
		
		lblRemitente = new JLabel("Remitente:");
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
		
		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.EAST;
		gbc_toolBar.insets = new Insets(0, 0, 0, 5);
		gbc_toolBar.gridx = 3;
		gbc_toolBar.gridy = 3;
		add(toolBar, gbc_toolBar);
		
		btnEnviar = new JButton("Enviar");
		toolBar.add(btnEnviar);

	}

}
