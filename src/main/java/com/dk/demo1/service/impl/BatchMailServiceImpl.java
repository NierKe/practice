package com.dk.demo1.service.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.dk.demo1.service.BatchMailService;
import com.dk.demo1.service.MailService;
import com.dk.demo1.EmailModel;
import com.dk.demo1.util.EmailNoticeThreadPoolTask;
import com.dk.demo1.util.EmailThreadPoolTask;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class BatchMailServiceImpl implements BatchMailService {

	@Autowired
	private ThreadPoolTaskExecutor getAsyncExecutor;
	@Autowired
	private MailService mailService;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BatchMailServiceImpl.class);

	@Override
	public void batchSendReturnEmail(List<EmailModel> emails) {
		for (EmailModel emailModel : emails) {
			logger.info("向" + emailModel.getEmail() + "发送邮件开始");
			Future<Boolean> statusFuture = getAsyncExecutor.submit(new EmailThreadPoolTask(mailService, emailModel.getEmail(), emailModel.getSubject(), emailModel.getContent(), emailModel.getAttachFilePath()));
			// 根据返回值来进行判断下一步操作，注意，future中的get方法是一个阻塞的方法，会一直等到future返回结果才会结束
			try {
				boolean status = statusFuture.get();
				// 根据结果可以进行存入数据库等操作   这边暂时只做输出操作
				logger.info("状态：" + status);
				logger.info("向" + emailModel.getEmail() + "发送邮件结束");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void batchSendEmail(List<EmailModel> emails) {
		
		for (EmailModel emailModel : emails) {
			logger.info("核心线程数:" + getAsyncExecutor.getCorePoolSize());
			logger.info("最大线程数:" + getAsyncExecutor.getMaxPoolSize());
			logger.info("向" + emailModel.getEmail() + "发送邮件开始");
			try {

				getAsyncExecutor.execute(new EmailNoticeThreadPoolTask(mailService, emailModel.getEmail(), emailModel.getSubject(), emailModel.getContent(), emailModel.getAttachFilePath()));
				logger.info("向" + emailModel.getEmail() + "发送邮件结束");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}