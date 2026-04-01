	window.onload=function(){					
				var i=0.1;
				var hide_img=document.getElementById("hide_img");
				var show_img=document.getElementsByClassName("cycle-slideshow");
				var sec=document.getElementById("content_wrap");
				var content=document.getElementById("content");
				var foot=document.getElementById("footer");

			
				function ani(){   
					setTimeout(function(){
							show_img[0].style.background="#fff";
							sec.removeChild(hide_img);

							itv=setInterval(increase,98);    //0.098초마다 increase()함수를 실행.
						},2900);   //2.7초후에 처음등장하는 애니메이션 이미지가 사라지고, 두번째 슬라이드 이미지등장			
				}

				function increase(){
					i+=0.1;
					if(i >= 1)
						clearInterval(itv);  // i의 값이 1이거나 1보다 크면은 setInterval()함수 종료
					show_img[0].style.opacity=i; // i의 값을 opacity값으로 넣어서 
					content.style.opacity=i;	
					foot.style.opacity=i;
				}
			return ani();
			}