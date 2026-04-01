import React from 'react';

//추가
import ContactInfo from './ContactInfo';
import ContactDetails from './ContactDetails';
import ContactCreate from './ContactCreate';
//추가2
import update from 'react-addons-update';

//
export default class Contact extends React.Component {
//추가
  constructor(props){
    super(props);
    this.state={
      //추가
      keyword:'', /* 검색 기억*/
      selectedKey: -1, //선택키 선언
      contactData:[
        {name:'홍길동',phone:'010-1234-0987'},
        {name:'테스트',phone:'010-4567-1234'},
        {name:'임시',phone:'010-8765-9876'},
        {name:'테스트2',phone:'010-5432-0987'}
      ]
    };
    //함수 연결
    this.handleChange=this.handleChange.bind(this);
    //함수추가
    this.handleClick=this.handleClick.bind(this);
    //추가(데이터를 추가,삭제,수정할 메서드 미리 bind)
    this.handleCreate=this.handleCreate.bind(this);
    this.handleRemove=this.handleRemove.bind(this);
    this.handleEdit=this.handleEdit.bind(this);
  }
  //추가 ->검색어에 입력을 하면 keyword에 저장되는 메서드 작성
  handleChange(e){
    this.setState({
      keyword:e.target.value
    });
  }
  //key값을 매개변수로 처리하는 함수 작성->state값을 수정할 예정
  handleClick(key){
    this.setState({
      selectedKey:key
    });
    console.log(key,' is selected');
  }
  //데이터 추가(contact를 매개변수로 받음)
  handleCreate(contact){
    this.setState({//1.집어넣을 데이터, 2.$push이용 한개라도 [ ]로 감싼다
       contactData:update(this.state.contactData,{$push:[contact]})
    });
  }

  handleRemove(){
    //추가 ->선택하지 않으면 삭제돼지 않게 설정
    if(this.state.selectedKey < 0){
      return;
    }
    this.setState({
      contactData:update(this.state.contactData,
            //$splice메서드를 이용해서 선택된키부터 1개를 삭제->역시
            //배열이기에 배열표시로 감싼다.
          {$splice:[[this.state.selectedKey,1]]}),
      selectedKey:-1 //추가로 -1 설정해 무효화함->다시 사용
    });
  }

  handleEdit(name,phone){
    this.setState({
        contactData:update(this.state.contactData,
        {
           [this.state.selectedKey]:{
             name: { $set:name },
             phone:{ $set:phone}
           }
        }
      )
    });
  }
    render(){
      //화살표함수를 이용
      const mapToComponents=(data)=>{
        //data=data.sort();
        data=data.filter(
          (contact)=>{
            return contact.name.indexOf(this.state.keyword) > -1;
          }
        );
           //새로운 배열을 받아서 리턴하는 함수 작성
           //data는 매개변수로 contact데이터 받아들이고 인덱스 i(요소)
           return data.map((contact,i)=>{ //key->각 데이터의 identity
             return (<ContactInfo contact={contact} key={i}
                     onClick={()=>this.handleClick(i)}/>);
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
            <ContactDetails
            isSelected={this.state.selectedKey != -1}
            contact={this.state.contactData[this.state.selectedKey]}
            onRemove={this.handleRemove}
            onEdit={this.handleEdit} />
            <ContactCreate
               onCreate={this.handleCreate}
            />
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
