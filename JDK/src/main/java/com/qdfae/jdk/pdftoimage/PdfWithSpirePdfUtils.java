package com.qdfae.jdk.pdftoimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.spire.pdf.PdfDocument;

/**
 * http://e-iceblue.cn/spirepdfjava/pdf-to-image-in-java.html
 * 
 * 技术：Spire.PDF
 *
 * @author hongwei.lian
 * @date 2019年3月5日 上午9:57:14
 */
public class PdfWithSpirePdfUtils {

	public static void main(String[] args) throws IOException {
        //加载PDF文件
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("C:\\Users\\Administrator\\Downloads\\software\\pdffolder\\pdf\\1214235423534.pdf");
        //保存PDF的每一页到图片
        BufferedImage image;
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            image = doc.saveAsImage(i);
            System.out.println("====" + image.getType());
            File file = new File(String.format("C:\\Users\\Administrator\\Downloads\\software\\pdffolder\\image\\ToImage-img-%d.png", i));
            ImageIO.write(image, "PNG", file);
        }
        doc.close();
    }
	
}
