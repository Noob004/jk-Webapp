package cn.ywt.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ywt.jk.dao.ContractDao;
import cn.ywt.jk.domain.Contract;
import cn.ywt.jk.pagination.Page;
import cn.ywt.jk.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {
	@Resource
	ContractDao contractDao;

	@Override
	public List<Contract> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contract> find(Map paraMap) {
		return contractDao.find(paraMap);
	}

	@Override
	public Contract get(Serializable id) {
		return contractDao.get(id);
	}

	@Override
	public void insert(Contract entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setState(0); // 0草稿1上报
		contractDao.insert(entity);
	}

	@Override
	public void update(Contract entity) {
		contractDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		contractDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		contractDao.delete(ids);
	}

	@Override
	public void start(String[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 1); // 1 启用
		map.put("ids", ids);
		contractDao.updateState(map);
	}

	@Override
	public void stop(String[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 0); // 0 停用
		map.put("ids", ids);
		contractDao.updateState(map);
	}

}
