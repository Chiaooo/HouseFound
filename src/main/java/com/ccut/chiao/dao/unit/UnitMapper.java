package com.ccut.chiao.dao.unit;

import com.ccut.chiao.entity.Unit;
import com.ccut.chiao.entity.UnitKind;
import com.ccut.chiao.entity.UnitType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Chiao
 */
public interface UnitMapper {
	int insertUnit(Unit unit);

	int updateUnit(Unit unit);

	int closeUnit(String unitAccNum);


	Unit findByAccNum(String unitAccNum);

	List<Unit> getUnitList();

	int findTotalCount();

	List<UnitType> getUnitTypeList();

	List<Unit> getUnitByNameOrType();

	List<Unit> getUnitByNameOrType(@Param("unitAccName") String unitAccName, @Param("unitChar") String unitChar);

	List<Unit> getUnitByType(String unitChar);

	List<Unit> getUnitByName(String unitAccName);

	Unit getUnit(String untiAccNum);

	List<UnitKind> getUnitKindList();
}
