package util;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
 
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;
 
import entity.Record;
 
public class ChartUtil {
    private static String[] sampleLabels(List<Record> rs) {
        String[] sampleLabels = new String[rs.size()];
        for (int i = 0; i < sampleLabels.length; i++) {
            if (0 == i % 5)
                sampleLabels[i] = i + 1 + "��";
        }
 
        return sampleLabels;
 
    }
 
    public static double[] sampleValues(List<Record> rs) {
        double[] sampleValues = new double[rs.size()];
        for (int i = 0; i < sampleValues.length; i++) {
            sampleValues[i] = rs.get(i).spend;
        }
 
        return sampleValues;
    }
 
    public static Image getImage(List<Record> rs, int width, int height) {
        // �������Ѽ�¼�õ�����������
        double[] sampleValues = sampleValues(rs);
        // �������Ѽ�¼�õ����·������ı�
        String[] sampleLabels = sampleLabels(rs);
        // �����е����ֵ
        int max = max(sampleValues);
 
        // ������ɫ
        Color[] sampleColors = new Color[] { ColorUtil.blueColor };
 
        // ��״ͼ
        BarChart chart = new BarChart();
 
        // ������������
        chart.setSampleCount(sampleValues.length);
        // ������������
        chart.setSampleValues(0, sampleValues);
        // ��������
        chart.setSampleLabels(sampleLabels);
        // ����������ɫ
        chart.setSampleColors(sampleColors);
        // ����ȡֵ��Χ
        chart.setRange(0, max * 1.2);
        // ��ʾ��������
        chart.setValueLinesOn(true);
        // ��ʾ����
        chart.setSampleLabelsOn(true);
        // ��������ʾ���·�
        chart.setSampleLabelStyle(Chart.BELOW);
 
        // ����ֵ������
        chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
        // ��ʾͼ��˵��
        chart.setLegendOn(true);
        // ��ͼ��˵���������
        chart.setLegendPosition(Chart.LEFT);
        // ͼ��˵���е�����
        chart.setLegendLabels(new String[] { "�����ѱ���" });
        // ͼ��˵��������
        chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
        // �·����ֵ�����
        chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        // ͼ���м䱳����ɫ
        chart.setChartBackground(Color.white);
        // ͼ�����屳����ɫ
        chart.setBackground(ColorUtil.backgroundColor);
        // ��ͼ��ת��ΪImage����
        Image im = chart.getImage(width, height);
        return im;
    }
 
    public static int max(double[] sampleValues) {
        int max = 0;
        for (double v : sampleValues) {
            if (v > max)
                max = (int) v;
        }
        return max;
 
    }

//    ����Ϊ���Դ��룬����ʵ����Ŀ������
    private static String[] sampleLabels() {
        String[] sampleLabels = new String[30];
 
        for (int i = 0; i < sampleLabels.length; i++) {
            if (0 == i % 5)
                sampleLabels[i] = String.valueOf(i + 1 + "��");
        }
        return sampleLabels;
    }
 
    public static Image getImage(int width, int height) {
        // ģ����������
        double[] sampleValues = sampleValues();
        // �·���ʾ������
        String[] sampleLabels = sampleLabels();
        // �����е����ֵ
        int max = max(sampleValues);
 
        // ������ɫ
        Color[] sampleColors = new Color[] { ColorUtil.blueColor };
 
        // ��״ͼ
        BarChart chart = new BarChart();
 
        // ������������
        chart.setSampleCount(sampleValues.length);
        // ������������
        chart.setSampleValues(0, sampleValues);
        // ��������
        chart.setSampleLabels(sampleLabels);
        // ����������ɫ
        chart.setSampleColors(sampleColors);
        // ����ȡֵ��Χ
        chart.setRange(0, max * 1.2);
        // ��ʾ��������
        chart.setValueLinesOn(true);
        // ��ʾ����
        chart.setSampleLabelsOn(true);
        // ��������ʾ���·�
        chart.setSampleLabelStyle(Chart.BELOW);
 
        // ����ֵ������
        chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
        // ��ʾͼ��˵��
        chart.setLegendOn(true);
        // ��ͼ��˵���������
        chart.setLegendPosition(Chart.LEFT);
        // ͼ��˵���е�����
        chart.setLegendLabels(new String[] { "�����ѱ���" });
        // ͼ��˵��������
        chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
        // �·����ֵ�����
        chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        // ͼ���м䱳����ɫ
        chart.setChartBackground(Color.white);
        // ͼ�����屳����ɫ
        chart.setBackground(ColorUtil.backgroundColor);
        // ��ͼ��ת��ΪImage����
        Image im = chart.getImage(width, height);
        return im;
    }
 
    private static double[] sampleValues() {
 
        double[] result = new double[30];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * 300);
        }
        return result;
 
    }
 
    public static void main(String[] args) {
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        Image img = ChartUtil.getImage(400, 300);
        Icon icon = new ImageIcon(img);
        l.setIcon(icon);
        p.add(l);
        GUIUtil.showPanel(p);
    }
 
}