package com.qdfae.jdk.domain;

import com.qdfae.jdk.enums.EncodingType;
import com.qdfae.jdk.enums.PingAnApp;
import com.qdfae.jdk.support.ConfigProperties;

public class PacketMsgHelper {
	
public static final int msg_header_length = 222;//报文头部长度
	
	public static final String encoding = "GBK";
	
	public static final PacketHeadItem msg_version = new PacketHeadItem("A001", 4) ;//报文版本
	
	public static final PacketHeadItem target_app = new PacketHeadItem(PingAnApp.SYS_YQZL.getAppId(), 2);//目标系统
	
	public static final PacketHeadItem msg_encoding = new PacketHeadItem(EncodingType.GBK.getType(), 2);//报文编码
	
	public static final PacketHeadItem trans_protocol = new PacketHeadItem("", 2);//通讯协议
	
	public static final PacketHeadItem agencyNo = new PacketHeadItem(ConfigProperties.getProperty("qjs_pingan_agencyno", ""),20);//外联客户代码
	
	public static final PacketHeadItem packet_length = new PacketHeadItem("",10);//接收报文的长度
	
	public static final PacketHeadItem tradecode = new PacketHeadItem("",6);//交易码
	
	public static final PacketHeadItem operatorcode = new PacketHeadItem(ConfigProperties.getProperty("pingan_operatorcode", "00000"),5);//操作员代码
	
	public static final PacketHeadItem reqType = new PacketHeadItem("",2);//服务类型,01:请求 02：应答
	
	public static final PacketHeadItem tradedate = new PacketHeadItem("",8);//交易日期
	
	public static final PacketHeadItem tradetime = new PacketHeadItem("",6);//交易时间
	
	public static final PacketHeadItem serialno = new PacketHeadItem("",20);//交易流水号
	
	public static final PacketHeadItem retcode = new PacketHeadItem("",6);//返回码
	
	public static final PacketHeadItem retmsg = new PacketHeadItem("",100);//返回描述
	
	public static final PacketHeadItem hasMoreFlag = new PacketHeadItem("0",1);//后续包标志，0：结束包，1：还有后续包
	
	public static final PacketHeadItem reqcout = new PacketHeadItem("000",3);//请求次数 000（第1次）
	
	public static final PacketHeadItem signflag = new PacketHeadItem("0",1);//签名标识，0：不签名 1：签名 目前仅支持填0
	
	public static final PacketHeadItem sign_packet_flag = new PacketHeadItem("1",1);//签名数据包格式 0:裸签 1：PKCS7，目前仅支持1
	
	public static final PacketHeadItem sign_algri = new PacketHeadItem("",12);//签名算法，默认RSA-SHA1 
	
	public static final PacketHeadItem sign_length = new PacketHeadItem("0",10);//签名长度，目前仅支持写0
	
	public static final PacketHeadItem filenum = new PacketHeadItem("0",1);//附件数目

	/** 以下为附件报文的相关内容，只有附件数目大于0才会有以下内容*/
	
	public static final int file_header_length = 277;//报文头部长度
	
	public static final PacketHeadItem filename = new PacketHeadItem("",240);//文件名称
	
	public static final PacketHeadItem file_encoding = new PacketHeadItem(EncodingType.GBK.getType(), 2);//文件内容编码
	
	public static final PacketHeadItem obtain_file_type = new PacketHeadItem("0", 1);//获取文件的方式
	
	public static final PacketHeadItem file_sign = new PacketHeadItem("", 1);//是否对文件进行签名
	
	public static final PacketHeadItem file_sign_type = new PacketHeadItem("", 1);//签名数据包格式
	
	public static final PacketHeadItem hash_sign = new PacketHeadItem("", 12);//哈希签名算法
	
	public static final PacketHeadItem file_sign_length = new PacketHeadItem("0000000000", 10);//签名内容长度
	
	public static final PacketHeadItem file_content_length = new PacketHeadItem("", 10);//文件内容长度

	
	/**
	 * 获取返回码的索引
	 * @return
	 * @author qiang.wen
	 * @date 2017年9月27日 下午2:55:43
	 */
	public static int getRetcodeIndex() {
		return msg_version.length + target_app.length + msg_encoding.length + trans_protocol.length + agencyNo.length
				+ packet_length.length + tradecode.length + operatorcode.length + reqType.length + tradedate.length
				+ tradetime.length + serialno.length ;
	}
	
	/**
	 * 获取报文长度的索引
	 * @return
	 * @author qiang.wen
	 * @date 2017年12月5日 下午1:38:33
	 */
	public static int getPacketIndex(){
		return msg_version.length + target_app.length + msg_encoding.length 
					+ trans_protocol.length + agencyNo.length;
	}

}
