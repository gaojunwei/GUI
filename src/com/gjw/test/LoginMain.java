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
        JLabel login_leb = new JLabel("�û����ƣ�");
        JLabel pwd_leb = new JLabel("��½���룺");
        
        JButton login_btn = new JButton("��½");
        JButton cancel_btn = new JButton("ȡ��");
        
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
        //���ô��ڿ�Ⱥ͸߶�
        frame.setSize(width, height);
        //��Ļ������ʾ
        Utile.getInstance().centerFrame(frame);
        //���ô��ڱ���
        frame.setTitle("�û���¼");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        //���ô�С�����Ե���
        frame.setResizable(false);
        Container container = frame.getContentPane();
        
        jp1.add(login_leb);
        jp1.add(login_name);
        
        jp2.add(pwd_leb);
        jp2.add(login_pwd);
        //ȡ����ť ����¼�
        cancel_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                frame.setVisible(false);
                System.exit(0);
            }
        });
        //��½��ť ����¼�
        login_btn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent arg0)
            {
                String password = String.valueOf(login_pwd.getPassword()).trim();
                String username = login_name.getText();
                /*if(!password.equals("123456") || !username.equals("gaojunwei"))
                {
                	JOptionPane.showMessageDialog(frame, "�˻������������������","����",JOptionPane.WARNING_MESSAGE);
                	logger.info(username+"����¼ʧ�ܣ�");
                }else
                {*/
                	frame.dispose();
                	logger.info("��¼�ɹ���");
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
        
        SwingUtilities.updateComponentTreeUI(frame);//ͨ����ǰ��۳�ʼ���� UI ����
        //�޸�ͼ��
        frame.setIconImage (Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+"/source/11.jpg"));
        frame.setVisible(true);
    }
}
