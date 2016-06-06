package org.smirkcat.plateocr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Utils {
	
	/**
	 * 图片文件目录转化为二进制
	 * 
	 * @param fileName
	 * @return byte[]
	 */
	public static byte[] SetImageToByteArray(String fileName) {
		File file = new File(fileName);
		return SetImageToByteArray(file);
	}

	/**
	 * 图片文件转化为二进制
	 * 
	 * @param file
	 * @return
	 */

	public static byte[] SetImageToByteArray(File file) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			byte[] filebuff = new byte[fis.available()];
			fis.read(filebuff);
			fis.close();
			return filebuff;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
