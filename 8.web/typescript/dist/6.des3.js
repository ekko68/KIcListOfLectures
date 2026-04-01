//객체=>{ 키:변수명,키2:변수명2~} ={ 키:값,키2:값2}
var _a = { prop1: 'a', prop2: 'b' }, p1 = _a.prop1, p2 = _a.prop2;
//객체명.키명=저장할값 var obj={ name:'Lee'}  obj.name='kim'
console.log({ prop1: p1, prop2: p2 });
//node 6.des3.js
//객체리터럴->default value값을 설정이 가능
//const {prop1,prop2,prop3} = { prop1:'ab',prop2:'bb',prop3:'cc'}
var _b = { prop1: 'ab', prop2: 'bb' }, prop1 = _b.prop1, prop2 = _b.prop2, _c = _b.prop3, prop3 = _c === void 0 ? 'ccc' : _c;
//객체명.키명=저장할값 var obj={ name:'Lee'}  obj.name='kim'
console.log({ prop1: prop1, prop2: prop2, prop3: prop3 });
//함수를 이용해서 값을 저장
function margin() {
    //left,right,top,bottom->값이 저장
    var left = 1, right = 2, top = 3, bottom = 4;
    return { left: left, right: right, top: top, bottom: bottom }; //객체
}
var _d = margin(), left = _d.left, bottom = _d.bottom; //={left,right,top,bottom};
console.log(left, bottom); //1,4

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIjYuZGVzMy50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSxxQ0FBcUM7QUFDL0IsSUFBQSwrQkFBNEMsRUFBM0MsYUFBUSxFQUFDLGFBQVEsQ0FBMEI7QUFDbEQsbURBQW1EO0FBQ25ELE9BQU8sQ0FBQyxHQUFHLENBQUMsRUFBQyxLQUFLLEVBQUMsRUFBRSxFQUFDLEtBQUssRUFBQyxFQUFFLEVBQUMsQ0FBQyxDQUFBO0FBQ2hDLGdCQUFnQjtBQUVoQiwrQkFBK0I7QUFDL0IsaUVBQWlFO0FBQzNELElBQUEsaUNBQW9ELEVBQW5ELGdCQUFLLEVBQUMsZ0JBQUssRUFBQyxhQUFXLEVBQVgsa0NBQVcsQ0FBNEI7QUFDMUQsbURBQW1EO0FBQ25ELE9BQU8sQ0FBQyxHQUFHLENBQUMsRUFBQyxLQUFLLE9BQUEsRUFBQyxLQUFLLE9BQUEsRUFBQyxLQUFLLE9BQUEsRUFBQyxDQUFDLENBQUE7QUFFaEMsZ0JBQWdCO0FBQ2hCO0lBQ0ksOEJBQThCO0lBQzlCLElBQU0sSUFBSSxHQUFDLENBQUMsRUFBQyxLQUFLLEdBQUMsQ0FBQyxFQUFDLEdBQUcsR0FBQyxDQUFDLEVBQUMsTUFBTSxHQUFDLENBQUMsQ0FBQztJQUNwQyxNQUFNLENBQUMsRUFBQyxJQUFJLE1BQUEsRUFBQyxLQUFLLE9BQUEsRUFBQyxHQUFHLEtBQUEsRUFBQyxNQUFNLFFBQUEsRUFBQyxDQUFDLENBQUEsSUFBSTtBQUN2QyxDQUFDO0FBQ0ssSUFBQSxhQUF3QixFQUF2QixjQUFJLEVBQUMsa0JBQU0sQ0FBYSxDQUFBLDJCQUEyQjtBQUMxRCxPQUFPLENBQUMsR0FBRyxDQUFDLElBQUksRUFBQyxNQUFNLENBQUMsQ0FBQSxDQUFBLEtBQUsiLCJmaWxlIjoiNi5kZXMzLmpzIiwic291cmNlc0NvbnRlbnQiOlsiLy/qsJ3ssrQ9Pnsg7YKkOuuzgOyImOuqhSztgqQyOuuzgOyImOuqhTJ+fSA9eyDtgqQ66rCSLO2CpDI66rCSMn1cclxuY29uc3Qge3Byb3AxOnAxLHByb3AyOnAyfSA9IHsgcHJvcDE6J2EnLHByb3AyOidiJ31cclxuLy/qsJ3ssrTrqoUu7YKk66qFPeyggOyepe2VoOqwkiB2YXIgb2JqPXsgbmFtZTonTGVlJ30gIG9iai5uYW1lPSdraW0nXHJcbmNvbnNvbGUubG9nKHtwcm9wMTpwMSxwcm9wMjpwMn0pXHJcbi8vbm9kZSA2LmRlczMuanNcclxuXHJcbi8v6rCd7LK066as7YSw65+0LT5kZWZhdWx0IHZhbHVl6rCS7J2EIOyEpOygleydtCDqsIDriqVcclxuLy9jb25zdCB7cHJvcDEscHJvcDIscHJvcDN9ID0geyBwcm9wMTonYWInLHByb3AyOidiYicscHJvcDM6J2NjJ31cclxuY29uc3Qge3Byb3AxLHByb3AyLHByb3AzPSdjY2MnfSA9IHsgcHJvcDE6J2FiJyxwcm9wMjonYmInfVxyXG4vL+qwneyytOuqhS7tgqTrqoU97KCA7J6l7ZWg6rCSIHZhciBvYmo9eyBuYW1lOidMZWUnfSAgb2JqLm5hbWU9J2tpbSdcclxuY29uc29sZS5sb2coe3Byb3AxLHByb3AyLHByb3AzfSlcclxuXHJcbi8v7ZWo7IiY66W8IOydtOyaqe2VtOyEnCDqsJLsnYQg7KCA7J6lXHJcbmZ1bmN0aW9uIG1hcmdpbigpe1xyXG4gICAgLy9sZWZ0LHJpZ2h0LHRvcCxib3R0b20tPuqwkuydtCDsoIDsnqVcclxuICAgIGNvbnN0IGxlZnQ9MSxyaWdodD0yLHRvcD0zLGJvdHRvbT00O1xyXG4gICAgcmV0dXJuIHtsZWZ0LHJpZ2h0LHRvcCxib3R0b219Oy8v6rCd7LK0XHJcbn1cclxuY29uc3Qge2xlZnQsYm90dG9tfSA9IG1hcmdpbigpOy8vPXtsZWZ0LHJpZ2h0LHRvcCxib3R0b219O1xyXG5jb25zb2xlLmxvZyhsZWZ0LGJvdHRvbSkvLzEsNCJdfQ==
