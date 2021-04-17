package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Board;
import view.linearView;
import view.menuView;
import view.mixingView;
import view.powView;

public class menuController implements MouseListener, MouseMotionListener  {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		menuView.click = true;
		linearView.click_l = true;
		powView.click_p = true;
		mixingView.click_m = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		menuView.click = false;
		linearView.click_l = false;
		powView.click_p = false;
		mixingView.click_m = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Board.mouseX = e.getX();
		Board.mouseY = e.getY();
	}

}
