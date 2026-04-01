//4.arrow2.ts
//1.배열->특정값을 찾고 싶을때 indexOf 함수를 사용할것.
var str:string[]=["테스트","연습","앵귤러"];
var isExist = false;//찾았는지 여부
for(var i=0;i<=str.length;i++){
    if(str[i] === "연습"){
        isExist = true;
        console.log('데이터 찾음->',str[i]);
    }else{
        console.log('데이터 못찾음->',str[i]);
    }
}
// 배열.indexOf("찾고자하는 값")!== -1 ->못찾으면 -1을 리턴
var isExist2=(str.indexOf("연습")!== -1)
console.log('isExist2=>',isExist2);
//2.filter()->JSON객체->특정한 값만 filter(추출)하고 싶다.->반환값존재
var arr =[
   {"name":"apple","count":2},
   {"name":"orange","count":5},
   {"name":"pear","count":3},
   {"name":"orange","count":16}
];
var newArr=arr.filter(function(item){  //반환시켜줄 수있는 익명함수작성
   return item.name === 'orange' //return item.count === 2
   //return 매개변수.특정키명 === '찾을값'->조건에 만족하는 항목만 리턴
});
console.log('Filter results=>',newArr);





