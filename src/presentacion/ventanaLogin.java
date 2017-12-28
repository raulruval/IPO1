package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class ventanaLogin {

	private JFrame frmAplicacionDeCorreo;
	private JPanel panel;
	private JLabel lblEstado;
	private JLabel lblUsuario;
	private JTextField tfUsuario;
	private JLabel lblContrasea;
	private JPasswordField pwdPassword;
	private JLabel lblAviso;
	private JButton btnEntrar;
	private String password="ipo1";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaLogin window = new ventanaLogin();
					window.frmAplicacionDeCorreo.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAplicacionDeCorreo = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Para que se abra a la dimensión de la pantalla
		frmAplicacionDeCorreo.setMinimumSize(new Dimension(screenSize.width/4, screenSize.height/3)); // Para que se abra en un tamaño adecuado
		frmAplicacionDeCorreo.setResizable(false);
		
		frmAplicacionDeCorreo.setTitle("Gestión de proyectos");
		frmAplicacionDeCorreo.setBounds(100, 100, 450, 317);
		frmAplicacionDeCorreo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAplicacionDeCorreo.setLocationRelativeTo(null); /// Para poner en el medio la ventana
		{
			panel = new JPanel();
			
			frmAplicacionDeCorreo.getContentPane().setLayout(new BorderLayout(0, 0));
			frmAplicacionDeCorreo.getContentPane().add(panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{49, 83, 265, 78, 0};
			gbl_panel.rowHeights = new int[]{64, 20, 20, 39, 23, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				{
					lblUsuario = new JLabel("Usuario:");
					lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
					GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
					gbc_lblUsuario.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
					gbc_lblUsuario.gridx = 1;
					gbc_lblUsuario.gridy = 1;
					panel.add(lblUsuario, gbc_lblUsuario);
				}
				tfUsuario = new JTextField();
				tfUsuario.addActionListener(new TfUsuarioActionListener());
				GridBagConstraints gbc_tfUsuario = new GridBagConstraints();
				gbc_tfUsuario.fill = GridBagConstraints.BOTH;
				gbc_tfUsuario.insets = new Insets(0, 0, 5, 5);
				gbc_tfUsuario.gridx = 2;
				gbc_tfUsuario.gridy = 1;
				panel.add(tfUsuario, gbc_tfUsuario);
				tfUsuario.setColumns(10);
				{
					lblContrasea = new JLabel("Contraseña:");
					lblContrasea.setEnabled(false);
					lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
					GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
					gbc_lblContrasea.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
					gbc_lblContrasea.gridx = 1;
					gbc_lblContrasea.gridy = 2;
					panel.add(lblContrasea, gbc_lblContrasea);
				}
				{
					pwdPassword = new JPasswordField();
					pwdPassword.addKeyListener(new PwdPasswordKeyListener());
					pwdPassword.addActionListener(new PwdPasswordActionListener());
					pwdPassword.setEnabled(false);
					GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
					gbc_pwdPassword.fill = GridBagConstraints.BOTH;
					gbc_pwdPassword.insets = new Insets(0, 0, 5, 5);
					gbc_pwdPassword.gridx = 2;
					gbc_pwdPassword.gridy = 2;
					panel.add(pwdPassword, gbc_pwdPassword);
				}
				{
					lblAviso = new JLabel("");
					lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
					lblAviso.setOpaque(true);
					GridBagConstraints gbc_lblAviso = new GridBagConstraints();
					gbc_lblAviso.fill = GridBagConstraints.BOTH;
					gbc_lblAviso.insets = new Insets(0, 0, 5, 5);
					gbc_lblAviso.gridx = 2;
					gbc_lblAviso.gridy = 3;
					panel.add(lblAviso, gbc_lblAviso);
				}
				{
					btnEntrar = new JButton("Entrar");
					btnEntrar.addActionListener(new BtnEntrarActionListener());
					btnEntrar.setEnabled(false);
					GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
					gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
					gbc_btnEntrar.anchor = GridBagConstraints.EAST;
					gbc_btnEntrar.fill = GridBagConstraints.VERTICAL;
					gbc_btnEntrar.gridx = 2;
					gbc_btnEntrar.gridy = 4;
					panel.add(btnEntrar, gbc_btnEntrar);
				}
			}
		}
		{
			lblEstado = new JLabel("Bienvenido a la aplicación de gestión de proyectos ");
			lblEstado.setOpaque(true);
			lblEstado.setBackground(new Color(30, 144, 255));
			lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
			frmAplicacionDeCorreo.getContentPane().add(lblEstado, BorderLayout.SOUTH);
		}
	}

	private class TfUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lblContrasea.setEnabled(true);
			pwdPassword.setEnabled(true);
			pwdPassword.requestFocus();
		}
	}
	private class PwdPasswordActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lblEstado.setText(e.getActionCommand());
				//obtenemos la contraseña introducida
				if (String.valueOf(pwdPassword.getPassword()).equals(password))
				{
				lblAviso.setBackground(Color.GREEN);
				lblAviso.setText("Contraseña correcta. Puede entrar");
				lblAviso.setVisible(true);
				btnEntrar.setEnabled(true);
				lblContrasea.setEnabled(false);
				pwdPassword.setEnabled(false);
				} else {
				lblAviso.setBackground(Color.RED);
				lblAviso.setText("Contraseña incorrecta. Vuelva a intentarlo");
				lblAviso.setVisible(true);
				btnEntrar.setEnabled(false);
				}

		}
	}
	private class PwdPasswordKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			lblEstado.setText("Tecla pulsada: "+ e.getKeyChar());
		}
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			PanelInicio window = new PanelInicio();
			window.setVisible(true);
			frmAplicacionDeCorreo.dispose();
		}
	}
}
