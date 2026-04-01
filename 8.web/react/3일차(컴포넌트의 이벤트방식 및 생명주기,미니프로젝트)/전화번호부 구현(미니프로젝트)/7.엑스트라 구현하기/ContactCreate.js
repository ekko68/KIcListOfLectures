import React from 'react';

export default class ContactCreate extends React.Component{

   constructor(props){
     super(props);
     this.state={
        name:'',
        phone:''
     };
     //생성자에서 메서드 연결
     this.handleChange=this.handleChange.bind(this);
     this.handleClick=this.handleClick.bind(this);
     //추가
     this.handleKeyPress=this.handleKeyPress.bind(this);
   }
   //추가
   handleChange(e){
     let nextState ={}; //한개 이상이기에 빈객체를 먼저 생성
     nextState[e.target.name] = e.target.value;
     this.setState(nextState);
   }
   //추가
   handleClick(){
      const contact = {  //contact객체 생성
         name:this.state.name,
         phone:this.state.phone
      };
      this.props.onCreate(contact);
      this.setState({
        name:'',
        phone:''
      });
      //추가
      this.nameInput.focus();//ref가 지정되면 focus()사용이 가능
      //ref는 컴포넌트에도 이름을 설정할 수 있다.
   }
    //추가
    handleKeyPress(e){
      if(e.charCode==13){//enter라면
         this.handleClick();//호출하라
      }
    }
  render(){
      return (
          <div>
            <h2>Create Contact </h2>
            <p>
               <input type="text" name="name" placeholder="name"
                       value={this.state.name}
                      onChange={this.handleChange} 
                      ref={(ref)=>{this.nameInput=ref}}/>
               <input type="text" name="phone" placeholder="phone"
                       value={this.state.phone}
                       onChange={this.handleChange} 
                       onKeyPress={this.handleKeyPress} />
            </p>
            <button onClick={this.handleClick}>Create</button>
          </div>
      );
  }
}

//자식에서 입력받은 props값의 초기값을 설정한다.
/*
ContactCreate.propTypes={
   onCreate:React.propTypes.func
};

ContactCreate.defaultProps={
   onCreate:()=>{console.error('onCreate not defined!');}
}*/
