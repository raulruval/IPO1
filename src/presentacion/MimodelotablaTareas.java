package presentacion;

import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;

class MimodelotablaTareas extends AbstractTableModel {
	
	String[] columnNames = { "Nombre     ", " Encargado     ", " Fecha final     ", "Etiquetas     ",
	"Comentarios      " };

	//Vector data = new Vector();
	private ArrayList<String[]> data=new ArrayList<String[]>();

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		Object[] fila = (Object[]) data.get(row);
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
			Object[] fila = (Object[]) data.get(row);
			fila[col] = value;
			fireTableCellUpdated(row, col);
		}
	}

	public void eliminaFila(int row) {
		data.remove(row);
		this.fireTableDataChanged();
	}

	public void aniadeFila(Object[] row) {
		data.add((String[]) row);
	}
	public void vaciartabla(){
		/*if(data.size()>0){
			for(int i=0; i<data.size();i++){
				data.remove(i);
			}
		}
		*/
		while(data.size()>0){
			eliminaFila(0);
		}
	}
}
