package com.qdfae.jdk.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberUtil {

	public static String formatStr1 = "#,##0.00";
	public static String formatStr2 = "###0.00";
	public static String formatStr3 = "###0.00000000";
	private static final String[] cnNumbers = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

	/**
	 * 涉及小数位的保留小数位
	 */
	public static final int DECIMAL_DOTLENG2 = 2;
	
	/**
	 * 涉及金额保留小数位
	 */
	public static final int DECIMAL_AMOUNT_DOTLENG4 = 4;

	/**
	 * 保留 len 位小数
	 *
	 * @param bigDecimal
	 * @param len
	 * @return
	 */
	public static BigDecimal getScale(BigDecimal bigDecimal, int len) {
		if (bigDecimal == null) {
			return null;
		}
		else{
			return bigDecimal.setScale(len, BigDecimal.ROUND_DOWN);
		}
	}

	/**
	 * 显示保留四位的金额
	 *
	 * @param amount
	 * @return
	 */
	public static BigDecimal getResponseAmountScale(BigDecimal amount) {
		return getScale(amount, DECIMAL_AMOUNT_DOTLENG4);
	}

	/**
	 * 显示保留2位的金额
	 *
	 * @param amount
	 * @return
	 */
	public static BigDecimal getResponseAmountScale2M(BigDecimal amount) {
		return getScale(amount, DECIMAL_DOTLENG2);
	}

	/**
	 * 显示保留两位小数
	 *
	 * @param bigDecimal
	 * @return
	 */
	public static BigDecimal getResponseScale(BigDecimal bigDecimal) {
		return getScale(bigDecimal, DECIMAL_DOTLENG2);
	}

	public static String formatDouble(Double value) throws Exception {
		DecimalFormat decimalFormat = new DecimalFormat(formatStr3);// 格式化设置
		return decimalFormat.format(value);
	}

	/**
	 * 金额大写
	 * 
	 * @return String
	 * @author qiang.wen
	 * @date 016年11月14日 下午4:15:43
	 */
	public static String formatToChineseMoney(BigDecimal money) {
		double number = money.doubleValue();
		if (number > 99999999999999.99 || number < -99999999999999.99){
			throw new IllegalArgumentException("参数值超出允许范围 (-99999999999999.99 ～ 99999999999999.99)！");
		}
		
		boolean negative = false;// 正负标号
		if (number < 0) {
			negative = true;
			number = number * (-1);
		}
		
		long temp = Math.round(number * 100);
		
		int numFen = (int) (temp % 10);// 分
		temp = temp / 10;
		int numJiao = (int) (temp % 10);// 角
		temp = temp / 10;
		// 此时temp只包含整数部分
		int[] parts = new int[20];// 将金额整数部分分为在0-9999之间数的各个部分
		int numParts = 0;// 记录把原来金额整数部分分割为几个部分
		for (int i = 0;; i++) {
			if (temp == 0){
				break;
			}
			
			int part = (int) (temp % 10000);
			parts[i] = part;
			temp = temp / 10000;
			numParts++;
		}
		
		boolean beforeWanIsZero = true;// 标志位，记录万的下一级是否为0
		String chineseString = "";
		for (int i = 0; i < numParts; i++) {
			String partChinese = partConvert(parts[i]);
			if (i % 2 == 0) {
				if ("".equals(partChinese))
					beforeWanIsZero = true;
				else
					beforeWanIsZero = false;
			}
			
			if (i != 0) {
				if (i % 2 == 0) {// 亿的部分
					chineseString = "亿" + chineseString;
				} else {
					if ("".equals(partChinese)) {
						if (!beforeWanIsZero) {
							chineseString = "零" + chineseString; // 如果“万”对应的 part 为 0，而“万”下面一级不为 0，则不加“万”，而加“零”
						}
					} else {
						if (parts[i - 1] < 1000 && parts[i - 1] > 0) {
							chineseString = "零" + chineseString;// 如果万的部分不为0，而万前面的部分小于1000大于0，则万后面应该跟零
						}
						chineseString = "万" + chineseString;
					}
				}
			}
			
			chineseString = partChinese + chineseString;
		}
		
		if ("".equals(chineseString)) {// 整数部分为0，则表示为零元
			chineseString = cnNumbers[0];
		}
		else if (negative) {// 整数部分部位0，但是为负数
			chineseString = "负" + chineseString;
		}
		
		chineseString = chineseString + "元";
		if (numFen == 0 && numJiao == 0) {
			chineseString = chineseString + "整";
		} else if (numFen == 0) {// 0分
			chineseString = chineseString + cnNumbers[numJiao] + "角";
		} else {
			if (numJiao == 0){
				chineseString = chineseString + "零" + cnNumbers[numFen] + "分";
			}
			else{
				chineseString = chineseString + cnNumbers[numJiao] + "角" + cnNumbers[numFen] + "分";
			}
		}
		
		return chineseString;
	}

	// 转换拆分后的每个部分，0-9999之间
	private static String partConvert(int partNum) {
		if (partNum < 0 || partNum > 10000) {
			throw new IllegalArgumentException("参数必须是大于等于0或小于10000的整数");
		}
		
		String[] units = new String[] { "", "拾", "佰", "仟" };
		
		int temp = partNum;
		String partResult = new Integer(partNum).toString();
		
		int partResultLength = partResult.length();
		boolean lastIsZero = true;// 记录上一位是否为0
		
		String chineseString = "";
		for (int i = 0; i < partResultLength; i++) {
			if (temp == 0) {// 高位无数字
				break;
			}
			
			int digit = temp % 10;
			if (digit == 0) {
				if (!lastIsZero){// 如果前一个数字不是0则在当前汉字串前加零
					chineseString = "零" + chineseString;
				}
				
				lastIsZero = true;
			} else {
				chineseString = cnNumbers[digit] + units[i] + chineseString;
				lastIsZero = false;
			}
			
			temp = temp / 10;
		}
		
		return chineseString;
	}

	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal("123123.1299999");
		System.out.println("11----------->>" + bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
		System.out.println("22----------->>" + bigDecimal.setScale(2, BigDecimal.ROUND_DOWN));
		System.out.println("33----------->>" + bigDecimal.setScale(2, BigDecimal.ROUND_FLOOR));
		System.out.println("44----------->>" + bigDecimal.setScale(2, BigDecimal.ROUND_UP));
	}

}
