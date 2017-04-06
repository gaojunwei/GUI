package com.gjw.test.frame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

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

import com.alibaba.fastjson.JSON;
import com.gjw.test.service.LoginService;
import com.gjw.test.util.Utile;

public class LoginMain
{
	private static Logger logger = Logger.getLogger(LoginMain.class.getName());
    static JFrame frame;
    static JTextField login_name;
    static JTextField login_addr_f;
    static JTextField base_addr_f;
    static JPasswordField login_pwd;
    static int width = 350;
    static int height = 240;
    public static void main(String[] args)
    {
        frame = new JFrame();
        JLabel base_addr = new JLabel(" ����ַ��");
        JLabel login_addr = new JLabel("��¼��ַ��");
        JLabel login_leb = new JLabel("�û����ƣ�");
        JLabel pwd_leb = new JLabel("��½���룺");
        
        JButton login_btn = new JButton("��½");
        JButton cancel_btn = new JButton("ȡ��");
        
        base_addr_f = new JTextField(24);
        base_addr_f.setText("http://www.baidu.com/");
        
        login_addr_f = new JTextField(24);
        login_addr_f.setText("index/login.do");
        
        login_name = new JTextField(24);
        login_name.setText("dongcunrui89");
        
        login_pwd = new JPasswordField(24);
        login_pwd.setText("123456");
        
        login_addr_f.setName("login_addr_f");
        login_name.setName("username");
        login_pwd.setName("userpwd");
        
        JPanel jp00 = new JPanel();
        JPanel jp0 = new JPanel();
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
        
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
        
        jp00.add(base_addr);
        jp00.add(base_addr_f);
        
        jp0.add(login_addr);
        jp0.add(login_addr_f);
        
        jp1.add(login_leb);
        jp1.add(login_name);
        
        jp2.add(pwd_leb);
        jp2.add(login_pwd);
        //ȡ����ť ����¼�
        cancel_btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
            	int option = JOptionPane.showConfirmDialog(null,"ȡ����¼�󽫽������û���¼״̬����", "��ʾ��", JOptionPane.YES_NO_OPTION,
            		       JOptionPane.WARNING_MESSAGE, null);
            	if(option != JOptionPane.YES_NO_OPTION)
            		return;
            	
            	String base_addr_str = base_addr_f.getText().trim();
            	if(base_addr_str.equals(""))
            	{
            		JOptionPane.showMessageDialog(frame.getContentPane(),"���û���¼״̬�²������������û���ַ������ʧ��", "������Ϣ", JOptionPane.ERROR_MESSAGE);
                 	return;
            	}
            	Utile.BASEUrl = base_addr_str;
            	frame.dispose();
            	logger.info("��¼�ɹ���");
            	HttpFrame frame2 = new HttpFrame();
            	frame2.init();
            }
        });
        //��½��ť ����¼�
        login_btn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent arg0)
            {
                String password = String.valueOf(login_pwd.getPassword()).trim();
                String username = login_name.getText();
                String login_addr_str = login_addr_f.getText();
                String base_addr_str = base_addr_f.getText();
                
                if(password.equals("") || username.equals("") || login_addr_str.equals("") || base_addr_str.equals(""))
                {
                	JOptionPane.showMessageDialog(frame.getContentPane(),"��Ϣ��д������������ʧ��", "������Ϣ", JOptionPane.ERROR_MESSAGE);
                	return;
                }
                Utile.BASEUrl = base_addr_str;
                login_addr_str = Utile.getInstance().getFullUrl(login_addr_str);
                
                String str = LoginService.sendReq(login_addr_str,username, password);
                Map<String,Object> map = (Map<String,Object>)JSON.parse(str);
                if(!(boolean)map.get("success"))
                {
                	JOptionPane.showMessageDialog(frame.getContentPane(),map.get("reason").toString(),"������Ϣ", JOptionPane.ERROR_MESSAGE);
                	return;
                }
                //�����¼ƾ֤
                Map dataMap = (Map)JSON.parse(map.get("data").toString());
                Utile.TOKEN = dataMap.get("token").toString();
                JOptionPane.showMessageDialog(frame.getContentPane(),"��¼�ɹ������������","ϵͳ��ʾ", JOptionPane.INFORMATION_MESSAGE);
                
            	frame.dispose();
            	logger.info("��¼�ɹ���");
            	HttpFrame frame2 = new HttpFrame();
            	frame2.init();
            }
        });
        jp3.add(login_btn);
        jp3.add(cancel_btn);
        
        container.setLayout(new FlowLayout());
        container.add(jp00);
        container.add(jp0);
        container.add(jp1);
        container.add(jp2);
        container.add(jp3);
        
        SwingUtilities.updateComponentTreeUI(frame);//ͨ����ǰ��۳�ʼ���� UI ����
        //�޸�ͼ��
        Utile.getInstance().setIconImageFrame(frame, "/source/11.jpg");
        frame.setVisible(true);
    }
}
