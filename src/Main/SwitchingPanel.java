package Main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import Sub_Book.*;
import Sub_Member.*;


public class SwitchingPanel {}



// ��ӹ޾� �̹��� ��θ� ���� �����Ͽ� �ѷ��ֱ�....
// class home extends SwitchingPanel {
//
// home() {
// imagefile = new File("images/Main_Page_Sample1.png");
// }
//
// }

// book Panel
class Books extends JPanel {
	private static final long serialVersionUID = 8958177589225906941L;
	public Image img = null;
	static File imagefile = new File("images/test2.jpg");
	
	Books() {
		
		try {
			img = ImageIO.read(imagefile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, 0, 0, this);
	
		
		// 1125, 700
		setLayout(null);
//
//		// String
//
//		JLabel title_Label = new JLabel("Bookmanagement");
//		title_Label.setFont(new Font("����", Font.BOLD, 40));
//		title_Label.setVerticalAlignment(SwingConstants.BOTTOM);
//		title_Label.setHorizontalAlignment(SwingConstants.CENTER);
//		title_Label.setBounds(160, 80, 800, 60);
//		add(title_Label);
//
//		JLabel subtitle_Label = new JLabel("Choose as your purpose");
//		subtitle_Label.setVerticalAlignment(SwingConstants.CENTER);
//		subtitle_Label.setHorizontalAlignment(SwingConstants.CENTER);
//		subtitle_Label.setBounds(460, 140, 200, 90);
//		add(subtitle_Label);
//		
		
		// Select Box_eventIcon

		JLabel icon_First = new JLabel();
		icon_First.setHorizontalAlignment(SwingConstants.CENTER);
		icon_First.setVerticalAlignment(SwingConstants.CENTER);
		icon_First.setOpaque(true);
		icon_First.setBackground(new Color(16, 198, 252));
		icon_First.setIcon(new ImageIcon("Images/icon_book_registration.png"));
		//icon_First.setPreferredSize(new Dimension(200, 200));
		icon_First.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				icon_First.setVerticalAlignment(SwingConstants.BOTTOM);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon_First.setVerticalAlignment(SwingConstants.CENTER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// dispose();
				setVisible(false);
				// remove(OperationPanel.border.getLayoutComponent(BorderLayout.CENTER));
				Book_Registration regi;
				regi = new Book_Registration();
				regi.setSize(1124,700);
				MainFrame.contentPane.add(regi, BorderLayout.CENTER);
				regi.updateUI();

			}
		});
		//grid_Middle_Icon_Panel.add(icon_First);
		icon_First.setBounds(70,230,210,210);
		add(icon_First);
		icon_First.repaint();
		
		
		JLabel icon_Second = new JLabel();
		icon_Second.setIcon(new ImageIcon("Images/icon_book_modification.png"));
		icon_Second.setHorizontalAlignment(SwingConstants.CENTER);
		icon_Second.setVerticalAlignment(SwingConstants.CENTER);
		icon_Second.setOpaque(true);
		icon_Second.setBackground(new Color(131, 90, 235));
		//icon_Second.setPreferredSize(new Dimension(200, 200));
		icon_Second.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				setVisible(false);
				//Book_Modification modi = new Book_Modification();
				Book_Search sear = new Book_Search();
				sear.setSize(1124,700);
				MainFrame.contentPane.add(sear, BorderLayout.CENTER); /// ����...
				sear.updateUI();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		icon_Second.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				icon_Second.setHorizontalAlignment(SwingConstants.RIGHT);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon_Second.setHorizontalAlignment(SwingConstants.CENTER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Book_Search sear = new Book_Search();
				sear.setSize(1124,700);
				MainFrame.contentPane.add(sear, BorderLayout.CENTER); /// ����...
				sear.updateUI();
			}
		});
		//grid_Middle_Icon_Panel.add(icon_Second);
		icon_Second.setBounds(330,230,210,210);
		add(icon_Second);
		icon_Second.repaint();

		
		JLabel icon_Third = new JLabel();
		icon_Third.setIcon(new ImageIcon("Images/icon_book_deletion.png"));
		icon_Third.setHorizontalAlignment(SwingConstants.CENTER);
		icon_Third.setVerticalAlignment(SwingConstants.CENTER);
		icon_Third.setOpaque(true);
		icon_Third.setBackground(new Color(0, 36, 83));
		//icon_Third.setPreferredSize(new Dimension(200, 200));
		icon_Third.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				setVisible(false);
				Book_Deletion del = new Book_Deletion();
				del.setSize(1124,700);
				MainFrame.contentPane.add(del, BorderLayout.CENTER); /// ����...
				del.updateUI();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
		icon_Third.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				icon_Third.setVerticalAlignment(SwingConstants.TOP);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon_Third.setVerticalAlignment(SwingConstants.CENTER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				// remove(OperationPanel.border.getLayoutComponent(BorderLayout.CENTER));
				Book_Deletion del = new Book_Deletion();
				del.setSize(1124,700);
				MainFrame.contentPane.add(del, BorderLayout.CENTER); /// ����...
				del.updateUI();
				
				
			}
		});
		//grid_Middle_Icon_Panel.add(icon_Third);
		icon_Third.setBounds(590,230,210,210);
		add(icon_Third);
		icon_Third.repaint();

		JLabel icon_Forth = new JLabel();
		icon_Forth.setIcon(new ImageIcon("Images/icon_book_statics.png"));
		icon_Forth.setHorizontalAlignment(SwingConstants.CENTER);
		icon_Forth.setVerticalAlignment(SwingConstants.CENTER);
		icon_Forth.setOpaque(true);
		icon_Forth.setBackground(new Color(255, 43, 74));
		//icon_Forth.setPreferredSize(new Dimension(200, 200));
		icon_Forth.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				setVisible(false);
				Book_Statics sta = new Book_Statics();
				sta.setSize(1124,700);
				MainFrame.contentPane.add(sta, BorderLayout.CENTER); /// ����...
				sta.updateUI();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		icon_Forth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				icon_Forth.setHorizontalAlignment(SwingConstants.LEFT);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon_Forth.setHorizontalAlignment(SwingConstants.CENTER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				// remove(OperationPanel.border.getLayoutComponent(BorderLayout.CENTER));
				Book_Statics sta = new Book_Statics();
				sta.setSize(1124,700);
				MainFrame.contentPane.add(sta, BorderLayout.CENTER); /// ����...
				sta.updateUI();
			}
		});
		//grid_Middle_Icon_Panel.add(icon_Forth);
		icon_Forth.setBounds(850,230,210,210);
		add(icon_Forth);
		icon_Forth.repaint();

		// Select Box_String

		JLabel string_First = new JLabel("Registration");
		string_First.setEnabled(false);
		string_First.setForeground(new Color(128, 128, 128));
		string_First.setBackground(null);
		string_First.setHorizontalAlignment(SwingConstants.CENTER);
		//string_First.setVerticalAlignment(SwingConstants.BOTTOM);
		string_First.setBounds(70,442,210,30);
		add(string_First);
		string_First.setOpaque(true);
		string_First.repaint();
		

		JLabel string_Second = new JLabel("Modification");
		string_Second.setEnabled(false);
		string_Second.setForeground(new Color(128, 128, 128));
		string_Second.setHorizontalAlignment(SwingConstants.CENTER);
		//string_Second.setVerticalAlignment(SwingConstants.BOTTOM);
		string_Second.setBounds(330,442,210,30);
		add(string_Second);
		string_Second.setOpaque(true);
		string_Second.repaint();


		JLabel string_Third = new JLabel("Deletion");
		string_Third.setEnabled(false);
		string_Third.setForeground(new Color(128, 128, 128));
		string_Third.setHorizontalAlignment(SwingConstants.CENTER);
		//string_Third.setVerticalAlignment(SwingConstants.BOTTOM);
		string_Third.setBounds(590,442,210,30);
		add(string_Third);
		string_Third.setOpaque(true);
		string_Third.repaint();

		JLabel string_forth = new JLabel("Statics");
		string_forth.setEnabled(false);
		string_forth.setForeground(new Color(128, 128, 128));
		string_forth.setHorizontalAlignment(SwingConstants.CENTER);
		//string_forth.setVerticalAlignment(SwingConstants.BOTTOM);
		string_forth.setBounds(850,442,210,30);
		add(string_forth);
		string_forth.setOpaque(true);
		string_forth.repaint();

		

	}
	
}



