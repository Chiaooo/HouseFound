package com.ccut.chiao.service.individual;

import com.ccut.chiao.entity.Individual;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Chiao
 */
public interface IndividualService {

	boolean insertIndividual(Individual individual);

	boolean updateIndividual(Individual individual);

	boolean closeIndividual(String accNum);

	int getIndividualSeq();

	int updateIndividualSeq(int seq);

	Individual findByAccNum(String accNum);

	String getSeq();

	String getCurrentTime();

	List<Individual> getIndividualList();

	List<Individual> getIndividualByAccNumOrPapNo(String accName);

	PageInfo findPage(int pageNum, int pageSize);

	int getIndividualCount();

	Individual getIndividual(String accNum);

	PageInfo getPageByAccNumOrPapNo(int pageNum, int pageSize, String accName);
}
