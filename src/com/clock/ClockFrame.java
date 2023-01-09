package com.clock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockFrame extends JFrame{
	Calendar calendar;
	SimpleDateFormat timeFormat, dayFormat, dateFormat;
	JLabel timeLabel, dayLabel, dateLabel;
	String time, day, date;
	
	ClockFrame(){
		this.setTitle("Jam Digital");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(500, 275);
		this.setResizable(false);
		
		//TIME
		timeFormat = new SimpleDateFormat("HH:mm:ss");	
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Helvetica", Font.BOLD, 100));
		timeLabel.setForeground(Color.DARK_GRAY);
		
		//DAY
		dayFormat = new SimpleDateFormat("EEEE");	
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Consolas", Font.PLAIN, 24));
		dayLabel.setForeground(Color.BLUE);
		
		//DATE
		dateFormat = new SimpleDateFormat(", dd MMMM yyyy");	
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Consolas", Font.PLAIN, 24));
		dateLabel.setForeground(Color.BLUE);
		
		
		//ADD LABEL TO FRAME
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		
		this.setVisible(true);
		setTime();
	}
	
	public void setTime(){
		while(true) {
				time = timeFormat.format(Calendar.getInstance().getTime());
				timeLabel.setText(time);
				
				day = dayFormat.format(Calendar.getInstance().getTime());
				dayLabel.setText(day);
				
				date = dateFormat.format(Calendar.getInstance().getTime());
				dateLabel.setText(date);
			
				try {
				Thread.sleep(1000);
				} catch (InterruptedException e) {
			}
		}
	}
}
