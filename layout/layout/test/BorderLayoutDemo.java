package layout.test;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo {
	public static void main(String[] args) {
		JFrame f = new JFrame("�߽粼��BorderLayout");
		//JFrame��Ĭ��LayoutManagerΪBorderLayout
		JButton btn =  new JButton("��");
		f.add(btn,BorderLayout.NORTH);
   
		btn=new JButton("��");
		f.add(btn,BorderLayout.SOUTH);
   
		btn=new JButton("��");
		f.add(btn,BorderLayout.EAST);
   
		btn=new JButton("��");
		f.add(btn,BorderLayout.WEST);
   
		btn=new JButton("��");
		f.add(btn,BorderLayout.CENTER);
   
		f.pack();//Ҳ������f.setSize(222,222);����������
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}