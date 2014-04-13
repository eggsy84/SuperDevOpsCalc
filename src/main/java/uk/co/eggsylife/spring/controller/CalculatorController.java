package uk.co.eggsylife.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.co.eggsylife.spring.beans.AdditionBean;
import uk.co.eggsylife.spring.model.CalculatorCommand;


@Controller
public class CalculatorController {
	
	@Autowired
	protected AdditionBean additionBean = null;
	
	@RequestMapping(method=RequestMethod.GET, value="/calculator")
	public String showCalculator(ModelMap modelMap) {
		modelMap.addAttribute("calculatorCommand", new CalculatorCommand());
		return "calculatorview";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/calculator")
	public String calculate(@ModelAttribute CalculatorCommand calculatorCommand, ModelMap modelMap) {
		int result = additionBean.addTwoNumbers(calculatorCommand.getNumberOne(), calculatorCommand.getNumberTwo());
		modelMap.put("result", result);
		return "calculatorview";
	}

}
