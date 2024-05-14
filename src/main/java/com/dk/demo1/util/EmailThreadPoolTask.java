package com.dk.demo1.util;

import java.util.concurrent.Callable;

import com.dk.demo1.service.MailService;
import org.slf4j.LoggerFactory;


/**
 *
 * @author zhangyuxuan 2019年7月23日
 */

public class EmailThreadPoolTask implements Callable<Boolean> {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmailNoticeThreadPoolTask.class);
	private MailService mailService;
	private String email;
	private String content;
	private String subject;
	private String filePath;

  /**
   * @param mailService
   * @param email
   * @param content
   * @param subject
   * @param part
   */
  public EmailThreadPoolTask(MailService mailService, String email, String subject, String content, String filePath) {
    this.mailService = mailService;
    this.email = email;
    this.content = content;
    this.subject = subject;
    this.filePath = filePath;
  }

  @Override
  public Boolean call() throws Exception {
	logger.info("call开始");
    boolean status = mailService.sendSimpleMail(email, subject, content);
    logger.info("call结束");
//    		mailService.sendAttachmentMail(email, subject, content, filePath);
    return status;
  }

}