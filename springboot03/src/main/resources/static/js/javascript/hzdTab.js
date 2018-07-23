/**
 * @author 15computer huangZeDong
 * @date
 */
const Pagination=antd.pagination;
var devId=6067;
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
                <TabPane tab="电压变化趋势" key="2"><TabEchartsZhu/></TabPane>
                <TabPane tab="水压变化趋势" key="3"><TabEchartsZhe/></TabPane>
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
    };
    getClickCondions = (condions) => {
        this.setState({condions:condions});
        this.refs.getChildButton.fetch({},condions);/*ref调用子组件的getChildButton*/
        this.setState({devId:devId});
    };
    render(){
        const WrappedAdvancedSearchForm = antd.Form.create()(SearchFormKeyWord);
        return (
            <div>
                <WrappedAdvancedSearchForm getClickCondions={this.getClickCondions}/>
                <IdxDataList ref="getChildButton"/>
            </div>
        );
    }
}

/**
 * The second Pagination of Tab Components :Echarts-Zhu
 */
class TabEchartsZhu extends React.Component{
    componentDidMount() {
        var myChart = echarts.init(document.getElementById('Tab02'));
        var names = [];    //类别数组（实际用来盛放X轴坐标值）
        var nums = [];    //数组（实际用来盛放Y坐标值）

        var option = null;
        var dataAxis = [];
        var data = [];
        var yMax = 0;
        var dataShadow = [];
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                text: '电压变化趋势图',
                subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
            },
            xAxis: {
                data: names,
                axisLabel: {
                    inside: true,
                    textStyle: {
                        color: '#FFFFFF'
                    }
                },
                axisTick: {
                    show: false
                },
                axisLine: {
                    show: false
                },
                z: 10
            },
            yAxis: {
                axisLine: {
                    show: false
                },
                axisTick: {
                    show: false
                },
                axisLabel: {
                    textStyle: {
                        color: '#999'
                    }
                }
            },
            dataZoom: [
                {
                    type: 'inside'
                }
            ],
            series: [
                { // For shadow
                    type: 'bar',
                    itemStyle: {
                        normal: {color: 'rgba(0,0,0,0.05)'}
                    },
                    barGap:'-100%',
                    barCategoryGap:'40%',
                    data: nums,
                    animation: false
                },
                {
                    type: 'bar',
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#83bff6'},
                                    {offset: 0.5, color: '#188df0'},
                                    {offset: 1, color: '#188df0'}
                                ]
                            )
                        },
                        emphasis: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#2378f7'},
                                    {offset: 0.7, color: '#2378f7'},
                                    {offset: 1, color: '#83bff6'}
                                ]
                            )
                        }
                    },
                    data: data
                }
            ]
        });

        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

        $.ajax({
            type: "get",
            async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url: '/equipmentList/queryHuang?pageNum='+1+'&pageSize='+5,    //请求发送到TestServlet处
            data: {},
            dataType: "json",        //返回数据形式为json
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    result=result.list;
                    var dataAxis = [];
                    var data = [];
                    var yMax = 0;
                    var dataShadow = [];
                    var i;
                    for(i = 0; i< result.length;i++){
                        dataAxis.push(result[i].createdate);
                        data.push(result[i].nbiotVoltage);
                        if(result[i].nbiotVoltage> yMax){
                            yMax = result[i].nbiotVoltage;

                        }
                    }

                    for (var i = 0; i < data.length; i++) {
                        dataShadow.push(yMax);
                    }
                    myChart.hideLoading();    //隐藏加载动画
                    option = {
                        title: {
                            text: '电压变化趋势图',
                            subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
                        },
                        xAxis: {
                            data: dataAxis,
                            axisLabel: {
                                inside: true,
                                textStyle: {
                                    color: '#FF0000'
                                }
                            },
                            axisTick: {
                                show: false
                            },
                            axisLine: {
                                show: false
                            },
                            z: 10
                        },
                        yAxis: {
                            axisLine: {
                                show: false
                            },
                            axisTick: {
                                show: false
                            },
                            axisLabel: {
                                textStyle: {
                                    color: '#00FF00'
                                }
                            }
                        },
                        dataZoom: [
                            {
                                type: 'inside'
                            }
                        ],
                        series: [
                            { // For shadow
                                type: 'bar',
                                itemStyle: {
                                    normal: {color: 'rgba(255,0,0,0.5)'}
                                },
                                barGap:'-100%',
                                barCategoryGap:'40%',
                                data: dataShadow,
                                animation: false
                            },
                            {
                                type: 'bar',
                                itemStyle: {
                                    normal: {
                                        color: new echarts.graphic.LinearGradient(
                                            0, 0, 0, 1,
                                            [
                                                {offset: 0, color: '#83bff6'},
                                                {offset: 0.5, color: '#188df0'},
                                                {offset: 1, color: '#188df0'}
                                            ]
                                        )
                                    },
                                    emphasis: {
                                        color: new echarts.graphic.LinearGradient(
                                            0, 0, 0, 1,
                                            [
                                                {offset: 0, color: '#2378f7'},
                                                {offset: 0.7, color: '#2378f7'},
                                                {offset: 1, color: '#83bff6'}
                                            ]
                                        )
                                    }
                                },
                                data: data
                            }
                        ]
                    };

                    var zoomSize = 6;
                    myChart.on('click', function (params) {
                        console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
                        myChart.dispatchAction({
                            type: 'dataZoom',
                            startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
                            endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
                        });
                    });;
                    if (option && typeof option === "object") {
                        myChart.setOption(option, true);
                    }
                }

            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })

    }
    render(){
        return <div>
            <div id="Tab02" style={{backgroundColor:'#ffffff',height:500,width:'100%'}}></div>
        </div>
    }
}

