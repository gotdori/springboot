package com.kosa.myapp.board.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kosa.myapp.board.domain.BoardDto;
import com.kosa.myapp.board.service.BoardService;

@CrossOrigin("*")
@RestController
public class BoardController {

	// application.properties로부터 값을 읽어와야 한다.
	@Value("${fileUploadPath}")
	String fileUploadPath = "";

	@Value("${domain}")
	String domain = "";

	@Resource(name = "boardService")
	BoardService service;

	@RequestMapping("/board/list/{pg}")
	public HashMap<String, Object> board_getList(@PathVariable("pg") int pg, BoardDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		dto.setPg(pg - 1);
		map.put("result", "success");
		map.put("totalCnt", service.getTotalCnt(dto));
		map.put("list", service.getList(dto));

		return map;
	}

	@RequestMapping("/board/insert")
	public HashMap<String, Object> board_insert(BoardDto dto, MultipartFile file) {
		String filename = file.getOriginalFilename();
		try {
			Path uploadPath = Paths.get(fileUploadPath);
			Path filePath = uploadPath.resolve(filename);
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setFilename(filename);
		dto.setImage_url(domain+"/"+fileUploadPath+"/"+filename);
		service.insert(dto);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");

		return map;
	}

	@GetMapping("/board/view/{seq}")
	public BoardDto getview(@PathVariable("seq") int seq, BoardDto dto) {
		return service.getView(dto);
	}
}
