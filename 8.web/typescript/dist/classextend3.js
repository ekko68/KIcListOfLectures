var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Animal = /** @class */ (function () {
    function Animal(weight) {
        this._weight = weight;
    }
    Animal.prototype.weight = function () {
        console.log(this._weight);
    };
    Animal.prototype.eat = function () {
        console.log('Animal eat');
    };
    return Animal;
}());
var Human = /** @class */ (function (_super) {
    __extends(Human, _super);
    function Human(weight, language) {
        var _this = _super.call(this, weight) || this;
        _this._language = language;
        return _this;
    }
    //오버라이딩->자식에서 부모클래스의 메서드 내용을 수정
    Human.prototype.eat = function () {
        console.log('Human eat');
    };
    Human.prototype.speak = function () {
        console.log("koreans speak " + this._language);
    };
    return Human;
}(Animal));
var korean = new Human(70, 'Korean'); //new 클래스명(인수1,인수2,,,)
korean.weight(); //70
korean.eat(); //Human eat
korean.speak(); //koreans speak Korean
//객체명 instanceof 클래스명=true or false
console.log(korean instanceof Human); //true
console.log(korean instanceof Animal); //true
//node classextend3.js

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImNsYXNzZXh0ZW5kMy50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7O0FBQUE7SUFFSSxnQkFBWSxNQUFNO1FBQ2QsSUFBSSxDQUFDLE9BQU8sR0FBQyxNQUFNLENBQUM7SUFDeEIsQ0FBQztJQUNELHVCQUFNLEdBQU47UUFDSSxPQUFPLENBQUMsR0FBRyxDQUFDLElBQUksQ0FBQyxPQUFPLENBQUMsQ0FBQztJQUM5QixDQUFDO0lBQ0Qsb0JBQUcsR0FBSDtRQUNJLE9BQU8sQ0FBQyxHQUFHLENBQUMsWUFBWSxDQUFDLENBQUM7SUFDOUIsQ0FBQztJQUNMLGFBQUM7QUFBRCxDQVhBLEFBV0MsSUFBQTtBQUNEO0lBQW9CLHlCQUFNO0lBRXRCLGVBQVksTUFBTSxFQUFDLFFBQVE7UUFBM0IsWUFDSSxrQkFBTSxNQUFNLENBQUMsU0FFaEI7UUFERyxLQUFJLENBQUMsU0FBUyxHQUFDLFFBQVEsQ0FBQzs7SUFDNUIsQ0FBQztJQUNELCtCQUErQjtJQUMvQixtQkFBRyxHQUFIO1FBQ0ksT0FBTyxDQUFDLEdBQUcsQ0FBQyxXQUFXLENBQUMsQ0FBQztJQUM3QixDQUFDO0lBQ0QscUJBQUssR0FBTDtRQUNJLE9BQU8sQ0FBQyxHQUFHLENBQUMsbUJBQWlCLElBQUksQ0FBQyxTQUFXLENBQUMsQ0FBQztJQUNuRCxDQUFDO0lBQ0wsWUFBQztBQUFELENBYkEsQUFhQyxDQWJtQixNQUFNLEdBYXpCO0FBQ0QsSUFBTSxNQUFNLEdBQUcsSUFBSSxLQUFLLENBQUMsRUFBRSxFQUFDLFFBQVEsQ0FBQyxDQUFDLENBQUEsc0JBQXNCO0FBQzVELE1BQU0sQ0FBQyxNQUFNLEVBQUUsQ0FBQyxDQUFBLElBQUk7QUFDcEIsTUFBTSxDQUFDLEdBQUcsRUFBRSxDQUFDLENBQUEsV0FBVztBQUN4QixNQUFNLENBQUMsS0FBSyxFQUFFLENBQUMsQ0FBQSxzQkFBc0I7QUFDckMsbUNBQW1DO0FBQ25DLE9BQU8sQ0FBQyxHQUFHLENBQUMsTUFBTSxZQUFZLEtBQUssQ0FBQyxDQUFBLENBQUMsTUFBTTtBQUMzQyxPQUFPLENBQUMsR0FBRyxDQUFDLE1BQU0sWUFBWSxNQUFNLENBQUMsQ0FBQSxDQUFDLE1BQU07QUFDNUMsc0JBQXNCIiwiZmlsZSI6ImNsYXNzZXh0ZW5kMy5qcyIsInNvdXJjZXNDb250ZW50IjpbImNsYXNzIEFuaW1hbHtcclxuICAgIF93ZWlnaHQ6YW55O1xyXG4gICAgY29uc3RydWN0b3Iod2VpZ2h0KXtcclxuICAgICAgICB0aGlzLl93ZWlnaHQ9d2VpZ2h0O1xyXG4gICAgfVxyXG4gICAgd2VpZ2h0KCl7XHJcbiAgICAgICAgY29uc29sZS5sb2codGhpcy5fd2VpZ2h0KTtcclxuICAgIH1cclxuICAgIGVhdCgpe1xyXG4gICAgICAgIGNvbnNvbGUubG9nKCdBbmltYWwgZWF0Jyk7XHJcbiAgICB9XHJcbn1cclxuY2xhc3MgSHVtYW4gZXh0ZW5kcyBBbmltYWx7XHJcbiAgICBfbGFuZ3VhZ2U6c3RyaW5nO1xyXG4gICAgY29uc3RydWN0b3Iod2VpZ2h0LGxhbmd1YWdlKXtcclxuICAgICAgICBzdXBlcih3ZWlnaHQpOy8vd2VpZ2h0LT7rtoDrqqjtgbTrnpjsiqTsnZgg7IOd7ISx7J6Q66W8IO2Gte2VtOyEnCDqsJLsnYQg7KCA7J6lXHJcbiAgICAgICAgdGhpcy5fbGFuZ3VhZ2U9bGFuZ3VhZ2U7XHJcbiAgICB9XHJcbiAgICAvL+yYpOuyhOudvOydtOuUqS0+7J6Q7Iud7JeQ7IScIOu2gOuqqO2BtOuemOyKpOydmCDrqZTshJzrk5wg64K07Jqp7J2EIOyImOyglVxyXG4gICAgZWF0KCl7XHJcbiAgICAgICAgY29uc29sZS5sb2coJ0h1bWFuIGVhdCcpO1xyXG4gICAgfVxyXG4gICAgc3BlYWsoKXtcclxuICAgICAgICBjb25zb2xlLmxvZyhga29yZWFucyBzcGVhayAke3RoaXMuX2xhbmd1YWdlfWApO1xyXG4gICAgfVxyXG59XHJcbmNvbnN0IGtvcmVhbiA9IG5ldyBIdW1hbig3MCwnS29yZWFuJyk7Ly9uZXcg7YG0656Y7Iqk66qFKOyduOyImDEs7J247IiYMiwsLClcclxua29yZWFuLndlaWdodCgpOy8vNzBcclxua29yZWFuLmVhdCgpOy8vSHVtYW4gZWF0XHJcbmtvcmVhbi5zcGVhaygpOy8va29yZWFucyBzcGVhayBLb3JlYW5cclxuLy/qsJ3ssrTrqoUgaW5zdGFuY2VvZiDtgbTrnpjsiqTrqoU9dHJ1ZSBvciBmYWxzZVxyXG5jb25zb2xlLmxvZyhrb3JlYW4gaW5zdGFuY2VvZiBIdW1hbikgLy90cnVlXHJcbmNvbnNvbGUubG9nKGtvcmVhbiBpbnN0YW5jZW9mIEFuaW1hbCkgLy90cnVlXHJcbi8vbm9kZSBjbGFzc2V4dGVuZDMuanNcclxuIl19
