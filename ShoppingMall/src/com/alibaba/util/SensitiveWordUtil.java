package com.alibaba.util;

import java.util.List;
import com.alibaba.entity.SensitiveWord;

public class SensitiveWordUtil {

	public static List<SensitiveWord> words;

	public static List<SensitiveWord> getWords() {
		return words;
	}

	public static void setWords(List<SensitiveWord> words) {
		SensitiveWordUtil.words = words;
	}

}
