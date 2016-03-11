package com.mtech.scheduler.core.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.mtech.scheduler.core.service.DubboFileService;
@Service
public class DubboFileServiceImpl implements DubboFileService {

	@Override
	public String addFile(InputStream source) {
		try {
			System.out.println("=============>>>"+source.available());
			File destDir = new File("D:/dubboFile");
			File file = new File(destDir, UUID.randomUUID().toString());
			FileUtils.copyInputStreamToFile(source, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

}
