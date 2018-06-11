package cn.ywt.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ywt.jk.dao.ContractProductDao;
import cn.ywt.jk.dao.FactoryDao;
import cn.ywt.jk.domain.ContractProduct;
import cn.ywt.jk.domain.Factory;
import cn.ywt.jk.pagination.Page;
import cn.ywt.jk.service.ContractProductService;
import cn.ywt.util.Arith;

@Service
public class ContractProductServiceImpl implements ContractProductService {
	@Resource
	ContractProductDao contractProductDao;
	@Resource
	FactoryDao factoryDao;

	@Override
	public List<ContractProduct> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContractProduct> find(Map paraMap) {
		return contractProductDao.find(paraMap);
	}

	@Override
	public ContractProduct get(Serializable id) {
		return contractProductDao.get(id);
	}

	@Override
	public void insert(ContractProduct contractProduct) {
		contractProduct.setId(UUID.randomUUID().toString());
		// 计算浮点数 总金额=数量*单价
		Arith arith = new Arith();
		if (contractProduct.getCnumber() != null && contractProduct.getPrice() != null) {
			contractProduct.setAmount(new Double(
					arith.mul(contractProduct.getCnumber().doubleValue(), contractProduct.getPrice().doubleValue())));
		}

		contractProductDao.insert(contractProduct);
	}

	@Override
	public void update(ContractProduct contractProduct) {
		// 计算浮点数 总金额=数量*单价
		Arith arith = new Arith();
		if (contractProduct.getCnumber() != null && contractProduct.getPrice() != null) {
			contractProduct.setAmount(new Double(
					arith.mul(contractProduct.getCnumber().doubleValue(), contractProduct.getPrice().doubleValue())));
		}
		contractProductDao.update(contractProduct);
	}

	@Override
	public void deleteById(Serializable id) {
		contractProductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		contractProductDao.delete(ids);
	}

	// 获取生产厂家
	@Override
	public List<Factory> getFactoryList() {
		Map<String, Integer> paraMap = new HashMap<String, Integer>();
		paraMap.put("state", 1); // 1代表启用
		return factoryDao.find(paraMap);
	}
}
