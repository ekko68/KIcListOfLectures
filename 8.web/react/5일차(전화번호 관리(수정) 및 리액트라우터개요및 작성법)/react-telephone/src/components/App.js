
import React from 'react';

import Contact from './Contact';
class App extends React.Component{
  render(){
      //화면에 출력할 수 있도록 element하는 반환
      return(
       <div>
        <h1>리액트연습</h1>
        <Contact />
       </div>
      );
  }
}
export default App;