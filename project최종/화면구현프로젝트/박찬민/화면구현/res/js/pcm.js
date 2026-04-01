// 사이드메뉴를 클릭해서 홈, 스케쥴, 등록 으로 이용할때 부드럽게 이동하게 하기 위한 코드
$(document).ready(function() {
    // smooth scroll
    $('#link-menu-1').click(function(event) {
        event.preventDefault();
        var id = $(this).attr("href");
        var offset = 60;
        var target = $(id).offset().top - offset;
        $('html, body').animate({scrollTop:target}, 500);
    });
    $('#link-menu-2').click(function(event) {
        event.preventDefault();
        var id = $(this).attr("href");
        var offset = 60;
        var target = $(id).offset().top - offset;
        $('html, body').animate({scrollTop:target}, 500);
    });
    $('#link-menu-3').click(function(event) {
        event.preventDefault();
        var id = $(this).attr("href");
        var offset = 60;
        var target = $(id).offset().top - offset;
        $('html, body').animate({scrollTop:target}, 500);
    });

    // 화면이 작을때 나타나는 top버튼을 눌렀을 때, 부드럽게 최상단으로 이동하기 위한 코드.
    $('#pcm-id-gotop').click(function(event) {
        event.preventDefault();
        var id = $(this).attr("href");
        var offset = 60;
        var target = $(id).offset().top - offset;
        $('html, body').animate({scrollTop:target}, 500);
    });

});

// 스크롤 위치를 읽어서 헤더가 가려지는 시점에 화면 상단에 행사 이름, 날짜, 장소를 표시하는 배너를 넣기 위한 코드
$(window).scroll(function () {
			var height = $(document).scrollTop();

            if(height > 500){
                $('.pcm-top-banner').css('display','block');
            }else{
                $('.pcm-top-banner').css('display','none');
            }
			
});

function doRegister() {
    // 입력폼 값 가져오기
    var name = document.getElementById('pcm-id-reg-name').value;
    var email = document.getElementById('pcm-id-reg-email').value;
    var pwd1 = document.getElementById('pcm-id-reg-pwd1').value;
    var pwd2 = document.getElementById('pcm-id-reg-pwd2').value;
    var phone = document.getElementById('pcm-id-reg-phone').value;
    var job = document.getElementById('pcm-id-reg-job').value;
    var news = document.getElementById('pcm-id-reg-news').checked;

    console.log(name,email,pwd1,pwd2,phone,job,news);

    // 제약사항 확인
    //(1) 빈칸있는지 확인
    if(!name || !email || !pwd1 || !pwd2 || !phone) {
        alert('모든 항목을 입력해주세요~ ^^');
        return;
    }
    //(2) 비밀번호 제약조건 확인
    if(pwd1.length < 6 || pwd1.length > 16){
        alert('비밀번호는 6자 이상, 16자 이하로 입력하셔야합니다.');
        return;
    }
    //(3) 비밀번호 일치 확인
    if(pwd1 != pwd2) {
        alert('비밀번호가 일치하지 않습니다.');
        document.getElementById('pcm-id-reg-pwd1').focus();
        return;
    }

    // 제약사항을 통과하면 등록확인 메세지 출력
    document.getElementById('pcm-id-reg-okay').innerHTML = name+'님,<br>등록이 완료되었습니다.'
    document.getElementById('pcm-id-form').reset();
    document.getElementById('pcm-id-reg-pwd-eq').innerHTML = '';
}

// 암호를 입력하는 두개의 칸을 다 채우고 나면 onchange함수로 두 값의 일치 여부를 바로 표시함.
function checkPwdEq() {
    var notice = document.getElementById('pcm-id-reg-pwd-eq');
    var pwd1 = document.getElementById('pcm-id-reg-pwd1').value;
    var pwd2 = document.getElementById('pcm-id-reg-pwd2').value;

    if(pwd1 != pwd2) {
        notice.style.fontSize = '10pt';
        notice.style.color='red';
        notice.innerHTML='암호 불일치';
    }else{
        notice.style.fontSize = '10pt';
        notice.style.color='green';
        notice.innerHTML='암호 일치';
    }
}

// 화면이 작을때 나타나는 top버튼을 눌렀을 때, 맨 위로 이동시키기 위한 함수
function goToTop() {
    location.href="#pcm-id-home";
}