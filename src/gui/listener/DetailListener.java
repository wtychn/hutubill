package gui.listener;

import entity.Category;
import entity.Record;
import gui.frame.EditFrame;
import gui.panel.DetailPanel;
import gui.panel.EditPanel;
import service.CategoryService;
import service.DetailService;
import service.RecordService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class DetailListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DetailPanel d = DetailPanel.instance;
        JButton b = (JButton) e.getSource();
        EditFrame fEdit = EditFrame.instance;
        EditPanel ep = EditPanel.instance;

        if (b == d.bEdit) {
            ep.updateData();
            fEdit.setVisible(true);
            fEdit.workingPanel.show(EditPanel.instance);
        }
        if (b == d.bAll) {
            d.updataFlag = false;
        }
        if (b == d.bFilter) {
            d.updataFlag = true;
        }
        if (b == d.bDelete) {
            Record r = d.getSelectedRecord();

            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(d, "ȷ��Ҫɾ����"))
                return;

            int id = r.id;
            new DetailService().delete(id);
        }
        d.updateData();
    }
}
