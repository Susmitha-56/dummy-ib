/*
 * package com.dbs.project.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.dbs.project.model.Bank; import
 * com.dbs.project.repository.BankRepository; import
 * com.dbs.project.service.BankServiceImpl;
 * 
 * 
 * @RestController public class BankController {
 * 
 * @Autowired private BankServiceImpl bankServiceImpl;
 * 
 * @Autowired private BankRepository bankRepository;
 * 
 * @PostMapping("/login") public String loginUser(
 * 
 * @RequestParam("username") String username,
 * 
 * @RequestParam("password") String password, Model model,Bank bank){
 * 
 * if(bankRepository.findByUsername(username) !=
 * null&&bankRepository.findByPassword(password)!=null) {
 * model.addAttribute("bank", username); return "success"; } return "register";
 * }
 * 
 * }
 */