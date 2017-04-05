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
       dialog.setTitle("不依附任何主窗口的对话框");
       dialog.setSize(350,120);
       Container contentPane = dialog.getContentPane();
       contentPane.add(new JLabel("这是一个JLabel对象,在下面",JLabel.CENTER),
       BorderLayout.SOUTH);                                    //13
       contentPane.add(new JLabel("这是一个JLabel对象,在左边",JLabel.CENTER),//14
       BorderLayout.WEST);                                         //15
       contentPane.add(new JLabel("这是一个JLabel对象,在右边",JLabel.CENTER),//16  
       BorderLayout.EAST);
       contentPane.add(new JLabel("这是一个JLabel对象,在上面",JLabel.CENTER),
       BorderLayout.NORTH);
       dialog.setVisible(true);
    }
}