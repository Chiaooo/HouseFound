package com.ccut.chiao.entity;


/**
 * @author Chiao
 */
public class AccNumControl {
	private String seqName;
	private int seq;
	private int maxSeq;
	private String desc;
	private String freeUse;

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getMaxSeq() {
		return maxSeq;
	}

	public void setMaxSeq(int maxSeq) {
		this.maxSeq = maxSeq;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFreeUse() {
		return freeUse;
	}

	public void setFreeUse(String freeUse) {
		this.freeUse = freeUse;
	}
}
