package presentacion;

import java.util.*;
import javax.swing.table.*;

class MiModeloTabla extends AbstractTableModel {
	private String[] nombreColumnas = { MessagesIPO1Inter.getString("MiModeloTabla.0") }; //$NON-NLS-1$
	//private Vector datos = new Vector();
	private ArrayList<String[]> datos=new ArrayList<String[]>();

	public int getColumnCount() {
		return nombreColumnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}

	public String getColumnName(int col) {
		return nombreColumnas[col];
	}

	public Object getValueAt(int row, int col) {
		Object[] fila = (Object[]) datos.get(row);
		return fila[col];
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		return true;
	}

	public void setValueAt(Object value, int row, int col) {
		if (row < getRowCount() && col < getColumnCount()) {
			Object[] fila = (Object[]) datos.get(row);
			fila[col] = value;
			fireTableCellUpdated(row, col);
		}
	}

	public void eliminaFila(int row) {
		datos.remove(row);
		this.fireTableDataChanged();
	}

	public void aniadeFila(Object[] row) {
		datos.add((String[]) row);
		
	}
	
	public void vaciartabla(){
		/*
		if(datos.size()>0){
			for(int i=0; i<datos.size();i++){
				datos.removeElementAt(i);
			}
		}
		*/
		while(datos.size()>0){
			eliminaFila(0);
		}
	}
}
