package com.gjw.test.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

import org.apache.log4j.Logger;

public class Utile extends JFrame
{
	private static final long serialVersionUID = 9037420577250914815L;

	private static Logger 		logger = Logger.getLogger(Utile.class.getName());
	
	public static Utile 	utile = null;
    private Utile(){}
    
    /**
     * <li>方法名称：单例模式</li>
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
	 * 屏幕居中显示
	 */
	public void centerFrame(JFrame jFrame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dimension.width-jFrame.getWidth())/2;
        int y = (dimension.height-jFrame.getHeight())/2;
        jFrame.setLocation(x, y);
	}
	
	/**
	 * 屏幕居中显示
	 */
	public void centerDialog(JDialog jDialog) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dimension.width-jDialog.getWidth())/2;
		int y = (dimension.height-jDialog.getHeight())/2;
		jDialog.setLocation(x, y);
	}
	
	/**
	 * JDialog设置图标
	 * @param jDialog
	 * @param jDialog
	 */
	public void setIconImageDialog(JDialog jDialog,String imgPath) {
		jDialog.setIconImage (Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+imgPath));
	}
	
	/**
	 * Frame设置图标
	 * @param jFrame
	 * @param imgPath
	 */
	public void setIconImageFrame(JFrame jFrame,String imgPath) {
		jFrame.setIconImage (Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+imgPath));
	}
}
