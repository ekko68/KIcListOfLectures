//객체를 생성해서 메서드를 작성하는 경우->arrow()함수 작성X
//${this}=>현재 객체가 아니다.(obj)
var obj = {
    name: 'Lee',
    //sayHi:()=> console.log(`Hi ${this.name}`)
    sayHi: function () {
        console.log("Hi " + this.name);
    }
};
obj.name = 'Kim'; //객체명.키명=새로운값
//메서드호출
obj.sayHi();

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIjQuYXJyb3c0LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLHNDQUFzQztBQUN0QywyQkFBMkI7QUFDM0IsSUFBTSxHQUFHLEdBQUM7SUFDTixJQUFJLEVBQUMsS0FBSztJQUNWLDJDQUEyQztJQUUzQyxLQUFLO1FBQ0YsT0FBTyxDQUFDLEdBQUcsQ0FBQyxRQUFNLElBQUksQ0FBQyxJQUFNLENBQUMsQ0FBQztJQUNsQyxDQUFDO0NBQ0osQ0FBQTtBQUNELEdBQUcsQ0FBQyxJQUFJLEdBQUMsS0FBSyxDQUFDLENBQUEsYUFBYTtBQUM1QixPQUFPO0FBQ1AsR0FBRyxDQUFDLEtBQUssRUFBRSxDQUFDIiwiZmlsZSI6IjQuYXJyb3c0LmpzIiwic291cmNlc0NvbnRlbnQiOlsiLy/qsJ3ssrTrpbwg7IOd7ISx7ZW07IScIOuplOyEnOuTnOulvCDsnpHshLHtlZjripQg6rK97JqwLT5hcnJvdygp7ZWo7IiYIOyekeyEsVhcclxuLy8ke3RoaXN9PT7tmITsnqwg6rCd7LK06rCAIOyVhOuLiOuLpC4ob2JqKVxyXG5jb25zdCBvYmo9e1xyXG4gICAgbmFtZTonTGVlJyxcclxuICAgIC8vc2F5SGk6KCk9PiBjb25zb2xlLmxvZyhgSGkgJHt0aGlzLm5hbWV9YClcclxuICAgIFxyXG4gICAgc2F5SGkoKXsgIC8vZnVuY3Rpb24g7IOd6561IOqwgOuKpVxyXG4gICAgICAgY29uc29sZS5sb2coYEhpICR7dGhpcy5uYW1lfWApO1xyXG4gICAgfVxyXG59XHJcbm9iai5uYW1lPSdLaW0nOy8v6rCd7LK066qFLu2CpOuqhT3sg4jroZzsmrTqsJJcclxuLy/rqZTshJzrk5ztmLjstpxcclxub2JqLnNheUhpKCk7Il19
