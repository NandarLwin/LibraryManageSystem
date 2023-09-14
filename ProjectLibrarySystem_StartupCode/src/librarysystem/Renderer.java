package librarysystem;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;



class Renderer extends DefaultTableCellRenderer implements TableCellRenderer {
    private JTextField textField;

    public Renderer() {
        textField = new JTextField();
        textField.setBorder(null);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.LEFT); // Adjust alignment as needed
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        textField.setText(value.toString());
        return textField;
    }
}

class CustomTextFieldEditor extends DefaultCellEditor implements TableCellEditor {
    private JTextField textField;

    public CustomTextFieldEditor() {
        super(new JTextField());
        textField = (JTextField) getComponent();
        textField.setBorder(null);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This method is called when Enter is pressed in the text field
                stopCellEditing();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        textField.setText(value.toString());
        return textField;
    }

    @Override
    public Object getCellEditorValue() {
        return textField.getText();
    }
}

