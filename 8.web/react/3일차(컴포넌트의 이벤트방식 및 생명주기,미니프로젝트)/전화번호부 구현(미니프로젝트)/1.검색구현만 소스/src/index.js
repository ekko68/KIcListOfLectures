import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';//App.js 확장자는 생략 가능

//상수로 root엘리먼트를 담는다.
const rootElement = document.getElementById('root');

ReactDOM.render(<App />, rootElement);

