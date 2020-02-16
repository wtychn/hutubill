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

        if (b == d.bDelete) {
            Record r = d.getSelectedRecord();

            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(d, "È·ÈÏÒªÉ¾³ý£¿"))
                return;

            int id = r.id;
            new DetailService().delete(id);
        }
        d.updateData();
    }
}
