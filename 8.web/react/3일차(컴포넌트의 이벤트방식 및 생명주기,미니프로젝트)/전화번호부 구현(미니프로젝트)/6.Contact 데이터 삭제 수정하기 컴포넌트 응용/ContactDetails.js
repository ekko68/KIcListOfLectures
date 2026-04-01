import React from 'react';

export default class ContactDetails extends  React.Component{
    //추가
    constructor(props){
        super(props);
        this.state={
            isEdit:false,
            name:'',
            phone:''
        };
        this.handleToggle=this.handleToggle.bind(this);
        this.handleChange=this.handleChange.bind(this);
        //추가
        this.handleEdit=this.handleEdit.bind(this);
    }
    handleToggle(){
        //추가
        if(!this.state.isEdit){//false라면->true
          this.setState({
              name:this.props.contact.name,
              phone:this.props.contact.phone
          });
        }else{//false인 경우
            this.handleEdit();
        }

        this.setState({
            isEdit:!this.state.isEdit
        });//위의 setState가 실행되기전에 밑의 코드가 실행된다.
        console.log(!this.state.isEdit);//그래서 앞에 !을 준다
    }
    //추가(ContactCreate에서 복사해 온다.)
    handleChange(e){
     let nextState ={}; //한개 이상이기에 빈객체를 먼저 생성
     nextState[e.target.name] = e.target.value;
     this.setState(nextState);
   }
    //추가
    handleEdit(){
        this.props.onEdit(this.state.name,this.state.phone);
    }
    render(){
        //추가
        const details=(
        <div>
           <p>{this.props.contact.name}</p>
           <p>{this.props.contact.phone}</p>
        </div>);
        //추가
        //const view=this.state.isEdit ? (<div></div>):details;
        //추가
        const edit=(
             <div>
              <p>
               <input type="text" name="name" placeholder="name"
                       value={this.state.name}
                      onChange={this.handleChange} />
               <input type="text" name="phone" placeholder="phone"
                       value={this.state.phone}
                       onChange={this.handleChange} />
               </p>
             </div>
        );
        const view=this.state.isEdit ? edit:details;
        const blank=(<div>Not Selected!</div>);
        return(
            <div>
                <h2>Details</h2>
              {this.props.isSelected ? view : blank}
              <p>
               <button onClick={this.handleToggle}>
                   {this.state.isEdit ? 'OK':'Edit'}
               </button>
               <button onClick={this.props.onRemove}>Remove </button>
              </p>
            </div>
        );
    }
}
ContactDetails.defaultProps={
    contact:{
         name:'',
         phone:''
    },
    onRemove: ()=>{ console.error('onRemove not defined');},
    //추가
    onEdit: ()=>{ console.error('onEdit not defined');}
};
//추가 안해도 된다.
ContactDetails.propTypes={
    contact:React.PropTypes.object,
    onRemove:React.PropTypes.func,
    onEdit:React.PropTypes.func
}