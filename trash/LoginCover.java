package Transh;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginCover extends TransparentFrame {
	
	JLabel id, pass;
	
	public LoginCover() {
		
		getContentPane().setBackground(Color.RED);
		this.setLayout(null);
		
		id = new JLabel("ID.");
		id.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		id.setBounds(480,330,200,20);
		this.add(id);
		
		pass = new JLabel("PASSWORD.");
		pass.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		pass.setBounds(480,445,200,20);
		this.add(pass);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
}
