//...배열->[123]+[456]=>[123456]->concat(+) 대용(대신 사용)
const arr4=[1,2,3];
// ...배열명
console.log([...arr4,4,5,6,7])

//배열에 값을 추가->push()<->pop()(배열의 요소값 삭제)
const arr5=[7,8,9];
const arr6=[10,11,12];
//기존배열객체명.push(추가시킬 배열객체)
arr5.push(...arr6) //arr5.push(10,11,12)
console.log('arr5->',arr5)
//배열도 복사가 된다.
const arr7=[13,14,15];
const copy = [...arr7]
console.log('추가 전의 copy=>',copy)//[13,14,15]
copy.push(16)
console.log('추가 후의 copy=>',copy)//[13,14,15,16]
console.log('arr7->',arr7)//원본은 변경X