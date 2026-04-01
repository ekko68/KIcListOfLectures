//1.const kk = new KFoo();//new 클래스명()=>객체생성X =>선언하기전
var KFoo = /** @class */ (function () {
    function KFoo() {
    }
    return KFoo;
}());
//2.const k1 = KFoo(); new연산자를 써야 객체생성이 가능
var kk = new KFoo();
console.log('kk->', kk);
kk.num = 1;
console.log(kk); //KFoo {num:1}
var Bar = /** @class */ (function () {
    //constructor(){} 생성자는 한개이상 작성X
    function Bar(num) {
        this.num = 3; //초기값 가능
        this.num = num;
    }
    return Bar;
}());

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIjcuY29udGVzdDIudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEscURBQXFEO0FBQ3JEO0lBQUE7SUFFQSxDQUFDO0lBQUQsV0FBQztBQUFELENBRkEsQUFFQyxJQUFBO0FBQ0QsMENBQTBDO0FBQzFDLElBQU0sRUFBRSxHQUFHLElBQUksSUFBSSxFQUFFLENBQUM7QUFDdEIsT0FBTyxDQUFDLEdBQUcsQ0FBQyxNQUFNLEVBQUMsRUFBRSxDQUFDLENBQUM7QUFDdkIsRUFBRSxDQUFDLEdBQUcsR0FBRyxDQUFDLENBQUM7QUFDWCxPQUFPLENBQUMsR0FBRyxDQUFDLEVBQUUsQ0FBQyxDQUFDLENBQUEsY0FBYztBQUU5QjtJQUVJLCtCQUErQjtJQUMvQixhQUFZLEdBQUc7UUFGZixRQUFHLEdBQVEsQ0FBQyxDQUFDLENBQUEsUUFBUTtRQUdqQixJQUFJLENBQUMsR0FBRyxHQUFDLEdBQUcsQ0FBQztJQUNqQixDQUFDO0lBQ0wsVUFBQztBQUFELENBTkEsQUFNQyxJQUFBIiwiZmlsZSI6IjcuY29udGVzdDIuanMiLCJzb3VyY2VzQ29udGVudCI6WyIvLzEuY29uc3Qga2sgPSBuZXcgS0ZvbygpOy8vbmV3IO2BtOuemOyKpOuqhSgpPT7qsJ3ssrTsg53shLFYID0+7ISg7Ja47ZWY6riw7KCEXHJcbmNsYXNzIEtGb297XHJcbiAgICBudW07XHJcbn1cclxuLy8yLmNvbnN0IGsxID0gS0ZvbygpOyBuZXfsl7DsgrDsnpDrpbwg7I2o7JW8IOqwneyytOyDneyEseydtCDqsIDriqVcclxuY29uc3Qga2sgPSBuZXcgS0ZvbygpO1xyXG5jb25zb2xlLmxvZygna2stPicsa2spO1xyXG5ray5udW0gPSAxO1xyXG5jb25zb2xlLmxvZyhrayk7Ly9LRm9vIHtudW06MX1cclxuXHJcbmNsYXNzIEJhcntcclxuICAgIG51bTpudW1iZXI9MzsvL+y0iOq4sOqwkiDqsIDriqVcclxuICAgIC8vY29uc3RydWN0b3IoKXt9IOyDneyEseyekOuKlCDtlZzqsJzsnbTsg4Eg7J6R7ISxWFxyXG4gICAgY29uc3RydWN0b3IobnVtKXtcclxuICAgICAgICB0aGlzLm51bT1udW07XHJcbiAgICB9XHJcbn1cclxuIl19
