package edu.pnu.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
//RestController는 html로 반환하는게 아니고 json같은걸로 응답할때.
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/board")
	public ResponseEntity<?> getBoard(){
		log.info("getBoard: All");
		return ResponseEntity.ok(boardService.getBoards());
	}
	//responseEntity는 HTTP 응답을 표현하는 객체임
	//응답본문으로 () 안의 내용을 설정하겠다는 것
	
	@GetMapping("/board/{id}")
	public ResponseEntity<?> getBoard(@PathVariable Long id){
		log.info("getBoard: " + id);
		return ResponseEntity.ok(boardService.getBoard(id));
	}
	
}
