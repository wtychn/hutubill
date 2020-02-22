package gui.listener;

import entity.Category;
import gui.frame.EditFrame;
import gui.panel.CategoryPanel;
import gui.panel.DetailPanel;
import gui.panel.EditPanel;
import gui.panel.MainPanel;
import service.RecordService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class EditListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DetailPanel dp = DetailPanel.instance;
        EditPanel ep = EditPanel.instance;
        JButton b = (JButton) e.getSource();

        if (b == ep.bDetermine) {
            if(0==ep.cbModel.cs.size()){
                JOptionPane.showMessageDialog(ep, "暂无消费分类，无法添加，请先增加消费分类");
                MainPanel.instance.workingPanel.show(CategoryPanel.instance);
                return;
            }

            if(!GUIUtil.checkZero(ep.tfSpend,"花费金额"))
                return;
            int spend = Integer.parseInt(ep.tfSpend.getText());
            Category c = ep.getSelectedCategory();
            String comment = ep.tfComment.getText();
            Date d = ep.datepick.getDate();
            int id = dp.getSelectedRecord().id;
            new RecordService().update(spend, c, comment, d, id);
            JOptionPane.showMessageDialog(ep, "修改成功");
            EditFrame.instance.setVisible(false);

            dp.updateData();
        }
        if (b == ep.bCancel) {
            EditFrame.instance.setVisible(false);
        }
    }
}
