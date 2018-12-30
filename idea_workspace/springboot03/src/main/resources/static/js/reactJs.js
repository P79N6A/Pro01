// ... the starter code you pasted ...
// import '../../style/index.css';
// import '../../grid/style/index.css';

// import Table from 'static/js/antd/lib/table';
// import { Table, Divider, Tag } from '/static/js/antd';
const Tag=antd.Tag;
const Divider=antd.Divider;
const Tabs=antd.Tabs;
const Table=antd.Table;
const columns = [{
    title: 'Name',
    dataIndex: 'name',
    key: 'name',

}, {
    title: 'Age',
    dataIndex: 'age',
    key: 'age',
}, {
    title: 'Address',
    dataIndex: 'address',
    key: 'address',
}, {
    title: 'Tags',
    key: 'tags',
    dataIndex: 'tags',
    render: tags => (
        <span>
      {tags.map(tag => <Tag color="blue" key={tag}>{tag}</Tag>)}
    </span>
    ),
}, {
    title: 'Action',
    key: 'action',
    render: (text, record) => (
        <span>
      <a href="javascript:;">Invite {record.name}</a>
      <Divider type="vertical" />
      <a href="javascript:;">Delete</a>
    </span>
    ),
}];

const data = [{
    key: '1',
    name: 'John Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
    tags: ['nice', 'developer'],
}, {
    key: '2',
    name: 'Jim Green',
    age: 42,
    address: 'London No. 1 Lake Park',
    tags: ['loser'],
}, {
    key: '3',
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
    tags: ['cool', 'teacher'],
}];

ReactDOM.render(<Table columns={columns} dataSource={data} />, document.getElementById("test"));