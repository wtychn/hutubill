package gui.frame;

import gui.panel.EditPanel;
import gui.panel.MainPanel;
import util.CenterPanel;

import javax.swing.*;

public class EditFrame extends JFrame {
    public static EditFrame instance = new EditFrame();
    public CenterPanel workingPanel;

    EditFrame() {
        workingPanel = new CenterPanel(0.8);

        this.setSize(500, 300);
        this.setTitle("±à¼­");
        this.setContentPane(workingPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EditFrame instance = new EditFrame();
        instance.setVisible(true);
        instance.workingPanel.show(EditPanel.instance);
    }
}
