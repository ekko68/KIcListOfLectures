package com.apik.course.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apik.course.dao.CourseDAO;
import com.apik.course.command.CourseCommand;
import com.apik.course.command.CourseVO;

@Controller
public class ContentController {

	// 1) Log객체 생성
		//private Logger log=Logger.getLogger(ListController.class);
		private Logger log=Logger.getLogger(this.getClass());
	
		@Autowired // 자동으로 객체를 구해와 불러옴
		private CourseDAO courseDao;	

/*	
		@RequestMapping("/content.do")
		public String result() {
			return "result/content";
		}
		
	*/
		@RequestMapping("/content.do")
		public ModelAndView contentPro(
				@RequestParam(value="cosnum", defaultValue="") int cosnum,
				@RequestParam(value="cosname", defaultValue="") String cosname,
				@RequestParam(value="mode", defaultValue="") String mode,
				@RequestParam(value="level", defaultValue="") String level
				) {
			System.out.println("===contentPro() 호출!===");	
			
			System.out.println("cosnum : " + cosnum);
			System.out.println("cosname : " + cosname);
			System.out.println("mode : " + mode);
			System.out.println("level : " + level);
			
			System.out.println("--- 이상, post로 받아온 값 ---");	
			
			//int lv = Integer.parseInt(level);
			//String play=mode;	
			
			String type="";
			
			String m = mode; 
			switch(m) { 
			case "rest": type="피로도"; break; 
			case "play": type="에너지"; break; 
			}
			
			
			List<CourseVO> cosnumList = null;
			int count = courseDao.getCourseNumCount(cosnum);
			
			//System.out.println("lv : " + lv);
			//System.out.println("play : " + play);
			System.out.println("type : " + type);
			System.out.println("count : " + count);
			
			if(count > 0) {
				cosnumList = courseDao.getCourseNumList(cosnum);
				System.out.println("cosnumList : "+cosnumList);
			}else {
				cosnumList = Collections.EMPTY_LIST;
			}
			

			// Log객체를 이용하여 처리과정 콘솔에 출력
			if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
				System.out.println("===contentPro() 호출!===");
				log.debug("cosnum : " + cosnum);
				log.debug("cosnumList : " + cosnumList);
				System.out.println("===contentPro() end===");
			}
			

			System.out.println("===contentPro() end===");
			
			ModelAndView mav = new ModelAndView();		
			mav.setViewName("details/content");
			mav.addObject("cosnumList", cosnumList);
			mav.addObject("count", count);
			mav.addObject("level", level);
			mav.addObject("cosname", cosname);
			mav.addObject("type", type);			
			return mav;
		}	
		
	
}
