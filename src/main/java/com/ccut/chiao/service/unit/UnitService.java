package com.ccut.chiao.service.unit;

import com.ccut.chiao.entity.Unit;
import com.ccut.chiao.entity.UnitKind;
import com.ccut.chiao.entity.UnitType;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Chiao
 */
public interface UnitService {

	boolean insertUnit(Unit unit);

	boolean updateUnit(Unit unit);

	boolean closeUnit(String unitAccNum);

	int getUnitSeq();

	int updateUnitSeq(int seq);

	Unit findByAccNum(String unitAccNum);

	String getSeq();

	String getCurrentTime();

	List<Unit> getUnitList();

	List<UnitType> getUnitTypeList();

	List<UnitKind> getUnitKindList();

	int findTotalCount();

	List<Unit> getUnitByNameOrType(@Param("unitAccName") String unitAccName, @Param("unitChar") String unitChar);

	List<Unit> getUnitByType(String unitChar);

	List<Unit> getUnitByName(String unitAccName);

	Unit getUnit(String untiAccNum);

	PageInfo findPage(int pageNum, int pageSize);

	PageInfo findPageByType(int pageNum, int pageSize, String unitChar);

	PageInfo findPageByName(int pageNum, int pageSize, String unitAccName);

	PageInfo findPageByNameOrType(int pageNum, int pageSize, String unitAccName, String unitChar);
}
