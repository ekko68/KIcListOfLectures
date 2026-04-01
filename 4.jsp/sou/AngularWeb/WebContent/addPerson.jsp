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
   //name을 매개변수로 받아서 데이터를 추가시킨후 다시 출력
   String name=request.getParameter("name");//나이
   //추가
   if(name==null){
	   name="테스트김";//NullPointerException
   }
   //
   ArrayList<Person> list =collection.getList(); //id,name,age
   //기존에 저장된 id값에 +을 더한 새로운 id값을 생성 한 후
   //입력받은 이름과 함께 데이터 저장시킨다.
   String newId=String.valueOf(Integer.parseInt
                             (list.get(list.size()-1).getId())+1);
   System.out.println("newId=>"+newId);
   list.add(new Person(newId,name,20));
   //list.add(new Person(newId,name,newAge));
   //추가한 후 데이터를 다시 출력
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


