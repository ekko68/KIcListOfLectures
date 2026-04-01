import React from 'react';
//사용자로부터 값을 입력폼
export default class ContactCreate extends React.Component{
    //생성자->일시적으로 입력한 값을 전달하기전까지는 this.state저장
    constructor(props){
        super(props);
        this.state={
            name:'',
            phone:''
        };
        //생성자 bind
        this.handleChange = this.handleChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
        //추가2
        this.handleKeyPress = this.handleKeyPress.bind(this);
    }
    //
    handleChange(e){  //contact->부모에게 전달 {}
                      // {name:'이민수',phone:'010-234-0981'}
    let nextState = {}
    //nextState[name]='이민수'->{name:'이민수'}
    //nextState[phone]='010-123-0983'
     nextState[e.target.name] = e.target.value
     this.setState(nextState);
    }
    handleClick(){
     //자기 클래스(name,phone)=>객체->contact->부모함수에게 매개변수를 전달
     const contact={
         name:this.state.name,//handleChange에 의해서 저장된 이름
         phone:this.state.phone
     };
     //부모의 함수 <ContactCreate onCreate={this.handleCreate} />
     this.props.onCreate(contact);//호출
     //다시 입력을 받기위해서 초기화
     this.setState({
        name:'',
        phone:''
     });
     //다입력을 하고나서
     this.nameInput.focus()
     console.log('this.phoneInput.value=>',this.phoneInput.value)
    }
    //추가2
    handleKeyPress(e){ //마우스의 좌표,특정키의 정보(charCode) 키코드값
      if(e.charCode==13){//enter를 치는 경우
         this.handleClick();//데이터입력하는 함수(부모)
      }
    }
    //------------------------------
    render(){
       return(
         <div>
           <h2>Create Contact</h2>
           <p>
             <input type="text" name="name" placeholder="name" 
                    value={this.state.name}
                    onChange={this.handleChange}
                    ref={(ref)=>{this.nameInput=ref}}/>
             <input type="text" name="phone" placeholder="phone"
                    value={this.state.phone}
                    onChange={this.handleChange}
                    onKeyPress={this.handleKeyPress}
                    ref={(ref)=>{this.phoneInput=ref}}/>
           </p>
           <button onClick={this.handleClick}>Create </button>
         </div>
       );
    }
}