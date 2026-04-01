import React from 'react';

export default class ContactDetails extends React.Component{
    //생성자->초기화
    constructor(props){
        super(props);
        this.state={//1.현재 상태(편집모드) 2.변경된 값 name,phone
          isEdit:false, //편집유무 체크
          name:'',
          phone:''
        };
        this.handleToggle = this.handleToggle.bind(this);
        //수정해주는 메서드이벤트를 연결
        this.handleChange = this.handleChange.bind(this); 
        //추가(실질적인 수정)
        this.handleEdit = this.handleEdit.bind(this);
        //추가2
        this.handleKeyPress = this.handleKeyPress.bind(this);
    }
    handleToggle(){//edit or ok
        //추가->false->true(ok)
        if(!this.state.isEdit){ //버튼이 ok로 바뀌면서 수정상태(편집상태)
          this.setState({
              name:this.props.contact.name,
              phone:this.props.contact.phone
          });
        }else{//false=>내용을 수정하고 ok버튼->false->다음거 수정할 준비
           this.handleEdit();
        }
        //
        this.setState({ //토글기능
            isEdit:!this.state.isEdit
        });
        console.log(!this.state.isEdit)
    }
    //추가2
    handleEdit(){//onEdit={this.handleEdit} />
        //부모로부터 전달받은 함수를 호출하고 수정할 데이터를 전송
        this.props.onEdit(this.state.name,this.state.phone);
    }
    //추가->ContactCreate와 동일
    handleChange(e){
        let nextState = {}
         nextState[e.target.name] = e.target.value
         this.setState(nextState);
    }
    //추가2
    handleKeyPress(e){ //마우스의 좌표,특정키의 정보(charCode) 키코드값
        if(e.charCode==13){//enter를 치는 경우
           this.handleToggle();//데이터 수정하는 함수호출
        }
      }
    //
    render(){
        //추가
        //const details=(<div>Selected !!!</div>);
        const details=( //상세보기
             <div>
                <p>{this.props.contact.name}</p>
                <p>{this.props.contact.phone}</p>
             </div>
        );
        //추가->화면에 보여줄 부분
        //추가->ContactCraete에서 복사
        const edit=(
            <div>
            <p>
              <input type="text" name="name" placeholder="name" 
                     value={this.state.name}
                     onChange={this.handleChange}/>
              <input type="text" name="phone" placeholder="phone"
                     value={this.state.phone}
                     onChange={this.handleChange}
                     onKeyPress={this.handleKeyPress} />
            </p>
          </div>
        );
        const view = this.state.isEdit?edit:details;
        const blank=(<div>Not Selected !!!</div>);
        return( //onRemove={this.handleRemove}
               <div>
                   <h2>Details</h2>
                {this.props.isSelected?view:blank}
                <p /> 
                <button onClick={this.handleToggle}>
                    {this.state.isEdit?'OK':'Edit'}
                </button>
                <button onClick={this.props.onRemove}>Remove</button>  
               </div>
              );
    }
}
//형식)->props값을 전달->자식 못받는경우 발생->초기값
//자식클래스명.defaultProps={키:초기값,~}
ContactDetails.defaultProps={
    //1.부모로 넘어오는 값이 데이터(문자열,숫자,객체)->초기값을 설정
    contact:{
        name:'',
        phone:'' //,age=0,address='',,,
    },
    //2.부모로 넘오오는 값이 함수인 경우->에러메세지를 출력 코딩
    onRemove:()=>{console.error('onRemove not defined')}
};