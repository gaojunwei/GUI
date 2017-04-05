package com.gjw.test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import com.gjw.test.actiom.HttpFrame;
import com.gjw.test.util.Utile;

public class LoginMain
{
	private static Logger logger = Logger.getLogger(LoginMain.class.getName());
    static JFrame frame;
    static JTextField login_name;
    static JPasswordField login_pwd;
    public static void main(String[] args)
    {
        frame = new JFrame();
        JLabel login_leb = new JLabel("用户名称：");
        JLabel pwd_leb = new JLabel("登陆密码：");
        
        JButton login_btn = new JButton("登陆");
        JButton cancel_btn = new JButton("取消");
        
        login_name = new JTextField(24);
        login_pwd = new JPasswordField(24);
        
        login_name.setName("username");
        login_pwd.setName("userpwd");
        
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
        
        int width = 350;
        int height = 180;
        //设置窗口宽度和高度
        frame.setSize(width, height);
        //屏幕居中显示
        Utile.getInstance().centerFrame(frame);
        //设置窗口标题
        frame.setTitle("用户登录");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        //设置大小不可以调节
        frame.setResizable(false);
        Container container = frame.getContentPane();
        
        jp1.add(login_leb);
        jp1.add(login_name);
        
        jp2.add(pwd_leb);
        jp2.add(login_pwd);
        //取消按钮 添加事件
        cancel_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                frame.setVisible(false);
                System.exit(0);
            }
        });
        //登陆按钮 添加事件
        login_btn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent arg0)
            {
                String password = String.valueOf(login_pwd.getPassword()).trim();
                String username = login_name.getText();
                /*if(!password.equals("123456") || !username.equals("gaojunwei"))
                {
                	JOptionPane.showMessageDialog(frame, "账户名或密码错误，请重试","警告",JOptionPane.WARNING_MESSAGE);
                	logger.info(username+"，登录失败！");
                }else
                {*/
                	frame.dispose();
                	logger.info("登录成功！");
                	HttpFrame frame2 = new HttpFrame();
                	frame2.init();
                /*}*/
            }
        });
        jp3.add(login_btn);
        jp3.add(cancel_btn);
        
        container.setLayout(new FlowLayout());
        container.add(jp1);
        container.add(jp2);
        container.add(jp3);
        
        SwingUtilities.updateComponentTreeUI(frame);//通过当前外观初始化其 UI 属性
        //修改图标
        frame.setIconImage (Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+"/source/11.jpg"));
        frame.setVisible(true);
    }
}
