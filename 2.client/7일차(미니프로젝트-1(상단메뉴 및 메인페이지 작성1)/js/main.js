$(document).ready(function(){
    $('.nv1 div .main1,.sub').mouseover(function(){ //Shopping 에 마우스 오버
        $('.sub').css('display','block');//유형별 제품 출력
    });
    
    $('.nv1 div .main1,.sub').mouseout(function(){
        $('.sub').css('display',''); //유형별 제품 출력 안되게 설정
    });
    
    $('.a1,.sub1').mouseover(function(){ //유형별 제품에 마우스 오버
        $('.sub1').css('display','block');//유형별 항목이 나오게 설정
    });
    
    $('.a1,.sub1').mouseout(function(){//유형별 항목이 안나오게 설정
        $('.sub1').css('display','');
    });
});