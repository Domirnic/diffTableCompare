package com.example.difftablecompare.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;

public class CloseUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(CloseUtils.class);

	public static void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (Exception e) {
				LOGGER.error("关闭错误", e);
			}
		}
	}

	public static void close(Closeable... closeables) {
		for (Closeable closeable : closeables) {
			close(closeable);
		}
	}

	public static void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable closeable : autoCloseables) {
			close(closeable);
		}
	}

	public static void close(AutoCloseable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (Exception e) {
				LOGGER.error("关闭错误", e);
			}
		}
	}

}
