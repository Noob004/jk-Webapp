package cn.ywt.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.ywt.jk.dao.FactoryDao;
import cn.ywt.jk.domain.Factory;

@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao {
	//利用默认构造方法初始化命名空间
	public FactoryDaoImpl() {
		super.setNs("cn.ywt.jk.mapper.FactoryMapper");
	}

	//修改状态
	@Override
	public void updateState(Map<String, Object> map) {
		super.getSqlSession().update(this.getNs() + ".updateState",map);
	}
}
