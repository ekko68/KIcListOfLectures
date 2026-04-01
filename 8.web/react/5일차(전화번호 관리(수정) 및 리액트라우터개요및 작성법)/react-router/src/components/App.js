
import React from 'react'// import 클래스명 from '불러올 경로 명 및 파일명'
//추가
import {Link} from 'react-router';

//App->링크를 걸 수 있도록 화면 디자인 <a href X) <Link> 요청처리
class App extends React.Component{
  render(){
      return(
        <div>
         <ul>
          <li><Link to="/home">Home</Link></li>
          <li><Link to="/about">About</Link></li>
          <li><Link to="/contact">Contact</Link></li>
         </ul>
         {this.props.children}
        </div>
      );
  }
}
export default App;