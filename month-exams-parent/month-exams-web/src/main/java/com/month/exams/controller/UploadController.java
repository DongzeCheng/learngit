package com.month.exams.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.month.exams.common.oss.AliyunOSSClientUtils;

import entity.Result;

@RestController
public class UploadController {

	@RequestMapping("/upload")
	public Result upload(MultipartFile file){
		AliyunOSSClientUtils aliyunOSSClientUtils = new AliyunOSSClientUtils();
		String uploadImg2Oss;
		try {
			uploadImg2Oss = aliyunOSSClientUtils.uploadImg2Oss(file);
			String imgUrl = aliyunOSSClientUtils.getImgUrl(uploadImg2Oss);
			return new Result(true, imgUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false, "上传失败");
		}
	}
}
