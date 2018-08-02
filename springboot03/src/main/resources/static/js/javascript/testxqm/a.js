/****
 * created by zhuganghui on 2018/7/20
 *
 * 项目信息查询及显示页面
 * 提供条件查询，双击每一条记录进入对应的明细页面
 */
import React from 'react';
import { Table, Icon, Input, Form,Row, Col, Button, Popconfirm,Tooltip } from 'antd';
import axios from 'axios';
import { connect } from 'dva';
import styles from './ProjectBaseInfoList.css';
const FormItem = Form.Item;
@Form.create()
@connect(({ user }) => ({
    user: user
}))
class ProjectBaseInfoList extends React.Component{

    state = {
        enterState:0,
        current: 1,
        totals: 0,
        data: [],
        moreSearchState: true,
        moreSearchInfo: "更多筛选",
    }

    columns = [
        {
            title: '序号',
            dataIndex: 'order',
            width: '6%',
        },
        {
            title: '项目编号',
            dataIndex: 'objectNo',
            width: '12%',
            render: (text, record) => {
                return (
                    <span title={record.objectNoLong}>{text}</span>
                )
            }
        },
        {
            title: '项目名称',
            dataIndex: 'objectName',
            width: '12%',
            render: (text, record) => {
                return (
                    <span title={record.objectNameLong}>{text}</span>
                )
            }
        },
        {
            title: '项目经理',
            dataIndex: 'objectManager',
            width: '9%',
        },
        {
            title: '项目状态',
            dataIndex: 'status',
            width: '9%',
        },
        {
            title: '开始日期',
            dataIndex: 'objectStartDate',
            width: '10%',
        },
        {
            title: '结束日期',
            dataIndex: 'objectEndDate',
            width: '10%',
        },
        {
            title: '所属公司',
            dataIndex: 'companyName',
            width: '12%',
            render: (text, record) => {
                return (
                    <span title={record.companyNameLong}>{text}</span>
                )
            }
        },
        {
            title: '操作',
            dataIndex: 'action',
            width: '20%',
            render: (text, record) => {
                return (
                    <div>
                        {this.state.enterState == 0?
                            <div>
                                <Tooltip placement="bottom" title="编辑">
                                    <Button onClick={(e) => {this.handleLinkToDetail(e, record.id)}}><Icon type="edit" /></Button>
                                </Tooltip>
                                <Tooltip placement="bottom" title="移除">
                                    <Popconfirm title="确定要删除吗" okText="是的" cancelText="取消"
                                                onConfirm={(e) => {this.handleDelete(e, record.id)}}
                                    >
                                        <Button type="danger" style={{marginLeft:10,marginRight:10}}><Icon type="delete" /></Button>
                                    </Popconfirm>
                                </Tooltip>
                                <Tooltip placement="bottom" title="添加需求信息">
                                    <Button onClick={(e) => {this.handleLinkToDemand(e, record.id)}}><Icon type="plus" /></Button>
                                </Tooltip>
                            </div>
                            :
                            <div></div>
                        }
                    </div>
                )
            }
        }
    ];

    componentWillMount(){
        let isadmin = this.props.user.currentUser.admin;
        if(isadmin==true){
            this.setState({
                enterState:1,
            })
        }
        this.selectData();
    }
    /**
     * 条件查询
     */
    handleSearch = () => {
        this.setState({
            current: 1,
            totals: 0,
        },() => {this.selectData()})
    }

    /***
     * 处理page跳转
     */
    handlePageChange = (page) => {
        // console.log(page);
        this.setState({
            current: page,
        },() => {this.selectData()});
    }

    /***
     * 根据page查询企业信息
     */
    selectData = () => {
        let url = "/base-info/resume/ocmsObject/page?";
        url += "page="+ (this.state.current-1) + "&size=6";

        let datas = {};
        //获取三个输入框的输入
        let objectNoValue = this.props.form.getFieldValue('objectNo');
        let objectNameValue = this.props.form.getFieldValue('objectName');
        let objectManagerValue = this.props.form.getFieldValue('objectManager');
        if(objectNoValue !== undefined){
            if(this.Trim(objectNoValue) !== ""){
                datas.objectNo = objectNoValue;
            }
        }
        if(objectNameValue !== undefined){
            if(this.Trim(objectNameValue) !== ""){
                datas.objectName = objectNameValue;
            }
        }
        if(objectManagerValue !== undefined){
            if(this.Trim(objectManagerValue) !== ""){
                datas.objectManager = objectManagerValue;
            }
        }
        //调用后台的接口
        axios({
            method: 'post',
            url: url,
            data:datas,
        }).then((res) => {
            console.log(res);
            let totals = res.data.totalElements;
            //添加数据到data
            this.addTodata(res.data.content);
            this.setState({
                totals: totals,
            })
        }).catch((err) => {
            console.log(err);
        })
    }


    /***
     *  更多筛选按钮
     */
    handleMoreSearch = () => {
        let moreSearchForm = document.getElementById("moreSearch");
        //改变筛选按钮的状态
        if(this.state.moreSearchState){
            moreSearchForm.style.display = "block";
            this.setState({
                moreSearchState: false,
                moreSearchInfo: "关闭筛选",
            });
        }else {
            moreSearchForm.style.display = "none";
            this.setState({
                moreSearchState: true,
                moreSearchInfo: "更多筛选",
            });
            this.handleReset();
        }
    }

