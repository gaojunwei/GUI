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
        JFrame f = new JFrame("卡片布局CardLayout");
        p=new JPanel();
        //设置p的布局管理器为卡片布局CardLayout
        p.setLayout(new CardLayout());
         
        //新建两个JPanel
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JLabel lb = new JLabel("第一个面板");
        p1.add(lb);//面板里面加标签
        lb=new JLabel("第二个面板");
        p2.add(lb);//面板里面加标签
         
        //将新建的两个JPanel面板添加到p中
        p.add(p1,"first");
        p.add(p2,"second");
         
        //设置默认显示first所对应的JPanel p1
        ((CardLayout)p.getLayout()).show(p,"first");
         
        JButton btn = new JButton("改变面板");
        btn.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //当点击'改变面板'时，显示second对应的JPanel p2
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