class HelloMessage extends React.Component {
    render() {
        return (
            <div>
                <Child name2={this.props.name1}/>
            </div>
        );
    }
}
class Child extends React.Component {
    render() {
        return (
            <div>
                {this.props.name2}
            </div>
        );
    }
}
ReactDOM.render(
    <HelloMessage name1="name1" />,
    document.getElementById("container01_props")
);