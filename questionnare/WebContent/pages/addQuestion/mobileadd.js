var NoValueData=-77777;function StringBuilder(){this._stringArray=new Array();}StringBuilder.prototype.append=function(a){this._stringArray.push(a);};StringBuilder.prototype.toString=function(a){a=a||"";return this._stringArray.join(a);};StringBuilder.prototype.clear=function(){this._stringArray.length=0;};function isEmpty(a){return trim(a)=="";}function isInt(a){var b=/^-?[0-9]+$/;return b.test(a);}function isPositive(a){var b=/^\+?[1-9][0-9]*$/;return b.test(a);}function toInt(a){return parseInt(trim(a));}function trim(a){if(a&&a.replace){return a.replace(/(^\s*)|(\s*$)/g,"");}else{return a;}}var defaultFileExt=".gif|.png|.jpg|.jpeg|.bmp";function createFreQdataNode(y,u,q){var w;var d;var a="";var l="question§1§";var g="§0§1§§false§false§§§false§§"+y;var m="";if(y=="check"&&q){m="-1";}var j="〒false〒1〒0〒false〒false〒〒false〒〒§〒false〒2〒0〒false〒false〒〒false〒〒";var h="1〒false〒1〒0§2〒false〒2〒0§3〒false〒3〒0§4〒false〒4〒0§5〒false〒5〒0";var A="";var n=false;var p="§§§§200§true§";var i="";switch(y){case"姓名":A="您的姓名：";n=true;i=p;break;case"电话":A="您常用的电话号码：";n=true;i=p;break;case"Email":A="您常用的Email地址：";n=true;i=p;break;case"城市单选":A="请选择城市:";n=true;break;case"省市区":A="请选择省份城市与地区:";n=true;break;case"手机":A="请输入您的手机号码：";n=true;i=p;break;case"数字":A="请输入您的卡号：";n=true;i=p;break;case"日期":A="请选择日期：";n=true;break;case"性别":w="radio§3§您的性别：§0§8§false§false§§true§0000§§性别§§§男〒false〒0〒0§女〒false〒0〒0";break;case"年龄段":w="radio§3§您的年龄段：§0§8§false§false§§true§0000§§年龄段§§§15岁以下〒false〒0〒0§15~20〒false〒0〒0§21~25〒false〒0〒0§26~30〒false〒0〒0§31~40〒false〒0〒0§41~50〒false〒0〒0§51~60〒false〒0〒0§60以上〒false〒0〒0";break;case"省份":w="radio§19§您所在的省份：§0§8§false§false§§true§0000§§省份§§§安徽〒false〒0〒0§北京〒false〒1〒0§重庆〒false〒1〒0§福建〒false〒1〒0§甘肃〒false〒1〒0§广东〒false〒1〒0§广西〒false〒1〒0§贵州〒false〒1〒0§海南〒false〒1〒0§河北〒false〒1〒0§黑龙江〒false〒1〒0§河南〒false〒1〒0§香港〒false〒1〒0§湖北〒false〒1〒0§湖南〒false〒1〒0§江苏〒false〒1〒0§江西〒false〒1〒0§吉林〒false〒1〒0§辽宁〒false〒1〒0§澳门〒false〒1〒0§内蒙古〒false〒1〒0§宁夏〒false〒1〒0§青海〒false〒1〒0§山东〒false〒1〒0§上海〒false〒1〒0§山西〒false〒1〒0§陕西〒false〒1〒0§四川〒false〒1〒0§台湾〒false〒1〒0§天津〒false〒1〒0§新疆〒false〒1〒0§西藏〒false〒1〒0§云南〒false〒1〒0§浙江〒false〒1〒0§海外〒false〒1〒0";break;case"radio":case"radio_down":case"check":case"qingjing":var b=y=="check"?"true,"+m+","+m:"true";if(y=="qingjing"){b="true,1";y="radio";j="情景1〒false〒50〒0§情景2〒false〒50〒0§情景3〒false〒50〒0§情景4〒false〒50〒0";}if(u){j+="§其它〒false〒1〒0〒true〒false〒〒false〒〒";}var z=q||0;w=y+"§1§"+a+"§"+q+"§1§false§false§§"+b+"§§§§§§"+j;break;case"likert":w="radio§1§"+a+"§1§1§true§false§§true§0000§§§§§"+h;break;case"matrix":var x=u||2;var c="";var t="";var v=10;if(x=="202"){v=100;}var f=x<102||x==303;var e=f?"true":"false";if(u-300>0){c="百度\n谷歌\n腾讯搜搜\n网易有道\n搜狐搜狗";}if(x==101){w="matrix§1§请根据您的实际情况选择最符合的项：1-->5表示非常不满意-->非常满意§"+x+"§内向\n悲观〒〒"+c+"§"+e+"§false§§true§"+t+"〒〒0〒"+v+"§§§§§1〒false〒1〒0§2〒false〒2〒0§3〒false〒3〒0§4〒false〒4〒0§5〒false〒5〒0";}else{if(x==102){var k="速度快〒false〒1〒0§准确率高〒false〒2〒0§信息量多〒false〒3〒0§界面更美观〒false〒4〒0";w="matrix§1§请评议下面的搜索引擎：§"+x+"§百度\nGoogle\n搜狗〒〒"+c+"§"+e+"§false§§true§"+t+"〒〒0〒"+v+"§§§§§"+k;}else{w="matrix§1§"+a+"§"+x+"§外观\n性能〒〒"+c+"§"+e+"§false§§true§"+t+"〒〒0〒"+v+"§§§§§"+h;}}break;case"邮寄地址":w="matrix§1§请输入您的联系地址：§201§姓名：\n所在地区：\n街道地址:\n邮政编码:\n手机或固话：〒〒§false§false§§true§15%〒〒0,,,;1,省市区,,,50;2,,,,50;3,数字,,;4,电话,,〒10§§§§§"+h;break;case"question":var o=u||1;var s=q||false;if(s){show_status_tip("如果您需要填写者提交的答案在一个列表中（如会员列表），请勾选“ 要求填写者输入的答案在指定的列表中”复选框，并设置答案列表！");}w="question§1§"+a+"§0§"+o+"§§false§false§§§false§§§"+s+"§§§§§";break;case"slider":w="slider§1§"+a+"§0§true§0§100§不满意§满意§§false§0§";break;case"fileupload":w="fileupload§1§请上传图片：§0§true§200§"+defaultFileExt+"§4096§§false§0§";break;case"page":var r=u||"";w=y+"§1§§§"+r;break;case"cut":var A=u?u:"请在此输入说明文字";w=y+"§"+A+"§";break;}if(n){w=l+A+g+i;}d=set_string_to_dataNode(w);return d;}function getqdata(e){var c=new StringBuilder();var r=false;var a=false;var b=false;var o=false;switch(e._type){case"question":var h=e._relation||"";c.append(e._type+"§"+e._topic+"§"+e._title+"〒"+e._keyword+"〒"+h+"§"+e._tag+"§"+e._height+"§"+e._maxword+"§"+e._requir+"§"+e._norepeat+"§"+e._default+"§"+e._ins+"§"+e._hasjump+"§"+e._anytimejumpto+"§"+e._verify+"§"+e._needOnly+"§"+e._hasList+"§"+e._listId+"§"+e._width+"§"+e._underline+"§"+e._minword);if(e._isCeShi){c.append("§"+e._ceshiValue+"〒"+e._answer+"〒"+e._ceshiDesc);o=true;}break;case"slider":var h=e._relation||"";c.append(e._type+"§"+e._topic+"§"+e._title+"〒"+e._keyword+"〒"+h+"§"+e._tag+"§"+e._requir+"§"+e._minvalue+"§"+e._maxvalue+"§"+e._minvaluetext+"§"+e._maxvaluetext+"§"+e._ins+"§"+e._hasjump+"§"+e._anytimejumpto);break;case"fileupload":var h=e._relation||"";var f=e._ext||defaultFileExt;c.append(e._type+"§"+e._topic+"§"+e._title+"〒"+e._keyword+"〒"+h+"§"+e._tag+"§"+e._requir+"§"+e._width+"§"+f+"§"+e._maxsize+"§"+e._ins+"§"+e._hasjump+"§"+e._anytimejumpto);case"cut":c.append(e._type+"§"+e._title+"§"+e._tag);break;case"page":c.append(e._type+"§"+e._topic+"§"+e._title+"§"+e._tag);var q=e._iszhenbie?"true":"";q=e._istimer?"time":q;c.append("§"+q);c.append("§"+e._mintime);if(e._mintime){r=true;}c.append("§"+e._maxtime);if(e._maxtime){a=true;}break;case"check":case"radio_down":case"radio":case"matrix":var h=e._relation||"";e._tag=isNaN(e._tag)?0:e._tag;var k=e._mainWidth||"";c.append(e._type+"§"+e._topic+"§"+e._title+"〒"+e._keyword+"〒"+h+"〒"+k+"§"+e._tag+"§");if(e._type=="matrix"){if(e._referTopic){e._rowtitle2="";}c.append(e._rowtitle+"〒"+e._rowtitle2+"〒"+e._columntitle);}else{c.append(e._numperrow+"〒"+e._randomChoice);}c.append("§"+e._hasvalue+"§"+e._hasjump+"§"+e._anytimejumpto+"§"+e._requir);if(e._type=="check"||(e._type=="matrix"&&e._tag=="102")){c.append(","+e._lowLimit+","+e._upLimit);}else{if(e._type=="radio"&&e._isQingJing){c.append(",1");}}if(e._type=="matrix"){var i=e._rowwidth;if(e._randomRow){i+=",true";}c.append("§"+i+"〒"+e._rowwidth2);if(e._tag=="202"||e._tag=="301"){c.append("〒"+e._minvalue+"〒"+e._maxvalue);}else{if(e._tag=="102"||e._tag=="103"){var l=e._daoZhi||"";c.append("〒"+l);}else{if(e._tag=="201"){if(e._rowVerify){c.append("〒");var m=trim(e._rowtitle).split("\n");var d=0;for(var n=0;n<m.length;n++){if(m[n].substring(0,4)=="【标签】"){continue;}if(e._rowVerify[d]){var s=e._rowVerify[d];c.append(d+",");c.append(s._verify||"");c.append(",");c.append(s._minword||"");c.append(",");c.append(s._maxword||"");c.append(",");c.append(s._width||"");c.append(";");}d++;}}}}}}else{if(e._isTouPiao){c.append("§"+e._isTouPiao+"〒"+e._touPiaoWidth+"〒"+e._displayTiao+"〒"+e._displayNum+"〒"+e._displayPercent);b=true;}else{if(e._isCeShi){c.append("§ceshi〒"+e._ceshiValue+"〒"+e._ceshiDesc);o=true;}else{if(e._isCePing){c.append("§ceping");}else{c.append("§");}}}}c.append("§"+e._ins+"§"+e._verify);c.append("§"+e._referTopic+"§"+e._referedTopics);for(var p=1;p<e._select.length;p++){var g="";if(e._select[p]._item_huchi){g="〒true";}var t=e._select[p]._item_value;if(e._select[p]._item_value==""){t=NoValueData;}c.append("§"+e._select[p]._item_title+"〒"+e._select[p]._item_radio+"〒"+t+"〒"+e._select[p]._item_jump+"〒"+e._select[p]._item_tb+"〒"+e._select[p]._item_tbr+"〒"+e._select[p]._item_img+"〒"+e._select[p]._item_imgtext+"〒"+e._select[p]._item_desc+"〒"+e._select[p]._item_label+g);}break;}return c.toString("");}function set_string_to_dataNode(n){var d=new Object();var b=new Array();b=n.split("§");d._type=b[0];switch(b[0]){case"page":d._topic=b[1];d._title=b[2];d._tag=b[3];d._iszhenbie=b[4]=="true";d._istimer=b[4]=="time";d._mintime=b[5]?parseInt(b[5]):"";d._maxtime=b[6]?parseInt(b[6]):"";total_page++;break;case"cut":d._title=b[1];d._tag=b[2];break;case"slider":d._topic=b[1];var p=b[2].split("〒");d._title=p[0];d._keyword=p.length==2?p[1]:"";d._relation=p[2]||"";if(b[4]=="true"){d._requir=true;}else{d._requir=false;}d._minvalue=b[5];d._maxvalue=b[6];d._minvaluetext=b[7];d._maxvaluetext=b[8];d._ins=b[9];if(b[10]=="true"){d._hasjump=true;}else{d._hasjump=false;}d._anytimejumpto=b[11];break;case"fileupload":d._topic=b[1];var p=b[2].split("〒");d._title=p[0];d._keyword=p.length==2?p[1]:"";d._relation=p[2]||"";if(b[4]=="true"){d._requir=true;}else{d._requir=false;}d._width=b[5]?parseInt(b[5]):200;d._ext=b[6]||"";d._maxsize=b[7]?parseInt(b[7]):4096;d._ins=b[8];if(b[9]=="true"){d._hasjump=true;}else{d._hasjump=false;}d._anytimejumpto=b[10];break;case"question":d._topic=b[1];var p=b[2].split("〒");d._title=p[0];d._keyword=p.length==2?p[1]:"";d._relation=p[2]||"";d._height=b[4]?parseInt(b[4]):1;d._maxword=b[5];if(b[6]=="true"){d._requir=true;}else{d._requir=false;}if(b[7]=="true"){d._norepeat=true;}else{d._norepeat=false;}d._default=b[8];d._ins=b[9];if(b[10]=="true"){d._hasjump=true;}else{d._hasjump=false;}d._anytimejumpto=b[11];d._verify=b[12];d._needOnly=b[13]=="true"?true:false;d._hasList=b[14]=="true"?true:false;d._listId=b[15]?parseInt(b[15]):-1;d._width=b[16]?parseInt(b[16]):"";d._underline=b[17]=="true"?true:false;d._minword=b[18]?parseInt(b[18]):"";if(b[19]){var e=b[19].split("〒");d._isCeShi=true;d._ceshiValue=e[0]||5;d._answer=e[1]||"请输入标准答案";d._ceshiDesc=e[2]||"";}break;case"radio":case"check":case"radio_down":case"matrix":case"boolean":if(b[0]=="boolean"){d._isbool=true;d._type="radio";}else{d._type=b[0];}d._topic=b[1];var p=b[2].split("〒");d._title=p[0];d._keyword=p.length==2?p[1]:"";d._relation=p[2]||"";d._mainWidth=p[3]||"";d._tag=isInt(b[3])?toInt(b[3]):0;if(d._type=="matrix"){var k=b[4].split("〒");d._rowtitle=k[0];if(k.length>=2){d._rowtitle2=k[1];}else{d._rowtitle2="";}if(k.length==3){d._columntitle=k[2];}else{d._columntitle="";}}else{var r=b[4].split("〒");d._numperrow=isInt(r[0])?toInt(r[0]):1;d._randomChoice=false;if(r.length==2){d._randomChoice=r[1]=="true"?true:false;}}if(b[5]=="true"){d._hasvalue=true;}else{d._hasvalue=false;}if(b[6]=="true"){d._hasjump=true;}else{d._hasjump=false;}d._anytimejumpto=b[7];if(b[0]=="check"||(b[0]=="matrix"&&d._tag=="102")){if(b[8].split(",")[0]=="true"){d._requir=true;}else{d._requir=false;}d._lowLimit=b[8].split(",")[1];d._upLimit=b[8].split(",")[2];}else{if(b[8]=="true"){d._requir=true;}else{if(b[0]=="radio"){var g=b[8].split(",");d._requir=g[0]=="true";if(g[1]){d._isQingJing=true;}}else{d._requir=false;}}}if(d._type=="matrix"){var u=b[9].split("〒");var v=u[0].split(",");d._rowwidth=v[0].indexOf("%")>-1?v[0]:"";d._randomRow=v[1]=="true";d._rowwidth2="";if(u.length>=2){d._rowwidth2=u[1].indexOf("%")>-1?u[1]:"";}d._minvalue=0;d._maxvalue=10;if(d._tag=="202"||d._tag=="301"){d._minvalue=u[2]||"";d._maxvalue=u[3]||"";}else{if(d._tag=="102"||d._tag=="103"){d._daoZhi=u[2]=="true";}else{if(d._tag=="201"){d._hasvalue=false;var h=u[2]||"";d._rowVerify=new Array();if(h){var l=h.split(";");for(var s=0;s<l.length;s++){if(!l[s]){continue;}var t=new Object();var m=l[s].split(",");t._verify=m[1];t._minword=m[2];t._maxword=m[3];t._width=m[4]||"";var c=parseInt(m[0]);d._rowVerify[c]=t;}}}}}d._isTouPiao=false;d._isCeShi=false;}else{var f=b[9].split("〒");if(f[0]=="true"){d._isTouPiao=true;d._touPiaoWidth=isInt(f[1])?parseInt(f[1]):50;d._displayTiao=f[2]=="true";d._displayNum=f[3]=="true";d._displayPercent=f[4]=="true";}else{if(f[0]=="ceshi"){d._isCeShi=true;d._ceshiValue=isInt(f[1])?parseInt(f[1]):5;d._ceshiDesc=f[2];}else{if(f[0]=="ceping"){d._isCePing=true;}}}}d._ins=b[10];d._verify=b[11];d._referTopic=b[12];d._referedTopics=b[13];d._select=new Array();var a=14;for(var o=a;o<b.length;o++){var q=new Array();q=b[o].split("〒");var i=o-a+1;d._select[i]=new Object();d._select[i]._item_title=q[0];if(q[1]=="true"){d._select[i]._item_radio=true;}else{d._select[i]._item_radio=false;}d._select[i]._item_value=q[2];d._select[i]._item_jump=q[3];d._select[i]._item_tb=false;d._select[i]._item_tbr=false;d._select[i]._item_img="";d._select[i]._item_imgtext=false;d._select[i]._item_desc="";d._select[i]._item_label="";if(q.length>=9){d._select[i]._item_tb=q[4]=="true";d._select[i]._item_tbr=q[5]=="true";d._select[i]._item_img=q[6];d._select[i]._item_imgtext=q[7]=="true";d._select[i]._item_desc=q[8];d._select[i]._item_label=q[9];d._select[i]._item_huchi=q[10]=="true";}}break;default:break;}return d;}$(function(){if(isEdit){var d=$("#questiondata").val();dataNode=set_string_to_dataNode(d);$("#question_title").val(dataNode._title);if(dataNode._isTouPiao){isTouPiao=1;}else{if(dataNode._isCeShi){isKaoShi=1;}}}else{if(qtype=="sort"){dataNode=createFreQdataNode("check","","1");}else{dataNode=createFreQdataNode(qtype);}qtype=dataNode._type;var c=dataNode._title;if(c=="请在此输入问题标题"){c="";}$("#question_title").val(c);if(isTouPiao){dataNode._isTouPiao=true;dataNode._displayNum=true;}else{if(isKaoShi){dataNode._isCeShi=true;dataNode._ceshiValue=5;dataNode._ceshiDesc="";dataNode._answer="";}}}isRadioCheck=(dataNode._type=="radio"&&!dataNode._tag)||(dataNode._type=="check");if(isRadioCheck&&editMode){prevSelCount=dataNode._select.length-1;}if(dataNode._type=="check"&&dataNode._tag){$(".SelectType").hide();}var b=$("#spanQtype");var a="单选题";if(dataNode._type=="radio"&&dataNode._tag){a="评分题";}else{if(dataNode._type=="check"){if(dataNode._tag){a="排序题";}else{a="多选题";}}else{if(dataNode._type=="question"){a="填空题";}}}if(isTouPiao){a="投票"+a.replace("题","");$("#divtoupiaotip").show();}else{if(isKaoShi){a="考试"+a.replace("题","");$("#divTipChoice").html("答案");}}b.html(a);});function goback(){history.go(-1);}function validate(){if(isRadioCheck){var b=true;var e=false;var a=0;var f=new Object();$("#option_list .input input").each(function(){var g=$.trim($(this).val());if(g!==""){a+=1;if(f[g]){e=true;}else{f[g]="1";}}});if(isKaoShi){var d=$("#option_list .jqchecked").length>0;if(!d){loadMack({off:"on",Limg:0,text:"考试题型必须设置正确答案！",set:1500});return false;}}if(e){loadMack({off:"on",Limg:0,text:"选项名称不能重复！",set:1500});return false;}if(a<2){b=false;}if(!b){loadMack({off:"on",Limg:0,text:"请至少输入两个选项的内容",set:1500});return false;}else{if(editMode&&a<prevSelCount){loadMack({off:"on",Limg:0,text:"此问卷已经有答卷，只能增加选项，不能删除选项！",set:1500});return false;}}}if($("#question_title").val()===""){loadMack({off:"on",Limg:0,text:"请输入题目名称",set:1500});return false;}dataNode._title=$("#question_title").val();var c=getqdata(dataNode);$("#questiondata").val(c);needCheckLeave=false;$("#qform").submit();}jQuery(document).ready(function(a){bind_event();if(dataNode._requir){a(".requir").addClass("on");}else{a(".requir").addClass("off");}stop_tap_mack();});function initNewOpiton(){var a=new Object();a._item_title="";a._item_value="";a._item_radio=false;a._item_jump="";a._item_tb=false;a._item_tbr=false;a._item_img="";a._item_imgtext="";a._item_desc="";a._item_label="";return a;}function bind_event(){$(".requir").bind("click",function(){var a=$(this).is(".on");if(a){$(this).removeClass("on").addClass("off");dataNode._requir=false;}else{$(this).removeClass("off").addClass("on");dataNode._requir=true;}});$(".add_question").bind("click",function(){var b=$("#option_list");var g=b.find(".sel_items").length;var f="item"+(g+1);var a='<label class="box"><input type="checkbox" class="cb" id="'+f+'"><a class="jqcheck" href="javascript:;"></a></label>';var d='<div class="sel_items"><div>'+a+'<div class="input"><input placeholder="选项名称" value=""/></div><div class="addImg"><input type="file" class="fileupload" /></div></div></div>';var e=$(d).appendTo("#option_list",b);e.find(".input input").focus();$("#option_list .input input").bind("blur",function(){isInputVal($(this));});var c=initNewOpiton();dataNode._select.push(c);BindUploadEvent();BindDefaultEvent();BindEnterEvent();setInputWidth();return false;});}function isInputVal(h,g){var e=$("#option_list");var b=h.parent().parent().parent();var d=e.find(".sel_items");var c=d.index(b);var f=dataNode._select[c+1];if(g==2){f._item_img=h[0].imgname;f._item_imgtext=h[0].imgname?true:false;}else{if(g==3){if(dataNode._type=="check"){f._item_radio=h.hasClass("jqchecked");}else{if(h.hasClass("jqchecked")){e.find(".jqcheck").each(function(j){if(this!=h[0]){dataNode._select[j+1]._item_radio=false;$(this).removeClass("jqchecked");}});f._item_radio=true;}else{f._item_radio=false;}}}else{var a=h.val();f._item_title=a;if(isRadioCheck){refresh_select_limit();}}}}function stop_tap_mack(){$("body").append('<div class="stop_tap_mack" style="width:100%;height:100%;position:fixed;top:0px;left:0px;z-index:9999;background-color:#fff;opacity:0;"></div>');setTimeout(function(){$(".stop_tap_mack").remove();},800);$(".stop_tap_mack").bind("click",function(){return false;});}function loadMack(c){if(c.off=="off"){$(".loadMack,.loadCon").fadeOut("800",function(){$(this).remove();});return;}var d=document.documentElement.clientWidth||document.body.clientWidth;var b=document.documentElement.clientHeight||document.body.clientHeight;var a=$("body").height();if(c.set==undefined){c.set=0;}if(c.Mack==undefined){c.Mack='<div class="loadMack" style="width:'+d+"px;height:"+b+'px;"></div>';}else{c.Mack="";}$("body").append(""+c.Mack+'<div style="left:0px;top:0px;" class="loadCon"><p style="text-align:center;font-size:14px;">'+c.text+"</p></div>");if(c.set!==0){setTimeout(function(){$(".loadMack,.loadCon").fadeOut("800",function(){$(this).remove();return;});},c.set);}loadwidth=$(".loadCon").width();$(".loadCon").css({left:($(document).width()-loadwidth)/2-20,top:150});}