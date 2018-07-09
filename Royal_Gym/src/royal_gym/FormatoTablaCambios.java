package royal_gym;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author alxcr
 */
public class FormatoTablaCambios extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel cell = new JLabel(value.toString());
        cell.setOpaque(true);
        //double valor = Double.parseDouble(value.toString());

        for (int a = 1; a < table.getColumnCount() - 1; a++) {
            if (column == a) {
                for (int i = 1; i < table.getRowCount(); i = i + 2) {
                    if (row == i) {
                        double valor = Double.parseDouble(value.toString());
                        if (valor < 0) {
                            cell.setBackground(new Color(151, 201, 65));
                        } else if (valor == 0){
                            cell.setBackground(new Color(240, 240, 240));
                        }else {
                            cell.setBackground(new Color(224, 67, 54));
                            cell.setForeground(Color.WHITE);
                        }

                    }
                }
            }
        }
        
        if(isSelected){
            //cell.setBackground(new Color(0, 120, 215));
            cell.setBackground(new Color(0, 0, 0));
            cell.setForeground(Color.WHITE);
        }
        return cell;
    }

}
