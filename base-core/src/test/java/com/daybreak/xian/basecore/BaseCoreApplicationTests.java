package com.daybreak.xian.basecore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseCoreApplicationTests {

	@Test
	public void contextLoads() {
		/*try {
			System.out.println(getFirstAndLastOfWeek("2019-05-22", "yyyy-MM-dd", "yyyy-MM-dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		System.out.println(getFirstOfWeek(new Date()));
	}
	public static String getFirstAndLastOfWeek(String dataStr,String dateFormat,String resultDateFormat) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
		int d = 0;
		if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
			d = -6;
		} else {
			d = 2 - cal.get(Calendar.DAY_OF_WEEK);
		}
		cal.add(Calendar.DAY_OF_WEEK, d);
		// 所在周开始日期
		String data1 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		// 所在周结束日期
		String data2 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
		return data1 + "_" + data2;

	}
	/**
	 * 获取某周第一天
	 * @param dataStr
	 * @return
	 * @throws ParseException
	 */
	public static Date getFirstOfWeek(Date dataStr) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataStr);
		int d = 0;
		if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
			d = -6;
		} else {
			d = 2 - cal.get(Calendar.DAY_OF_WEEK);
		}
		cal.add(Calendar.DAY_OF_WEEK, d);
		// 所在周开始日期

		return cal.getTime();

	}

}
