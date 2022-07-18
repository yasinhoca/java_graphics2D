package tspd;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Canvas;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class m1 extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	Random r = new Random();
	int x,y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					m1 frame = new m1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public m1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = draw();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 400, 400);
		contentPane.add(panel);
		
		
		JButton btnNewButton = new JButton("Generate random 10 points");
		btnNewButton.setBounds(438, 10, 264, 38);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(panel);
				contentPane.repaint();
				panel = draw();
				panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.setBackground(Color.WHITE);
				panel.setBounds(10, 10, 400, 400);
				contentPane.add(panel);
				contentPane.repaint();
			}
		});

	}

	JPanel draw() {
		return new JPanel() {
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				super.paintComponent(g2);
				g2.setColor(Color.RED);
				g2.setStroke(new BasicStroke(3));
				g2.setFont(new Font("Verdana", 2, 12));
				
				for(int i=0;i<10;i++) {
					x=r.nextInt(350)+10;
					y=r.nextInt(350)+10;
					g2.drawOval(x, y, 5, 5);
					g2.drawString(Integer.toString(i), x, y-5);
				}
			};			
		};
	}
}
