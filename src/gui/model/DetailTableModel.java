package gui.model;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;
import service.DetailService;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class DetailTableModel extends AbstractTableModel {

    String[] columNames = new String[]{"分类", "日期", "金额", "备注"};
    DetailService dServer = new DetailService();
    public List<Record> ds = dServer.list();

    @Override
    public int getRowCount() {
        return ds.size();
    }

    @Override
    public int getColumnCount() {
        return columNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columNames[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Record r = ds.get(rowIndex);
        if (columnIndex == 0) {
            return dServer.getCategoryName(r);
        }
        if (columnIndex == 1) {
            return r.date;
        }
        if (columnIndex == 2) {
            return r.spend;
        }
        if (columnIndex == 3) {
            return r.comment;
        }

        return null;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {

    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {

    }
}
