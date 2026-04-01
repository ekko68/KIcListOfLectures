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
public class ResultController {

	// 1) Log객체 생성
		//private Logger log=Logger.getLogger(ListController.class);
		private Logger log=Logger.getLogger(this.getClass());
	
		@Autowired // 자동으로 객체를 구해와 불러옴
		private CourseDAO courseDao;	

	/*
	@RequestMapping("/result.do")
	public String result() {
		return "resultMap";
	}*/
	
		@RequestMapping("/resultcos.do")
		public ModelAndView resultcos(
				@RequestParam(value="mode", defaultValue="") String mode,
				@RequestParam(value="level", defaultValue="") String level
				//@RequestParam(value="count", defaultValue="") int count
				) {
			System.out.println("===result() 호출!===");	
			int lv = Integer.parseInt(level);
			String play=mode;			
			
			// DB 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("play", play);
			map.put("lv", new Integer(lv));
			
			int count=courseDao.getCourseCount(map);  //매개변수를 받아 해당하는 코스 개수 조회
			List<CourseCommand> cosList = null;
			
			// paly와 lv에 해당하는 코스 리스트 
			if(count > 0) {
				cosList = courseDao.getCourseList(map);
				System.out.println("cosList : "+cosList);
			}else {
				cosList = Collections.EMPTY_LIST;
			}
			// Log객체를 이용하여 처리과정 콘솔에 출력
			if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
				System.out.println("===result() 호출!===");
				log.debug("play : " + play);
				log.debug("lv : " + lv);
				log.debug("count : " + count);	
				System.out.println("===result() end===");
			}
			
			
		

				
			System.out.println("play : " + play);
			System.out.println("lv : " + lv); 
			System.out.println("count : " + count);
			//System.out.println("cosCount : " + cosCount);
			System.out.println("===result() end===");
			
			ModelAndView mav = new ModelAndView();		
			mav.setViewName("result/resultcos"); 
			mav.addObject("count", count);
			mav.addObject("cosList", cosList);
			mav.addObject("play", play);
			mav.addObject("lv", lv);
			//mav.addObject("cosMakerList", cosMakerList);
			
			//mav.addObject("cosCount", cosCount);
			//mav.addObject("cosnumList", cosnumList);
			
			return mav;
		}	
		
		
		@RequestMapping(value="/cosinfo.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String cosinfoPro2() {
			System.out.println("===cosinfoPro2() end===");
			return "cos_info";
		}
		
		
		
/*		@RequestMapping(value="/cosinfo.do", method = RequestMethod.POST)
		public String cosinfoPro(@RequestParam(value="cosnum", defaultValue="") int cosnum,
				Model model) {
			
			cosnum = 1;
			List <CourseVO> cosnumList = courseDao.getCourseNumList(cosnum);
			
			model.addAttribute("cosnumList", cosnumList);
			
			return "result/cos_info";
		}
		
		*/
		
		
	// map 페이지 추가
