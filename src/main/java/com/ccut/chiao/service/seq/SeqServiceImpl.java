package com.ccut.chiao.service.seq;

import com.ccut.chiao.dao.seq.SeqMapper;
import com.ccut.chiao.entity.Seq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Chiao
 */
@Service
public class SeqServiceImpl implements SeqService {
	@Resource
	private SeqMapper seqMapper;


	@Override
	public List<Seq> getSeqList() {
		return seqMapper.getSeqList();
	}
}
