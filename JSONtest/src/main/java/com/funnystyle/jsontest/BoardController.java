package com.funnystyle.jsontest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardController {

    @RequestMapping(value = "/board", method = RequestMethod.GET)
	public String list(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
    	if (page == null) {
    		page = 1;
    	}
    	
	    List<Board> result = new ArrayList<Board>();
	    List<Board> data = new ArrayList<Board>();
	    
	    int totalRow = 301;
	    int pageSize = 10;
	    
	    /* mock data */
	    for(int i = 0; i < totalRow; i++) {
	    	Board board = new Board();
	    	board.setBoard("name" + i, "title" + i);
	    	result.add(board);
	    }
	    
	    page = Math.min(Math.max(page, 1), (totalRow - 1) / pageSize + 1);
	    
	    int firstIndex = (page - 1) * pageSize; 
	    int lastIndex = page * pageSize < totalRow ? page * pageSize : totalRow;
	    if (firstIndex >= 0 && firstIndex <= lastIndex) {
	    	data = result.subList(firstIndex, lastIndex);
	    }
	    
	    model.addAttribute("data", data);
	    model.addAttribute("page", new Page(totalRow, page));
	    return "board/list";
    }
    
    @RequestMapping(value = "/board/page/{currentPage}", method = RequestMethod.GET)
	public void getPage(@PathVariable Integer currentPage, Model model) {
    	model.addAttribute("page", new Page(301, currentPage));
    }
	    
    @RequestMapping(method = RequestMethod.GET, value = "/board/{id}")
    public String view(@PathVariable String id) {
	    return "board/view";
    }
    
//    @RequestMapping(method = RequestMethod.GET, value = "/board/{id}.json")
//    public ResponseEntity<Board> viewJson(@PathVariable String id) {
//	    Board board = new Board();
//	    board.setBoard("kim", "test1");
//	    
//        if (id.equals("1")) {
//            return new ResponseEntity<Board>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<Board>(board, HttpStatus.OK);
//    }
    
	@RequestMapping("/board/form")
	public void form(Model model, RedirectAttributes attr){
	    if (!model.containsAttribute("board")) {
	        model.addAttribute("board", new Board());
	    }
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.POST)
	public String create(@Valid Board board, BindingResult result, SessionStatus status, RedirectAttributes attr){
		if(result.hasErrors()) {
		    attr.addFlashAttribute("org.springframework.validation.BindingResult.board", result);
		    attr.addFlashAttribute("board", board);			
			return "redirect:/board/form";
		}
		int id = 2;
		board.setId(id);
		status.setComplete();
		return "redirect:/board/" + id;
	}   
}