/*	@RequestMapping("/result.do")
	public ModelAndView result(
			@RequestParam(value="mode", defaultValue="") String mode,
			@RequestParam(value="level", defaultValue="") String level
			//@RequestParam(value="count", defaultValue="") int count
			) {
		
		int lv = Integer.parseInt(level);
		String play=mode;
		
		
		// DB 조회
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));
		
		int count=courseDao.getCourseCount(map);  //매개변수를 받아 해당하는 코스 개수 조회
		List<CourseCommand> cosList = null;
		
		// paly와 lv에 해당하는 코스 리스트 
		if(count > 0) {
			cosList = courseDao.getCourseList(map);
			System.out.println("cosList : "+cosList);
		}else {
			cosList = Collections.EMPTY_LIST;
		}
		// Log객체를 이용하여 처리과정 콘솔에 출력
		if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
			System.out.println("===result() 호출!===");
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);	
			System.out.println("===result() end===");
		}
		
		System.out.println("===result() 호출!===");	
	

			
		System.out.println("play : " + play);
		System.out.println("lv : " + lv); 
		System.out.println("count : " + count);
		//System.out.println("cosCount : " + cosCount);
		System.out.println("===result() end===");
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("resultMap"); 
		mav.addObject("count", count);
		mav.addObject("cosList", cosList);
		mav.addObject("play", play);
		mav.addObject("lv", lv);
		//mav.addObject("cosMakerList", cosMakerList);
		
		//mav.addObject("cosCount", cosCount);
		//mav.addObject("cosnumList", cosnumList);
		
		return mav;
	}
	*/
	
	
	@RequestMapping("/json.do")
	//@ResponseBody
	public String json(Model model) {
		String play = "rest";
		int lv = 1;
		
		// DB 조회
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));

		int count = courseDao.getCourseCount(map); // 매개변수를 받아 해당하는 코스 개수 조회
		String jsonMap = null;
		List<CourseVO> cosMakerList = null;
		//CourseVO couservo;
		// paly와 lv에 해당하는 코스 리스트
		if (count > 0) {
			cosMakerList = courseDao.getCourseMarkerList(map);
			System.out.println("cosMakerList : " + cosMakerList);
			 StringBuffer buffer = new StringBuffer(); 
			 buffer.append("[");
			 	// {"id":1, "name":"홍길동","age":23}
			 	for(int i=0; i<cosMakerList.size(); i++){
			 		CourseVO c=cosMakerList.get(i);
			 		String mesg = "{"; //결합할 문자 변수 선언, 겹따옴표 표현방식 : " = \"
			 		mesg+="name: "+"\""+c.getLocname()+"\","; // "id":"1" 
			 		mesg+=" location: "+"["+c.getLocationx()+", ";
			 		mesg+=+c.getLocationy()+"]";
			 		mesg+="}";
			 		buffer.append(mesg); // buffer에 추가후에 레코드가 더 있는지 끝나는지 확인을 해야함
			 		// 레코드가 1개 이상일 경우: {"id":1, "name":"홍길동","age":23} , {"id":1, "name":"홍길동","age":23}
			 		// 레코드가 마지막을 경우는 ,가 붙지 않음
			 		if(i!=cosMakerList.size()-1) buffer.append(","); // i가 맨 마지막 인덱스 번호가 아니라면 , 추가
			 	}
			 buffer.append("]");
			 System.out.println(buffer.toString());
			 jsonMap = buffer.toString();
			 System.out.println("jsonMap"+jsonMap);
		} else {
			cosMakerList = Collections.EMPTY_LIST;
		}
				
		// Log객체를 이용하여 처리과정 콘솔에 출력
		if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
			System.out.println("===json() 호출!===");
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);
			System.out.println("===json() end===");
		}

		System.out.println("===json() 호출!===");

		System.out.println("play : " + play);
		System.out.println("lv : " + lv);
		System.out.println("count : " + count);
		// System.out.println("cosCount : " + cosCount);
		System.out.println("===json() end===");

		model.addAttribute("count", count);
		model.addAttribute("play", play);
		model.addAttribute("lv", lv);
		model.addAttribute("jsonMap", jsonMap);
		model.addAttribute("cosMakerList", cosMakerList);

		return "result/json"; // return "이동할 페이지명"; 확장자 생략
	}
	
	
	
	

	
	
/*	
	@RequestMapping("/cosInfo.do")
	public String cos() {
		return "cosResult";
	}
	
	*/
	
	
	
/*	@RequestMapping(value="/json.do")
	@ResponseBody
	public Map<String, Object> test(){
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("1", "111");
	    	map.put("2", 222);
	    	return map;
	    }
	
	*/
	
	/*
	@RequestMapping("jsonlist2")
	public Map<String, Object> jjson() {
		
		String play = "rest";
		int lv = 1;
		
		// DB 조회
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));

		int count = courseDao.getCourseCount(map); // 매개변수를 받아 해당하는 코스 개수 조회
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<CourseVO> cosMakerList = null;
		// paly와 lv에 해당하는 코스 리스트
		if (count > 0) {
			cosMakerList = courseDao.getCourseMarkerList(map);
			System.out.println("cosMakerList : " + cosMakerList);
			for(CourseVO courseVo : cosMakerList){
				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("sawon_no", courseVo.getLocname());
				map2.put("sawon_no", courseVo.getLocationx());
				map2.put("sawon_no", courseVo.getLocationy());
				map2.put("sawon_no", courseVo.getLoctype());
				list.add(map2);
			}
		} else {
			cosMakerList = Collections.EMPTY_LIST;
		}
				
		// Log객체를 이용하여 처리과정 콘솔에 출력
		if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
			System.out.println("===jjson() 호출!===");
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);
			System.out.println("===jjson() end===");
		}
		
		Map<String, Object> returnData = new HashMap<String, Object>();
		returnData.put("cosMakerList", list);
		System.out.println("returnData" + returnData);
		//ModelAndView mav = new ModelAndView();		
		//mav.setViewName(returnData); 
		return returnData;
	}
		
		*/
	
}
