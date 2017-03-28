package Transh;
import java.awt.*;
import javax.swing.*;

public class Loading_Option1 extends JFrame {

	private JPanel contentPane;
	private JLabel label1, label2, label3;

	public Loading_Option1() {

		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 26, 26));
		// contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));

		label1 = new JLabel();
		contentPane.add(label1);

		label2 = new JLabel();
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setIcon(new ImageIcon("Images/ajax-loader.gif"));
		contentPane.add(label2);
		
		label3 = new JLabel("Loding...");
		label3.setFont(new Font("±¼¸²", Font.BOLD, 16));
		label3.setForeground(Color.WHITE);
		label3.setVerticalAlignment(SwingConstants.TOP);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label3);
		
		setUndecorated(true);
		setSize(1200, 700);
		setLocationRelativeTo(null);
		//setBackground(new Color(0, 255, 0, 0));
		setVisible(true);

	}

	public static void main(String[] args) {
		new Loading_Option1();
	}
}