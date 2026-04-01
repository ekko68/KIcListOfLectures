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
   String id=request.getParameter("id");//수정 또는 삭제하는 데이터를 찾기위해서
   String name=request.getParameter("name");
   String age=request.getParameter("age");
   System.out.println("id:"+id+",name:"+name+",age:"+age);
   
   ArrayList<Person> list =collection.getList(); //id,name,age
   for(int i=0;i<list.size();i++){
  	 Person p=list.get(i);
  	 //추가 넘겨받은 id값과 일치하는 데이터를 찾았다면
  	 if(id.equals(p.getId())){
  		 list.set(i,new Person(id,name,Integer.parseInt(age)));
  	 }
   }//
   //수정한 후 데이터를 다시 출력
   StringBuffer buffer = new StringBuffer();//String str="";
   buffer.append("[");//str="["

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


