package com.dk.demo1.service;

import java.util.List;

import com.dk.demo1.EmailModel;
import org.springframework.stereotype.Service;

@Service
public interface BatchMailService {

	public void batchSendEmail(List<EmailModel> emails);
	
	public void batchSendReturnEmail(List<EmailModel> emails);
}