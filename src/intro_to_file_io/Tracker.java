package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tracker implements ActionListener {
	/*4. Make a to-do list tracker:
		Create a window with four buttons: add task, remove task, save, and load.
		The add task button will display a JOptionPane to get a task from the user and add it to the list.
		Remove task will remove a task from the list. You can choose your own method of how to select a task from the list.
		The save button will save the current task list to a file.
		The load button will load a new task list into the program and display it.
		X The program should automatically load the last saved list from the file at startup and display it.*/
	private JFrame jFrame;
	private JPanel jPanel;
	private JButton jButton1,jButton2,jButton3,jButton4;
	private ArrayList<String> toSave = new ArrayList<String>();
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Tracker tracker = new Tracker();
	}
	public Tracker() {
		jFrame = new JFrame();
		jPanel = new JPanel();
		jFrame.add(jPanel);
		jButton1 = new JButton();jButton2 = new JButton();jButton3 = new JButton();jButton4 = new JButton();
		jPanel.add(jButton1);jPanel.add(jButton2);jPanel.add(jButton3);jPanel.add(jButton4);
		jButton1.setText("Add Task");jButton2.setText("Remove Task");jButton3.setText("Save");jButton4.setText("Load");
		jButton1.addActionListener(this);jButton2.addActionListener(this);jButton3.addActionListener(this);jButton4.addActionListener(this);
		jFrame.setVisible(true);
		jFrame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jButton1) {
			String task = JOptionPane.showInputDialog("Add a task!");
			toSave.add(task);
		}
		else if(e.getSource() == jButton3) {
			for(String s : toSave) {
				FileWriter fw;
				try {
					fw = new FileWriter("src/intro_to_file_io/data.txt",true);
					fw.write(s);
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				finally {
					try {
						fw = new FileWriter("src/intro_to_file_io/data.txt",true);
						fw.write("☕");
						fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		else if(e.getSource() == jButton2) {
			int mint = Integer.valueOf(JOptionPane.showInputDialog("Remove element 1 of " + getCount()));
			int count = mint;
			int currentCount = 0;
			int totalCount = 0;
			while(totalCount != getTotalCount()) {
				try {
					FileReader fr = new FileReader("src/intro_to_file_io/data.txt");
					int c = fr.read();
					System.out.println((char)c);
					while(c != -1){
						if((char)c == '☕') {
							currentCount++;
						}
						totalCount++;
						if(count != currentCount) {
							try {
								FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt");
								
								fw.write(c);
								
								fw.write("\nThis is me writing a message");
									
								fw.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						c = fr.read();
						
					}
					fr.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	private int getCount() {
		int count = 0;
		try {
			FileReader fr = new FileReader("src/intro_to_file_io/data.txt");
			int c = fr.read();
			while(c != -1){
				if((char)c == '☕') {
					count++;
				}
				c = fr.read();
				
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
	private int getTotalCount() {
		int count = 0;
		try {
			FileReader fr = new FileReader("src/intro_to_file_io/data.txt");
			int c = fr.read();
			while(c != -1){
				count++;
				c = fr.read();
				
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
}
