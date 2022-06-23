package com.ccut.chiao.controller;

import com.ccut.chiao.entity.Individual;
import com.ccut.chiao.entity.Unit;
import com.ccut.chiao.service.individual.IndividualService;
import com.ccut.chiao.service.unit.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Chiao
 */
@Controller
public class WelcomeController {
	@Resource
	private UnitService unitService;

	public int getUnitCount() {
		List<Unit> unitList = unitService.getUnitList();
		return unitList.size();
	}

	@Resource
	private IndividualService individualService;

	public int getIndividualCount() {
		List<Individual> individualList = individualService.getIndividualList();
		return individualList.size();
	}

	@RequestMapping("welcome")
	public String welcome(HttpSession session, Model model) {

		model.addAttribute("unitCount", getUnitCount());
		model.addAttribute("individualCount", getIndividualCount());
		return "welcome";
	}

}
