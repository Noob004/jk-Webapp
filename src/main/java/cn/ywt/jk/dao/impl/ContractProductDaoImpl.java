package cn.ywt.jk.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ywt.jk.dao.ContractProductDao;
import cn.ywt.jk.domain.ContractProduct;

@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao {
	// 利用默认构造方法初始化命名空间
	public ContractProductDaoImpl() {
		super.setNs("cn.ywt.jk.mapper.ContractProductMapper");
	}

}
