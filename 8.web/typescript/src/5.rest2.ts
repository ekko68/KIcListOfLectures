//5.rest2.ts->rest매개변수,spred연산자(...배열)
function ktest( ...rest){  //동적으로 배열의 값을 받아서 처리해주는 연산자
   console.log(Array.isArray(rest));//true or false반환
   console.log('rest=>',rest);//[1,2,3,4,5,6]
}

ktest(1,2,3,4,5,6)

//2.매개변수를 받을때 순서가 정해져 있다.->spread연산자는 맨 마지막에 위치
//첫번째는 일반 매개변수가 받음,두번째~배열형태로 받음
function ktest2(param, ...rest){
    console.log('param=>',param);
    console.log('rest=>',rest);
}
ktest2(7,8,9,10,11,12);//7,[8~]
ktest2(13,14,15);//13,[14,15]
console.log('==========================');
function ktest3(param,param2, ...rest){
    console.log('param=>',param);
    console.log('param2->',param2)
    console.log('rest=>',rest);
}
ktest3(7,8,9,10,11,12);//7,[8~]
ktest3(13,14,15);//13,[14,15]
console.log('==========================');
//function ktest4( ...rest,param1,param2){}
//spread연산자를 이용한 매개변수값은 맨 마지막에 위치해야 된다.