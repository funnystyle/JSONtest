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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) throws Exception {
    	if (page == null) {
    		page = 1;
    	}
    	
	    int totalRow = 301; // 총 갯수
	    int pageSize = 10;
	    
	    Page p = new Page(totalRow, page, pageSize);
	    
	    if (!p.isValidPage(page)) { // page not found
	    	throw new NotFoundException("page : " + page);
	    }
	    
	    List<Board> data = getBoardListMockData(p);
	    
	    model.addAttribute("data", data);
	    model.addAttribute("page", p);
	    return "board/list";
    }

	@RequestMapping(value = "/page/{currentPage}", method = RequestMethod.GET)
	public void getPage(@PathVariable Integer currentPage, Model model) {
    	model.addAttribute("page", new Page(301, currentPage));
    }
	    
    @RequestMapping(method = RequestMethod.GET, value = "/board/{id}")
    public String view(@PathVariable String id) {
	    return "board/view";
    }
    
	@RequestMapping("/form")
	public void form(Model model, RedirectAttributes attr){
	    if (!model.containsAttribute("board")) {
	        model.addAttribute("board", new Board());
	    }
	}
	
	@RequestMapping(method = RequestMethod.POST)
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

	private List<Board> getBoardListMockData(Page p) {
		List<Board> result = new ArrayList<Board>();
	    List<Board> data = new ArrayList<Board>();
	    
	    for(int i = 0; i < p.getTotalRow(); i++) {
	    	Board board = new Board();
	    	board.setBoard("name" + i, "title" + i);
	    	result.add(board);
	    }
	    
	    int firstRow = p.getFirstRow();
	    int lastRow = p.getLastRow();
	    
	    if (firstRow >= 0 && firstRow <= lastRow) {
	    	data = result.subList(firstRow, lastRow);
	    }
		return data;
	}
}
