package com.sns.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component // 일반적인 spring bean 
public class FileManagerService {
	// 실제 업로드 된 이미지가 저장될 경로(서버)
	public static final String FILE_UPLOAD_PATH = "D:\\신보람\\6_spring_project\\sns\\workspace\\images/";
	
	// input:MultipartFile(이미지파일), loginId   
	// output:image path(String)
	public String saveFile(String loginId, MultipartFile file) {
		// 파일 디렉토리(폴더)  예) aaaa_1678694564/sun.png
		String directoryName = loginId + "_" + System.currentTimeMillis() + "/"; //  "aaaa_1678694564/"
		String filePath = FILE_UPLOAD_PATH + directoryName; //  D:\\신보람\\6_spring_project\\memo\\workspace\\images/aaaa_1678694564/
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			return null; // 폴더 만드는데 실패 시 이미지경로 null
		}
		
		// 파일 업로드: byte 단위로 업로드
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename()); // 디렉토리명 + originalFileName은 사용자가 올린 파일명
			Files.write(path, bytes); // 파일 업로드
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		// 파일 업로드가 성공했으면 이미지 url path를 리턴한다.
		// http://localhost/images/aaaa_1678694564/sun.png
		return "/images/" + directoryName + file.getOriginalFilename(); // originalFileName은 사용자가 올린 파일명
	}
}
