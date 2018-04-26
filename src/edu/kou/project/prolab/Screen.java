package edu.kou.project.prolab;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;

import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;

public class Screen extends JFrame {

	private JPanel contentPane;
	Panel panel=null;	
	private JPanel pnCanvas;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
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
	public Screen() {
  
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ProLab Point QuadTree Implementation");
		setBounds(100, 100, 732, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		pnCanvas = new JPanel();
		pnCanvas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));		
		pnCanvas.setBounds(10, 10, 514, 514);
		pnCanvas.setBackground(Color.white);

		panel = new Panel(512, 512);
		panel.setBackground(Color.white);
		//mazeCanvas.setLocation(1, 1);
		//CanvasMouseListener canvasMouseListener = new CanvasMouseListener();
		//panel.addMouseListener(canvasMouseListener);
		pnCanvas.add(panel);
		
		contentPane.add(pnCanvas);
		pnCanvas.setLayout(null);
		
//		ButtonGroup group = new ButtonGroup();
//
//		JRadioButton rdbtnAddNode = new JRadioButton("Ekleme Modu");
//		rdbtnAddNode.setBounds(540, 10, 109, 23);
//		contentPane.add(rdbtnAddNode);
//
//		JRadioButton rdbtnDeleteNode = new JRadioButton("Silme Modu");
//		rdbtnDeleteNode.setBounds(540, 34, 109, 23);
//		contentPane.add(rdbtnDeleteNode);
//
//		group.add(rdbtnAddNode);
//		group.add(rdbtnDeleteNode);
//
		
		
	}
}
