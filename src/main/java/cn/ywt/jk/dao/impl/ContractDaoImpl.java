package cn.ywt.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.ywt.jk.dao.ContractDao;
import cn.ywt.jk.domain.Contract;

@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {
	// 利用默认构造方法初始化命名空间
	public ContractDaoImpl() {
		super.setNs("cn.ywt.jk.mapper.ContractMapper");
	}

	// 修改状态
	@Override
	public void updateState(Map<String, Object> map) {
		super.getSqlSession().update(this.getNs() + ".updateState", map);
	}
}
