package j0602;

//1차원배열->한쪽면만 나열
public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int b[]= {56,38,12,36,41,27,26,32,59,16,18,28,21,17};
          //20대만 몇명?(20~29)
          int count=0;//20대 사람수를 기억
          for(int i=0;i<b.length;i++)
        	  if(b[i]>=20 && b[i]<=29) {
        		  count++;
        	     System.out.println("b["+i+"]="+b[i]);
        	  }
          System.out.println("20대 인원수(count)=>"+count+"명");
	}
}




