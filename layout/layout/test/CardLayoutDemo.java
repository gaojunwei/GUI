package layout.test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class CardLayoutDemo {
    private static JPanel p;
    public static void main(String[] args) {
        JFrame f = new JFrame("��Ƭ����CardLayout");
        p=new JPanel();
        //����p�Ĳ��ֹ�����Ϊ��Ƭ����CardLayout
        p.setLayout(new CardLayout());
         
        //�½�����JPanel
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JLabel lb = new JLabel("��һ�����");
        p1.add(lb);//�������ӱ�ǩ
        lb=new JLabel("�ڶ������");
        p2.add(lb);//�������ӱ�ǩ
         
        //���½�������JPanel�����ӵ�p��
        p.add(p1,"first");
        p.add(p2,"second");
         
        //����Ĭ����ʾfirst����Ӧ��JPanel p1
        ((CardLayout)p.getLayout()).show(p,"first");
         
        JButton btn = new JButton("�ı����");
        btn.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //�����'�ı����'ʱ����ʾsecond��Ӧ��JPanel p2
                ((CardLayout)p.getLayout()).show(p,"second");
            }
        });
        f.add(btn,BorderLayout.NORTH);
        f.add(p,BorderLayout.CENTER);
        f.setSize(400,150);//f.pack();
         
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}