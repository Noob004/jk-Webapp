package cn.ywt.jk.controller.cargo.contract;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ywt.jk.controller.BaseController;
import cn.ywt.jk.domain.Contract;
import cn.ywt.jk.service.ContractService;

@Controller
public class ContractController extends BaseController {
	@Resource
	ContractService contractService;

	// 查询
	@RequestMapping("/cargo/contract/list.action")
	public String list(Model model) {
		List<Contract> dataList = contractService.find(null);
		model.addAttribute("dataList", dataList);

		return "/cargo/contract/jContractList.jsp";
	}

	// 查询一条
	@RequestMapping("/cargo/contract/toview.action")
	public String toview(String id, Model model) {
		Contract obj = contractService.get(id);
		model.addAttribute("obj", obj);

		return "/cargo/contract/jContractView.jsp";
	}

	// 转向新增页面
	@RequestMapping("/cargo/contract/tocreate.action")
	public String tocreate() {

		return "/cargo/contract/jContractCreate.jsp";
	}

	// 新增保存
	@RequestMapping("/cargo/contract/insert.action")
	public String insert(Contract contract) {
		contractService.insert(contract);

		return "redirect:/cargo/contract/list.action";
	}

	// 转向修改页面，回显数据
	@RequestMapping("/cargo/contract/toupdate.action")
	public String toupdate(String id, Model model) {
		Contract obj = contractService.get(id);
		model.addAttribute("obj", obj);

		return "/cargo/contract/jContractUpdate.jsp";
	}

	// 修改保存
	@RequestMapping("/cargo/contract/update.action")
	public String update(Contract contract) {
		contractService.update(contract);

		return "redirect:/cargo/contract/list.action";
	}

	// 删除一条
	@RequestMapping("/cargo/contract/deleteById.action")
	public String deleteById(String id) {
		contractService.deleteById(id);

		return "redirect:/cargo/contract/list.action";
	}

	// 批量删除
	@RequestMapping("/cargo/contract/delete.action")
	public String delete(@RequestParam("id") String[] ids) {
		contractService.delete(ids);

		return "redirect:/cargo/contract/list.action";
	}

	// 启用
	@RequestMapping("/cargo/contract/start.action")
	public String start(@RequestParam("id") String[] ids) {
		contractService.start(ids);

		return "redirect:/cargo/contract/list.action";
	}

	// 停用
	@RequestMapping("/cargo/contract/stop.action")
	public String stop(@RequestParam("id") String[] ids) {
		contractService.stop(ids);

		return "redirect:/cargo/contract/list.action";
	}
}
