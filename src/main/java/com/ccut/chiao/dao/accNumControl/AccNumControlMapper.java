package com.ccut.chiao.dao.accNumControl;

/**
 * @author Chiao
 */
public interface AccNumControlMapper {
	int findSeqByUnit();

	int findSeqByPerson();

	int updateUnitSeq(int seq);

	int updatePersonSeq(int seq);
}
