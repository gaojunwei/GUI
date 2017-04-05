package com.gjw.test.actiom;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gjw.test.util.Utile;

public class HttpFrame
{
	private static JFrame jFrame = null;
	private static int height = 500;
	private static int width = 500;
	private static String title = "HTTP �������";
	
	static JTextField req_addr;
	static JTextField req_header_text;
    static JTextField req_params;
	
    public static void main(String[] args) {
    	HttpFrame frame2 = new HttpFrame();
    	frame2.init();
	}
    
	public static void init() {
		jFrame = new JFrame();
		jFrame.setTitle(title);
		jFrame.setSize(width, height);
		//���ô��ھ���
		Utile.getInstance().centerFrame(jFrame);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel req_address = new JLabel("�����ַ��");
        JLabel req_param = new JLabel("���������");
        JLabel req_header = new JLabel("����ͷ������");
        
        JButton sendReq_btn = new JButton("�� �� �� ��");
        sendReq_btn.setPreferredSize(new Dimension(450,40));
        sendReq_btn.setFont(new Font("����", Font.BOLD, 25));
        //��������ť ����¼�
        sendReq_btn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent arg0)
            {
        		String req_addr_str = String.valueOf(req_addr.getText()).trim();
        		String req_params_str = String.valueOf(req_params.getText()).trim();
        		String req_header_text_str = String.valueOf(req_header_text.getText()).trim();
        		System.out.println(req_addr_str+","+req_params_str+","+req_header_text_str);
            }
        });
        
        req_addr = new JTextField(45);
        req_params = new JTextField(45);
        req_header_text = new JTextField(43);
        
        req_addr.setName("username");
        req_params.setName("userpwd");
        
        JPanel jp1 = new JPanel(new GridLayout(0,1));
        JPanel jp1_1 = new JPanel();
        jp1_1.add(req_address);
        jp1_1.add(req_addr);
        jp1.add(jp1_1);
        
        JPanel jp2 = new JPanel(new GridLayout(0,1));
        JPanel jp2_2 = new JPanel();
        jp2_2.add(req_param);
        jp2_2.add(req_params);
        jp2.add(jp2_2);
        
        JPanel jp3 = new JPanel(new GridLayout(0,1));
        JPanel jp3_3 = new JPanel();
        jp3_3.add(req_header);
        jp3_3.add(req_header_text);
        jp3.add(jp3_3);
        
        JPanel jp4 = new JPanel();
        jp4.add(sendReq_btn);
		
        //���ô�С�����Ե���GirdLayout
        jFrame.setResizable(false);
		
		Container container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());
        container.add(jp1_1);
        container.add(jp2_2);
        container.add(jp3_3);
        container.add(jp4);
		
		//��Ӵ��ڹرռ���
		jFrame.addWindowListener(new WDListener());
		jFrame.setVisible(true);
		
	}
}
