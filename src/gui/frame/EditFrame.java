package gui.frame;

import gui.panel.EditPanel;

import javax.swing.*;

public class EditFrame extends JFrame {
    public static EditFrame instance = new EditFrame();

    EditFrame() {
        this.setSize(400, 270);
        this.setTitle("±à¼­");
        this.setContentPane(EditPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EditFrame instance = new EditFrame();
        instance.setVisible(true);
    }
}
