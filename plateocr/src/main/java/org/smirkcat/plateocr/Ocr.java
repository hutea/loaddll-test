package org.smirkcat.plateocr;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixReadMem;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.smirkcat.loaddll.JarDllJava;


public class Ocr {
	private static TessBaseAPI api = new TessBaseAPI();
	
	private static Mser detectId=new Mser();
	
	static {
		String rootPath=JarDllJava.rootPath(Ocr.class);
		if (api.Init(rootPath+"/tessdata", "eng") != 0 ||
				!api.SetVariable("tessedit_char_whitelist", "0123456789X")) {//只识别为0123456789X
			System.err.println("tesseract.TessBaseAPI初始化失败");
			System.exit(1);
        }
		else{
			System.out.println("tesseract.TessBaseAPI初始化成功");
		}
	}
	
	/**
	 * 
	 * @param img
	 * @param isPre 是否预处理，进行了预处理就调用了Mser
	 * @return
	 */
	public static String TessOcr(byte[] img,boolean isPre){
		if(img==null)
			return null;
		byte[] temp;
		if(isPre){
			temp=detectId.detectIdNum(img);
		}
		else 
			temp=img;
		PIX image = pixReadMem(temp, temp.length);
        api.SetImage(image);
        BytePointer outText = api.GetUTF8Text();
        
        if(outText==null){
        	return null;
        }
        String out=outText.getString();
        out=out.replaceAll(" ", "");
        outText.deallocate();
        pixDestroy(image);
		return out;
	}
}
