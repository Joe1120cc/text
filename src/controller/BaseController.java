package controller;

import factory.ServiceFactory;
import service.BaseService;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 基础控制器，是所有控制器的父类
 */
public class BaseController {
	private BaseService baseService;

	public BaseController(String message) {
		baseService = ServiceFactory.createService(message);
	}

}
