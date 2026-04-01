import React from 'react';
//var React = require('react')와 동일
import Contact from './Contact'

class App extends React.Component {
    render(){
        return (
              <div>
                <h1>리액트 연습</h1>
                <Contact />
              </div>
        );
    }
}

export default App; //다른 클래스에서도 불러올 수 있도록 export 시킨다.es6
//es5로 변환이 된다면 module.export=App;