package jdialog.test;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.BorderLayout;
 
public class JDialogDemo1
{
    public static void main(String[] agrs)
    {
       JDialog dialog = new JDialog();//8
       dialog.setTitle("�������κ������ڵĶԻ���");
       dialog.setSize(350,120);
       Container contentPane = dialog.getContentPane();
       contentPane.add(new JLabel("����һ��JLabel����,������",JLabel.CENTER),
       BorderLayout.SOUTH);                                    //13
       contentPane.add(new JLabel("����һ��JLabel����,�����",JLabel.CENTER),//14
       BorderLayout.WEST);                                         //15
       contentPane.add(new JLabel("����һ��JLabel����,���ұ�",JLabel.CENTER),//16  
       BorderLayout.EAST);
       contentPane.add(new JLabel("����һ��JLabel����,������",JLabel.CENTER),
       BorderLayout.NORTH);
       dialog.setVisible(true);
    }
}