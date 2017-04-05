package com.gjw.test.actiom;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.gjw.test.util.Utile;

public class HttpFrame
{
	private static JFrame jFrame = null;
	private static int height = 500;
	private static int width = 500;
	private static String title = "HTTP �������";
	
	static JTextField login_name;
    static JPasswordField login_pwd;
	
	public static void init() {
		jFrame = new JFrame();
		jFrame.setTitle(title);
		jFrame.setSize(width, height);
		//���ô��ھ���
		Utile.getInstance().centerFrame(jFrame);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel login_leb = new JLabel("�����ַ��");
        JLabel pwd_leb = new JLabel("���������");
        
        login_name = new JTextField(40);
        login_pwd = new JPasswordField(40);
        
        login_name.setName("username");
        login_pwd.setName("userpwd");
        
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        
        jp1.add(login_leb);
        jp1.add(login_name);
        
        jp2.add(pwd_leb);
        jp2.add(login_pwd);
		
        //���ô�С�����Ե���
        jFrame.setResizable(false);
		
		Container container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());
        container.add(jp1);
        container.add(jp2);
		
		//��Ӵ��ڹرռ���
		jFrame.addWindowListener(new WDListener());
		jFrame.setVisible(true);
		
	}
}