/***************************************************/
/**
 * The Third Pagination of Tab Components :Echarts-Zhe
 */
class TabEchartsZhe extends React.Component{
    componentDidMount() {
        var myChart = echarts.init(document.getElementById('Tab03'));
        var names = [];    //类别数组（实际用来盛放X轴坐标值）
        var nums = [];    //数组（实际用来盛放Y坐标值）

        var option = null;
        var dataAxis = [];
        var data = [];
        var yMax = 0;
        var dataShadow = [];
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                text: '水压变化趋势图',
                subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
            },
            xAxis: {
                data: names,
                axisLabel: {
                    inside: true,
                    textStyle: {
                        color: '#FFFFFF'
                    }
                },
                axisTick: {
                    show: false
                },
                axisLine: {
                    show: false
                },
                z: 10
            },
            yAxis: {
                axisLine: {
                    show: false
                },
                axisTick: {
                    show: false
                },
                axisLabel: {
                    textStyle: {
                        color: '#999'
                    }
                }
            },
            dataZoom: [
                {
                    type: 'inside'
                }
            ],
            series: [
                { // For shadow
                    type: 'line',
                    itemStyle: {
                        normal: {color: 'rgba(0,0,0,0.05)'}
                    },
                    barGap:'-100%',
                    barCategoryGap:'40%',
                    data: nums,
                    animation: false
                },
                {
                    type: 'line',
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#83bff6'},
                                    {offset: 0.5, color: '#188df0'},
                                    {offset: 1, color: '#188df0'}
                                ]
                            )
                        },
                        emphasis: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#2378f7'},
                                    {offset: 0.7, color: '#2378f7'},
                                    {offset: 1, color: '#83bff6'}
                                ]
                            )
                        }
                    },
                    data: data
                }
            ]
        });

        myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
        $.ajax({
            type: "get",
            async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url: '/equipmentList/queryHuang?pageNum='+1+'&pageSize='+5,    //请求发送到TestServlet处
            data: {},
            dataType: "json",        //返回数据形式为json
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                    result=result.list;/*这一步很重要*/
                    var dataAxis = [];
                    var data = [];
                    var yMax = 0;
                    var dataShadow = [];
                    var i;
                    for(i = 0; i< result.length;i++){
                        dataAxis.push(result[i].createdate);
                        data.push(result[i].status10);
                        if(result[i].status10> yMax){
                            yMax = result[i].status10;

                        }
                    }

                    for (var i = 0; i < data.length; i++) {
                        dataShadow.push(yMax);
                    }
                    myChart.hideLoading();    //隐藏加载动画
                    option = {
                        title: {
                            text: '水压变化趋势图',
                            subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
                        },
                        xAxis: {
                            data: dataAxis,
                            axisLabel: {
                                inside: true,
                                textStyle: {
                                    color: '#FF0000'
                                }
                            },
                            axisTick: {
                                show: false
                            },
                            axisLine: {
                                show: false
                            },
                            z: 10
                        },
                        yAxis: {
                            axisLine: {
                                show: false
                            },
                            axisTick: {
                                show: false
                            },
                            axisLabel: {
                                textStyle: {
                                    color: '#00FF00'
                                }
                            }
                        },
                        dataZoom: [
                            {
                                type: 'inside'
                            }
                        ],
                        series: [
                            { // For shadow
                                type: 'line',
                                itemStyle: {
                                    normal: {color: 'rgba(255,0,0,0.5)'}
                                },
                                barGap:'-100%',
                                barCategoryGap:'40%',
                                data: dataShadow,
                                animation: false
                            },
                            {
                                type: 'line',
                                itemStyle: {
                                    normal: {
                                        color: new echarts.graphic.LinearGradient(
                                            0, 0, 0, 1,
                                            [
                                                {offset: 0, color: '#83bff6'},
                                                {offset: 0.5, color: '#188df0'},
                                                {offset: 1, color: '#188df0'}
                                            ]
                                        )
                                    },
                                    emphasis: {
                                        color: new echarts.graphic.LinearGradient(
                                            0, 0, 0, 1,
                                            [
                                                {offset: 0, color: '#2378f7'},
                                                {offset: 0.7, color: '#2378f7'},
                                                {offset: 1, color: '#83bff6'}
                                            ]
                                        )
                                    }
                                },
                                data: data
                            }
                        ]
                    };

                    var zoomSize = 6;
                    myChart.on('click', function (params) {
                        console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
                        myChart.dispatchAction({
                            type: 'dataZoom',
                            startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
                            endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
                        });
                    });;
                    if (option && typeof option === "object") {
                        myChart.setOption(option, true);
                    }
                }

            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })

    }
    render(){
        return <div>
            <div id="Tab03" style={{backgroundColor:'#ffffff',height:500,width:'100%'}}></div>
        </div>
    }
}

