package com.alex.spring.aop;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AppLogging {

	private static Logger log = Logger.getLogger(Listening.class);
	static {
		try {
			log.addAppender(new FileAppender(new PatternLayout(
					"%p %d{HH:mm:ss}: %m"), "sungsongs.log", true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Pointcut("execution(* com.alex.spring.beans.Instrumentalist.setSong(String)) && args(song)")
	public void logging(String song) {
		log.info("========IN LOGGING SONGS======");
	}

	@Before("logging(song)")
	public void sungSongs(String song) {
		System.out.println(song);
		log.info(song);
		log.info("END");
	}

}
