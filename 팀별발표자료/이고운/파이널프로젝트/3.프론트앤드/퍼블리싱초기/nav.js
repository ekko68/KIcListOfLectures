function openNav() {
    //document.getElementById("navUl").style.width = "250px";
    $('#navUl').css('right','0')
    //$('.menu').css('display','block')
    //$('.menu').css({ display: none, transition: 0.3s })
    //$('.login').css('display','block')
}

function closeNav() {
    $('#navUl').css('right','-20vw')
    //$('#navUl').css('width','0')
    //$('.menu').css('display','none')
    //$('.login').css('display','none')    
}

function openCosInfo(){
    $('#cosInfo').css('left','0')
    $('#wrap').css('marginLeft','25vw')
    $('#wrapBg').css('display','block')
}

function closeCosInfo(){
    $('#cosInfo').css('left','-26vw')
    $('#wrap').css('marginLeft','0')
    $('#wrapBg').css('display','none')
    //$('#wrapBg').css('backgroundColor','rgba(0,0,0,0)')
}