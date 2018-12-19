package com.qdfae.jdk.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;

/**
 * 时间日期转换工具类
 *
 * @author hongwei.lian
 * @date 2018年7月20日 下午7:10:37
 */
public final class DateTimeUtil {

	/**
	 * 获取系统设置的默认时区
	 */
	private static final ZoneId ZONEID = ZoneId.systemDefault();
	
	/**
	 * 日期时间格式化缓存
	 */
	private static final ConcurrentMap<String, DateTimeFormatter> FORMATTER_CACHE = 
			new ConcurrentHashMap<>();

	/**
	 * 日期时间格式化字符串缓存大小
	 */
    private static final int PATTERN_CACHE_SIZE = 500;

	/**
	 * 不允许创建工具类实例
	 */
	private DateTimeUtil() {}

	/**
	 * java.util.Date转换为java.time.LocalDate
	 *
	 * @param date
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月20日 下午7:13:21
	 */
	public static LocalDate toLocalDate(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZONEID).toLocalDate();
	}

	/**
	 * java.time.LocalDate转换为java.util.Date
	 *
	 * @param localDate
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月20日 下午7:21:43
	 */
	public static Date toDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZONEID).toInstant());
	}

	/**
	 * 两个日期之间相差的年数
	 *
	 * @param startDateInclusive
	 * @param endDateExclusive
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月24日 上午9:54:22
	 */
	public static int betweenYearsOfTwoLocalDate(LocalDate startDateInclusive, LocalDate endDateExclusive) {
		return Period.between(startDateInclusive, endDateExclusive).getYears();
	}

	/**
	 * 两个日期之间相差的月数
	 *
	 * @param startDateInclusive
	 * @param endDateExclusive
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月24日 上午9:54:27
	 */
	public static int betweenMonthsOfTwoLocalDate(LocalDate startDateInclusive, LocalDate endDateExclusive) {
		return Period.between(startDateInclusive, endDateExclusive).getMonths();
	}

	/**
	 * 两个日期之间相差的天数
	 *
	 * @param startDateInclusive
	 * @param endDateExclusive
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月24日 上午9:54:31
	 */
	public static int betweenDaysOfTwoLocalDate(LocalDate startDateInclusive, LocalDate endDateExclusive) {
		return Period.between(startDateInclusive, endDateExclusive).getDays();
	}

	/**
	 * 给指定日期增加天数
	 *
	 * @param localDate
	 * @param days
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月24日 上午10:27:10
	 */
	public static LocalDate addDays(LocalDate localDate, int days) {
		return plus(localDate, ChronoUnit.DAYS, days);
	}

	/**
	 * 给指定日期增加周数
	 *
	 * @param localDate
	 * @param weeks
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月24日 上午10:28:12
	 */
	public static LocalDate addWeeks(LocalDate localDate, int weeks) {
		return plus(localDate, ChronoUnit.WEEKS, weeks);
	}

	/**
	 * 给指定日期增加月数
	 *
	 * @param localDate
	 * @param months
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月24日 上午10:28:27
	 */
	public static LocalDate addMonths(LocalDate localDate, int months) {
		return plus(localDate, ChronoUnit.MONTHS, months);
	}

	/**
	 * 给指定日期增加年数
	 *
	 * @param localDate
	 * @param years
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月24日 上午10:28:38
	 */
	public static LocalDate addYears(LocalDate localDate, int years) {
		return plus(localDate, ChronoUnit.YEARS, years);
	}

	/**
	 * 获取指定日期所属月最大天数和指定天数的较小者
	 *
	 * @param localDate
	 * @param days
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月24日 下午12:06:50
	 */
	public static int getMinDays(LocalDate localDate, int days) {
		return days < localDate.lengthOfMonth() ? days : localDate.lengthOfMonth();
	}

	/**
	 * 使用指定天数设置指定日期
	 *
	 * @param localDate
	 * @param days
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月24日 下午12:07:57
	 */
	public static LocalDate setDays(LocalDate localDate, int days) {
		return LocalDate.of(localDate.getYear(), localDate.getMonth(), days);
	}

	/**
	 * 根据需求增加指定的日期
	 *
	 * @param localDate
	 * @param unit
	 * @param add
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月26日 下午4:48:04
	 */
	private static LocalDate plus(LocalDate localDate, TemporalUnit unit, int add) {
		return localDate.plus(add, unit);
	}
	
	/**
	 * 获取两个日期间隔的天数
	 *
	 * @param startDate 起始日期
	 * @param endDate 终止日期
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月12日 下午6:15:09
	 */
	public static int daysBetweenDate(Date startDate, Date endDate){
		 return Days.daysBetween(new org.joda.time.LocalDate(startDate), new org.joda.time.LocalDate(endDate))
				             .getDays();
	 }
	
	/**
	 * 获取两个日期间隔的月数
	 *
	 * @param startDate 起始日期
	 * @param endDate 终止日期
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月13日 下午4:58:17
	 */
	public static int monthsBetweenDate(Date startDate, Date endDate){
		 return Months.monthsBetween(new org.joda.time.LocalDate(startDate), new org.joda.time.LocalDate(endDate))
	                             .getMonths();
	 }
	
	/**
	 * 获取两个日期间隔的年数
	 *
	 * @param startDate 起始日期
	 * @param endDate 终止日期
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月13日 下午4:58:40
	 */
	public static int yearsBetweenDate(Date startDate, Date endDate){
		 return Years.yearsBetween(new org.joda.time.LocalDate(startDate), new org.joda.time.LocalDate(endDate))
				              .getYears();
	 }
	
	/**
	 * 将Date日期按照指定的格式显示
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月26日 下午4:48:04
	 */
	public static String formatDate(Date date, String pattern) {
		return toLocalDate(date).format(createCacheFormatter(pattern));
	}
	
	/**
	 * 将LocalDate日期按照指定的格式显示
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月26日 下午4:48:04
	 */
	public static String formatDate(LocalDate localDate, String pattern) {
		return localDate.format(createCacheFormatter(pattern));
	}
	
    /**
     * 将日期时间格式化字符串转换为Date
     *
     * @param time
     * @param pattern
     * @return
     * @author hongwei.lian
     * @date 2018年9月20日 下午2:36:57
     */
	public static Date parseDate(String time, String pattern){
        return Date.from(parseLocalDateTime(time, pattern).atZone(ZONEID).toInstant());
    }
	
	/**
	 * 将日期时间格式化字符串转换为LocalDate
	 *
	 * @param time
	 * @param pattern
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月20日 下午2:51:05
	 */
	public static LocalDate parseLocalDate(String time, String pattern){
        return parseLocalDateTime(time, pattern).toLocalDate();
    }
	
	/**
	 * 将日期时间格式化字符串转换为LocalDateTime
	 *
	 * @param time
	 * @param pattern
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月20日 下午2:34:50
	 */
	public static LocalDateTime parseLocalDateTime(String time, String pattern){
        DateTimeFormatter formatter = createCacheFormatter(pattern);
        return LocalDateTime.parse(time, formatter);
    }
	
	/**
	 * 创建日期时间格式化缓存
	 *
	 * @param pattern
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月20日 下午2:28:03
	 */
	private static DateTimeFormatter createCacheFormatter(String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            throw new IllegalArgumentException("Invalid pattern specification");
        }
        DateTimeFormatter formatter = FORMATTER_CACHE.get(pattern);
        if (Objects.isNull(formatter) && FORMATTER_CACHE.size() < PATTERN_CACHE_SIZE) {
        	//-- 创建日期时间格式化器
        	formatter = DateTimeFormatter.ofPattern(pattern);
            DateTimeFormatter oldFormatter = FORMATTER_CACHE.putIfAbsent(pattern, formatter);
            if (Objects.nonNull(oldFormatter)) {
                formatter = oldFormatter;
            }
        }
        return formatter;
    }
	
	/**
	 * 将日期按照指定的格式显示
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 * @author hongwei.lian
	 * @date 2018年7月26日 下午4:48:04
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (Objects.nonNull(pattern) && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 取出指定月天数较小者
	 *
	 * @param startDateInclusive
	 * @param month
	 * @param settleInvestDay
	 * @return 
	 * @author hongwei.lian
	 * @date 2018年12月6日 下午2:42:17
	 */
	public static int getMinDays(LocalDate startDateInclusive, Month month, int settleInvestDay) {
		int lengthOfMonth = month.length(startDateInclusive.isLeapYear());
		return settleInvestDay > lengthOfMonth ? lengthOfMonth : settleInvestDay;
	}

	/**
	 * 使用指定月数设置指定日期
	 *
	 * @param localDate
	 * @param months
	 * @return 
	 * @author hongwei.lian
	 * @date 2018年9月25日 下午6:07:52
	 */
	public static LocalDate setMonths(LocalDate localDate, int months) {
		return LocalDate.of(localDate.getYear(), months, localDate.getDayOfMonth());
	}
	
}
