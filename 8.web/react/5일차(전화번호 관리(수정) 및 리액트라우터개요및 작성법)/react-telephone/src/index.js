//src/components에 저장된 컴포넌트들을 모두 불러와서 div태그에 결합역할
import React from 'react';//react.js
//import {React} from 'react';
import ReactDOM from 'react-dom';//react-dom.js
//다음부터가 당신이 화면에 출력하고자하는 컴포넌트를 불러오기
import App from './components/App';//App.js

//<div id="root"></div>
//getElementById->querySelector('부착시킬 id')
const rootElement = document.getElementById('root');//div태그 정보
//ReacDOM.render(1.화면에 결합시킬 컴포넌트명(<태그명 />)) 2.부착시킬 위치
ReactDOM.render(<App />,rootElement);
