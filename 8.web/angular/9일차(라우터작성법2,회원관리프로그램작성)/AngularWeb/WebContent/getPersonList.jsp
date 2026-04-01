<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.data.*,java.util.ArrayList" %>
<%
     //CORS(Cross-Origin Resource Sharing)
     //"name":"hello"
     response.setHeader("Access-Control-Allow-Origin","*");
 %>
<%
   //회원목록=>[{"id":1,"name":"홍길동","age":23}]
   PersonCollection collection=PersonCollection.getInstance();
   ArrayList<Person> list =collection.getList(); //id,name,age
   //String(+) or StringBuffer(append())->이용->메모리 사용
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


