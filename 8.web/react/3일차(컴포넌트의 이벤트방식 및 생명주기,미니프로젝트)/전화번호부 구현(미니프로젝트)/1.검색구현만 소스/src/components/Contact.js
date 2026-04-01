import React from 'react';

//추가
import ContactInfo from './ContactInfo';

export default class Contact extends React.Component {
//추가 
  constructor(props){
    super(props);
    this.state={
      //추가
      keyword:'', /* 검색 기억*/
      contactData:[
        {name:'홍길동',phone:'010-1234-0987'},
        {name:'테스트',phone:'010-4567-1234'},
        {name:'임시',phone:'010-8765-9876'},
        {name:'테스트2',phone:'010-5432-0987'}
      ]
    };
    //함수 연결
    this.handleChange=this.handleChange.bind(this);
  }
  //추가 ->검색어에 입력을 하면 keyword에 저장되는 메서드 작성
  handleChange(e){
    this.setState({
      keyword:e.target.value
    });
  }
  //
    render(){
      //화살표함수를 이용
      const mapToComponents=(data)=>{
        data=data.sort();
        data=data.filter(
          (contact)=>{
            return contact.name.indexOf(this.state.keyword) > -1;
          }
        );
           //새로운 배열을 받아서 리턴하는 함수 작성
           //data는 매개변수로 contact데이터 받아들이고 인덱스 i(요소)
           return data.map((contact,i)=>{ //key->각 데이터의 identity
             return (<ContactInfo contact={contact} key={i} />);
           });
      };
        return(
          <div>
          <h1>전화번호 부</h1>
          <input name="keyword" placeholder="Search"
                 value={this.state.keyword} 
                 onChange={this.handleChange} />
           <div>
            {mapToComponents(this.state.contactData)}
            {/*
            <div>홍길동 010-1234-0987</div>
            <div>테스트 010-4567-1234</div>
            <div>임시 010-8765-9876</div>
            <div>테스트2 010-5432-0987</div> */ }
            </div>
          </div>
        );
    }
}
//export default Contact;