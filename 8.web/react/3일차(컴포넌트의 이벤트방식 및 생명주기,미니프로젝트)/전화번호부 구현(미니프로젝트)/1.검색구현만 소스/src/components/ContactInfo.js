import React from 'react';
//추가
//import Contact from './Contact';

export default class ContactInfo extends React.Component{
    render(){
        return(
            <div>
              {this.props.contact.name}
            </div>
        );
    }
}