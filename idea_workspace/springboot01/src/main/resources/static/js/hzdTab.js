/**
 * @author 15computer huangZeDong
 * @date
 */

/*
function getdata(d){
    alert(d.data.id);      //弹出111
}
*/

const Pagination=antd.pagination;
let devId = 6068;
let equLocation="";
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
            <Tabs>
                <TabPane tab="实时数据" key="1"><TabTable/></TabPane>
            </Tabs>
        )
    }
}

/**
 * Search keywords in the first paging - fuzzy query
 */
class SearchFormKeyWord extends  React.Component{
    state = {
        expand: false,
    };
    handleSearch = (e) => {
        e.preventDefault();
        var params = $("#searchForm").serialize();//获取表单内容
        params = decodeURIComponent(params,true);//变为中文
        // params = encodeURI(encodeURI(params));//变为传递给后台代码的变量
        params=params.substring(params.indexOf('=')+1,params.length);
        this.props.getClickCondions(params);//引用父组件的方法
    }

    handleReset = () => {
        this.props.form.resetFields();
    }

    handleHzdClick = () => {
        $("#dataTable").slideUp(500);
    }


    toggle = () => {
        const { expand } = this.state;
        this.setState({ expand: !expand });
    }

    getFields() {
        const count = this.state.expand ? 10 : 6;
        const { getFieldDecorator } = this.props.form;
        const children = [];
        children.push(
            <label>设备ID:{this .props.equLocation}</label>,
            <FormItem label={`关键字`} >
                {getFieldDecorator('关键字', {
                    rules: [{
                        required: false,
                        message: '请输入',
                    }],
                })(
                    <antd.Input placeholder="请输入..." name={'关键字'} />
                )}
            </FormItem>
        );
        return children;
    }
    render (){
        return (
            <antd.Form className="ant-advanced-search-form" id="searchForm" layout="inline">
                <antd.Row gutter={24}>
                    {this.getFields()}
                    <antd.Button id="id-equipmentLszSearch" type="primary"  onClick={this.handleSearch}>查找</antd.Button>
                    <antd.Button style={{ marginLeft: 8 }} onClick={this.handleReset}>清除</antd.Button>
                    <antd.Button id="hzdCloseTab" onClick={this.handleHzdClick} style={{ marginLeft: 8 }} >关闭</antd.Button>
                </antd.Row>
            </antd.Form>
        );
    }
}

/********************************************************************************/

/*$("#dataTable").slideDown(500);*/
/**
 * The first Pagination of Tab Components :Table
 */
class TabTable extends React.Component{
    state = {
        condions: '',
        devId:devId,
        equLocation:equLocation,
    };
    getClickCondions = (condions) => {
        this.setState({condions:condions});
      /*  alert(this.state.devId);*/
        this.refs.getChildButton.fetch({
            // page: // todo
        },condions);/*ref调用子组件的getChildButton*/
        this.setState({devId:devId,equLocation:equLocation});
    };
    render(){
        const WrappedAdvancedSearchForm = antd.Form.create()(SearchFormKeyWord);
        return (
            <div>
                <WrappedAdvancedSearchForm getClickCondions={this.getClickCondions} devId={this .state.devId} equLocation={this.state.equLocation}/>
                <IdxDataList ref="getChildButton" />
            </div>
        );
    }
}

const renderContent = (value, row, index) => {
    const obj = {
        children: value,
        props: {},
    };
   /* if (index ===8) {
        obj.props.colSpan = 0;
    }*/
    return obj;
};
const columns = [
   /* {
        title: '设备ID',
        dataIndex: 'equipmentLocation',
        width: '6%',
       /!* fixed:'left',*!/
        render: (value, row, index) => {
            const obj = {
                children: value,
                props: {},
            };
            if (index === 0) {
                obj.props.rowSpan = 10;
            }
            if (index>0&index<10) {
                obj.props.rowSpan = 0;
            }
            return obj;
        },
    },*/
    {
        title: '采集时间戳',
        dataIndex: 'createdate',
        width: '16%',
        // fixed:'left',
        render: (text, row, index) => {
            // if (index < 10) {
            //     return <div>{text}</div>;
            // }
            // return {
            //     children: {text}
            //   /*  props: {
            //         colSpan: 5,
            //     },*/
            // };
            return <div>{text}</div>;
        },
    },
    {
        title: '水压(kPA)',
        dataIndex: 'pressure',
        width: '5%',

    },
    {
        title: '消防栓温度',
        dataIndex: 'hrTemp',
        width: '5%',
    },
    {
        title: '传感器温度',
        dataIndex: 'pressTraTemp',
        width: '5%',
    },
    {
        title: '主机电压(毫伏)',
        dataIndex: 'nbiotVoltage',
        width: '5%',
    }
    ,{
        title: '传感器电压(毫伏)',
        dataIndex: 'pressTraVoltage',
        width: '5%',
    }
    ,{
        title: '消防栓倾角(度)',
        dataIndex: 'angleOfInclination',
        width: '5%',
    }
    ,{
        title: ' 出水口状态',
        dataIndex: 'status17',
        width: '5%',
    }
    ,
    {
        title: '主机震动',
        dataIndex: 'status07',
        width: '5%',
    }
    ,{
        title: '主机倾斜',
        dataIndex: 'status06',
        width: '5%',
    }
    ,{
        title: '主机电量低',
        dataIndex: 'status05',
        width: '5%',
    },
    {
        title: '传感器电量低',
        dataIndex: 'status04',
        width: '5%',
    }
    ,{
        title: '用水检测器',
        dataIndex: 'status03',
        width: '5%',
    }
    ,{
        title: '陀螺仪',
        dataIndex: 'status02',
        width: '5%',
    }
    ,{
        title: '压力传感器',
        dataIndex: 'status01',
        width: '5%',
    }

    ,{
        title: 'RF通讯',
        dataIndex: 'status00',
        width: '5%',
       /* flexed:'right',*/
    },


];

