package layout.test;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class GirdLayoutDemo {
 
    public static void main(String[] args) {
        JFrame f = new JFrame("���񲼾�GirdLayout");
        //����f�Ĳ��ֹ�����Ϊ3��3�е�GirdLayout�����ˮƽ�봹ֱ���Ϊ5
        f.setLayout(new GridLayout(3,3,5,5));
        for(int i=1;i<10;++i)
        {
            JButton btn = new JButton(String.valueOf(i));
            f.add(btn);
        }
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}