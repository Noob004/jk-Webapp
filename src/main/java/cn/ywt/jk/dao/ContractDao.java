package cn.ywt.jk.dao;

import java.util.Map;

import cn.ywt.jk.domain.Contract;

public interface ContractDao extends BaseDao<Contract> {
	public void updateState(Map<String, Object> map);
}
