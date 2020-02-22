package gui.panel;

import entity.Category;
import gui.listener.EditListener;
import gui.model.CategoryComboBoxModel;
import org.jdesktop.swingx.JXDatePicker;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.Date;

public class EditPanel extends JPanel{
    static{
        GUIUtil.useLNF();
    }
    public static EditPanel instance = new EditPanel();

    JLabel lSpend = new JLabel("����(��)");
    JLabel lCategory = new JLabel("����");
    JLabel lComment = new JLabel("��ע");
    JLabel lDate = new JLabel("����");

    public JTextField tfSpend = new JTextField("0");
    public JTextField tfComment = new JTextField("");

    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);

    public JXDatePicker datepick = new JXDatePicker(new Date());

    public JButton bDetermine = new JButton("ȷ��");
    public JButton bCancel = new JButton("ȡ��");

    public EditPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lSpend,lCategory,lComment,lDate);
        GUIUtil.setColor(ColorUtil.blueColor, bDetermine, bCancel);
        JPanel pInput =new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 25;
        pInput.setLayout(new GridLayout(4, 2, gap, gap));

        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(datepick);

        pSubmit.add(bDetermine);
        pSubmit.add(bCancel);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);

        addListener();
    }

    public Category getSelectedCategory(){
        return (Category) cbCategory.getSelectedItem();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(EditPanel.instance);
    }

    public void updateData() {
        cbModel.cs = new CategoryService().list();
        cbModel.cs.sort(Comparator.comparing(c -> c.id));
        cbCategory.updateUI();
        resetInput();
        tfSpend.grabFocus();
    }

    public void resetInput(){
        tfSpend.setText(String.valueOf(DetailPanel.instance.getSelectedRecord().spend));
        tfComment.setText(DetailPanel.instance.getSelectedRecord().comment);
        if(0!=cbModel.cs.size())
            cbCategory.setSelectedIndex(DetailPanel.instance.getSelectedRecord().cid - 1);
        datepick.setDate(DetailPanel.instance.getSelectedRecord().date);
    }

    public void addListener() {
        EditListener listener = new EditListener();
        bCancel.addActionListener(listener);
        bDetermine.addActionListener(listener);
    }
}
