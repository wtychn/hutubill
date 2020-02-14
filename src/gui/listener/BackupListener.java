package gui.listener;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
 
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
 
import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;
 
public class BackupListener implements ActionListener {
 
    @Override
    public void actionPerformed(ActionEvent e) {
        BackupPanel p  =BackupPanel.instance;
        String mysqlPath= new ConfigService().get(ConfigService.mysqlPath);
        if(0==mysqlPath.length()){
            JOptionPane.showMessageDialog(p, "����ǰ����������mysql��·��");
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            ConfigPanel.instance.tfMysqlPath.grabFocus();
            return;
        }
        JFileChooser fc = new JFileChooser("D:\\WTYdoc\\java\\j2se\\project\\process\\hutubill\\backup");
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new FileFilter() {
             
            @Override
            public String getDescription() {
                return ".sql";
            }
             
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".sql");
            }
        });
 
         int returnVal =  fc.showSaveDialog(p);
         File file = fc.getSelectedFile();
         System.out.println(file);
         if (returnVal == JFileChooser.APPROVE_OPTION) {
             //���������ļ���û����.sql��β���Զ�����.sql
             System.out.println(file);
             if(!file.getName().toLowerCase().endsWith(".sql"))
                 file = new File(file.getParent(),file.getName()+".sql");
             System.out.println(file);
              
            try {
                MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(p, "���ݳɹ�,�����ļ�λ��:\r\n"+file.getAbsolutePath());
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(p, "����ʧ��\r\n,����:\r\n"+e1.getMessage());   
            }
              
         }      
    }
 
}