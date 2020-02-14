package gui.panel;
 
import javax.swing.JButton;
 
import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;
 
public class RecoverPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }
    public static RecoverPanel instance = new RecoverPanel();
 
    JButton bRecover =new JButton("�ָ�");
 
    public RecoverPanel() {
 
        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
         
        addListener();
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }
 
    @Override
    public void updateData() {
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void addListener() {
        RecoverListener listener = new RecoverListener();
        bRecover.addActionListener(listener);
    }
 
}