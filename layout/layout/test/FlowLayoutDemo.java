package layout.test;

import java.awt.FlowLayout;
 
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class FlowLayoutDemo {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame f = new JFrame("��ʽ����FlowLayout");
        f.setLayout(new FlowLayout());
        for(int i=0;i<8;i++)
        {
            JButton btn=new JButton("Button"+i);
            f.add(btn);
        }
        f.setSize(300,250);
        //f.pack();Ĭ�ϱ߿����ÿ�Ⱥͳ��ȸոպõ�����
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}