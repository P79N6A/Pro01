(function(s){var z=document.documentElement,x=Ext.isEmpty,l=Ext.each,w=false,h=true,B=null,v="",D="_",p=" ",q="-c",f="-u",j="checkedvalue",u="cellcheck",c="-readonly",e="item-ckb",m="required",r="item-notBlank",b="item-invalid",y="cellclick",i="rowclick",k="keydown",o="select",n="mousedown",d="editorshow",a="nexteditorshow",g="未找到",t="方法!";s.GridBox=Ext.extend(s.Component,{constructor:function(A){s.GridBox.superclass.constructor.call(this,A)},initComponent:function(E){var H=this;s.GridBox.superclass.initComponent.call(H,E);var A=H.wrap,K=H.isfield,G=H.tbody=K?A.parent("tbody"):A.child("tbody"),J=H.tr=K?A.parent("tr").addClass("gridbox-row-end"):G.first(),C=H.btn=A.child(".gridbox-button"),I=0,F=H.column,L=1;l(H.columns,function(M){var N=Number(M.colspan)||1;if(N>1&&I<F&&I+N>F){M.colspan=N=F-I}I+=N;if(I>F){L++;I=Number(M.colspan)||1}});H.rows=L;C.dom.tabIndex=H.tabindex;C.setStyle({outline:"none"});H.rowposition=G.query("tr").indexOf(J.dom);H.initTemplate()},processDataSetLiestener:function(A){var C=this,E=C.dataset;if(E){E[A]("metachange",C.onLoad,C);E[A]("update",C.onUpdate,C);E[A]("reject",C.onUpdate,C);E[A]("add",C.onAdd,C);E[A]("load",C.onLoad,C);E[A]("valid",C.onValid,C);E[A]("remove",C.onRemove,C);E[A]("clear",C.onLoad,C);E[A]("refresh",C.onLoad,C);E[A]("indexchange",C.onIndexChange,C)}},processListener:function(A){var C=this;s.GridBox.superclass.processListener.call(C,A);C.tbody[A]("click",C.onClick,C);C.btn[A](Ext.isOpera?"keypress":k,C.handleKeyDown,C)[A]("keyup",C.handleKeyUp,C)[A]("focus",C.onFocus,C)[A]("blur",C.onBlur,C);C[A](y,C.onCellClick,C)},processMouseOverOut:function(A){var C=this;if(C.isfield){C.wrap.parent("table")[A]("mouseover",C.onMouseOver,C)[A]("mouseout",C.onMouseOut,C)}else{s.GridBox.superclass.processMouseOverOut.call(C,A)}},bind:function(C){if(Ext.isString(C)){C=$(C);if(!C){return}}var A=this;A.dataset=C;A.processDataSetLiestener("on");A.onLoad()},handleKeyDown:function(F){var C=this,A=F.getKey(),E=C.dataset;if(F.ctrlKey&&F.keyCode==86&&C.canpaste){var G=window.clipboardData.getData("text");if(G){l(G.split("\n"),function(K){var I=K.split("\t");if(I==v){return}var J={},H=0;l(C.columns,function(L){if(C.isFunctionCol(L.type)){return}if(L.hidden!==h){J[L.name]=I[H];H++}});E.create(J)})}}else{if(A==9){C.showEditorByRecord()}else{if(A==38||A==40||A==33||A==34){if(E.loading==h){return}switch(F.getKey()){case 33:E.prePage();break;case 34:E.nextPage();break;case 38:if(!F.ctrlKey){E.pre()}break;case 40:if(!F.ctrlKey){E.next()}break}F.stopEvent()}}}C.fireEvent(k,C,F)},handleKeyUp:function(A){if(A.getKey()==9){this.showEditorByRecord()}},onFocus:function(){this.hasFocus=h},onBlur:function(){this.hasFocus=w},onValid:function(F,A,C,E){var H=this.findColByName(C);if(H){var G=Ext.get([this.id,C,A.id].join(D));if(G){if(E==w){G.addClass(b)}else{G.removeClass([r,b])}}}},getDataIndex:function(E){for(var C=0,F=this.dataset.data,A=F.length;C<A;C++){if(F[C].id==E){return C}}return -1},onIndexChange:function(E,C){var A=this.getDataIndex(C.id);if(A==-1){return}this.selectRow(A,w)},onAdd:function(F,A,C){var E=this;E.createRow(A,C*(E.rows||1))},onRemove:function(E,A,C){this.tr.parent().select("[_row="+A.id+"]").remove()},onUpdate:function(H,A,C,G){var F=this,J=Ext.get([F.id,C,A.id].join(D));if(J){var I=F.findColByName(C),E=F.getEditor(I,A);if(E!=v&&($(E) instanceof s.CheckBox)){F.renderEditor(J,A,I,E)}else{J.update(F.renderText(A,I,G))}}l(F.columns,function(L){if(L.name!=C){var K=Ext.get([F.id,L.name,A.id].join(D));if(K){if(L.editorfunction){F.renderEditor(K,A,L,F.getEditor(L,A))}if(L.renderer){K.update(F.renderText(A,L,A.get(L.name)))}}}})},onLoad:function(){var A=this,C=A.dataset;A.clear();A.render()},clear:function(){this.tr.parent().select("[_id="+this.id+"]").remove()},initTemplate:function(){this.cellTpl=new Ext.Template(['<div class="gridbox-cell {cellcls}" id="',this.id,'_{name}_{recordid}" style="width:{width}px">{text}</div>']);this.cbTpl=new Ext.Template(['<div class="gridbox-ckb-wrap" style="height:20px;width:{width}px"><div style="margin-top:3px" class="{cellcls}" id="',this.id,'_{name}_{recordid}"></div></div>'])},render:function(){var A=this;l(A.dataset.getAll(),function(E,C){A.createRow(E,C*A.rows)})},renderPrompt:function(A,C,G){var F=C.promptrenderer;if(F){var E=s.getRenderer(F);if(E==B){alert(g+F+t);return G}G=E(G,A,C.name);return G==B?v:G}return G==B?v:G},renderEditor:function(F,A,E,C){this.createCell(F.dom,E,A)},renderText:function(A,C,G){var F=C.renderer;if(F){var E=s.getRenderer(F);if(E==B){alert(g+F+t);return G}G=E(G,A,C.name);return G==B?v:G}return G==B?v:G},createRow:function(E,H){var F=this,C=F.column,K=F.rowposition,G=0,J=F.tbody.dom.insertRow(H+K+1),A,L=1,I=false;Ext.fly(J).set({_row:E.id,_id:F.id},true);l(F.columns,function(N,P){G+=Number(N.colspan)||1;if(G>C){if(!I){F.createCloseBtn(A,E);I=true}J=F.tbody.dom.insertRow(H+L+K+1);Ext.fly(J).set({_row:E.id,_id:F.id},true);G=Number(N.colspan)||1;L++}A=F.createCell(J,N,E);if(P==F.columns.length-1){for(var O=0,M=C-G;O<M;O++){F.createEmptyCell(J)}}});J.className="gridbox-row-end";if(!I){F.createCloseBtn(A,E)}},createEmptyCell:function(C){var A=document.createElement("th"),E=document.createElement("td");C.appendChild(A);C.appendChild(E);A.innerHTML="&#160;";E.innerHTML="&#160;"},createCloseBtn:function(C,A){new Ext.Template('<div class="gridbox-close-button" recordid="{recordid}"></div>').append(C,{recordid:A.id});C.addClass("gridbox-close-botton-wrap")},createCell:function(N,E,I){var K=this,A=document.createElement("th"),G,P=w;A.className="layout-th";if(E){var C=K.renderPrompt(I,E,E.prompt);A.innerHTML="<div>"+C+(x(C)?v:K.labelseparator)+"</div>"}A.width=E.labelwidth;N.appendChild(A);if(N.tagName.toLowerCase()=="tr"){G=document.createElement("td");N.appendChild(G);G=Ext.fly(G)}else{G=Ext.fly(N).parent("td");if(G.hasClass("gridbox-close-botton-wrap")){P=h}}G.addClass("layout-td-cell").setStyle({padding:this.padding+"px"});if(E){if(E.colspan){G.dom.colSpan=E.colspan*2-1}var J=K.getEditor(E,I),F=E.type,M=E.name,H,Q=v;if(J!=v){var L=s.CmpManager.get(J);if(L&&(L instanceof s.CheckBox)){F=u}else{Q="item-tf item-wrap"}}else{if(M&&Ext.isDefined(I.getField(M).get(j))){F=u;H=h}else{Q="item-tf item-wrap item-readOnly"}}G.set({atype:"gridbox-cell",recordid:I.id,dataindex:M}).setStyle({"text-align":E.align||"left"});if(F==u){G.update(K.cbTpl.applyTemplate({cellcls:"gridbox-ckb "+K.getCheckBoxStatus(I,M,H),name:M,recordid:I.id,width:E.width||-1}))}else{var O=I.getMeta().getField(M);if(O&&x(I.data[M])&&O.get(m)==h){Q=Q+p+r}G.update(M?K.cellTpl.applyTemplate({text:K.renderText(I,E,I.data[M]),cellcls:Q,name:M,recordid:I.id,width:E.width||150}):"&#160;")}if(P){K.createCloseBtn(G,I)}}return G},getCheckBoxStatus:function(A,F,E){var H=this.dataset.getField(F),C=H.getPropertity(j),G=A.data[F];return e+(E?c:v)+((G&&G==C)?q:f)},onClick:function(I,E){var F=this,H=E=Ext.fly(E),G=F.dataset,A;if(H.is("div.gridbox-close-button")){A=G.findById(H.getAttributeNS(v,"recordid"));s.showConfirm("提示","确认删除？",function(){G.remove(A)})}else{if(H.is("div.gridbox-cell")||H.is("div.gridbox-ckb-wrap")||H.parent("div.gridbox-ckb-wrap")){H=H.parent("td");A=G.findById(H.getAttributeNS(v,"recordid"));var J=G.indexOf(A),C=H.getAttributeNS(v,"dataindex");F.fireEvent(y,F,J,C,A,!E.hasClass("gridbox-ckb"));F.fireEvent(i,F,J,A)}}},onCellClick:function(E,F,C,A,G){this.showEditor(F,C,G)},setEditor:function(C,E){var F=this,A=F.findColByName(C),G=Ext.get([F.id,C,F.selectedId].join(D));A.editor=E},getEditor:function(F,C){var E=F.editor||v;if(F.editorfunction){var A=window[F.editorfunction];if(A==B){alert(g+F.editorfunction+t);return B}E=A.call(window,C,F.name)||v}return E},positionEditor:function(){var E=this,C=E.currentEditor,A=C.editor,G=Ext.get([E.id,C.name,C.record.id].join(D)),F=G.getXY();if(A instanceof s.CheckBox){A.move(F[0],F[1]-4)}else{A.setHeight(G.getHeight()-2);A.setWidth(G.getWidth()-5<22?22:(G.getWidth()-5));A.move(F[0],F[1])}if(A.isExpanded&&A.isExpanded()){if(Ext.isIE){if(E.t){clearTimeout(E.t)}E.t=(function(){A.syncPopup()}).defer(1)}else{A.syncPopup()}}},hideEditor:function(){var F=this,E=F.currentEditor;if(E){var C=E.editor;if(C){if(!C.canHide||C.canHide()){C.el.un(k,F.onEditorKeyDown,F);C.un(o,F.onEditorSelect,F);Ext.fly(z).un(n,F.onEditorBlur,F);C.move(-10000,-10000);var A=C.autocompleteview;if(A){A.hide()}C.blur();C.onBlur();C.isFireEvent=w;C.isHidden=h;F.editing=w;if(C.collapse){C.collapse()}}}}},showEditor:function(K,A,J){if(K==-1){return}var H=this,E=H.findColByName(A);if(!E){return}var C=H.dataset,F=C.getAt(K);if(!F){return}if(F.id!=H.selectedId){H.selectRow(K)}var I=H.getEditor(E,F);H.setEditor(A,I);if(I!=v){var G=$(I);(function(){var M=F.get(A),O=Ext.get([H.id,A,F.id].join(D)),N=O.getXY(),L;G.bind(C,A);G.render(F);G.el.on(k,H.onEditorKeyDown,H);Ext.fly(z).on(n,H.onEditorBlur,H);L=H.currentEditor={record:F,ov:M,name:A,editor:G};H.positionEditor();if(G instanceof s.CheckBox){if(J){G.focus()}else{G.onClick()}}else{if(G instanceof s.Field&&!G instanceof s.TextArea){G.el.setStyle("text-align",E.align||"left")}else{if(G instanceof s.Lov){G.on("fetching",H.onFetching,H)}}G.isEditor=h;G.isFireEvent=h;G.isHidden=w;G.focus();G.on(o,H.onEditorSelect,H);if(Ext.isFunction(J)){J(G)}H.fireEvent(d,H,G,K,A,F)}H.editing=h}).defer(10)}},onFetching:function(A){var C=this;C.isFetching=h;s.Masker.mask(C.wrap,_lang["grid.mask.fetching"]);A.on("fetched",C.onFetched,C)},onFetched:function(A){var C=this;C.isFetching=w;s.Masker.unmask(C.wrap);A.un("fetched",C.onFetched,C);A.un("fetching",C.onFetching,C)},showEditorByRecord:function(A){var C=this,E=C.dataset,F=A?E.indexOf(A):0;A=A||E.getAt(0);if(!A&&C.autoappend){A=E.create()}if(A){l(C.columns,function(G){if(G.hidden!=h&&C.getEditor(G,A)!=v){C.fireEvent(y,C,F,G.name,A,function(){});C.fireEvent(i,C,F,A);return w}})}},onEditorBlur:function(F,C){var E=this,A=E.currentEditor;if(A&&!A.editor.isEventFromComponent(C)){E.hideEditor.defer(Ext.isIE9?10:0,E)}},onEditorSelect:function(){(function(){this.hideEditor()}).defer(1,this)},onEditorKeyDown:function(G,C){var E=this,F=G.keyCode;ced=E.currentEditor;if(F==27){if(ced){var A=ced.editor;if(A){A.clearInvalid();A.render(A.binder.ds.getCurrentRecord())}}E.hideEditor()}else{if(F==13){if(!(ced&&ced.editor&&ced.editor instanceof s.TextArea)){E.showEditorBy(39)}}else{if(F==9){G.stopEvent();E.showEditorBy(G.shiftKey?37:39)}else{if(G.ctrlKey&&(F==37||F==38||F==39||F==40)){E.showEditorBy(F);G.stopEvent()}}}}},showEditorBy:function(E){var F=this,H=h,C=F.findEditorBy(E);if(C){F.hideEditor();var G=C.row,A=C.record;F.fireEvent(y,F,G,C.name,A,H);F.fireEvent(i,F,G,A)}},findColByName:function(A){var C;if(A){l(this.columns,function(E){if(E.name&&E.name.toLowerCase()===A.toLowerCase()){C=E;return w}})}return C},findEditorBy:function(I){var L=this,C,K;if((C=L.currentEditor)&&(K=C.editor)){var O=L.columns,M=w,H=L.dataset,G=K.binder.name,A=K.record,Q=H.data.indexOf(A),E=B,N=w,J=h,P=w,F;if(Q!=-1){if(I==37||I==38){O=[].concat(O).reverse();J=w}if(I==38||I==40){P=h;F=L.findColByName(G)}while(A){if(!P){l(O,function(R){if(M){if(R.hidden!=h&&L.getEditor(R,A)!=v){E=R.name;return w}}else{if(R.name==G){M=h}}})}if(E){return{row:Q,name:E,record:A}}A=H.getAt(J?++Q:--Q);if(J&&!A&&!N&&L.autoappend){L.hideEditor();H.create();A=H.getAt(Q);N=h}if(P&&A&&L.getEditor(F,A)!=v){E=G}}}}return B},selectRow:function(H,C){var F=this,G=F.dataset,A=G.getAt(H),E=(G.currentPage-1)*G.pagesize+H+1;F.selectedId=A.id;if(C!==w&&E!=B){G.locate.defer(5,G,[E,w])}}});s.GridBox.revision="$Rev$"})($A);