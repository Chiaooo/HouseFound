package com.ccut.chiao.service.individual;

import com.ccut.chiao.dao.accNumControl.AccNumControlMapper;
import com.ccut.chiao.dao.individual.IndividualMapper;
import com.ccut.chiao.entity.Individual;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author Chiao
 */
@Service
public class IndividualServiceImpl implements IndividualService {
	@Resource
	private IndividualMapper individualMapper;
	@Resource
	private AccNumControlMapper accNumControlMapper;


	@Override
	public boolean insertIndividual(Individual individual) {
		boolean flag = false;
		if (individualMapper.insertIndividual(individual) > 0)
			flag = true;
		return flag;
	}

	@Override
	public boolean updateIndividual(Individual individual) {
		boolean flag = false;
		if (individualMapper.updateIndividual(individual) > 0)
			flag = true;
		return flag;
	}

	@Override
	public boolean closeIndividual(String accNum) {
		boolean flag = false;
		if (individualMapper.closeIndividual(accNum) > 0)
			flag = true;
		return flag;
	}

	@Override
	public int getIndividualSeq() {
		return accNumControlMapper.findSeqByPerson();
	}

	@Override
	public int updateIndividualSeq(int seq) {
		return accNumControlMapper.updatePersonSeq(seq);
	}

	@Override
	public Individual findByAccNum(String accNum) {
		return individualMapper.findByAccNum(accNum);
	}

	@Override
	public String getSeq() {
		int seq = getIndividualSeq();
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
	public List<Individual> getIndividualList() {
		return individualMapper.getIndividualList();
	}

	@Override
	public List<Individual> getIndividualByAccNumOrPapNo(String accName) {
		return individualMapper.getIndividualByAccNumOrPapNo(accName);
	}

	@Override
	public PageInfo findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Individual> individualList = individualMapper.getIndividualList();
		PageInfo pageInfo = new PageInfo<>(individualList);
		return pageInfo;
	}

	@Override
	public int getIndividualCount() {
		return individualMapper.findTotalCount();
	}

	@Override
	public Individual getIndividual(String accNum) {
		return individualMapper.getIndividual(accNum);
	}

	@Override
	public PageInfo getPageByAccNumOrPapNo(int pageNum, int pageSize, String accName) {
		PageHelper.startPage(pageNum, pageSize);
		List<Individual> individualList = individualMapper.getIndividualByAccNumOrPapNo(accName);
		PageInfo pageInfo = new PageInfo<>(individualList);
		return pageInfo;
	}
}
