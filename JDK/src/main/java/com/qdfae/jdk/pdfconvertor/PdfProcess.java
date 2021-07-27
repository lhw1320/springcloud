package com.qdfae.jdk.pdfconvertor;

import static com.itextpdf.kernel.pdf.PdfName.BaseFont;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.FilteredEventListener;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.text.DocumentException;

/**
 * pdf文件处理
 * 2016年12月2日 上午9:56:44
 */
public class PdfProcess {

    /**
     * 读取csv文件到pdf文件中
     * @param csvFile csv文件
     * @throws IOException
     * @return File 返回pdf文件
     * 2016年12月2日 上午9:51:56
     */
    public static File readCsvContentToPdf(File csvFile) throws IOException {
    	//生成pdf文件
    	String csvFilePath = csvFile.getPath();
    	if( !csvFilePath.endsWith(".csv") ) {
    		throw new IOException(csvFilePath + " is not csv file!");
    	}
    	String pdfFilePath = csvFilePath.substring(0,csvFilePath.lastIndexOf("."))+".pdf";
    	File pdfFile = new File(pdfFilePath);
    	
    	PdfDocument pdf = new PdfDocument(new PdfWriter(pdfFile.getPath()));
    	PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", false);
    	Document document = new Document(pdf,PageSize.A2);
    	
    	//读取csv文件
    	@SuppressWarnings("resource")
    	BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath),"UTF-8"));
    	String line = null;
    	while((line = reader.readLine())!=null){  
    		Paragraph contentParagraph = new Paragraph(line).setFont(font).setFontSize(9);  
    		document.add(contentParagraph);
        }
        reader.close();
    	pdf.close();
		document.close();
		return pdfFile;
    }
    
    /**
     * 读取Excel文件，得到PDF文件
     * PDF文件和Excel文件在相同目录下，文件名称相同
     * @param excelFile Excel文件
     * @return File
     * @author hongbo.zhao
     * 2016年12月21日 下午2:00:25
     */
    public static File readFromExcelToPdf(File excelFile) throws IOException {
    	File csvFile = PdfProcessSupport.readFromExcelToCsv(excelFile);
    	File pdfFile = readCsvContentToPdf(csvFile);
    	return pdfFile;
    }
    
    /**
     * 读取pdf文本为字符串
     * @param pdfFile pdf文件
     * @throws IOException
     * @return String
     * 2016年12月2日 上午10:02:43
     */
    public static String readPdfContentToStr(File pdfFile) throws IOException {
		PdfDocument pdfDoc = new PdfDocument(new PdfReader(pdfFile.getPath()));
		FilteredEventListener listener = new FilteredEventListener();
		StringBuilder sb = new StringBuilder();
		int pageSize = pdfDoc.getNumberOfPages();
		for (int i = 1; i <= pageSize; i++) {
			LocationTextExtractionStrategy extractionStrategy = listener.attachEventListener(new LocationTextExtractionStrategy());
			PdfCanvasProcessor processor = new PdfCanvasProcessor(listener);
			processor.processPageContent(pdfDoc.getPage(i));
			String actualText = extractionStrategy.getResultantText();
			sb.append(actualText);
		}
		pdfDoc.close();
		return sb.toString();
    }
    
    /**
     * 读取pdf文本为字符数组（按照 '\n'分割）
     * @param pdfFile pdf文件
     * @throws IOException
     * @return String[]
     * 2016年12月2日 上午10:02:43
     */

	public static String[] readPdfContentToArray(File pdfFile) throws IOException {
		String result = readPdfContentToStr(pdfFile);
		if (result != null && !result.equals("")) {
			return result.split("\n");
		}
		return null;
	}
    
    public static void main(String[] args) throws IOException {
    	File excelFile;
    	if(args.length ==1) {
    		excelFile =new File(args[0]);
    	}else {
    		excelFile =new File("D:/任务清单/20161018-互金平台对接-开放API平台/6000940.xlsx");
    	}
    	File pdfFile = PdfProcess.readFromExcelToPdf(excelFile);
    	String result = PdfProcess.readPdfContentToStr(pdfFile);
    	String []resultSplit = result.split("\n");
    	for (int i = 0; i < resultSplit.length; i++) {
			System.out.println(resultSplit[i].split(",")[1]);
			System.out.println("----------");
		}
    	System.out.println(resultSplit.length);
	}

	/**
	 * HTML 转PDF，FONT路径默认为 /fonts/simsun.ttc，并且Velocity已经初始化过
	 * @param param 模板中待替换的参数
	 * @param velocityName velocity 模板名称
	 * @param outFile pdf文件输入路径
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void html2pdf(Map<String,Object> param,String velocityName,String outFile) throws IOException, DocumentException {
		html2pdf( param,velocityName,outFile,null);
	}

	/**
	 * HTML 转PDF，FONT路径默认为 /fonts/simsun.ttc，并且Velocity已经初始化过
	 * @param param 模板中待替换的参数
	 * @param velocityName velocity 模板名称
	 * @param outFile pdf文件输入路径
	 * @param fontPath font文件路径
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void html2pdf(Map<String,Object> param,String velocityName,String outFile,String fontPath) throws IOException, DocumentException {
		html2pdf( param,velocityName,outFile,fontPath,null);
	}

	/**
	 * HTML 转PDF，FONT路径默认为 /fonts/simsun.ttc，Velocity如果未初始化，则会根据 @tempRootPath 的值
	 * 进行初始化，否则忽略该值。
	 *
	 * @param param 模板中待替换的参数
	 * @param velocityName velocity 模板名称
	 * @param outFile pdf文件输入路径
	 * @param fontPath font文件路径
	 * @throws IOException
	 * @throws DocumentException
	 */
	@SuppressWarnings("static-access")
	public static void html2pdf(Map<String,Object> param,String velocityName,String outFile,String fontPath,String tempRootPath) throws IOException, DocumentException {
		if(!RuntimeSingleton.isInitialized()) {
			if(StringUtils.isNotBlank(tempRootPath)) {
				Properties properties = new Properties();
				properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, tempRootPath);
				Velocity.init(properties);
			} else {
				throw new RuntimeException("Velocity未初始化，并且没有提供模板根目录");
			}
		}
		//设置默认font
		if(StringUtils.isBlank(fontPath)){
			fontPath = "/fonts/simsun.ttc";
		}
		//设置velocity 模板需要的参数
		VelocityContext context = new VelocityContext();
		if(MapUtils.isNotEmpty(param)) {
			for(String key:param.keySet()) {
				context.put(key,param.get(key));
			}
		}
		//替换velocity模板中的参数，并将替换后的结果放入到 stringWriter 中
		StringWriter stringWriter = new StringWriter();
		if(Velocity.resourceExists(velocityName)) {
			Velocity.mergeTemplate(velocityName, "UTF-8", context, stringWriter);
		} else {
			String resourceRootPath = Velocity.getProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH).toString();
			throw new RuntimeException("Velocity 模板在模板根目录【"+resourceRootPath+"】中不存在");
		}
		// html文件内容输出到PDF文件中
		OutputStream os = null;
		try {
			os = new FileOutputStream(outFile);
			ITextRenderer renderer = new ITextRenderer();
			ITextFontResolver fontResolver = renderer.getFontResolver();
			fontResolver.addFont(fontPath, BaseFont.IdentityH.getValue(), false);
			renderer.setDocumentFromString(stringWriter.toString(), null);
			renderer.layout();
			renderer.createPDF(os);
			os.close();
		}finally {
			if(os !=null) {
				os.close();
			}
		}
	}
    
}
