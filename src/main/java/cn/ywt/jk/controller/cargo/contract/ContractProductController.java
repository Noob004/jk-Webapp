package cn.ywt.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ywt.jk.controller.BaseController;
import cn.ywt.jk.domain.ContractProduct;
import cn.ywt.jk.domain.Factory;
import cn.ywt.jk.service.ContractProductService;

@Controller
public class ContractProductController extends BaseController {
	@Resource
	ContractProductService contractProductService;

	// 转向新增页面
	@RequestMapping("/cargo/contractproduct/tocreate.action") // 从表
	public String tocreate(String contractId, Model model) {
		model.addAttribute("contractId", contractId); // 传递主表ID
		// 生产厂家
		List<Factory> factoryList = contractProductService.getFactoryList();
		model.addAttribute("factoryList", factoryList);

		// 列表信息，某个合同下的货物信息
		Map paraMap = new HashMap();
		paraMap.put("contractId", contractId);

		model.addAttribute("dataList", contractProductService.find(paraMap));

		return "/cargo/contract/jContractProductCreate.jsp";
	}

	// 新增保存
	@RequestMapping("/cargo/contractproduct/insert.action")
	public String insert(ContractProduct contractProduct) {
		contractProductService.insert(contractProduct);

		return "redirect:/cargo/contractproduct/tocreate.action"; // 批量新增
	}

	// 转向修改页面，回显数据
	@RequestMapping("/cargo/contractproduct/toupdate.action")
	public String toupdate(String id, Model model) {
		// String contractId,
		// model.addAttribute("contractId", contractId); // 传递主表ID String
		// 生产厂家
		List<Factory> factoryList = contractProductService.getFactoryList();
		model.addAttribute("factoryList", factoryList);

		ContractProduct obj = contractProductService.get(id);
		model.addAttribute("obj", obj);

		return "/cargo/contract/jContractProductUpdate.jsp";
	}

	// 修改保存
	@RequestMapping("/cargo/contractproduct/update.action")
	public String update(Model model, ContractProduct contractProduct) {
		// 传递主表ID String(第一种方式，获取name=contractId的隐藏域中的值，传给model)
		// String contractId,
		// model.addAttribute("contractId", contractId);
		// 第二种方式：通过当前对象contractProduct的属性(contractId)的get方法获取到，传给model
		model.addAttribute("contractId", contractProduct.getContractId());
		contractProductService.update(contractProduct);

		return "redirect:/cargo/contractproduct/tocreate.action";
	}

	// 删除一条
	@RequestMapping("/cargo/contractproduct/deleteById.action")
	public String deleteById(String id) {
		contractProductService.deleteById(id);

		return "redirect:/cargo/contractproduct/tocreate.action";
	}

}
