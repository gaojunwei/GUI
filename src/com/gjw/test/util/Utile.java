package com.gjw.test.util;

import java.awt.Toolkit;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

public class Utile extends JFrame
{
	private static final long serialVersionUID = 9037420577250914815L;

	private static Logger 		logger = Logger.getLogger(Utile.class.getName());
	
	public static Utile 	utile = null;
    private Utile(){}
    
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
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width-jFrame.getWidth())/2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height-jFrame.getHeight())/2;
        jFrame.setLocation(x, y);
	}
}