/**
 * Table Pagination
 */
/*********************
 private Long id;

 private String equipmentNo;

 private String equipmentLocation;

 private BigDecimal pressure;*********************************/
const columns = [
    {
        title: '设备的编号',
        dataIndex: 'equipmentNo',
        width: '7.5%',
    },
    {
        title: '采集时间戳',
        dataIndex: 'createdate',
        width: '7.5%'

    },
    {
        title: '水压(kPa)',
        dataIndex: 'status10',
        width: '7.5%',
    }, {
        title: '消防栓温度',
        dataIndex: 'hrTemp',
        width: '7.5%',
    },{
        title: '传感器温度',
        dataIndex: 'pressTraTemp',
        width: '7.5%',
    },
    {
        title: '主机电压(毫伏)',
        dataIndex: 'nbiotVoltage',
        width: '7.5%',
    }
    ,{
        title: '传感器电压(毫伏)',
        dataIndex: 'pressTraVoltage',
        width: '7.5%',
    }
    ,{
        title: '消防栓倾角(度)',
        dataIndex: 'angleOfInclination',
        width: '7.5%',
    }

    ,
    {
        /*title: '操作',
        dataIndex: 'id',*/
        render: (text, record) => {
            return (
                <div style={{width:'100%'}}>
                    {/*<a href="#" style={{ marginRight: 8 }}>查看</a>
                    <a href="#" style={{ marginRight: 8 }}>编辑</a>
                    <antd.Popconfirm title="Are you sure？" okText="Yes" cancelText="No">
                        <a   href="#"    onClick={(e) => handleTableDelete(e,record.id)}       style={{ marginRight: 8 }}    >删除</a>
                    </antd.Popconfirm>*/}
                </div>
            )
        }
    }
];

function handleTableDelete(e,id) {
    e.stopPropagation();
    reqwest({
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
            pagination: {pageSize: 5},
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
        if(typeof(condions) == "undefined"){
            condions = "";
        }
        var current;
        if (typeof(params) == "undefined") {
            current = 1;
        }else
        {
            current=params.page;
        }



        reqwest({
            url: '/equipmentList/queryHuang?keyword='+ condions + '&equipmentid=' + devId  +'&pageNum='+current+'&pageSize='+5,
            method: 'get',
            data: {
                results: this.state.pagination.pageSize,
                ...params,

            },
            type: 'json',
            }).then((data) => {
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
            />
        );
    }
}
/*********************************************************/
/**
 * render
 */
/*组件中关闭按钮也可以加在id="hzdClose"后加上onClick={this.handleHzdClick}*/
$(document).ready(function() {
    $("#hzdOpenTab").click(function () {

        /* devId= $("#devIdText").val();传值进入<HzdTab/>
         alert(devId);*/
        /* debugger*/       ReactDOM.render(
            <div>
                <HzdTab/>
            </div> ,document.getElementById("appHzd"));
        $("#dataTable").slideDown(500);

        /* $("#dataTable").css("background-color","#a6c8e6");
         $("#dataTable").css("overflow","scroll");
         $("#dataTable").css("white-space","nowrap");*/
        $("#dataTable").css({
            "background-color":"#a6c8e6",
            "overflow":"scroll",
            "white-space":"nowrap"
        });
    });
});

//关闭按钮点击事件
$("#hzdClose2Tab").click(function () {
    /!* debugger*!/
    $("#dataTable").slideUp(500);
})

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