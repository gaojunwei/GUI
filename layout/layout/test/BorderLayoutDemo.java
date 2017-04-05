package layout.test;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo {
	public static void main(String[] args) {
		JFrame f = new JFrame("边界布局BorderLayout");
		//JFrame的默认LayoutManager为BorderLayout
		JButton btn =  new JButton("北");
		f.add(btn,BorderLayout.NORTH);
   
		btn=new JButton("南");
		f.add(btn,BorderLayout.SOUTH);
   
		btn=new JButton("东");
		f.add(btn,BorderLayout.EAST);
   
		btn=new JButton("西");
		f.add(btn,BorderLayout.WEST);
   
		btn=new JButton("中");
		f.add(btn,BorderLayout.CENTER);
   
		f.pack();//也可以用f.setSize(222,222);来进行设置
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}