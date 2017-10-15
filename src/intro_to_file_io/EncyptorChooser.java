package intro_to_file_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class EncyptorChooser {
	public static void main(String[] args) {
		EncyptorChooser encC = new EncyptorChooser();
		encC.openWindow();
	}

	private void openWindow() {
		File f;
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			f = new File(fileName);
			if(!fileName.substring(fileName.length() - 3, fileName.length()).equalsIgnoreCase("txt")) {
				return;
			}
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String a = "";
				String line;
				while((line = br.readLine()) != null){
					System.out.println(line);
					for(char c : line.toCharArray()) {
						a += Character.toString((char) (c - 8));
					}
				}
				System.out.println(a);
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
