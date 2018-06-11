package cn.ywt.jk.dao;


import java.util.Map;

import cn.ywt.jk.domain.Factory;

public interface FactoryDao extends BaseDao<Factory> {
	public void updateState(Map<String,Object> map);
}
