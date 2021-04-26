package com.rding.www;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class study_java_JPanel_demo_1 extends JPanel{
	
	Image img_board	= Toolkit.getDefaultToolkit().getImage("res//img//board.png");
	Image img_chess	= Toolkit.getDefaultToolkit().getImage("res//img//chessmen_two.png");
	Image img_white = Toolkit.getDefaultToolkit().getImage("res//img//chessmen_white.png");
	Image img_black = Toolkit.getDefaultToolkit().getImage("res//img//chessmen_black.png");

	int img_bool = 0;
	Boolean win_game = false;
	
	int[][] map_chessmen = new int[16][16];
	int[][] map_time = new int[16][16];
	
	int player = 0;	// 1black, 2white
	int num_chess = 1;
	
	public study_java_JPanel_demo_1() {
		
		init_var();
		
	}
	
	private void init_var() {
		for(int i = 0; i < 16; i ++) {
			for(int j = 0; j < 16; j ++) {
				map_chessmen[i][j] = 0;
				map_time[i][j] = 0;
			}
		}
		img_bool = 0;
		win_game = false;
		
		player = 0;
		num_chess = 1;
		
		super.repaint();
	}
	
	public void click_left(int mouse_x, int mouse_y) {
		
		int index_x = (int)((mouse_x - 56) / 32);
		index_x = index_x < 0 ? 0 : index_x > 15 ? 15 : index_x;
		int index_y = (int)((mouse_y - 32) / 32);
		index_y = index_y < 0 ? 0 : index_y > 15 ? 15 : index_y;
		
//		System.out.println("x_y: " + index_x + "," + index_y);
		
		if(map_chessmen[index_y][index_x] != 0) {
			return;
		}
		
		map_chessmen[index_y][index_x] = player + 1;
		map_time[index_y][index_x] = num_chess;
		num_chess ++;
		player = (player + 1) % 2;
		
		super.repaint();
		
		// win function
		win_game = func_win(index_x, index_y);
		
		if (win_game == true) {
			String win_msg = "";
			if (player == 0) {
				win_msg = "白色胜利";
			}else {
				win_msg = "黑色胜利";
			}
			int res = JOptionPane.showConfirmDialog(null, win_msg, "win!!!", JOptionPane.YES_NO_OPTION);
			if (res == JOptionPane.YES_OPTION) {
				init_var();
			} else {
//				System.out.println("continue No");
				System.exit(-1);
			}
		}
	}
	
	/*
	 * 屎山代码
	 * time: 2021.04.23.22:10
	 * 准备重写
	 * */
	private Boolean func_win(int index_x, int index_y) {
		int count_chess = 1;
		for(int count_n = 1, dir = 1; count_n < 5; count_n ++) {
			int index_x2 = index_x + dir * count_n;
			if (index_x2 <0 || index_x2 > 15) {
				break;
			}
			if(map_chessmen[index_y][index_x2] == map_chessmen[index_y][index_x]) {
				count_chess += 1;
				if (count_chess >= 5) {
					return true;
				}
			}else {
				break;
			}
		}
		for(int count_n = 1, dir = -1; count_n < 5; count_n ++) {
			int index_x2 = index_x + dir * count_n;
			if (index_x2 <0 || index_x2 > 15) {
				break;
			}
			if(map_chessmen[index_y][index_x2] == map_chessmen[index_y][index_x]) {
				count_chess += 1;
				if (count_chess >= 5) {
					return true;
				}
			}else {
				break;
			}
		}
		
		count_chess = 1;
		for(int count_n = 1, dir = 1; count_n < 5; count_n ++) {
			int index_y2 = index_y + dir * count_n;
			if (index_y2 <0 || index_y2 > 15) {
				break;
			}
			if(map_chessmen[index_y2][index_x] == map_chessmen[index_y][index_x]) {
				count_chess += 1;
				if (count_chess >= 5) {
					return true;
				}
			}else {
				break;
			}
		}
		for(int count_n = 1, dir = -1; count_n < 5; count_n ++) {
			int index_y2 = index_y + dir * count_n;
			if (index_y2 <0 || index_y2 > 15) {
				break;
			}
			if(map_chessmen[index_y2][index_x] == map_chessmen[index_y][index_x]) {
				count_chess += 1;
				if (count_chess >= 5) {
					return true;
				}
			}else {
				break;
			}
		}
		
		count_chess = 1;
		for(int count_n = 1, dir = 1; count_n < 5; count_n ++) {
			int index_x2 = index_x + dir * count_n;
			int index_y2 = index_y + dir * count_n;
			if (index_x2 <0 || index_x2 > 15) {
				break;
			}
			if (index_y2 <0 || index_y2 > 15) {
				break;
			}
			if(map_chessmen[index_y2][index_x2] == map_chessmen[index_y][index_x]) {
				count_chess += 1;
				if (count_chess >= 5) {
					return true;
				}
			}else {
				break;
			}
		}
		for(int count_n = 1, dir = -1; count_n < 5; count_n ++) {
			int index_x2 = index_x + dir * count_n;
			int index_y2 = index_y + dir * count_n;
			if (index_x2 <0 || index_x2 > 15) {
				break;
			}
			if (index_y2 <0 || index_y2 > 15) {
				break;
			}
			if(map_chessmen[index_y2][index_x2] == map_chessmen[index_y][index_x]) {
				count_chess += 1;
				if (count_chess >= 5) {
					return true;
				}
			}else {
				break;
			}
		}
		
		count_chess = 1;
		for(int count_n = 1, dir = 1; count_n < 5; count_n ++) {
			int index_x2 = index_x + dir * count_n;
			int index_y2 = index_y - dir * count_n;
			if (index_x2 <0 || index_x2 > 15) {
				break;
			}
			if (index_y2 <0 || index_y2 > 15) {
				break;
			}
			if(map_chessmen[index_y2][index_x2] == map_chessmen[index_y][index_x]) {
				count_chess += 1;
				if (count_chess >= 5) {
					return true;
				}
			}else {
				break;
			}
		}
		for(int count_n = 1, dir = -1; count_n < 5; count_n ++) {
			int index_x2 = index_x + dir * count_n;
			int index_y2 = index_y - dir * count_n;
			if (index_x2 <0 || index_x2 > 15) {
				break;
			}
			if (index_y2 <0 || index_y2 > 15) {
				break;
			}
			if(map_chessmen[index_y2][index_x2] == map_chessmen[index_y][index_x]) {
				count_chess += 1;
				if (count_chess >= 5) {
					return true;
				}
			}else {
				break;
			}
		}
		
		return false;
	}
	
	public void click_right() {
		
		int max_chess = 0;
		int max_x = 0;
		int max_y = 0;
		for (int index_y = 0; index_y < 16; index_y ++) {
			for (int index_x = 0; index_x < 16; index_x ++) {
				if (max_chess < map_time[index_y][index_x]) {
					max_chess = map_time[index_y][index_x];
					max_x = index_x;
					max_y = index_y;
				}
			}
		}
		
		if (max_chess == 0) {
			return;
		}
		num_chess --;
		
		switch(map_chessmen[max_y][max_x]) {
		case 1:
			player = 0;
			break;
		case 2:
			player = 1;
			break;
		default:
			player = 0;
		}
		
		map_chessmen[max_y][max_x] = 0;
		map_time[max_y][max_x] = 0;
		win_game = false;

		super.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);	// 调用自身

//		g.drawImage(img_board, 0, 0, 32, 32, 64, 64, 128, 128, this);
		for (int index_y = 0; index_y < 16; index_y++) {
			for (int index_x = 0; index_x < 16; index_x ++) {
				
				Image img_draw = img_board;
				switch(map_chessmen[index_y][index_x]) {
				case 1:
					img_draw = img_black;
					break;
				case 2:
					img_draw = img_white;
					break;
				default:
					img_draw = img_board;
					break;
				}
				
				int draw_start_x = index_x * 32 + 56;	// (640 - (512 + 32 / 2)) / 2
				int draw_start_y = index_y * 32 + 32;
				int draw_end_x = draw_start_x + 32;
				int draw_end_y = draw_start_y + 32;
				
				int img_start_x = 64;
				int img_start_y = 64;
				
				switch(index_x) {
				case 0:
					img_start_x = 0;
					break;
				case 15:
					img_start_x = 128;
					break;
				default:
					img_start_x = 64;
				}
				
				switch(index_y) {
				case 0:
					img_start_y = 0;
					break;
				case 15:
					img_start_y = 128;
					break;
				default:
					img_start_y = 64;
				}
				
				int img_end_x = img_start_x + 63;
				int img_end_y = img_start_y + 63;
				
				g.drawImage(img_draw, 
						draw_start_x, draw_start_y, draw_end_x, draw_end_y, 
						img_start_x, img_start_y, img_end_x, img_end_y, this);
			}
		}
	}
	
	//  implements Runnable 
//	@Override
//	public void run() {
//		while(true) {
//			switch(img_bool) {
//			case 1:
//				img_draw = img_white;
//				break;
//			case 2:
//				img_draw = img_black;
//				break;
//			case 0:
//			default:
//				img_draw = img_board;
//			}
//			
//			img_bool = (img_bool + 1) % 3;
//			
//			this.repaint();
//			try {
//				Thread.sleep(500);
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
