package spring6;

import java.util.List;

//성능에 대한 클래스
public class PerformanceMoniter {
    private List<Double> number;//성능의 차이

	public void setNumber(List<Double> number) {
		this.number = number;
		System.out.println("setNumber()호출");
	}
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "PerformanceMoniter[number="+number+"]";
    }
}
