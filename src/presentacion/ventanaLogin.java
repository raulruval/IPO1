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
		
		frmAplicacionDeCorreo.setTitle("Gestión de proyectos");
		frmAplicacionDeCorreo.setBounds(100, 100, 450, 317);
		frmAplicacionDeCorreo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAplicacionDeCorreo.getContentPane().setLayout(null);
		{
			panel = new JPanel();
			panel.addMouseMotionListener(new PanelMouseMotionListener());
			panel.setBounds(0, 0, 440, 231);
			frmAplicacionDeCorreo.getContentPane().add(panel);
			panel.setLayout(null);
			{
				lblUsuario = new JLabel("Usuario:");
				lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
				lblUsuario.setBounds(64, 67, 68, 14);
				panel.add(lblUsuario);
			}
			{
				tfUsuario = new JTextField();
				tfUsuario.addActionListener(new TfUsuarioActionListener());
				tfUsuario.setBounds(142, 64, 210, 20);
				panel.add(tfUsuario);
				tfUsuario.setColumns(10);
			}
			{
				lblContrasea = new JLabel("Contraseña:");
				lblContrasea.setEnabled(false);
				lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
				lblContrasea.setBounds(49, 96, 80, 14);
				panel.add(lblContrasea);
			}
			{
				pwdPassword = new JPasswordField();
				pwdPassword.addKeyListener(new PwdPasswordKeyListener());
				pwdPassword.addActionListener(new PwdPasswordActionListener());
				pwdPassword.setEnabled(false);
				pwdPassword.setBounds(142, 93, 210, 20);
				panel.add(pwdPassword);
			}
			{
				lblAviso = new JLabel("");
				lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
				lblAviso.setOpaque(true);
				lblAviso.setBounds(142, 136, 257, 39);
				panel.add(lblAviso);
			}
			{
				btnEntrar = new JButton("Entrar");
				btnEntrar.addActionListener(new BtnEntrarActionListener());
				btnEntrar.setEnabled(false);
				btnEntrar.setBounds(318, 197, 89, 23);
				panel.add(btnEntrar);
			}
		}
		{
			lblEstado = new JLabel("Aqui se mostraran los distintos eventos capturados. ");
			lblEstado.setOpaque(true);
			lblEstado.setBackground(new Color(30, 144, 255));
			lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
			lblEstado.setBounds(0, 231, 440, 47);
			frmAplicacionDeCorreo.getContentPane().add(lblEstado);
		}
	}
	private class PanelMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			lblEstado.setText("("+e.getX()+","+e.getY()+")");
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
			lblEstado.setText("Evento de Acción: ActionPerformed"+e.getActionCommand());
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
