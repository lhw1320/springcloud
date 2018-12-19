//package com.qdfae.summarize.controller;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.ObjectUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.huajin.baymax.logger.XMsgError;
//import com.huajin.baymax.logger.Xlogger;
//import com.qdfae.summarize.util.CompressDownloadUtil;
//import com.qdfae.summarize.util.UUIDUtil;
//
///**
// * 压缩下载文件
// *
// * @author hongwei.lian
// * @date 2018年9月6日 下午6:29:05
// */
//@Controller
//@RequestMapping("/compressdownload")
//public class CompressDownloadController extends HjBaseController {
//	
////	@Autowired
////	private FeFileCenterService feFileCenterService;
////	
////	@Autowired
////	private SysParamService sysParamService;
//
//	/**
//	 * 多文件压缩下载
//	 * 
//	 * @author hongwei.lian
//	 * @date 2018年9月6日 下午6:28:56
//	 */
//	@RequestMapping("/downloadallfiles")
//	public void downloadallfiles() {
//		//-- 1、根据ids查询下载的文件地址列表
//		String ids = request().getParameter("ids");
//		if (StringUtils.isEmpty(ids)) {
//			return ;
//		}
//		//-- 将字符串数组改变为整型数组
//		Integer[] idsInteger = CompressDownloadUtil.toIntegerArray(ids);
//		List<FeFileCenter> fileCenters = feFileCenterService.getFeFileByIds(super.getExchangeId(), idsInteger);
//		if (CollectionUtils.isNotEmpty(fileCenters) && ObjectUtils.notEqual(idsInteger.length, fileCenters.size())) {
//			//-- 要下载文件Id数组个数和返回的文件地址个数不一致
//			return ;
//		}
//		
//		//-- 2、转换成文件列表
//		List<File> files = this.toFileList(fileCenters);
//		//-- 检查需要下载多文件列表中文件路径是否都存在
//		for (File file : files) {
//			if (!file.exists()) {
//				//-- 需要下载的文件中存在不存在地址
//				return ;
//			}
//		}
//		
//		//-- 3、响应头的设置
//		String downloadName = UUIDUtil.getUUID() + ".zip";
//		HttpServletResponse response = CompressDownloadUtil.setDownloadResponse(super.response(), downloadName);
//		
//		//-- 4、第一种方案：
//		//-- 指定ZIP压缩包路径
////		String zipFilePath = this.setZipFilePath(downloadName);
////		try {
////			//-- 将多个文件压缩到指定路径下
////			CompressDownloadUtil.compressZip(files, new FileOutputStream(zipFilePath));
////			//-- 下载压缩包
////			CompressDownloadUtil.downloadFile(response.getOutputStream(), zipFilePath);
////			//-- 删除临时生成的ZIP文件
////			CompressDownloadUtil.deleteFile(zipFilePath);
////		} catch (IOException e) {
////			Xlogger.error(XMsgError.buildSimple(CompressDownloadUtil.class.getName(), "downloadallfiles", e));
////		}
//		
//		//-- 5、第二种方案：
//	   try {
//		    //-- 将多个文件压缩写进响应的输出流
//			CompressDownloadUtil.compressZip(files, response.getOutputStream());
//		} catch (IOException e) {
//			Xlogger.error(XMsgError.buildSimple(CompressDownloadUtil.class.getName(), "downloadallfiles", e));
//		}
//		
//	}
//
//	/**
//	 * 设置临时生成的ZIP文件路径
//	 *
//	 * @param fileName
//	 * @return 
//	 * @author hongwei.lian
//	 * @date 2018年9月7日 下午3:54:13
//	 */
//	private String setZipFilePath(String fileName) {
//		String zipPath = sysParamService.getCompressDownloadFilePath();
//		File zipPathFile = new File(zipPath);
//		if (!zipPathFile.exists()) {
//			zipPathFile.mkdirs();
//		}
//		return zipPath + File.separator + fileName;
//	}
//
//	/**
//	 * 将fileCenters列表转换为File列表
//	 *
//	 * @param fileCenters
//	 * @return 
//	 * @author hongwei.lian
//	 * @date 2018年9月6日 下午6:54:16
//	 */
//	private List<File> toFileList(List<FeFileCenter> fileCenters) {
//		return fileCenters.stream()
//                                     .map(feFileCenter -> {
//                                    	 //-- 获取每个文件的路径
//                                    	 String filePath = this.getSysFilePath(feFileCenter.getFileTypeId());
//                                         return new File(filePath + feFileCenter.fileLink());})
//                                     .collect(Collectors.toList());
//	}
//	
//	/**
//	 * 获取文件类型对应存储路径
//	 *
//	 * @param fileTypeId
//	 * @return 
//	 * @author hongwei.lian
//	 * @date 2018年9月5日 下午2:01:53
//	 */
//	private String getSysFilePath(Integer fileTypeId){
//		SysParamPo sysmParam = sysParamService.getByParamKey(SysParamKey.FC_UPLOAD_ADDRESS.value);
//		String filePath = Objects.nonNull(sysmParam) ? sysmParam.getParamValue() : "";
//		return filePath + fileTypeId + File.separator;
//	}
//
//}