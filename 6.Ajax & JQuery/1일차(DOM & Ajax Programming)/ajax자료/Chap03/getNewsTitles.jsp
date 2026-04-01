<%@ page contentType="text/plain; charset=euc-kr" %>
<%
	String [] titles = {"사건 하나", "두번째 사건", "또 다른 세번째 사건"};
	String sSStrong = "<strong>";
	String sEStrong = "</strong>";
	for(int i = 0; i <titles.length; ++i)
	{
%>
<% 
		if(i==0) { %>
			<%= sSStrong %>
<% 
		}
%>
		<%= titles[i] %>
<%	
		if(i==0) { %>
			<%= sEStrong %>
<%
		}
%>
		<br>
<%
	} // end of for
%>
