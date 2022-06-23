package com.ccut.chiao.controller;

import com.ccut.chiao.entity.Seq;
import com.ccut.chiao.service.seq.SeqService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author Chiao
 */
@Controller
public class SeqController {
	@Resource
	private SeqService seqService;

	@RequestMapping("/seqList.html")
	public String getSeqList(Model model, HttpSession session, HttpServletRequest request) {
		List<Seq> seqList = seqService.getSeqList();
		model.addAttribute("seqList", seqList);
		return "seq";
	}
}
