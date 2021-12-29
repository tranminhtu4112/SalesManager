package com.SalesManager.Utils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFile {

      @Autowired
	private StringUtils stringUtils;
	private Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

	public String getPathUploadFile(@RequestParam MultipartFile image, String pathConfig) throws IOException {
		Path staticPath = Paths.get("src/main/resources/static");
		String path = "DataImages/" + pathConfig;
        Path imagePath = Paths.get(path);
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
	        Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
	    }
		Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(image.getOriginalFilename());
	    try (OutputStream os = Files.newOutputStream(file)) {
	         os.write(image.getBytes());
	    }
	    String pathFile = imagePath.resolve(image.getOriginalFilename()).toString();
	    return "/" + stringUtils.convertPathImage(pathFile);
	}
}
