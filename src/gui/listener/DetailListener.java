package gui.listener;

import entity.Record;
import gui.frame.EditFrame;
import gui.panel.DetailPanel;
import gui.panel.EditPanel;
import service.DetailService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(d, "È·ÈÏÒªÉ¾³ý£¿"))
                return;

            int id = r.id;
            new DetailService().delete(id);
        }
        d.updateData();
    }
}
