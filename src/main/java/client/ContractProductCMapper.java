package client;

import cn.itcast.mybatis.domain.ContractProductC;
import cn.itcast.mybatis.domain.ContractProductCExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.ywt.mybatis.domain.ContractProductC;
import cn.ywt.mybatis.domain.ContractProductCExample;

public interface ContractProductCMapper {
    int countByExample(ContractProductCExample example);

	int deleteByExample(ContractProductCExample example);

	int deleteByPrimaryKey(String contractProductId);

	int insert(ContractProductC record);

	int insertSelective(ContractProductC record);

	List<ContractProductC> selectByExample(ContractProductCExample example);

	ContractProductC selectByPrimaryKey(String contractProductId);

	int updateByExampleSelective(@Param("record") ContractProductC record,
			@Param("example") ContractProductCExample example);

	int updateByExample(@Param("record") ContractProductC record, @Param("example") ContractProductCExample example);

	int updateByPrimaryKeySelective(ContractProductC record);

	int updateByPrimaryKey(ContractProductC record);

	int countByExample(ContractProductCExample example);

    int deleteByExample(ContractProductCExample example);

    int deleteByPrimaryKey(String contractProductId);

    int insert(ContractProductC record);

    int insertSelective(ContractProductC record);

    List<ContractProductC> selectByExample(ContractProductCExample example);

    ContractProductC selectByPrimaryKey(String contractProductId);

    int updateByExampleSelective(@Param("record") ContractProductC record, @Param("example") ContractProductCExample example);

    int updateByExample(@Param("record") ContractProductC record, @Param("example") ContractProductCExample example);

    int updateByPrimaryKeySelective(ContractProductC record);

    int updateByPrimaryKey(ContractProductC record);
}