package com.gjw.test.jdialog;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gjw.test.util.Utile;

public class JDialogOne{
	
	private JDialog jdialog = null;
	static Map<String,Object> param;
	static JTextField user_imp;
	
	public JDialogOne(Frame owner, String title, boolean modal) {
		jdialog = new JDialog(owner, title, modal);
		jdialog.setSize(500, 150);
		jdialog.setResizable(false);
		Container container=jdialog.getContentPane();
		container.setLayout(new FlowLayout());
		
		JLabel user_imp_label = new JLabel("输入用户名：");
		user_imp = new JTextField(45);
        JButton confirmBtn=new JButton("确定");
        JButton cancelBtn=new JButton("取消");
        confirmBtn.setPreferredSize(new Dimension(225,40));
        cancelBtn.setPreferredSize(new Dimension(225,40));
        
        JPanel jp1_1 = new JPanel();
        JPanel jp1_2 = new JPanel();
        
        jp1_1.add(user_imp_label);
        jp1_1.add(user_imp);
        
        jp1_2.add(confirmBtn);
        jp1_2.add(cancelBtn);
        
        
        //给确定按钮添加事件
        confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				param = new HashMap<String, Object>();
				param.put("user_imp", user_imp.getText().trim());
				System.out.println("点击dialog确定按钮");
				jdialog.dispose();
			}
		});
        //给取消按钮添加事件
        cancelBtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		param = new HashMap<String, Object>();
        		System.out.println("点击dialog取消按钮");
        		jdialog.dispose();
        	}
        });
        
        JPanel jPanel = new JPanel();
        jPanel.setBounds(10, 10, 100, 100);
        
        container.add(jp1_1);
        container.add(jp1_2);
        
        //修改图标
        Utile.getInstance().setIconImageDialog(jdialog, "/source/dialog.jpg");
        jdialog.setIconImage (Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+"/source/dialog.jpg"));
        
        Utile.getInstance().centerDialog(jdialog);
		jdialog.setVisible(true);
	}

	public static Map<String, Object> getParam() {
		return param;
	}
}
