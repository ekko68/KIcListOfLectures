import React from 'react';
//import {React} from 'react';
import ReactDOM from 'react-dom';
//추가
import {Router,Route,browserHistory,Link,IndexRoute} from 'react-router';

//다음부터가 당신이 화면에 출력하고자하는 컴포넌트를 불러오기
import App from './components/App';//App.js
import Home from './components/Home';
import About from './components/About';
import Contact from './components/Contact';

const rootElement = document.getElementById('root');

ReactDOM.render((
   <Router history={browserHistory}>
      <Route path="/" component={App}>
         <IndexRoute component={Home} />
         <Route path="home" component={Home} />
         <Route path="about" component={About} />
         <Route path="contact" component={Contact} />
       </Route>
   </Router>    
),rootElement);
