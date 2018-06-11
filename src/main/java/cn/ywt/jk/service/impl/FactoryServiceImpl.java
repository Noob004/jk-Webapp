package cn.ywt.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ywt.jk.dao.FactoryDao;
import cn.ywt.jk.domain.Factory;
import cn.ywt.jk.pagination.Page;
import cn.ywt.jk.service.FactoryService;

@Service
public class FactoryServiceImpl implements FactoryService {
	@Resource
	FactoryDao factoryDao;

	@Override
	public List<Factory> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factory> find(Map paraMap) {
		return factoryDao.find(paraMap);
	}

	@Override
	public Factory get(Serializable id) {
		return factoryDao.get(id);
	}

	@Override
	public void insert(Factory entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setState("1");    //0停用1启用
		factoryDao.insert(entity);
	}

	@Override
	public void update(Factory entity) {
		factoryDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		factoryDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		factoryDao.delete(ids);
	}

	@Override
	public void start(String[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state",1);			//1 启用
		map.put("ids", ids);
		factoryDao.updateState(map);
	}

	@Override
	public void stop(String[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state",0);			//0 停用
		map.put("ids", ids);
		factoryDao.updateState(map);
	}



}
