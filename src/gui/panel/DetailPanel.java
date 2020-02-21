package gui.panel;

import entity.Category;
import entity.Record;
import gui.listener.DetailListener;
import gui.model.CategoryComboBoxModel;
import gui.model.DetailTableModel;
import service.CategoryService;
import service.DetailService;
import service.RecordService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class DetailPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }
    public static DetailPanel instance = new DetailPanel();

    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");
    public JButton bFilter = new JButton("筛选");
    public JButton bAll = new JButton("查看全部");
    public boolean updataFlag = false;
    public DetailService dServer = new DetailService();

    public DetailTableModel dtm = new DetailTableModel();
    public JTable t = new JTable(dtm);

    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
    public JLabel lCategory = new JLabel("查看分类");

    public DetailPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lCategory);
        GUIUtil.setColor(ColorUtil.blueColor, bEdit, bDelete);

        this.setLayout(new BorderLayout());
        this.add(south(), BorderLayout.SOUTH);
        this.add(center(), BorderLayout.CENTER);

        addListener();
    }

    private JPanel center() {
        JPanel pInput = new JPanel();
        pInput.setLayout(new BorderLayout());
        JScrollPane sp = new JScrollPane(t);
        t.getColumnModel().getColumn(0).setPreferredWidth(10);
        t.getColumnModel().getColumn(2).setPreferredWidth(30);

        pInput.add(sp, BorderLayout.CENTER);
        pInput.add(north(), BorderLayout.NORTH);

        return pInput;
    }

    private Component north() {
        JPanel pInput = new JPanel();
        pInput.setLayout(new FlowLayout());
        cbCategory.setPreferredSize(new Dimension(100, 20));
        bAll.setPreferredSize(new Dimension(80, 20));
        bFilter.setPreferredSize(new Dimension(80, 20));

        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(bFilter);
        pInput.add(bAll);
        return pInput;
    }

    private JPanel south() {
        JPanel pSubmit = new JPanel();
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);

        return pSubmit;
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(DetailPanel.instance);
    }

    public Category getSelectedCategory(){
        return (Category) cbCategory.getSelectedItem();
    }

    public Record getSelectedRecord() {
        int index = t.getSelectedRow();
        return dtm.ds.get(index);
    }

    @Override
    public void updateData() {
        if (updataFlag) {
            dtm.ds = dServer.list(getSelectedCategory().id);
        } else {
            dtm.ds = dServer.list();
        }

        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

        if (dtm.ds.size() == 0) {
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        } else {
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }

        cbModel.cs = new CategoryService().list();
        cbCategory.updateUI();
        if(0!=cbModel.cs.size())
            cbCategory.setSelectedIndex(0);
    }

    @Override
    public void addListener() {
        DetailListener listener = new DetailListener();
        bFilter.addActionListener(listener);
        bAll.addActionListener(listener);
        bEdit.addActionListener(listener);
        bDelete.addActionListener(listener);
    }
}
