package com.ccut.chiao.controller;

import com.ccut.chiao.entity.Individual;
import com.ccut.chiao.entity.Unit;
import com.ccut.chiao.service.individual.IndividualService;
import com.ccut.chiao.service.unit.UnitService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;


/**
 * @author Chiao
 */
@Controller
public class IndividualController {
	@Resource
	private IndividualService individualService;
	@Resource
	private UnitService unitService;

	@RequestMapping("/individualList.html")
	public String getIndividualList(Model model, HttpSession session, HttpServletRequest request) {
		int pageNum = 1;
		String cp = request.getParameter("pageNum");
		if (cp != null) {
			pageNum = Integer.parseInt(cp);
		}
		PageInfo pageInfo = individualService.findPage(pageNum, 10);
		model.addAttribute("pageInfo", pageInfo);
		List<Individual> individualList = individualService.getIndividualList();
		model.addAttribute("individualList", individualList);
		return "individual";
	}

	@RequestMapping("/delIndividual/{individual.accNum}")
	public String deleteIndividual(@PathVariable("individual.accNum") String accNum) {
		individualService.closeIndividual(accNum);
		return "redirect:/individualList.html";
	}

	@RequestMapping("/toUpdateIndividualPage/{individual.accNum}")
	public String toUpdate(Model model, @PathVariable("individual.accNum") String accNum) {
		model.addAttribute("accNum", accNum);
		Individual individual = individualService.findByAccNum(accNum);
		model.addAttribute("individual", individual);
		return "updateIndividual";
	}

	@RequestMapping("/updateIndividual")
	public String updateIndividual(Model model, Individual individual) {
		individualService.updateIndividual(individual);
		return "redirect:/individualList.html";
	}

	@RequestMapping("/queryUnit")
	public String queryUnitAccNum(HttpSession session, HttpServletRequest request, Model model) {
		String unitAccNum = request.getParameter("unitAccNum");
		String referer = request.getHeader("referer");
		String redirectUri = "uploadIndividual";
		if (referer != null) {
			if (referer.contains("/uploadIndividual")) {
				redirectUri = "uploadIndividual";
			}
		}
		Unit unit = unitService.findByAccNum(unitAccNum);
		model.addAttribute("unit", unit);
		return redirectUri;
	}

	@RequestMapping("/uploadIndividual")
	public String uploadUnit(HttpServletRequest request, HttpSession session, Model model) throws InvocationTargetException, IllegalAccessException {
		Map<String, String[]> map = request.getParameterMap();
		Individual individual = new Individual();
		Unit unit = (Unit) model.getAttribute("unit");
		String seq = individualService.getSeq();
		if (seq == null) {
			out.print("alert('开户失败')");
			return "redirect:/individualList.html";
		}
		BeanUtils.populate(individual, map);
		String unitAccNum = request.getParameter("unitAccNum");
		individual.setUnitAccNum(unitAccNum);
		individual.setAccNum(seq);
		individual.setOpenDate(individualService.getCurrentTime());

		Double unitProp = Double.valueOf(request.getParameter("unitProp"));
		Double perProp = Double.valueOf(request.getParameter("perProp"));
		Double baseNumber = Double.valueOf(request.getParameter("baseNumber"));

		individual.setUnitProp(unitProp);
		individual.setPerProp(perProp);

		individual.setUnitMonPaySum(baseNumber * unitProp);
		individual.setPerMonPaySum(baseNumber * perProp);

		boolean flag = individualService.insertIndividual(individual);
		if (flag) {
			if (individualService.updateIndividualSeq(Integer.parseInt(seq)) > 0) {
				out.print("alert('开户成功')");
				return "redirect:/individualList.html";
			}
		} else {
			out.print("alert('开户失败')");
			return "redirect:/individualList.html";
		}
		return "redirect:/individualList.html";
	}

	@RequestMapping("/getIndividual")
	public String getIndividual(Model model, String accName, HttpSession session, HttpServletRequest request) {
		int pageNum = 1;
		String cp = request.getParameter("pageNum");
		if (cp != null) {
			pageNum = Integer.parseInt(cp);
		}
		PageInfo pageInfo = individualService.getPageByAccNumOrPapNo(pageNum, 10, accName);
		model.addAttribute("pageInfo", pageInfo);
		List<Individual> individualList = individualService.getIndividualByAccNumOrPapNo(accName);
		model.addAttribute("individualList", individualList);
		return "individual";
	}
}
