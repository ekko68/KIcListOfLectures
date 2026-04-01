//const는 객체에도 사용이 가능하다.->물론 재할당은 금지된다.
//key,value로 객체를 저장
const obj = {id:7890};
//obj = {bar: 456}; key값이 변경되는것이 아니라 value이 변경이 가능
const obj2 = {bar:456};
//개인정보 user객체 생성 가능하다. var user={~}

const user={
    name:'Lee',
    address:{
        city:'Seoul'
    }
};
//객체명.키명=>값을 불러올때, 객체명.키명=변경할값
//주소값은 그대로 유지가 되면서(변경X)->키에 해당되는 데이터를 변경허용
console.log(user)
user.name = 'kim';
console.log(user)
/*
c:\webtest\8.web\typescript\dist>node const2.js
{ name: 'Lee', address: { city: 'Seoul' } }
{ name: 'kim', address: { city: 'Seoul' } }

c:\webtest\8.web\typescript\dist>
*/

