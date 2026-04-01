function openNav() {
    //document.getElementById("navUl").style.width = "250px";
    $('#navUl').css('right','0')
    $('#navUl').on('scroll touchmove mousewheel', function(event){
        event.preventDefault();
        event.stopPropagation();
        return false;
    });
    //$('.menu').css('display','block')
    //$('.menu').css({ display: none, transition: 0.3s })
    //$('.login').css('display','block')
}

function closeNav() {
    $('#navUl').css('right','-20vw')
    $('#navUl').off('scroll touchmove mousewheel');
    //$('#navUl').css('width','0')
    //$('.menu').css('display','none')
    //$('.login').css('display','none')    
}



function loginPopup() {
    $('#modal_login').css('display','flex');    
    $('#modal_login').on('scroll touchmove mousewheel', function(event){
        event.preventDefault();
        event.stopPropagation();
        return false;
    });
}


function closePopup() {
    $('#modal_login').css('display','none');    
    $('#modal_login').off('scroll touchmove mousewheel');
}







/*

$(document).ready(function(){
    
    var modal = document.getElementById('modal_login');    
    
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

});
*/










/*function openCosInfo(){
    $('#cosInfo').css('left','0')
    $('#wrap').css('marginLeft','25vw')
    $('#wrapBg').css('display','block')
    //$('.closebtn').css('right','0')
}

function closeCosInfo(){
    $('#cosInfo').css('left','-28vw')
    $('#wrap').css('marginLeft','0')
    $('#wrapBg').css('display','none')
    //$('.closebtn').css('right','12vw')
    //$('#wrapBg').css('backgroundColor','rgba(0,0,0,0)')
}
*/