package com.ccut.chiao.dao.individual;

import com.ccut.chiao.entity.Individual;

import java.util.List;

/**
 * @author Chiao
 */
public interface IndividualMapper {
	int insertIndividual(Individual individual);

	int updateIndividual(Individual individual);

	int closeIndividual(String accNum);

	Individual findByAccNum(String accNum);

	List<Individual> getIndividualList();

	int findTotalCount();

	List<Individual> getIndividualByAccNumOrPapNo(String accName);

	Individual getIndividual(String accNum);
}
