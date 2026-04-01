package spring7;
//고객-도서(서버에 접속->ip주소,접속시간을 설정)

import java.util.Set;

public class Customer {
   private Set<Integer> subSet;//책대여수

public void setSubSet(Set<Integer> subSet) {
	this.subSet = subSet;
}
  @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer[subSet="+subSet+"]";
	}
}
