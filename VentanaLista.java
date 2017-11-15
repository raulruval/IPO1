package Presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Rectangle;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class VentanaLista extends JInternalFrame {
	private JScrollPane scrollPane;
	private JList lstIdiomas;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLista frame = new VentanaLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLista() {
		setBounds(new Rectangle(50, 50, 200, 400));
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);

		btnNewButton = new JButton("Añadir elemento");
		getContentPane().add(btnNewButton, BorderLayout.NORTH);
		btnNewButton.addActionListener(new BtnNewButtonActionListener());

		JLabel lblFilaSeleccionada = new JLabel("Fila seleccionada:");
		getContentPane().add(lblFilaSeleccionada, BorderLayout.SOUTH);

		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		lstIdiomas = new JList();
		lstIdiomas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstIdiomas.addListSelectionListener(new LstIdiomasListSelectionListener());
		/*
		 * / lstIdiomas.setModel(new AbstractListModel() { String[] values = new
		 * String[] { "Español", "Inglés", "Idioma" };
		 * 
		 * public int getSize() { return values.length; }
		 * 
		 * public Object getElementAt(int index) { return values[index]; } }); /
		 */

		lstIdiomas = new JList();
		DefaultListModel modeloLista = new DefaultListModel();
		lstIdiomas.setModel(modeloLista);
		// Añadimos dos elementos de prueba a la lista
		modeloLista.addElement("Español");
		modeloLista.addElement("Inglés");

		scrollPane.setViewportView(lstIdiomas);
		
	//	lstIdiomas.setCellRenderer(new MiListCellRenderer());
		lstIdiomas.setCellRenderer(new OtroListCellRenderer());
	}

	private class LstIdiomasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			lblFilaSeleccionada.setText("Fila seleccionada:" + (String) lstIdiomas.getSelectedValue());
		}
	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			DefaultListModel modeloLista = (DefaultListModel) lstIdiomas.getModel();
			int indice = modeloLista.getSize();
			modeloLista.addElement("Idioma " + (indice + 1));
			lstIdiomas.setSelectedIndex(indice);
			lstIdiomas.ensureIndexIsVisible(indice);
		}
	}

}
