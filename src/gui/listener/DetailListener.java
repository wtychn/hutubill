package gui.listener;

import entity.Category;
import entity.Record;
import gui.panel.DetailPanel;
import service.CategoryService;
import service.DetailService;
import service.RecordService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DetailPanel d = DetailPanel.instance;
        JButton b = (JButton) e.getSource();

        if (b == d.bEdit) {

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
