function EbankUtil() {

}

Date.prototype.format = function(fmt) { // author: meizz
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

/**
 * 记录日志信息
 * 
 * option:
 * 
 * level:日志级别，可空，DEBUG，INFO，WARN，ERROR，FATAL，默认为DEBUG.
 * 
 * log_text:日志内容，非空.
 * 
 * p_ref_table:关联表，可空
 * 
 * p_ref_field:关联字段，可空
 * 
 * p_ref_id:关联ID，可空
 */
EbankUtil.prototype.log = function(option) {
	println(new Date().format("yyyy-MM-dd hh:mm:ss") + ':' + option.log_text);
	$bm('ebank.log').execute(option);
}

EbankUtil.prototype.dolock = function(ebankType) {
	$bm('ebank.dolock').execute({
		ebank_type : ebankType
	});
}

EbankUtil.prototype.unlock = function(ebankType) {
	$bm('ebank.unlock').execute({
		ebank_type : ebankType
	});
}

EbankUtil.prototype.paySendUpdateTrans = function(data) {
	for (var i = 0; i < data.length; i++) {
		if (data[i]._status == 'update') {
			$bm('ebank.update_trans_detail_commit').update(data[i]);
		}
	}
}

EbankUtil.prototype.paySendUpdateTransBatch = function(data) {
	for (var i = 0; i < data.length; i++) {
		if (data[i]._status == 'update') {
			$bm('ebank.update_trans_detail_batch').update(data[i]);
		}
	}
}

EbankUtil.prototype.getDate = function() {
	return $bm('ebank.get_date').queryAsMap().getChildren()[0].current_date;
}

EbankUtil.prototype.getTime = function() {
	return $bm('ebank.get_date').queryAsMap().getChildren()[0].current_time;
}

EbankUtil.prototype.errorMsg = {
	'1012' : 'XML解析失败',
	'1016' : '报文校验失败:终端号termid',
	'1017' : '报文校验失败:客户号custid',
	'1018' : '报文校验失败:操作员号cusopr',
	'1019' : '报文校验失败:无交易码trncod',
	'1037' : '报文校验失败:交易流水号为空',
	'1021' : '请求报文为空',
	'1035' : '企业未向银行前置机签到'
};

EbankUtil.prototype.getErrorMsg = function(errorCode) {
	return this.errorMsg[errorCode];
}

EbankUtil.prototype.validateFormat = function(param) {
	var fixedTermId = '1000';
	var fixedCustId = '1000000';
	var fixedCusOpr = '0001';
	var fixedToken = 'fixed-token';

	var head = param.get('/parameter/head');
	if (!head) {
		// XML解析失败
		throw new Error('1012');
	}

	var termId = head.get('termid').getText();
	if (termId != fixedTermId) {
		// 报文校验失败:终端号termid
		throw new Error('1016');
	}

	var custId = head.get('custid').getText();
	if (custId != fixedCustId) {
		// 报文校验失败:客户号custid
		throw new Error('1017');
	}

	var cusOpr = head.get('cusopr').getText();
	if (cusOpr != fixedCusOpr) {
		// 报文校验失败:操作员号cusopr
		throw new Error('1018');
	}

	var trnId = head.get('trnid').getText();
	if (!trnId) {
		// 报文校验失败:交易流水号为空
		throw new Error('1037');
	}

	var token = head.get('token').getText();
	if (token != fixedToken) {
		// 企业未向银行前置机签到
		throw new Error('1035');
	}

	var trans = param.get('/parameter/trans');
	if (!trans) {
		// 请求报文为空
		throw new Error('1021');
	}
}