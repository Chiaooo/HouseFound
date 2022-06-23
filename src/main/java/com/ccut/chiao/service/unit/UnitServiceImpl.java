package com.ccut.chiao.service.unit;

import com.ccut.chiao.dao.accNumControl.AccNumControlMapper;
import com.ccut.chiao.dao.unit.UnitMapper;
import com.ccut.chiao.entity.Unit;
import com.ccut.chiao.entity.UnitKind;
import com.ccut.chiao.entity.UnitType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author Chiao
 */
@Service
public class UnitServiceImpl implements UnitService {
	@Resource
	private UnitMapper unitMapper;
	@Resource
	private AccNumControlMapper accNumControlMapper;

	@Override
	public boolean insertUnit(Unit unit) {
		boolean flag = false;
		if (unitMapper.insertUnit(unit) > 0)
			flag = true;
		return flag;
	}

	@Override
	public boolean updateUnit(Unit unit) {
		boolean flag = false;
		if (unitMapper.updateUnit(unit) > 0)
			flag = true;
		return flag;
	}

	@Override
	public boolean closeUnit(String unitAccNum) {
		boolean flag = false;
		if (unitMapper.closeUnit(unitAccNum) > 0)
			flag = true;
		return flag;
	}

	@Override
	public int getUnitSeq() {
		return accNumControlMapper.findSeqByUnit();
	}

	@Override
	public int updateUnitSeq(int seq) {
		return accNumControlMapper.updateUnitSeq(seq);
	}

	@Override
	public Unit findByAccNum(String unitAccNum) {
		return unitMapper.findByAccNum(unitAccNum);
	}


	@Override
	public String getSeq() {
		int seq = getUnitSeq();
		if (seq > 0) {
			String accNum = String.format("%0" + 12 + "d", seq);
			return accNum;
		} else {
			return null;
		}
	}

	@Override
	public String getCurrentTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return simpleDateFormat.format(date);
	}

	@Override
	public List<Unit> getUnitList() {
		return unitMapper.getUnitList();
	}

	@Override
	public List<UnitType> getUnitTypeList() {
		return unitMapper.getUnitTypeList();
	}

	@Override
	public List<UnitKind> getUnitKindList() {
		return unitMapper.getUnitKindList();
	}

	@Override
	public int findTotalCount() {
		return unitMapper.findTotalCount();
	}

	@Override
	public List<Unit> getUnitByNameOrType(@Param("unitAccName") String unitAccName, @Param("unitChar") String unitChar) {
		return unitMapper.getUnitByNameOrType(unitAccName, unitChar);
	}

	@Override
	public List<Unit> getUnitByType(String unitChar) {
		return unitMapper.getUnitByType(unitChar);
	}

	@Override
	public List<Unit> getUnitByName(String unitAccName) {
		return unitMapper.getUnitByName(unitAccName);
	}

	@Override
	public Unit getUnit(String untiAccNum) {
		return unitMapper.getUnit(untiAccNum);
	}

	@Override
	public PageInfo findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Unit> unitList = unitMapper.getUnitList();
		PageInfo pageInfo = new PageInfo<>(unitList);
		return pageInfo;
	}

	@Override
	public PageInfo findPageByType(int pageNum, int pageSize, String unitChar) {
		PageHelper.startPage(pageNum, pageSize);
		List<Unit> unitList = unitMapper.getUnitByType(unitChar);
		PageInfo pageInfo = new PageInfo<>(unitList);
		return pageInfo;
	}

	@Override
	public PageInfo findPageByName(int pageNum, int pageSize, String unitAccName) {
		PageHelper.startPage(pageNum, pageSize);
		List<Unit> unitList = unitMapper.getUnitByName(unitAccName);
		PageInfo pageInfo = new PageInfo<>(unitList);
		return pageInfo;
	}

	@Override
	public PageInfo findPageByNameOrType(int pageNum, int pageSize, String unitAccName, String unitChar) {
		PageHelper.startPage(pageNum, pageSize);
		List<Unit> unitList = unitMapper.getUnitByNameOrType(unitAccName, unitChar);
		PageInfo pageInfo = new PageInfo<>(unitList);
		return pageInfo;
	}

}
