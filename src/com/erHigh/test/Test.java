package com.erHigh.test;

import org.pmw.tinylog.Logger;

import com.erHigh.view.MainView;
import com.erHigh.view.View;

public class Test {

	
	
	public static void main(String[] args) {
		Logger.info("开始进行测试");
		View mv = new MainView();
		mv.showView();
	}
}
