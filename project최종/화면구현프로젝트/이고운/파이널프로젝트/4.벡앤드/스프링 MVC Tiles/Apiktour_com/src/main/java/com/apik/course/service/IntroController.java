package com.apik.course.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.course.dao.CourseDAO;

@Controller
public class IntroController {

	// 1) Log객체 생성
	// private Logger log=Logger.getLogger(ListController.class);
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired // 자동으로 객체를 구해와 불러옴
	private CourseDAO courseDao;

	@RequestMapping("/index.do")
	public String process() {
		return "intro/intro";
	}

	@RequestMapping(value = "/choicePlay.do", method = RequestMethod.GET)
	public String choicePlay( Model model) {
		System.out.println("===choicePlay() 호출!===");
		String type="에너지";
		String mode = "play"; 
			
		if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
			System.out.println("===choicePlay() 호출!===");
			log.debug("mode : " + mode); // 내부적인 처리과정
			System.out.println("===choicePlay() end===");
		}		
		
		System.out.println("mode : " + mode);
		System.out.println("type : " + type);
		
		model.addAttribute("mode", mode);
		model.addAttribute("type", type);
		
		System.out.println("===choicePlay() end===");
		return "intro/choicePlay";
	}
	
	@RequestMapping(value = "/choiceRest.do", method = RequestMethod.GET)
	public String choiceRest(Model model) {
		String type="피로도";
		String mode = "rest"; 
		System.out.println("===choiceRest() 호출!===");
		if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
			System.out.println("===choice() 호출!===");
			log.debug("mode : " + mode); // 내부적인 처리과정
			System.out.println("===choice() end===");
		}
		
		model.addAttribute("mode", mode);
		model.addAttribute("type", type);
		
		System.out.println("mode : " + mode);
		System.out.println("type : " + type);
		System.out.println("===choiceRest() end===");
		return "intro/choiceRest";
	}

	@RequestMapping("/playPro.do") 
	public ModelAndView playPro(
			@RequestParam(value="mode", defaultValue="") String mode,
			@RequestParam(value="level", defaultValue="") String level) {
		System.out.println("===playPro() 호출!===");
		String type="";
		String m = mode;
		
		switch(m) { 
		case "play": type="에너지"; break; 
		}
		
		int lv = Integer.parseInt(level);
		String play=mode;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));
		
		int count=courseDao.getCourseCount(map);
		
		if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
			System.out.println("===playPro() 호출!===");
			log.debug("mode : " + mode); // 내부적인 처리과정
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);	
			System.out.println("===playPro() end===");
		}
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("intro/playPro");
		mav.addObject("count", count);
		mav.addObject("type", type);
		mav.addObject("mode", mode);
		mav.addObject("level", level);
		mav.addObject("play", play);
		mav.addObject("lv", lv);
		
		System.out.println("count : " + count);
		System.out.println("type : " + type);
		System.out.println("mode : " + mode);
		System.out.println("level : " + level);
		System.out.println("play : " + play);
		System.out.println("lv : " + lv);
		
		System.out.println("===playPro() end===");
		
		return mav;
	}
	
	@RequestMapping("/restPro.do") 
	public ModelAndView restPro(
			@RequestParam(value="mode", defaultValue="") String mode,
			@RequestParam(value="level", defaultValue="") String level) {
		System.out.println("===restPro() 호출!===");
		String type="";
		String m = mode;
		
		switch(m) { 
		case "rest": type="피로도"; break; 
		}
		
		int lv = Integer.parseInt(level);
		String play=mode;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));
		
		int count=courseDao.getCourseCount(map);
		
		if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
			System.out.println("===restPro() 호출!===");
			log.debug("mode : " + mode); // 내부적인 처리과정
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);	
			System.out.println("===restPro() end===");
		}
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("intro/playPro");
		mav.addObject("count", count);
		mav.addObject("type", type);
		mav.addObject("mode", mode);
		mav.addObject("level", level);
		mav.addObject("play", play);
		
		System.out.println("count : " + count);
		System.out.println("type : " + type);
		System.out.println("mode : " + mode);
		System.out.println("level : " + level);
		System.out.println("play : " + play);
		System.out.println("lv : " + lv);
		System.out.println("===restPro() end===");
		return mav;
	}
	
}
