import React from 'react';
//추가
import ContactInfo from './ContactInfo';
import ContactDetails from './ContactDetails';
import ContactCreate from './ContactCreate';
//추가(update)
import update from 'react-addons-update';
//------------------------------------------
export default class Contacts extends React.Component{
    //(3)생성자->초기값을 설정 
    constructor(props){
        super(props);
        //따로 배열형태로 데이터 저장
        this.state={ //state->변동사항이 있는 데이터를 저장(state)
            //추가
            keyword:'', //검색할 값을 기억할 변수선언
            //추가2
            selectedKey:-1,
            contactData:[ //contact={this.state.contactData[0]}
                {name:"홍길동", phone:"010-123-0987"},
                {name:"임시", phone:"010-456-0987"},
                {name:"테스트", phone:"010-987-1234"},
                {name:"테스트2", phone:"010-765-1111"}
            ]
            //selectedKey:-1
        };
        //생성자
        this.handleChange = this.handleChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
        //추가,수정,삭제
        this.handleCreate = this.handleCreate.bind(this);//추가
        this.handleEdit = this.handleEdit.bind(this);//수정
        this.handleRemove = this.handleRemove.bind(this);//삭제
    }
    //검색어가 변경될때마다 호추할 함수 선언
    handleChange(e){   //event객체->이벤트발생시킨 컴포넌트를 얻어올때
      this.setState({keyword:e.target.value}) //e.target.name=>input박스, e.taget.value
    }
    //항목을 클릭했을때 항목의 인덱스번호출력
    handleClick(key){
        //this.state.selectedKey=1;//사용X
        this.setState({
            selectedKey:key
        });
        console.log(key,'is selected');
    }
    //데이터추가->ContactCreate
    handleCreate(contact){ //name,phone,age,address
       this.setState({
           //1.집어넣어줄 데이터(객체),2.$push이용->값저장->[]로 묶어줘야 된다.
           //배열객체명:update(1,2)
           contactData:update(this.state.contactData,{$push:[contact]})
       });
       console.log('contact의 handleCreate호출됨!',contact)
       //[Object Object]
       console.log('contact.name,contact.phone=>',contact.name,contact.phone)
    }
    //데이터 삭제->this.state.selectedKey을 이용
    handleRemove(){
      //삭제하면 안되는 조건->-1(선택하지 않았다면)
      if(this.state.selectedKey < 0){
          return;//함수종료
      }
      this.setState({
        contactData:update(this.state.contactData,
            //1.현재 선택된 객체항목의 인덱스번호,삭제할 갯수
            //선택된키로부터 1개를 삭제->역시 배열이기에 배열표시로 해준다.
            {$splice:[[this.state.selectedKey,1]]}),
            selectedKey:-1 //추가로 -1 설정해->다시 초기화 사용가능 
      });
    }
    
    //$set->키값에 해당하는 값을 변경
    handleEdit(name,phone){
        this.setState({
            contactData:update(this.state.contactData,
                {  //수정할 인덱스번호
                  [this.state.selectedKey]:{
                      name:{$set:name}, //name(키명):{$set:수정할값}
                      phone:{$set:phone}//, age:{$set:age},,,
                  }
                }
            )
       });
     }
    //render()호출전에 호출하는 초기화함수
    componentWillMount(){  //localStorage.키명(contactData)
      const contactData = localStorage.contactData;
      if(contactData){//불러올 데이터가 존재한다면
        this.setState({//텍스트문자열->객체로 바꾸어서 this.state에 저장
            contactData:JSON.parse(contactData)
        })
      }
      console.log('componentWillMount()호출됨!')
    }
     //화면에 데이터를 수정할때마다
    componentDidUpdate(prevProps,prevState){//revStat(이전의 state값)
        //이미 저장된 과거의 데이터와 현재 데이터가 다르면
      if(JSON.stringify(prevState.contactData)!=JSON.stringify(this.state.contactData)){
         localStorage.contactData=JSON.stringify(this.state.contactData);
      }
      console.log('componentDidUpdate()호출됨')
    }
    //----------------------------------------------------------
    render(){
        //화살표함수를 이용 따로 함수호출
        const mapToComponents=(data)=>{ //data=>this.state.contactData의미
          //1.배열의 값을 정렬->배열객체명.sort()
          //2.특정배열의 값을 찾을때 사용->filter()이용
          data=data.sort();
          //contact.name(배열의 각 이름).indexOf(찾는값)->못찾으면 -1이 리턴
          //-1보다 크다는 얘기->조건에 만족하는 데이터를 찾았다면 리턴(data)
          data=data.filter((contact)=>{
              return contact.name.indexOf(this.state.keyword) > -1;
          })
          //-----------------------------------------------------
          return data.map((contact,i)=>{
              return(<ContactInfo contact={contact} key={i}
                                  onClick={()=>this.handleClick(i)}/>);
          })
        }
        //검색항목을 만들어주자 (onChange)=handelChange($event) />
        return( 
           <div>
               <h1>전화번호부 목록</h1>
               <input name="keyword" placeholder="search"  value={this.state.keyword}
                 onChange={this.handleChange} />
              <div>
                {mapToComponents(this.state.contactData)}
                <ContactDetails isSelected={this.state.selectedKey!=-1}
                     contact={this.state.contactData[this.state.selectedKey]}
                     onRemove={this.handleRemove}
                     onEdit={this.handleEdit} />
                <ContactCreate onCreate={this.handleCreate} />
              </div>
           </div>
        );
    }
}