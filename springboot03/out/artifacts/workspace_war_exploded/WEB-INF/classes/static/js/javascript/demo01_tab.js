const Tabs=antd.Tabs;
const TabPane = antd.Tabs.TabPane;
const FormItem = antd.Form.Item;
function callback(key){
    console.log(key);
}
/**
 * Tab Component include three Pagination
 */
class HzdTab extends React.Component{

    render(){
        return (
            <div>
                <Tabs>
                    <TabPane tab="实时数据" key="1"></TabPane>
                    <TabPane tab="电压变化趋势" key="2"></TabPane>
                    <TabPane tab="水压变化趋势" key="3"></TabPane>
                </Tabs>
            </div>
        );
    }
}
ReactDOM.render(
    <div>
        <HzdTab/>
    </div>
    ,document.getElementById("appHzd"));