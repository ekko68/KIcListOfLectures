<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.data.*,java.util.ArrayList" %>
<%
     //CORS(Cross-Origin Resource Sharing)
     response.setHeader("Access-Control-Allow-Origin","*");
 %>
<%
   //회원목록=>[{"id":1,"name":"홍길동","age":23}]
   PersonCollection collection=PersonCollection.getInstance();
   //id을 매개변수로 받아서 데이터를 조회
   String id=request.getParameter("id");//삭제시킬 id값
   ArrayList<Person> list =collection.getList(); //id,name,age
   //삭제시킬 항목을 저장
   Person pp=null;
   for(Person x:list){//for(int i=0;i<list.size();i++){
      if(x.getId().equals(id)){ //DB상의 데이터 id과 넘겨받은 id값이 일치한다면
    	  pp=x;
      }
   }
   list.remove(pp);//찾은데이터는 삭제
   
   StringBuffer buffer = new StringBuffer();//String str="";
   buffer.append("[");//str="["
     //[{"id":"1","name":"홍길동","age":"23"},{"id":"2","name":"테스트","age":"23"}]
     for(int i=0;i<list.size();i++){
    	 Person p=list.get(i);
	    	 String mesg="{";
	    	 mesg+="\"id\":\""+p.getId()+"\",";
	    	 mesg+="\"name\":\" "+p.getName()+"\",";
	    	 mesg+="\"age\":\""+p.getAge()+"\"";
	    	 mesg+="}";
	    	 buffer.append(mesg);//추가하고나서 
	    	 if(i!=list.size()-1) buffer.append(",");//맨마지막 인덱스번호가 아니라면,
     }
   buffer.append("]");//str+="]";
   System.out.println(buffer.toString());//StringBuffer->String으로 변환
   //Angular가 데이터를 전송받을 수 있도록 전송해주는 구문
   out.println(buffer.toString().trim());//혹 공백이 존재한다면 공백을 제거->전송


%>


