package com.tommyqu.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TQBUtilities {

	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}
}
