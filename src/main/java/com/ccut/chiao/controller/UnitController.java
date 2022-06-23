package com.ccut.chiao.controller;

import com.ccut.chiao.entity.Unit;
import com.ccut.chiao.entity.UnitKind;
import com.ccut.chiao.entity.UnitType;
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
public class UnitController {
	@Resource
	private UnitService unitService;


	@RequestMapping("/unitList.html")
	public String getUnitList(Model model, HttpSession session, HttpServletRequest request) {
		int pageNum = 1;
		String cp = request.getParameter("pageNum");
		if (cp != null) {
			pageNum = Integer.parseInt(cp);
		}
		PageInfo pageInfo = unitService.findPage(pageNum, 10);
		model.addAttribute("pageInfo", pageInfo);
		List<Unit> unitList = unitService.getUnitList();
		List<UnitType> unitTypeList = unitService.getUnitTypeList();
		List<UnitKind> unitKindList = unitService.getUnitKindList();
		model.addAttribute("unitList", unitList);
		session.setAttribute("unitTypeList", unitTypeList);
		session.setAttribute("unitKindList", unitKindList);
		return "unit";
	}

	@RequestMapping("/getUnit")
	public String getUnit(Model model, String unitAccName, String unitChar, HttpSession session, HttpServletRequest request) {
		if ("".equals(unitAccName)) {
			List<UnitType> unitTypeList = unitService.getUnitTypeList();
			int pageNum = 1;
			String cp = request.getParameter("pageNum");
			if (cp != null) {
				pageNum = Integer.parseInt(cp);
			}
			PageInfo pageInfo = unitService.findPageByType(pageNum, 10, unitChar);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("unitChar", unitChar);
			List<Unit> unitList = unitService.getUnitByType(unitChar);
			model.addAttribute("unitList", unitList);
			session.setAttribute("unitTypeList", unitTypeList);
			return "unit";
		}
		if ("".equals(unitChar)) {
			List<UnitType> unitTypeList = unitService.getUnitTypeList();
			int pageNum = 1;
			String cp = request.getParameter("pageNum");
			if (cp != null) {
				pageNum = Integer.parseInt(cp);
			}
			PageInfo pageInfo = unitService.findPageByName(pageNum, 10, unitAccName);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("unitAccName", unitAccName);
			List<Unit> unitList = unitService.getUnitByName(unitAccName);
			model.addAttribute("unitList", unitList);
			session.setAttribute("unitTypeList", unitTypeList);
			return "unit";
		} else {
			List<UnitType> unitTypeList = unitService.getUnitTypeList();
			int pageNum = 1;
			String cp = request.getParameter("pageNum");
			if (cp != null) {
				pageNum = Integer.parseInt(cp);
			}
			PageInfo pageInfo = unitService.findPageByNameOrType(pageNum, 10, unitAccName, unitChar);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("unitAccName", unitAccName);
			model.addAttribute("unitChar", unitChar);
			List<Unit> unitList = unitService.getUnitByNameOrType(unitAccName, unitChar);
			model.addAttribute("unitList", unitList);
			session.setAttribute("unitTypeList", unitTypeList);
			return "unit";
		}
	}

	@RequestMapping("/delUnit/{unit.unitAccNum}")
	public String deleteUnit(@PathVariable("unit.unitAccNum") String unitAccNum) {
		unitService.closeUnit(unitAccNum);
		return "redirect:/unitList.html";
	}

	@RequestMapping("/toUpdateUnitPage/{unit.unitAccNum}")
	public String toUpdate(Model model, @PathVariable("unit.unitAccNum") String unitAccNum) {
		model.addAttribute("unitAccNum", unitAccNum);
		Unit unit = unitService.getUnit(unitAccNum);
		List<UnitKind> unitKind = unitService.getUnitKindList();
		model.addAttribute("unitKind", unitKind);
		model.addAttribute("unit", unit);
		return "updateUnit";
	}

	@RequestMapping("/updateUnit")
	public String updateUnit(Model model, Unit unit) {
		unitService.updateUnit(unit);
		return "redirect:/unitList.html";
	}

	@RequestMapping("/uploadUnit")
	public String uploadUnit(HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {
		Map<String, String[]> map = request.getParameterMap();
		Unit unit = new Unit();
		String seq = unitService.getSeq();
		if (seq == null) {
			out.print("alert('开户失败')");
			return "redirect:/unitList.html";
		}
		BeanUtils.populate(unit, map);
		unit.setCreateDate(unitService.getCurrentTime());
		unit.setUnitAccNum(seq);
		boolean flag = unitService.insertUnit(unit);
		if (flag) {
			if (unitService.updateUnitSeq(Integer.parseInt(seq)) > 0) {
				out.print("alert('开户成功')");
				return "redirect:/unitList.html";
			}
		} else {
			out.print("alert('开户失败')");
			return "redirect:/unitList.html";
		}
		return "redirect:/unitList.html";
	}
}
