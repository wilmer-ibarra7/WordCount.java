package week4;

import acm.program.ConsoleProgram;
import java.io.*;
public class WordCount extends ConsoleProgram {

	public void run() {
		int lines = 0;
		int words = 0;
		int chars = 0;
		BufferedReader buffer = openFileReader("File: ");
		try {
			while (true) {
				String line = buffer.readLine();
				if (line == null)
					break;
				lines++;
				words += countWords(line);
				chars += line.length();
			}
			buffer.close();
		} catch (IOException ex) {
			println("An I/O exception has occurred");
		}
		println("Lines = " + lines);
		println("Words = " + words);
		println("Chars = " + chars);
	}

	
	private BufferedReader openFileReader(String popScreen) {
		BufferedReader buffer = null;
		while (buffer == null) {
			String name = readLine(popScreen);
			try {
				buffer = new BufferedReader(new FileReader(name));
			} catch (IOException ex) {
				println("Oops I Did It Again");
			}
		}
		return buffer;
	}

	private int countWords(String line) {
		boolean inWord = false;
		int words = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				inWord = true;
			} else {
				if (inWord)
					words++;
				inWord = false;
			}
		}
		if (inWord)
			words++;
		return words;
	}
}
