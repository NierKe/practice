package com.dk.demo1.controller;

import java.util.List;

import com.dk.demo1.EmailModel;
import com.dk.demo1.service.BatchMailService;
import com.dk.demo1.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/mail")
public class MailController {

	@Autowired
	private MailService mailService;

	@Autowired
	private BatchMailService batchMailService;

	@RequestMapping(value="/simple")
	@ResponseBody
	public void sendMail() {
		mailService.sendSimpleMail("15735170558@163.com", "test", "我是一封测试邮件");
	}

	@RequestMapping(value="/attach", method = RequestMethod.POST)
	@ResponseBody
	public void sendAttachMail(List<EmailModel> emailModels) {
		mailService.sendSimpleMail("15735170558@163.com", "test", "我是一封测试邮件");
	}
	
	@RequestMapping(value="/batch", method = RequestMethod.POST)
	@ResponseBody
	public void batchSendMail(@RequestBody List<EmailModel> emails) {
		batchMailService.batchSendEmail(emails);
	}
	
	@RequestMapping(value="/batchReturn", method = RequestMethod.POST)
	@ResponseBody
	public void batchSendMailReturn(@RequestBody List<EmailModel> emails) {
		batchMailService.batchSendReturnEmail(emails);
	}
}