// 메뉴 슬라이드
function openNav() {
    document.getElementById('gnb').style.height = "263px"
}
function closeNav() {
    document.getElementById('gnb').style.height = "79px"
}

 // 지우기
function fnClean(type){
	var select = document.getElementsByName(type)
	var length = select.length
	for (i = 0; i < length; i++) {
		select[i].value = null
	}
}

// 추가
var count = 0;
function fnAdd(type){
	if(count<4){
		count++
		var table = document.getElementById(type+'_table')

		var th1 = document.createElement('th')
		var th2 = document.createElement('th')
		var th3 = document.createElement('th')
		var td1 = document.createElement('td')
		var td2 = document.createElement('td')

		th1.innerHTML = "자격면허"
		th2.innerHTML = "자격취득일"

		if(document.mainForm.license[0].value == ""){
			alert('자격면허 이름을 입력하세요.')
			document.mainForm.license[0].focus()
			return
		}else{
			td1.innerHTML = document.mainForm.license[0].value
		}
		if(document.mainForm.license[1].value == "" || document.mainForm.license[2].value == "" || document.mainForm.license[3].value == ""){
			alert('자격취득일을 정확하게 입력하세요.')
			return
		}else{
			td2.innerHTML = document.mainForm.license[1].value+"년 "+document.mainForm.license[2].value+"월 "+document.mainForm.license[3].value+"일"
		}
		
		// count값을 가진 삭제 버튼 추가
		th3.innerHTML = '<a onclick="fnDel('+count+');" class="del btn small">삭제하기</a>'

		var tr = document.createElement('tr')
		// tr에 id값을 count값을 포함해서 줌
		tr.setAttribute('id', 'license'+count)

		tr.appendChild(th1)
		tr.appendChild(td1)
		tr.appendChild(th2)
		tr.appendChild(td2)
		tr.appendChild(th3)

		var tbody = document.getElementById(type+'_tbody')
		tbody.appendChild(tr)

	}else{
		alert("자격증은 최대 4개까지 입력 가능합니다")
	}
	fnClean(type)
}

// 제거
function fnDel(num){
	var item = document.getElementById('license'+num)
	item.parentNode.removeChild(item)
}