class Member extends JPanel {
	private static final long serialVersionUID = 137324716901030271L;
	public Image img = null;
	static File imagefile = new File("images/Resize_blur_bg.png");
	
	Member() {
		
		try {
			img = ImageIO.read(imagefile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, 0, 0, this);
	
		
		// 1125, 700
		setLayout(null);
//
//		// String
//
//		JLabel title_Label = new JLabel("Bookmanagement");
//		title_Label.setFont(new Font("����", Font.BOLD, 40));
//		title_Label.setVerticalAlignment(SwingConstants.BOTTOM);
//		title_Label.setHorizontalAlignment(SwingConstants.CENTER);
//		title_Label.setBounds(160, 80, 800, 60);
//		add(title_Label);
//
//		JLabel subtitle_Label = new JLabel("Choose as your purpose");
//		subtitle_Label.setVerticalAlignment(SwingConstants.CENTER);
//		subtitle_Label.setHorizontalAlignment(SwingConstants.CENTER);
//		subtitle_Label.setBounds(460, 140, 200, 90);
//		add(subtitle_Label);
//		
		
		// Select Box_eventIcon

		JLabel icon_First = new JLabel();
		icon_First.setHorizontalAlignment(SwingConstants.CENTER);
		icon_First.setVerticalAlignment(SwingConstants.CENTER);
		icon_First.setOpaque(true);
		icon_First.setBackground(new Color(16, 198, 252));
		icon_First.setIcon(new ImageIcon("Images/icon_people_registration.png"));
		//icon_First.setPreferredSize(new Dimension(200, 200));
		icon_First.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				setVisible(false);
				Mem_Registration mem_regi = new Mem_Registration();
				mem_regi.setSize(1124,700);
				MainFrame.contentPane.add(mem_regi, BorderLayout.CENTER); /// ����...
				mem_regi.updateUI();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		icon_First.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				icon_First.setVerticalAlignment(SwingConstants.BOTTOM);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon_First.setVerticalAlignment(SwingConstants.CENTER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// dispose();
				setVisible(false);
				// remove(OperationPanel.border.getLayoutComponent(BorderLayout.CENTER));
				Mem_Registration mem_regi = new Mem_Registration();
				mem_regi.setSize(1124,700);
				MainFrame.contentPane.add(mem_regi, BorderLayout.CENTER);
				mem_regi.updateUI();
			}
		});
		//grid_Middle_Icon_Panel.add(icon_First);
		icon_First.setBounds(70,230,210,210);
		add(icon_First);
		icon_First.repaint();
		
		
		JLabel icon_Second = new JLabel();
		icon_Second.setIcon(new ImageIcon("Images/icon_people_modification.png"));
		icon_Second.setHorizontalAlignment(SwingConstants.CENTER);
		icon_Second.setVerticalAlignment(SwingConstants.CENTER);
		icon_Second.setOpaque(true);
		icon_Second.setBackground(new Color(131, 90, 235));
		//icon_Second.setPreferredSize(new Dimension(200, 200));
		icon_Second.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				setVisible(false);
				Mem_Search mem_search = new Mem_Search();
				mem_search.setSize(1124,700);
				MainFrame.contentPane.add(mem_search, BorderLayout.CENTER); /// ����...
				mem_search.updateUI();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		icon_Second.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				icon_Second.setHorizontalAlignment(SwingConstants.RIGHT);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon_Second.setHorizontalAlignment(SwingConstants.CENTER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Mem_Search mem_search = new Mem_Search();
				mem_search.setSize(1124,700);
				MainFrame.contentPane.add(mem_search, BorderLayout.CENTER); /// ����...
				mem_search.updateUI();
				
			}
		});
		//grid_Middle_Icon_Panel.add(icon_Second);
		icon_Second.setBounds(330,230,210,210);
		add(icon_Second);
		icon_Second.repaint();

		
		JLabel icon_Third = new JLabel();
		icon_Third.setIcon(new ImageIcon("Images/icon_poeple_deletion.png"));
		icon_Third.setHorizontalAlignment(SwingConstants.CENTER);
		icon_Third.setVerticalAlignment(SwingConstants.CENTER);
		icon_Third.setOpaque(true);
		icon_Third.setBackground(new Color(0, 36, 83));
		//icon_Third.setPreferredSize(new Dimension(200, 200));
		icon_Third.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				setVisible(false);
				Mem_Deletion mem_del = new Mem_Deletion();
				mem_del.setSize(1124,700);
				MainFrame.contentPane.add(mem_del, BorderLayout.CENTER); /// ����...
				mem_del.updateUI();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		icon_Third.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				icon_Third.setVerticalAlignment(SwingConstants.TOP);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon_Third.setVerticalAlignment(SwingConstants.CENTER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				// remove(OperationPanel.border.getLayoutComponent(BorderLayout.CENTER));
				Mem_Deletion mem_del = new Mem_Deletion();
				mem_del.setSize(1124,700);
				MainFrame.contentPane.add(mem_del, BorderLayout.CENTER); /// ����...
				mem_del.updateUI();
			}
		});
		//grid_Middle_Icon_Panel.add(icon_Third);
		icon_Third.setBounds(590,230,210,210);
		add(icon_Third);
		icon_Third.repaint();

		JLabel icon_Forth = new JLabel();
		icon_Forth.setIcon(new ImageIcon("Images/icon_people_statics.png"));
		icon_Forth.setHorizontalAlignment(SwingConstants.CENTER);
		icon_Forth.setVerticalAlignment(SwingConstants.CENTER);
		icon_Forth.setOpaque(true);
		icon_Forth.setBackground(new Color(255, 43, 74));
		//icon_Forth.setPreferredSize(new Dimension(200, 200));
		icon_Forth.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				setVisible(false);
				Mem_Statics mem_sta = new Mem_Statics();
				mem_sta.setSize(1124,700);
				MainFrame.contentPane.add(mem_sta, BorderLayout.CENTER); /// ����...
				mem_sta.updateUI();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		icon_Forth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				icon_Forth.setHorizontalAlignment(SwingConstants.LEFT);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				icon_Forth.setHorizontalAlignment(SwingConstants.CENTER);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				// remove(OperationPanel.border.getLayoutComponent(BorderLayout.CENTER));
				Mem_Statics mem_sta = new Mem_Statics();
				mem_sta.setSize(1124,700);
				MainFrame.contentPane.add(mem_sta, BorderLayout.CENTER); /// ����...
				mem_sta.updateUI();
			}
		});
		//grid_Middle_Icon_Panel.add(icon_Forth);
		icon_Forth.setBounds(850,230,210,210);
		add(icon_Forth);
		icon_Forth.repaint();

		// Select Box_String

		JLabel string_First = new JLabel("Registration");
		string_First.setEnabled(false);
		string_First.setForeground(new Color(128, 128, 128));
		string_First.setBackground(null);
		string_First.setHorizontalAlignment(SwingConstants.CENTER);
		//string_First.setVerticalAlignment(SwingConstants.BOTTOM);
		string_First.setBounds(70,442,210,30);
		add(string_First);
		string_First.setOpaque(true);
		string_First.repaint();
		

		JLabel string_Second = new JLabel("Modification");
		string_Second.setEnabled(false);
		string_Second.setForeground(new Color(128, 128, 128));
		string_Second.setHorizontalAlignment(SwingConstants.CENTER);
		//string_Second.setVerticalAlignment(SwingConstants.BOTTOM);
		string_Second.setBounds(330,442,210,30);
		add(string_Second);
		string_Second.setOpaque(true);
		string_Second.repaint();


		JLabel string_Third = new JLabel("Deletion");
		string_Third.setEnabled(false);
		string_Third.setForeground(new Color(128, 128, 128));
		string_Third.setHorizontalAlignment(SwingConstants.CENTER);
		//string_Third.setVerticalAlignment(SwingConstants.BOTTOM);
		string_Third.setBounds(590,442,210,30);
		add(string_Third);
		string_Third.setOpaque(true);
		string_Third.repaint();

		JLabel string_forth = new JLabel("Statics");
		string_forth.setEnabled(false);
		string_forth.setForeground(new Color(128, 128, 128));
		string_forth.setHorizontalAlignment(SwingConstants.CENTER);
		//string_forth.setVerticalAlignment(SwingConstants.BOTTOM);
		string_forth.setBounds(850,442,210,30);
		add(string_forth);
		string_forth.setOpaque(true);
		string_forth.repaint();
	
		setSize(1124,700);
	}	
}

