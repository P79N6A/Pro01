import React from 'react';
import ReactDOM from 'react-dom';
require('../css/tab.css');

class App extends React.Component{
    render(){
        return(
            <TabController>
                <section name='red'>我是红色</section>
                <section name='blue'>我是蓝色</section>
                <section name='yellow'>我是黄色</section>
                <section name='green'>我是绿色</section>
            </TabController>
        )
    }
}

class TabController extends React.Component{
    constructor(props){
        super(props);
        this.state={
            currentIndex:0
        }
    }
    render(){
        return(
            <div className='tab-container'>
                <nav className='nav-tab'>
                    {React.Children.map(this.props.children,(element,index)=>(<div onClick={this.changeTab.bind(this,index)} className={this.addTitleClass(index)}>{element.props.name}</div>))}
                </nav>
                <div>
                    {React.Children.map(this.props.children,(element,index)=>(<div className={this.addContentClass(index)}>{element}</div>))}
                </div>
            </div>
        )
    }
    addTitleClass(index){
        return index==this.state.currentIndex?'tab-title tab-title-shown':'tab-title';
    }
    addContentClass(index){
        return index==this.state.currentIndex?'tab-content shown':'tab-content';
    }
    changeTab(index){
        this.setState({
            currentIndex: index
        })
    }
}
ReactDOM.render(<App />,document.getElementById('container'));