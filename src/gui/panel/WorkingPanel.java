package gui.panel;
 
import javax.swing.JPanel;
 
public abstract class WorkingPanel  extends JPanel{
    public abstract void updateData();
    public abstract void addListener();
}