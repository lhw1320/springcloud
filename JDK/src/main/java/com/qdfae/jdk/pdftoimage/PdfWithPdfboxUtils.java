package com.qdfae.jdk.pdftoimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 * https://blog.csdn.net/thc1987/article/details/76457474
 * 
 * https://www.jb51.net/article/144380.htm
 * 
 * 技术：pdfbox
 *
 * @author hongwei.lian
 * @date 2019年3月5日 上午9:53:00
 */
public class PdfWithPdfboxUtils {
	
	public static void main(String[] args) {
		pdf2Image("C:\\Users\\Administrator\\Downloads\\software\\pdffolder\\pdf\\1214235423534.pdf", "C:\\Users\\Administrator\\Downloads\\software\\pdffolder\\image", 30);
	}
	
	/***
	 * PDF文件转PNG图片，全部页数
	 * 
	 * @param PdfFilePath pdf完整路径
	 * @param imgFilePath 图片存放的文件夹
	 * @param dpi dpi越大转换后越清晰，相对转换速度越慢
	 * @return
	 */
	public static void pdf2Image(String pdfFilePath, String dstImgFolder, int dpi) {
		File file = new File(pdfFilePath);
		PDDocument pdDocument;
		try {
			String imgPDFPath = file.getParent();
			int dot = file.getName().lastIndexOf('.');
			String imagePDFName = file.getName().substring(0, dot); // 获取图片文件名
			String imgFolderPath = null;
			if (dstImgFolder.equals("")) {
				imgFolderPath = imgPDFPath + File.separator + imagePDFName;// 获取图片存放的文件夹路径
			} else {
				imgFolderPath = dstImgFolder + File.separator + imagePDFName;
			}
			if (createDirectory(imgFolderPath)) {
				pdDocument = PDDocument.load(file);
				PDFRenderer renderer = new PDFRenderer(pdDocument);
				//-- com.itextpdf.text.pdf.PdfReader;
				//PdfReader reader = new PdfReader(pdfFilePath);
				//int pages = reader.getNumberOfPages();
				//System.out.println("====" + reader.getNumberOfPages());
				//System.out.println("====" + pdDocument.getNumberOfPages());
				int pages = pdDocument.getNumberOfPages();
				StringBuffer imgFilePath = null;
				//-- dpi越大转换后越清晰，相对转换速度越慢
				for (int i = 0; i < pages; i++) {
					String imgFilePathPrefix = imgFolderPath + File.separator + imagePDFName;
					imgFilePath = new StringBuffer();
					imgFilePath.append(imgFilePathPrefix);
					imgFilePath.append("_");
					imgFilePath.append(String.valueOf(i + 1));
					imgFilePath.append(".png");
					File dstFile = new File(imgFilePath.toString());
					BufferedImage image = renderer.renderImageWithDPI(i, dpi);
					ImageIO.write(image, "png", dstFile);
				}
				System.out.println("PDF文档转PNG图片成功！");
			} else {
				System.out.println("PDF文档转PNG图片失败：" + "创建" + imgFolderPath + "失败");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	private static boolean createDirectory(String folder) {
		File dir = new File(folder);
		if (dir.exists()) {
			return true;
		} else {
			return dir.mkdirs();
		}
	}

}
