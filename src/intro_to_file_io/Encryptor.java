package intro_to_file_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Encryptor {
	public static void main(String[] args) {
		Encryptor enc = new Encryptor();
		enc.openWindow();
	}
	public void openWindow() {
		String message = JOptionPane.showInputDialog("Please enter your message!");
		File f = new File("src/intro_to_file_io/enc1.txt");
		FileWriter fr = null;
		try {
			fr = new FileWriter(f);
			String encM = "";
			for(char c : message.toCharArray()) {
				encM += Character.toString((char) (c + 8));
			}
			System.out.println(encM);
			fr.write(encM);
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
