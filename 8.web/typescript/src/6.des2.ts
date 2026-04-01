//왼쪽의 변수리스트와 오른쪽 배열은 인덱스를 기준으로 값이 할당된다.
let t1,y1,v1;
[t1,y1] = ['a',2];//tuple에 근접
console.log(t1,y1);

[t1,y1] = [1,null];
console.log(t1,y1);

//default parameter처럼 구현 [변수명=기본값,변수명2,,]
[t1,y1,v1=3] = [1,2];
console.log(t1,y1,v1);

[t1,y1=10,v1=3] =[1,2];
console.log(t1,y1,v1);//t1=1,y1=2,v1=3

//spread operator
[t1,...y1] = [1,2,3,4]
console.log(t1,y1);//1,[2,3,4]


