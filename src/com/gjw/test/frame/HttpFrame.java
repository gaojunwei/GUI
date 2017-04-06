package com.gjw.test.frame;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.gjw.test.listener.WDListener;
import com.gjw.test.service.HttpService;
import com.gjw.test.util.Utile;

public class HttpFrame
{
	private static JFrame jFrame = null;
	private static int height = 510;
	private static int width = 500;
	private static String title = "HTTP 请求测试";
	
	static JTextField req_addr;
	static JTextField req_header_text;
    static JTextField req_params;
    static JTextArea text_area;
    
	public static void init() {
		jFrame = new JFrame();
		jFrame.setTitle(title);
		jFrame.setSize(width, height);
		//设置窗口居中
		Utile.getInstance().centerFrame(jFrame);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel req_address = new JLabel("请求地址：");
        JLabel req_param = new JLabel("请求参数：");
        JLabel req_header = new JLabel("请求头参数：");
        
        JButton sendReq_btn = new JButton("发 送 请 求");
        sendReq_btn.setPreferredSize(new Dimension(450,40));
        sendReq_btn.setFont(new Font("宋体", Font.BOLD, 25));
        //发送请求按钮 添加事件
        sendReq_btn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent arg0)
            {
        		String req_addr_str = String.valueOf(req_addr.getText()).trim();
        		String req_params_str = String.valueOf(req_params.getText()).trim();
        		String req_header_text_str = String.valueOf(req_header_text.getText()).trim();
        		
        		if(req_addr_str.equals(""))
        		{
        			text_area.append("请求地址为空，操作失败");
        			return;
        		}
        		text_area.append("请求地址："+req_addr_str+"\n");
        		text_area.append("请求参数："+req_params_str+"\n");
        		text_area.append("请求头参数："+req_header_text_str+"\n");
        		
        		String result = HttpService.sendReq(req_addr_str, req_params_str, req_header_text_str);
        		text_area.append("请求返回数据："+result+"\n");
        		
        		//打开jdialog对话框
        		/*JDialogOne jDialogOne = new JDialogOne(jFrame, "对话框", true);
        		System.out.println("得到JDialog输入框中的值："+jDialogOne.getParam());*/
            }
        });
        
        req_addr = new JTextField(45);
        req_params = new JTextField(45);
        req_header_text = new JTextField(43);
        
        text_area = new JTextArea(14,65);
        text_area.setEditable(false);
        text_area.setLineWrap(true);//设置文本区的换行策略。如果设置为 true，则当行的长度大于所分配的宽度时，将换行。如果设置为 false，则始终不换行
        
        JScrollPane scrollPane = new JScrollPane(text_area);  
        
        //分别设置水平和垂直滚动条自动出现
        scrollPane.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
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
        
        JPanel jp4 = new JPanel(new GridLayout(0,1));
        JPanel jp4_4 = new JPanel();
        jp4_4.add(sendReq_btn);
        jp4.add(jp4_4);
        
        JPanel jp5 = new JPanel(new GridLayout(1,1));
        jp5.add(scrollPane);
        
        //设置大小不可以调节GirdLayout
        jFrame.setResizable(false);
		
		Container container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());
        container.add(jp1_1);
        container.add(jp2_2);
        container.add(jp3_3);
        container.add(jp4);
        container.add(jp5);
		
		//添加窗口关闭监听
		jFrame.addWindowListener(new WDListener());
		jFrame.setVisible(true);
		
	}
}
