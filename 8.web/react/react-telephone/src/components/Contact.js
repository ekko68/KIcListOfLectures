import React from 'react';
//추가
import ContactInfo from './ContactInfo';

export default class Contacts extends React.Component{
    //(3)생성자->초기값을 설정 
    constructor(props){
        super(props);
        //따로 배열형태로 데이터 저장
        this.state={
            //추가
            keyword:'', //검색할 값을 기억할 변수선언
            contactData:[
                {name:"홍길동", phone:"010-123-0987"},
                {name:"임시", phone:"010-456-0987"},
                {name:"테스트", phone:"010-987-1234"},
                {name:"테스트2", phone:"010-765-1111"}
            ]
        };
        //생성자
        this.handleChange = this.handleChange.bind(this);
    }
    //검색어가 변경될때마다 호추할 함수 선언
    handleChange(e){   //event객체->이벤트발생시킨 컴포넌트를 얻어올때
      this.setState({keyword:e.target.value}) //e.target.name=>input박스, e.taget.value
    }
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
              return(<ContactInfo contact={contact} key={i}/>);
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
              </div>
           </div>
        );
    }
}