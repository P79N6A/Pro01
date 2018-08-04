import React from 'react';
import { Table, Icon, Input, Form,Row, Col, Button, Popconfirm,Tooltip } from 'antd';
import axios from 'axios';
const FormItem = Form.Item;
@connect(({ user }) => ({
    user: user
}))




class ManagementTab extends React.Component{


    columns = [
        {
            title: '序号',
            dataIndex: 'order',
            width: '6%',
            align:'center',
        },
        {
            title: '用户名',
            dataIndex: 'loginName',
            width: '12%',
            align:'center',
        },
        {
            title: '电子邮箱',
            dataIndex: 'email',
            width: '12%',
            align:'center',
        },
        {
            title: '公司名称',
            dataIndex: 'organizationId',
            width: '9%',
            align:'center',
        },
        {
            title: '真实姓名',
            dataIndex: 'realName',
            width: '9%',
            align:'center',
        },
        {
            title: '手机号',
            dataIndex: 'phone',
            width: '10%',
            align:'center',
        },
        {
            title: '用户是否启用',
            dataIndex: 'enabled',
            width: '10%',
            align:'center',
        },
        {
            title: '用户是否为管理员',
            dataIndex: 'admin',
            width: '17%',
            align:'center',
        },
        {
            title: '操作',
            dataIndex: 'action',
            width: '15%',
            align:'center',
            render: (text, record) => {
                return (
                    <div>
                        <Tooltip placement="bottom" title="编辑">
                            <Button onClick={(e) => {this.handleLinkToDetail(e, record.id)}}><Icon type="edit" /></Button>
                        </Tooltip>
                        <Tooltip placement="bottom" title="移除">
                            <Popconfirm title="确定要删除吗" okText="是的" cancelText="取消"
                                        onConfirm={(e) => {this.handleDelete(e, record.id)}}
                            >
                                <Button type="danger" style={{marginLeft:10}}><Icon type="delete" /></Button>
                            </Popconfirm>
                        </Tooltip>
                    </div>
                )
            }
        }
    ];

    state = {
        enterState:0,
        current: 1,
        totals: 0,
        data: [],
        moreSearchState: true,
        moreSearchInfo: "更多筛选"
    }

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
        //获取三个输入框的输入
        let objectNoValue = this.props.form.getFieldValue('objectNo');
        let objectNameValue = this.props.form.getFieldValue('objectName');
        let objectManagerValue = this.props.form.getFieldValue('objectManager');
        //调用后台的接口
        axios({
            method: 'post',
           /* url: '/base-info/resume/ocmsObject/page?page=0&size=6',*/
            url:url,

            data:{'objectNo':objectNoValue,'objectName':objectNameValue,'objectManager':objectManagerValue}
        }).then((res) => {
            // console.log(res.data.content);
            //添加数据到data
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
     * 查询所有的项目信息
     */
    selectAll = () => {
        axios({
            method: 'post',
            url: '/iam/v1/organizations/1/users/search?page=0&size=6',
            data:{}
        }).then((res) => {
            console.log(res.data);
            console.log("1111111111111111");
            console.log(res.data.content);
            this.addTodata(res.data.content);

        }).catch((err) => {
            console.log(err);
        })
    }

    /***
     * 将查询到的结果添加到列表的data中
     */
    addTodata = (result) => {

        let datas = [];
        let order=1;

        result.forEach(function (value) {
            let item = {};
            item.order = order++;
            item.id = value.id;
            // item.objectNo = value.objectNo;
            if(value.loginName.length>5){
                item.loginName=value.loginName.substring(0,5)+'...';
            } else{
                item.loginName=value.loginName;
            }
            // item.objectName = value.objectName;
            if(value.email.length>5){
                item.email=value.email.substring(0,5)+'...';
            } else{
                item.email=value.email;
            }
            item.organizationId = value.organizationId;
            item.realName = value.realName;
            item.phone = value.phone;
            item.enabled = value.enabled===true?'是':'否';
            item.admin = value.admin===true?'是':'否';
            datas.push(item);
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
                    if(this.state.moreSearchState){
                        this.selectAll();
                    } else {
                        this.selectData();
                    }
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
                        <Col xs={{span: 4}} style={{ marginRight:20}}>
                            <FormItem
                                wrapperCol={{span:24}}
                            >
                                {getFieldDecorator('loginName', {})(
                                    <Input />
                                )}
                            </FormItem>
                        </Col>
                        <Col xs={{span: 4}} style={{ marginRight:20}}>
                            <FormItem
                                wrapperCol={{span:24}}
                            >
                                {getFieldDecorator('loginName', {rules: [{ required: true, message: '请输入您的用户名' }]})(
                                    <Input />
                                )}
                            </FormItem>
                        </Col>
                        <Col xs={{span: 4}} style={{ marginRight:20}}>
                            <FormItem
                                wrapperCol={{span:24}}
                            >
                                {getFieldDecorator('loginName', {rules: [{ required: true, message: '请输入您的用户名' }]})(
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
                                        onClick={(e) => {this.handleLinkToDemand(e, this.state.data.id)}}
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
                       style={{textAlign:'center'}}
                >
                </Table>
            </div>

        );
    }

}


export default Form.create()(ManagementTab);
