package wallet.view.components;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {

    public ModeloTabla(final Object[][] data, final String[] titulo) {
        super(data, titulo);
    }

    public Class getColumnClass(final int column) {
        return this.getValueAt(0, column).getClass();
    }
}
