package controller;

import factory.ServiceFactory;
import service.BaseService;

public class BaseController {
	private BaseService baseService;
	public BaseController(String message) {
		baseService = ServiceFactory.createService(message);
	}

}
