package gui.frame;

import gui.panel.EditPanel;
import gui.panel.MainPanel;
import gui.panel.WorkingPanel;
import util.CenterPanel;

import javax.swing.*;
import java.awt.*;

public class EditFrame extends JFrame {
//    CenterPanel cp = new CenterPanel(0.85);
    public static EditFrame instance = new EditFrame();

    EditFrame() {
        this.setSize(550, 300);
        this.setTitle("±à¼­");
        this.setContentPane(EditPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        cp.show(EditPanel.instance);
    }

    public static void main(String[] args) {
        EditFrame instance = new EditFrame();
        instance.setVisible(true);
    }
}
