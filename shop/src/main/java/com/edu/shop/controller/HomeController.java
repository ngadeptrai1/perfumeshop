package com.edu.shop.controller;

import com.edu.shop.dao.AccountRepository;
import com.edu.shop.dao.PerfumeRepository;
import com.edu.shop.model.Account;
import com.edu.shop.model.Perfume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
	PerfumeRepository dao;

	@RequestMapping("/home")
	public String get(Model model) {
		model.addAttribute("list",dao.findAll() );
		return "user/index";
	}
}
