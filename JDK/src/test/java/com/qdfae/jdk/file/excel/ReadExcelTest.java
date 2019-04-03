package com.qdfae.jdk.file.excel;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.qdfae.jdk.domain.BizimportTradeDetailVo;
import com.qdfae.jdk.enums.CertificateTypeEnum;
import com.qdfae.jdk.exception.BayMaxBaseException;
import com.qdfae.jdk.pdfconvertor.PdfProcessSupport;
import com.qdfae.jdk.support.ResponseCodeBase;
import com.qdfae.jdk.utils.BigDecimalUtil;
import com.qdfae.jdk.utils.DateUtil;

/**
 * Excel文件解析
 *
 * @author hongwei.lian
 * @date 2019年2月20日 下午7:11:30
 */
public class ReadExcelTest {
	
	/**
	 * 解析
	 *
	 * @throws IOException
	 * @author hongwei.lian
	 * @date 2019年2月20日 下午7:11:51
	 */
	@Test
	public void testReadExcel() throws IOException {
		File file = new File("C:\\Users\\Administrator\\Desktop\\6.1投资明细 4.2.xlsx");
		if (!file.exists()) {
			throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null, "文件不存在");
		}
		//读取文件
		List<BizimportTradeDetailVo> list = new ArrayList<>();
		List<String[]> resultList = PdfProcessSupport.readFirstSheetFromExcelFile(file);
		for (int i = 0; i < resultList.size(); i++) {
			String[] strArray = resultList.get(i);
			System.out.println("strArray" + strArray.length);
			BizimportTradeDetailVo vo = null;
			try {
				vo = assumUpTradeDetails(strArray, 57337, 1);
			} catch (Exception e) {
				throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null,"投资明细文件第"+(i+2)+"行格式错误，请检查后重新上传");
			}
			if(StringUtils.isNotBlank(vo.getProjectCode()) && !vo.getProjectCode().equals("6006245")) {
				throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null,"投资明细文件第"+(i+2)+"行挂牌代码错误，请检查后重新上传");
			}
			if(StringUtils.isNotBlank(vo.getProjectName()) && !vo.getProjectName().equals("罗平县兴城城建实业有限公司2019年债务融资计划")) {
				throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null,"投资明细文件第"+(i+2)+"行挂牌名称错误，请检查后重新上传");
			}
			if(vo.getIdType() == null) {
				throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null,"投资明细文件第"+(i+2)+"行证件类型错误，请检查后重新上传");
			}
			if((vo.getIdType() == CertificateTypeEnum.身份证 || vo.getIdType() == CertificateTypeEnum.临时身份证) && vo.getIdNumber().split(" ").length > 1) {
				throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null,"投资明细文件第"+(i+2)+"行身份证信息不能包含空格，请检查后重新上传");
			}
			list.add(vo);
		}
	}
	
	/**
	 * 组装投资结果明细
	 * @param string
	 * @return BizimportTransferDetailVo
	 * @author peng.liu
	 * 2016年12月12日 上午11:23:30
	 * @param exchangeId 
	 */
	private static BizimportTradeDetailVo assumUpTradeDetails(String[] dataSplit, int memberId, Integer exchangeId) {
		BizimportTradeDetailVo detail = new BizimportTradeDetailVo();
		detail.setApplyMemberId(memberId);
		if(dataSplit.length != 15) {
			System.out.println("===" + DateUtil.autoParseDate(dataSplit[0]));
			detail.setTradeTime(DateUtil.autoParseDate(dataSplit[0]));
			detail.setPeriodName(dataSplit[1]);
			detail.setPeriodCode(dataSplit[2]);
			detail.setTradeMoney(BigDecimalUtil.convertDefaultZero(dataSplit[3]));
			detail.setUserRealName(dataSplit[4]);
			detail.setIdType(getIdTypeDesc(dataSplit[5]));
			detail.setIdNumber(dataSplit[6]);
			detail.setPhoneNumber(dataSplit[7]);
			detail.setPartnerTradeSeq(dataSplit[8]);
			if(dataSplit.length >= 10) {
				detail.setProjectCode(dataSplit[9]);
				detail.setProjectName(dataSplit[10]);
			}
			if(dataSplit.length == 12) {
				detail.setUserName(StringUtils.isBlank(dataSplit[11])?null:dataSplit[11]);
			}
		}else {
			System.out.println("===" + DateUtil.autoParseDate(dataSplit[0]));
			detail.setTradeTime(DateUtil.autoParseDate(dataSplit[0]));//交易时间
			System.out.println("dataSplit[1]=" + dataSplit[1]);
			detail.setProjectCode(dataSplit[1]);//挂牌代码
			detail.setProjectName(dataSplit[2]);//挂牌名称
			detail.setTradeMoney(BigDecimalUtil.convertDefaultZero(dataSplit[3]));//投资金额
			detail.setUserRealName(dataSplit[4]);//客户姓名
			detail.setIdType(getIdTypeDesc(dataSplit[5]));//证件类型
			detail.setIdNumber(dataSplit[6]);//证件号码
			detail.setEvaluationScore(dataSplit[7]);
			detail.setEvaluationType(dataSplit[8]);
			detail.setEvaluationBeginDate(DateUtil.autoParseDate(dataSplit[9]));
			detail.setEvaluationEffect(dataSplit[10]);
			detail.setPhoneNumber(dataSplit[11]);//手机号
			detail.setCardAccount(dataSplit[12]);
			detail.setChannelName(dataSplit[13]);
			detail.setPartnerTradeSeq(dataSplit[14]);//合作方交易流水号
		}
		detail.setExchangeId(exchangeId);
		if(StringUtils.isBlank(detail.getIdNumber()) || detail.getIdNumber().indexOf('.') >= 0 
				|| StringUtils.isBlank(detail.getUserRealName())
				|| detail.getTradeMoney().compareTo(BigDecimal.ZERO) <= 0
				|| Objects.isNull(detail.getTradeTime())) {
			throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null);
		}
		if(StringUtils.isBlank(detail.getPartnerTradeSeq()))
			detail.setPartnerTradeSeq(null);
		return detail;
	}
	
	/**
	 * 获取证件类型Id
	 * 
	 * @param key
	 * @return Integer
	 * @author zhiya.chai
	 * 2016年12月14日 下午3:21:49
	 */
	private static CertificateTypeEnum getIdTypeDesc(String key) {
		CertificateTypeEnum certificateType = CertificateTypeEnum.fromCertificateTypeName(key);
		if(certificateType != null) {
			return certificateType;
		}
		try {
			int type = Integer.valueOf(key);
			certificateType = CertificateTypeEnum.fromValue(type);
			if(certificateType != null) {
				return certificateType;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

}
