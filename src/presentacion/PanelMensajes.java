package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dominio.Mensaje;
import dominio.Proyecto;
import dominio.Usuario;

import java.awt.ComponentOrientation;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class PanelMensajes extends JPanel {
	private JScrollPane scrollPane;
	private JToolBar toolBar;
	private JButton button;
	private JButton button_1;
	MiModeloTabla modeloTabla = new MiModeloTabla();
	ArrayList<Proyecto> pro=dominio.persistencia.inicializar();
	ArrayList<Mensaje> mensajes=dominio.persistencia.getmensajes();
	private JTable table;
	PanelInicio inicio;
	Mensaje mens;
	PanelInformacionMensajes datmens;
	/**
	 * Create the panel.
	 */
	public PanelMensajes() {
		modeloTabla.vaciartabla();
		setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modeloTabla);
		table.setCellSelectionEnabled(true);

		for (int i = 0; i < (mensajes.size()/2); i++) {
			String[] fila1 = { mensajes.get(i).getAsunto() };
			modeloTabla.aniadeFila(fila1);
		}
		
		toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(toolBar, BorderLayout.SOUTH);
		
		button = new JButton(MessagesIPO1Inter.getString("PanelMensajes.0")); //$NON-NLS-1$
		button.setMinimumSize(new Dimension(100, 30));
		button.setMaximumSize(new Dimension(100, 35));
		button.setIcon(new ImageIcon(PanelMensajes.class.getResource("/recursos/icons8-new-message-30.png"))); //$NON-NLS-1$
		button.addActionListener(new ButtonActionListener());
		toolBar.add(button);
		
		button_1 = new JButton(MessagesIPO1Inter.getString("PanelMensajes.2")); //$NON-NLS-1$
		button_1.setMaximumSize(new Dimension(100, 35));
		button_1.setIcon(new ImageIcon(PanelMensajes.class.getResource("/recursos/icons8-trash-can-30.png"))); //$NON-NLS-1$
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		toolBar.add(button_1);
		button_1.setEnabled(false);
		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (!lsm.isSelectionEmpty()) {
					int filaSeleccionada = lsm.getMinSelectionIndex();
					mens=mensajes.get(filaSeleccionada);
					Usuario us = mens.getRemitente();
					String contenido=mens.getContenido();
					datmens = inicio.getVentanaInformacionMensaje();
					datmens.getTextField_Remitente().setText(us.getNombre());
					datmens.getTextField_Asunto().setText(mens.getAsunto());
					datmens.getTextArea_Mensaje().setText(contenido);
					datmens.getTextField_Remitente().setEnabled(false);
					datmens.getTextField_Asunto().setEnabled(false);
					datmens.getTextArea_Mensaje().setEnabled(false);
					datmens.getBtnEnviar().setEnabled(false);
					button_1.setEnabled(true);
					inicio.getVentanaInformacionMensaje().getBtnModificar().setEnabled(true);
				}
			}
		});
	}
	public MiModeloTabla getModeloTabla() {
		return modeloTabla;
	}
	public JButton getButton() {
		return button;
	}
	public JButton getButton_1() {
		return button_1;
	}
	public void setinicio(PanelInicio in) {
		inicio = in;
	}
	

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null, MessagesIPO1Inter.getString("PanelMensajes.4"), MessagesIPO1Inter.getString("PanelMensajes.5"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			inicio.getVentanaInformacionMensaje().getTextArea_Mensaje().setText(""); //$NON-NLS-1$
			inicio.getVentanaInformacionMensaje().getTextField_Asunto().setText(""); //$NON-NLS-1$
			inicio.getVentanaInformacionMensaje().getTextField_Remitente().setText(MessagesIPO1Inter.getString("PanelMensajes.8")); //$NON-NLS-1$
			
			inicio.getVentanaInformacionMensaje().getTextArea_Mensaje().setEnabled(true);
			inicio.getVentanaInformacionMensaje().getTextField_Asunto().setEnabled(true);
			inicio.getVentanaInformacionMensaje().getTextField_Remitente().setEnabled(true);
	
			inicio.getVentanaInformacionMensaje().getBtnEnviar().setEnabled(true);
		}
		
	}

	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int p = JOptionPane.showOptionDialog(null, MessagesIPO1Inter.getString("PanelMensajes.9"), //$NON-NLS-1$
					MessagesIPO1Inter.getString("PanelMensajes.10"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, //$NON-NLS-1$
					null);
			if (p == 0) {
				MiModeloTabla modeloTabla = (MiModeloTabla) table.getModel();
				int n = table.getSelectedRow();
				if (n != -1)
					modeloTabla.eliminaFila(table.getSelectedRow());
				modeloTabla.fireTableDataChanged();
				datmens.getTextField_Remitente().setText(""); //$NON-NLS-1$
				datmens.getTextField_Asunto().setText(""); //$NON-NLS-1$
				datmens.getTextArea_Mensaje().setText(""); //$NON-NLS-1$
			}
		}
	}
}
