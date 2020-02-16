package gui.panel;

import entity.Category;
import gui.model.CategoryComboBoxModel;
import gui.model.DetailTableModel;
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
    public JButton bAll = new JButton("查看全部");

    public DetailTableModel ds = new DetailTableModel();
    public JTable t = new JTable(ds);

    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
    public JLabel lCategory = new JLabel("查看分类");

    public DetailPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lCategory);
        GUIUtil.setColor(ColorUtil.blueColor, bEdit, bDelete);

        this.setLayout(new BorderLayout());
        this.add(south(), BorderLayout.SOUTH);
        this.add(center(), BorderLayout.CENTER);
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

        pInput.add(lCategory);
        pInput.add(cbCategory);
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

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {

    }
}
