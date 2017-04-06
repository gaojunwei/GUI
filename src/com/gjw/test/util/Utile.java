package com.gjw.test.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Utile extends JFrame
{
	private static final long serialVersionUID = 9037420577250914815L;

	public static String 		BASEUrl = "";
	public static String 		TOKEN = "";
	public static Utile 		utile = null;
    //private Utile(){}
    
    /**
     * <li>�������ƣ�����ģʽ</li>
     * */
    public static Utile getInstance()
    {
        if (utile == null)
        {
            synchronized (Utile.class)
            {
                if (utile == null)
                {
                	utile = new Utile();
                }
            }
        }
        return utile;
    }
	
	/**
	 * ��Ļ������ʾ
	 */
	public void centerFrame(JFrame jFrame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dimension.width-jFrame.getWidth())/2;
        int y = (dimension.height-jFrame.getHeight())/2;
        jFrame.setLocation(x, y);
	}
	
	/**
	 * ��Ļ������ʾ
	 */
	public void centerDialog(JDialog jDialog) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dimension.width-jDialog.getWidth())/2;
		int y = (dimension.height-jDialog.getHeight())/2;
		jDialog.setLocation(x, y);
	}
	
	/**
	 * JDialog����ͼ��
	 * @param jDialog
	 * @param jDialog
	 */
	public void setIconImageDialog(JDialog jDialog,String imgPath) {
		jDialog.setIconImage (Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+imgPath));
	}
	
	/**
	 * Frame����ͼ��
	 * @param jFrame
	 * @param imgPath
	 */
	public void setIconImageFrame(JFrame jFrame,String imgPath) {
		jFrame.setIconImage (Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+imgPath));
	}
	
	/**
	 * ���������URL
	 * @param jFrame
	 * @param imgPath
	 */
	public String getFullUrl(String reqUrl) {
		if(!reqUrl.substring(0,7).equals("http://"))
			reqUrl = Utile.BASEUrl+reqUrl;
		return reqUrl;
	}
}
