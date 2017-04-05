package layout.test;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class GirdLayoutDemo {
 
    public static void main(String[] args) {
        JFrame f = new JFrame("网格布局GirdLayout");
        //设置f的布局管理器为3行3列的GirdLayout组件间水平与垂直间距为5
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