function handleTableDelete(e,id) {
    e.stopPropagation();
    $.ajax({
        url: '/fce/test/deleteById',
        method: 'get',
        data: {
            id: id,
        },
        type: 'json',
    }).then((data) => {
        // this.setState({
        //     loading: false,
        //     data: data,
        //     pagination
        // });

    });
}
/*pagination: {pageSize:5,current:1,total:0},*/
class IdxDataList extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            data: [],
            pagination: {pageSize:10},
            loading: false,
        }
    };


    handleTableChange = (pagination, filters, sorter) => {
        const pager = { ...this.state.pagination };
        pager.current = pagination.current;

        this.fetch({
            results: pagination.pageSize,
            page: pagination.current,
            sortField: sorter.field,
            sortOrder: sorter.order,
            ...filters,
        },);
        // this.setState({
        //     pagination: pager,
        // });
    }

    fetch = (params,condions) => {
        this.setState({ loading: true });
        if(typeof(condions) === "undefined"){
            condions = "";
        }
        var current;
        if (typeof(params) === "undefined"||JSON.stringify(params)==='{}') {
            current = 1;
        }else{
            current =params.page
        }
        var pageSize=10;
        $.ajax({
            url: '/equipmentList/queryHuang?keyword='+ condions + '&equipmentid=' + devId  +'&pageNum='+current+'&pageSize='+pageSize,
            method: 'GET',
            data: {
                results: this.state.pagination.pageSize,
                ...params,
            },
            type: 'json',
        }).then((data) => {
           /* console.log("测试数据类型"+data[0].equipmentid);*/
           /* console.log("设备id"+data.list[0].equipmentid);*/
           /* var equipmentid=data.list[0].equipmentid;*/
            this.setState({

                pagination: current,
            });
            /* alert(data.total);*/

            const pagination = { ...this.state.pagination };//...this.state.pagination
            pagination.total = data.total;
            this.setState({
                loading: false,
                data: data.list,
                pagination:pagination
            });
        }).catch(e =>{
          /*  alert(e)*/
            this.setState({
                loading: false,
            });
        });
    }

    componentDidMount() {
        this.fetch();
    }
    render() {
        return (
            <antd.Table
                columns={columns}/* columns={this.columns}*/
                rowKey={record => record.registered}/* rowKey={record => record.id}*/
                dataSource={this.state.data}/* dataSource={this.state.data.rows}*/
                pagination={this.state.pagination}
                loading={this.state.loading}
                onChange={this.handleTableChange}
                scroll={{ x: '120%', y: 300}}
                bordered
                indentSize

            />
        );
    }
}
ReactDOM.render(
    <div>
        <HzdTab/>
    </div> ,document.getElementById("appHzd"));

/*$(document).ready(function() {
    $("table.ant-table-fixed").colResizable({liveDrag:true, draggingClass:"dragging"});
});*/


/*组件中关闭按钮也可以加在id="hzdClose"后加上onClick={this.handleHzdClick}*/
/*$(document).ready(function() {
    $("#dataTable").click(function () {

        /!* devId= $("#devIdText").val();传值进入<HzdTab/>
         alert(devId);*!/
        /!* debugger*!/       ReactDOM.render(
            <div>
                <HzdTab/>
            </div> ,document.getElementById("appHzd"));
        $("#dataTable").slideDown(500);

        /!* $("#dataTable").css("background-color","#a6c8e6");
         $("#dataTable").css("overflow","scroll");
         $("#dataTable").css("white-space","nowrap");*!/
      /!*  $("#dataTable").css({
            "background-color":"#a6c8e6",
            "overflow":"scroll",
            "white-space":"nowrap"
        });*!/
    });
});

//关闭按钮点击事件
$("#hzdClose2Tab").click(function () {
    /!* debugger*!/
    $("#dataTable").slideUp(500);
})*/

//js方法：
// document.getElementById("dataTable").style.overflow="scroll";
//document.getElementById("dataTable").style.whiteSpace="nowrap";
/*document.getElementById('div2').style.backgroundColor='#ff0000';
//这样错的会覆盖原来的document.getElementById("dataTable").style.cssText="overflow:scroll;whiteSpace:nowrap";

//jQuery方法
//设置单个属性值
$("#divID").css("background-color","red");
    });
//设置多个属性值
// $(selector).css({property:value, property:value, ...})  //{property:value}	“名称/值对”比如 {"color":"red","font-weight":"bold"}
/*$("p").css({
  "color":"white",
  "background-color":"#98bf21",
  "font-family":"Arial",
  "font-size":"20px",
  "padding":"5px"
  });*/