const name2 = '테스트'; //중간에 값을 변경X
//let name2 = '테스트'; //중간에 값을 변경가능
const addr2 = '서울시 강남구';

//기존방법
console.log('내이름은 '+name2+'이고 주소는 '+addr2+'입니다.');

//es6 ${출력할 변수명}
console.log(`내이름은 ${name2} 이고 주소는 ${addr2}.`);
//표현식도 가능->수식도 가능(연산이 가능하다.)
console.log(`1+1 = ${1+1}`);
const name3 = 'imsi';
console.log(`Hello ${name3.toUpperCase()}`);