    /***
     * 将查询到的结果添加到列表的data中
     */
    addTodata = (result) => {

        let datas = [];
        let order=1;
        let userid=this.props.user.currentUser.id;
        let isadmin=this.props.user.currentUser.admin;
        console.log(userid);
        result.forEach(function (value) {
            if(value.createdBy==userid||isadmin==true){
                let item = {};
                item.order = order++;
                item.id = value.id;
                item.objectNoLong = value.objectNo;
                if(value.objectNo.length>8){
                    item.objectNo=value.objectNo.substring(0,8)+'...';
                } else{
                    item.objectNo=value.objectNo;
                }
                item.objectNameLong = value.objectName;
                if(value.objectName.length>5){
                    item.objectName=value.objectName.substring(0,5)+'...';
                } else{
                    item.objectName=value.objectName;
                }
                item.objectManager = value.objectManager;
                item.status = value.status===0?'有效':'无效';
                item.objectStartDate = new Date(value.objectStartDate).toLocaleDateString() ;
                item.objectEndDate = new Date(value.objectEndDate).toLocaleDateString();
                item.companyNameLong = value.companyName;
                if(value.companyName.length>5){
                    item.companyName=value.companyName.substring(0,5)+'...';
                } else{
                    item.companyName=value.companyName;
                }

                datas.push(item);
            }
        });

        //将datas 添加到state中
        this.setState({
            data: datas,
        })

    }

    /**
     * 删除一条记录
     */
    handleDelete = (e, id) => {
        e.stopPropagation();
        //调用后台接口删除一条记录

        let url = "/base-info/resume/ocmsObject/";
        url += id;
        //删除数据
        axios({
            method: 'delete',
            url: url,
        }).then((res) => {
            // console.log(res);

            if(res.data === false){
                //过滤掉删除的信息
                const { data } = this.state;
                const nextData = data.filter(item => item.id !== id);
                this.setState({
                    data:nextData
                },() => {
                    this.selectData();
                });
                console.log("删除成功");
            }
        }).catch((err) => {
            console.log(err);
        })

    }

    /***
     * 清空三个查询输入框的内容
     */
    handleReset = () => {
        this.props.form.resetFields();
        this.setState({
            current: 1,
            totals: 0,
        },() => {this.selectData()})
    }

    /**
     *   跳转到明细页面
     */
    handleLinkToDetail = (e, id)=>{
        e.stopPropagation();
        this.linkToChange(`/base-info-defend/projectUpdate/${id}`);
    }
    /**
     *   跳转到需求页面
     */
    handleLinkToDemand = (e, id)=>{
        e.stopPropagation();
        this.linkToChange(`/external-demand/applicationDetail/1/0/${id}`);
    }

    /***
     *   路径跳转
     */
    linkToChange = url => {
        const { history } = this.props;
        history.push(url);
    };


    /**
     * 去除两端空格
     * @param str
     * @returns {*}
     * @constructor
     */
    Trim = (str) =>{
        return str.replace(/(^\s*)|(\s*$)/g,"");
    }


    render(){
        const { getFieldDecorator } = this.props.form;
        const formItemLayout = {
            labelCol: {
                xs: { span: 24 },
                sm: { span: 8 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 16 },
            },
        };

        return(
            <div id="no">
                <Form layout="horizontal">
                    <Row type="flex" style={{marginLeft: 20}}>
                        <Col xs={{span: 12}} style={{ marginRight:20}}>
                            <FormItem
                                wrapperCol={{span:24}}
                            >
                                {getFieldDecorator('searchInput', {})(
                                    <Input />
                                )}
                            </FormItem>
                        </Col>
                        <Col style={{ marginRight:87}}>
                            <FormItem>
                                <Button type="primary" onClick={this.handleSearch}>搜索</Button>
                            </FormItem>
                        </Col>
                        <Col style={{ marginRight:20}}>
                            <FormItem>
                                <Button type="primary" onClick={this.handleMoreSearch}>{this.state.moreSearchInfo}</Button>
                            </FormItem>
                        </Col>
                        {this.state.enterState == 0?
                            <Col>
                                <FormItem>
                                    <Button type="primary"
                                            onClick={(e) => {this.handleLinkToDetail(e, 0)}}
                                    >添加</Button>
                                </FormItem>
                            </Col>
                            :
                            <Col></Col>
                        }
                    </Row>
                </Form>
                <Form id="moreSearch" layout="inline" style={{display: 'none',marginBottom:20}}>
                    <FormItem
                        {...formItemLayout}
                        label="项目编号"
                    >
                        {getFieldDecorator('objectNo', {})(
                            <Input prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}/>
                        )}
                    </FormItem>
                    <FormItem
                        {...formItemLayout}
                        label="项目名称"
                    >
                        {getFieldDecorator('objectName', {})(
                            <Input prefix={<Icon type="info-circle-o" style={{ color: 'rgba(0,0,0,.25)' }} />}/>
                        )}
                    </FormItem>
                    <FormItem
                        {...formItemLayout}
                        label="项目经理"
                    >
                        {getFieldDecorator('objectManager', {})(
                            <Input prefix={<Icon type="contacts" style={{ color: 'rgba(0,0,0,.25)' }} />}/>
                        )}
                    </FormItem>
                    <FormItem>
                        <Button onClick={this.handleReset}>重置</Button>
                    </FormItem>
                </Form>
                <Table columns = {this.columns}
                       dataSource = {this.state.data}
                       rowClassName={() => styles.Table__row}
                       pagination = { {
                           pageSize: 6,
                           current: this.state.current,
                           onChange: this.handlePageChange,
                           total: this.state.totals
                       }}
                       onRow={(record) => {
                           return {
                               onDoubleClick: (e) => {this.handleLinkToDetail(e, record.id)}
                           };
                       }}
                       rowKey = "id"
                >
                </Table>
            </div>

        );
    }

}


export default ProjectBaseInfoList;
