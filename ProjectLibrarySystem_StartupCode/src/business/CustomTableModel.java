package business;

import java.util.*;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class CustomTableModel extends AbstractTableModel {
    private List<Object[]> data = new ArrayList<>();
    private String[] columnNames = {"First Name", "Last Name", "Telephone", "Address", "Action"};

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Allow editing only for the "Name" column (column index 1)
        return columnIndex == 1;
    }



    public void addRow(Object[] rowData) {
        data.add(rowData);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void editRow(int rowIndex, String fname, String lname, String tele, String address, String bio) {
        Object[] rowData = data.get(rowIndex);
        rowData[0] = fname;
        rowData[1] = lname;
        rowData[2] = tele;
        rowData[3] = address;
        rowData[4] = bio;
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
    }

    public void deleteRow(int rowIndex) {
        data.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}