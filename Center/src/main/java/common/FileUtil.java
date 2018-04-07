package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	public static String readAll(String fileName){
		try {
			File file = new File(fileName);

			BufferedReader bf = new BufferedReader(new FileReader(file));

			String content = "";
			StringBuilder sb = new StringBuilder();

			while (content != null) {
				content = bf.readLine();

				if (content == null) {
					break;
				}

				sb.append(content.trim());
			}

			bf.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
