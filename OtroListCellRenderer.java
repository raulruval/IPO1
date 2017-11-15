package Presentacion;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class OtroListCellRenderer extends DefaultListCellRenderer {
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

public Component getListCellRendererComponent(JList list, Object value, int index,boolean
isSelected, boolean hasFocus) {
JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
isSelected, hasFocus);
renderer.setIcon(new ImageIcon(OtroListCellRenderer.class.getResource("idioma.png")));
renderer.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),"Idioma..."));
renderer.setHorizontalAlignment(JLabel.CENTER);
renderer.setBackground(new Color(250,250,200));
renderer.setForeground(Color.BLUE);
if (isSelected) renderer.setBackground(new Color(200,250,200));
return renderer;
}
}