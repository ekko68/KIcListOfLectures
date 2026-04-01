package j0614;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("객체형변환 연습");
        Shape s=new Shape();
        Point p=new Point();
        Line l=new Line();
        Square sq=new Square();
        
        s.shapeDraw();
        p.pointDraw();
        l.lineDraw();
        sq.squareDraw();
        
        System.out.println("==객체 자동형변환==");
        Shape sh[]=new Shape[4];
        sh[0]=s;
        sh[1]=p;//s+p
        sh[2]=l;//s+p+l
        sh[3]=sq;//s+p+l+sq
        
        for(int i=0;i<sh.length;i++) {
        	sh[i].draw();//메서드는 같지만 객체가 다르면 서로 구분해서 메서드호출 
        	                  //다형성의 한예
        	whoAreYou(sh[i]);
        }
	}
	//상속관계(형변환)->instanceof연산자
	static void whoAreYou(Shape sh) { //p383
		//Shape
		if(sh instanceof Shape)
			System.out.println("I am Shape");
		else
			System.out.println("I am not Shape");
		//Point
		if(sh instanceof Point)
			System.out.println("I am Point");
		else
			System.out.println("I am not Point");
		//Line
		if(sh instanceof Line)
			System.out.println("I am Line");
		else
			System.out.println("I am not Line");
		//Squre
		if(sh instanceof Square)
			System.out.println("I am Square");
		else
			System.out.println("I am not Square");
		System.out.println("=============");
	}
}
//Shape->Point(점)->Line(직선)->Square(다각형)
class Shape{
	//모든 도형에 공통으로 사용하는 메서드
	void draw() {
		System.out.println("Shape");
	}
	//shape전용 메서드
	void shapeDraw() {
		System.out.println("Shape");
	}
}
//Point
class Point extends Shape{ //is a 관계
	void draw() { //오버라이딩
		System.out.println("Point");
	}
	void pointDraw() {
		System.out.println("Point");
	}
}
//Line>Point>Shape
class Line extends Point{ //is a 관계
	void draw() { //오버라이딩
		System.out.println("Line");
	}
	void lineDraw() {
		System.out.println("Line");
	}
}
//Square>Line>Point>Shape
class Square extends Line{ //is a 관계
	void draw() { //오버라이딩
		System.out.println("Square");
	}
	void squareDraw() {
		System.out.println("Square");
	}
	
}







