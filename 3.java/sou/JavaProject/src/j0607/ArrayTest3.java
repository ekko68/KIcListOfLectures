package j0607;

//1차원배열->한쪽면만 나열
public class ArrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//형식) 자료형 배열명[]=new 자료형[갯수],자료형 배열명[]={값1,값2,,,};
          int b[]= {56,38,12,36,41,27,26,32,59,16,18,28,21,17};
          //10~50대만 몇명?
          //int count=0,count2,count3,count4,count5=>변수가 5개필요
          int cnt[]=new int[5];//cnt[0]~cnt[4] 각 세대별로 배열에 저장
          
          for(int i=0;i<b.length;i++) {
        	  if(b[i]>=10 && b[i]<=19) cnt[0]++; //10대
        	  if(b[i]>=20 && b[i]<=29) cnt[1]++; //20대
        	  if(b[i]>=30 && b[i]<=39) cnt[2]++; //30대
        	  if(b[i]>=40 && b[i]<=49) cnt[3]++;//40대
        	  if(b[i]>=50 && b[i]<=59) cnt[4]++;//50대
        	  }//for
          for(int i=0;i<cnt.length;i++)
          System.out.println((i+1)*10+"대 인원수=>"+cnt[i]+"명");
	}
}




