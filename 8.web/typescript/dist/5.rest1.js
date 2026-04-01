//함수를 작성할때 매개변수를 전달할때->매개변수 전달X->에러유발
//만약에 매개변수를 전달 받지 못할경우에는 디폴트 매개변수값을 지정이 가능
//->rest 매개변수->매개변수값이 정상적으로 전달되면 적용이 안된다.
function plus(x, y) {
    if (x === void 0) { x = 0; }
    if (y === void 0) { y = 0; }
    return x + y;
}
console.log('plus()->', plus()); //값이 전달->디폴트 매개변수(=rest 매개변수)
console.log('plus(1,2)->', plus(1, 2));

//# sourceMappingURL=data:application/json;charset=utf8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIjUucmVzdDEudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEscUNBQXFDO0FBQ3JDLDBDQUEwQztBQUMxQyx5Q0FBeUM7QUFFekMsY0FBYyxDQUFLLEVBQUMsQ0FBSztJQUFYLGtCQUFBLEVBQUEsS0FBSztJQUFDLGtCQUFBLEVBQUEsS0FBSztJQUNyQixNQUFNLENBQUMsQ0FBQyxHQUFDLENBQUMsQ0FBQztBQUNmLENBQUM7QUFDRCxPQUFPLENBQUMsR0FBRyxDQUFDLFVBQVUsRUFBQyxJQUFJLEVBQUUsQ0FBQyxDQUFDLENBQUEsNkJBQTZCO0FBQzVELE9BQU8sQ0FBQyxHQUFHLENBQUMsYUFBYSxFQUFDLElBQUksQ0FBQyxDQUFDLEVBQUMsQ0FBQyxDQUFDLENBQUMsQ0FBQyIsImZpbGUiOiI1LnJlc3QxLmpzIiwic291cmNlc0NvbnRlbnQiOlsiLy/tlajsiJjrpbwg7J6R7ISx7ZWg65WMIOunpOqwnOuzgOyImOulvCDsoITri6ztlaDrlYwtPuunpOqwnOuzgOyImCDsoITri6xYLT7sl5Drn6zsnKDrsJxcclxuLy/rp4zslb3sl5Ag66ek6rCc67OA7IiY66W8IOyghOuLrCDrsJvsp4Ag66q77ZWg6rK97Jqw7JeQ64qUIOuUlO2PtO2KuCDrp6TqsJzrs4DsiJjqsJLsnYQg7KeA7KCV7J20IOqwgOuKpVxyXG4vLy0+cmVzdCDrp6TqsJzrs4DsiJgtPuunpOqwnOuzgOyImOqwkuydtCDsoJXsg4HsoIHsnLzroZwg7KCE64us65CY66m0IOyggeyaqeydtCDslYjrkJzri6QuXHJcblxyXG5mdW5jdGlvbiBwbHVzKHggPSAwLHkgPSAwKXtcclxuICAgIHJldHVybiB4K3k7XHJcbn1cclxuY29uc29sZS5sb2coJ3BsdXMoKS0+JyxwbHVzKCkpOy8v6rCS7J20IOyghOuLrC0+65SU7Y+07Yq4IOunpOqwnOuzgOyImCg9cmVzdCDrp6TqsJzrs4DsiJgpXHJcbmNvbnNvbGUubG9nKCdwbHVzKDEsMiktPicscGx1cygxLDIpKTsiXX0=
